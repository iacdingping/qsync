/*
 * Powered By china-telcom
 * Since 2012 - 2014
 */

package com.openteach.qsync.core.order;

import com.openteach.qsync.core.order.Orderfreightquotation;
import com.openteach.qsync.core.order.OrderfreightquotationDao;
import com.openteach.qsync.core.order.OrderfreightquotationManager;
import com.openteach.qsync.core.order.OrderfreightquotationQuery;


import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springside.modules.test.spring.SpringTransactionalTestCase;

/**
 *
 * @author dingp email:dingp@51box.cn
 * @version 1.0
 * @since 1.0
 * */
@DirtiesContext
@ContextConfiguration(locations = { "classpath:spring/applicationContext-dao.xml" })
public class OrderfreightquotationDaoTest extends SpringTransactionalTestCase{
	@Autowired
	private OrderfreightquotationDao orderfreightquotationDao;

	/**
	 * 注意只能单个库测试
	 * 因为对删除使用到count方法计数进行对比
	 * @throws Exception
	 */
	@Test
	public void orderfreightquotationCurl() throws Exception {
		OrderfreightquotationQuery query = new OrderfreightquotationQuery();
		long startRows = orderfreightquotationDao.count(query);
		List<Orderfreightquotation> lists = orderfreightquotationDao.list(query);
		assertEquals(lists.size(), startRows);
		
		Orderfreightquotation orderfreightquotation = new Orderfreightquotation();
		/** id */
		/** ccorderId */
		orderfreightquotation.setCcorderId(1L);
		/** freightquotationId */
		orderfreightquotation.setFreightquotationId(1L);
		/** freight */
		orderfreightquotation.setFreight(1);
		/** createDatetime */
		orderfreightquotation.setCreateDatetime(new java.util.Date());
		/** updatedatetime */
		orderfreightquotation.setUpdatedatetime(new java.util.Date());
		
		orderfreightquotationDao.save(orderfreightquotation);
		long saveRows = orderfreightquotationDao.count(query);
		assertEquals(startRows + 1, saveRows);
		
		Orderfreightquotation OrderfreightquotationQueried = orderfreightquotationDao.getById(orderfreightquotation.getId());
		assertNotNull("查询错误", OrderfreightquotationQueried);
		assertEquals(OrderfreightquotationQueried.getId(), orderfreightquotation.getId());
		assertEquals(OrderfreightquotationQueried.getCcorderId(), orderfreightquotation.getCcorderId());
		assertEquals(OrderfreightquotationQueried.getFreightquotationId(), orderfreightquotation.getFreightquotationId());
		assertEquals(OrderfreightquotationQueried.getFreight(), orderfreightquotation.getFreight());
		assertEquals(OrderfreightquotationQueried.getCreateDatetime(), orderfreightquotation.getCreateDatetime());
		assertEquals(OrderfreightquotationQueried.getUpdatedatetime(), orderfreightquotation.getUpdatedatetime());
		
		/** ccorderId */
		orderfreightquotation.setCcorderId(2L);
		/** freightquotationId */
		orderfreightquotation.setFreightquotationId(2L);
		/** freight */
		orderfreightquotation.setFreight(2);
		/** createDatetime */
		orderfreightquotation.setCreateDatetime(new java.util.Date());
		/** updatedatetime */
		orderfreightquotation.setUpdatedatetime(new java.util.Date());
		
		orderfreightquotationDao.update(orderfreightquotation);
		Orderfreightquotation orderfreightquotationUpdated = orderfreightquotationDao.getById(orderfreightquotation.getId());
		assertEquals(orderfreightquotationUpdated.getCcorderId(), orderfreightquotation.getCcorderId());
		assertEquals(orderfreightquotationUpdated.getFreightquotationId(), orderfreightquotation.getFreightquotationId());
		assertEquals(orderfreightquotationUpdated.getFreight(), orderfreightquotation.getFreight());
		assertEquals(orderfreightquotationUpdated.getCreateDatetime(), orderfreightquotation.getCreateDatetime());
		assertEquals(orderfreightquotationUpdated.getUpdatedatetime(), orderfreightquotation.getUpdatedatetime());
		
		//delete
		orderfreightquotationDao.deleteById(orderfreightquotation.getId());
		long deleteRows = orderfreightquotationDao.count(query);
		assertEquals(startRows, deleteRows);
	}
}
