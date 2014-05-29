package com.openteach.qsync.api;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.openteach.qsync.api.XmlResponse;

/**
 * 
 * @author sihai
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)  
@XmlRootElement(name="mo")
@XmlType(name = "mo", propOrder = {"head", "body"})
public class CommonXmlResponse extends XmlResponse {

	@XmlElement(required = true)
	private CommonXmlResponseHead head;
	
	@XmlElement(required = true)
	private CommonXmlResponseBody body;

	public CommonXmlResponseHead getHead() {
		return head;
	}

	public CommonXmlResponseBody getBody() {
		return body;
	}

	public void setHead(CommonXmlResponseHead head) {
		this.head = head;
	}

	public void setBody(CommonXmlResponseBody body) {
		this.body = body;
	}
}
