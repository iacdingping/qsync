package com.openteach.qsync.core.order;

/**
 *
 * @author dingp email:dingp@51box.cn
 * @version 1.0
 * @since 1.0
 * */
public class OrderTransport {
	
	//alias
	public static final String TABLE_ALIAS = "OrderTransport";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_CODE = "code";
	public static final String ALIAS_CONGSIGNEE = "congsignee";
	public static final String ALIAS_PLACE = "place";
	public static final String ALIAS_WAYBILLNUMBER = "waybillnumber";
	public static final String ALIAS_POSTNUMBER = "postnumber";
	public static final String ALIAS_SOURCE = "source";
	public static final String ALIAS_COUNTRY_ID = "countryId";
	public static final String ALIAS_PROVINCE_ID = "provinceId";
	public static final String ALIAS_CITY_ID = "cityId";
	public static final String ALIAS_DISTRICT_ID = "districtId";
	public static final String ALIAS_ORDER_ID = "orderId";
	public static final String ALIAS_PHONECOUNTRY = "phonecountry";
	public static final String ALIAS_PHONEAREA = "phonearea";
	public static final String ALIAS_PHONE = "phone";
	public static final String ALIAS_FAXCOUNTRY = "faxcountry";
	public static final String ALIAS_FAXAREA = "faxarea";
	public static final String ALIAS_FAX = "fax";
	public static final String ALIAS_HANDPHONECOUNTRY = "handphonecountry";
	public static final String ALIAS_HANDPHONE = "handphone";
	public static final String ALIAS_FIRSTNAME = "firstname";
	public static final String ALIAS_LASTNAME = "lastname";
	public static final String ALIAS_ADDRESS1 = "address1";
	public static final String ALIAS_ADDRESS2 = "address2";
	public static final String ALIAS_SCITY = "scity";
	public static final String ALIAS_SPROVINCE = "sprovince";
	public static final String ALIAS_PHONENUMBER = "phonenumber";
	
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
     * congsignee       db_column: congsignee 
     */	
	private java.lang.String congsignee;
    /**
     * place       db_column: place 
     */	
	private java.lang.String place;
    /**
     * waybillnumber       db_column: waybillnumber 
     */	
	private java.lang.String waybillnumber;
    /**
     * postnumber       db_column: postnumber 
     */	
	private java.lang.String postnumber;
    /**
     * source       db_column: source 
     */	
	private java.lang.Integer source;
    /**
     * countryId       db_column: country_id 
     */	
	private java.lang.Long countryId;
    /**
     * provinceId       db_column: province_id 
     */	
	private java.lang.Long provinceId;
    /**
     * cityId       db_column: city_id 
     */	
	private java.lang.Long cityId;
    /**
     * districtId       db_column: district_id 
     */	
	private java.lang.Long districtId;
    /**
     * orderId       db_column: order_id 
     */	
	private java.lang.Long orderId;
    /**
     * phonecountry       db_column: phonecountry 
     */	
	private java.lang.String phonecountry;
    /**
     * phonearea       db_column: phonearea 
     */	
	private java.lang.String phonearea;
    /**
     * phone       db_column: phone 
     */	
	private java.lang.String phone;
    /**
     * faxcountry       db_column: faxcountry 
     */	
	private java.lang.String faxcountry;
    /**
     * faxarea       db_column: faxarea 
     */	
	private java.lang.String faxarea;
    /**
     * fax       db_column: fax 
     */	
	private java.lang.String fax;
    /**
     * handphonecountry       db_column: handphonecountry 
     */	
	private java.lang.String handphonecountry;
    /**
     * handphone       db_column: handphone 
     */	
	private java.lang.String handphone;
    /**
     * firstname       db_column: firstname 
     */	
	private java.lang.String firstname;
    /**
     * lastname       db_column: lastname 
     */	
	private java.lang.String lastname;
    /**
     * address1       db_column: address1 
     */	
	private java.lang.String address1;
    /**
     * address2       db_column: address2 
     */	
	private java.lang.String address2;
    /**
     * scity       db_column: scity 
     */	
	private java.lang.String scity;
    /**
     * sprovince       db_column: sprovince 
     */	
	private java.lang.String sprovince;
    /**
     * phonenumber       db_column: phonenumber 
     */	
	private java.lang.String phonenumber;
	//columns END

