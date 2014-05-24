package com.openteach.qsync.core.entity.system;



/**
 *
 * @author dingp email:dingp@51box.cn
 * @version 1.0
 * @since 1.0
 * */
public class CcSyncTaks {
	
	//alias
	public static final String TABLE_ALIAS = "申报任务";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_GENERATOR = "generator";
	public static final String ALIAS_TYPE = "type";
	public static final String ALIAS_STATUS = "status";
	public static final String ALIAS_XML_REQUEST = "xmlRequest";
	public static final String ALIAS_XML_RESPONSE = "xmlResponse";
	public static final String ALIAS_EXCEPTION = "exception";
	public static final String ALIAS_GMT_CREATE = "gmtCreate";
	public static final String ALIAS_GMT_MODIFIED = "gmtModified";
	
	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START
    /**
     * id       db_column: id 
     */	
	private java.lang.Long id;
	
	private Long orderId;
    /**
     * generator       db_column: generator 
     */	
	private java.lang.String generator;
    /**
     * type       db_column: type 
     */	
	private java.lang.String type;
    /**
     * status       db_column: status 
     */	
	private java.lang.String status;
    /**
     * xmlRequest       db_column: xml_request 
     */	
	private java.lang.String xmlRequest;
    /**
     * xmlResponse       db_column: xml_response 
     */	
	private java.lang.String xmlResponse;
    /**
     * exception       db_column: exception 
     */	
	private java.lang.String exception;
    /**
     * gmtCreate       db_column: gmt_create 
     */	
	private java.util.Date gmtCreate;
    /**
     * gmtModified       db_column: gmt_modified 
     */	
	private java.util.Date gmtModified;
	//columns END

	public CcSyncTaks(){
	}

	public CcSyncTaks(
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
	public void setGenerator(java.lang.String value) {
		this.generator = value;
	}
	public java.lang.String getGenerator() {
		return this.generator;
	}
	public void setType(java.lang.String value) {
		this.type = value;
	}
	public java.lang.String getType() {
		return this.type;
	}
	public void setStatus(java.lang.String value) {
		this.status = value;
	}
	public java.lang.String getStatus() {
		return this.status;
	}
	public void setXmlRequest(java.lang.String value) {
		this.xmlRequest = value;
	}
	public java.lang.String getXmlRequest() {
		return this.xmlRequest;
	}
	public void setXmlResponse(java.lang.String value) {
		this.xmlResponse = value;
	}
	public java.lang.String getXmlResponse() {
		return this.xmlResponse;
	}
	public void setException(java.lang.String value) {
		this.exception = value;
	}
	public java.lang.String getException() {
		return this.exception;
	}
	public void setGmtCreate(java.util.Date value) {
		this.gmtCreate = value;
	}
	public java.util.Date getGmtCreate() {
		return this.gmtCreate;
	}
	public void setGmtModified(java.util.Date value) {
		this.gmtModified = value;
	}
	public java.util.Date getGmtModified() {
		return this.gmtModified;
	}
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
}

