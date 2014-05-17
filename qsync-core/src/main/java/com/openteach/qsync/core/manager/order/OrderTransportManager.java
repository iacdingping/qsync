package com.openteach.qsync.core.manager.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.openteach.qsync.core.PageList;
import com.openteach.qsync.core.PageQuery;
import com.openteach.qsync.core.dao.order.OrderTransportDao;
import com.openteach.qsync.core.entity.order.OrderTransport;
import com.openteach.qsync.core.query.order.OrderTransportQuery;


/**
 *
 * @author dingp email:dingp@51box.cn
 * @version 1.0
 * @since 1.0
 * */
@Service
@Transactional
public class OrderTransportManager {

	@Autowired
	private OrderTransportDao orderTransportDao;
	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性,请注意大小写*/
	public void setOrderTransportDao(OrderTransportDao dao) {
		this.orderTransportDao = dao;
	}
	
	/** 
	 * 创建OrderTransport
	 **/
	public OrderTransport save(OrderTransport orderTransport) {
	    Assert.notNull(orderTransport,"'orderTransport' must be not null");
	    this.orderTransportDao.save(orderTransport);
	    return orderTransport;
	}
	
	/** 
	 * 更新OrderTransport
	 **/	
    public OrderTransport update(OrderTransport orderTransport) {
        Assert.notNull(orderTransport,"'orderTransport' must be not null");
        this.orderTransportDao.update(orderTransport);
        return orderTransport;
    }	
    
	/** 
	 * 删除OrderTransport
	 **/
    public void deleteById(java.lang.Long id) {
        this.orderTransportDao.deleteById(id);
    }
    
	/** 
	 * 根据ID得到OrderTransport
	 **/    
    public OrderTransport getById(java.lang.Long id) {
        return this.orderTransportDao.getById(id);
    }
    
	/** 
	 * 统计总数OrderTransport
	 **/ 
	public Long count(PageQuery query) {
		return orderTransportDao.count(query);
	}
	
	/** 
	 * list OrderTransport
	 **/ 
	public List<OrderTransport> list(PageQuery query) {
		return orderTransportDao.list(query);
	}
	
	/** 
	 * 分页查询: OrderTransport
	 **/      
	@Transactional(readOnly=true)
	public PageList<OrderTransport> findPage(OrderTransportQuery query) {
	    Assert.notNull(query,"'query' must be not null");
		return new PageList<OrderTransport>(list(query), 
				query.getPage(), query.getPageSize(), count(query));
	}
	
}
