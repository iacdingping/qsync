package com.openteach.qsync.task.db;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.openteach.qsync.core.entity.system.CcSyncTaks;
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
	
	@Override
	public List<CcSyncTaks> query(CcSyncTaksQuery query) {
		return ccSyncTaksManager.list(query);
	}

	@Override
	public void store(CcSyncTaks task) {
		ccSyncTaksManager.save(task);
	}

	@Override
	public void update(CcSyncTaks task) {
		ccSyncTaksManager.update(task);
	}
}
