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

import com.openteach.qsync.core.order.Transportation;
import com.openteach.qsync.core.order.TransportationDao;
import com.openteach.qsync.core.order.TransportationManager;
import com.openteach.qsync.core.order.TransportationQuery;


/**
 *
 * @author dingp email:dingp@51box.cn
 * @version 1.0
 * @since 1.0
 * */
@Service
@Transactional
@Monitored
public class TransportationManager {

	@Autowired
	private TransportationDao transportationDao;
	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性,请注意大小写*/
	public void setTransportationDao(TransportationDao dao) {
		this.transportationDao = dao;
	}
	
	/** 
	 * 创建Transportation
	 **/
	public Transportation save(Transportation transportation) {
	    Assert.notNull(transportation,"'transportation' must be not null");
	    initDefaultValuesForCreate(transportation);
	    new TransportationChecker().checkCreateTransportation(transportation);
	    this.transportationDao.save(transportation);
	    return transportation;
	}
	
	/** 
	 * 更新Transportation
	 **/	
    public Transportation update(Transportation transportation) {
        Assert.notNull(transportation,"'transportation' must be not null");
        new TransportationChecker().checkUpdateTransportation(transportation);
        this.transportationDao.update(transportation);
        return transportation;
    }	
    
	/** 
	 * 删除Transportation
	 **/
    public void deleteById(java.lang.Long id) {
        this.transportationDao.deleteById(id);
    }
    
	/** 
	 * 根据ID得到Transportation
	 **/    
    public Transportation getById(java.lang.Long id) {
        return this.transportationDao.getById(id);
    }
    
	/** 
	 * 统计总数Transportation
	 **/ 
	public Long count(PageQuery query) {
		return transportationDao.count(query);
	}
	
	/** 
	 * list Transportation
	 **/ 
	public List<Transportation> list(PageQuery query) {
		return transportationDao.list(query);
	}
	
	/** 
	 * 分页查询: Transportation
	 **/      
	@Transactional(readOnly=true)
	public PageList<Transportation> findPage(TransportationQuery query) {
	    Assert.notNull(query,"'query' must be not null");
		return new PageList<Transportation>(list(query), 
				query.getPage(), query.getPageSize(), count(query));
	}
	
    
	/**
	 * 为创建时初始化相关默认值 
	 **/
    public void initDefaultValuesForCreate(Transportation v) {
    }
    
    /**
     * Transportation的属性检查类,根据自己需要编写自定义检查
     **/
    public class TransportationChecker {
        /**可以在此检查只有更新才需要的特殊检查 */
        public void checkUpdateTransportation(Transportation v) {
            checkTransportation(v);
        }
    
        /**可以在此检查只有创建才需要的特殊检查 */
        public void checkCreateTransportation(Transportation v) {
            checkTransportation(v);
        }
        
        /** 检查到有错误请直接抛异常，不要使用 return errorCode的方式 */
        public void checkTransportation(Transportation v) {
        	// Bean Validator检查,属性检查失败将抛异常
            validateWithException(v);
            
        	//复杂的属性的检查一般需要分开写几个方法，如 checkProperty1(v),checkProperty2(v)
        }
    }
}
