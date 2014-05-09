/*
 * Powered By china-telcom
 * Since 2012 - 2014
 */

package com.openteach.qsync.core.pay;

import iac.dp.tourism.util.PageList;
import iac.dp.tourism.util.PageQuery;

import java.util.List;

import org.javasimon.aop.Monitored;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.openteach.qsync.core.pay.Payment;
import com.openteach.qsync.core.pay.PaymentDao;
import com.openteach.qsync.core.pay.PaymentManager;
import com.openteach.qsync.core.pay.PaymentQuery;


/**
 *
 * @author dingp email:dingp@51box.cn
 * @version 1.0
 * @since 1.0
 * */
@Service
@Transactional
@Monitored
public class PaymentManager {

	@Autowired
	private PaymentDao paymentDao;
	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性,请注意大小写*/
	public void setPaymentDao(PaymentDao dao) {
		this.paymentDao = dao;
	}
	
	/** 
	 * 创建Payment
	 **/
	public Payment save(Payment payment) {
	    Assert.notNull(payment,"'payment' must be not null");
	    initDefaultValuesForCreate(payment);
	    new PaymentChecker().checkCreatePayment(payment);
	    this.paymentDao.save(payment);
	    return payment;
	}
	
	/** 
	 * 更新Payment
	 **/	
    public Payment update(Payment payment) {
        Assert.notNull(payment,"'payment' must be not null");
        new PaymentChecker().checkUpdatePayment(payment);
        this.paymentDao.update(payment);
        return payment;
    }	
    
	/** 
	 * 删除Payment
	 **/
    public void deleteById(java.lang.Long id) {
        this.paymentDao.deleteById(id);
    }
    
	/** 
	 * 根据ID得到Payment
	 **/    
    public Payment getById(java.lang.Long id) {
        return this.paymentDao.getById(id);
    }
    
	/** 
	 * 统计总数Payment
	 **/ 
	public Long count(PageQuery query) {
		return paymentDao.count(query);
	}
	
	/** 
	 * list Payment
	 **/ 
	public List<Payment> list(PageQuery query) {
		return paymentDao.list(query);
	}
	
	/** 
	 * 分页查询: Payment
	 **/      
	@Transactional(readOnly=true)
	public PageList<Payment> findPage(PaymentQuery query) {
	    Assert.notNull(query,"'query' must be not null");
		return new PageList<Payment>(list(query), 
				query.getPage(), query.getPageSize(), count(query));
	}
	
    
	/**
	 * 为创建时初始化相关默认值 
	 **/
    public void initDefaultValuesForCreate(Payment v) {
    }
    
    /**
     * Payment的属性检查类,根据自己需要编写自定义检查
     **/
    public class PaymentChecker {
        /**可以在此检查只有更新才需要的特殊检查 */
        public void checkUpdatePayment(Payment v) {
            checkPayment(v);
        }
    
        /**可以在此检查只有创建才需要的特殊检查 */
        public void checkCreatePayment(Payment v) {
            checkPayment(v);
        }
        
        /** 检查到有错误请直接抛异常，不要使用 return errorCode的方式 */
        public void checkPayment(Payment v) {
        	// Bean Validator检查,属性检查失败将抛异常
            validateWithException(v);
            
        	//复杂的属性的检查一般需要分开写几个方法，如 checkProperty1(v),checkProperty2(v)
        }
    }
}
