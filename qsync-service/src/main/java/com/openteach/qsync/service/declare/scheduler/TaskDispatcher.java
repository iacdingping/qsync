package com.openteach.qsync.service.declare.scheduler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.openteach.qsync.api.XmlRequest;
import com.openteach.qsync.api.order.request.OrderInfo;
import com.openteach.qsync.core.order.Order;
import com.openteach.qsync.service.declare.AssembleService;

@Component
public class TaskDispatcher {

	@Autowired
	private AssembleService assembleService;
	
	public void scan() {
		List<Order> orders = assembleService.listOrders();
		for(Order order : orders) {
			pushTask(order);
		}
	}

	private void pushTask(Order order) {
		//商品订单发送跨境电商平台
		pushOrderTask(order);
		//个人物品申报单写入跨境电商平台
		pushGoodsTask(order);
		//物流数据发送跨境电商平台
		pushLogisticsTask(order);
		//运单信息发送跨境平台
		pushWillbillTask(order);
	}

	private void pushOrderTask(Order order) {
		
	}
	
	private void pushGoodsTask(Order order) {
		
	}
	
	private void pushLogisticsTask(Order order) {
		
	}
	
	private void pushWillbillTask(Order order) {
		
	}

}
