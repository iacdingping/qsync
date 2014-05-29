package com.openteach.qsync.api.goods.response;

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
@XmlType (name="body")
public class XmlGoodsDeclarResponseBody {

	@XmlElement(required = true, name="jkfSign")
	private JkfSign jkfSign;
	
	@XmlElement(required = true, name="jkfGoodsDeclar")
	private JkfGoodsDeclar jkfGoodsDeclar;

	public JkfSign getJkfSign() {
		return jkfSign;
	}

	public JkfGoodsDeclar getJkfGoodsDeclar() {
		return jkfGoodsDeclar;
	}

	public void setJkfSign(JkfSign jkfSign) {
		this.jkfSign = jkfSign;
	}

	public void setJkfGoodsDeclar(JkfGoodsDeclar jkfGoodsDeclar) {
		this.jkfGoodsDeclar = jkfGoodsDeclar;
	}
}
