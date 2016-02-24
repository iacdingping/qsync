package com.openteach.qsync.api.order.request;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * 购买人信息
 * @author IAC-DINGPING
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType (name="jkfGoodsPurchaser")
public class JkfGoodsPurchaser {

	/**
	 * 购买人ID
	 */
	@XmlElement(required = true)
	private String id;
	/**
	 * 购买人名称
	 */
	@XmlElement(required = true)
	private String name;
	/**
	 * 购买人邮箱
	 */
	@XmlElement(required = true)
	private String email;
	/**
	 * 联系电话
	 */
	@XmlElement(required = true)
	private String telNumber;
	/**
	 * 地址
	 */
	@XmlElement(required = true)
	private String address;
	/**
	 * 证件类型01:身份证（试点期间只能是身份证） 02:护照 03:其他
	 */
	@XmlElement(required = true)
	private String paperType;
	/**
	 * 证件号码
	 */
	@XmlElement(required = true)
	private String paperNumber;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelNumber() {
		return telNumber;
	}
	public void setTelNumber(String telNumber) {
		this.telNumber = telNumber;
	}
	public String getPaperType() {
		return paperType;
	}
	public void setPaperType(String paperType) {
		this.paperType = paperType;
	}
	public String getPaperNumber() {
		return paperNumber;
	}
	public void setPaperNumber(String paperNumber) {
		this.paperNumber = paperNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
