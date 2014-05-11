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
public class CityManager {

	@Autowired
	private CityDao cityDao;
	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性,请注意大小写*/
	public void setCityDao(CityDao dao) {
		this.cityDao = dao;
	}
	
	/** 
	 * 创建City
	 **/
	public City save(City city) {
	    Assert.notNull(city,"'city' must be not null");
	    this.cityDao.save(city);
	    return city;
	}
	
	/** 
	 * 更新City
	 **/	
    public City update(City city) {
        Assert.notNull(city,"'city' must be not null");
        this.cityDao.update(city);
        return city;
    }	
    
	/** 
	 * 删除City
	 **/
    public void deleteById(java.lang.Long id) {
        this.cityDao.deleteById(id);
    }
    
	/** 
	 * 根据ID得到City
	 **/    
    public City getById(java.lang.Long id) {
        return this.cityDao.getById(id);
    }
    
	/** 
	 * 统计总数City
	 **/ 
	public Long count(PageQuery query) {
		return cityDao.count(query);
	}
	
	/** 
	 * list City
	 **/ 
	public List<City> list(PageQuery query) {
		return cityDao.list(query);
	}
	
	/** 
	 * 分页查询: City
	 **/      
	@Transactional(readOnly=true)
	public PageList<City> findPage(CityQuery query) {
	    Assert.notNull(query,"'query' must be not null");
		return new PageList<City>(list(query), 
				query.getPage(), query.getPageSize(), count(query));
	}
}
