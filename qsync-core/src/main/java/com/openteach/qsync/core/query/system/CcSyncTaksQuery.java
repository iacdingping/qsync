package com.openteach.qsync.core.query.system;

import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.openteach.qsync.core.PageQuery;


/**
 *
 * @author dingp email:dingp@51box.cn
 * @version 1.0
 * @since 1.0
 * */
public class CcSyncTaksQuery extends PageQuery {
    

	/** id */
	private java.lang.Long id;
	/** generator */
	private java.lang.String generator;
	/** type */
	private java.lang.String type;
	/** status */
	private java.lang.String status;
	
	private List<String> inStatus;
	
	/** xmlRequest */
	private java.lang.String xmlRequest;
	/** xmlResponse */
	private java.lang.String xmlResponse;
	/** exception */
	private java.lang.String exception;
	/** gmtCreate */
	private java.util.Date gmtCreateBegin;
	private java.util.Date gmtCreateEnd;
	/** gmtModified */
	private java.util.Date gmtModifiedBegin;
	private java.util.Date gmtModifiedEnd;

	public java.lang.Long getId() {
		return this.id;
	}
	
	public void setId(java.lang.Long value) {
		this.id = value;
	}
	
	public java.lang.String getGenerator() {
		return this.generator;
	}
	
	public void setGenerator(java.lang.String value) {
		this.generator = value;
	}
	
	public java.lang.String getType() {
		return this.type;
	}
	
	public void setType(java.lang.String value) {
		this.type = value;
	}
	
	public java.lang.String getStatus() {
		return this.status;
	}
	
	public void setStatus(java.lang.String value) {
		this.status = value;
	}
	
	public java.lang.String getXmlRequest() {
		return this.xmlRequest;
	}
	
	public void setXmlRequest(java.lang.String value) {
		this.xmlRequest = value;
	}
	
	public java.lang.String getXmlResponse() {
		return this.xmlResponse;
	}
	
	public void setXmlResponse(java.lang.String value) {
		this.xmlResponse = value;
	}
	
	public java.lang.String getException() {
		return this.exception;
	}
	
	public void setException(java.lang.String value) {
		this.exception = value;
	}
	
	public java.util.Date getGmtCreateBegin() {
		return this.gmtCreateBegin;
	}
	
	public void setGmtCreateBegin(java.util.Date value) {
		this.gmtCreateBegin = value;
	}	
	
	public java.util.Date getGmtCreateEnd() {
		return this.gmtCreateEnd;
	}
	
	public void setGmtCreateEnd(java.util.Date value) {
		this.gmtCreateEnd = value;
	}
	
	public java.util.Date getGmtModifiedBegin() {
		return this.gmtModifiedBegin;
	}
	
	public void setGmtModifiedBegin(java.util.Date value) {
		this.gmtModifiedBegin = value;
	}	
	
	public java.util.Date getGmtModifiedEnd() {
		return this.gmtModifiedEnd;
	}
	
	public void setGmtModifiedEnd(java.util.Date value) {
		this.gmtModifiedEnd = value;
	}

	public List<String> getInStatus() {
		return inStatus;
	}

	public void setInStatus(List<String> inStatus) {
		this.inStatus = inStatus;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.MULTI_LINE_STYLE);
	}
	
}

