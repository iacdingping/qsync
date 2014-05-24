package com.openteach.qsync.task;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.test.annotation.DirtiesContext;

@DirtiesContext
public class SchedulerTest extends SpringTransactionalTestCase {

	@Resource
	private Scheduler scheduler;
	
	@Test
	public void test() throws Exception {
		
		Thread.sleep(1000 * 60 * 5);
		
		scheduler.shutdown();
	}

}
