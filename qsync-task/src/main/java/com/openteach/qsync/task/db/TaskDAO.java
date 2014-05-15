package com.openteach.qsync.task.db;

import com.openteach.qsync.core.BaseMyBatisRepository;
import com.openteach.qsync.core.MyBatisRepository;
import com.openteach.qsync.task.Task;

/**
 * 
 * @author rqq
 *
 */
@MyBatisRepository
public interface TaskDAO extends BaseMyBatisRepository<Task, Long> {

}
