package com.openteach.qsync.api.order.request;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * 订单信息
 * @author IAC-DINGPING
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "jkfOrderImportHead")
public class JkfOrderImportHead {

	/**
	 * 电商企业编码
	 */
	@XmlElement(required = true)
	private String eCommerceCode;
	/**
	 * 电商企业名称
	 */
	@XmlElement(required = true)
	private String eCommerceName;
	
	/**
	 * 进出口标志 I:进口E:出口
	 */
	@XmlElement(required = true)
	private String ieFlag;
	/**
	 * 支付类型 01:银行卡支付 02:余额支付 03:其他
	 */
	@XmlElement(required = true)
	private String payType;
	/**
	 * 支付公司编码
	 */
	@XmlElement(required = true)
	private String payCompanyCode;
	/**
	 * 支付单号
	 */
	@XmlElement(required = true)
	private String payNumber;
	/**
	 * 订单总金额
	 */
	@XmlElement(required = true)
	private Double orderTotalAmount;
	/**
	 * 订单编号
	 */
	@XmlElement(required = true)
	private String orderNo;
	/**
	 * 订单税款
	 */
	@XmlElement(required = true)
	private Double orderTaxAmount;
	
	/**
	 * 订单货款 文档字段含义里漏掉了
	 */
	@XmlElement(required = true)
	private Double orderGoodsAmount;
	/**
	 * 运费 非必填
	 */
	@XmlElement(required = false)
	@Deprecated
	private Double feeAmount;
	/**
	 * 电商平台名称
	 */
	@XmlElement(required = true)
	private String companyName;
	/**
	 * 电商平台编号
	 */
	@XmlElement(required = true)
	private String companyCode;
	/**
	 * 成交时间 format : yyyy-mm-dd HH:MM:SS
	 */
	@XmlElement(required = true)
	private String tradeTime;
	/**
	 * 成交币制
	 */
	@XmlElement(required = true)
	private String currCode;
	/**
	 * 成交总价
	 */
	@XmlElement(required = true)
	private Double totalAmount;
	/**
	 * 收件人Email
	 */
	@XmlElement(required = true)
	private String consigneeEmail;
	/**
	 * 收件人联系方式
	 */
	@XmlElement(required = true)
	private String consigneeTel;
	/**
	 * 收件人姓名
	 */
	@XmlElement(required = true)
	private String consignee;
	/**
	 * 收件人地址
	 */
	@XmlElement(required = true)
	private String consigneeAddress;
	/**
	 * 总件数
	 */
	@XmlElement(required = true)
	private Integer totalCount;
	/**
	 * 发货方式（物流方式）
	 */
	@XmlElement(required = true)
	private String postMode;
	/**
	 * 发件人国别
	 */
	@XmlElement(required = true)
	private String senderCountry;
	/**
	 * 发件人姓名
	 */
	@XmlElement(required = true)
	private String senderName;
	/**
	 * 购买人ID
	 */
	@XmlElement(required = true)
	private String purchaserId;
	/**
	 * 物流企业名称
	 */
	@XmlElement(required = true)
	private String logisCompanyName;
	/**
	 * 物流企业编号
	 */
	@XmlElement(required = true)
	private String logisCompanyCode;
	/**
	 * 邮编
	 */
	@XmlElement(required = false)
	@Deprecated
	private String zipCode;
	/**
	 * 备注
	 */
	@XmlElement(required = false)
	@Deprecated
	private String note;
	/**
	 * 运单号列表 运单之间以分号隔开
	 */
	@XmlElement(required = false)
	@Deprecated
	private String wayBills;
	@XmlElement(required = false)
	@Deprecated
	private Double rate;
	@XmlElement
	private String userProcotol;
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCompanyCode() {
		return companyCode;
	}
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}
	public String getIeFlag() {
		return ieFlag;
	}
	public void setIeFlag(String ieFlag) {
		this.ieFlag = ieFlag;
	}
	public String getPayType() {
		return payType;
	}
	public void setPayType(String payType) {
		this.payType = payType;
	}
	public String getPayCompanyCode() {
		return payCompanyCode;
	}
	public void setPayCompanyCode(String payCompanyCode) {
		this.payCompanyCode = payCompanyCode;
	}
	public String getPayNumber() {
		return payNumber;
	}
	public void setPayNumber(String payNumber) {
		this.payNumber = payNumber;
	}
	public Double getOrderTotalAmount() {
		return orderTotalAmount;
	}
	public void setOrderTotalAmount(Double orderTotalAmount) {
		this.orderTotalAmount = orderTotalAmount;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public Double getOrderTaxAmount() {
		return orderTaxAmount;
	}
	public void setOrderTaxAmount(Double orderTaxAmount) {
		this.orderTaxAmount = orderTaxAmount;
	}
	public Double getOrderGoodsAmount() {
		return orderGoodsAmount;
	}
	public void setOrderGoodsAmount(Double orderGoodsAmount) {
		this.orderGoodsAmount = orderGoodsAmount;
	}
	public Double getFeeAmount() {
		return feeAmount;
	}
	public void setFeeAmount(Double feeAmount) {
		this.feeAmount = feeAmount;
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
	public String getTradeTime() {
		return tradeTime;
	}
	public void setTradeTime(String tradeTime) {
		this.tradeTime = tradeTime;
	}
	public String getCurrCode() {
		return currCode;
	}
	public void setCurrCode(String currCode) {
		this.currCode = currCode;
	}
	public Double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getConsigneeEmail() {
		return consigneeEmail;
	}
	public void setConsigneeEmail(String consigneeEmail) {
		this.consigneeEmail = consigneeEmail;
	}
	public String getConsigneeTel() {
		return consigneeTel;
	}
	public void setConsigneeTel(String consigneeTel) {
		this.consigneeTel = consigneeTel;
	}
	public String getConsignee() {
		return consignee;
	}
	public void setConsignee(String consignee) {
		this.consignee = consignee;
	}
	public String getConsigneeAddress() {
		return consigneeAddress;
	}
	public void setConsigneeAddress(String consigneeAddress) {
		this.consigneeAddress = consigneeAddress;
	}
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	public String getPostMode() {
		return postMode;
	}
	public void setPostMode(String postMode) {
		this.postMode = postMode;
	}
	public String getSenderCountry() {
		return senderCountry;
	}
	public void setSenderCountry(String senderCountry) {
		this.senderCountry = senderCountry;
	}
	public String getSenderName() {
		return senderName;
	}
	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}
	public String getPurchaserId() {
		return purchaserId;
	}
	public void setPurchaserId(String purchaserId) {
		this.purchaserId = purchaserId;
	}
	public String getLogisCompanyName() {
		return logisCompanyName;
	}
	public void setLogisCompanyName(String logisCompanyName) {
		this.logisCompanyName = logisCompanyName;
	}
	public String getLogisCompanyCode() {
		return logisCompanyCode;
	}
	public void setLogisCompanyCode(String logisCompanyCode) {
		this.logisCompanyCode = logisCompanyCode;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getWayBills() {
		return wayBills;
	}
	public void setWayBills(String wayBills) {
		this.wayBills = wayBills;
	}
	public Double getRate() {
		return rate;
	}
	public void setRate(Double rate) {
		this.rate = rate;
	}
	public String getUserProcotol() {
		return userProcotol;
	}
	public void setUserProcotol(String userProcotol) {
		this.userProcotol = userProcotol;
	}
}
