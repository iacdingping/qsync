package com.openteach.qsync.core.manager.goods;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.openteach.qsync.core.PageList;
import com.openteach.qsync.core.PageQuery;
import com.openteach.qsync.core.dao.goods.UnitDao;
import com.openteach.qsync.core.entity.goods.Unit;
import com.openteach.qsync.core.query.goods.UnitQuery;


/**
 *
 * @author dingp email:dingp@51box.cn
 * @version 1.0
 * @since 1.0
 * */
@Service
@Transactional
public class UnitManager {

	@Autowired
	private UnitDao unitDao;
	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性,请注意大小写*/
	public void setUnitDao(UnitDao dao) {
		this.unitDao = dao;
	}
	
	/** 
	 * 创建Unit
	 **/
	public Unit save(Unit unit) {
	    Assert.notNull(unit,"'unit' must be not null");
	    this.unitDao.save(unit);
	    return unit;
	}
	
	/** 
	 * 更新Unit
	 **/	
    public Unit update(Unit unit) {
        Assert.notNull(unit,"'unit' must be not null");
        this.unitDao.update(unit);
        return unit;
    }	
    
	/** 
	 * 删除Unit
	 **/
    public void deleteById(java.lang.Long id) {
        this.unitDao.deleteById(id);
    }
    
	/** 
	 * 根据ID得到Unit
	 **/    
    public Unit getById(java.lang.Long id) {
        return this.unitDao.getById(id);
    }
    
	/** 
	 * 统计总数Unit
	 **/ 
	public Long count(PageQuery query) {
		return unitDao.count(query);
	}
	
	/** 
	 * list Unit
	 **/ 
	public List<Unit> list(PageQuery query) {
		return unitDao.list(query);
	}
	
	/** 
	 * 分页查询: Unit
	 **/      
	@Transactional(readOnly=true)
	public PageList<Unit> findPage(UnitQuery query) {
	    Assert.notNull(query,"'query' must be not null");
		return new PageList<Unit>(list(query), 
				query.getPage(), query.getPageSize(), count(query));
	}
	
}
