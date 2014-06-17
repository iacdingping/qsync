package com.openteach.qsync.core.entity.info;

import javax.validation.constraints.NotNull;



/**
 *
 * @author dingp email:dingp@51box.cn
 * @version 1.0
 * @since 1.0
 * */
public class Member {
	
	//alias
	public static final String TABLE_ALIAS = "Member";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_USERNAME = "username";
	public static final String ALIAS_PICURL = "picurl";
	public static final String ALIAS_RANDOMCODE = "randomcode";
	public static final String ALIAS_EMAIL = "email";
	public static final String ALIAS_PASSWORD = "password";
	public static final String ALIAS_STATUS = "status";
	public static final String ALIAS_LEFTAMOUNT = "leftamount";
	public static final String ALIAS_REGTIME = "regtime";
	public static final String ALIAS_TRUENAME = "truename";
	public static final String ALIAS_HANDPHONE = "handphone";
	public static final String ALIAS_TELEPHONE = "telephone";
	public static final String ALIAS_PAYAMOUNT = "payamount";
	public static final String ALIAS_SCORE = "score";
	public static final String ALIAS_LASTLOGTIME = "lastlogtime";
	public static final String ALIAS_SECONDLOGTIME = "secondlogtime";
	public static final String ALIAS_SEX = "sex";
	public static final String ALIAS_BIRTHDAY = "birthday";
	public static final String ALIAS_AGE = "age";
	public static final String ALIAS_NICKNAME = "nickname";
	public static final String ALIAS_SOURCE = "source";
	public static final String ALIAS_SOURCEID = "sourceid";
	public static final String ALIAS_ORDERTIME = "ordertime";
	public static final String ALIAS_RESTPASSTIME = "restpasstime";
	public static final String ALIAS_ISDELETED = "isdeleted";
	public static final String ALIAS_COUNTRY_ID = "countryId";
	public static final String ALIAS_PROVINCE_ID = "provinceId";
	public static final String ALIAS_CITY_ID = "cityId";
	public static final String ALIAS_ADDRESS = "address";
	public static final String ALIAS_COMPANY = "company";
	public static final String ALIAS_FIRSTNAME = "firstname";
	public static final String ALIAS_LASTNAME = "lastname";
	public static final String ALIAS_GRADE = "grade";
	public static final String ALIAS_CODE = "code";
	public static final String ALIAS_COMPANYPHONECOUNTRY = "companyphonecountry";
	public static final String ALIAS_COMPANYPHONEAREA = "companyphonearea";
	public static final String ALIAS_COMPANYPHONE = "companyphone";
	public static final String ALIAS_COMPANYFAXCOUNTRY = "companyfaxcountry";
	public static final String ALIAS_COMPANYFAXAREA = "companyfaxarea";
	public static final String ALIAS_COMPANYFAX = "companyfax";
	public static final String ALIAS_COMPANYHANDPHONECOUNTRY = "companyhandphonecountry";
	public static final String ALIAS_COMPANYHANDPHONE = "companyhandphone";
	public static final String ALIAS_ESTABLISHED = "established";
	public static final String ALIAS_REGISTRATIONID = "registrationid";
	public static final String ALIAS_PRODUCTSSCOPE = "productsscope";
	public static final String ALIAS_SALESVOLUME = "salesvolume";
	public static final String ALIAS_IMPORTVOLUME = "importvolume";
	public static final String ALIAS_DESCRIPTION = "description";
	public static final String ALIAS_TITLE = "title";
	public static final String ALIAS_COMPANYADDRESS = "companyaddress";
	public static final String ALIAS_WEBSITE = "website";
	public static final String ALIAS_COMPANYCOUNTRY_ID = "companycountryId";
	public static final String ALIAS_COMPANYPROVINCE_ID = "companyprovinceId";
	public static final String ALIAS_COMPANYCITY_ID = "companycityId";
	public static final String ALIAS_NEWNEW = "newnew";
	public static final String ALIAS_FEEDBACK = "feedback";
	public static final String ALIAS_TRADEGUIDE = "tradeguide";
	public static final String ALIAS_OPTIMIZATIONHINTS = "optimizationhints";
	public static final String ALIAS_VIPAUDIT = "vipaudit";
	public static final String ALIAS_ADDRESS1 = "address1";
	public static final String ALIAS_ADDRESS2 = "address2";
	public static final String ALIAS_SCITY = "scity";
	public static final String ALIAS_SPROVINCE = "sprovince";
	public static final String ALIAS_ZIP = "zip";
	public static final String ALIAS_PHONENUMBER = "phonenumber";
	public static final String ALIAS_CCITY = "ccity";
	public static final String ALIAS_CPROVINCE = "cprovince";
	public static final String ALIAS_POSITON = "positon";
	public static final String ALIAS_CONTACTMAIL = "contactmail";
	public static final String ALIAS_POSTALCODE = "postalcode";
	public static final String ALIAS_CLOSECOUNT = "closecount";
	public static final String ALIAS_CLOSE_TIME = "closeTime";
	public static final String ALIAS_CERTIFICATES_TYPE = "证件类型 01:身份证（试点期间只能是身份证） 02:护照 03:其他";
	public static final String ALIAS_CERTIFICATES = "证件号码";
	
	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START
    /**
     * id       db_column: id 
     */	
	private java.lang.Long id;
    /**
     * username       db_column: username 
     */	
	private java.lang.String username;
    /**
     * picurl       db_column: picurl 
     */	
	private java.lang.String picurl;
    /**
     * randomcode       db_column: randomcode 
     */	
	private java.lang.String randomcode;
    /**
     * email       db_column: email 
     */	
	@NotNull
	private java.lang.String email;
    /**
     * password       db_column: password 
     */	
	private java.lang.String password;
    /**
     * status       db_column: status 
     */	
	private java.lang.Integer status;
    /**
     * leftamount       db_column: leftamount 
     */	
	private java.lang.Double leftamount;
    /**
     * regtime       db_column: regtime 
     */	
	private java.util.Date regtime;
    /**
     * truename       db_column: truename 
     */	
	@NotNull
	private java.lang.String truename;
    /**
     * handphone       db_column: handphone 
     */	
	private java.lang.String handphone;
    /**
     * telephone       db_column: telephone 
     */	
	@NotNull
	private java.lang.String telephone;
    /**
     * payamount       db_column: payamount 
     */	
	private java.lang.Double payamount;
    /**
     * score       db_column: score 
     */	
	private java.lang.Integer score;
    /**
     * lastlogtime       db_column: lastlogtime 
     */	
	private java.util.Date lastlogtime;
    /**
     * secondlogtime       db_column: secondlogtime 
     */	
	private java.util.Date secondlogtime;
    /**
     * sex       db_column: sex 
     */	
	private java.lang.Integer sex;
    /**
     * birthday       db_column: birthday 
     */	
	private java.util.Date birthday;
    /**
     * age       db_column: age 
     */	
	private java.lang.Integer age;
    /**
     * nickname       db_column: nickname 
     */	
	private java.lang.String nickname;
    /**
     * source       db_column: source 
     */	
	private java.lang.Integer source;
    /**
     * sourceid       db_column: sourceid 
     */	
	private java.lang.String sourceid;
    /**
     * ordertime       db_column: ordertime 
     */	
	private java.util.Date ordertime;
    /**
     * restpasstime       db_column: restpasstime 
     */	
	private java.util.Date restpasstime;
    /**
     * isdeleted       db_column: isdeleted 
     */	
	private java.lang.Integer isdeleted;
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
     * address       db_column: address 
     */	
	@NotNull
	private java.lang.String address;
    /**
     * company       db_column: company 
     */	
	private java.lang.String company;
    /**
     * firstname       db_column: firstname 
     */	
	private java.lang.String firstname;
    /**
     * lastname       db_column: lastname 
     */	
	private java.lang.String lastname;
    /**
     * grade       db_column: grade 
     */	
	private java.lang.Integer grade;
    /**
     * code       db_column: code 
     */	
	private java.lang.String code;
    /**
     * companyphonecountry       db_column: companyphonecountry 
     */	
	private java.lang.String companyphonecountry;
    /**
     * companyphonearea       db_column: companyphonearea 
     */	
	private java.lang.String companyphonearea;
    /**
     * companyphone       db_column: companyphone 
     */	
	private java.lang.String companyphone;
    /**
     * companyfaxcountry       db_column: companyfaxcountry 
     */	
	private java.lang.String companyfaxcountry;
    /**
     * companyfaxarea       db_column: companyfaxarea 
     */	
	private java.lang.String companyfaxarea;
    /**
     * companyfax       db_column: companyfax 
     */	
	private java.lang.String companyfax;
    /**
     * companyhandphonecountry       db_column: companyhandphonecountry 
     */	
	private java.lang.String companyhandphonecountry;
    /**
     * companyhandphone       db_column: companyhandphone 
     */	
	private java.lang.String companyhandphone;
    /**
     * established       db_column: established 
     */	
	private java.util.Date established;
    /**
     * registrationid       db_column: registrationid 
     */	
	private java.lang.String registrationid;
    /**
     * productsscope       db_column: productsscope 
     */	
	private java.lang.String productsscope;
    /**
     * salesvolume       db_column: salesvolume 
     */	
	private java.lang.String salesvolume;
    /**
     * importvolume       db_column: importvolume 
     */	
	private java.lang.String importvolume;
    /**
     * description       db_column: description 
     */	
	private java.lang.String description;
    /**
     * title       db_column: title 
     */	
	private java.lang.Integer title;
    /**
     * companyaddress       db_column: companyaddress 
     */	
	private java.lang.String companyaddress;
    /**
     * website       db_column: website 
     */	
	private java.lang.String website;
    /**
     * companycountryId       db_column: companycountry_id 
     */	
	private java.lang.Long companycountryId;
    /**
     * companyprovinceId       db_column: companyprovince_id 
     */	
	private java.lang.Long companyprovinceId;
    /**
     * companycityId       db_column: companycity_id 
     */	
	private java.lang.Long companycityId;
    /**
     * newnew       db_column: newnew 
     */	
	private java.lang.String newnew;
    /**
     * feedback       db_column: feedback 
     */	
	private java.lang.String feedback;
    /**
     * tradeguide       db_column: tradeguide 
     */	
	private java.lang.String tradeguide;
    /**
     * optimizationhints       db_column: optimizationhints 
     */	
	private java.lang.String optimizationhints;
    /**
     * vipaudit       db_column: vipaudit 
     */	
	private java.lang.Integer vipaudit;
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
     * zip       db_column: zip 
     */	
	private java.lang.String zip;
    /**
     * phonenumber       db_column: phonenumber 
     */	
	private java.lang.String phonenumber;
    /**
     * ccity       db_column: ccity 
     */	
	private java.lang.String ccity;
    /**
     * cprovince       db_column: cprovince 
     */	
	private java.lang.String cprovince;
    /**
     * positon       db_column: positon 
     */	
	private java.lang.String positon;
    /**
     * contactmail       db_column: contactmail 
     */	
	private java.lang.String contactmail;
    /**
     * postalcode       db_column: postalcode 
     */	
	private java.lang.String postalcode;
    /**
     * closecount       db_column: closecount 
     */	
	private java.lang.Integer closecount;
    /**
     * closeTime       db_column: closeTime 
     */	
	private java.util.Date closeTime;
    /**
     * 证件类型 01:身份证（试点期间只能是身份证） 02:护照 03:其他       db_column: certificates_type 
     */	
	@NotNull
	private java.lang.String certificatesType;
    /**
     * 证件号码       db_column: certificates 
     */	
	@NotNull
	private java.lang.String certificates;
	//columns END

