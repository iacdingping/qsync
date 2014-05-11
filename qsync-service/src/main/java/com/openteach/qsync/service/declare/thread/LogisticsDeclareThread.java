package com.openteach.qsync.service.declare.thread;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.openteach.qsync.api.logistics.request.Body;
import com.openteach.qsync.service.declare.DeclareResult;
import com.openteach.qsync.service.declare.queue.TaskQueue;

/**
 * 物流信息报关线程
 * @author IAC-DINGPING
 *
 */
@Component
public class LogisticsDeclareThread implements Runnable {

	@Autowired
	TaskQueue queue;
	
	@Override
	public void run() {
		Body request = (Body)queue.getWaybillRequest().getRequest();
		DeclareResult result = processDeclare(request);
		processResult(queue.getWaybillRequest().getId(), result);
	}

	/**
	 * 处理回执申报结果 更新申报信息状态
	 * @param id	order ID or logistic ID
	 * @param result
	 */
	private void processResult(Long id, DeclareResult result) {
		
	}

	/**
	 * 申报数据通信处理 调用qsync-api
	 * @param request
	 * @return
	 */
	private DeclareResult processDeclare(Body request) {
		return null;
	}

}
