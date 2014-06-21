package com.openteach.qsync.core.entity.goods;

import javax.validation.constraints.NotNull;



/**
 *
 * @author dingp email:dingp@51box.cn
 * @version 1.0
 * @since 1.0
 * */
public class Unit {
	
	//alias
	public static final String TABLE_ALIAS = "Unit";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_NAME = "name";
	public static final String ALIAS_CODE = "code";
	public static final String ALIAS_SORT = "sort";
	public static final String ALIAS_ACCOUNT = "account";
	public static final String ALIAS_CREATEDATE = "createdate";
	public static final String ALIAS_ISDELETED = "isdeleted";
	
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
     * code       db_column: code 
     */	
	@NotNull
	private java.lang.String code;
    /**
     * sort       db_column: sort 
     */	
	private java.lang.String sort;
    /**
     * account       db_column: account 
     */	
	private java.lang.String account;
    /**
     * createdate       db_column: createdate 
     */	
	private java.util.Date createdate;
    /**
     * isdeleted       db_column: isdeleted 
     */	
	private java.lang.String isdeleted;
	//columns END

	public Unit(){
	}

	public Unit(
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
	public void setCode(java.lang.String value) {
		this.code = value;
	}
	public java.lang.String getCode() {
		return this.code;
	}
	public void setSort(java.lang.String value) {
		this.sort = value;
	}
	public java.lang.String getSort() {
		return this.sort;
	}
	public void setAccount(java.lang.String value) {
		this.account = value;
	}
	public java.lang.String getAccount() {
		return this.account;
	}
	public void setCreatedate(java.util.Date value) {
		this.createdate = value;
	}
	public java.util.Date getCreatedate() {
		return this.createdate;
	}
	public void setIsdeleted(java.lang.String value) {
		this.isdeleted = value;
	}
	public java.lang.String getIsdeleted() {
		return this.isdeleted;
	}
}

