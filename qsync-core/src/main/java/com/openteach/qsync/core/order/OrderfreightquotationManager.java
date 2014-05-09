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

import com.openteach.qsync.core.order.Orderfreightquotation;
import com.openteach.qsync.core.order.OrderfreightquotationDao;
import com.openteach.qsync.core.order.OrderfreightquotationManager;
import com.openteach.qsync.core.order.OrderfreightquotationQuery;


/**
 *
 * @author dingp email:dingp@51box.cn
 * @version 1.0
 * @since 1.0
 * */
@Service
@Transactional
@Monitored
public class OrderfreightquotationManager {

	@Autowired
	private OrderfreightquotationDao orderfreightquotationDao;
	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性,请注意大小写*/
	public void setOrderfreightquotationDao(OrderfreightquotationDao dao) {
		this.orderfreightquotationDao = dao;
	}
	
	/** 
	 * 创建Orderfreightquotation
	 **/
	public Orderfreightquotation save(Orderfreightquotation orderfreightquotation) {
	    Assert.notNull(orderfreightquotation,"'orderfreightquotation' must be not null");
	    initDefaultValuesForCreate(orderfreightquotation);
	    new OrderfreightquotationChecker().checkCreateOrderfreightquotation(orderfreightquotation);
	    this.orderfreightquotationDao.save(orderfreightquotation);
	    return orderfreightquotation;
	}
	
	/** 
	 * 更新Orderfreightquotation
	 **/	
    public Orderfreightquotation update(Orderfreightquotation orderfreightquotation) {
        Assert.notNull(orderfreightquotation,"'orderfreightquotation' must be not null");
        new OrderfreightquotationChecker().checkUpdateOrderfreightquotation(orderfreightquotation);
        this.orderfreightquotationDao.update(orderfreightquotation);
        return orderfreightquotation;
    }	
    
	/** 
	 * 删除Orderfreightquotation
	 **/
    public void deleteById(java.lang.Long id) {
        this.orderfreightquotationDao.deleteById(id);
    }
    
	/** 
	 * 根据ID得到Orderfreightquotation
	 **/    
    public Orderfreightquotation getById(java.lang.Long id) {
        return this.orderfreightquotationDao.getById(id);
    }
    
	/** 
	 * 统计总数Orderfreightquotation
	 **/ 
	public Long count(PageQuery query) {
		return orderfreightquotationDao.count(query);
	}
	
	/** 
	 * list Orderfreightquotation
	 **/ 
	public List<Orderfreightquotation> list(PageQuery query) {
		return orderfreightquotationDao.list(query);
	}
	
	/** 
	 * 分页查询: Orderfreightquotation
	 **/      
	@Transactional(readOnly=true)
	public PageList<Orderfreightquotation> findPage(OrderfreightquotationQuery query) {
	    Assert.notNull(query,"'query' must be not null");
		return new PageList<Orderfreightquotation>(list(query), 
				query.getPage(), query.getPageSize(), count(query));
	}
	
    
	/**
	 * 为创建时初始化相关默认值 
	 **/
    public void initDefaultValuesForCreate(Orderfreightquotation v) {
    }
    
    /**
     * Orderfreightquotation的属性检查类,根据自己需要编写自定义检查
     **/
    public class OrderfreightquotationChecker {
        /**可以在此检查只有更新才需要的特殊检查 */
        public void checkUpdateOrderfreightquotation(Orderfreightquotation v) {
            checkOrderfreightquotation(v);
        }
    
        /**可以在此检查只有创建才需要的特殊检查 */
        public void checkCreateOrderfreightquotation(Orderfreightquotation v) {
            checkOrderfreightquotation(v);
        }
        
        /** 检查到有错误请直接抛异常，不要使用 return errorCode的方式 */
        public void checkOrderfreightquotation(Orderfreightquotation v) {
        	// Bean Validator检查,属性检查失败将抛异常
            validateWithException(v);
            
        	//复杂的属性的检查一般需要分开写几个方法，如 checkProperty1(v),checkProperty2(v)
        }
    }
}
