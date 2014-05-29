package com.openteach.qsync.api.record.response;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;

/**
 * 
 * @author rqq
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "body")
public class XmlRecordResponseBody {

	/**
	 * 
	 */
	@XmlElementWrapper
	@XmlElement(required = true, name="companyResult")
	private List<CompanyResult> companyResultList;

	public List<CompanyResult> getCompanyResultList() {
		return companyResultList;
	}

	public void setCompanyResultList(List<CompanyResult> companyResultList) {
		this.companyResultList = companyResultList;
	}
}
