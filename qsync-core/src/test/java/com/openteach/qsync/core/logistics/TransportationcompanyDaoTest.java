package com.openteach.qsync.core.logistics;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;

import com.openteach.qsync.core.SpringTransactionalTestCase;

/**
 *
 * @author dingp email:dingp@51box.cn
 * @version 1.0
 * @since 1.0
 * */
@DirtiesContext
@ContextConfiguration(locations = { "classpath:spring/applicationContext-dao.xml" })
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
		
		Transportationcompany TransportationcompanyQueried = transportationcompanyDao.getById(transportationcompany.getId());
		assertNotNull("查询错误", TransportationcompanyQueried);
		assertEquals(TransportationcompanyQueried.getId(), transportationcompany.getId());
		assertEquals(TransportationcompanyQueried.getTransportationId(), transportationcompany.getTransportationId());
		assertEquals(TransportationcompanyQueried.getName(), transportationcompany.getName());
		assertEquals(TransportationcompanyQueried.getDay(), transportationcompany.getDay());
		assertEquals(TransportationcompanyQueried.getUrl(), transportationcompany.getUrl());
		assertEquals(TransportationcompanyQueried.getIsdeleted(), transportationcompany.getIsdeleted());
		assertEquals(TransportationcompanyQueried.getCreateDatetime(), transportationcompany.getCreateDatetime());
		assertEquals(TransportationcompanyQueried.getUpdatedatetime(), transportationcompany.getUpdatedatetime());
		assertEquals(TransportationcompanyQueried.getCode(), transportationcompany.getCode());
		assertEquals(TransportationcompanyQueried.getZipCode(), transportationcompany.getZipCode());
		
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
		assertEquals(transportationcompanyUpdated.getCreateDatetime(), transportationcompany.getCreateDatetime());
		assertEquals(transportationcompanyUpdated.getUpdatedatetime(), transportationcompany.getUpdatedatetime());
		assertEquals(transportationcompanyUpdated.getCode(), transportationcompany.getCode());
		assertEquals(transportationcompanyUpdated.getZipCode(), transportationcompany.getZipCode());
		
		//delete
		transportationcompanyDao.deleteById(transportationcompany.getId());
		long deleteRows = transportationcompanyDao.count(query);
		assertEquals(startRows, deleteRows);
	}
}
