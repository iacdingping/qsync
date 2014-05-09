/*
 * Powered By china-telcom
 * Since 2012 - 2014
 */

package com.openteach.qsync.core.pay;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import iac.dp.tourism.util.PageQuery;

import com.openteach.qsync.core.pay.Payment;
import com.openteach.qsync.core.pay.PaymentDao;
import com.openteach.qsync.core.pay.PaymentManager;
import com.openteach.qsync.core.pay.PaymentQuery;


/**
 *
 * @author dingp email:dingp@51box.cn
 * @version 1.0
 * @since 1.0
 * */
public class PaymentQuery extends PageQuery {
    

	/** id */
	private java.lang.Long id;
	/** payerid */
	private java.lang.String payerid;
	/** payerstatus */
	private java.lang.Integer payerstatus;
	/** amount */
	private java.lang.Double amount;
	/** stalutation */
	private java.lang.String stalutation;
	/** paytime */
	private java.util.Date paytimeBegin;
	private java.util.Date paytimeEnd;
	/** type */
	private java.lang.Integer type;
	/** orderId */
	private java.lang.Long orderId;
	/** memberId */
	private java.lang.Long memberId;
	/** creatoradmin */
	private java.lang.Long creatoradmin;

	public java.lang.Long getId() {
		return this.id;
	}
	
	public void setId(java.lang.Long value) {
		this.id = value;
	}
	
	public java.lang.String getPayerid() {
		return this.payerid;
	}
	
	public void setPayerid(java.lang.String value) {
		this.payerid = value;
	}
	
	public java.lang.Integer getPayerstatus() {
		return this.payerstatus;
	}
	
	public void setPayerstatus(java.lang.Integer value) {
		this.payerstatus = value;
	}
	
	public java.lang.Double getAmount() {
		return this.amount;
	}
	
	public void setAmount(java.lang.Double value) {
		this.amount = value;
	}
	
	public java.lang.String getStalutation() {
		return this.stalutation;
	}
	
	public void setStalutation(java.lang.String value) {
		this.stalutation = value;
	}
	
	public java.util.Date getPaytimeBegin() {
		return this.paytimeBegin;
	}
	
	public void setPaytimeBegin(java.util.Date value) {
		this.paytimeBegin = value;
	}	
	
	public java.util.Date getPaytimeEnd() {
		return this.paytimeEnd;
	}
	
	public void setPaytimeEnd(java.util.Date value) {
		this.paytimeEnd = value;
	}
	
	public java.lang.Integer getType() {
		return this.type;
	}
	
	public void setType(java.lang.Integer value) {
		this.type = value;
	}
	
	public java.lang.Long getOrderId() {
		return this.orderId;
	}
	
	public void setOrderId(java.lang.Long value) {
		this.orderId = value;
	}
	
	public java.lang.Long getMemberId() {
		return this.memberId;
	}
	
	public void setMemberId(java.lang.Long value) {
		this.memberId = value;
	}
	
	public java.lang.Long getCreatoradmin() {
		return this.creatoradmin;
	}
	
	public void setCreatoradmin(java.lang.Long value) {
		this.creatoradmin = value;
	}
	

	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.MULTI_LINE_STYLE);
	}
	
}

