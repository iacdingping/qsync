package com.openteach.qsync.api.record.response;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;

import com.openteach.qsync.api.BaseBody;

/**
 * 
 * @author rqq
 *
 */
@XmlType(namespace="record.response", name = "body")
public class Body extends BaseBody {

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
