package com.openteach.qsync.core;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ConfigService {
	//企业备案编号
	@Value("${declare.company.code}")
	private String declareCompanyCode;
	//电商平台名称
	@Value("${declare.company.name}")
	private String declareCompanyName;
	//业务编号
	@Value("${declare.business.no}")
	private String declareBusinessNo;
	//业务类型
	@Value("${declare.business.type}")
	private String declareBusinessType;
	//申报类型代码
	@Value("${declare.type}")
	private String declareType;
	//电商企业编码
	@Value("${declare.record.no}")
	private String declareRecordNo;
	//币制
	@Value("${declare.currency}")
	private String declareCurrency;
	public String getDeclareCompanyCode() {
		return declareCompanyCode;
	}
	public void setDeclareCompanyCode(String declareCompanyCode) {
		this.declareCompanyCode = declareCompanyCode;
	}
	public String getDeclareBusinessNo() {
		return declareBusinessNo;
	}
	public void setDeclareBusinessNo(String declareBusinessNo) {
		this.declareBusinessNo = declareBusinessNo;
	}
	public String getDeclareBusinessType() {
		return declareBusinessType;
	}
	public void setDeclareBusinessType(String declareBusinessType) {
		this.declareBusinessType = declareBusinessType;
	}
	public String getDeclareType() {
		return declareType;
	}
	public void setDeclareType(String declareType) {
		this.declareType = declareType;
	}
	public String getDeclareRecordNo() {
		return declareRecordNo;
	}
	public void setDeclareRecordNo(String declareRecordNo) {
		this.declareRecordNo = declareRecordNo;
	}
	public String getDeclareCompanyName() {
		return declareCompanyName;
	}
	public void setDeclareCompanyName(String declareCompanyName) {
		this.declareCompanyName = declareCompanyName;
	}
	public String getDeclareCurrency() {
		return declareCurrency;
	}
	public void setDeclareCurrency(String declareCurrency) {
		this.declareCurrency = declareCurrency;
	}
}
