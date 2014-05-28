package com.openteach.qsync.api.order.request;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;

import com.openteach.qsync.api.JkfSign;

/**
 * 
 * @author IAC-DINGPING
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace="order.request", name = "orderInfo")
public class OrderInfo {

	@XmlElement(required = true)
	private JkfSign jkfSign;
	
	@XmlElement(required = true)
	private JkfOrderImportHead jkfOrderImportHead;
	
	@XmlElementWrapper
	@XmlElement(required = true, name="jkfOrderDetail")
	private List<JkfOrderDetail> jkfOrderDetailList;
	
	@XmlElement(required = true)
	private JkfGoodsPurchaser jkfGoodsPurchaser;

	public JkfSign getJkfSign() {
		return jkfSign;
	}

	public void setJkfSign(JkfSign jkfSign) {
		this.jkfSign = jkfSign;
	}

	public JkfOrderImportHead getJkfOrderImportHead() {
		return jkfOrderImportHead;
	}

	public void setJkfOrderImportHead(JkfOrderImportHead jkfOrderImportHead) {
		this.jkfOrderImportHead = jkfOrderImportHead;
	}

	public List<JkfOrderDetail> getJkfOrderDetailList() {
		return jkfOrderDetailList;
	}

	public void setJkfOrderDetailList(List<JkfOrderDetail> jkfOrderDetailList) {
		this.jkfOrderDetailList = jkfOrderDetailList;
	}

	public JkfGoodsPurchaser getJkfGoodsPurchaser() {
		return jkfGoodsPurchaser;
	}

	public void setJkfGoodsPurchaser(JkfGoodsPurchaser jkfGoodsPurchaser) {
		this.jkfGoodsPurchaser = jkfGoodsPurchaser;
	}
}
