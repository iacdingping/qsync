package com.openteach.qsync.api;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * 
 * @author rqq
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "jkfResult")
public class JkfResultDetail {

	/**
	 * 
	 */
	@XmlElement(required = true)
	private String resultInfo;

	public String getResultInfo() {
		return resultInfo;
	}

	public void setResultInfo(String resultInfo) {
		this.resultInfo = resultInfo;
	}
}
