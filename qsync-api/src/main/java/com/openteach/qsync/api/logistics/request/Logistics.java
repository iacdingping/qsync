package com.openteach.qsync.api.logistics.request;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import com.openteach.qsync.api.JkfSign;

/**
 * 
 * @author rqq
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace="logistics.request", name = "logistics")
public class Logistics {
	
	/**
	 * 
	 */
	@XmlElement(required = true)
	private JkfSign jkfSign;
	
	/**
	 * 
	 */
	@XmlElement(required = true)
	private JkfLogisticsInfo jkfLogisticsInfo;

	public JkfSign getJkfSign() {
		return jkfSign;
	}

	public void setJkfSign(JkfSign jkfSign) {
		this.jkfSign = jkfSign;
	}

	public JkfLogisticsInfo getJkfLogisticsInfo() {
		return jkfLogisticsInfo;
	}

	public void setJkfLogisticsInfo(JkfLogisticsInfo jkfLogisticsInfo) {
		this.jkfLogisticsInfo = jkfLogisticsInfo;
	}
}
