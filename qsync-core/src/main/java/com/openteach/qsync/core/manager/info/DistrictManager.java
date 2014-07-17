package com.openteach.qsync.core.manager.info;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.openteach.qsync.core.PageList;
import com.openteach.qsync.core.PageQuery;
import com.openteach.qsync.core.dao.info.DistrictDao;
import com.openteach.qsync.core.entity.info.District;
import com.openteach.qsync.core.query.info.DistrictQuery;


/**
 *
 * @author dingp email:dingp@51box.cn
 * @version 1.0
 * @since 1.0
 * */
@Service
@Transactional
public class DistrictManager {

	@Autowired
	private DistrictDao districtDao;
	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性,请注意大小写*/
	public void setDistrictDao(DistrictDao dao) {
		this.districtDao = dao;
	}
	
	/** 
	 * 创建District
	 **/
	public District save(District district) {
	    Assert.notNull(district,"'district' must be not null");
	    this.districtDao.save(district);
	    return district;
	}
	
	/** 
	 * 更新District
	 **/	
    public District update(District district) {
        Assert.notNull(district,"'district' must be not null");
        this.districtDao.update(district);
        return district;
    }	
    
	/** 
	 * 删除District
	 **/
    public void deleteById(java.lang.Long id) {
        this.districtDao.deleteById(id);
    }
    
	/** 
	 * 根据ID得到District
	 **/    
    public District getById(java.lang.Long id) {
        return this.districtDao.getById(id);
    }
    
	/** 
	 * 统计总数District
	 **/ 
	public Long count(PageQuery query) {
		return districtDao.count(query);
	}
	
	/** 
	 * list District
	 **/ 
	public List<District> list(PageQuery query) {
		return districtDao.list(query);
	}
	
	/** 
	 * 分页查询: District
	 **/      
	@Transactional(readOnly=true)
	public PageList<District> findPage(DistrictQuery query) {
	    Assert.notNull(query,"'query' must be not null");
		return new PageList<District>(list(query), 
				query.getPage(), query.getPageSize(), count(query));
	}
	
}
