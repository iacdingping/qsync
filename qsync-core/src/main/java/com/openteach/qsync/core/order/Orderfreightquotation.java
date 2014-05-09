/*
 * Powered By china-telcom
 * Since 2012 - 2014
 */

package com.openteach.qsync.core.order;

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
public class Orderfreightquotation {
	
	//alias
	public static final String TABLE_ALIAS = "Orderfreightquotation";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_CCORDER_ID = "ccorderId";
	public static final String ALIAS_FREIGHTQUOTATION_ID = "freightquotationId";
	public static final String ALIAS_FREIGHT = "freight";
	public static final String ALIAS_CREATE_DATETIME = "createDatetime";
	public static final String ALIAS_UPDATEDATETIME = "updatedatetime";
	
	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START
    /**
     * id       db_column: id 
     */	
	private java.lang.Long id;
    /**
     * ccorderId       db_column: ccorder_id 
     */	
	private java.lang.Long ccorderId;
    /**
     * freightquotationId       db_column: freightquotation_id 
     */	
	private java.lang.Long freightquotationId;
    /**
     * freight       db_column: freight 
     */	
	private java.lang.Double freight;
    /**
     * createDatetime       db_column: createDatetime 
     */	
	private java.util.Date createDatetime;
    /**
     * updatedatetime       db_column: updatedatetime 
     */	
	private java.util.Date updatedatetime;
	//columns END

	public Orderfreightquotation(){
	}

	public Orderfreightquotation(
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
	public void setCcorderId(java.lang.Long value) {
		this.ccorderId = value;
	}
	public java.lang.Long getCcorderId() {
		return this.ccorderId;
	}
	public void setFreightquotationId(java.lang.Long value) {
		this.freightquotationId = value;
	}
	public java.lang.Long getFreightquotationId() {
		return this.freightquotationId;
	}
	public void setFreight(java.lang.Double value) {
		this.freight = value;
	}
	public java.lang.Double getFreight() {
		return this.freight;
	}
	public void setCreateDatetime(java.util.Date value) {
		this.createDatetime = value;
	}
	public java.util.Date getCreateDatetime() {
		return this.createDatetime;
	}
	public void setUpdatedatetime(java.util.Date value) {
		this.updatedatetime = value;
	}
	public java.util.Date getUpdatedatetime() {
		return this.updatedatetime;
	}
	
	private Order order;
	
	public void setOrder(Order order){
		this.order = order;
	}
	
	public Order getOrder() {
		return order;
	}
	
	private Freightquotation freightquotation;
	
	public void setFreightquotation(Freightquotation freightquotation){
		this.freightquotation = freightquotation;
	}
	
	public Freightquotation getFreightquotation() {
		return freightquotation;
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
		if(obj instanceof Orderfreightquotation == false) return false;
		if(this == obj) return true;
		Orderfreightquotation other = (Orderfreightquotation)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