	public Member(){
	}

	public Member(
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
	public void setUsername(java.lang.String value) {
		this.username = value;
	}
	public java.lang.String getUsername() {
		return this.username;
	}
	public void setPicurl(java.lang.String value) {
		this.picurl = value;
	}
	public java.lang.String getPicurl() {
		return this.picurl;
	}
	public void setRandomcode(java.lang.String value) {
		this.randomcode = value;
	}
	public java.lang.String getRandomcode() {
		return this.randomcode;
	}
	public void setEmail(java.lang.String value) {
		this.email = value;
	}
	public java.lang.String getEmail() {
		return this.email;
	}
	public void setPassword(java.lang.String value) {
		this.password = value;
	}
	public java.lang.String getPassword() {
		return this.password;
	}
	public void setStatus(java.lang.Integer value) {
		this.status = value;
	}
	public java.lang.Integer getStatus() {
		return this.status;
	}
	public void setLeftamount(java.lang.Double value) {
		this.leftamount = value;
	}
	public java.lang.Double getLeftamount() {
		return this.leftamount;
	}
	public void setRegtime(java.util.Date value) {
		this.regtime = value;
	}
	public java.util.Date getRegtime() {
		return this.regtime;
	}
	public void setTruename(java.lang.String value) {
		this.truename = value;
	}
	public java.lang.String getTruename() {
		return this.truename;
	}
	public void setHandphone(java.lang.String value) {
		this.handphone = value;
	}
	public java.lang.String getHandphone() {
		return this.handphone;
	}
	public void setTelephone(java.lang.String value) {
		this.telephone = value;
	}
	public java.lang.String getTelephone() {
		return this.telephone;
	}
	public void setPayamount(java.lang.Double value) {
		this.payamount = value;
	}
	public java.lang.Double getPayamount() {
		return this.payamount;
	}
	public void setScore(java.lang.Integer value) {
		this.score = value;
	}
	public java.lang.Integer getScore() {
		return this.score;
	}
	public void setLastlogtime(java.util.Date value) {
		this.lastlogtime = value;
	}
	public java.util.Date getLastlogtime() {
		return this.lastlogtime;
	}
	public void setSecondlogtime(java.util.Date value) {
		this.secondlogtime = value;
	}
	public java.util.Date getSecondlogtime() {
		return this.secondlogtime;
	}
	public void setSex(java.lang.Integer value) {
		this.sex = value;
	}
	public java.lang.Integer getSex() {
		return this.sex;
	}
	public void setBirthday(java.util.Date value) {
		this.birthday = value;
	}
	public java.util.Date getBirthday() {
		return this.birthday;
	}
	public void setAge(java.lang.Integer value) {
		this.age = value;
	}
	public java.lang.Integer getAge() {
		return this.age;
	}
	public void setNickname(java.lang.String value) {
		this.nickname = value;
	}
	public java.lang.String getNickname() {
		return this.nickname;
	}
	public void setSource(java.lang.Integer value) {
		this.source = value;
	}
	public java.lang.Integer getSource() {
		return this.source;
	}
	public void setSourceid(java.lang.String value) {
		this.sourceid = value;
	}
	public java.lang.String getSourceid() {
		return this.sourceid;
	}
	public void setOrdertime(java.util.Date value) {
		this.ordertime = value;
	}
	public java.util.Date getOrdertime() {
		return this.ordertime;
	}
	public void setRestpasstime(java.util.Date value) {
		this.restpasstime = value;
	}
	public java.util.Date getRestpasstime() {
		return this.restpasstime;
	}
	public void setIsdeleted(java.lang.Integer value) {
		this.isdeleted = value;
	}
	public java.lang.Integer getIsdeleted() {
		return this.isdeleted;
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
	public void setAddress(java.lang.String value) {
		this.address = value;
	}
	public java.lang.String getAddress() {
		return this.address;
	}
	public void setCompany(java.lang.String value) {
		this.company = value;
	}
	public java.lang.String getCompany() {
		return this.company;
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
	public void setGrade(java.lang.Integer value) {
		this.grade = value;
	}
	public java.lang.Integer getGrade() {
		return this.grade;
	}
	public void setCode(java.lang.String value) {
		this.code = value;
	}
	public java.lang.String getCode() {
		return this.code;
	}
	public void setCompanyphonecountry(java.lang.String value) {
		this.companyphonecountry = value;
	}
	public java.lang.String getCompanyphonecountry() {
		return this.companyphonecountry;
	}
	public void setCompanyphonearea(java.lang.String value) {
		this.companyphonearea = value;
	}
	public java.lang.String getCompanyphonearea() {
		return this.companyphonearea;
	}
	public void setCompanyphone(java.lang.String value) {
		this.companyphone = value;
	}
	public java.lang.String getCompanyphone() {
		return this.companyphone;
	}
	public void setCompanyfaxcountry(java.lang.String value) {
		this.companyfaxcountry = value;
	}
	public java.lang.String getCompanyfaxcountry() {
		return this.companyfaxcountry;
	}
	public void setCompanyfaxarea(java.lang.String value) {
		this.companyfaxarea = value;
	}
	public java.lang.String getCompanyfaxarea() {
		return this.companyfaxarea;
	}
	public void setCompanyfax(java.lang.String value) {
		this.companyfax = value;
	}
	public java.lang.String getCompanyfax() {
		return this.companyfax;
	}
	public void setCompanyhandphonecountry(java.lang.String value) {
		this.companyhandphonecountry = value;
	}
	public java.lang.String getCompanyhandphonecountry() {
		return this.companyhandphonecountry;
	}
	public void setCompanyhandphone(java.lang.String value) {
		this.companyhandphone = value;
	}
	public java.lang.String getCompanyhandphone() {
		return this.companyhandphone;
	}
	public void setEstablished(java.util.Date value) {
		this.established = value;
	}
	public java.util.Date getEstablished() {
		return this.established;
	}
	public void setRegistrationid(java.lang.String value) {
		this.registrationid = value;
	}
	public java.lang.String getRegistrationid() {
		return this.registrationid;
	}
	public void setProductsscope(java.lang.String value) {
		this.productsscope = value;
	}
	public java.lang.String getProductsscope() {
		return this.productsscope;
	}
	public void setSalesvolume(java.lang.String value) {
		this.salesvolume = value;
	}
	public java.lang.String getSalesvolume() {
		return this.salesvolume;
	}
	public void setImportvolume(java.lang.String value) {
		this.importvolume = value;
	}
	public java.lang.String getImportvolume() {
		return this.importvolume;
	}
	public void setDescription(java.lang.String value) {
		this.description = value;
	}
	public java.lang.String getDescription() {
		return this.description;
	}
	public void setTitle(java.lang.Integer value) {
		this.title = value;
	}
	public java.lang.Integer getTitle() {
		return this.title;
	}
	public void setCompanyaddress(java.lang.String value) {
		this.companyaddress = value;
	}
	public java.lang.String getCompanyaddress() {
		return this.companyaddress;
	}
	public void setWebsite(java.lang.String value) {
		this.website = value;
	}
	public java.lang.String getWebsite() {
		return this.website;
	}
	public void setCompanycountryId(java.lang.Long value) {
		this.companycountryId = value;
	}
	public java.lang.Long getCompanycountryId() {
		return this.companycountryId;
	}
	public void setCompanyprovinceId(java.lang.Long value) {
		this.companyprovinceId = value;
	}
	public java.lang.Long getCompanyprovinceId() {
		return this.companyprovinceId;
	}
	public void setCompanycityId(java.lang.Long value) {
		this.companycityId = value;
	}
	public java.lang.Long getCompanycityId() {
		return this.companycityId;
	}
	public void setNewnew(java.lang.String value) {
		this.newnew = value;
	}
	public java.lang.String getNewnew() {
		return this.newnew;
	}
	public void setFeedback(java.lang.String value) {
		this.feedback = value;
	}
	public java.lang.String getFeedback() {
		return this.feedback;
	}
	public void setTradeguide(java.lang.String value) {
		this.tradeguide = value;
	}
	public java.lang.String getTradeguide() {
		return this.tradeguide;
	}
	public void setOptimizationhints(java.lang.String value) {
		this.optimizationhints = value;
	}
	public java.lang.String getOptimizationhints() {
		return this.optimizationhints;
	}
	public void setVipaudit(java.lang.Integer value) {
		this.vipaudit = value;
	}
	public java.lang.Integer getVipaudit() {
		return this.vipaudit;
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
	public void setZip(java.lang.String value) {
		this.zip = value;
	}
	public java.lang.String getZip() {
		return this.zip;
	}
	public void setPhonenumber(java.lang.String value) {
		this.phonenumber = value;
	}
	public java.lang.String getPhonenumber() {
		return this.phonenumber;
	}
	public void setCcity(java.lang.String value) {
		this.ccity = value;
	}
	public java.lang.String getCcity() {
		return this.ccity;
	}
	public void setCprovince(java.lang.String value) {
		this.cprovince = value;
	}
	public java.lang.String getCprovince() {
		return this.cprovince;
	}
	public void setPositon(java.lang.String value) {
		this.positon = value;
	}
	public java.lang.String getPositon() {
		return this.positon;
	}
	public void setContactmail(java.lang.String value) {
		this.contactmail = value;
	}
	public java.lang.String getContactmail() {
		return this.contactmail;
	}
	public void setPostalcode(java.lang.String value) {
		this.postalcode = value;
	}
	public java.lang.String getPostalcode() {
		return this.postalcode;
	}
	public void setClosecount(java.lang.Integer value) {
		this.closecount = value;
	}
	public java.lang.Integer getClosecount() {
		return this.closecount;
	}
	public void setCloseTime(java.util.Date value) {
		this.closeTime = value;
	}
	public java.util.Date getCloseTime() {
		return this.closeTime;
	}
	public void setCertificatesType(java.lang.String value) {
		this.certificatesType = value;
	}
	@NotNull
	public java.lang.String getCertificatesType() {
		return this.certificatesType;
	}
	public void setCertificates(java.lang.String value) {
		this.certificates = value;
	}
	@NotNull
	public java.lang.String getCertificates() {
		return this.certificates;
	}
}

