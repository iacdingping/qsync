package com.openteach.qsync.service.declare.queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

import org.springframework.stereotype.Component;

import com.openteach.qsync.api.BaseBody;

@Component
public class TaskQueue {

	private BlockingQueue<Task> goodsQueue = 
			new LinkedBlockingDeque<Task>();
	
	private BlockingQueue<Task> logisticsQueue = 
			new LinkedBlockingDeque<Task>();
	
	private BlockingQueue<Task> orderQueue = 
			new LinkedBlockingDeque<Task>();
	
	private BlockingQueue<Task> waybillQueue = 
			new LinkedBlockingDeque<Task>();
	
	public Task getGoodsRequest() {
		return goodsQueue.poll();
	}
	
	public Task getLogisticsRequest() {
		return logisticsQueue.poll();
	}
	
	public Task getOrderRequest() {
		return orderQueue.poll();
	}
	
	public Task getWaybillRequest() {
		return waybillQueue.poll();
	}
	
	public void submitGoodsRequest(Task goodsRequest) throws InterruptedException {
			goodsQueue.put(goodsRequest);
	}
	
	public void submitLogisticsRequest(Task logisticsRequest) throws InterruptedException {
		logisticsQueue.put(logisticsRequest);
	}
	
	public void submitOrderRequest(Task orderRequest) throws InterruptedException {
		orderQueue.put(orderRequest);
	}
	
	public void submitWaybillRequest(Task waybillRequest) throws InterruptedException {
		waybillQueue.put(waybillRequest);
	}
	
	public class Task {
		private BaseBody request;
		//orderID or maybe logistics id
		private Long id;
		public BaseBody getRequest() {
			return request;
		}
		public void setRequest(BaseBody request) {
			this.request = request;
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
	}
}
