package com.openteach.qsync.core.logistics;



/**
 *
 * @author dingp email:dingp@51box.cn
 * @version 1.0
 * @since 1.0
 * */
public class Transportationcompany {
	
	//alias
	public static final String TABLE_ALIAS = "Transportationcompany";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_TRANSPORTATION_ID = "transportationId";
	public static final String ALIAS_NAME = "name";
	public static final String ALIAS_DAY = "day";
	public static final String ALIAS_URL = "url";
	public static final String ALIAS_ISDELETED = "isdeleted";
	public static final String ALIAS_CREATE_DATETIME = "createDatetime";
	public static final String ALIAS_UPDATEDATETIME = "updatedatetime";
	public static final String ALIAS_CODE = "物流企业编号";
	public static final String ALIAS_ZIP_CODE = "物流企业邮编";
	
	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START
    /**
     * id       db_column: id 
     */	
	private java.lang.Long id;
    /**
     * transportationId       db_column: transportation_id 
     */	
	private java.lang.Long transportationId;
    /**
     * name       db_column: name 
     */	
	private java.lang.String name;
    /**
     * day       db_column: day 
     */	
	private java.lang.String day;
    /**
     * url       db_column: url 
     */	
	private java.lang.String url;
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
     * 物流企业编号       db_column: code 
     */	
	private java.lang.String code;
    /**
     * 物流企业邮编       db_column: zip_code 
     */	
	private java.lang.String zipCode;
	//columns END

	public Transportationcompany(){
	}

	public Transportationcompany(
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
	public void setTransportationId(java.lang.Long value) {
		this.transportationId = value;
	}
	public java.lang.Long getTransportationId() {
		return this.transportationId;
	}
	public void setName(java.lang.String value) {
		this.name = value;
	}
	public java.lang.String getName() {
		return this.name;
	}
	public void setDay(java.lang.String value) {
		this.day = value;
	}
	public java.lang.String getDay() {
		return this.day;
	}
	public void setUrl(java.lang.String value) {
		this.url = value;
	}
	public java.lang.String getUrl() {
		return this.url;
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
	public void setCode(java.lang.String value) {
		this.code = value;
	}
	public java.lang.String getCode() {
		return this.code;
	}
	public void setZipCode(java.lang.String value) {
		this.zipCode = value;
	}
	public java.lang.String getZipCode() {
		return this.zipCode;
	}
}

