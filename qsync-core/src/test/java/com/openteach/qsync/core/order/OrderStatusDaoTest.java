package com.openteach.qsync.core.order;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;

import com.openteach.qsync.core.SpringTransactionalTestCase;
import com.openteach.qsync.core.dao.order.OrderStatusDao;
import com.openteach.qsync.core.entity.order.OrderStatus;
import com.openteach.qsync.core.query.order.OrderStatusQuery;
import com.openteach.qsync.util.common.DateUtil;

/**
 *
 * @author dingp email:dingp@51box.cn
 * @version 1.0
 * @since 1.0
 * */
@DirtiesContext
public class OrderStatusDaoTest extends SpringTransactionalTestCase{
	@Autowired
	private OrderStatusDao orderStatusDao;
	
	/**
	 * 注意只能单个库测试
	 * 因为对删除使用到count方法计数进行对比
	 * @throws Exception
	 */
	@Test
	public void orderStatusCurl() throws Exception {
		OrderStatusQuery query = new OrderStatusQuery();
		long startRows = orderStatusDao.count(query);
		List<OrderStatus> lists = orderStatusDao.list(query);
		assertEquals(lists.size(), startRows);
		
		OrderStatus orderStatus = new OrderStatus();
		/** id */
		/** status */
		orderStatus.setStatus(1);
		/** orderId */
		orderStatus.setOrderId(1L);
		/** creatoradmin */
		orderStatus.setCreatoradmin(1L);
		/** createdatetime */
		orderStatus.setCreatedatetime(new java.util.Date());
		
		orderStatusDao.save(orderStatus);
		long saveRows = orderStatusDao.count(query);
		assertEquals(startRows + 1, saveRows);
		
		OrderStatus orderStatusQueried = orderStatusDao.getById(orderStatus.getId());
		assertNotNull("查询错误", orderStatusQueried);
			assertEquals(orderStatusQueried.getId(), orderStatus.getId());
			assertEquals(orderStatusQueried.getStatus(), orderStatus.getStatus());
			assertEquals(orderStatusQueried.getOrderId(), orderStatus.getOrderId());
			assertEquals(orderStatusQueried.getCreatoradmin(), orderStatus.getCreatoradmin());
			assertEquals(DateUtil.format(orderStatusQueried.getCreatedatetime(), "yyyy-mm-dd HH:MM"), 
				DateUtil.format(orderStatus.getCreatedatetime(), "yyyy-mm-dd HH:MM"));
		
		/** status */
		orderStatus.setStatus(2);
		/** orderId */
		orderStatus.setOrderId(2L);
		/** creatoradmin */
		orderStatus.setCreatoradmin(2L);
		/** createdatetime */
		orderStatus.setCreatedatetime(new java.util.Date());
		
		orderStatusDao.update(orderStatus);
		OrderStatus orderStatusUpdated = orderStatusDao.getById(orderStatus.getId());
		assertEquals(orderStatusUpdated.getStatus(), orderStatus.getStatus());
		assertEquals(orderStatusUpdated.getOrderId(), orderStatus.getOrderId());
		assertEquals(orderStatusUpdated.getCreatoradmin(), orderStatus.getCreatoradmin());
		assertEquals(DateUtil.format(orderStatusUpdated.getCreatedatetime(), "yyyy-mm-dd HH:MM"), 
			DateUtil.format(orderStatusUpdated.getCreatedatetime(), "yyyy-mm-dd HH:MM"));
		
		//delete
		orderStatusDao.deleteById(orderStatus.getId());
		long deleteRows = orderStatusDao.count(query);
		assertEquals(startRows, deleteRows);
	}
}
