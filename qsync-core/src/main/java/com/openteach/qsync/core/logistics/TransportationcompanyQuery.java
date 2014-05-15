package com.openteach.qsync.core.logistics;

import com.openteach.qsync.core.PageQuery;


/**
 *
 * @author dingp email:dingp@51box.cn
 * @version 1.0
 * @since 1.0
 * */
public class TransportationcompanyQuery extends PageQuery {
    

	/** id */
	private java.lang.Long id;
	/** transportationId */
	private java.lang.Long transportationId;
	/** name */
	private java.lang.String name;
	/** day */
	private java.lang.String day;
	/** url */
	private java.lang.String url;
	/** isdeleted */
	private java.lang.String isdeleted;
	/** createDatetime */
	private java.util.Date createDatetimeBegin;
	private java.util.Date createDatetimeEnd;
	/** updatedatetime */
	private java.util.Date updatedatetimeBegin;
	private java.util.Date updatedatetimeEnd;
	/** 物流企业编号 */
	private java.lang.String code;
	/** 物流企业邮编 */
	private java.lang.String zipCode;

	public java.lang.Long getId() {
		return this.id;
	}
	
	public void setId(java.lang.Long value) {
		this.id = value;
	}
	
	public java.lang.Long getTransportationId() {
		return this.transportationId;
	}
	
	public void setTransportationId(java.lang.Long value) {
		this.transportationId = value;
	}
	
	public java.lang.String getName() {
		return this.name;
	}
	
	public void setName(java.lang.String value) {
		this.name = value;
	}
	
	public java.lang.String getDay() {
		return this.day;
	}
	
	public void setDay(java.lang.String value) {
		this.day = value;
	}
	
	public java.lang.String getUrl() {
		return this.url;
	}
	
	public void setUrl(java.lang.String value) {
		this.url = value;
	}
	
	public java.lang.String getIsdeleted() {
		return this.isdeleted;
	}
	
	public void setIsdeleted(java.lang.String value) {
		this.isdeleted = value;
	}
	
	public java.util.Date getCreateDatetimeBegin() {
		return this.createDatetimeBegin;
	}
	
	public void setCreateDatetimeBegin(java.util.Date value) {
		this.createDatetimeBegin = value;
	}	
	
	public java.util.Date getCreateDatetimeEnd() {
		return this.createDatetimeEnd;
	}
	
	public void setCreateDatetimeEnd(java.util.Date value) {
		this.createDatetimeEnd = value;
	}
	
	public java.util.Date getUpdatedatetimeBegin() {
		return this.updatedatetimeBegin;
	}
	
	public void setUpdatedatetimeBegin(java.util.Date value) {
		this.updatedatetimeBegin = value;
	}	
	
	public java.util.Date getUpdatedatetimeEnd() {
		return this.updatedatetimeEnd;
	}
	
	public void setUpdatedatetimeEnd(java.util.Date value) {
		this.updatedatetimeEnd = value;
	}
	
	public java.lang.String getCode() {
		return this.code;
	}
	
	public void setCode(java.lang.String value) {
		this.code = value;
	}
	
	public java.lang.String getZipCode() {
		return this.zipCode;
	}
	
	public void setZipCode(java.lang.String value) {
		this.zipCode = value;
	}
	
}

