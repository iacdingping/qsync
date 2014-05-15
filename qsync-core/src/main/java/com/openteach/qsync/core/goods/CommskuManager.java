package com.openteach.qsync.core.goods;

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
public class CommskuManager {

	@Autowired
	private CommskuDao commskuDao;
	@Autowired
	private CommodityDao commodityDao;
	
	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性,请注意大小写*/
	public void setCommskuDao(CommskuDao dao) {
		this.commskuDao = dao;
	}
	
	/** 
	 * 创建Commsku
	 **/
	public Commsku save(Commsku commsku) {
	    Assert.notNull(commsku,"'commsku' must be not null");
	    this.commskuDao.save(commsku);
	    return commsku;
	}
	
	/** 
	 * 更新Commsku
	 **/	
    public Commsku update(Commsku commsku) {
        Assert.notNull(commsku,"'commsku' must be not null");
        this.commskuDao.update(commsku);
        return commsku;
    }	
    
	/** 
	 * 删除Commsku
	 **/
    public void deleteById(java.lang.Long id) {
        this.commskuDao.deleteById(id);
    }
    
	/** 
	 * 根据ID得到Commsku
	 **/    
    public Commsku getById(java.lang.Long id) {
        return this.commskuDao.getById(id);
    }
    
    /** 
	 * 根据ID得到Commsku 并且映射Commodity
	 **/    
    public Commsku getByIdMappedCommodity(Long id) {
    	Commsku commsku = commskuDao.getById(id);
    	Commodity commodity = commodityDao.getById(commsku.getItemId());
    	commsku.setCommodity(commodity);
    	return commsku;
	}
    
	/** 
	 * 统计总数Commsku
	 **/ 
	public Long count(PageQuery query) {
		return commskuDao.count(query);
	}
	
	/** 
	 * list Commsku
	 **/ 
	public List<Commsku> list(PageQuery query) {
		return commskuDao.list(query);
	}
	
	/** 
	 * 分页查询: Commsku
	 **/      
	@Transactional(readOnly=true)
	public PageList<Commsku> findPage(CommskuQuery query) {
	    Assert.notNull(query,"'query' must be not null");
		return new PageList<Commsku>(list(query), 
				query.getPage(), query.getPageSize(), count(query));
	}
}
