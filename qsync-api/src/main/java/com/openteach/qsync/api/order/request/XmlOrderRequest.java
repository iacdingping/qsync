package com.openteach.qsync.api.order.request;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.openteach.qsync.api.CommonXmlRequestHead;
import com.openteach.qsync.api.XmlRequest;

/**
 * 
 * @author sihai
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)  
@XmlRootElement(name="mo")
@XmlType(name = "mo", propOrder = {"head", "body"})
public class XmlOrderRequest extends XmlRequest {

	/**
	 * 
	 */
	@XmlElement(required = true)
	private CommonXmlRequestHead head;
	
	/**
	 * 
	 */
	@XmlElement(required = true)
	private XmlOrderRequestBody body;

	public CommonXmlRequestHead getHead() {
		return head;
	}

	public XmlOrderRequestBody getBody() {
		return body;
	}

	public void setHead(CommonXmlRequestHead head) {
		this.head = head;
	}

	public void setBody(XmlOrderRequestBody body) {
		this.body = body;
	}
}
