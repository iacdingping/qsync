package com.openteach.qsync.core.info;

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
public class ProvinceManager {

	@Autowired
	private ProvinceDao provinceDao;
	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性,请注意大小写*/
	public void setProvinceDao(ProvinceDao dao) {
		this.provinceDao = dao;
	}
	
	/** 
	 * 创建Province
	 **/
	public Province save(Province province) {
	    Assert.notNull(province,"'province' must be not null");
	    this.provinceDao.save(province);
	    return province;
	}
	
	/** 
	 * 更新Province
	 **/	
    public Province update(Province province) {
        Assert.notNull(province,"'province' must be not null");
        this.provinceDao.update(province);
        return province;
    }	
    
	/** 
	 * 删除Province
	 **/
    public void deleteById(java.lang.Long id) {
        this.provinceDao.deleteById(id);
    }
    
	/** 
	 * 根据ID得到Province
	 **/    
    public Province getById(java.lang.Long id) {
        return this.provinceDao.getById(id);
    }
    
	/** 
	 * 统计总数Province
	 **/ 
	public Long count(PageQuery query) {
		return provinceDao.count(query);
	}
	
	/** 
	 * list Province
	 **/ 
	public List<Province> list(PageQuery query) {
		return provinceDao.list(query);
	}
	
	/** 
	 * 分页查询: Province
	 **/      
	@Transactional(readOnly=true)
	public PageList<Province> findPage(ProvinceQuery query) {
	    Assert.notNull(query,"'query' must be not null");
		return new PageList<Province>(list(query), 
				query.getPage(), query.getPageSize(), count(query));
	}
}