	public OrderTransport(){
	}

	public OrderTransport(
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
	public void setCongsignee(java.lang.String value) {
		this.congsignee = value;
	}
	public java.lang.String getCongsignee() {
		return this.congsignee;
	}
	public void setPlace(java.lang.String value) {
		this.place = value;
	}
	public java.lang.String getPlace() {
		return this.place;
	}
	public void setWaybillnumber(java.lang.String value) {
		this.waybillnumber = value;
	}
	public java.lang.String getWaybillnumber() {
		return this.waybillnumber;
	}
	public void setPostnumber(java.lang.String value) {
		this.postnumber = value;
	}
	public java.lang.String getPostnumber() {
		return this.postnumber;
	}
	public void setSource(java.lang.Integer value) {
		this.source = value;
	}
	public java.lang.Integer getSource() {
		return this.source;
	}
	public void setCountryId(java.lang.Long value) {
		this.countryId = value;
	}
	public java.lang.Long getCountryId() {
		return this.countryId;
	}
	public void setProvinceId(java.lang.Long value) {
		this.provinceId = value;
	}
	public java.lang.Long getProvinceId() {
		return this.provinceId;
	}
	public void setCityId(java.lang.Long value) {
		this.cityId = value;
	}
	public java.lang.Long getCityId() {
		return this.cityId;
	}
	public void setDistrictId(java.lang.Long value) {
		this.districtId = value;
	}
	public java.lang.Long getDistrictId() {
		return this.districtId;
	}
	public void setOrderId(java.lang.Long value) {
		this.orderId = value;
	}
	public java.lang.Long getOrderId() {
		return this.orderId;
	}
	public void setPhonecountry(java.lang.String value) {
		this.phonecountry = value;
	}
	public java.lang.String getPhonecountry() {
		return this.phonecountry;
	}
	public void setPhonearea(java.lang.String value) {
		this.phonearea = value;
	}
	public java.lang.String getPhonearea() {
		return this.phonearea;
	}
	public void setPhone(java.lang.String value) {
		this.phone = value;
	}
	public java.lang.String getPhone() {
		return this.phone;
	}
	public void setFaxcountry(java.lang.String value) {
		this.faxcountry = value;
	}
	public java.lang.String getFaxcountry() {
		return this.faxcountry;
	}
	public void setFaxarea(java.lang.String value) {
		this.faxarea = value;
	}
	public java.lang.String getFaxarea() {
		return this.faxarea;
	}
	public void setFax(java.lang.String value) {
		this.fax = value;
	}
	public java.lang.String getFax() {
		return this.fax;
	}
	public void setHandphonecountry(java.lang.String value) {
		this.handphonecountry = value;
	}
	public java.lang.String getHandphonecountry() {
		return this.handphonecountry;
	}
	public void setHandphone(java.lang.String value) {
		this.handphone = value;
	}
	public java.lang.String getHandphone() {
		return this.handphone;
	}
	public void setFirstname(java.lang.String value) {
		this.firstname = value;
	}
	public java.lang.String getFirstname() {
		return this.firstname;
	}
	public void setLastname(java.lang.String value) {
		this.lastname = value;
	}
	public java.lang.String getLastname() {
		return this.lastname;
	}
	public void setAddress1(java.lang.String value) {
		this.address1 = value;
	}
	public java.lang.String getAddress1() {
		return this.address1;
	}
	public void setAddress2(java.lang.String value) {
		this.address2 = value;
	}
	public java.lang.String getAddress2() {
		return this.address2;
	}
	public void setScity(java.lang.String value) {
		this.scity = value;
	}
	public java.lang.String getScity() {
		return this.scity;
	}
	public void setSprovince(java.lang.String value) {
		this.sprovince = value;
	}
	public java.lang.String getSprovince() {
		return this.sprovince;
	}
	public void setPhonenumber(java.lang.String value) {
		this.phonenumber = value;
	}
	public java.lang.String getPhonenumber() {
		return this.phonenumber;
	}
}

