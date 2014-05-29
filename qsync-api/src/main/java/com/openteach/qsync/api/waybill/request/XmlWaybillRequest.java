package com.openteach.qsync.api.waybill.request;

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
public class XmlWaybillRequest extends XmlRequest {

	@XmlElement(required = true)
	private CommonXmlRequestHead head;
	
	@XmlElement(required = true)
	private XmlWaybillRequestBody body;

	public CommonXmlRequestHead getHead() {
		return head;
	}

	public XmlWaybillRequestBody getBody() {
		return body;
	}

	public void setHead(CommonXmlRequestHead head) {
		this.head = head;
	}

	public void setBody(XmlWaybillRequestBody body) {
		this.body = body;
	}
}
