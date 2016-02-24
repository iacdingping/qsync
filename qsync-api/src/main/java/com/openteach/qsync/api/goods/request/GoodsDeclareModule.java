package com.openteach.qsync.api.goods.request;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;

import com.openteach.qsync.api.JkfSign;

/**
 * 
 * @author rqq
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "goodsDeclarModule")
public class GoodsDeclareModule {
	
	@XmlElement(required = true)
	private JkfSign jkfSign;
	
	@XmlElement(required = true)
	private GoodsDeclare goodsDeclare;
	
	@XmlElementWrapper
	@XmlElement(required = true, name="goodsDeclareDetail")
	private List<GoodsDeclareDetail> goodsDeclareDetails;

	public JkfSign getJkfSign() {
		return jkfSign;
	}

	public void setJkfSign(JkfSign jkfSign) {
		this.jkfSign = jkfSign;
	}

	public GoodsDeclare getGoodsDeclare() {
		return goodsDeclare;
	}

	public void setGoodsDeclare(GoodsDeclare goodsDeclare) {
		this.goodsDeclare = goodsDeclare;
	}

	public List<GoodsDeclareDetail> getGoodsDeclareDetails() {
		return goodsDeclareDetails;
	}

	public void setGoodsDeclareDetails(List<GoodsDeclareDetail> goodsDeclareDetails) {
		this.goodsDeclareDetails = goodsDeclareDetails;
	}

}