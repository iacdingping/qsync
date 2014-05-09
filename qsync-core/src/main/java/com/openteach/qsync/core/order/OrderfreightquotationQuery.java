/*
 * Powered By china-telcom
 * Since 2012 - 2014
 */

package com.openteach.qsync.core.order;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import iac.dp.tourism.util.PageQuery;

import com.openteach.qsync.core.order.Orderfreightquotation;
import com.openteach.qsync.core.order.OrderfreightquotationDao;
import com.openteach.qsync.core.order.OrderfreightquotationManager;
import com.openteach.qsync.core.order.OrderfreightquotationQuery;


/**
 *
 * @author dingp email:dingp@51box.cn
 * @version 1.0
 * @since 1.0
 * */
public class OrderfreightquotationQuery extends PageQuery {
    

	/** id */
	private java.lang.Long id;
	/** ccorderId */
	private java.lang.Long ccorderId;
	/** freightquotationId */
	private java.lang.Long freightquotationId;
	/** freight */
	private java.lang.Double freight;
	/** createDatetime */
	private java.util.Date createDatetimeBegin;
	private java.util.Date createDatetimeEnd;
	/** updatedatetime */
	private java.util.Date updatedatetimeBegin;
	private java.util.Date updatedatetimeEnd;

	public java.lang.Long getId() {
		return this.id;
	}
	
	public void setId(java.lang.Long value) {
		this.id = value;
	}
	
	public java.lang.Long getCcorderId() {
		return this.ccorderId;
	}
	
	public void setCcorderId(java.lang.Long value) {
		this.ccorderId = value;
	}
	
	public java.lang.Long getFreightquotationId() {
		return this.freightquotationId;
	}
	
	public void setFreightquotationId(java.lang.Long value) {
		this.freightquotationId = value;
	}
	
	public java.lang.Double getFreight() {
		return this.freight;
	}
	
	public void setFreight(java.lang.Double value) {
		this.freight = value;
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
	

	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.MULTI_LINE_STYLE);
	}
	
}

