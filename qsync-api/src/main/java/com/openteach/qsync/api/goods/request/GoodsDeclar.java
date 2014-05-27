package com.openteach.qsync.api.goods.request;

import java.util.Date;

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
@XmlType(namespace="goods.request", name = "goodsDeclar")
public class GoodsDeclar {

	/**
	 * 
	 */
	@XmlElement(required = true)
	private String accountBookNo;
	
	@XmlElement(required = true)
	private String inOutFlag;
	
	@XmlElement(required = true)
	private String preEntryNumber;
	
	@XmlElement(required = true)
	private String importType;
	
	@XmlElement(required = true)
	private Date inOutDatStr;
	
	@XmlElement(required = true)
	private String inOutPortNumber;
	
	@XmlElement(required = true)
	private String arrivedPort;
	
	@XmlElement(required = true)
	private String transportTool;
	
	@XmlElement(required = true)
	private String transportToolFltNo;
	
	@XmlElement(required = true)
	private String transportTypeCode;
	
	@XmlElement(required = true)
	private String declareCompanyType;
	
	@XmlElement(required = true)
	private String declareCompanyCode;
	
	@XmlElement(required = true)
	private String declareCompanyName;
	
	@XmlElement(required = true)
	private String eeBusinessCompanyCode;
	
	@XmlElement(required = true)
	private String eeBusinessCompanyName;
	
	@XmlElement(required = true)
	private String orderNumber;
	
	@XmlElement(required = true)
	private String subCarriageNo;
	
	@XmlElement(required = true)
	private String fromCountry;
	
	@XmlElement(required = true)
	private int pieceNumber;
	
	@XmlElement(required = true)
	private double roughWeight;
	
	@XmlElement(required = true)
	private double netWeight;
	
	@XmlElement(required = true)
	private String packType;
	
	@XmlElement(required = true)
	private String remark;
	
	@XmlElement(required = true)
	private String declarePortCode;
	
	@XmlElement(required = true)
	private String enteringPerson;
	
	@XmlElement(required = true)
	private String enteringCompanyName;
	
	@XmlElement(required = true)
	private String declarantCode;
	
	@XmlElement(required = true)
	private String goodsYardCode;
	
	@XmlElement(required = true)
	private String sender;
	
	@XmlElement(required = true)
	private String receiver;
	
	@XmlElement(required = true)
	private String senderCountry;
	
	@XmlElement(required = true)
	private String senderCity;
	
	@XmlElement(required = true)
	private String receiverPapersType;
	
	@XmlElement(required = true)
	private String receiverPapersNo;
	
	@XmlElement(required = true)
	private double worth;
	
	@XmlElement(required = true)
	private String currency;
	
	@XmlElement(required = true)
	private String majorGoodsName;
	
	@XmlElement(required = true)
	private String internalAreaCompanyNo;
	
	@XmlElement(required = true)
	private String internalAreaCompanyName;
	
	@XmlElement(required = true)
	private String applicationFormNo;
	
	@XmlElement(required = true)
	private byte isAuthorize;

	public String getAccountBookNo() {
		return accountBookNo;
	}

	public void setAccountBookNo(String accountBookNo) {
		this.accountBookNo = accountBookNo;
	}

	public String getInOutFlag() {
		return inOutFlag;
	}

	public void setInOutFlag(String inOutFlag) {
		this.inOutFlag = inOutFlag;
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

	public Date getInOutDatStr() {
		return inOutDatStr;
	}

	public void setInOutDatStr(Date inOutDatStr) {
		this.inOutDatStr = inOutDatStr;
	}

	public String getInOutPortNumber() {
		return inOutPortNumber;
	}

	public void setInOutPortNumber(String inOutPortNumber) {
		this.inOutPortNumber = inOutPortNumber;
	}

	public String getArrivedPort() {
		return arrivedPort;
	}

	public void setArrivedPort(String arrivedPort) {
		this.arrivedPort = arrivedPort;
	}

	public String getTransportTool() {
		return transportTool;
	}

	public void setTransportTool(String transportTool) {
		this.transportTool = transportTool;
	}

	public String getTransportToolFltNo() {
		return transportToolFltNo;
	}

	public void setTransportToolFltNo(String transportToolFltNo) {
		this.transportToolFltNo = transportToolFltNo;
	}

	public String getTransportTypeCode() {
		return transportTypeCode;
	}

	public void setTransportTypeCode(String transportTypeCode) {
		this.transportTypeCode = transportTypeCode;
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

	public String getEeBusinessCompanyCode() {
		return eeBusinessCompanyCode;
	}

	public void setEeBusinessCompanyCode(String eeBusinessCompanyCode) {
		this.eeBusinessCompanyCode = eeBusinessCompanyCode;
	}

	public String getEeBusinessCompanyName() {
		return eeBusinessCompanyName;
	}

	public void setEeBusinessCompanyName(String eeBusinessCompanyName) {
		this.eeBusinessCompanyName = eeBusinessCompanyName;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getSubCarriageNo() {
		return subCarriageNo;
	}

	public void setSubCarriageNo(String subCarriageNo) {
		this.subCarriageNo = subCarriageNo;
	}

	public String getFromCountry() {
		return fromCountry;
	}

	public void setFromCountry(String fromCountry) {
		this.fromCountry = fromCountry;
	}

	public int getPieceNumber() {
		return pieceNumber;
	}

	public void setPieceNumber(int pieceNumber) {
		this.pieceNumber = pieceNumber;
	}

	public double getRoughWeight() {
		return roughWeight;
	}

	public void setRoughWeight(double roughWeight) {
		this.roughWeight = roughWeight;
	}

	public double getNetWeight() {
		return netWeight;
	}

	public void setNetWeight(double netWeight) {
		this.netWeight = netWeight;
	}

	public String getPackType() {
		return packType;
	}

	public void setPackType(String packType) {
		this.packType = packType;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getDeclarePortCode() {
		return declarePortCode;
	}

	public void setDeclarePortCode(String declarePortCode) {
		this.declarePortCode = declarePortCode;
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

	public String getDeclarantCode() {
		return declarantCode;
	}

	public void setDeclarantCode(String declarantCode) {
		this.declarantCode = declarantCode;
	}

	public String getGoodsYardCode() {
		return goodsYardCode;
	}

	public void setGoodsYardCode(String goodsYardCode) {
		this.goodsYardCode = goodsYardCode;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
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

	public String getReceiverPapersType() {
		return receiverPapersType;
	}

	public void setReceiverPapersType(String receiverPapersType) {
		this.receiverPapersType = receiverPapersType;
	}

	public String getReceiverPapersNo() {
		return receiverPapersNo;
	}

	public void setReceiverPapersNo(String receiverPapersNo) {
		this.receiverPapersNo = receiverPapersNo;
	}

	public double getWorth() {
		return worth;
	}

	public void setWorth(double worth) {
		this.worth = worth;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getMajorGoodsName() {
		return majorGoodsName;
	}

	public void setMajorGoodsName(String majorGoodsName) {
		this.majorGoodsName = majorGoodsName;
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
