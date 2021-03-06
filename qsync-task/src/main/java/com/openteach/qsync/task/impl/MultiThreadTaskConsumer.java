package com.openteach.qsync.task.impl;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.openteach.qcity.qsync.common.lifecycle.AbstractLifeCycle;
import com.openteach.qsync.api.CommonXmlResponse;
import com.openteach.qsync.api.JkfClient;
import com.openteach.qsync.api.JkfClient.Callback;
import com.openteach.qsync.api.XmlRequest;
import com.openteach.qsync.api.XmlResponse;
import com.openteach.qsync.api.exception.ApiException;
import com.openteach.qsync.api.goods.request.XmlGoodsDeclarRequest;
import com.openteach.qsync.api.logistics.request.XmlLogisticsRequest;
import com.openteach.qsync.api.order.request.XmlOrderRequest;
import com.openteach.qsync.api.utils.JaxbUtils;
import com.openteach.qsync.api.waybill.request.XmlWaybillRequest;
import com.openteach.qsync.core.TaskStatus;
import com.openteach.qsync.core.TaskType;
import com.openteach.qsync.core.entity.system.CcSyncTaks;
import com.openteach.qsync.core.query.system.CcSyncTaksQuery;
import com.openteach.qsync.task.TaskConsumer;
import com.openteach.qsync.task.TaskStorage;
import com.openteach.qsync.task.TaskUtils;

/**
 * 
 * @author rqq
 *
 */
public class MultiThreadTaskConsumer extends AbstractLifeCycle implements TaskConsumer {

	private static final Log LOGGER = LogFactory.getLog(MultiThreadTaskConsumer.class);
	
	public static final int DEFAULT_RETRY_PERIOD = 10;
	
	public static final int DEFAULT_THREAD_COUNT = 1 /*Runtime.getRuntime().availableProcessors() + 1*/;
	
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
	
	/**
	 * 
	 */
	private CountDownLatch latch;
	
	@Override
	public void initialize() {
		super.initialize();
		
		latch = new CountDownLatch(threadCount);
		threads = new Thread[threadCount];
		for(int i = 0; i < threadCount; i++) { 
			CcSyncTaksQuery query = new CcSyncTaksQuery();
			query.setWorkerSize(threadCount);
			query.setInStatus(Arrays.asList(TaskStatus.UNDO.name(), TaskStatus.LAUNCH_FAILED.name()));
			query.setMode(i);
			threads[i] = new Worker(query);
		}
		
		callback = new Callback() {

			@Override
			public void onSucceed(XmlResponse response, Object context) {
				CcSyncTaks task = (CcSyncTaks)context;
				task.setStatus(response.getSuccess() ? TaskStatus.DECLARE_SUCCESS.name() : TaskStatus.DECLARE_FAILED.name());
				task.setXmlResponse(JaxbUtils.convertToXml(response));
				task.setGmtModified(new Date());
				storage.update(task);
			}

			@Override
			public void onFailed(ApiException exception, Object context) {
				CcSyncTaks task = (CcSyncTaks)context;
				task.setStatus(TaskStatus.LAUNCH_FAILED.name());
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
	private int consume(CcSyncTaksQuery query, boolean isRecovered) {
		List<CcSyncTaks> tList = storage.query(query);
		for(CcSyncTaks t : tList) {
			Object[] a = TaskUtils.formXml(t);
			if(null == a) {
				LOGGER.error("Wrong task type for consume, task id:" + t.getId());
				continue;
			}
			
			if(TaskType.LOGISTICS_DECLARE == (TaskType)a[0]) {
				t.setStatus(TaskStatus.IGNORE.name());
				t.setGmtModified(new Date());
				storage.update(t);
				continue;
			}
			
			jkfClient.async((XmlRequest)a[1], callback, t, t.getBusinessNo(), (Class<? extends XmlResponse>)a[2], isRecovered);
			t.setStatus(TaskStatus.DOING.name());
			storage.update(t);
		}
		return tList.size();
	}
	
	/**
	 * 
	 * @param t
	 * @return
	 */
	private Object[] formXml(CcSyncTaks t) {
		XmlRequest r = null;
		Class<? extends XmlResponse> clazz = null;
		TaskType type = TaskType.valueOf(t.getType());
		if(TaskType.PERSONAL_GOODS_DECLAR == type) {
			r = JaxbUtils.converyToJavaBean(t.getXmlRequest(), XmlGoodsDeclarRequest.class);
			clazz = CommonXmlResponse.class;
		} else if(TaskType.LOGISTICS_DECLARE == type) {
			r = JaxbUtils.converyToJavaBean(t.getXmlRequest(), XmlLogisticsRequest.class);
			clazz = CommonXmlResponse.class;
		} else if(TaskType.ORDER_DECLARE == type) {
			r = JaxbUtils.converyToJavaBean(t.getXmlRequest(), XmlOrderRequest.class);
			clazz = CommonXmlResponse.class;
		} else if(TaskType.WAY_BILL_DECLARE == type) {
			r = JaxbUtils.converyToJavaBean(t.getXmlRequest(), XmlWaybillRequest.class);
			clazz = CommonXmlResponse.class;
		}
		if(null == r || null == clazz) {
			return null;
		}
		return new Object[]{r, clazz};
	}
	
	/**
	 * 
	 * @author rqq
	 *
	 */
	private class Worker extends Thread {
		
		private CcSyncTaksQuery query;
		
		public Worker(CcSyncTaksQuery query) {
			super("default-task-consumer-thread-" + query.getMode());
			this.query = query;
		}
		
		@Override
		public void run() {
			
			//
			recover();
			latch.countDown();
			// wait other threads
			
			try {
				latch.await();
			} catch (InterruptedException e) {
				LOGGER.error("wait other threads recover failed", e);
				Thread.currentThread().interrupt();
			}
			
			while(!Thread.currentThread().isInterrupted()) {
				try {
					if(0 == consume(this.query, false)) {
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
		
		private void recover() {
			CcSyncTaksQuery query = new CcSyncTaksQuery();
			query.setWorkerSize(this.query.getWorkerSize());
			query.setInStatus(Arrays.asList(TaskStatus.DOING.name()));
			query.setMode(this.query.getMode());
			query.setSortColumns("id ASC");
			LOGGER.warn("Consumer : " + Thread.currentThread().getName() + ", mode : " + query.getMode() + " try to recover");
			
			int total = 0;
			int count = 0;
			while((count = consume(query, true))> 0) {
				total += count;
				query.setPage(query.getPage() + 1);
			}
			LOGGER.warn("Consumer : " + Thread.currentThread().getName() + ", mode : " + query.getMode() + " , " + total + " recover completed");
		}
	}
}
