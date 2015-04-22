package com.openteach.qsync.core.order;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;

import com.openteach.qsync.api.ExaminationState;
import com.openteach.qsync.core.SpringTransactionalTestCase;
import com.openteach.qsync.core.manager.order.OrderManager;

@DirtiesContext
public class OrderManagerTest extends SpringTransactionalTestCase {

	@Autowired
	private OrderManager orderManager;
	
	@Test
	public void test() {
		int count = orderManager.updateOrderStatus(1L, "11111", 6, ExaminationState.EXAMINATION_PASS, true);
		System.out.println("updated " + count);
	}
}
