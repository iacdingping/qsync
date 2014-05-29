package com.openteach.qsync.api.goods.request;

import java.util.Arrays;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
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
public class XmlGoodsDeclarRequest extends XmlRequest {

	@XmlAttribute(required = true)
	private String version = DEFAULT_VERSION;
	
	@XmlElement(required = true, name="head")
	private CommonXmlRequestHead head;
	
	@XmlElement(required = true, name="body")
	private XmlGoodsDeclarRequestBody body;
	
	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public CommonXmlRequestHead getHead() {
		return head;
	}

	public XmlGoodsDeclarRequestBody getBody() {
		return body;
	}

	public void setHead(CommonXmlRequestHead head) {
		this.head = head;
	}

	public void setBody(XmlGoodsDeclarRequestBody body) {
		this.body = body;
	}
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String ... args) {
		XmlGoodsDeclarRequest request = new XmlGoodsDeclarRequest();
		GoodsDeclarModule m = new GoodsDeclarModule();
		GoodsDeclar gd = new GoodsDeclar();
		CommonXmlRequestHead head = new CommonXmlRequestHead();
		XmlGoodsDeclarRequestBody body = new XmlGoodsDeclarRequestBody();
		head.setBusinessType(CommonXmlRequestHead.PERSONAL_GOODS_DECLAR);
		gd.setAccountBookNo("fdsfsre");
		gd.setApplicationFormNo("dsfsdfsfrewr");
		gd.setCurrency("dfsfd");
		gd.setInOutDatStr(new Date());
		m.setGoodsDeclar(gd);
		body.setGoodsDeclarModuleList(Arrays.asList(m));
		request.setHead(head);
		request.setBody(body);
		System.out.println(request.toXml());
	}
}
