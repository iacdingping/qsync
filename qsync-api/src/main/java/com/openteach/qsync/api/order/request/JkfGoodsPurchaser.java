package com.openteach.qsync.api.order.request;

import javax.xml.bind.annotation.XmlElement;

/**
 * 购买人信息
 * @author IAC-DINGPING
 *
 */
public class JkfGoodsPurchaser {

	/**
	 * 购买人ID
	 */
	@XmlElement(required = true)
	private String id;
	/**
	 * 姓名
	 */
	@XmlElement(required = true)
	private String name;
	/**
	 * 注册邮箱
	 */
	@XmlElement(required = true)
	private String email;
	/**
	 * 联系电话
	 */
	@XmlElement(required = true)
	private String telNumber;
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
	/**
	 * 地址
	 */
	@XmlElement(required = true)
	private String address;
}
