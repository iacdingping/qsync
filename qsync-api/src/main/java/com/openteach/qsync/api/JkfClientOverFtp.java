package com.openteach.qsync.api;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPConnectionClosedException;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.parser.ParserInitializationException;
import org.apache.commons.net.io.CopyStreamException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

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
	
	private static String PREFIX = "12345";
	
	private AtomicLong sequence;
	
	private ConcurrentHashMap<String, PendingRequest> pendingRequests;
	
	private int bufferSize = DEFAULT_BUFFER_SIZE;
	
	/**
	 * 
	 */
	private BlockingQueue<PendingRequest> buffer;
	
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
				PREFIX = address.hashCode() + "";
			} catch (UnknownHostException e) {
				// XXX 还是失败了好, 后面很多都依赖这两个值
				throw new RuntimeException("Can not get host_name and host ip", e);
			}
			sequence = new AtomicLong(0);
			pendingRequests = new ConcurrentHashMap<String, PendingRequest>();
			
			initializePushers();
			initializePullers();
			
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
		buffer.clear();
		pendingRequests.clear();
	}
	
	@Override
	public XmlResponse sync(XmlRequest request) throws ApiException {
		PendingRequest pr = this.pendingRequest(request, null, null);
		// 同步等待
		synchronized(pr) {
			//
			try {
				pr.wait();
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				throw new ApiException(e);
			}
		}
		return pr.response;
	}

	@Override
	public void async(XmlRequest request, Callback callback) {
		async(request, callback, null);
	}
	
	@Override
	public void async(XmlRequest request, Callback callback, Object context) {
		try {
			this.pendingRequest(request, callback, context);
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
	 * @param ip
	 * @param port
	 * @param username
	 * @param password
	 * @return
	 * @throws IOException
	 */
	private FTPClient initializeFtpClient(String ip, int port, String username, String password) throws IOException {
		FTPClient ftp = new FTPClient();
		ftp.connect(ip, port);
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
	private PendingRequest pendingRequest(XmlRequest request, Callback callback, Object context) throws ApiException {
				
		String sequence = generateSequence();
		String requestFileName = generateRequestFileName(sequence);
		String responseFileName = generateReponseFileName(sequence);
		PendingRequest pr = new PendingRequest(request, sequence, requestFileName, responseFileName, callback, context);
		
		try {
			buffer.put(pr);
			return pr;
		} catch (InterruptedException e) {
			// 清理
			buffer.remove(pr);
			pendingRequests.remove(pr.responseFileName);
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
		return PREFIX + "_" + sequence.getAndIncrement();
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
	 * @param sequence
	 * @return
	 */
	private String generateReponseFileName(String sequence) {
		return "receipt_" + sequence + ".xml";
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
								pendingRequests.put(pr.responseFileName, pr);
							} else {
								// 存储失败
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
					while(!Thread.currentThread().isInterrupted()) {
						try {
							FTPFile[] files = ftp.listFiles();
							for(FTPFile f : files) {
								if(null == f || null == f.getName()) {
									continue;
								}
								PendingRequest pr = pendingRequests.remove(f.getName());
								if(null == pr) {
									// 另外一个线程在处理
									continue;
								}
								String xml = getAndDeleteFile(f.getName());
								pr.response = JaxbUtils.converyToJavaBean(xml, XmlResponse.class);
								pr.completed();
							}
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
				ftp.retrieveFile(fileName, bo);
				ftp.deleteFile(fileName);
				return bo.toString();
			} finally {
				if(null != bo) {
					bo.close();
				}
			}
		}
	}
	
	/**
	 * 
	 * @author sihai
	 *
	 */
	private class PendingRequest {
		XmlRequest request;
		String sequence;
		String requestFileName;
		String responseFileName;
		
		XmlResponse response;
		
		private Callback callback;
		private Object context;
		
		/**
		 * 
		 * @param request
		 * @param sequence
		 * @param requestFileName
		 * @param responseFileName
		 */
		public PendingRequest(XmlRequest request, String sequence, String requestFileName, String responseFileName) {
			this(request, sequence, requestFileName, responseFileName, null, null);
		}
		
		/**
		 * 
		 * @param request
		 * @param sequence
		 * @param requestFileName
		 * @param responseFileName
		 * @param callback
		 * @param context
		 */
		public PendingRequest(XmlRequest request, String sequence, String requestFileName, String responseFileName, Callback callback, Object context) {
			this.request = request;
			this.sequence = sequence;
			this.requestFileName = requestFileName;
			this.responseFileName = responseFileName;
			this.callback = callback;
			this.context = context;
		}
		
		/**
		 * 
		 * @return
		 */
		public InputStream getInputStream() {
			return new ByteArrayInputStream(request.toXml().getBytes());
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
		private synchronized void notifyCompleted() {
			this.notifyAll();
		}
	}
}
