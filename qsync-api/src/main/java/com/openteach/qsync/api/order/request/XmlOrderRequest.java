package com.openteach.qsync.api.order.request;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.openteach.qsync.api.CommonXmlRequestHead;
import com.openteach.qsync.api.XmlRequest;
import com.openteach.qsync.api.goods.request.XmlGoodsDeclarRequest;
import com.openteach.qsync.api.utils.JaxbUtils;

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
	
	public static void main(String[] args) {
		String xml = "<mo version=\"1.0.0\">" + 
				"	<head>" + 
				"		<businessType>IMPORTORDER</businessType>" + 
				"	</head>" + 
				"	<body>" + 
				"		<orderInfoList>" + 
				"			<orderInfo>" + 
				"				<jkfSign>" + 
				"					<companyCode>发送方备案编号</companyCode>" + 
				"					<businessNo>业务编号</businessNo>" + 
				"					<businessType>业务类型</businessType>" + 
				"					<declareType>申报类型</declareType>" + 
				"					<note>备注</note>" + 
				"				</jkfSign>" + 
				"				<jkfOrderImportHead>" + 
				"					<eCommerceCode>电商企业编号</eCommerceCode>" + 
				"					<eCommerceName>电商企业名称</eCommerceName>" + 
				"					<ieFlag>进出口标志</ieFlag>" + 
				"					<payType>支付类型</payType>" + 
				"					<payCompanyCode>支付公司编码</payCompanyCode>" + 
				"					<payNumber>支付单号</payNumber>" + 
				"					<orderTotalAmount>11.0</orderTotalAmount>" + 
				"					<orderNo>订单编号</orderNo>" + 
				"					<orderTaxAmount>11.0</orderTaxAmount>" + 
				"					<orderGoodsAmount>11.0</orderGoodsAmount>" + 
				"					<feeAmount>11.0</feeAmount>" + 
				"					<companyName>企业备案名称</companyName>" + 
				"					<companyCode>企业备案编码</companyCode>" + 
				"					<tradeTime>成交时间</tradeTime>" + 
				"					<currCode>成交币制</currCode>" + 
				"					<totalAmount>11.0</totalAmount>" + 
				"					<consigneeEmail>收件人邮箱</consigneeEmail>" + 
				"					<consigneeTel>收件人电话</consigneeTel>" + 
				"					<consignee>收件人</consignee>" + 
				"					<consigneeAddress>收件人地址</consigneeAddress>" + 
				"					<totalCount>11</totalCount>" + 
				"					<postMode>发货方式（物流方式）</postMode>" + 
				"					<senderCountry>发件人国别</senderCountry>" + 
				"					<senderName>发件人名称</senderName>" + 
				"					<purchaserId>购买人ID</purchaserId>" + 
				"					<logisCompanyName>物流企业备案名称</logisCompanyName>" + 
				"					<logisCompanyCode>物流企业备案编号</logisCompanyCode>" + 
				"					<zipCode>邮编</zipCode>" + 
				"					<note>备注信息</note>" + 
				"					<wayBills>运单号列表,单号之间分号隔开</wayBills>" + 
				"					<rate>1</rate>" + 
				"<userProcotol>本人承诺所购买商品系个人合理自用，现委托商家代理申报、代缴税款等通关事宜，本人保证遵守《海关法》和国家相关法律法规，保证所提供的身份信息和收货信息真实完整，无侵犯他人权益的行为，以上委托关系系如实填写，本人愿意接受海关、检验检疫机构及其他监管部门的监管，并承担相应法律责任。</userProcotol>" + 
				"				</jkfOrderImportHead>" + 
				"				<jkfOrderDetailList>" + 
				"					<jkfOrderDetail>" + 
				"						<goodsOrder>1</goodsOrder>" + 
				"						<itemNo>项号</itemNo>" + 
				"						<sourceNo>料号</sourceNo>" + 
				"						<goodsName>物品名称</goodsName>" + 
				"						<goodsModel>规格型号</goodsModel>" + 
				"						<codeTs>行邮税号</codeTs>" + 
				"						<grossWeight>24.3</grossWeight>" + 
				"						<unitPrice>10</unitPrice>" + 
				"						<goodsUnit>申报计量单位</goodsUnit>" + 
				"						<goodsCount>23</goodsCount>" + 
				"						<originCountry>产销国</originCountry>" + 
				"					</jkfOrderDetail>" + 
				"					<jkfOrderDetail>" + 
				"						<goodsOrder>2</goodsOrder>" + 
				"						<itemNo>项号</itemNo>" + 
				"						<sourceNo>料号</sourceNo>" + 
				"						<goodsName>物品名称</goodsName>" + 
				"						<goodsModel>规格型号</goodsModel>" + 
				"						<codeTs>行邮税号</codeTs>" + 
				"						<grossWeight>24.3</grossWeight>" + 
				"						<unitPrice>10</unitPrice>" + 
				"						<goodsUnit>申报计量单位</goodsUnit>" + 
				"						<goodsCount>24</goodsCount>" + 
				"						<originCountry>产销国</originCountry>" + 
				"					</jkfOrderDetail>" + 
				"				</jkfOrderDetailList>" + 
				"				<jkfGoodsPurchaser>" + 
				"					<id>购买人ID</id>" + 
				"					<name>购买人名称</name>" + 
				"					<email>购买人邮箱</email>" + 
				"					<telNumber>联系电话</telNumber>" + 
				"					<address>地址</address>" + 
				"					<paperType>证件类型</paperType>" + 
				"					<paperNumber>证件号码</paperNumber>" + 
				"				</jkfGoodsPurchaser>" + 
				"			</orderInfo>" + 
				"		</orderInfoList>" + 
				"	</body>" + 
				"</mo>";
		
		XmlOrderRequest request = JaxbUtils.converyToJavaBean(xml, XmlOrderRequest.class);
		System.out.println(JaxbUtils.convertToXml(request));
	}
}
