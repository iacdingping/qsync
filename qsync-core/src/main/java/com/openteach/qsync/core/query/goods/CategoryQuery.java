package com.openteach.qsync.core.query.goods;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.openteach.qsync.core.PageQuery;


/**
 *
 * @author dingp email:dingp@51box.cn
 * @version 1.0
 * @since 1.0
 * */
public class CategoryQuery extends PageQuery {
    

	/** id */
	private java.lang.Long id;
	/** name */
	private java.lang.String name;
	/** picurl */
	private java.lang.String picurl;
	/** pic */
	private java.lang.String pic;
	/** isparent */
	private java.lang.String isparent;
	/** isshow */
	private java.lang.String isshow;
	/** listorder */
	private java.lang.Integer listorder;
	/** isdeleted */
	private java.lang.String isdeleted;
	/** cid */
	private java.lang.Long cid;
	/** source */
	private java.lang.Integer source;
	/** highid */
	private java.lang.Long highid;
	/** creatoradmin */
	private java.lang.Long creatoradmin;
	/** modifieradmin */
	private java.lang.Long modifieradmin;
	/** createdatetime */
	private java.util.Date createdatetimeBegin;
	private java.util.Date createdatetimeEnd;
	/** updatedatetime */
	private java.util.Date updatedatetimeBegin;
	private java.util.Date updatedatetimeEnd;
	/** seokeyword */
	private java.lang.String seokeyword;
	/** seodescription */
	private java.lang.String seodescription;
	/** taxrate */
	private java.lang.Double taxrate;
	/** 行邮税号 必须已备案，且与参数说明文档中的行邮税号中的税号一致 */
	private java.lang.String tariff;

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
	
	public java.lang.String getPicurl() {
		return this.picurl;
	}
	
	public void setPicurl(java.lang.String value) {
		this.picurl = value;
	}
	
	public java.lang.String getPic() {
		return this.pic;
	}
	
	public void setPic(java.lang.String value) {
		this.pic = value;
	}
	
	public java.lang.String getIsparent() {
		return this.isparent;
	}
	
	public void setIsparent(java.lang.String value) {
		this.isparent = value;
	}
	
	public java.lang.String getIsshow() {
		return this.isshow;
	}
	
	public void setIsshow(java.lang.String value) {
		this.isshow = value;
	}
	
	public java.lang.Integer getListorder() {
		return this.listorder;
	}
	
	public void setListorder(java.lang.Integer value) {
		this.listorder = value;
	}
	
	public java.lang.String getIsdeleted() {
		return this.isdeleted;
	}
	
	public void setIsdeleted(java.lang.String value) {
		this.isdeleted = value;
	}
	
	public java.lang.Long getCid() {
		return this.cid;
	}
	
	public void setCid(java.lang.Long value) {
		this.cid = value;
	}
	
	public java.lang.Integer getSource() {
		return this.source;
	}
	
	public void setSource(java.lang.Integer value) {
		this.source = value;
	}
	
	public java.lang.Long getHighid() {
		return this.highid;
	}
	
	public void setHighid(java.lang.Long value) {
		this.highid = value;
	}
	
	public java.lang.Long getCreatoradmin() {
		return this.creatoradmin;
	}
	
	public void setCreatoradmin(java.lang.Long value) {
		this.creatoradmin = value;
	}
	
	public java.lang.Long getModifieradmin() {
		return this.modifieradmin;
	}
	
	public void setModifieradmin(java.lang.Long value) {
		this.modifieradmin = value;
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
	
	public java.lang.String getSeokeyword() {
		return this.seokeyword;
	}
	
	public void setSeokeyword(java.lang.String value) {
		this.seokeyword = value;
	}
	
	public java.lang.String getSeodescription() {
		return this.seodescription;
	}
	
	public void setSeodescription(java.lang.String value) {
		this.seodescription = value;
	}
	
	public java.lang.Double getTaxrate() {
		return this.taxrate;
	}
	
	public void setTaxrate(java.lang.Double value) {
		this.taxrate = value;
	}
	
	public java.lang.String getTariff() {
		return this.tariff;
	}
	
	public void setTariff(java.lang.String value) {
		this.tariff = value;
	}
	

	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.MULTI_LINE_STYLE);
	}
	
}

