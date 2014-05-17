package com.openteach.qsync.core.declare;

import com.openteach.qsync.core.PageQuery;

/**
 *
 * @author dingp email:dingp@51box.cn
 * @version 1.0
 * @since 1.0
 * */
public class DeclarePayTypeQuery extends PageQuery {
    

	/** id */
	private java.lang.Long id;
	/** 电商平台支付方式 1 paypal 2 skril */
	private java.lang.Integer platformPayType;
	/** 支付公司编码 */
	private java.lang.String platformPayCompanyCode;
	/** 报关支付类型 01:银行卡支付 02:余额支付 03:其他 */
	private java.lang.String declarePayType;
	/** isdeleted */
	private java.lang.String isdeleted;
	/** createdatetime */
	private java.util.Date createdatetimeBegin;
	private java.util.Date createdatetimeEnd;
	/** updatedatetime */
	private java.util.Date updatedatetimeBegin;
	private java.util.Date updatedatetimeEnd;

	public java.lang.Long getId() {
		return this.id;
	}
	
	public void setId(java.lang.Long value) {
		this.id = value;
	}
	
	public java.lang.Integer getPlatformPayType() {
		return this.platformPayType;
	}
	
	public void setPlatformPayType(java.lang.Integer value) {
		this.platformPayType = value;
	}
	
	public java.lang.String getPlatformPayCompanyCode() {
		return this.platformPayCompanyCode;
	}
	
	public void setPlatformPayCompanyCode(java.lang.String value) {
		this.platformPayCompanyCode = value;
	}
	
	public java.lang.String getDeclarePayType() {
		return this.declarePayType;
	}
	
	public void setDeclarePayType(java.lang.String value) {
		this.declarePayType = value;
	}
	
	public java.lang.String getIsdeleted() {
		return this.isdeleted;
	}
	
	public void setIsdeleted(java.lang.String value) {
		this.isdeleted = value;
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
	
}

