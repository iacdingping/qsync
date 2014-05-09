/*
 * Powered By china-telcom
 * Since 2012 - 2014
 */

package com.openteach.qsync.core.order;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import iac.dp.tourism.util.PageQuery;

import com.openteach.qsync.core.order.Admininfo;
import com.openteach.qsync.core.order.AdmininfoDao;
import com.openteach.qsync.core.order.AdmininfoManager;
import com.openteach.qsync.core.order.AdmininfoQuery;


/**
 *
 * @author dingp email:dingp@51box.cn
 * @version 1.0
 * @since 1.0
 * */
public class AdmininfoQuery extends PageQuery {
    

	/** id */
	private java.lang.Long id;
	/** name */
	private java.lang.String name;
	/** password */
	private java.lang.String password;
	/** truename */
	private java.lang.String truename;
	/** telephone */
	private java.lang.String telephone;
	/** handphone */
	private java.lang.String handphone;
	/** qq */
	private java.lang.String qq;
	/** aliww */
	private java.lang.String aliww;
	/** email */
	private java.lang.String email;
	/** lastlogtime */
	private java.util.Date lastlogtimeBegin;
	private java.util.Date lastlogtimeEnd;
	/** isdeleted */
	private java.lang.String isdeleted;
	/** roleId */
	private java.lang.Long roleId;
	/** departId */
	private java.lang.Long departId;

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
	
	public java.lang.String getPassword() {
		return this.password;
	}
	
	public void setPassword(java.lang.String value) {
		this.password = value;
	}
	
	public java.lang.String getTruename() {
		return this.truename;
	}
	
	public void setTruename(java.lang.String value) {
		this.truename = value;
	}
	
	public java.lang.String getTelephone() {
		return this.telephone;
	}
	
	public void setTelephone(java.lang.String value) {
		this.telephone = value;
	}
	
	public java.lang.String getHandphone() {
		return this.handphone;
	}
	
	public void setHandphone(java.lang.String value) {
		this.handphone = value;
	}
	
	public java.lang.String getQq() {
		return this.qq;
	}
	
	public void setQq(java.lang.String value) {
		this.qq = value;
	}
	
	public java.lang.String getAliww() {
		return this.aliww;
	}
	
	public void setAliww(java.lang.String value) {
		this.aliww = value;
	}
	
	public java.lang.String getEmail() {
		return this.email;
	}
	
	public void setEmail(java.lang.String value) {
		this.email = value;
	}
	
	public java.util.Date getLastlogtimeBegin() {
		return this.lastlogtimeBegin;
	}
	
	public void setLastlogtimeBegin(java.util.Date value) {
		this.lastlogtimeBegin = value;
	}	
	
	public java.util.Date getLastlogtimeEnd() {
		return this.lastlogtimeEnd;
	}
	
	public void setLastlogtimeEnd(java.util.Date value) {
		this.lastlogtimeEnd = value;
	}
	
	public java.lang.String getIsdeleted() {
		return this.isdeleted;
	}
	
	public void setIsdeleted(java.lang.String value) {
		this.isdeleted = value;
	}
	
	public java.lang.Long getRoleId() {
		return this.roleId;
	}
	
	public void setRoleId(java.lang.Long value) {
		this.roleId = value;
	}
	
	public java.lang.Long getDepartId() {
		return this.departId;
	}
	
	public void setDepartId(java.lang.Long value) {
		this.departId = value;
	}
	

	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.MULTI_LINE_STYLE);
	}
	
}

