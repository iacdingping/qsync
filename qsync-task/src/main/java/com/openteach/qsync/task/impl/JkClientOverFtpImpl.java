package com.openteach.qsync.task.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openteach.qcity.qsync.common.api.TaskStatus;
import com.openteach.qsync.api.JkfClientOverFtp;
import com.openteach.qsync.task.db.TaskStorageOverDatabase;

@Service
public class JkClientOverFtpImpl extends JkfClientOverFtp{

	@Autowired
	private TaskStorageOverDatabase storage;
	
	@Override
	public boolean updateStatus(String businessNo, TaskStatus status,
			String message) {
		return storage.updateStatus(businessNo, status, message);
	}

}
