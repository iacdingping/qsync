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

import com.openteach.qsync.core.order.Finalstatement;
import com.openteach.qsync.core.order.FinalstatementDao;
import com.openteach.qsync.core.order.FinalstatementManager;
import com.openteach.qsync.core.order.FinalstatementQuery;


/**
 *
 * @author dingp email:dingp@51box.cn
 * @version 1.0
 * @since 1.0
 * */
@Service
@Transactional
@Monitored
public class FinalstatementManager {

	@Autowired
	private FinalstatementDao finalstatementDao;
	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性,请注意大小写*/
	public void setFinalstatementDao(FinalstatementDao dao) {
		this.finalstatementDao = dao;
	}
	
	/** 
	 * 创建Finalstatement
	 **/
	public Finalstatement save(Finalstatement finalstatement) {
	    Assert.notNull(finalstatement,"'finalstatement' must be not null");
	    initDefaultValuesForCreate(finalstatement);
	    new FinalstatementChecker().checkCreateFinalstatement(finalstatement);
	    this.finalstatementDao.save(finalstatement);
	    return finalstatement;
	}
	
	/** 
	 * 更新Finalstatement
	 **/	
    public Finalstatement update(Finalstatement finalstatement) {
        Assert.notNull(finalstatement,"'finalstatement' must be not null");
        new FinalstatementChecker().checkUpdateFinalstatement(finalstatement);
        this.finalstatementDao.update(finalstatement);
        return finalstatement;
    }	
    
	/** 
	 * 删除Finalstatement
	 **/
    public void deleteById(java.lang.Long id) {
        this.finalstatementDao.deleteById(id);
    }
    
	/** 
	 * 根据ID得到Finalstatement
	 **/    
    public Finalstatement getById(java.lang.Long id) {
        return this.finalstatementDao.getById(id);
    }
    
	/** 
	 * 统计总数Finalstatement
	 **/ 
	public Long count(PageQuery query) {
		return finalstatementDao.count(query);
	}
	
	/** 
	 * list Finalstatement
	 **/ 
	public List<Finalstatement> list(PageQuery query) {
		return finalstatementDao.list(query);
	}
	
	/** 
	 * 分页查询: Finalstatement
	 **/      
	@Transactional(readOnly=true)
	public PageList<Finalstatement> findPage(FinalstatementQuery query) {
	    Assert.notNull(query,"'query' must be not null");
		return new PageList<Finalstatement>(list(query), 
				query.getPage(), query.getPageSize(), count(query));
	}
	
    
	/**
	 * 为创建时初始化相关默认值 
	 **/
    public void initDefaultValuesForCreate(Finalstatement v) {
    }
    
    /**
     * Finalstatement的属性检查类,根据自己需要编写自定义检查
     **/
    public class FinalstatementChecker {
        /**可以在此检查只有更新才需要的特殊检查 */
        public void checkUpdateFinalstatement(Finalstatement v) {
            checkFinalstatement(v);
        }
    
        /**可以在此检查只有创建才需要的特殊检查 */
        public void checkCreateFinalstatement(Finalstatement v) {
            checkFinalstatement(v);
        }
        
        /** 检查到有错误请直接抛异常，不要使用 return errorCode的方式 */
        public void checkFinalstatement(Finalstatement v) {
        	// Bean Validator检查,属性检查失败将抛异常
            validateWithException(v);
            
        	//复杂的属性的检查一般需要分开写几个方法，如 checkProperty1(v),checkProperty2(v)
        }
    }
}
