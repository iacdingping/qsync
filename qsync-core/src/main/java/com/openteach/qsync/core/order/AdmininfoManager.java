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

import com.openteach.qsync.core.order.Admininfo;
import com.openteach.qsync.core.order.AdmininfoDao;
import com.openteach.qsync.core.order.AdmininfoManager;
import com.openteach.qsync.core.order.AdmininfoQuery;


/**
 *
 * @author dingp email:dingp@51box.cn
 * @version 1.0
 * @since 1.0
 * */
@Service
@Transactional
@Monitored
public class AdmininfoManager {

	@Autowired
	private AdmininfoDao admininfoDao;
	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性,请注意大小写*/
	public void setAdmininfoDao(AdmininfoDao dao) {
		this.admininfoDao = dao;
	}
	
	/** 
	 * 创建Admininfo
	 **/
	public Admininfo save(Admininfo admininfo) {
	    Assert.notNull(admininfo,"'admininfo' must be not null");
	    initDefaultValuesForCreate(admininfo);
	    new AdmininfoChecker().checkCreateAdmininfo(admininfo);
	    this.admininfoDao.save(admininfo);
	    return admininfo;
	}
	
	/** 
	 * 更新Admininfo
	 **/	
    public Admininfo update(Admininfo admininfo) {
        Assert.notNull(admininfo,"'admininfo' must be not null");
        new AdmininfoChecker().checkUpdateAdmininfo(admininfo);
        this.admininfoDao.update(admininfo);
        return admininfo;
    }	
    
	/** 
	 * 删除Admininfo
	 **/
    public void deleteById(java.lang.Long id) {
        this.admininfoDao.deleteById(id);
    }
    
	/** 
	 * 根据ID得到Admininfo
	 **/    
    public Admininfo getById(java.lang.Long id) {
        return this.admininfoDao.getById(id);
    }
    
	/** 
	 * 统计总数Admininfo
	 **/ 
	public Long count(PageQuery query) {
		return admininfoDao.count(query);
	}
	
	/** 
	 * list Admininfo
	 **/ 
	public List<Admininfo> list(PageQuery query) {
		return admininfoDao.list(query);
	}
	
	/** 
	 * 分页查询: Admininfo
	 **/      
	@Transactional(readOnly=true)
	public PageList<Admininfo> findPage(AdmininfoQuery query) {
	    Assert.notNull(query,"'query' must be not null");
		return new PageList<Admininfo>(list(query), 
				query.getPage(), query.getPageSize(), count(query));
	}
	
    
	/**
	 * 为创建时初始化相关默认值 
	 **/
    public void initDefaultValuesForCreate(Admininfo v) {
    }
    
    /**
     * Admininfo的属性检查类,根据自己需要编写自定义检查
     **/
    public class AdmininfoChecker {
        /**可以在此检查只有更新才需要的特殊检查 */
        public void checkUpdateAdmininfo(Admininfo v) {
            checkAdmininfo(v);
        }
    
        /**可以在此检查只有创建才需要的特殊检查 */
        public void checkCreateAdmininfo(Admininfo v) {
            checkAdmininfo(v);
        }
        
        /** 检查到有错误请直接抛异常，不要使用 return errorCode的方式 */
        public void checkAdmininfo(Admininfo v) {
        	// Bean Validator检查,属性检查失败将抛异常
            validateWithException(v);
            
        	//复杂的属性的检查一般需要分开写几个方法，如 checkProperty1(v),checkProperty2(v)
        }
    }
}
