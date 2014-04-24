package com.openteach.qsync.api.goods;

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
@XmlType(name = "goodsDeclarModule")
public class GoodsDeclarModule {
	
	/**
	 * 
	 */
	@XmlElement(required = true)
	private JkfSign jkfSign;
	
	/**
	 * 
	 */
	@XmlElement(required = true)
	private GoodsDeclar goodsDeclar;
	
	/**
	 * 
	 */
	@XmlElement(required = true)
	private GoodsDeclarDetail goodsDeclarDetails;

	public JkfSign getJkfSign() {
		return jkfSign;
	}

	public void setJkfSign(JkfSign jkfSign) {
		this.jkfSign = jkfSign;
	}

	public GoodsDeclar getGoodsDeclar() {
		return goodsDeclar;
	}

	public void setGoodsDeclar(GoodsDeclar goodsDeclar) {
		this.goodsDeclar = goodsDeclar;
	}

	public GoodsDeclarDetail getGoodsDeclarDetails() {
		return goodsDeclarDetails;
	}

	public void setGoodsDeclarDetails(GoodsDeclarDetail goodsDeclarDetails) {
		this.goodsDeclarDetails = goodsDeclarDetails;
	}
}