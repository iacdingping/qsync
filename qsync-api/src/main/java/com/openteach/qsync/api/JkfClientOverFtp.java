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

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPConnectionClosedException;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.parser.ParserInitializationException;
import org.apache.commons.net.io.CopyStreamException;

import com.openteach.qsync.api.exception.ApiException;
import com.openteach.qsync.api.utils.JaxbUtils;

/**
 * Over ftp
 * @author sihai
 *
 */
public class JkfClientOverFtp implements JkfClient {
	
	public static final int DEFAULT_COUNT = 4;
	
	public static final int DEFAULT_BUFFER_SIZE = 1024;
	
	private static final String SUFFIX = "PT14050401";
	
	private static final Log logger = LogFactory.getLog(JkfClientOverFtp.class);

	private String requestIp;
	
	private int requestPort;
	
	private String requestUsername;
	
	private String requestPassword;
	
	private String responseIp;
	
	private int responsePort;
	
	private String responseUsername;
	
	private String responsePassword;
	
	/**
	 * 
	 */
	private int requesterCount = DEFAULT_COUNT;
	
	/**
	 * 
	 */
	private int responserCount = DEFAULT_COUNT;
	
	private Requester[] requesters;
	
	private Responser[] responsers;
	
	private static String PREFIX;
	
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
	public void initialize() {
		try {
			// 
			buffer = new ArrayBlockingQueue<PendingRequest>(bufferSize);
			
			initializeRequesters();
			initializeResponsers();
			
			try {
				InetAddress address = InetAddress.getLocalHost();
				PREFIX = address.hashCode() + "";
			} catch (UnknownHostException e) {
				// XXX 还是失败了好, 后面很多都依赖这两个值
				throw new RuntimeException("Can not get host_name and host ip", e);
			}
			sequence = new AtomicLong(0);
			pendingRequests = new ConcurrentHashMap<String, PendingRequest>();
		} catch (IOException e) {
			throw new IllegalArgumentException("Can not connect ftp server", e);
		}
	}
	
	/**
	 * 
	 */
	public void release() {
		// TODO 优雅的停下来
		releaseRequesters();
		releaseResponsers();
		buffer.clear();
		pendingRequests.clear();
	}
	
	@Override
	public XmlResponse syncRequest(XmlRequest request) throws ApiException {
		PendingRequest pr = null;
		try {
			pr = pendingRequest(request, null);
		} catch (InterruptedException e) {
			// 清理
			buffer.remove(pr);
			pendingRequests.remove(pr.responseFileName);
			// 
			Thread.currentThread().interrupt();
			throw new ApiException(e);
		}
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
	public void asyncRequest(XmlRequest request, Callback callback) {
		
	}

	public void setRequestIp(String requestIp) {
		this.requestIp = requestIp;
	}

	public void setRequestPort(int requestPort) {
		this.requestPort = requestPort;
	}

	public void setRequestUsername(String requestUsername) {
		this.requestUsername = requestUsername;
	}

	public void setRequestPassword(String requestPassword) {
		this.requestPassword = requestPassword;
	}

	public void setResponseIp(String responseIp) {
		this.responseIp = responseIp;
	}

	public void setResponsePort(int responsePort) {
		this.responsePort = responsePort;
	}

	public void setResponseUsername(String responseUsername) {
		this.responseUsername = responseUsername;
	}

	public void setResponsePassword(String responsePassword) {
		this.responsePassword = responsePassword;
	}
	
	public void setResponserCount(int responserCount) {
		this.responserCount = responserCount;
	}

	public void setRequesterCount(int requesterCount) {
		this.requesterCount = requesterCount;
	}
	
	public void setBufferSize(int bufferSize) {
		this.bufferSize = bufferSize;
	}
	
	/**
	 * 
	 * @throws IOException
	 */
	private void initializeRequesters() throws IOException {
		requesters = new Requester[requesterCount];
		for(int i = 0; i < requesterCount; i++) {
			requesters[i] = new Requester(i, requestIp, requestPort, requestUsername, requestPassword);
			requesters[i].start();
		}
	}
	
	/**
	 * 
	 * @throws IOException
	 */
	private void initializeResponsers() throws IOException {
		responsers = new Responser[responserCount];
		for(int i = 0; i < responserCount; i++) {
			responsers[i] = new Responser(i, responseIp, responsePort, responseUsername, responsePassword);
			responsers[i].start();
		}
	}
	
	/**
	 * 
	 */
	private void releaseRequesters() {
		if(null != requesters) {
			for(Requester r : requesters) {
				r.stop();
			}
		}
	}
	
	/**
	 * 
	 */
	private void releaseResponsers() {
		if(null != responsers) {
			for(Responser r : responsers) {
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
	 * @return
	 */
	private PendingRequest pendingRequest(XmlRequest request, Callback callback) throws InterruptedException {
		String sequence = generateSequence();
		String requestFileName = generateRequestFileName(sequence);
		String responseFileName = generateReponseFileName(sequence);
		PendingRequest pr = new PendingRequest(request, sequence, requestFileName, responseFileName);
		buffer.put(pr);
		return pr;
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
	private class Requester {
		
		private int no;
		
		private String ip;
		private int port;
		private String username;
		private String password;
		
		private FTPClient ftp;
		
		private Thread thread;
		
		public Requester(int no, String ip, int port, String username, String password) {
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
							logger.error(e);
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
							logger.error(t);
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
	private class Responser {
		
		private int no;
		
		private String ip;
		private int port;
		private String username;
		private String password;
		
		private FTPClient ftp;
		
		private Thread thread;
		
		public Responser(int no, String ip, int port, String username, String password) {
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
								if(null == f) {
									continue;
								}
								PendingRequest pr = pendingRequests.remove(f.getName());
								if(null == pr) {
									// 另外一个线程在处理
									continue;
								}
								String xml = getAndDeleteFile(f.getName());
								pr.response = JaxbUtils.converyToJavaBean(xml, XmlResponse.class);
								pr.notifyCompleted();
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
							logger.error(t);
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
		
		/**
		 * 
		 * @param request
		 * @param sequence
		 * @param requestFileName
		 * @param responseFileName
		 */
		public PendingRequest(XmlRequest request, String sequence, String requestFileName, String responseFileName) {
			this.request = request;
			this.sequence = sequence;
			this.requestFileName = requestFileName;
			this.responseFileName = responseFileName;
		}
		
		/**
		 * 
		 * @return
		 */
		public InputStream getInputStream() {
			return new ByteArrayInputStream("Hi HahA".getBytes()/*request.toXml().getBytes()*/);
		}
		
		/**
		 * 
		 */
		public synchronized void notifyCompleted() {
			this.notifyAll();
		}
	}
}
