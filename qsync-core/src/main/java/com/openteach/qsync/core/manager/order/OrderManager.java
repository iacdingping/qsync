package com.openteach.qsync.core.manager.order;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.openteach.qcity.qsync.common.api.TaskStatus;
import com.openteach.qcity.qsync.common.api.TaskType;
import com.openteach.qsync.api.ExaminationState;
import com.openteach.qsync.core.OrderDeclareStatus;
import com.openteach.qsync.core.PageList;
import com.openteach.qsync.core.PageQuery;
import com.openteach.qsync.core.dao.order.OrderDao;
import com.openteach.qsync.core.dao.order.OrderStatusDao;
import com.openteach.qsync.core.entity.order.Order;
import com.openteach.qsync.core.entity.order.OrderStatus;
import com.openteach.qsync.core.query.order.OrderQuery;
import com.openteach.qsync.util.common.Exceptions;


/**
 *
 * @author dingp email:dingp@51box.cn
 * @version 1.0
 * @since 1.0
 * */
@Service
@Transactional
public class OrderManager {
	
	private Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	private OrderDao orderDao;
	@Autowired
	private OrderStatusDao orderStatusDao;
	
	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性,请注意大小写*/
	public void setOrderDao(OrderDao dao) {
		this.orderDao = dao;
	}
	
	/** 
	 * 创建Order
	 **/
	public Order save(Order order) {
	    Assert.notNull(order,"'order' must be not null");
	    this.orderDao.save(order);
	    return order;
	}
	
	/** 
	 * 更新Order
	 **/	
    public Order update(Order order) {
        Assert.notNull(order,"'order' must be not null");
        this.orderDao.update(order);
        return order;
    }	
    
	/** 
	 * 删除Order
	 **/
    public void deleteById(java.lang.Long id) {
        this.orderDao.deleteById(id);
    }
    
	/** 
	 * 根据ID得到Order
	 **/    
    public Order getById(java.lang.Long id) {
        return this.orderDao.getById(id);
    }
    
	/** 
	 * 统计总数Order
	 **/ 
	public Long count(PageQuery query) {
		return orderDao.count(query);
	}
	
	/** 
	 * list Order
	 **/ 
	public List<Order> list(PageQuery query) {
		return orderDao.list(query);
	}
	
	/** 
	 * 分页查询: Order
	 **/      
	@Transactional(readOnly=true)
	public PageList<Order> findPage(OrderQuery query) {
	    Assert.notNull(query,"'query' must be not null");
		return new PageList<Order>(list(query), 
				query.getPage(), query.getPageSize(), count(query));
	}

	/**
	 * 修改订单状态 isSync returnType
	 * @param id
	 * @param declareStatus
	 * @param orderState
	 * @param examinationState
	 * @return
	 */
	public int updateOrderStatus(Long id, String declareStatus, Integer orderState, ExaminationState examinationState, boolean insertOrderState) {
		Map<String, Object> params = new HashMap<String, Object>(2);
		params.put("id", id);
		params.put("declareStatus", declareStatus);
		params.put("state", orderState);
		
		log.info(String.format("updated order id [%s] to state [%s], declareStatus [%s], stackTrace [%s]", 
				id, orderState, declareStatus, Exceptions.getCurrentStackTrace()));
		if(examinationState != null) {
			params.put("returnType", examinationState.getState());
		}
		
		if(insertOrderState && orderState != null) {
			//成功或者失败 插入一条订单报关状态表记录
			OrderStatus orderStatus = new OrderStatus();
			orderStatus.setOrderId(id);
			orderStatus.setStatus(orderState);
			orderStatus.setCreatedatetime(new Date());
			orderStatusDao.save(orderStatus);
		}
		
		return orderDao.updateDeclareStatus(params);
	}
	
	public synchronized int updateDeclareStatus(Long orderId, TaskType taskType, TaskStatus taskStatus, ExaminationState examinationState) {
		Order order = getById(orderId);
		String declareStatus = StringUtils.defaultIfEmpty(order.getDeclareStatus(), OrderDeclareStatus.INITIALIZE.getValue());
		int index = 0;
		char s =  (taskStatus.ordinal() + "").charAt(0);
		switch(taskType) {
		case DATA_ERROR:
			s = '2';
			break;
		case ORDER_DECLARE:
			index = 1;
			break;
		case PERSONAL_GOODS_DECLAR:
			index = 2;
			break;
		case WAY_BILL_DECLARE:
			index = 3;
			break;
		case LOGISTICS_DECLARE:
			index = 4;
			break;
		}
		char[] status = declareStatus.toCharArray();
		status[index] = s;
		
		Integer orderState = null;
		
		if(taskStatus.isSuccess()) {
			orderState = 6;
		} else if(taskStatus.isFailed()) {
			orderState = 5;
		}
		return updateOrderStatus(order.getId(), String.valueOf(status), orderState, examinationState, taskStatus != TaskStatus.DATA_ERROR && taskType ==TaskType.PERSONAL_GOODS_DECLAR);
	}
	
}
