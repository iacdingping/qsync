package com.openteach.qsync.api;

import com.openteach.qcity.qsync.common.api.TaskStatus;


public class XmlResponse {

	private String fileName;
	
	private Boolean success;
	
	private TaskStatus status;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public TaskStatus getStatus() {
		return status;
	}

	public void setStatus(TaskStatus status) {
		this.status = status;
	}
}
