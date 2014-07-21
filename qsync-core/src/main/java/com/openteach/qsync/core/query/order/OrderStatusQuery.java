package com.openteach.qsync.core.query.order;

import com.openteach.qsync.core.PageQuery;


/**
 *
 * @author dingp email:dingp@51box.cn
 * @version 1.0
 * @since 1.0
 * */
public class OrderStatusQuery extends PageQuery {
    

	/** id */
	private java.lang.Long id;
	/** status */
	private java.lang.Integer status;
	/** orderId */
	private java.lang.Long orderId;
	/** creatoradmin */
	private java.lang.Long creatoradmin;
	/** createdatetime */
	private java.util.Date createdatetimeBegin;
	private java.util.Date createdatetimeEnd;

	public java.lang.Long getId() {
		return this.id;
	}
	
	public void setId(java.lang.Long value) {
		this.id = value;
	}
	
	public java.lang.Integer getStatus() {
		return this.status;
	}
	
	public void setStatus(java.lang.Integer value) {
		this.status = value;
	}
	
	public java.lang.Long getOrderId() {
		return this.orderId;
	}
	
	public void setOrderId(java.lang.Long value) {
		this.orderId = value;
	}
	
	public java.lang.Long getCreatoradmin() {
		return this.creatoradmin;
	}
	
	public void setCreatoradmin(java.lang.Long value) {
		this.creatoradmin = value;
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
}

