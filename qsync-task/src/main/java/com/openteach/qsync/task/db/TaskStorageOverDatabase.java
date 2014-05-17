package com.openteach.qsync.task.db;

import java.util.List;

import javax.annotation.Resource;

import com.openteach.qsync.task.Task;
import com.openteach.qsync.task.TaskStorage;

/**
 * 
 * @author rqq
 *
 */
public class TaskStorageOverDatabase implements TaskStorage {

	@Resource
	private TaskDAO taskDAO;
	
	@Override
	public List<Task> query(TaskQuery query) {
		return taskDAO.list(query);
	}

	@Override
	public void store(Task task) {
		taskDAO.save(task);
	}

	@Override
	public void update(Task task) {
		taskDAO.update(task);
	}
	
	public void setTaskDAO(TaskDAO taskDAO) {
		this.taskDAO = taskDAO;
	}
}
