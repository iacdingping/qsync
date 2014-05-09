/*
 * Powered By china-telcom
 * Since 2012 - 2014
 */

package com.openteach.qsync.core.order;

import com.openteach.qsync.core.order.Transportation;
import com.openteach.qsync.core.order.TransportationDao;
import com.openteach.qsync.core.order.TransportationManager;
import com.openteach.qsync.core.order.TransportationQuery;


/**
 *
 * @author dingp email:dingp@51box.cn
 * @version 1.0
 * @since 1.0
 * */
public class Transportation {
	
	//alias
	public static final String TABLE_ALIAS = "Transportation";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_NAME = "name";
	public static final String ALIAS_PICURL = "picurl";
	public static final String ALIAS_REMARK = "remark";
	public static final String ALIAS_FREESHIPPING = "freeshipping";
	public static final String ALIAS_ISDELETED = "isdeleted";
	public static final String ALIAS_CREATE_DATETIME = "createDatetime";
	public static final String ALIAS_UPDATEDATETIME = "updatedatetime";
	
	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START
    /**
     * id       db_column: id 
     */	
	private java.lang.Long id;
    /**
     * name       db_column: name 
     */	
	private java.lang.String name;
    /**
     * picurl       db_column: picurl 
     */	
	private java.lang.String picurl;
    /**
     * remark       db_column: remark 
     */	
	private java.lang.String remark;
    /**
     * freeshipping       db_column: freeshipping 
     */	
	private java.lang.String freeshipping;
    /**
     * isdeleted       db_column: isdeleted 
     */	
	private java.lang.String isdeleted;
    /**
     * createDatetime       db_column: createDatetime 
     */	
	private java.util.Date createDatetime;
    /**
     * updatedatetime       db_column: updatedatetime 
     */	
	private java.util.Date updatedatetime;
	//columns END

	public Transportation(){
	}

	public Transportation(
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
	public void setName(java.lang.String value) {
		this.name = value;
	}
	public java.lang.String getName() {
		return this.name;
	}
	public void setPicurl(java.lang.String value) {
		this.picurl = value;
	}
	public java.lang.String getPicurl() {
		return this.picurl;
	}
	public void setRemark(java.lang.String value) {
		this.remark = value;
	}
	public java.lang.String getRemark() {
		return this.remark;
	}
	public void setFreeshipping(java.lang.String value) {
		this.freeshipping = value;
	}
	public java.lang.String getFreeshipping() {
		return this.freeshipping;
	}
	public void setIsdeleted(java.lang.String value) {
		this.isdeleted = value;
	}
	public java.lang.String getIsdeleted() {
		return this.isdeleted;
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
	
	private Set orders = new HashSet(0);
	public void setOrders(Set<Order> order){
		this.orders = order;
	}
	
	public Set<Order> getOrders() {
		return orders;
	}
	
	private Set transportationcompanys = new HashSet(0);
	public void setTransportationcompanys(Set<Transportationcompany> transportationcompany){
		this.transportationcompanys = transportationcompany;
	}
	
	public Set<Transportationcompany> getTransportationcompanys() {
		return transportationcompanys;
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
		if(obj instanceof Transportation == false) return false;
		if(this == obj) return true;
		Transportation other = (Transportation)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

