package com.openteach.qsync.task.impl;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.openteach.qcity.qsync.common.lifecycle.AbstractLifeCycle;
import com.openteach.qsync.api.JkfClient;
import com.openteach.qsync.api.JkfClient.Callback;
import com.openteach.qsync.api.XmlRequest;
import com.openteach.qsync.api.XmlResponse;
import com.openteach.qsync.api.exception.ApiException;
import com.openteach.qsync.api.utils.JaxbUtils;
import com.openteach.qsync.task.Task;
import com.openteach.qsync.task.TaskConsumer;
import com.openteach.qsync.task.TaskStatus;
import com.openteach.qsync.task.TaskStorage;

/**
 * 
 * @author rqq
 *
 */
public class MultiThreadTaskConsumer extends AbstractLifeCycle implements TaskConsumer {

	private static final Log LOGGER = LogFactory.getLog(MultiThreadTaskConsumer.class);
	
	public static final int DEFAULT_RETRY_PERIOD = 10;
	
	public static final int DEFAULT_THREAD_COUNT = 4;
	
	private TaskStorage storage;
	
	private JkfClient jkfClient;

	/**
	 * 周期, 单位秒
	 */
	private int retryPeriod = DEFAULT_RETRY_PERIOD;
	
	/**
	 * 
	 */
	private int threadCount = DEFAULT_THREAD_COUNT;

	/**
	 * 
	 */
	private Thread[] threads;
	
	/**
	 * 
	 */
	private JkfClient.Callback callback;
	
	@Override
	public void initialize() {
		super.initialize();
		for(int i = 0; i < threadCount; i++) {
			TaskStorage.TaskQuery query = new TaskStorage.TaskQuery();
			query.setStatusList(Arrays.asList(TaskStatus.UNDO, TaskStatus.FAILED));
			query.setMode(i);
			threads[i] = new Worker(query);
		}
		
		callback = new Callback() {

			@Override
			public void onSucceed(XmlResponse response, Object context) {
				Task task = (Task)context;
				task.setStatus(TaskStatus.DONE);
				task.setXmlResponse(JaxbUtils.convertToXml(response));
				task.setGmtModified(new Date());
				storage.update(task);
			}

			@Override
			public void onFailed(ApiException exception, Object context) {
				Task task = (Task)context;
				task.setStatus(TaskStatus.FAILED);
				StringWriter sw = new StringWriter();
				PrintWriter pw = new PrintWriter(sw); 
				exception.printStackTrace(pw);
				task.setException(sw.toString());
				task.setGmtModified(new Date());
				storage.update(task);
			}
			
		};
	}

	@Override
	public void start() {
		super.start();
		for(int i = 0; i < threadCount; i++) {
			threads[i].start();
		}
	}

	@Override
	public void shutdown() {
		for(int i = 0; i < threadCount; i++) {
			threads[i].interrupt();
		}
		super.shutdown();
	}
	
	public void setRetryPeriod(int retryPeriod) {
		this.retryPeriod = retryPeriod;
	}
	
	public void setThreadCount(int threadCount) {
		this.threadCount = threadCount;
	}
	
	public void setStorage(TaskStorage storage) {
		this.storage = storage;
	}

	public void setJkfClient(JkfClient jkfClient) {
		this.jkfClient = jkfClient;
	}
	
	/**
	 * 
	 */
	private int consume(TaskStorage.TaskQuery query) {
		List<Task> tList = storage.query(query);
		for(Task t : tList) {
			jkfClient.async(JaxbUtils.converyToJavaBean(t.getXmlRequest(), XmlRequest.class), callback, t);
		}
		return tList.size();
	}
	
	/**
	 * 
	 * @author rqq
	 *
	 */
	private class Worker extends Thread {
		
		private TaskStorage.TaskQuery query;
		
		public Worker(TaskStorage.TaskQuery query) {
			super("default-task-consumer-thread-" + query.getMode());
			this.query = query;
		}
		
		@Override
		public void run() {
			while(!Thread.currentThread().isInterrupted()) {
				try {
					if(0 == consume(this.query)) {
						// 休息一下
						Thread.sleep(retryPeriod);
					}
				} catch (InterruptedException e) {
					LOGGER.error("generate task failed", e);
					Thread.currentThread().interrupt();
				} catch (Throwable t) {
					LOGGER.error("consume task failed", t);
				}
			}
		}
	}
}
