package com.openteach.qsync.api.record.request;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;

import com.openteach.qsync.api.JkfSign;

/**
 * 
 * @author rqq
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "body")
public class XmlRecordRequestBody {

	/**
	 * 
	 */
	@XmlElement(required = true)
	private JkfSign jkfSign;
	
	/**
	 * 
	 */
	@XmlElementWrapper
	@XmlElement(required = true, name="importCompany")
	private List<ImportCompany> importCompanyList;

	public JkfSign getJkfSign() {
		return jkfSign;
	}

	public void setJkfSign(JkfSign jkfSign) {
		this.jkfSign = jkfSign;
	}

	public List<ImportCompany> getImportCompanyList() {
		return importCompanyList;
	}

	public void setImportCompanyList(List<ImportCompany> importCompanyList) {
		this.importCompanyList = importCompanyList;
	}
}
