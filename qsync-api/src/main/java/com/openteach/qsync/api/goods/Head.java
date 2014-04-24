package com.openteach.qsync.api.goods;

import javax.xml.bind.annotation.XmlElement;

import com.openteach.qsync.api.BaseHead;

/**
 * 
 * @author rqq
 *
 */
public class Head extends BaseHead {

	@XmlElement(required = true)
	private String businessType = "PERSONAL_GOODS_DECLAR";

	public String getBusinessType() {
		return businessType;
	}

	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}
}
