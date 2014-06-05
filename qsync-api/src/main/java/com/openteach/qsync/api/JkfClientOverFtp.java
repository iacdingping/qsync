package com.openteach.qsync.api;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Iterator;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPConnectionClosedException;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;
import org.apache.commons.net.ftp.parser.ParserInitializationException;
import org.apache.commons.net.io.CopyStreamException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.openteach.qcity.qsync.common.lifecycle.NamedThreadFactory;
import com.openteach.qsync.api.exception.ApiException;
import com.openteach.qsync.api.utils.JaxbUtils;

/**
 * Over ftp
 * @author sihai
 *
 */
@Service
public class JkfClientOverFtp implements JkfClient {
	
	public static final int DEFAULT_COUNT = 4;
	
	public static final int DEFAULT_BUFFER_SIZE = 1024;
	
	public static final int DEFAULT_TIMEOUT = 1800;
	
	private static final String SUFFIX = "PT14050401";
	
	private static final Log logger = LogFactory.getLog(JkfClientOverFtp.class);

	@Value("${sync.customs.pusher.ftp.server}")
	private String pusherFtpServer;
	
	@Value("${sync.customs.pusher.ftp.port}")
	private int pusherFtpPort;
	
	@Value("${sync.customs.pusher.ftp.username}")
	private String pusherFtpUsername;
	
	@Value("${sync.customs.pusher.ftp.password}")
	private String pusherFtpPassword;
	
	@Value("${sync.customs.puller.ftp.server}")
	private String pullerFtpServer;
	
	@Value("${sync.customs.puller.ftp.port}")
	private int pullerFtpPort;
	
	@Value("${sync.customs.puller.ftp.username}")
	private String pullerFtpUsername;
	
	@Value("${sync.customs.puller.ftp.password}")
	private String pullerFtpPassword;
	
	/**
	 * 
	 */
	@Value("${sync.customs.pusher.count}")
	private int pusherCount = DEFAULT_COUNT;
	
	/**
	 * 
	 */
	@Value("${sync.customs.puller.count}")
	private int pullerCount = DEFAULT_COUNT;
	
	private Pusher[] pushers;
	
	private Puller[] pullers;
	
	private static String PREFIX = "JKF";
	
	private AtomicLong sequence;
	
	private ConcurrentHashMap<String, PendingRequest> pendingRequests;
	
	private int bufferSize = DEFAULT_BUFFER_SIZE;
	
	/**
	 * 
	 */
	private BlockingQueue<PendingRequest> buffer;
	
	/**
	 * 看门狗
	 */
	private ScheduledExecutorService scheduledExecutorService;
	
	/**
	 * 
	 */
	@Value("${sync.customs.timeout}")
	private long timeout = DEFAULT_TIMEOUT;
	
	/**
	 * 
	 */
	@PostConstruct
	public void initialize() {
		try {
			// 
			buffer = new ArrayBlockingQueue<PendingRequest>(bufferSize);
			
			try {
				InetAddress address = InetAddress.getLocalHost();
				PREFIX = String.valueOf(address.hashCode() + System.currentTimeMillis());
			} catch (UnknownHostException e) {
				// XXX 还是失败了好, 后面很多都依赖这两个值
				throw new RuntimeException("Can not get host_name and host ip", e);
			}
			sequence = new AtomicLong(System.currentTimeMillis());
			pendingRequests = new ConcurrentHashMap<String, PendingRequest>();
			
			initializePushers();
			initializePullers();
			initializeWatchdog();
		} catch (IOException e) {
			throw new IllegalArgumentException("Can not connect ftp server", e);
		}
	}
	
	/**
	 * 
	 */
	@PreDestroy
	public void release() {
		// TODO 优雅的停下来
		releasePushers();
		releasePullers();
		shutdownWatchdog();
		buffer.clear();
		pendingRequests.clear();
	}
	
