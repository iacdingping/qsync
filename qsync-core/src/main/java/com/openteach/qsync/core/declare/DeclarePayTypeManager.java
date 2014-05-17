package com.openteach.qsync.core.declare;

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
public class DeclarePayTypeManager {

	@Autowired
	private DeclarePayTypeDao declarePayTypeDao;
	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性,请注意大小写*/
	public void setDeclarePayTypeDao(DeclarePayTypeDao dao) {
		this.declarePayTypeDao = dao;
	}
	
	/** 
	 * 创建DeclarePayType
	 **/
	public DeclarePayType save(DeclarePayType declarePayType) {
	    Assert.notNull(declarePayType,"'declarePayType' must be not null");
	    this.declarePayTypeDao.save(declarePayType);
	    return declarePayType;
	}
	
	/** 
	 * 更新DeclarePayType
	 **/	
    public DeclarePayType update(DeclarePayType declarePayType) {
        Assert.notNull(declarePayType,"'declarePayType' must be not null");
        this.declarePayTypeDao.update(declarePayType);
        return declarePayType;
    }	
    
	/** 
	 * 删除DeclarePayType
	 **/
    public void deleteById(java.lang.Long id) {
        this.declarePayTypeDao.deleteById(id);
    }
    
	/** 
	 * 根据ID得到DeclarePayType
	 **/    
    public DeclarePayType getById(java.lang.Long id) {
        return this.declarePayTypeDao.getById(id);
    }
    
	/** 
	 * 统计总数DeclarePayType
	 **/ 
	public Long count(PageQuery query) {
		return declarePayTypeDao.count(query);
	}
	
	/** 
	 * list DeclarePayType
	 **/ 
	public List<DeclarePayType> list(PageQuery query) {
		return declarePayTypeDao.list(query);
	}
	
	/** 
	 * 分页查询: DeclarePayType
	 **/      
	@Transactional(readOnly=true)
	public PageList<DeclarePayType> findPage(DeclarePayTypeQuery query) {
	    Assert.notNull(query,"'query' must be not null");
		return new PageList<DeclarePayType>(list(query), 
				query.getPage(), query.getPageSize(), count(query));
	}

	/**
	 * 
	 * @param platformPayType 平台支付方式
	 * @return 海关定义的支付方式
	 */
	public DeclarePayType getDeclarePayType(Integer platformPayType) {
		if(platformPayType == null) return getDefaultDeclarePayType();
		
		DeclarePayTypeQuery query = new DeclarePayTypeQuery();
		query.setPlatformPayType(platformPayType);
		List<DeclarePayType> result = this.list(query);
		return result.isEmpty() ? getDefaultDeclarePayType() : result.get(0);
	}
	
	public DeclarePayType getDefaultDeclarePayType() {
		DeclarePayType declarePayType = new DeclarePayType();
		declarePayType.setPlatformPayCompanyCode("Unknown pay company code");
		declarePayType.setDeclarePayType(DeclarePayTypeEmun.OTHER.getType());
		return declarePayType;
	}
}
