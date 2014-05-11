/*
 * Powered By china-telcom
 * Since 2012 - 2014
 */

package com.openteach.qsync.core.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.openteach.qsync.core.PageList;
import com.openteach.qsync.core.PageQuery;


/**
 *
 * @author dingp email:dingp@51box.cn
 * @version 1.0
 * @since 1.0
 * */
@Service
@Transactional
public class OrderManager {

	@Autowired
	private OrderDao orderDao;
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
	
}
