package com.openteach.qsync.core.manager.system;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.openteach.qsync.core.PageList;
import com.openteach.qsync.core.PageQuery;
import com.openteach.qsync.core.dao.system.CcSyncTaksDao;
import com.openteach.qsync.core.entity.system.CcSyncTaks;
import com.openteach.qsync.core.query.system.CcSyncTaksQuery;


/**
 *
 * @author dingp email:dingp@51box.cn
 * @version 1.0
 * @since 1.0
 * */
@Service
@Transactional
public class CcSyncTaksManager {

	@Autowired
	private CcSyncTaksDao ccSyncTaksDao;
	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性,请注意大小写*/
	public void setCcSyncTaksDao(CcSyncTaksDao dao) {
		this.ccSyncTaksDao = dao;
	}
	
	/** 
	 * 创建CcSyncTaks
	 **/
	public CcSyncTaks save(CcSyncTaks ccSyncTaks) {
	    Assert.notNull(ccSyncTaks,"'ccSyncTaks' must be not null");
	    this.ccSyncTaksDao.save(ccSyncTaks);
	    return ccSyncTaks;
	}
	
	/** 
	 * 更新CcSyncTaks
	 **/	
    public CcSyncTaks update(CcSyncTaks ccSyncTaks) {
        Assert.notNull(ccSyncTaks,"'ccSyncTaks' must be not null");
        this.ccSyncTaksDao.update(ccSyncTaks);
        return ccSyncTaks;
    }	
    
	/** 
	 * 删除CcSyncTaks
	 **/
    public void deleteById(java.lang.Long id) {
        this.ccSyncTaksDao.deleteById(id);
    }
    
	/** 
	 * 根据ID得到CcSyncTaks
	 **/    
    public CcSyncTaks getById(java.lang.Long id) {
        return this.ccSyncTaksDao.getById(id);
    }
    
	/** 
	 * 统计总数CcSyncTaks
	 **/ 
	public Long count(PageQuery query) {
		return ccSyncTaksDao.count(query);
	}
	
	/** 
	 * list CcSyncTaks
	 **/ 
	public List<CcSyncTaks> list(PageQuery query) {
		return ccSyncTaksDao.list(query);
	}
	
	/** 
	 * 分页查询: CcSyncTaks
	 **/      
	@Transactional(readOnly=true)
	public PageList<CcSyncTaks> findPage(CcSyncTaksQuery query) {
	    Assert.notNull(query,"'query' must be not null");
		return new PageList<CcSyncTaks>(list(query), 
				query.getPage(), query.getPageSize(), count(query));
	}
}
