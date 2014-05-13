package com.openteach.qsync.core.logistics;

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
	    this.transportationDao.save(transportation);
	    return transportation;
	}
	
	/** 
	 * 更新Transportation
	 **/	
    public Transportation update(Transportation transportation) {
        Assert.notNull(transportation,"'transportation' must be not null");
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
}
