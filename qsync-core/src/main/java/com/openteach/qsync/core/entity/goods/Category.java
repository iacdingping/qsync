package com.openteach.qsync.core.entity.goods;

import javax.validation.constraints.NotNull;



/**
 *
 * @author dingp email:dingp@51box.cn
 * @version 1.0
 * @since 1.0
 * */
public class Category {
	
	//alias
	public static final String TABLE_ALIAS = "Category";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_NAME = "name";
	public static final String ALIAS_PICURL = "picurl";
	public static final String ALIAS_PIC = "pic";
	public static final String ALIAS_ISPARENT = "isparent";
	public static final String ALIAS_ISSHOW = "isshow";
	public static final String ALIAS_LISTORDER = "listorder";
	public static final String ALIAS_ISDELETED = "isdeleted";
	public static final String ALIAS_CID = "cid";
	public static final String ALIAS_SOURCE = "source";
	public static final String ALIAS_HIGHID = "highid";
	public static final String ALIAS_CREATORADMIN = "creatoradmin";
	public static final String ALIAS_MODIFIERADMIN = "modifieradmin";
	public static final String ALIAS_CREATEDATETIME = "createdatetime";
	public static final String ALIAS_UPDATEDATETIME = "updatedatetime";
	public static final String ALIAS_SEOKEYWORD = "seokeyword";
	public static final String ALIAS_SEODESCRIPTION = "seodescription";
	public static final String ALIAS_TAXRATE = "taxrate";
	public static final String ALIAS_TARIFF = "行邮税号 必须已备案，且与参数说明文档中的行邮税号中的税号一致";
	
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
     * pic       db_column: pic 
     */	
	private java.lang.String pic;
    /**
     * isparent       db_column: isparent 
     */	
	private java.lang.String isparent;
    /**
     * isshow       db_column: isshow 
     */	
	private java.lang.String isshow;
    /**
     * listorder       db_column: listorder 
     */	
	private java.lang.Integer listorder;
    /**
     * isdeleted       db_column: isdeleted 
     */	
	private java.lang.String isdeleted;
    /**
     * cid       db_column: cid 
     */	
	private java.lang.Long cid;
    /**
     * source       db_column: source 
     */	
	private java.lang.Integer source;
    /**
     * highid       db_column: highid 
     */	
	private java.lang.Long highid;
    /**
     * creatoradmin       db_column: creatoradmin 
     */	
	private java.lang.Long creatoradmin;
    /**
     * modifieradmin       db_column: modifieradmin 
     */	
	private java.lang.Long modifieradmin;
    /**
     * createdatetime       db_column: createdatetime 
     */	
	private java.util.Date createdatetime;
    /**
     * updatedatetime       db_column: updatedatetime 
     */	
	private java.util.Date updatedatetime;
    /**
     * seokeyword       db_column: seokeyword 
     */	
	private java.lang.String seokeyword;
    /**
     * seodescription       db_column: seodescription 
     */	
	private java.lang.String seodescription;
    /**
     * taxrate       db_column: taxrate 
     */	
	private java.lang.Double taxrate;
    /**
     * 行邮税号 必须已备案，且与参数说明文档中的行邮税号中的税号一致       db_column: tariff 
     */	
	@NotNull
	private java.lang.String tariff;
	//columns END

	public Category(){
	}

	public Category(
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
	public void setPic(java.lang.String value) {
		this.pic = value;
	}
	public java.lang.String getPic() {
		return this.pic;
	}
	public void setIsparent(java.lang.String value) {
		this.isparent = value;
	}
	public java.lang.String getIsparent() {
		return this.isparent;
	}
	public void setIsshow(java.lang.String value) {
		this.isshow = value;
	}
	public java.lang.String getIsshow() {
		return this.isshow;
	}
	public void setListorder(java.lang.Integer value) {
		this.listorder = value;
	}
	public java.lang.Integer getListorder() {
		return this.listorder;
	}
	public void setIsdeleted(java.lang.String value) {
		this.isdeleted = value;
	}
	public java.lang.String getIsdeleted() {
		return this.isdeleted;
	}
	public void setCid(java.lang.Long value) {
		this.cid = value;
	}
	public java.lang.Long getCid() {
		return this.cid;
	}
	public void setSource(java.lang.Integer value) {
		this.source = value;
	}
	public java.lang.Integer getSource() {
		return this.source;
	}
	public void setHighid(java.lang.Long value) {
		this.highid = value;
	}
	public java.lang.Long getHighid() {
		return this.highid;
	}
	public void setCreatoradmin(java.lang.Long value) {
		this.creatoradmin = value;
	}
	public java.lang.Long getCreatoradmin() {
		return this.creatoradmin;
	}
	public void setModifieradmin(java.lang.Long value) {
		this.modifieradmin = value;
	}
	public java.lang.Long getModifieradmin() {
		return this.modifieradmin;
	}
	public void setCreatedatetime(java.util.Date value) {
		this.createdatetime = value;
	}
	public java.util.Date getCreatedatetime() {
		return this.createdatetime;
	}
	public void setUpdatedatetime(java.util.Date value) {
		this.updatedatetime = value;
	}
	public java.util.Date getUpdatedatetime() {
		return this.updatedatetime;
	}
	public void setSeokeyword(java.lang.String value) {
		this.seokeyword = value;
	}
	public java.lang.String getSeokeyword() {
		return this.seokeyword;
	}
	public void setSeodescription(java.lang.String value) {
		this.seodescription = value;
	}
	public java.lang.String getSeodescription() {
		return this.seodescription;
	}
	public void setTaxrate(java.lang.Double value) {
		this.taxrate = value;
	}
	public java.lang.Double getTaxrate() {
		return this.taxrate;
	}
	public void setTariff(java.lang.String value) {
		this.tariff = value;
	}
	public java.lang.String getTariff() {
		return this.tariff;
	}
}

