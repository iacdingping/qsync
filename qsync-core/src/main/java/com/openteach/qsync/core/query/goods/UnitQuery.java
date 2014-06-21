package com.openteach.qsync.core.query.goods;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.openteach.qsync.core.PageQuery;


/**
 *
 * @author dingp email:dingp@51box.cn
 * @version 1.0
 * @since 1.0
 * */
public class UnitQuery extends PageQuery {
    

	/** id */
	private java.lang.Long id;
	/** name */
	private java.lang.String name;
	/** code */
	private java.lang.String code;
	/** sort */
	private java.lang.String sort;
	/** account */
	private java.lang.String account;
	/** createdate */
	private java.util.Date createdateBegin;
	private java.util.Date createdateEnd;
	/** isdeleted */
	private java.lang.String isdeleted;

	public java.lang.Long getId() {
		return this.id;
	}
	
	public void setId(java.lang.Long value) {
		this.id = value;
	}
	
	public java.lang.String getName() {
		return this.name;
	}
	
	public void setName(java.lang.String value) {
		this.name = value;
	}
	
	public java.lang.String getCode() {
		return this.code;
	}
	
	public void setCode(java.lang.String value) {
		this.code = value;
	}
	
	public java.lang.String getSort() {
		return this.sort;
	}
	
	public void setSort(java.lang.String value) {
		this.sort = value;
	}
	
	public java.lang.String getAccount() {
		return this.account;
	}
	
	public void setAccount(java.lang.String value) {
		this.account = value;
	}
	
	public java.util.Date getCreatedateBegin() {
		return this.createdateBegin;
	}
	
	public void setCreatedateBegin(java.util.Date value) {
		this.createdateBegin = value;
	}	
	
	public java.util.Date getCreatedateEnd() {
		return this.createdateEnd;
	}
	
	public void setCreatedateEnd(java.util.Date value) {
		this.createdateEnd = value;
	}
	
	public java.lang.String getIsdeleted() {
		return this.isdeleted;
	}
	
	public void setIsdeleted(java.lang.String value) {
		this.isdeleted = value;
	}
	

	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.MULTI_LINE_STYLE);
	}
	
}

