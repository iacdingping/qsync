package com.openteach.qsync.task.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openteach.qcity.qsync.common.api.TaskStatus;
import com.openteach.qcity.qsync.common.api.TaskType;
import com.openteach.qsync.api.ExaminationState;
import com.openteach.qsync.api.JkfClientOverFtp;
import com.openteach.qsync.core.entity.system.CcSyncTaks;
import com.openteach.qsync.core.query.system.CcSyncTaksQuery;
import com.openteach.qsync.task.db.TaskStorageOverDatabase;

@Service
public class JkClientOverFtpImpl extends JkfClientOverFtp{

	private static final Log logger = LogFactory.getLog(JkClientOverFtpImpl.class);
	
	@Autowired
	private TaskStorageOverDatabase storage;
	
	@Override
	public boolean updateStatus(String businessNo, TaskStatus status,
			String message, String xmlResponse, ExaminationState state) {
		CcSyncTaksQuery query = new CcSyncTaksQuery();
		query.setBusinessNo(businessNo);
		List<CcSyncTaks> tasks = storage.query(query);
		if(tasks.size() == 0)
			return false;
		CcSyncTaks task = tasks.get(0);
		TaskStatus statusBefore = TaskStatus.valueOf(task.getStatus());
		if(statusBefore.isEndState() && statusBefore != TaskStatus.NOT_PASS) {
			logger.info(String.format("order [%s], businessNo [%s] status [%s] is final and not the NOT_PASS status, donot modify the status. to be change status [%s]", 
					task.getOrderId(), businessNo, task.getStatus(), status.name()));
			return true;
		}
		
		return storage.updateStatus(businessNo, status, message, task.getOrderId(), TaskType.valueOf(task.getType()), xmlResponse, state);
	}

}
