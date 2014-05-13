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
@XmlType(name = "head")
public class BaseHead {

	public static final String IMPORTBILL = "IMPORTBILL";
	
	public static final String LOGISTICS_INFO = "LOGISTICS_INFO";
	
	public static final String IMPORT_COMPANY = "IMPORT_COMPANY";
	
	public static final String CHECKRESULT = "CHECKRESULT";
	
	@XmlElement(required = true)
	private String businessType;
	
	public String getBusinessType() {
		return businessType;
	}
	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}
}
