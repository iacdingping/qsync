package com.openteach.qsync.api.record.response;

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
@XmlType(name = "companyResult")
public class CompanyResult {

	/**
	 * 
	 */
	@XmlElement(required = true)
	private String businessNo;
	
	/**
	 * 
	 */
	@XmlElement(required = true)
	private String businessType;
	
	/**
	 * 
	 */
	@XmlElement(required = true)
	private String processTime;
	
	/**
	 * 
	 */
	@XmlElement(required = true)
	private String approveComment;
	
	/**
	 * 
	 */
	@XmlElement(required = true)
	private String approveResult;
	
	/**
	 * 
	 */
	@XmlElement(required = true)
	private String companyCode;
	
	/**
	 * 
	 */
	@XmlElement(required = false)
	private String recordNo;

	public String getBusinessNo() {
		return businessNo;
	}

	public void setBusinessNo(String businessNo) {
		this.businessNo = businessNo;
	}

	public String getBusinessType() {
		return businessType;
	}

	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}

	public String getProcessTime() {
		return processTime;
	}

	public void setProcessTime(String processTime) {
		this.processTime = processTime;
	}

	public String getApproveComment() {
		return approveComment;
	}

	public void setApproveComment(String approveComment) {
		this.approveComment = approveComment;
	}

	public String getApproveResult() {
		return approveResult;
	}

	public void setApproveResult(String approveResult) {
		this.approveResult = approveResult;
	}

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public String getRecordNo() {
		return recordNo;
	}

	public void setRecordNo(String recordNo) {
		this.recordNo = recordNo;
	}
}