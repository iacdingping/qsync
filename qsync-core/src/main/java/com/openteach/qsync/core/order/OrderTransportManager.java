/*
 * Powered By china-telcom
 * Since 2012 - 2014
 */

package com.openteach.qsync.core.order;

import iac.dp.tourism.util.PageList;
import iac.dp.tourism.util.PageQuery;

import java.util.List;

import org.javasimon.aop.Monitored;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.openteach.qsync.core.order.OrderTransport;
import com.openteach.qsync.core.order.OrderTransportDao;
import com.openteach.qsync.core.order.OrderTransportManager;
import com.openteach.qsync.core.order.OrderTransportQuery;


/**
 *
 * @author dingp email:dingp@51box.cn
 * @version 1.0
 * @since 1.0
 * */
@Service
@Transactional
@Monitored
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
	    initDefaultValuesForCreate(orderTransport);
	    new OrderTransportChecker().checkCreateOrderTransport(orderTransport);
	    this.orderTransportDao.save(orderTransport);
	    return orderTransport;
	}
	
	/** 
	 * 更新OrderTransport
	 **/	
    public OrderTransport update(OrderTransport orderTransport) {
        Assert.notNull(orderTransport,"'orderTransport' must be not null");
        new OrderTransportChecker().checkUpdateOrderTransport(orderTransport);
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
	
    
	/**
	 * 为创建时初始化相关默认值 
	 **/
    public void initDefaultValuesForCreate(OrderTransport v) {
    }
    
    /**
     * OrderTransport的属性检查类,根据自己需要编写自定义检查
     **/
    public class OrderTransportChecker {
        /**可以在此检查只有更新才需要的特殊检查 */
        public void checkUpdateOrderTransport(OrderTransport v) {
            checkOrderTransport(v);
        }
    
        /**可以在此检查只有创建才需要的特殊检查 */
        public void checkCreateOrderTransport(OrderTransport v) {
            checkOrderTransport(v);
        }
        
        /** 检查到有错误请直接抛异常，不要使用 return errorCode的方式 */
        public void checkOrderTransport(OrderTransport v) {
        	// Bean Validator检查,属性检查失败将抛异常
            validateWithException(v);
            
        	//复杂的属性的检查一般需要分开写几个方法，如 checkProperty1(v),checkProperty2(v)
        }
    }
}
