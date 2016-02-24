package com.openteach.qsync.api.goods.request;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.openteach.qsync.api.CommonXmlRequestHead;
import com.openteach.qsync.api.XmlRequest;
import com.openteach.qsync.api.utils.JaxbUtils;

/**
 * 
 * @author sihai
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)  
@XmlRootElement(name="mo")
@XmlType(name = "mo", propOrder = {"head", "body"})
public class XmlGoodsDeclarRequest extends XmlRequest {

	@XmlElement(required = true, name="head")
	private CommonXmlRequestHead head;
	
	@XmlElement(required = true, name="body")
	private XmlGoodsDeclareRequestBody body;
	
	public CommonXmlRequestHead getHead() {
		return head;
	}

	public void setHead(CommonXmlRequestHead head) {
		this.head = head;
	}

	public XmlGoodsDeclareRequestBody getBody() {
		return body;
	}

	public void setBody(XmlGoodsDeclareRequestBody body) {
		this.body = body;
	}


	public static void main(String[] args) {
		String xml = "<mo version=\"1.0.0\">" +
				"  <head>" +
				"    <businessType>PERSONAL_GOODS_DECLAR</businessType>" +
				"  </head>" +
				"  <body>" +
				"    <goodsDeclareModuleList>" +
				"      <goodsDeclareModule>" +
				"        <jkfSign>" +
				"          <companyCode>发送方备案编号</companyCode>" +
				"          <businessNo>业务编码</businessNo>" +
				"          <businessType>业务类型</businessType>" +
				"          <declareType>申报类型</declareType>" +
				"          <note>备注</note>" +
				"        </jkfSign>" +
				"        <goodsDeclare>" +
				"  		  <accountBookNo>账册编号</accountBookNo>" +
				"          <ieFlag>进出口标志</ieFlag>" +
				"          <preEntryNumber>预录入号码</preEntryNumber>" +
				"          <importType>进口类型</importType>" +
				"          <inOutDateStr>2015-11-12 10:30:00</inOutDateStr>" +
				"          <iePort>进出口岸代码</iePort>" +
				"          <destinationPort>指运港(抵运港)</destinationPort>" +
				"          <trafName>运输工具名称</trafName>" +
				"          <voyageNo>运输工具航次(班)号</voyageNo>" +
				"          <trafMode>运输方式代码</trafMode>" +
				"          <declareCompanyType>申报单位类别</declareCompanyType>" +
				"          <declareCompanyCode>申报单位代码</declareCompanyCode>" +
				"          <declareCompanyName>申报单位名称</declareCompanyName>" +
				"          <eCommerceCode>电商企业代码</eCommerceCode>" +
				"          <eCommerceName>电商企业名称</eCommerceName>" +
				"          <orderNo>订单编号</orderNo>" +
				"          <wayBill>分运单号</wayBill>" +
				"          <tradeCountry>贸易国别（起运地）</tradeCountry>" +
				"          <packNo>100</packNo>" +
				"          <grossWeight>23.5</grossWeight>" +
				"          <netWeight>22</netWeight>" +
				"          <warpType>包装种类</warpType>" +
				"          <remark>备注</remark>" +
				"          <declPort>申报口岸代码</declPort>" +
				"          <enteringPerson>录入人</enteringPerson>" +
				"          <enteringCompanyName>录入单位名称</enteringCompanyName>" +
				"          <declarantNo>报关员代码</declarantNo>" +
				"          <customsField>码头/货场代码</customsField>" +
				"          <senderName>发件人</senderName>" +
				"          <consignee>收件人</consignee>" +
				"          <senderCountry>发件人国别</senderCountry>" +
				"          <senderCity>发件人城市</senderCity>" +
				"          <paperType>支付人证件类型</paperType>" +
				"          <paperNumber>支付人证件号</paperNumber>" +
				"          <worth>10000</worth>" +
				"          <currCode>币制</currCode>" +
				"          <mainGName>主要货物名称</mainGName>" +
				"          <internalAreaCompanyNo>区内企业编码</internalAreaCompanyNo>" +
				"          <internalAreaCompanyName>区内企业名称</internalAreaCompanyName>" +
				"          <applicationFormNo>申请单编号</applicationFormNo>" +
				"		  <isAuthorize>0</isAuthorize>" +
				"        </goodsDeclare>" +
				"        <goodsDeclareDetails>" +
				"          <goodsDeclareDetail>" +
				"            <goodsOrder>1</goodsOrder>" +
				"            <codeTs>行邮税号</codeTs>" +
				"            <goodsItemNo>商品货号</goodsItemNo>" +
				"            <goodsName>物品名称</goodsName>" +
				"            <goodsModel>商品规格、型号</goodsModel>" +
				"            <originCountry>产销国</originCountry>" +
				"            <tradeCurr>成交币制</tradeCurr>" +
				"            <tradeTotal>11.11</tradeTotal>" +
				"            <declPrice>1.2</declPrice>" +
				"            <declTotalPrice>25.23</declTotalPrice>" +
				"            <useTo>用途</useTo>" +
				"            <declareCount>10</declareCount>" +
				"            <goodsUnit>申报计量单位</goodsUnit>" +
				"            <goodsGrossWeight>23</goodsGrossWeight>" +
				"            <firstUnit>第一单位</firstUnit>" +
				"            <firstCount>1</firstCount>" +
				"            <secondUnit>第二单位</secondUnit>" +
				"            <secondCount>20</secondCount>" +
				"			<productRecordNo>产品国检备案编号</productRecordNo>" +
				"			<webSite>商品网址</webSite>" +
				"          </goodsDeclareDetail>" +
				"        </goodsDeclareDetails>" +
				"      </goodsDeclareModule>" +
				"    </goodsDeclareModuleList>" +
				"  </body>" +
				"</mo>";
		
		XmlGoodsDeclarRequest request = JaxbUtils.converyToJavaBean(xml, XmlGoodsDeclarRequest.class);
		System.out.println(JaxbUtils.convertToXml(request));
	}
}
