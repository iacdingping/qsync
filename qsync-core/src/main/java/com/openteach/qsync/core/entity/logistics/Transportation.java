package com.openteach.qsync.core.entity.logistics;

import javax.validation.constraints.NotNull;



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
	public static final String ALIAS_TYPE = "1 邮政小包 2 快件 3 EMS";
	public static final String ALIAS_TOOL_FLT_NO = "运输工具航次(班)号";
	public static final String ALIAS_TYPE_CODE = "参照运输方式代码表(TRANSF)";
	public static final String ALIAS_FROM_COUNTRY = "贸易国别（起运地）";
	public static final String ALIAS_PACK_TYPE = "包装种类 1 木箱 2 纸箱 3 桶装 4 散装 5 托盘 6 包 7 其它";
	public static final String ALIAS_APPLICATION_FORM_NO = "申请单编号 保税进口必填，指仓储企业事先在辅助系统申请的分送集报申请单编号";
	
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
    /**
     * 1 邮政小包 2 快件 3 EMS       db_column: type 
     */	
	@NotNull
	private java.lang.Integer type;
    /**
     * 运输工具航次(班)号       db_column: tool_flt_no 
     */	
	private java.lang.String toolFltNo;
    /**
     * 参照运输方式代码表(TRANSF)       db_column: type_code 
     */	
	private java.lang.String typeCode;
    /**
     * 贸易国别（起运地）       db_column: from_country 
     */	
	private java.lang.Long fromCountry;
    /**
     * 包装种类 1 木箱 2 纸箱 3 桶装 4 散装 5 托盘 6 包 7 其它       db_column: pack_type 
     */	
	private java.lang.String packType;
    /**
     * 申请单编号 保税进口必填，指仓储企业事先在辅助系统申请的分送集报申请单编号       db_column: application_form_no 
     */	
	private java.lang.String applicationFormNo;
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
	@NotNull
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
	public void setType(java.lang.Integer value) {
		this.type = value;
	}
	public java.lang.Integer getType() {
		return this.type;
	}
	public void setToolFltNo(java.lang.String value) {
		this.toolFltNo = value;
	}
	@NotNull
	public java.lang.String getToolFltNo() {
		return this.toolFltNo;
	}
	public void setTypeCode(java.lang.String value) {
		this.typeCode = value;
	}
	@NotNull
	public java.lang.String getTypeCode() {
		return this.typeCode;
	}
	@NotNull
	public java.lang.Long getFromCountry() {
		return fromCountry;
	}
	public void setFromCountry(java.lang.Long fromCountry) {
		this.fromCountry = fromCountry;
	}
	public void setPackType(java.lang.String value) {
		this.packType = value;
	}
	@NotNull
	public java.lang.String getPackType() {
		return this.packType;
	}
	public void setApplicationFormNo(java.lang.String value) {
		this.applicationFormNo = value;
	}
	@NotNull
	public java.lang.String getApplicationFormNo() {
		return this.applicationFormNo;
	}
}

