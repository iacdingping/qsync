package com.openteach.qsync.task;

import java.util.List;

import com.openteach.qsync.core.PageQuery;

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
	List<Task> query(TaskQuery query);
	
	/**
	 * 持久化
	 * @param task
	 */
	void store(Task task);
	
	/**
	 * 更新
	 * @param task
	 */
	void update(Task task);
	
	/**
	 * 
	 * @author rqq
	 *
	 */
	class TaskQuery extends PageQuery {
		
		/**
		 * 
		 */
		private int denominator;

		/**
		 * 
		 */
		private int mode;
		
		/**
		 * 
		 */
		private List<TaskStatus> statusList;

		public int getDenominator() {
			return denominator;
		}

		public void setDenominator(int denominator) {
			this.denominator = denominator;
		}
		
		public int getMode() {
			return mode;
		}

		public void setMode(int mode) {
			this.mode = mode;
		}
		
		public List<TaskStatus> getStatusList() {
			return statusList;
		}

		public void setStatusList(List<TaskStatus> statusList) {
			this.statusList = statusList;
		}
	}
}
