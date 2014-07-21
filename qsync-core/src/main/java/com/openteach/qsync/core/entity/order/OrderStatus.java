package com.openteach.qsync.core.entity.order;



/**
 *
 * @author dingp email:dingp@51box.cn
 * @version 1.0
 * @since 1.0
 * */
public class OrderStatus {
	
	//alias
	public static final String TABLE_ALIAS = "OrderStatus";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_STATUS = "status";
	public static final String ALIAS_ORDER_ID = "orderId";
	public static final String ALIAS_CREATORADMIN = "creatoradmin";
	public static final String ALIAS_CREATEDATETIME = "createdatetime";
	
	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START
    /**
     * id       db_column: id 
     */	
	private java.lang.Long id;
    /**
     * status       db_column: status 
     */	
	private java.lang.Integer status;
    /**
     * orderId       db_column: order_id 
     */	
	private java.lang.Long orderId;
    /**
     * creatoradmin       db_column: creatoradmin 
     */	
	private java.lang.Long creatoradmin;
    /**
     * createdatetime       db_column: createdatetime 
     */	
	private java.util.Date createdatetime;
	//columns END

	public OrderStatus(){
	}

	public OrderStatus(
		java.lang.Long id
	){
		this.id = id;
	}

	public void setId(java.lang.Long value) {
		this.id = value;
	}
	public java.lang.Long getId() {
		return this.id;
	}
	public void setStatus(java.lang.Integer value) {
		this.status = value;
	}
	public java.lang.Integer getStatus() {
		return this.status;
	}
	public void setOrderId(java.lang.Long value) {
		this.orderId = value;
	}
	public java.lang.Long getOrderId() {
		return this.orderId;
	}
	public void setCreatoradmin(java.lang.Long value) {
		this.creatoradmin = value;
	}
	public java.lang.Long getCreatoradmin() {
		return this.creatoradmin;
	}
	public void setCreatedatetime(java.util.Date value) {
		this.createdatetime = value;
	}
	public java.util.Date getCreatedatetime() {
		return this.createdatetime;
	}
}

