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
public class TransportationDaoTest extends SpringTransactionalTestCase{
	@Autowired
	private TransportationDao transportationDao;

	/**
	 * 注意只能单个库测试
	 * 因为对删除使用到count方法计数进行对比
	 * @throws Exception
	 */
	@Test
	public void transportationCurl() throws Exception {
		TransportationQuery query = new TransportationQuery();
		long startRows = transportationDao.count(query);
		List<Transportation> lists = transportationDao.list(query);
		assertEquals(lists.size(), startRows);
		
		Transportation transportation = new Transportation();
		/** id */
		/** name */
		transportation.setName("1");
		/** picurl */
		transportation.setPicurl("1");
		/** remark */
		transportation.setRemark("1");
		/** freeshipping */
		transportation.setFreeshipping("1");
		/** isdeleted */
		transportation.setIsdeleted("1");
		/** createDatetime */
		transportation.setCreateDatetime(new java.util.Date());
		/** updatedatetime */
		transportation.setUpdatedatetime(new java.util.Date());
		
		transportationDao.save(transportation);
		long saveRows = transportationDao.count(query);
		assertEquals(startRows + 1, saveRows);
		
		Transportation TransportationQueried = transportationDao.getById(transportation.getId());
		assertNotNull("查询错误", TransportationQueried);
		assertEquals(TransportationQueried.getId(), transportation.getId());
		assertEquals(TransportationQueried.getName(), transportation.getName());
		assertEquals(TransportationQueried.getPicurl(), transportation.getPicurl());
		assertEquals(TransportationQueried.getRemark(), transportation.getRemark());
		assertEquals(TransportationQueried.getFreeshipping(), transportation.getFreeshipping());
		assertEquals(TransportationQueried.getIsdeleted(), transportation.getIsdeleted());
		assertEquals(TransportationQueried.getCreateDatetime(), transportation.getCreateDatetime());
		assertEquals(TransportationQueried.getUpdatedatetime(), transportation.getUpdatedatetime());
		
		/** name */
		transportation.setName("2");
		/** picurl */
		transportation.setPicurl("2");
		/** remark */
		transportation.setRemark("2");
		/** freeshipping */
		transportation.setFreeshipping("2");
		/** isdeleted */
		transportation.setIsdeleted("2");
		/** createDatetime */
		transportation.setCreateDatetime(new java.util.Date());
		/** updatedatetime */
		transportation.setUpdatedatetime(new java.util.Date());
		
		transportationDao.update(transportation);
		Transportation transportationUpdated = transportationDao.getById(transportation.getId());
		assertEquals(transportationUpdated.getName(), transportation.getName());
		assertEquals(transportationUpdated.getPicurl(), transportation.getPicurl());
		assertEquals(transportationUpdated.getRemark(), transportation.getRemark());
		assertEquals(transportationUpdated.getFreeshipping(), transportation.getFreeshipping());
		assertEquals(transportationUpdated.getIsdeleted(), transportation.getIsdeleted());
		assertEquals(transportationUpdated.getCreateDatetime(), transportation.getCreateDatetime());
		assertEquals(transportationUpdated.getUpdatedatetime(), transportation.getUpdatedatetime());
		
		//delete
		transportationDao.deleteById(transportation.getId());
		long deleteRows = transportationDao.count(query);
		assertEquals(startRows, deleteRows);
	}
}
