/*
 * Powered By china-telcom
 * Since 2012 - 2014
 */

package com.openteach.qsync.core.pay;

import com.openteach.qsync.core.pay.Payment;
import com.openteach.qsync.core.pay.PaymentDao;
import com.openteach.qsync.core.pay.PaymentManager;
import com.openteach.qsync.core.pay.PaymentQuery;


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
public class PaymentDaoTest extends SpringTransactionalTestCase{
	@Autowired
	private PaymentDao paymentDao;

	/**
	 * 注意只能单个库测试
	 * 因为对删除使用到count方法计数进行对比
	 * @throws Exception
	 */
	@Test
	public void paymentCurl() throws Exception {
		PaymentQuery query = new PaymentQuery();
		long startRows = paymentDao.count(query);
		List<Payment> lists = paymentDao.list(query);
		assertEquals(lists.size(), startRows);
		
		Payment payment = new Payment();
		/** id */
		/** payerid */
		payment.setPayerid("1");
		/** payerstatus */
		payment.setPayerstatus(1);
		/** amount */
		payment.setAmount(1);
		/** stalutation */
		payment.setStalutation("1");
		/** paytime */
		payment.setPaytime(new java.util.Date());
		/** type */
		payment.setType(1);
		/** orderId */
		payment.setOrderId(1L);
		/** memberId */
		payment.setMemberId(1L);
		/** creatoradmin */
		payment.setCreatoradmin(1L);
		
		paymentDao.save(payment);
		long saveRows = paymentDao.count(query);
		assertEquals(startRows + 1, saveRows);
		
		Payment PaymentQueried = paymentDao.getById(payment.getId());
		assertNotNull("查询错误", PaymentQueried);
		assertEquals(PaymentQueried.getId(), payment.getId());
		assertEquals(PaymentQueried.getPayerid(), payment.getPayerid());
		assertEquals(PaymentQueried.getPayerstatus(), payment.getPayerstatus());
		assertEquals(PaymentQueried.getAmount(), payment.getAmount());
		assertEquals(PaymentQueried.getStalutation(), payment.getStalutation());
		assertEquals(PaymentQueried.getPaytime(), payment.getPaytime());
		assertEquals(PaymentQueried.getType(), payment.getType());
		assertEquals(PaymentQueried.getOrderId(), payment.getOrderId());
		assertEquals(PaymentQueried.getMemberId(), payment.getMemberId());
		assertEquals(PaymentQueried.getCreatoradmin(), payment.getCreatoradmin());
		
		/** payerid */
		payment.setPayerid("2");
		/** payerstatus */
		payment.setPayerstatus(2);
		/** amount */
		payment.setAmount(2);
		/** stalutation */
		payment.setStalutation("2");
		/** paytime */
		payment.setPaytime(new java.util.Date());
		/** type */
		payment.setType(2);
		/** orderId */
		payment.setOrderId(2L);
		/** memberId */
		payment.setMemberId(2L);
		/** creatoradmin */
		payment.setCreatoradmin(2L);
		
		paymentDao.update(payment);
		Payment paymentUpdated = paymentDao.getById(payment.getId());
		assertEquals(paymentUpdated.getPayerid(), payment.getPayerid());
		assertEquals(paymentUpdated.getPayerstatus(), payment.getPayerstatus());
		assertEquals(paymentUpdated.getAmount(), payment.getAmount());
		assertEquals(paymentUpdated.getStalutation(), payment.getStalutation());
		assertEquals(paymentUpdated.getPaytime(), payment.getPaytime());
		assertEquals(paymentUpdated.getType(), payment.getType());
		assertEquals(paymentUpdated.getOrderId(), payment.getOrderId());
		assertEquals(paymentUpdated.getMemberId(), payment.getMemberId());
		assertEquals(paymentUpdated.getCreatoradmin(), payment.getCreatoradmin());
		
		//delete
		paymentDao.deleteById(payment.getId());
		long deleteRows = paymentDao.count(query);
		assertEquals(startRows, deleteRows);
	}
}
