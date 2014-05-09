/*
 * Powered By china-telcom
 * Since 2012 - 2014
 */

package com.openteach.qsync.core.pay;

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
public class Payment {
	
	//alias
	public static final String TABLE_ALIAS = "Payment";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_PAYERID = "payerid";
	public static final String ALIAS_PAYERSTATUS = "payerstatus";
	public static final String ALIAS_AMOUNT = "amount";
	public static final String ALIAS_STALUTATION = "stalutation";
	public static final String ALIAS_PAYTIME = "paytime";
	public static final String ALIAS_TYPE = "type";
	public static final String ALIAS_ORDER_ID = "orderId";
	public static final String ALIAS_MEMBER_ID = "memberId";
	public static final String ALIAS_CREATORADMIN = "creatoradmin";
	
	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START
    /**
     * id       db_column: id 
     */	
	private java.lang.Long id;
    /**
     * payerid       db_column: payerid 
     */	
	private java.lang.String payerid;
    /**
     * payerstatus       db_column: payerstatus 
     */	
	private java.lang.Integer payerstatus;
    /**
     * amount       db_column: amount 
     */	
	private java.lang.Double amount;
    /**
     * stalutation       db_column: stalutation 
     */	
	private java.lang.String stalutation;
    /**
     * paytime       db_column: paytime 
     */	
	private java.util.Date paytime;
    /**
     * type       db_column: type 
     */	
	private java.lang.Integer type;
    /**
     * orderId       db_column: order_id 
     */	
	private java.lang.Long orderId;
    /**
     * memberId       db_column: member_id 
     */	
	private java.lang.Long memberId;
    /**
     * creatoradmin       db_column: creatoradmin 
     */	
	private java.lang.Long creatoradmin;
	//columns END

	public Payment(){
	}

	public Payment(
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
	public void setPayerid(java.lang.String value) {
		this.payerid = value;
	}
	public java.lang.String getPayerid() {
		return this.payerid;
	}
	public void setPayerstatus(java.lang.Integer value) {
		this.payerstatus = value;
	}
	public java.lang.Integer getPayerstatus() {
		return this.payerstatus;
	}
	public void setAmount(java.lang.Double value) {
		this.amount = value;
	}
	public java.lang.Double getAmount() {
		return this.amount;
	}
	public void setStalutation(java.lang.String value) {
		this.stalutation = value;
	}
	public java.lang.String getStalutation() {
		return this.stalutation;
	}
	public void setPaytime(java.util.Date value) {
		this.paytime = value;
	}
	public java.util.Date getPaytime() {
		return this.paytime;
	}
	public void setType(java.lang.Integer value) {
		this.type = value;
	}
	public java.lang.Integer getType() {
		return this.type;
	}
	public void setOrderId(java.lang.Long value) {
		this.orderId = value;
	}
	public java.lang.Long getOrderId() {
		return this.orderId;
	}
	public void setMemberId(java.lang.Long value) {
		this.memberId = value;
	}
	public java.lang.Long getMemberId() {
		return this.memberId;
	}
	public void setCreatoradmin(java.lang.Long value) {
		this.creatoradmin = value;
	}
	public java.lang.Long getCreatoradmin() {
		return this.creatoradmin;
	}
	
	private Order order;
	
	public void setOrder(Order order){
		this.order = order;
	}
	
	public Order getOrder() {
		return order;
	}
	
	private Admininfo admininfo;
	
	public void setAdmininfo(Admininfo admininfo){
		this.admininfo = admininfo;
	}
	
	public Admininfo getAdmininfo() {
		return admininfo;
	}
	
	private Member member;
	
	public void setMember(Member member){
		this.member = member;
	}
	
	public Member getMember() {
		return member;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Payment == false) return false;
		if(this == obj) return true;
		Payment other = (Payment)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

