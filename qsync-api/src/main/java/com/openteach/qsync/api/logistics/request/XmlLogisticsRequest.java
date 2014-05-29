package com.openteach.qsync.api.logistics.request;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.openteach.qsync.api.CommonXmlRequestHead;
import com.openteach.qsync.api.XmlRequest;

@XmlAccessorType(XmlAccessType.FIELD)  
@XmlRootElement(name="mo")
@XmlType(name = "mo", propOrder = {"head", "body"})
public class XmlLogisticsRequest extends XmlRequest {

	@XmlElement(required = true)
	private CommonXmlRequestHead head;
	
	@XmlElement(required = true)
	private XmlLogisticsRequestBody body;

	public CommonXmlRequestHead getHead() {
		return head;
	}

	public XmlLogisticsRequestBody getBody() {
		return body;
	}

	public void setHead(CommonXmlRequestHead head) {
		this.head = head;
	}

	public void setBody(XmlLogisticsRequestBody body) {
		this.body = body;
	}
}
