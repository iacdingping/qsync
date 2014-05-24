package com.openteach.qsync.task.impl;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.openteach.qcity.qsync.common.lifecycle.AbstractLifeCycle;
import com.openteach.qsync.api.XmlRequest;
import com.openteach.qsync.api.utils.JaxbUtils;
import com.openteach.qsync.core.entity.order.Order;
import com.openteach.qsync.core.entity.system.CcSyncTaks;
import com.openteach.qsync.service.declare.AssembleService;
import com.openteach.qsync.task.TaskGenerator;
import com.openteach.qsync.task.TaskStatus;
import com.openteach.qsync.task.TaskStorage;

/**
 * 目前是单线程跑
 * @author rqq
 *
 */
public class SingleThreadTaskGenerator extends AbstractLifeCycle implements TaskGenerator {

	private static final Log LOGGER = LogFactory.getLog(SingleThreadTaskGenerator.class);
	
	private static final String HOST_NAME;
	
	public static final int DEFAULT_RETRY_PERIOD = 10;
	
	/**
	 * 周期, 单位秒
	 */
	private int retryPeriod = DEFAULT_RETRY_PERIOD;
	
	private AssembleService assembleService;

	private TaskStorage storage;
	
	/**
	 * 
	 */
	private Thread thread;
	
	static {
		try {
			HOST_NAME = InetAddress.getLocalHost().getHostName();
		} catch (UnknownHostException e) {
			throw new RuntimeException("can not get host name", e);
		}
	}
	
	@Override
	public void initialize() {
		super.initialize();
		thread = new Thread(new Runnable() {

			@Override
			public void run() {
				while(!Thread.currentThread().isInterrupted()) {
					try {
						if(0 == generate()) {
							Thread.sleep(retryPeriod);
						}
					} catch (InterruptedException e) {
						LOGGER.error("generate task failed", e);
						Thread.currentThread().interrupt();
					} catch (Throwable t) {
						LOGGER.error("generate task failed", t);
					}
				}
			}
			
		}, "default-task-generator-thread");
	}

	@Override
	public void start() {
		super.start();
		thread.start();
	}

	@Override
	public void shutdown() {
		thread.interrupt();
		super.shutdown();
	}
	
	public void setRetryPeriod(int retryPeriod) {
		this.retryPeriod = retryPeriod;
	}
	
	public void setAssembleService(AssembleService assembleService) {
		this.assembleService = assembleService;
	}

	public void setStorage(TaskStorage storage) {
		this.storage = storage;
	}
	
	/**
	 * 
	 */
	private int generate() {
		List<Order> oList = assembleService.listOrders();
		for(Order o : oList) {
			XmlRequest request = assembleService.getOrderXmlRequest(o);
			storage.store(newTask(request, TaskType.ORDER_DECLARE));
			storage.store(newTask(assembleService.getLogisticsXmlRequest(o), TaskType.LOGISTICS_DECLARE));
			storage.store(newTask(assembleService.getWaybillXmlRequest(o), TaskType.WAY_BILL_DECLARE));
			storage.store(newTask(assembleService.getGoodsXmlRequest(o), TaskType.GOODS_DECLARE));
			// TODO 标记订单已经被处理，处理中
		}
		return oList.size();
	}
	
	/**
	 * 
	 * @param request
	 * @param type
	 * @return
	 */
	private CcSyncTaks newTask(XmlRequest request, TaskType type) {
		CcSyncTaks t = new CcSyncTaks();
		t.setGenerator(HOST_NAME);
		t.setType(type.name());
		t.setStatus(TaskStatus.UNDO.name());
		t.setXmlRequest(JaxbUtils.convertToXml(request));
		t.setGmtCreate(new Date());
		t.setGmtModified(t.getGmtCreate());
		return t;
	}
}