	@Override
	public XmlResponse sync(XmlRequest request, String responseKey, Class<? extends XmlResponse> responseClass) throws ApiException {
		PendingRequest pr = this.pendingRequest(request, null, null, responseKey, responseClass);
		// 同步等待
		synchronized(pr) {
			//
			try {
				pr.wait(1000 * timeout);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				throw new ApiException(e);
			}
		}
		if(null == pr.response) {
			throw new ApiException("Timeout");
		}
		return pr.response;
	}

	@Override
	public void async(XmlRequest request, Callback callback, String responseKey, Class<? extends XmlResponse> responseClass) {
		async(request, callback, null, responseClass);
	}
	
	@Override
	public void async(XmlRequest request, Callback callback, Object context, String responseKey, Class<? extends XmlResponse> responseClass) {
		try {
			this.pendingRequest(request, callback, context, responseKey, responseClass);
		} catch (ApiException e) {
			callback.onFailed(e, context);
		}
	}
	
	public void setBufferSize(int bufferSize) {
		this.bufferSize = bufferSize;
	}
	
	public void setPusherFtpServer(String pusherFtpServer) {
		this.pusherFtpServer = pusherFtpServer;
	}

	public void setPusherFtpPort(int pusherFtpPort) {
		this.pusherFtpPort = pusherFtpPort;
	}

	public void setPusherFtpUsername(String pusherFtpUsername) {
		this.pusherFtpUsername = pusherFtpUsername;
	}

	public void setPusherFtpPassword(String pusherFtpPassword) {
		this.pusherFtpPassword = pusherFtpPassword;
	}

	public void setPullerFtpServer(String pullerFtpServer) {
		this.pullerFtpServer = pullerFtpServer;
	}

	public void setPullerFtpPort(int pullerFtpPort) {
		this.pullerFtpPort = pullerFtpPort;
	}

	public void setPullerFtpUsername(String pullerFtpUsername) {
		this.pullerFtpUsername = pullerFtpUsername;
	}

	public void setPullerFtpPassword(String pullerFtpPassword) {
		this.pullerFtpPassword = pullerFtpPassword;
	}

	public void setPusherCount(int pusherCount) {
		this.pusherCount = pusherCount;
	}

	public void setPullerCount(int pullerCount) {
		this.pullerCount = pullerCount;
	}
	
	/**
	 * 
	 * @throws IOException
	 */
	private void initializePushers() throws IOException {
		pushers = new Pusher[pusherCount];
		for(int i = 0; i < pusherCount; i++) {
			pushers[i] = new Pusher(i, pullerFtpServer, pusherFtpPort, pusherFtpUsername, pusherFtpPassword);
			pushers[i].start();
		}
	}
	
	/**
	 * 
	 * @throws IOException
	 */
	private void initializePullers() throws IOException {
		pullers = new Puller[pullerCount];
		for(int i = 0; i < pullerCount; i++) {
			pullers[i] = new Puller(i, pullerFtpServer, pullerFtpPort, pullerFtpUsername, pullerFtpPassword);
			pullers[i].start();
		}
	}
	
	/**
	 * 
	 */
	private void initializeWatchdog() {
		scheduledExecutorService = Executors.newSingleThreadScheduledExecutor(new NamedThreadFactory("mtop-trace-timer"));
		scheduledExecutorService.scheduleAtFixedRate(new Runnable() {

			@Override
			public void run() {
				String key = null;
				for(Iterator<String> it = pendingRequests.keySet().iterator(); it.hasNext();) {
					key = it.next();
					PendingRequest pr = pendingRequests.get(key);
					if(null != pr && System.currentTimeMillis() - pr.commitedTimestamp > timeout) {
						pendingRequests.remove(key);
						pr.failed(new ApiException("Timeout"));
					}
				}
			}
			
		}, timeout, timeout, TimeUnit.SECONDS);
	}
	
	/**
	 * 
	 */
	private void releasePushers() {
		if(null != pushers) {
			for(Pusher r : pushers) {
				r.stop();
			}
		}
	}
	
