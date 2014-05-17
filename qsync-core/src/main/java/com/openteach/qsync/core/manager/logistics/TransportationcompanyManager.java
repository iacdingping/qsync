package com.openteach.qsync.core.manager.logistics;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.openteach.qsync.core.PageList;
import com.openteach.qsync.core.PageQuery;
import com.openteach.qsync.core.dao.logistics.TransportationcompanyDao;
import com.openteach.qsync.core.entity.logistics.Transportationcompany;
import com.openteach.qsync.core.query.logistics.TransportationcompanyQuery;


/**
 *
 * @author dingp email:dingp@51box.cn
 * @version 1.0
 * @since 1.0
 * */
@Service
@Transactional
public class TransportationcompanyManager {

	@Autowired
	private TransportationcompanyDao transportationcompanyDao;
	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性,请注意大小写*/
	public void setTransportationcompanyDao(TransportationcompanyDao dao) {
		this.transportationcompanyDao = dao;
	}
	
	/** 
	 * 创建Transportationcompany
	 **/
	public Transportationcompany save(Transportationcompany transportationcompany) {
	    Assert.notNull(transportationcompany,"'transportationcompany' must be not null");
	    this.transportationcompanyDao.save(transportationcompany);
	    return transportationcompany;
	}
	
	/** 
	 * 更新Transportationcompany
	 **/	
    public Transportationcompany update(Transportationcompany transportationcompany) {
        Assert.notNull(transportationcompany,"'transportationcompany' must be not null");
        this.transportationcompanyDao.update(transportationcompany);
        return transportationcompany;
    }	
    
	/** 
	 * 删除Transportationcompany
	 **/
    public void deleteById(java.lang.Long id) {
        this.transportationcompanyDao.deleteById(id);
    }
    
	/** 
	 * 根据ID得到Transportationcompany
	 **/    
    public Transportationcompany getById(java.lang.Long id) {
        return this.transportationcompanyDao.getById(id);
    }
    
	/** 
	 * 统计总数Transportationcompany
	 **/ 
	public Long count(PageQuery query) {
		return transportationcompanyDao.count(query);
	}
	
	/** 
	 * list Transportationcompany
	 **/ 
	public List<Transportationcompany> list(PageQuery query) {
		return transportationcompanyDao.list(query);
	}
	
	/** 
	 * 分页查询: Transportationcompany
	 **/      
	@Transactional(readOnly=true)
	public PageList<Transportationcompany> findPage(TransportationcompanyQuery query) {
	    Assert.notNull(query,"'query' must be not null");
		return new PageList<Transportationcompany>(list(query), 
				query.getPage(), query.getPageSize(), count(query));
	}
	
}
