package com.openteach.qcity.qsync.common.lifecycle;

/**
 * 生命周期状态
 * @author rqq
 *
 */
public enum Status {

	/**
	 * 初始状态
	 */
	UNINITIALIZED,
	
	/**
	 * 已经初始化
	 */
	INITIALIZED,
	
	/**
	 * 已经启动
	 */
	STARTED,
	
	/**
	 * 已经停止
	 */
	SHUTDOWNED;
}