	/**
	 * 
	 */
	private void releasePullers() {
		if(null != pullers) {
			for(Puller r : pullers) {
				r.stop();
			}
		}
	}
	
	/**
	 * 
	 */
	private void shutdownWatchdog() {
		if(null != scheduledExecutorService) {
			scheduledExecutorService.shutdown();
		}
	}
	
	/**
	 * 
	 * @param ip
	 * @param port
	 * @param username
	 * @param password
	 * @return
	 * @throws IOException
	 */
	private FTPClient initializeFtpClient(String ip, int port, String username, String password) throws IOException {
		FTPClient ftp = new FTPClient();
		ftp.setListHiddenFiles(true);
		ftp.connect(ip, port);
		if(!FTPReply.isPositiveCompletion(ftp.getReplyCode())) {
            ftp.disconnect();
            throw new IllegalArgumentException(String.format("Can not login ftp by username: %s, password: %s, FTP server refused connection", username, password));
        }
		if(!ftp.login(username, password)) {
			throw new IllegalArgumentException(String.format("Can not login ftp by username: %s, password: %s", username, password));
		}
		ftp.enterLocalPassiveMode();
		ftp.setFileType(FTP.BINARY_FILE_TYPE);
		return ftp;
	}
	
	/**
	 * 
	 * @param request
	 * @param callback
	 * @param context
	 * @return
	 * @throws ApiException
	 */
	private PendingRequest pendingRequest(XmlRequest request, Callback callback, Object context, String responseKey, Class<? extends XmlResponse> responseClass) throws ApiException {
				
		String sequence = generateSequence();
		String requestFileName = generateRequestFileName(sequence);
		PendingRequest pr = new PendingRequest(request, requestFileName, responseKey,  responseClass, callback, context);
		
		try {
			buffer.put(pr);
			return pr;
		} catch (InterruptedException e) {
			// 清理
			buffer.remove(pr);
			pendingRequests.remove(pr.responseKey);
			// 
			Thread.currentThread().interrupt();
			throw new ApiException(e);
		}
	}
	
	/**
	 * 
	 * @return
	 */
	private String generateSequence() {
		return String.valueOf(sequence.getAndIncrement());
	}
	
	/**
	 * 
	 * @param sequence
	 * @return
	 */
	private String generateRequestFileName(String sequence) {
		return PREFIX + "_" + sequence + "_" + SUFFIX + ".xml";
	}
	
	/**
	 * 
	 * @author sihai
	 *
	 */
	private class Pusher {
		
		private int no;
		
		private String ip;
		private int port;
		private String username;
		private String password;
		
		private FTPClient ftp;
		
		private Thread thread;
		
		public Pusher(int no, String ip, int port, String username, String password) {
			this.no = no;
			this.ip = ip;
			this.port = port;
			this.username = username;
			this.password = password;
			// 快速失败
			initializeFtp();
		}
		
		public void start() {
			thread = new Thread(new Runnable() {

				@Override
				public void run() {
					while(!Thread.currentThread().isInterrupted()) {
						InputStream stream = null;
						try {
							PendingRequest pr = buffer.take();
							stream = pr.getInputStream();
						_retry:
							if(ftp.storeFile(pr.requestFileName, stream)) {
								logger.info("stored file to ftp server:" + pr.requestFileName);
								pendingRequests.put(pr.responseKey, pr);
								// 
								pr.commitedTimestamp = System.currentTimeMillis();
							} else {
								// TODO 存储失败
								pr.failed(new ApiException("Store file to ftp failed"));
							}
						} catch (InterruptedException e) {
							logger.error("Thread interrupted", e);
							Thread.currentThread().interrupt();
						} catch (FTPConnectionClosedException e) {
							// 重新初始化ftp呗
							reInitializeFtp();
							//goto _retry;
						} catch (CopyStreamException e) {
							// 不可能的
						} catch (IOException e) {
							// 重新初始化ftp呗
							reInitializeFtp();
							//goto _retry;
						} catch (Throwable t) {
							logger.error("Exception", t);
						} finally {
							if(null != stream) {
								try {
									stream.close();
								} catch (IOException e) {
								}
							}
						}
					}
				}
				
			}, "Requester-" + no);
			//
			thread.start();
		}
		
