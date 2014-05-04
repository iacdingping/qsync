package com.openteach.qsync.api.record.response;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;

import com.openteach.qsync.api.BaseBody;

/**
 * 
 * @author rqq
 *
 */
public class Body extends BaseBody {

	/**
	 * 
	 */
	@XmlElement(required = true)
	private List<CompanyResult> companyResultList;

	public List<CompanyResult> getCompanyResultList() {
		return companyResultList;
	}

	public void setCompanyResultList(List<CompanyResult> companyResultList) {
		this.companyResultList = companyResultList;
	}
}
