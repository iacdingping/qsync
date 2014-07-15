package com.openteach.qsync.task.db;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.openteach.qcity.qsync.common.api.TaskStatus;
import com.openteach.qcity.qsync.common.api.TaskType;
import com.openteach.qsync.core.entity.system.CcSyncTaks;
import com.openteach.qsync.core.manager.order.OrderManager;
import com.openteach.qsync.core.manager.system.CcSyncTaksManager;
import com.openteach.qsync.core.query.system.CcSyncTaksQuery;
import com.openteach.qsync.task.TaskStorage;

/**
 * 
 * @author rqq
 *
 */
@Service
public class TaskStorageOverDatabase implements TaskStorage {

	@Resource
	private CcSyncTaksManager ccSyncTaksManager;
	@Resource
	private OrderManager orderManager;
	
	@Override
	public List<CcSyncTaks> query(CcSyncTaksQuery query) {
		return ccSyncTaksManager.findPage(query).getItems();
	}

	@Override
	public void store(CcSyncTaks task) {
		TaskStatus taskStatus = TaskStatus.valueOf(task.getStatus());
		TaskType taskType = TaskType.valueOf(task.getType());
				
		orderManager.updateDeclareStatus(task.getOrderId(), taskType, taskStatus);
		ccSyncTaksManager.save(task);
	}

	@Override
	public void update(CcSyncTaks task) {
		TaskStatus taskStatus = TaskStatus.valueOf(task.getStatus());
		TaskType taskType = TaskType.valueOf(task.getType());
		orderManager.updateDeclareStatus(task.getOrderId(), taskType, taskStatus);
		ccSyncTaksManager.update(task);
	}

	public boolean updateStatus(String businessNo, TaskStatus status,
			String message) {
		return ccSyncTaksManager.updateStatus(businessNo, status, message, status == TaskStatus.NOT_PASS);
	}
}
