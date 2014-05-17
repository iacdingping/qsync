package com.openteach.qsync.core.manager.logistics;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.openteach.qsync.core.PageList;
import com.openteach.qsync.core.PageQuery;
import com.openteach.qsync.core.dao.logistics.TransportCommodityDao;
import com.openteach.qsync.core.entity.logistics.TransportCommodity;
import com.openteach.qsync.core.query.logistics.TransportCommodityQuery;


/**
 *
 * @author dingp email:dingp@51box.cn
 * @version 1.0
 * @since 1.0
 * */
@Service
@Transactional
public class TransportCommodityManager {

	@Autowired
	private TransportCommodityDao transportCommodityDao;
	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性,请注意大小写*/
	public void setTransportCommodityDao(TransportCommodityDao dao) {
		this.transportCommodityDao = dao;
	}
	
	/** 
	 * 创建TransportCommodity
	 **/
	public TransportCommodity save(TransportCommodity transportCommodity) {
	    Assert.notNull(transportCommodity,"'transportCommodity' must be not null");
	    this.transportCommodityDao.save(transportCommodity);
	    return transportCommodity;
	}
	
	/** 
	 * 更新TransportCommodity
	 **/	
    public TransportCommodity update(TransportCommodity transportCommodity) {
        Assert.notNull(transportCommodity,"'transportCommodity' must be not null");
        this.transportCommodityDao.update(transportCommodity);
        return transportCommodity;
    }	
    
	/** 
	 * 删除TransportCommodity
	 **/
    public void deleteById(java.lang.Long id) {
        this.transportCommodityDao.deleteById(id);
    }
    
	/** 
	 * 根据ID得到TransportCommodity
	 **/    
    public TransportCommodity getById(java.lang.Long id) {
        return this.transportCommodityDao.getById(id);
    }
    
	/** 
	 * 统计总数TransportCommodity
	 **/ 
	public Long count(PageQuery query) {
		return transportCommodityDao.count(query);
	}
	
	/** 
	 * list TransportCommodity
	 **/ 
	public List<TransportCommodity> list(PageQuery query) {
		return transportCommodityDao.list(query);
	}
	
	/** 
	 * 分页查询: TransportCommodity
	 **/      
	@Transactional(readOnly=true)
	public PageList<TransportCommodity> findPage(TransportCommodityQuery query) {
	    Assert.notNull(query,"'query' must be not null");
		return new PageList<TransportCommodity>(list(query), 
				query.getPage(), query.getPageSize(), count(query));
	}

	public List<TransportCommodity> listByOrderTransport(Long ordertransport) {
		TransportCommodityQuery query = new TransportCommodityQuery();
		query.setTransportId(ordertransport);
		return list(query);
	}
	
}
