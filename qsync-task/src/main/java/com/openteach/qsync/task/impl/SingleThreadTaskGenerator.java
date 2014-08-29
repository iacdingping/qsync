package com.openteach.qsync.task.impl;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.openteach.qcity.qsync.common.api.TaskStatus;
import com.openteach.qcity.qsync.common.api.TaskType;
import com.openteach.qcity.qsync.common.lifecycle.AbstractLifeCycle;
import com.openteach.qsync.api.XmlRequest;
import com.openteach.qsync.api.goods.request.XmlGoodsDeclarRequest;
import com.openteach.qsync.api.logistics.request.XmlLogisticsRequest;
import com.openteach.qsync.api.order.request.XmlOrderRequest;
import com.openteach.qsync.api.utils.JaxbUtils;
import com.openteach.qsync.api.waybill.request.XmlWaybillRequest;
import com.openteach.qsync.core.entity.order.Order;
import com.openteach.qsync.core.entity.system.CcSyncTaks;
import com.openteach.qsync.service.declare.AssembleService;
import com.openteach.qsync.task.TaskGenerator;
import com.openteach.qsync.task.TaskStorage;
import com.openteach.qsync.util.common.Exceptions;

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
			
			try {
					assembleService.mappingOrder(o);
					XmlOrderRequest orderRequest = assembleService.getOrderXmlRequest(o);
					storage.store(newTask(o.getId(), orderRequest, TaskType.ORDER_DECLARE, orderRequest.getBody().getOrderInfoList().get(0).getJkfSign().getBusinessNo(), null));
					XmlLogisticsRequest logisticsRequest = assembleService.getLogisticsXmlRequest(o);
					storage.store(newTask(o.getId(), logisticsRequest, TaskType.LOGISTICS_DECLARE, logisticsRequest.getBody().getLogisticsList().get(0).getJkfSign().getBusinessNo(), null));
					XmlWaybillRequest waybillRequest = assembleService.getWaybillXmlRequest(o);
					storage.store(newTask(o.getId(), waybillRequest, TaskType.WAY_BILL_DECLARE, waybillRequest.getBody().getWayBillList().get(0).getJkfSign().getBusinessNo(), null));
					XmlGoodsDeclarRequest goodsDeclarRequest = assembleService.getGoodsXmlRequest(o);
					String businessNo = goodsDeclarRequest.getBody().getGoodsDeclarModuleList().get(0).getJkfSign().getBusinessNo();
					String preEntryNo = goodsDeclarRequest.getBody().getGoodsDeclarModuleList().get(0).getGoodsDeclar().getPreEntryNumber();
					storage.store(newTask(o.getId(), goodsDeclarRequest, TaskType.PERSONAL_GOODS_DECLAR, businessNo, preEntryNo));
			} catch (Throwable t) {
					storage.store(newErrorTask(o.getId(), Exceptions.getStackTraceAsString(t)));
			}
			// TODO 标记订单已经被处理，处理中
		}
		return oList.size();
	}
	
	/**
	 * 
	 * @param orderId	订单ID
	 * @param request	请求报文
	 * @param type	任务类型
	 * @param businessNo	第一次回执匹配根据bisinessNo
	 * @param preEntryNo	海关回执根据preEntryNo匹配
	 * @return
	 */
	private CcSyncTaks newTask(Long orderId, XmlRequest request, TaskType type, String businessNo, String preEntryNo) {
		CcSyncTaks t = new CcSyncTaks();
		t.setOrderId(orderId);
		t.setGenerator(HOST_NAME);
		t.setType(type.name());
		t.setStatus(TaskStatus.UNDO.name());
		t.setXmlRequest(JaxbUtils.convertToXml(request));
		t.setGmtCreate(new Date());
		t.setGmtModified(t.getGmtCreate());
		t.setBusinessNo(businessNo);
		t.setPreEntryNo(preEntryNo);
		return t;
	}
	
	private CcSyncTaks newErrorTask(Long orderId, String exception) {
		CcSyncTaks t = new CcSyncTaks();
		t.setGenerator(HOST_NAME);
		t.setType(TaskType.DATA_ERROR.name());
		t.setStatus(TaskStatus.DATA_ERROR.name());
		t.setXmlRequest("");
		t.setOrderId(orderId);
		t.setException(exception);
		t.setGmtCreate(new Date());
		t.setGmtModified(t.getGmtCreate());
		return t;
	}
}
