package com.openteach.qcity.qsync.common.api;

/**
 * 任务状态
 * @author rqq
 *
 */
public enum TaskStatus {

	UNDO(false),
	DOING(false),
	LAUNCH_FAILED(false),
	DATA_ERROR(true),
	DECLARE_FAILED(false),
	IGNORE(true),
	DECLARE_SUCCESS(false),
	NOT_PASS(true),
	PASS(true),
	;
	
	private boolean endState;

	private TaskStatus(boolean endState) {
		this.endState = endState;
	}

	public boolean isEndState() {
		return endState;
	}

	public void setEndState(boolean endState) {
		this.endState = endState;
	}
}