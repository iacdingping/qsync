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
	
	/**
	 * endstate状态 并且未通过的  或者 通过的为99电子审单的
	 * 海关平台回执有三次  第一次为验证 处理成功 根据businessNo匹配数据
	 * 第二次为电子放行 preEntryNo 匹配数据
	 * 第三次为手工放行 
	 */
	@Override
	public boolean updateStatus(String businessNoOrPreEntryNo, TaskStatus status,
			String message, String xmlResponse, ExaminationState state) {
		CcSyncTaksQuery query = new CcSyncTaksQuery();
		query.setBusinessNoOrPreEntryNo(businessNoOrPreEntryNo);
		List<CcSyncTaks> tasks = storage.query(query);
		if(tasks.isEmpty())
			return false;
		
		CcSyncTaks task = tasks.get(0);
		TaskStatus statusBefore = TaskStatus.valueOf(task.getStatus());
		// 先是申报失败 然后是申报通过
		// 什么情况下 不修改状态 ？  从TaskStatus.ordinal 后向前修改状态
		// 防止读取文件时序颠倒 修改状态错误
		if(statusBefore.isEndState() && statusBefore.ordinal() >= status.ordinal()) {
			
			if(statusBefore == TaskStatus.PASS && state!= null && state != ExaminationState.EXAMINATION_PASS) {
				// 99的电子审单通过  并且 当前的sate 不为99状态的 需要再次修改订单的报关状态
			} else {
				logger.info(String.format("order [%s], businessNo [%s] status [%s] is final and not the NOT_PASS status, donot modify the status. to be change status [%s]", 
						task.getOrderId(), businessNoOrPreEntryNo, task.getStatus(), status.name()));
				return true;
			}
		}
		
		return storage.updateStatus(businessNoOrPreEntryNo, status, message, task.getOrderId(), TaskType.valueOf(task.getType()), xmlResponse, state);
	}

}
