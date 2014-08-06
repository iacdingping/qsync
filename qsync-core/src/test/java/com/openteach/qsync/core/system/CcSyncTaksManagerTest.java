package com.openteach.qsync.core.system;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;

import com.openteach.qcity.qsync.common.api.TaskStatus;
import com.openteach.qsync.core.SpringTransactionalTestCase;
import com.openteach.qsync.core.manager.system.CcSyncTaksManager;

@DirtiesContext
public class CcSyncTaksManagerTest extends SpringTransactionalTestCase {

	@Autowired
	CcSyncTaksManager ccSyncTaksManager;
	
	@Test
	public void updateStatusTest() {
		ccSyncTaksManager.updateStatus("-1", TaskStatus.DATA_ERROR, "数据错误", false, "");
		ccSyncTaksManager.updateStatus("-1", TaskStatus.DATA_ERROR, "数据错误", true, "");
	}
}
