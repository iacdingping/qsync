package com.openteach.qsync.api.record.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.openteach.qsync.api.CommonXmlResponseHead;
import com.openteach.qsync.api.XmlResponse;

/**
 * 
 * @author sihai
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)  
@XmlRootElement(name="mo")
@XmlType(name = "mo", propOrder = {"head", "body"})
public class XmlRecordResponse extends XmlResponse {

	@XmlElement(required = true)
	private CommonXmlResponseHead head;
	
	@XmlElement(required = true)
	private XmlRecordResponseBody body;

	public CommonXmlResponseHead getHead() {
		return head;
	}

	public XmlRecordResponseBody getBody() {
		return body;
	}

	public void setHead(CommonXmlResponseHead head) {
		this.head = head;
	}

	public void setBody(XmlRecordResponseBody body) {
		this.body = body;
	}
}
