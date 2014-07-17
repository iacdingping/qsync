package com.openteach.qsync.core.entity.info;

import javax.validation.constraints.NotNull;



/**
 *
 * @author dingp email:dingp@51box.cn
 * @version 1.0
 * @since 1.0
 * */
public class Province {
	
	//alias
	public static final String TABLE_ALIAS = "Province";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_CODE = "code";
	public static final String ALIAS_NAME = "name";
	public static final String ALIAS_ISDELETED = "isdeleted";
	public static final String ALIAS_COUNTRY_ID = "countryId";
	public static final String ALIAS_CREATOR_ID = "creatorId";
	public static final String ALIAS_MODIFIER_ID = "modifierId";
	public static final String ALIAS_CREATEDATETIME = "createdatetime";
	public static final String ALIAS_UPDATEDATETIME = "updatedatetime";
	
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
     * name       db_column: name 
     */	
	@NotNull(message="省份名称")
	private java.lang.String name;
    /**
     * isdeleted       db_column: isdeleted 
     */	
	private java.lang.String isdeleted;
    /**
     * countryId       db_column: country_id 
     */	
	private java.lang.Long countryId;
    /**
     * creatorId       db_column: creator_id 
     */	
	private java.lang.Long creatorId;
    /**
     * modifierId       db_column: modifier_id 
     */	
	private java.lang.Long modifierId;
    /**
     * createdatetime       db_column: createdatetime 
     */	
	private java.util.Date createdatetime;
    /**
     * updatedatetime       db_column: updatedatetime 
     */	
	private java.util.Date updatedatetime;
	//columns END

	public Province(){
	}

	public Province(
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
	public void setName(java.lang.String value) {
		this.name = value;
	}
	public java.lang.String getName() {
		return this.name;
	}
	public void setIsdeleted(java.lang.String value) {
		this.isdeleted = value;
	}
	public java.lang.String getIsdeleted() {
		return this.isdeleted;
	}
	public void setCountryId(java.lang.Long value) {
		this.countryId = value;
	}
	public java.lang.Long getCountryId() {
		return this.countryId;
	}
	public void setCreatorId(java.lang.Long value) {
		this.creatorId = value;
	}
	public java.lang.Long getCreatorId() {
		return this.creatorId;
	}
	public void setModifierId(java.lang.Long value) {
		this.modifierId = value;
	}
	public java.lang.Long getModifierId() {
		return this.modifierId;
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
}

