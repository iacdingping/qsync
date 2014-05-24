package com.openteach.qsync.task;

import java.util.Date;

import com.openteach.qsync.core.TaskStatus;
import com.openteach.qsync.core.TaskType;


/**
 * 
 * @author rqq
 *
 */
public class Task {

	/**
	 * 
	 */
	private Long id;
	
	/**
	 * 
	 */
	private String generator;
	
	/**
	 * 
	 */
	private TaskType type;
	
	/**
	 * 
	 */
	private TaskStatus status;
	
	/**
	 * 
	 */
	private String xmlRequest;
	
	/**
	 * 
	 */
	private String xmlResponse;
	
	/**
	 * 
	 */
	private String exception;
	
	/**
	 * 
	 */
	private Date gmtCreate;
	
	/**
	 * 
	 */
	private Date gmtModified;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGenerator() {
		return generator;
	}

	public void setGenerator(String generator) {
		this.generator = generator;
	}
	
	public TaskType getType() {
		return type;
	}

	public void setType(TaskType type) {
		this.type = type;
	}

	public TaskStatus getStatus() {
		return status;
	}

	public void setStatus(TaskStatus status) {
		this.status = status;
	}

	public String getXmlRequest() {
		return xmlRequest;
	}

	public void setXmlRequest(String xmlRequest) {
		this.xmlRequest = xmlRequest;
	}

	public String getXmlResponse() {
		return xmlResponse;
	}

	public void setXmlResponse(String xmlResponse) {
		this.xmlResponse = xmlResponse;
	}
	
	public String getException() {
		return exception;
	}

	public void setException(String exception) {
		this.exception = exception;
	}
	
	public Date getGmtCreate() {
		return gmtCreate;
	}

	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	public Date getGmtModified() {
		return gmtModified;
	}

	public void setGmtModified(Date gmtModified) {
		this.gmtModified = gmtModified;
	}
}
