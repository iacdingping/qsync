package com.openteach.qsync.core.manager.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.openteach.qsync.core.PageList;
import com.openteach.qsync.core.PageQuery;
import com.openteach.qsync.core.dao.order.OrderStatusDao;
import com.openteach.qsync.core.entity.order.OrderStatus;
import com.openteach.qsync.core.query.order.OrderStatusQuery;


/**
 *
 * @author dingp email:dingp@51box.cn
 * @version 1.0
 * @since 1.0
 * */
@Service
@Transactional
public class OrderStatusManager {

	@Autowired
	private OrderStatusDao orderStatusDao;
	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性,请注意大小写*/
	public void setOrderStatusDao(OrderStatusDao dao) {
		this.orderStatusDao = dao;
	}
	
	/** 
	 * 创建OrderStatus
	 **/
	public OrderStatus save(OrderStatus orderStatus) {
	    Assert.notNull(orderStatus,"'orderStatus' must be not null");
	    this.orderStatusDao.save(orderStatus);
	    return orderStatus;
	}
	
	/** 
	 * 更新OrderStatus
	 **/	
    public OrderStatus update(OrderStatus orderStatus) {
        Assert.notNull(orderStatus,"'orderStatus' must be not null");
        this.orderStatusDao.update(orderStatus);
        return orderStatus;
    }	
    
	/** 
	 * 删除OrderStatus
	 **/
    public void deleteById(java.lang.Long id) {
        this.orderStatusDao.deleteById(id);
    }
    
	/** 
	 * 根据ID得到OrderStatus
	 **/    
    public OrderStatus getById(java.lang.Long id) {
        return this.orderStatusDao.getById(id);
    }
    
	/** 
	 * 统计总数OrderStatus
	 **/ 
	public Long count(PageQuery query) {
		return orderStatusDao.count(query);
	}
	
	/** 
	 * list OrderStatus
	 **/ 
	public List<OrderStatus> list(PageQuery query) {
		return orderStatusDao.list(query);
	}
	
	/** 
	 * 分页查询: OrderStatus
	 **/      
	@Transactional(readOnly=true)
	public PageList<OrderStatus> findPage(OrderStatusQuery query) {
	    Assert.notNull(query,"'query' must be not null");
		return new PageList<OrderStatus>(list(query), 
				query.getPage(), query.getPageSize(), count(query));
	}
	
}
