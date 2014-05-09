/*
 * Powered By china-telcom
 * Since 2012 - 2014
 */

package com.openteach.qsync.core.order;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import iac.dp.tourism.util.PageQuery;

import com.openteach.qsync.core.order.Finalstatement;
import com.openteach.qsync.core.order.FinalstatementDao;
import com.openteach.qsync.core.order.FinalstatementManager;
import com.openteach.qsync.core.order.FinalstatementQuery;


/**
 *
 * @author dingp email:dingp@51box.cn
 * @version 1.0
 * @since 1.0
 * */
public class FinalstatementQuery extends PageQuery {
    

	/** id */
	private java.lang.Long id;
	/** code */
	private java.lang.String code;
	/** suppliercode */
	private java.lang.String suppliercode;
	/** suppliername */
	private java.lang.String suppliername;
	/** isfinal */
	private java.lang.Integer isfinal;
	/** totalamount */
	private java.lang.Double totalamount;
	/** ccshopId */
	private java.lang.Long ccshopId;
	/** createDatetime */
	private java.util.Date createDatetimeBegin;
	private java.util.Date createDatetimeEnd;
	/** updatedatetime */
	private java.util.Date updatedatetimeBegin;
	private java.util.Date updatedatetimeEnd;
	/** isdeleted */
	private java.lang.String isdeleted;
	/** iscomplete */
	private java.lang.String iscomplete;
	/** operatepeople */
	private java.lang.Long operatepeople;
	/** modeifier */
	private java.lang.Long modeifier;

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
	
	public java.lang.String getSuppliercode() {
		return this.suppliercode;
	}
	
	public void setSuppliercode(java.lang.String value) {
		this.suppliercode = value;
	}
	
	public java.lang.String getSuppliername() {
		return this.suppliername;
	}
	
	public void setSuppliername(java.lang.String value) {
		this.suppliername = value;
	}
	
	public java.lang.Integer getIsfinal() {
		return this.isfinal;
	}
	
	public void setIsfinal(java.lang.Integer value) {
		this.isfinal = value;
	}
	
	public java.lang.Double getTotalamount() {
		return this.totalamount;
	}
	
	public void setTotalamount(java.lang.Double value) {
		this.totalamount = value;
	}
	
	public java.lang.Long getCcshopId() {
		return this.ccshopId;
	}
	
	public void setCcshopId(java.lang.Long value) {
		this.ccshopId = value;
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
	
	public java.lang.String getIsdeleted() {
		return this.isdeleted;
	}
	
	public void setIsdeleted(java.lang.String value) {
		this.isdeleted = value;
	}
	
	public java.lang.String getIscomplete() {
		return this.iscomplete;
	}
	
	public void setIscomplete(java.lang.String value) {
		this.iscomplete = value;
	}
	
	public java.lang.Long getOperatepeople() {
		return this.operatepeople;
	}
	
	public void setOperatepeople(java.lang.Long value) {
		this.operatepeople = value;
	}
	
	public java.lang.Long getModeifier() {
		return this.modeifier;
	}
	
	public void setModeifier(java.lang.Long value) {
		this.modeifier = value;
	}
	

	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.MULTI_LINE_STYLE);
	}
	
}

