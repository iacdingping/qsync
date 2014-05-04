package com.openteach.qsync.api.goods.request;

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
@XmlType(name = "goodsDeclarDetail")
public class GoodsDeclarDetail {
	
	/**
	 * 
	 */
	@XmlElement(required = true)
	private int goodsOrder;
	
	/**
	 * 
	 */
	@XmlElement(required = true)
	private String mailTaxNo;
	
	/**
	 * 
	 */
	@XmlElement(required = true)
	private String goodsItemNo;
	
	/**
	 * 
	 */
	@XmlElement(required = true)
	private String goodsName;
	
	/**
	 * 
	 */
	@XmlElement(required = true)
	private String goodsSpecification;
	
	/**
	 * 
	 */
	@XmlElement(required = true)
	private String productionMarketingCountry;
	
	/**
	 * 
	 */
	@XmlElement(required = true)
	private String bargainCurrency;
	
	/**
	 * 
	 */
	@XmlElement(required = true)
	private double bargainTotalPrices;
	
	/**
	 * 
	 */
	@XmlElement(required = true)
	private double declarePrice;
	
	/**
	 * 
	 */
	@XmlElement(required = true)
	private double declareTotalPrices;
	
	/**
	 * 
	 */
	@XmlElement(required = true)
	private String purpose;
	
	/**
	 * 
	 */
	@XmlElement(required = true)
	private int declareCount;
	
	/**
	 * 
	 */
	@XmlElement(required = true)
	private String declareMeasureUnit;
	
	/**
	 * 
	 */
	@XmlElement(required = true)
	private double goodsRoughWeight;
	
	/**
	 * 
	 */
	@XmlElement(required = true)
	private String firstUnit;
	
	/**
	 * 
	 */
	@XmlElement(required = true)
	private int firstCount;
	
	/**
	 * 
	 */
	@XmlElement(required = true)
	private String secondUnit;
	
	/**
	 * 
	 */
	@XmlElement(required = true)
	private int secondCount;

	public int getGoodsOrder() {
		return goodsOrder;
	}

	public void setGoodsOrder(int goodsOrder) {
		this.goodsOrder = goodsOrder;
	}

	public String getMailTaxNo() {
		return mailTaxNo;
	}

	public void setMailTaxNo(String mailTaxNo) {
		this.mailTaxNo = mailTaxNo;
	}

	public String getGoodsItemNo() {
		return goodsItemNo;
	}

	public void setGoodsItemNo(String goodsItemNo) {
		this.goodsItemNo = goodsItemNo;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getGoodsSpecification() {
		return goodsSpecification;
	}

	public void setGoodsSpecification(String goodsSpecification) {
		this.goodsSpecification = goodsSpecification;
	}

	public String getProductionMarketingCountry() {
		return productionMarketingCountry;
	}

	public void setProductionMarketingCountry(String productionMarketingCountry) {
		this.productionMarketingCountry = productionMarketingCountry;
	}

	public String getBargainCurrency() {
		return bargainCurrency;
	}

	public void setBargainCurrency(String bargainCurrency) {
		this.bargainCurrency = bargainCurrency;
	}

	public double getBargainTotalPrices() {
		return bargainTotalPrices;
	}

	public void setBargainTotalPrices(double bargainTotalPrices) {
		this.bargainTotalPrices = bargainTotalPrices;
	}

	public double getDeclarePrice() {
		return declarePrice;
	}

	public void setDeclarePrice(double declarePrice) {
		this.declarePrice = declarePrice;
	}

	public double getDeclareTotalPrices() {
		return declareTotalPrices;
	}

	public void setDeclareTotalPrices(double declareTotalPrices) {
		this.declareTotalPrices = declareTotalPrices;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public int getDeclareCount() {
		return declareCount;
	}

	public void setDeclareCount(int declareCount) {
		this.declareCount = declareCount;
	}

	public String getDeclareMeasureUnit() {
		return declareMeasureUnit;
	}

	public void setDeclareMeasureUnit(String declareMeasureUnit) {
		this.declareMeasureUnit = declareMeasureUnit;
	}

	public double getGoodsRoughWeight() {
		return goodsRoughWeight;
	}

	public void setGoodsRoughWeight(double goodsRoughWeight) {
		this.goodsRoughWeight = goodsRoughWeight;
	}

	public String getFirstUnit() {
		return firstUnit;
	}

	public void setFirstUnit(String firstUnit) {
		this.firstUnit = firstUnit;
	}

	public int getFirstCount() {
		return firstCount;
	}

	public void setFirstCount(int firstCount) {
		this.firstCount = firstCount;
	}

	public String getSecondUnit() {
		return secondUnit;
	}

	public void setSecondUnit(String secondUnit) {
		this.secondUnit = secondUnit;
	}

	public int getSecondCount() {
		return secondCount;
	}

	public void setSecondCount(int secondCount) {
		this.secondCount = secondCount;
	}
}
