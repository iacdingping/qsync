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
@XmlType(namespace="order.request", name = "jkfOrderDetail")
public class JkfOrderDetail {

	/**
	 * 商品序号,序号不大于50
	 */
	@XmlElement(required = true)
	private Integer goodsOrder;
	/**
	 * 物品名称
	 */
	@XmlElement(required = true)
	private String goodsName;
	/**
	 * 行邮税号 必须已备案，且与参数说明文档中的行邮税号中的税号一致
	 */
	@XmlElement(required = true)
	private String goodsNo;
	/**
	 * 商品规格、型号
	 */
	@XmlElement(required = false)
	@Deprecated
	private String goodsModel;
	/**
	 * 产销国
	 */
	@XmlElement(required = true)
	private String countryCode;
	/**
	 * 申报单价
	 */
	@XmlElement(required = true)
	private Double unitPrice;
	/**
	 * 申报数量
	 */
	@XmlElement(required = true)
	private Double goodsCount;
	/**
	 * 申报计量单位
	 */
	@XmlElement(required = true)
	private String goodsUnit;
	/**
	 * 商品毛重
	 */
	@XmlElement(required = false)
	@Deprecated
	private Double weight;
	public Integer getGoodsOrder() {
		return goodsOrder;
	}
	public void setGoodsOrder(Integer goodsOrder) {
		this.goodsOrder = goodsOrder;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public String getGoodsNo() {
		return goodsNo;
	}
	public void setGoodsNo(String goodsNo) {
		this.goodsNo = goodsNo;
	}
	public String getGoodsModel() {
		return goodsModel;
	}
	public void setGoodsModel(String goodsModel) {
		this.goodsModel = goodsModel;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public Double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public Double getGoodsCount() {
		return goodsCount;
	}
	public void setGoodsCount(Double goodsCount) {
		this.goodsCount = goodsCount;
	}
	public String getGoodsUnit() {
		return goodsUnit;
	}
	public void setGoodsUnit(String goodsUnit) {
		this.goodsUnit = goodsUnit;
	}
	public Double getWeight() {
		return weight;
	}
	public void setWeight(Double weight) {
		this.weight = weight;
	}
}
