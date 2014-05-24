package com.openteach.qsync.task;

import java.util.List;

import com.openteach.qsync.core.entity.system.CcSyncTaks;
import com.openteach.qsync.core.query.system.CcSyncTaksQuery;

/**
 * task 存储
 * @author rqq
 *
 */
public interface TaskStorage {
	
	/**
	 * 
	 * @param query
	 */
	List<CcSyncTaks> query(CcSyncTaksQuery query);
	
	/**
	 * 持久化
	 * @param task
	 */
	void store(CcSyncTaks task);
	
	/**
	 * 更新
	 * @param task
	 */
	void update(CcSyncTaks task);
}
