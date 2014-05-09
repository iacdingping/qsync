/*
 * Powered By china-telcom
 * Since 2012 - 2014
 */

package com.openteach.qsync.core.order;

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
public class Finalstatement {
	
	//alias
	public static final String TABLE_ALIAS = "Finalstatement";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_CODE = "code";
	public static final String ALIAS_SUPPLIERCODE = "suppliercode";
	public static final String ALIAS_SUPPLIERNAME = "suppliername";
	public static final String ALIAS_ISFINAL = "isfinal";
	public static final String ALIAS_TOTALAMOUNT = "totalamount";
	public static final String ALIAS_CCSHOP_ID = "ccshopId";
	public static final String ALIAS_CREATE_DATETIME = "createDatetime";
	public static final String ALIAS_UPDATEDATETIME = "updatedatetime";
	public static final String ALIAS_ISDELETED = "isdeleted";
	public static final String ALIAS_ISCOMPLETE = "iscomplete";
	public static final String ALIAS_OPERATEPEOPLE = "operatepeople";
	public static final String ALIAS_MODEIFIER = "modeifier";
	
	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START
    /**
     * id       db_column: id 
     */	
	private java.lang.Long id;
    /**
     * code       db_column: code 
     */	
	private java.lang.String code;
    /**
     * suppliercode       db_column: suppliercode 
     */	
	private java.lang.String suppliercode;
    /**
     * suppliername       db_column: suppliername 
     */	
	private java.lang.String suppliername;
    /**
     * isfinal       db_column: isfinal 
     */	
	private java.lang.Integer isfinal;
    /**
     * totalamount       db_column: totalamount 
     */	
	private java.lang.Double totalamount;
    /**
     * ccshopId       db_column: ccshop_id 
     */	
	private java.lang.Long ccshopId;
    /**
     * createDatetime       db_column: createDatetime 
     */	
	private java.util.Date createDatetime;
    /**
     * updatedatetime       db_column: updatedatetime 
     */	
	private java.util.Date updatedatetime;
    /**
     * isdeleted       db_column: isdeleted 
     */	
	private java.lang.String isdeleted;
    /**
     * iscomplete       db_column: iscomplete 
     */	
	private java.lang.String iscomplete;
    /**
     * operatepeople       db_column: operatepeople 
     */	
	private java.lang.Long operatepeople;
    /**
     * modeifier       db_column: modeifier 
     */	
	private java.lang.Long modeifier;
	//columns END

	public Finalstatement(){
	}

	public Finalstatement(
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
	public void setCode(java.lang.String value) {
		this.code = value;
	}
	public java.lang.String getCode() {
		return this.code;
	}
	public void setSuppliercode(java.lang.String value) {
		this.suppliercode = value;
	}
	public java.lang.String getSuppliercode() {
		return this.suppliercode;
	}
	public void setSuppliername(java.lang.String value) {
		this.suppliername = value;
	}
	public java.lang.String getSuppliername() {
		return this.suppliername;
	}
	public void setIsfinal(java.lang.Integer value) {
		this.isfinal = value;
	}
	public java.lang.Integer getIsfinal() {
		return this.isfinal;
	}
	public void setTotalamount(java.lang.Double value) {
		this.totalamount = value;
	}
	public java.lang.Double getTotalamount() {
		return this.totalamount;
	}
	public void setCcshopId(java.lang.Long value) {
		this.ccshopId = value;
	}
	public java.lang.Long getCcshopId() {
		return this.ccshopId;
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
	public void setIsdeleted(java.lang.String value) {
		this.isdeleted = value;
	}
	public java.lang.String getIsdeleted() {
		return this.isdeleted;
	}
	public void setIscomplete(java.lang.String value) {
		this.iscomplete = value;
	}
	public java.lang.String getIscomplete() {
		return this.iscomplete;
	}
	public void setOperatepeople(java.lang.Long value) {
		this.operatepeople = value;
	}
	public java.lang.Long getOperatepeople() {
		return this.operatepeople;
	}
	public void setModeifier(java.lang.Long value) {
		this.modeifier = value;
	}
	public java.lang.Long getModeifier() {
		return this.modeifier;
	}
	
	private Set orders = new HashSet(0);
	public void setOrders(Set<Order> order){
		this.orders = order;
	}
	
	public Set<Order> getOrders() {
		return orders;
	}
	
	private Set finalOrders = new HashSet(0);
	public void setFinalOrders(Set<FinalOrder> finalOrder){
		this.finalOrders = finalOrder;
	}
	
	public Set<FinalOrder> getFinalOrders() {
		return finalOrders;
	}
	
	private Admininfo admininfo;
	
	public void setAdmininfo(Admininfo admininfo){
		this.admininfo = admininfo;
	}
	
	public Admininfo getAdmininfo() {
		return admininfo;
	}
	
	private Shop shop;
	
	public void setShop(Shop shop){
		this.shop = shop;
	}
	
	public Shop getShop() {
		return shop;
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
		if(obj instanceof Finalstatement == false) return false;
		if(this == obj) return true;
		Finalstatement other = (Finalstatement)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

