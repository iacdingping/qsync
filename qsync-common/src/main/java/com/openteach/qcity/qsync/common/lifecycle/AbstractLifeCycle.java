package com.openteach.qcity.qsync.common.lifecycle;

/**
 * 
 * @author rqq
 *
 */
public class AbstractLifeCycle implements LifeCycle {

	/**
	 * 状态
	 */
	private Status status = Status.UNINITIALIZED;
	
	@Override
	public void initialize() {
		if(status != Status.UNINITIALIZED && status != Status.SHUTDOWNED) {
			throw new IllegalStateException();
		}
		this.status = Status.INITIALIZED;
	}

	@Override
	public void start() {
		if(status != Status.INITIALIZED) {
			throw new IllegalStateException();
		}
		this.status = Status.STARTED;
	}

	@Override
	public void shutdown() {
		if(status != Status.INITIALIZED && status != Status.STARTED) {
			throw new IllegalStateException();
		}
		this.status = Status.SHUTDOWNED;
	}
}
