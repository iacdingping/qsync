package com.openteach.qsync.core.manager.goods;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.openteach.qsync.core.PageList;
import com.openteach.qsync.core.PageQuery;
import com.openteach.qsync.core.dao.goods.CategoryDao;
import com.openteach.qsync.core.entity.goods.Category;
import com.openteach.qsync.core.query.goods.CategoryQuery;


/**
 *
 * @author dingp email:dingp@51box.cn
 * @version 1.0
 * @since 1.0
 * */
@Service
@Transactional
public class CategoryManager {

	@Autowired
	private CategoryDao categoryDao;
	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性,请注意大小写*/
	public void setCategoryDao(CategoryDao dao) {
		this.categoryDao = dao;
	}
	
	/** 
	 * 创建Category
	 **/
	public Category save(Category category) {
	    Assert.notNull(category,"'category' must be not null");
	    this.categoryDao.save(category);
	    return category;
	}
	
	/** 
	 * 更新Category
	 **/	
    public Category update(Category category) {
        Assert.notNull(category,"'category' must be not null");
        this.categoryDao.update(category);
        return category;
    }	
    
	/** 
	 * 删除Category
	 **/
    public void deleteById(java.lang.Long id) {
        this.categoryDao.deleteById(id);
    }
    
	/** 
	 * 根据ID得到Category
	 **/    
    public Category getById(java.lang.Long id) {
        return this.categoryDao.getById(id);
    }
    
	/** 
	 * 统计总数Category
	 **/ 
	public Long count(PageQuery query) {
		return categoryDao.count(query);
	}
	
	/** 
	 * list Category
	 **/ 
	public List<Category> list(PageQuery query) {
		return categoryDao.list(query);
	}
	
	/** 
	 * 分页查询: Category
	 **/      
	@Transactional(readOnly=true)
	public PageList<Category> findPage(CategoryQuery query) {
	    Assert.notNull(query,"'query' must be not null");
		return new PageList<Category>(list(query), 
				query.getPage(), query.getPageSize(), count(query));
	}
	
}
