package com.openteach.qsync.api.logistics;

import javax.xml.bind.annotation.XmlElement;

import com.openteach.qsync.api.BaseHead;

/**
 * 
 * @author rqq
 *
 */
public class Head extends BaseHead {

	@XmlElement(required = true)
	private String businessType = "IMPORTBILL";

	public String getBusinessType() {
		return businessType;
	}

	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}
}
