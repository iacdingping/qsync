package com.openteach.qsync.api.order.request;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * 订单表体信息
 * @author IAC-DINGPING
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "jkfOrderDetail")
public class JkfOrderDetail {

	/**
	 * 商品序号,序号不大于50
	 */
	@XmlElement(required = true)
	private Integer goodsOrder;
	/**
	 * 项号
	 */
	@XmlElement(required = true)
	private String itemNo;
	/**
	 * 料号
	 */
	@XmlElement(required = true)
	private String sourceNo;
	/**
	 * 物品名称
	 */
	@XmlElement(required = true)
	private String goodsName;
	/**
	 * 商品规格、型号
	 */
	@XmlElement(required = false)
	@Deprecated
	private String goodsModel;
	/**
	 * 行邮税号 必须已备案，且与参数说明文档中的行邮税号中的税号一致
	 */
	@XmlElement(required = true)
	private String codeTs;
	/**
	 * 商品毛重
	 */
	@XmlElement(required = false)
	@Deprecated
	private Double grossWeight;
	/**
	 * 申报单价
	 */
	@XmlElement(required = true)
	private Double unitPrice;
	/**
	 * 申报计量单位
	 */
	@XmlElement(required = true)
	private String goodsUnit;
	/**
	 * 申报数量
	 */
	@XmlElement(required = true)
	private Double goodsCount;
	/**
	 * 产销国
	 */
	@XmlElement(required = true)
	private String originCountry;
	public Integer getGoodsOrder() {
		return goodsOrder;
	}
	public void setGoodsOrder(Integer goodsOrder) {
		this.goodsOrder = goodsOrder;
	}
	public String getItemNo() {
		return itemNo;
	}
	public void setItemNo(String itemNo) {
		this.itemNo = itemNo;
	}
	public String getSourceNo() {
		return sourceNo;
	}
	public void setSourceNo(String sourceNo) {
		this.sourceNo = sourceNo;
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
	public String getCodeTs() {
		return codeTs;
	}
	public void setCodeTs(String codeTs) {
		this.codeTs = codeTs;
	}
	public Double getGrossWeight() {
		return grossWeight;
	}
	public void setGrossWeight(Double grossWeight) {
		this.grossWeight = grossWeight;
	}
	public Double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public String getGoodsUnit() {
		return goodsUnit;
	}
	public void setGoodsUnit(String goodsUnit) {
		this.goodsUnit = goodsUnit;
	}
	public Double getGoodsCount() {
		return goodsCount;
	}
	public void setGoodsCount(Double goodsCount) {
		this.goodsCount = goodsCount;
	}
	public String getOriginCountry() {
		return originCountry;
	}
	public void setOriginCountry(String originCountry) {
		this.originCountry = originCountry;
	}
}
