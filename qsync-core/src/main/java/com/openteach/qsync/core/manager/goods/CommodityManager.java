package com.openteach.qsync.core.manager.goods;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.openteach.qsync.core.PageList;
import com.openteach.qsync.core.PageQuery;
import com.openteach.qsync.core.dao.goods.CommodityDao;
import com.openteach.qsync.core.entity.goods.Commodity;
import com.openteach.qsync.core.query.goods.CommodityQuery;


/**
 *
 * @author dingp email:dingp@51box.cn
 * @version 1.0
 * @since 1.0
 * */
@Service
@Transactional
public class CommodityManager {

	@Autowired
	private CommodityDao commodityDao;
	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性,请注意大小写*/
	public void setCommodityDao(CommodityDao dao) {
		this.commodityDao = dao;
	}
	
	/** 
	 * 创建Commodity
	 **/
	public Commodity save(Commodity commodity) {
	    Assert.notNull(commodity,"'commodity' must be not null");
	    this.commodityDao.save(commodity);
	    return commodity;
	}
	
	/** 
	 * 更新Commodity
	 **/	
    public Commodity update(Commodity commodity) {
        Assert.notNull(commodity,"'commodity' must be not null");
        this.commodityDao.update(commodity);
        return commodity;
    }	
    
	/** 
	 * 删除Commodity
	 **/
    public void deleteById(java.lang.Long id) {
        this.commodityDao.deleteById(id);
    }
    
	/** 
	 * 根据ID得到Commodity
	 **/    
    public Commodity getById(java.lang.Long id) {
        return this.commodityDao.getById(id);
    }
    
	/** 
	 * 统计总数Commodity
	 **/ 
	public Long count(PageQuery query) {
		return commodityDao.count(query);
	}
	
	/** 
	 * list Commodity
	 **/ 
	public List<Commodity> list(PageQuery query) {
		return commodityDao.list(query);
	}
	
	/** 
	 * 分页查询: Commodity
	 **/      
	@Transactional(readOnly=true)
	public PageList<Commodity> findPage(CommodityQuery query) {
	    Assert.notNull(query,"'query' must be not null");
		return new PageList<Commodity>(list(query), 
				query.getPage(), query.getPageSize(), count(query));
	}
	
    
}
