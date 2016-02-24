package com.openteach.qsync.api.goods.request;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.openteach.qsync.api.utils.JaxbDateSerializer;

/**
 * 
 * @author rqq
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "goodsDeclar")
public class GoodsDeclare {

	/**
	 * 账册编号
	 */
	@XmlElement(required = true)
	private String accountBookNo;
	/**
	 * 进出口标志
	 */
	@XmlElement(required = true)
	private String ieFlag;
	/**
	 * 预录入号码
	 */
	@XmlElement(required = true)
	private String preEntryNumber;
	/**
	 * 进口类型
	 */
	@XmlElement(required = true)
	private String importType;
	/**
	 * 进出口日期
	 */
	@XmlElement(required = true)
	@XmlJavaTypeAdapter(JaxbDateSerializer.class)
	private Date inOutDateStr;
	/**
	 * 进出口岸代码
	 */
	@XmlElement(required = true)
	private String iePort;
	/**
	 * 指运港(抵运港)
	 */
	@XmlElement(required = true)
	private String destinationPort;
	/**
	 * 运输工具名称
	 */
	@XmlElement(required = true)
	private String trafName;
	/**
	 * 运输工具航次(班)号
	 */
	@XmlElement(required = true)
	private String voyageNo;
	/**
	 * 运输方式代码
	 */
	@XmlElement(required = true)
	private String trafMode;
	/**
	 * 申报单位类别
	 */
	@XmlElement(required = true)
	private String declareCompanyType;
	/**
	 * 申报单位代码
	 */
	@XmlElement(required = true)
	private String declareCompanyCode;
	/**
	 * 申报单位名称
	 */
	@XmlElement(required = true)
	private String declareCompanyName;
	/**
	 * 电商企业代码
	 */
	@XmlElement(required = true)
	private String eCommerceCode;
	/**
	 * 电商企业名称
	 */
	@XmlElement(required = true)
	private String eCommerceName;
	/**
	 * 订单编号
	 */
	@XmlElement(required = true)
	private String orderNo;
	/**
	 * 分运单号
	 */
	@XmlElement(required = true)
	private String wayBill;
	/**
	 * 贸易国别（起运地）
	 */
	@XmlElement(required = true)
	private String tradeCountry;
	/**
	 * 件数
	 */
	@XmlElement(required = true)
	private int packNo;
	/**
	 * 毛重（公斤）
	 */
	@XmlElement(required = true)
	private double grossWeight;
	/**
	 * 净重（公斤）
	 */
	@XmlElement(required = true)
	private double netWeight;
	/**
	 * 包装种类
	 */
	@XmlElement(required = true)
	private String warpType;
	/**
	 * 备注
	 */
	@XmlElement(required = true)
	private String remark;
	/**
	 * 申报口岸代码
	 */
	@XmlElement(required = true)
	private String declPort;
	/**
	 * 录入人
	 */
	@XmlElement(required = true)
	private String enteringPerson;
	/**
	 * 录入单位名称
	 */
	@XmlElement(required = true)
	private String enteringCompanyName;
	/**
	 * 报关员代码
	 */
	@XmlElement(required = true)
	private String declarantNo;
	/**
	 * 码头/货场代码
	 */
	@XmlElement(required = true)
	private String customsField;
	/**
	 * 发件人
	 */
	@XmlElement(required = true)
	private String senderName;
	/**
	 * 收件人
	 */
	@XmlElement(required = true)
	private String consignee;
	/**
	 * 发件人国别
	 */
	@XmlElement(required = true)
	private String senderCountry;
	/**
	 * 发件人城市
	 */
	@XmlElement(required = true)
	private String senderCity;
	/**
	 * 支付人证件类型
	 */
	@XmlElement(required = true)
	private String paperType;
	/**
	 * 支付人证件号
	 */
	@XmlElement(required = true)
	private String paperNumber;
	
	@XmlElement(required = true)
	private double worth;
	/**
	 * 币制
	 */
	@XmlElement(required = true)
	private String currCode;
	/**
	 * 主要货物名称
	 */
	@XmlElement(required = true)
	private String mainGName;
	/**
	 * 区内企业编码
	 */
	@XmlElement(required = true)
	private String internalAreaCompanyNo;
	/**
	 * 区内企业名称
	 */
	@XmlElement(required = true)
	private String internalAreaCompanyName;
	/**
	 * 申请单编号
	 */
	@XmlElement(required = true)
	private String applicationFormNo;
	/**
	 * 是否授权
	 */
	@XmlElement(required = true)
	private byte isAuthorize;
	public String getAccountBookNo() {
		return accountBookNo;
	}
	public void setAccountBookNo(String accountBookNo) {
		this.accountBookNo = accountBookNo;
	}
	public String getIeFlag() {
		return ieFlag;
	}
	public void setIeFlag(String ieFlag) {
		this.ieFlag = ieFlag;
	}
	public String getPreEntryNumber() {
		return preEntryNumber;
	}
	public void setPreEntryNumber(String preEntryNumber) {
		this.preEntryNumber = preEntryNumber;
	}
	public String getImportType() {
		return importType;
	}
	public void setImportType(String importType) {
		this.importType = importType;
	}
	public Date getInOutDateStr() {
		return inOutDateStr;
	}
	public void setInOutDateStr(Date inOutDateStr) {
		this.inOutDateStr = inOutDateStr;
	}
	public String getIePort() {
		return iePort;
	}
	public void setIePort(String iePort) {
		this.iePort = iePort;
	}
	public String getDestinationPort() {
		return destinationPort;
	}
	public void setDestinationPort(String destinationPort) {
		this.destinationPort = destinationPort;
	}
	public String getTrafName() {
		return trafName;
	}
	public void setTrafName(String trafName) {
		this.trafName = trafName;
	}
	public String getVoyageNo() {
		return voyageNo;
	}
	public void setVoyageNo(String voyageNo) {
		this.voyageNo = voyageNo;
	}
	public String getTrafMode() {
		return trafMode;
	}
	public void setTrafMode(String trafMode) {
		this.trafMode = trafMode;
	}
	public String getDeclareCompanyType() {
		return declareCompanyType;
	}
	public void setDeclareCompanyType(String declareCompanyType) {
		this.declareCompanyType = declareCompanyType;
	}
	public String getDeclareCompanyCode() {
		return declareCompanyCode;
	}
	public void setDeclareCompanyCode(String declareCompanyCode) {
		this.declareCompanyCode = declareCompanyCode;
	}
	public String getDeclareCompanyName() {
		return declareCompanyName;
	}
	public void setDeclareCompanyName(String declareCompanyName) {
		this.declareCompanyName = declareCompanyName;
	}
	public String geteCommerceCode() {
		return eCommerceCode;
	}
	public void seteCommerceCode(String eCommerceCode) {
		this.eCommerceCode = eCommerceCode;
	}
	public String geteCommerceName() {
		return eCommerceName;
	}
	public void seteCommerceName(String eCommerceName) {
		this.eCommerceName = eCommerceName;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getWayBill() {
		return wayBill;
	}
	public void setWayBill(String wayBill) {
		this.wayBill = wayBill;
	}
	public String getTradeCountry() {
		return tradeCountry;
	}
	public void setTradeCountry(String tradeCountry) {
		this.tradeCountry = tradeCountry;
	}
	public int getPackNo() {
		return packNo;
	}
	public void setPackNo(int packNo) {
		this.packNo = packNo;
	}
	public double getGrossWeight() {
		return grossWeight;
	}
	public void setGrossWeight(double grossWeight) {
		this.grossWeight = grossWeight;
	}
	public double getNetWeight() {
		return netWeight;
	}
	public void setNetWeight(double netWeight) {
		this.netWeight = netWeight;
	}
	public String getWarpType() {
		return warpType;
	}
	public void setWarpType(String warpType) {
		this.warpType = warpType;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getDeclPort() {
		return declPort;
	}
	public void setDeclPort(String declPort) {
		this.declPort = declPort;
	}
	public String getEnteringPerson() {
		return enteringPerson;
	}
	public void setEnteringPerson(String enteringPerson) {
		this.enteringPerson = enteringPerson;
	}
	public String getEnteringCompanyName() {
		return enteringCompanyName;
	}
	public void setEnteringCompanyName(String enteringCompanyName) {
		this.enteringCompanyName = enteringCompanyName;
	}
	public String getDeclarantNo() {
		return declarantNo;
	}
	public void setDeclarantNo(String declarantNo) {
		this.declarantNo = declarantNo;
	}
	public String getCustomsField() {
		return customsField;
	}
	public void setCustomsField(String customsField) {
		this.customsField = customsField;
	}
	public String getSenderName() {
		return senderName;
	}
	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}
	public String getConsignee() {
		return consignee;
	}
	public void setConsignee(String consignee) {
		this.consignee = consignee;
	}
	public String getSenderCountry() {
		return senderCountry;
	}
	public void setSenderCountry(String senderCountry) {
		this.senderCountry = senderCountry;
	}
	public String getSenderCity() {
		return senderCity;
	}
	public void setSenderCity(String senderCity) {
		this.senderCity = senderCity;
	}
	public String getPaperType() {
		return paperType;
	}
	public void setPaperType(String paperType) {
		this.paperType = paperType;
	}
	public String getPaperNumber() {
		return paperNumber;
	}
	public void setPaperNumber(String paperNumber) {
		this.paperNumber = paperNumber;
	}
	public double getWorth() {
		return worth;
	}
	public void setWorth(double worth) {
		this.worth = worth;
	}
	public String getCurrCode() {
		return currCode;
	}
	public void setCurrCode(String currCode) {
		this.currCode = currCode;
	}
	public String getMainGName() {
		return mainGName;
	}
	public void setMainGName(String mainGName) {
		this.mainGName = mainGName;
	}
	public String getInternalAreaCompanyNo() {
		return internalAreaCompanyNo;
	}
	public void setInternalAreaCompanyNo(String internalAreaCompanyNo) {
		this.internalAreaCompanyNo = internalAreaCompanyNo;
	}
	public String getInternalAreaCompanyName() {
		return internalAreaCompanyName;
	}
	public void setInternalAreaCompanyName(String internalAreaCompanyName) {
		this.internalAreaCompanyName = internalAreaCompanyName;
	}
	public String getApplicationFormNo() {
		return applicationFormNo;
	}
	public void setApplicationFormNo(String applicationFormNo) {
		this.applicationFormNo = applicationFormNo;
	}
	public byte getIsAuthorize() {
		return isAuthorize;
	}
	public void setIsAuthorize(byte isAuthorize) {
		this.isAuthorize = isAuthorize;
	}

}
