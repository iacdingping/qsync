package com.openteach.qsync.api.goods.request;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import com.openteach.qsync.api.JkfSign;

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
	private List<GoodsDeclarDetail> goodsDeclarDetails;

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

	public List<GoodsDeclarDetail> getGoodsDeclarDetails() {
		return goodsDeclarDetails;
	}

	public void setGoodsDeclarDetails(List<GoodsDeclarDetail> goodsDeclarDetails) {
		this.goodsDeclarDetails = goodsDeclarDetails;
	}

}