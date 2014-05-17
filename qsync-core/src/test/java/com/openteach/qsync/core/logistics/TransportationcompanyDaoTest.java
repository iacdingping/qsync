package com.openteach.qsync.core.logistics;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;

import com.openteach.qsync.core.SpringTransactionalTestCase;
import com.openteach.qsync.core.dao.logistics.TransportationcompanyDao;
import com.openteach.qsync.core.entity.logistics.Transportationcompany;
import com.openteach.qsync.core.query.logistics.TransportationcompanyQuery;
import com.openteach.qsync.util.common.DateUtil;

/**
 *
 * @author dingp email:dingp@51box.cn
 * @version 1.0
 * @since 1.0
 * */
@DirtiesContext
public class TransportationcompanyDaoTest extends SpringTransactionalTestCase{
	@Autowired
	private TransportationcompanyDao transportationcompanyDao;
	
	/**
	 * 注意只能单个库测试
	 * 因为对删除使用到count方法计数进行对比
	 * @throws Exception
	 */
	@Test
	public void transportationcompanyCurl() throws Exception {
		TransportationcompanyQuery query = new TransportationcompanyQuery();
		long startRows = transportationcompanyDao.count(query);
		List<Transportationcompany> lists = transportationcompanyDao.list(query);
		assertEquals(lists.size(), startRows);
		
		Transportationcompany transportationcompany = new Transportationcompany();
		/** id */
		/** transportationId */
		transportationcompany.setTransportationId(1L);
		/** name */
		transportationcompany.setName("1");
		/** day */
		transportationcompany.setDay("1");
		/** url */
		transportationcompany.setUrl("1");
		/** isdeleted */
		transportationcompany.setIsdeleted("1");
		/** createDatetime */
		transportationcompany.setCreateDatetime(new java.util.Date());
		/** updatedatetime */
		transportationcompany.setUpdatedatetime(new java.util.Date());
		/** 物流企业编号 */
		transportationcompany.setCode("1");
		/** 物流企业邮编 */
		transportationcompany.setZipCode("1");
		
		transportationcompanyDao.save(transportationcompany);
		long saveRows = transportationcompanyDao.count(query);
		assertEquals(startRows + 1, saveRows);
		
		Transportationcompany transportationcompanyQueried = transportationcompanyDao.getById(transportationcompany.getId());
		assertNotNull("查询错误", transportationcompanyQueried);
			assertEquals(transportationcompanyQueried.getId(), transportationcompany.getId());
			assertEquals(transportationcompanyQueried.getTransportationId(), transportationcompany.getTransportationId());
			assertEquals(transportationcompanyQueried.getName(), transportationcompany.getName());
			assertEquals(transportationcompanyQueried.getDay(), transportationcompany.getDay());
			assertEquals(transportationcompanyQueried.getUrl(), transportationcompany.getUrl());
			assertEquals(transportationcompanyQueried.getIsdeleted(), transportationcompany.getIsdeleted());
			assertEquals(DateUtil.format(transportationcompanyQueried.getCreateDatetime(), "yyyy-mm-dd HH:MM"), 
				DateUtil.format(transportationcompany.getCreateDatetime(), "yyyy-mm-dd HH:MM"));
			assertEquals(DateUtil.format(transportationcompanyQueried.getUpdatedatetime(), "yyyy-mm-dd HH:MM"), 
				DateUtil.format(transportationcompany.getUpdatedatetime(), "yyyy-mm-dd HH:MM"));
			assertEquals(transportationcompanyQueried.getCode(), transportationcompany.getCode());
			assertEquals(transportationcompanyQueried.getZipCode(), transportationcompany.getZipCode());
		
		/** transportationId */
		transportationcompany.setTransportationId(2L);
		/** name */
		transportationcompany.setName("2");
		/** day */
		transportationcompany.setDay("2");
		/** url */
		transportationcompany.setUrl("2");
		/** isdeleted */
		transportationcompany.setIsdeleted("2");
		/** createDatetime */
		transportationcompany.setCreateDatetime(new java.util.Date());
		/** updatedatetime */
		transportationcompany.setUpdatedatetime(new java.util.Date());
		/** 物流企业编号 */
		transportationcompany.setCode("2");
		/** 物流企业邮编 */
		transportationcompany.setZipCode("2");
		
		transportationcompanyDao.update(transportationcompany);
		Transportationcompany transportationcompanyUpdated = transportationcompanyDao.getById(transportationcompany.getId());
		assertEquals(transportationcompanyUpdated.getTransportationId(), transportationcompany.getTransportationId());
		assertEquals(transportationcompanyUpdated.getName(), transportationcompany.getName());
		assertEquals(transportationcompanyUpdated.getDay(), transportationcompany.getDay());
		assertEquals(transportationcompanyUpdated.getUrl(), transportationcompany.getUrl());
		assertEquals(transportationcompanyUpdated.getIsdeleted(), transportationcompany.getIsdeleted());
		assertEquals(DateUtil.format(transportationcompanyUpdated.getCreateDatetime(), "yyyy-mm-dd HH:MM"), 
			DateUtil.format(transportationcompanyUpdated.getCreateDatetime(), "yyyy-mm-dd HH:MM"));
		assertEquals(DateUtil.format(transportationcompanyUpdated.getUpdatedatetime(), "yyyy-mm-dd HH:MM"), 
			DateUtil.format(transportationcompanyUpdated.getUpdatedatetime(), "yyyy-mm-dd HH:MM"));
		assertEquals(transportationcompanyUpdated.getCode(), transportationcompany.getCode());
		assertEquals(transportationcompanyUpdated.getZipCode(), transportationcompany.getZipCode());
		
		//delete
		transportationcompanyDao.deleteById(transportationcompany.getId());
		long deleteRows = transportationcompanyDao.count(query);
		assertEquals(startRows, deleteRows);
	}
}
