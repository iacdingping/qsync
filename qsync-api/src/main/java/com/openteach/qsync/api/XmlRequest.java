package com.openteach.qsync.api;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.openteach.qsync.api.utils.JaxbUtils;


/**
 * 
 * @author rqq
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)  
@XmlRootElement(name="mo")
@XmlType(name = "mo", propOrder = {"head", "body"})
public class XmlRequest {
	
	public static final String DEFAULT_VERSION = "1.0.0";
	
	@XmlAttribute(required = true)
	private String version = DEFAULT_VERSION;

	/**
	 * 
	 */
	@XmlElement(required = true)
	private BaseHead head;
	
	/**
	 * 
	 */
	@XmlElement(required = true)
	private BaseBody body;

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}
	
	public BaseHead getHead() {
		return head;
	}

	public void setHead(BaseHead head) {
		this.head = head;
	}

	public BaseBody getBody() {
		return body;
	}

	public void setBody(BaseBody body) {
		this.body = body;
	}
	
	/**
	 * 
	 * @return
	 */
	public String toXml() {
		return JaxbUtils.convertToXml(this);
	}
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String ... args) {
		XmlRequest request = new XmlRequest();
		request.setHead(new BaseHead());
		request.setBody(new BaseBody());
		System.out.println(request.toXml());
	}
}