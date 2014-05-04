package com.openteach.qsync.api.waybill.request;

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
@XmlType(name = "wayBillImportDto")
public class WayBillImportDto {

	@XmlElement(required = true)
	private String wayBillNo;
	
	@XmlElement(required = true)
	private String totalWayBill;
	
	@XmlElement(required = true)
	private int packageNo;
	
	@XmlElement(required = true)
	private double weight;
	
	@XmlElement(required = true)
	private double netWeight;
	
	@XmlElement(required = true)
	private String goodsName;
	
	@XmlElement(required = true)
	private String sendArea;
	
	@XmlElement(required = true)
	private String consigneeArea;
	
	@XmlElement(required = true)
	private String consignee;
	
	@XmlElement(required = true)
	private String consigneeAddress;
	
	@XmlElement(required = true)
	private String consigneeTel;
	
	@XmlElement(required = true)
	private String zipCode;
	
	@XmlElement(required = true)
	private String customsCode;
	
	@XmlElement(required = true)
	private double worth;
	
	@XmlElement(required = true)
	private double currCode;
	
	@XmlElement(required = true)
	private Date importDateString;

	public String getWayBillNo() {
		return wayBillNo;
	}

	public void setWayBillNo(String wayBillNo) {
		this.wayBillNo = wayBillNo;
	}

	public String getTotalWayBill() {
		return totalWayBill;
	}

	public void setTotalWayBill(String totalWayBill) {
		this.totalWayBill = totalWayBill;
	}

	public int getPackageNo() {
		return packageNo;
	}

	public void setPackageNo(int packageNo) {
		this.packageNo = packageNo;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getNetWeight() {
		return netWeight;
	}

	public void setNetWeight(double netWeight) {
		this.netWeight = netWeight;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getSendArea() {
		return sendArea;
	}

	public void setSendArea(String sendArea) {
		this.sendArea = sendArea;
	}

	public String getConsigneeArea() {
		return consigneeArea;
	}

	public void setConsigneeArea(String consigneeArea) {
		this.consigneeArea = consigneeArea;
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

	public String getConsigneeTel() {
		return consigneeTel;
	}

	public void setConsigneeTel(String consigneeTel) {
		this.consigneeTel = consigneeTel;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getCustomsCode() {
		return customsCode;
	}

	public void setCustomsCode(String customsCode) {
		this.customsCode = customsCode;
	}

	public double getWorth() {
		return worth;
	}

	public void setWorth(double worth) {
		this.worth = worth;
	}

	public double getCurrCode() {
		return currCode;
	}

	public void setCurrCode(double currCode) {
		this.currCode = currCode;
	}

	public Date getImportDateString() {
		return importDateString;
	}

	public void setImportDateString(Date importDateString) {
		this.importDateString = importDateString;
	}
}
