package com.openteach.qcity.qsync.common.lifecycle;

/**
 * 生命周期管理
 * @author rqq
 *
 */
public interface LifeCycle {

	/**
	 *初始化 
	 */
	void initialize();
	
	/**
	 * 启动
	 */
	void start();
	
	/**
	 * 关闭
	 */
	void shutdown(); 
}
