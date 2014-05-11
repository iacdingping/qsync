package com.openteach.qsync.core.info;

import com.openteach.qsync.core.PageQuery;


/**
 *
 * @author dingp email:dingp@51box.cn
 * @version 1.0
 * @since 1.0
 * */
public class CityQuery extends PageQuery {
    

	/** id */
	private java.lang.Long id;
	/** code */
	private java.lang.String code;
	/** name */
	private java.lang.String name;
	/** isdeleted */
	private java.lang.String isdeleted;
	/** creatorId */
	private java.lang.Long creatorId;
	/** modifierId */
	private java.lang.Long modifierId;
	/** createdatetime */
	private java.util.Date createdatetimeBegin;
	private java.util.Date createdatetimeEnd;
	/** updatedatetime */
	private java.util.Date updatedatetimeBegin;
	private java.util.Date updatedatetimeEnd;
	/** provinceId */
	private java.lang.Long provinceId;
	/** countryId */
	private java.lang.Long countryId;

	public java.lang.Long getId() {
		return this.id;
	}
	
	public void setId(java.lang.Long value) {
		this.id = value;
	}
	
	public java.lang.String getCode() {
		return this.code;
	}
	
	public void setCode(java.lang.String value) {
		this.code = value;
	}
	
	public java.lang.String getName() {
		return this.name;
	}
	
	public void setName(java.lang.String value) {
		this.name = value;
	}
	
	public java.lang.String getIsdeleted() {
		return this.isdeleted;
	}
	
	public void setIsdeleted(java.lang.String value) {
		this.isdeleted = value;
	}
	
	public java.lang.Long getCreatorId() {
		return this.creatorId;
	}
	
	public void setCreatorId(java.lang.Long value) {
		this.creatorId = value;
	}
	
	public java.lang.Long getModifierId() {
		return this.modifierId;
	}
	
	public void setModifierId(java.lang.Long value) {
		this.modifierId = value;
	}
	
	public java.util.Date getCreatedatetimeBegin() {
		return this.createdatetimeBegin;
	}
	
	public void setCreatedatetimeBegin(java.util.Date value) {
		this.createdatetimeBegin = value;
	}	
	
	public java.util.Date getCreatedatetimeEnd() {
		return this.createdatetimeEnd;
	}
	
	public void setCreatedatetimeEnd(java.util.Date value) {
		this.createdatetimeEnd = value;
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
	
	public java.lang.Long getProvinceId() {
		return this.provinceId;
	}
	
	public void setProvinceId(java.lang.Long value) {
		this.provinceId = value;
	}
	
	public java.lang.Long getCountryId() {
		return this.countryId;
	}
	
	public void setCountryId(java.lang.Long value) {
		this.countryId = value;
	}
	
}

