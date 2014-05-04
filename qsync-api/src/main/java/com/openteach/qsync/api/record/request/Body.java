package com.openteach.qsync.api.record.request;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;

import com.openteach.qsync.api.BaseBody;
import com.openteach.qsync.api.JkfSign;

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
	private JkfSign jkfSign;
	
	/**
	 * 
	 */
	@XmlElement(required = true, name="ImportCompanyList")
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
