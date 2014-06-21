package com.openteach.qsync.core.logistics;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;

import com.openteach.qsync.core.SpringTransactionalTestCase;
import com.openteach.qsync.core.dao.logistics.TransportationDao;
import com.openteach.qsync.core.entity.logistics.Transportation;
import com.openteach.qsync.core.query.logistics.TransportationQuery;
import com.openteach.qsync.util.common.DateUtil;

/**
 *
 * @author dingp email:dingp@51box.cn
 * @version 1.0
 * @since 1.0
 * */
@DirtiesContext
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
		/** 运输工具航次(班)号 */
		transportation.setToolFltNo("1");
		/** 参照运输方式代码表(TRANSF) */
		transportation.setTypeCode("1");
		/** 包装种类 1 木箱 2 纸箱 3 桶装 4 散装 5 托盘 6 包 7 其它 */
		transportation.setPackType("1");
		/** 申请单编号 保税进口必填，指仓储企业事先在辅助系统申请的分送集报申请单编号 */
		transportation.setApplicationFormNo("1");
		
		transportationDao.save(transportation);
		long saveRows = transportationDao.count(query);
		assertEquals(startRows + 1, saveRows);
		
		Transportation transportationQueried = transportationDao.getById(transportation.getId());
		assertNotNull("查询错误", transportationQueried);
			assertEquals(transportationQueried.getId(), transportation.getId());
			assertEquals(transportationQueried.getName(), transportation.getName());
			assertEquals(transportationQueried.getPicurl(), transportation.getPicurl());
			assertEquals(transportationQueried.getRemark(), transportation.getRemark());
			assertEquals(transportationQueried.getFreeshipping(), transportation.getFreeshipping());
			assertEquals(transportationQueried.getIsdeleted(), transportation.getIsdeleted());
			assertEquals(DateUtil.format(transportationQueried.getCreateDatetime(), "yyyy-mm-dd HH:MM"), 
				DateUtil.format(transportation.getCreateDatetime(), "yyyy-mm-dd HH:MM"));
			assertEquals(DateUtil.format(transportationQueried.getUpdatedatetime(), "yyyy-mm-dd HH:MM"), 
				DateUtil.format(transportation.getUpdatedatetime(), "yyyy-mm-dd HH:MM"));
			assertEquals(transportationQueried.getToolFltNo(), transportation.getToolFltNo());
			assertEquals(transportationQueried.getTypeCode(), transportation.getTypeCode());
			assertEquals(transportationQueried.getFromCountry(), transportation.getFromCountry());
			assertEquals(transportationQueried.getPackType(), transportation.getPackType());
			assertEquals(transportationQueried.getApplicationFormNo(), transportation.getApplicationFormNo());
		
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
		/** 运输工具航次(班)号 */
		transportation.setToolFltNo("2");
		/** 参照运输方式代码表(TRANSF) */
		transportation.setTypeCode("2");
		/** 包装种类 1 木箱 2 纸箱 3 桶装 4 散装 5 托盘 6 包 7 其它 */
		transportation.setPackType("2");
		/** 申请单编号 保税进口必填，指仓储企业事先在辅助系统申请的分送集报申请单编号 */
		transportation.setApplicationFormNo("2");
		
		transportationDao.update(transportation);
		Transportation transportationUpdated = transportationDao.getById(transportation.getId());
		assertEquals(transportationUpdated.getName(), transportation.getName());
		assertEquals(transportationUpdated.getPicurl(), transportation.getPicurl());
		assertEquals(transportationUpdated.getRemark(), transportation.getRemark());
		assertEquals(transportationUpdated.getFreeshipping(), transportation.getFreeshipping());
		assertEquals(transportationUpdated.getIsdeleted(), transportation.getIsdeleted());
		assertEquals(DateUtil.format(transportationUpdated.getCreateDatetime(), "yyyy-mm-dd HH:MM"), 
			DateUtil.format(transportationUpdated.getCreateDatetime(), "yyyy-mm-dd HH:MM"));
		assertEquals(DateUtil.format(transportationUpdated.getUpdatedatetime(), "yyyy-mm-dd HH:MM"), 
			DateUtil.format(transportationUpdated.getUpdatedatetime(), "yyyy-mm-dd HH:MM"));
		assertEquals(transportationUpdated.getToolFltNo(), transportation.getToolFltNo());
		assertEquals(transportationUpdated.getTypeCode(), transportation.getTypeCode());
		assertEquals(transportationUpdated.getFromCountry(), transportation.getFromCountry());
		assertEquals(transportationUpdated.getPackType(), transportation.getPackType());
		assertEquals(transportationUpdated.getApplicationFormNo(), transportation.getApplicationFormNo());
		
		//delete
		transportationDao.deleteById(transportation.getId());
		long deleteRows = transportationDao.count(query);
		assertEquals(startRows, deleteRows);
	}
}
