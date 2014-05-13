package com.openteach.qsync.core.declare;

/**
 *
 * @author dingp email:dingp@51box.cn
 * @version 1.0
 * @since 1.0
 * */
public class DeclarePayType {
	
	//alias
	public static final String TABLE_ALIAS = "报关支付类型与平台支付类型对应表";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_PLATFORM_PAY_TYPE = "电商平台支付方式 1 paypal 2 skril";
	public static final String ALIAS_PLATFORM_PAY_COMPANY_CODE = "支付公司编码";
	public static final String ALIAS_DECLARE_PAY_TYPE = "报关支付类型 01:银行卡支付 02:余额支付 03:其他";
	public static final String ALIAS_ISDELETED = "isdeleted";
	public static final String ALIAS_CREATEDATETIME = "createdatetime";
	public static final String ALIAS_UPDATEDATETIME = "updatedatetime";
	
	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START
    /**
     * id       db_column: id 
     */	
	private java.lang.Long id;
    /**
     * 电商平台支付方式 1 paypal 2 skril       db_column: platform_pay_type 
     */	
	private java.lang.Integer platformPayType;
    /**
     * 支付公司编码       db_column: platform_pay_company_code 
     */	
	private java.lang.String platformPayCompanyCode;
    /**
     * 报关支付类型 01:银行卡支付 02:余额支付 03:其他       db_column: declare_pay_type 
     */	
	private java.lang.String declarePayType;
    /**
     * isdeleted       db_column: isdeleted 
     */	
	private java.lang.String isdeleted;
    /**
     * createdatetime       db_column: createdatetime 
     */	
	private java.util.Date createdatetime;
    /**
     * updatedatetime       db_column: updatedatetime 
     */	
	private java.util.Date updatedatetime;
	//columns END

	public DeclarePayType(){
	}

	public DeclarePayType(
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
	public void setPlatformPayType(java.lang.Integer value) {
		this.platformPayType = value;
	}
	public java.lang.Integer getPlatformPayType() {
		return this.platformPayType;
	}
	public void setPlatformPayCompanyCode(java.lang.String value) {
		this.platformPayCompanyCode = value;
	}
	public java.lang.String getPlatformPayCompanyCode() {
		return this.platformPayCompanyCode;
	}
	public void setDeclarePayType(java.lang.String value) {
		this.declarePayType = value;
	}
	public java.lang.String getDeclarePayType() {
		return this.declarePayType;
	}
	public void setIsdeleted(java.lang.String value) {
		this.isdeleted = value;
	}
	public java.lang.String getIsdeleted() {
		return this.isdeleted;
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

