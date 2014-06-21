package com.openteach.qsync.core.query.logistics;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.openteach.qsync.core.PageQuery;


/**
 *
 * @author dingp email:dingp@51box.cn
 * @version 1.0
 * @since 1.0
 * */
public class TransportationQuery extends PageQuery {
    

	/** id */
	private java.lang.Long id;
	/** name */
	private java.lang.String name;
	/** picurl */
	private java.lang.String picurl;
	/** remark */
	private java.lang.String remark;
	/** freeshipping */
	private java.lang.String freeshipping;
	/** isdeleted */
	private java.lang.String isdeleted;
	/** createDatetime */
	private java.util.Date createDatetimeBegin;
	private java.util.Date createDatetimeEnd;
	/** updatedatetime */
	private java.util.Date updatedatetimeBegin;
	private java.util.Date updatedatetimeEnd;
	/** 运输工具航次(班)号 */
	private java.lang.String toolFltNo;
	/** 参照运输方式代码表(TRANSF) */
	private java.lang.String typeCode;
	/** 贸易国别（起运地） */
	private java.lang.String fromCountry;
	/** 包装种类 1 木箱 2 纸箱 3 桶装 4 散装 5 托盘 6 包 7 其它 */
	private java.lang.String packType;
	/** 申请单编号 保税进口必填，指仓储企业事先在辅助系统申请的分送集报申请单编号 */
	private java.lang.String applicationFormNo;

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
	
	public java.lang.String getPicurl() {
		return this.picurl;
	}
	
	public void setPicurl(java.lang.String value) {
		this.picurl = value;
	}
	
	public java.lang.String getRemark() {
		return this.remark;
	}
	
	public void setRemark(java.lang.String value) {
		this.remark = value;
	}
	
	public java.lang.String getFreeshipping() {
		return this.freeshipping;
	}
	
	public void setFreeshipping(java.lang.String value) {
		this.freeshipping = value;
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
	
	public java.lang.String getToolFltNo() {
		return this.toolFltNo;
	}
	
	public void setToolFltNo(java.lang.String value) {
		this.toolFltNo = value;
	}
	
	public java.lang.String getTypeCode() {
		return this.typeCode;
	}
	
	public void setTypeCode(java.lang.String value) {
		this.typeCode = value;
	}
	
	public java.lang.String getFromCountry() {
		return this.fromCountry;
	}
	
	public void setFromCountry(java.lang.String value) {
		this.fromCountry = value;
	}
	
	public java.lang.String getPackType() {
		return this.packType;
	}
	
	public void setPackType(java.lang.String value) {
		this.packType = value;
	}
	
	public java.lang.String getApplicationFormNo() {
		return this.applicationFormNo;
	}
	
	public void setApplicationFormNo(java.lang.String value) {
		this.applicationFormNo = value;
	}
	

	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.MULTI_LINE_STYLE);
	}
	
}