		public void stop() {
			// TODO 优雅停止
			thread.interrupt();
			try {
				ftp.logout();
			} catch (IOException e) {
				logger.error("logout failed", e);
			}
			try {
				ftp.disconnect();
			} catch (IOException e) {
				logger.error("disconnect failed", e);
			}
		}
		
		private void initializeFtp() {
			try {
				ftp = initializeFtpClient(ip, port, username, password);
			} catch (IOException e) {
				throw new IllegalArgumentException(String.format("Wrong ftp config: {ip: %s, port: %d, username: %s, password: %s}", ip, port, username, password), e);
			}
		}
		
		private void reInitializeFtp() {
			releaseFtp();
			initializeFtp();
		}
		
		private void releaseFtp() {
			try {
				ftp.logout();
			} catch (IOException e) {
				
			}
			try {
				ftp.disconnect();
			} catch (IOException e) {
				
			}
		}
	}
	
	/**
	 * 
	 * @author sihai
	 *
	 */
	private class Puller {
		
		private int no;
		
		private String ip;
		private int port;
		private String username;
		private String password;
		
		private FTPClient ftp;
		
		private Thread thread;
		
		public Puller(int no, String ip, int port, String username, String password) {
			this.no = no;
			this.ip = ip;
			this.port = port;
			this.username = username;
			this.password = password;
			// 快速失败
			initializeFtp();
		}
		
		public void start() {
			thread = new Thread(new Runnable() {

				@Override
				public void run() {
					String key = null;
					PendingRequest pr = null;
					String xml = null;
					while(!Thread.currentThread().isInterrupted()) {
						try {
							FTPFile[] files = ftp.listFiles();
							for(FTPFile f : files) {
								if(null == f || null == f.getName() || f.isDirectory()) {
									continue;
								}
							
								xml = getAndDeleteFile(f.getName());
								if(null == xml) {
									logger.error("Get content of file:" + f.getName() + " from ftp failed");
									continue;
								}
								
								key = getKey(xml);
								if(null == key) {
									logger.error("Content of file:" + f.getName() + " wrong, not contains businessNo element");
								}
								pr = pendingRequests.get(key);
								
								pr.response = JaxbUtils.converyToJavaBean(xml, pr.responseClass);
								pr.response.setFileName(key);
								pr.completed();
							}
							/*
							for(Iterator<String> it = pendingRequests.keySet().iterator(); it.hasNext();) {
								key = it.next();
								pr = pendingRequests.get(key);
								if(null == pr) {
									continue;
								}
								if(pr.tryLock()) {
									xml = getFile(key);
									if(null == xml) {
										// 还没审批
										continue;
									}
									// remove
									pendingRequests.remove(key);
									pr.response = JaxbUtils.converyToJavaBean(xml, pr.responseClass);
									pr.response.setFileName(key);
									pr.completed();
								}
							}
							*/
						} catch (FTPConnectionClosedException e) {
							// 重新初始化ftp呗
							reInitializeFtp();
							//goto _retry;
						} catch (ParserInitializationException e) {
							reInitializeFtp();
							//goto _retry;
						} catch (IOException e) {
							// 重新初始化ftp呗
							reInitializeFtp();
							//goto _retry;
						} catch (Throwable t) {
							logger.error("Exception", t);
						}
					}
				}
				
			}, "Responser-" + no);
			//
			thread.start();
		}
		
		public void stop() {
			// TODO 优雅停止
			thread.interrupt();
			try {
				ftp.logout();
			} catch (IOException e) {
				logger.error("logout failed", e);
			}
			try {
				ftp.disconnect();
			} catch (IOException e) {
				logger.error("disconnect failed", e);
			}
		}
		
