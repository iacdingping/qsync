package com.openteach.qsync.core.manager.info;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.openteach.qsync.core.PageList;
import com.openteach.qsync.core.PageQuery;
import com.openteach.qsync.core.dao.info.CountryDao;
import com.openteach.qsync.core.entity.info.Country;
import com.openteach.qsync.core.query.info.CountryQuery;


/**
 *
 * @author dingp email:dingp@51box.cn
 * @version 1.0
 * @since 1.0
 * */
@Service
@Transactional
public class CountryManager {

	@Autowired
	private CountryDao countryDao;
	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性,请注意大小写*/
	public void setCountryDao(CountryDao dao) {
		this.countryDao = dao;
	}
	
	/** 
	 * 创建Country
	 **/
	public Country save(Country country) {
	    Assert.notNull(country,"'country' must be not null");
	    this.countryDao.save(country);
	    return country;
	}
	
	/** 
	 * 更新Country
	 **/	
    public Country update(Country country) {
        Assert.notNull(country,"'country' must be not null");
        this.countryDao.update(country);
        return country;
    }	
    
	/** 
	 * 删除Country
	 **/
    public void deleteById(java.lang.Long id) {
        this.countryDao.deleteById(id);
    }
    
	/** 
	 * 根据ID得到Country
	 **/    
    public Country getById(java.lang.Long id) {
        return this.countryDao.getById(id);
    }
    
	/** 
	 * 统计总数Country
	 **/ 
	public Long count(PageQuery query) {
		return countryDao.count(query);
	}
	
	/** 
	 * list Country
	 **/ 
	public List<Country> list(PageQuery query) {
		return countryDao.list(query);
	}
	
	/** 
	 * 分页查询: Country
	 **/      
	@Transactional(readOnly=true)
	public PageList<Country> findPage(CountryQuery query) {
	    Assert.notNull(query,"'query' must be not null");
		return new PageList<Country>(list(query), 
				query.getPage(), query.getPageSize(), count(query));
	}
}
