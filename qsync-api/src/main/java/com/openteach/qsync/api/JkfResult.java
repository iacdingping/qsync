package com.openteach.qsync.api;

import java.util.List;

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
public class JkfResult {

	/**
	 * 
	 */
	@XmlElement(required = true)
	private String companyCode;
	
	/**
	 * 
	 */
	@XmlElement(required = true)
	private String businessNo;
	
	/**
	 * 
	 */
	@XmlElement(required = true)
	private int businessType;
	
	/**
	 * 
	 */
	@XmlElement(required = true)
	private int declareType;
	
	/**
	 * 
	 */
	@XmlElement(required = true)
	private String chkMark;
	
	/**
	 * 
	 */
	@XmlElement(required = true)
	private String noticeDate;
	
	/**
	 * 
	 */
	@XmlElement(required = true)
	private String noticeTime;
	
	/**
	 * 
	 */
	@XmlElement(required = false)
	private String note;
	
	/**
	 * 
	 */
	@XmlElement(required = false)
	private List<JkfResultDetail> resultList;

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public String getBusinessNo() {
		return businessNo;
	}

	public void setBusinessNo(String businessNo) {
		this.businessNo = businessNo;
	}

	public int getBusinessType() {
		return businessType;
	}

	public void setBusinessType(int businessType) {
		this.businessType = businessType;
	}

	public int getDeclareType() {
		return declareType;
	}

	public void setDeclareType(int declareType) {
		this.declareType = declareType;
	}

	public String getChkMark() {
		return chkMark;
	}

	public void setChkMark(String chkMark) {
		this.chkMark = chkMark;
	}

	public String getNoticeDate() {
		return noticeDate;
	}

	public void setNoticeDate(String noticeDate) {
		this.noticeDate = noticeDate;
	}

	public String getNoticeTime() {
		return noticeTime;
	}

	public void setNoticeTime(String noticeTime) {
		this.noticeTime = noticeTime;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public List<JkfResultDetail> getResultList() {
		return resultList;
	}

	public void setResultList(List<JkfResultDetail> resultList) {
		this.resultList = resultList;
	}
}