		private void initializeFtp() {
			try {
				ftp = initializeFtpClient(ip, port, username, password);
			} catch (IOException e) {
				throw new IllegalArgumentException(String.format("Wrong ftp config: {ip: %s, port: %d, username: %s, password: %s}", ip, port, username, password), e);
			}
		}
		
		private void reInitializeFtp() {
			releaseFtp();
			initializeFtp();
		}
		
		private void releaseFtp() {
			try {
				ftp.logout();
			} catch (IOException e) {
				
			}
			try {
				ftp.disconnect();
			} catch (IOException e) {
				
			}
		}
		
		private String getAndDeleteFile(String fileName) throws IOException {
			ByteArrayOutputStream bo = null;
			try {
				bo = new ByteArrayOutputStream();
				if(ftp.retrieveFile(fileName, bo)) {
					try {
						ftp.deleteFile(fileName);
					} catch (FTPConnectionClosedException e) {
						//
					}
					return bo.toString("gbk");
				} else {
					return null;
				}
			} finally {
				if(null != bo) {
					bo.close();
				}
			}
		}
	}
	
	/**
	 * 
	 * @param xml
	 * @return
	 */
	private static String getKey(String xml) {
		Document doc = Jsoup.parse(xml, "", Parser.xmlParser());
		Elements es = doc.select("businessNo");
		if(es.isEmpty()) {
			throw new IllegalArgumentException("Wrong response : " + xml);
		} else if(es.size() == 1) {
			return StringUtils.trim(es.get(0).text());
		} else {
			throw new IllegalArgumentException("Wrong response, multi businessNo : " + xml);
		}
	}
	
	/**
	 * 
	 * @author sihai
	 *
	 */
	private class PendingRequest {
		XmlRequest request;
		String requestFileName;
		String responseKey;
		
		Class<? extends XmlResponse> responseClass;
		
		XmlResponse response;
		
		Callback callback;
		Object context;
		
		long commitedTimestamp;
		
		/**
		 * 
		 * @param request
		 * @param requestFileName
		 * @param responseFileNameKey
		 * @param responseKey
		 * @parma responseClass
		 */
		public PendingRequest(XmlRequest request, String requestFileName, String responseKey, Class<? extends XmlResponse> responseClass) {
			this(request, requestFileName, responseKey, responseClass, null, null);
		}
		
		/**
		 * 
		 * @param request
		 * @param requestFileName
		 * @param responseKey
		 * @param responseClass
		 * @param callback
		 * @param context
		 */
		public PendingRequest(XmlRequest request, String requestFileName, String responseKey, Class<? extends XmlResponse> responseClass, Callback callback, Object context) {
			this.request = request;
			this.requestFileName = requestFileName;
			this.responseKey = responseKey;
			this.responseClass = responseClass;
			this.callback = callback;
			this.context = context;
			this.commitedTimestamp = System.currentTimeMillis();
		}
		
		/**
		 * 
		 * @return
		 * @throws UnsupportedEncodingException 
		 */
		public InputStream getInputStream() throws UnsupportedEncodingException {
			return new ByteArrayInputStream(request.toXml().getBytes("UTF-8"));
		}
		
		/**
		 * 
		 */
		public void completed() {
			if(null != callback) {
				// async
				callback.onSucceed(response, context);
			} else {
				notifyCompleted();
			}
		}
		
		/**
		 * 
		 */
		public void failed(ApiException e) {
			if(null != callback) {
				// async
				callback.onFailed(e, context);
			} else {
				notifyCompleted();
			}
		}
		
		/**
		 * 
		 */
		private synchronized void notifyCompleted() {
			this.notifyAll();
		}
	}
	
	public static void main(String[] args) {
		BufferedReader reader = null;
		try {
			StringBuilder sb = new StringBuilder();
			String line = null;
			reader = new BufferedReader(new FileReader("d:\\receipt_5103782061297550.xml"));
			
			while(null != (line = reader.readLine())) {
				sb.append(line);
			}
			
			System.out.println(sb.toString());
			
			System.out.println();
			
			System.out.println(getKey(sb.toString()));
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(null != reader) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
