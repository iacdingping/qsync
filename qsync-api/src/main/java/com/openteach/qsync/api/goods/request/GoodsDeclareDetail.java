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
public class GoodsDeclareDetail {
	
	/**
	 * 商品序号
	 */
	@XmlElement(required = true)
	private int goodsOrder;
	
	/**
	 * 行邮税号
	 */
	@XmlElement(required = true)
	private String codeTs;
	
	/**
	 * 商品货号
	 */
	@XmlElement(required = true)
	private String goodsItemNo;
	
	/**
	 * 物品名称
	 */
	@XmlElement(required = true)
	private String goodsName;
	
	/**
	 * 商品规格、型号
	 */
	@XmlElement(required = true)
	private String goodsModel;
	
	/**
	 * 产销国
	 */
	@XmlElement(required = true)
	private String originCountry;
	
	/**
	 * 成交币制
	 */
	@XmlElement(required = true)
	private String tradeCurr;
	
	/**
	 * 成交总价
	 */
	@XmlElement(required = true)
	private double tradeTotal;
	
	/**
	 * 申报单价
	 */
	@XmlElement(required = true)
	private double declPrice;
	
	/**
	 * 申报总价
	 */
	@XmlElement(required = true)
	private double declTotalPrice;
	
	/**
	 * 用途
	 */
	@XmlElement(required = true)
	private String useTo;
	
	/**
	 * 申报数量
	 */
	@XmlElement(required = true)
	private int declareCount;
	
	/**
	 * 申报计量单位
	 */
	@XmlElement(required = true)
	private String goodsUnit;
	
	/**
	 * 商品毛重
	 */
	@XmlElement(required = true)
	private double goodsGrossWeight;
	
	/**
	 * 第一单位
	 */
	@XmlElement(required = true)
	private String firstUnit;
	
	/**
	 * 第一数量
	 */
	@XmlElement(required = true)
	private int firstCount;
	
	/**
	 * 第二单位
	 */
	@XmlElement(required = true)
	private String secondUnit;
	
	/**
	 * 第二数量
	 */
	@XmlElement(required = true)
	private int secondCount;
	/**
	 * 产品国检备案编号
	 * 新增 2015.11.12
	 */
	private String productRecordNo;
	/**
	 * 商品网址
	 * 新增 2015.11.12
	 */
	private String webSite;
	public int getGoodsOrder() {
		return goodsOrder;
	}
	public void setGoodsOrder(int goodsOrder) {
		this.goodsOrder = goodsOrder;
	}
	public String getCodeTs() {
		return codeTs;
	}
	public void setCodeTs(String codeTs) {
		this.codeTs = codeTs;
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
	public String getGoodsModel() {
		return goodsModel;
	}
	public void setGoodsModel(String goodsModel) {
		this.goodsModel = goodsModel;
	}
	public String getOriginCountry() {
		return originCountry;
	}
	public void setOriginCountry(String originCountry) {
		this.originCountry = originCountry;
	}
	public String getTradeCurr() {
		return tradeCurr;
	}
	public void setTradeCurr(String tradeCurr) {
		this.tradeCurr = tradeCurr;
	}
	public double getTradeTotal() {
		return tradeTotal;
	}
	public void setTradeTotal(double tradeTotal) {
		this.tradeTotal = tradeTotal;
	}
	public double getDeclPrice() {
		return declPrice;
	}
	public void setDeclPrice(double declPrice) {
		this.declPrice = declPrice;
	}
	public double getDeclTotalPrice() {
		return declTotalPrice;
	}
	public void setDeclTotalPrice(double declTotalPrice) {
		this.declTotalPrice = declTotalPrice;
	}
	public String getUseTo() {
		return useTo;
	}
	public void setUseTo(String useTo) {
		this.useTo = useTo;
	}
	public int getDeclareCount() {
		return declareCount;
	}
	public void setDeclareCount(int declareCount) {
		this.declareCount = declareCount;
	}
	public String getGoodsUnit() {
		return goodsUnit;
	}
	public void setGoodsUnit(String goodsUnit) {
		this.goodsUnit = goodsUnit;
	}
	public double getGoodsGrossWeight() {
		return goodsGrossWeight;
	}
	public void setGoodsGrossWeight(double goodsGrossWeight) {
		this.goodsGrossWeight = goodsGrossWeight;
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
	public String getProductRecordNo() {
		return productRecordNo;
	}
	public void setProductRecordNo(String productRecordNo) {
		this.productRecordNo = productRecordNo;
	}
	public String getWebSite() {
		return webSite;
	}
	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}

}
