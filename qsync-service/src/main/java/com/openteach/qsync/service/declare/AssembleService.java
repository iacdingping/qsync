package com.openteach.qsync.service.declare;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openteach.qsync.api.BaseHead;
import com.openteach.qsync.api.JkfSign;
import com.openteach.qsync.api.XmlRequest;
import com.openteach.qsync.api.order.request.JkfGoodsPurchaser;
import com.openteach.qsync.api.order.request.JkfOrderDetail;
import com.openteach.qsync.api.order.request.JkfOrderImportHead;
import com.openteach.qsync.api.order.request.OrderInfo;
import com.openteach.qsync.core.ConfigService;
import com.openteach.qsync.core.OrderStatus;
import com.openteach.qsync.core.declare.DeclarePayType;
import com.openteach.qsync.core.declare.DeclarePayTypeManager;
import com.openteach.qsync.core.goods.Commsku;
import com.openteach.qsync.core.goods.CommskuManager;
import com.openteach.qsync.core.goods.TransportCommodity;
import com.openteach.qsync.core.goods.TransportCommodityManager;
import com.openteach.qsync.core.info.Member;
import com.openteach.qsync.core.info.MemberManager;
import com.openteach.qsync.core.order.Order;
import com.openteach.qsync.core.order.OrderManager;
import com.openteach.qsync.core.order.OrderQuery;
import com.openteach.qsync.core.order.OrderTransport;
import com.openteach.qsync.core.order.OrderTransportManager;
import com.openteach.qsync.util.common.DateUtil;

/**
 * 组装请求服务
 * 1、全部根据订单取数据
 * 2、物流数据是否应该分开
 * @author IAC-DINGPING
 *
 */
@Service
public class AssembleService implements InitializingBean {
	@Autowired private ConfigService configService;
	@Autowired private OrderManager orderManager;
	@Autowired private MemberManager memberManager;
	@Autowired private DeclarePayTypeManager declarePayTypeManager;
	@Autowired private OrderTransportManager orderTransportManager;
	@Autowired private TransportCommodityManager transportCommodityManager;
	@Autowired private CommskuManager commskuManager;
	
	private JkfSign jkfSign;
	private BaseHead head;
	
	private OrderQuery orderQuery;
	
	public 	List<Order> listOrders() {
		List<Order> orders = orderManager.list(orderQuery);
		for(Order order : orders) {
			Member member = memberManager.getById(order.getMember());
			order.setMemberObject(member);
			
			OrderTransport orderTransport = orderTransportManager.getById(order.getOrdertransport());
			List<TransportCommodity> transportCommoditiyList = transportCommodityManager.getByOrderTransport(order.getOrdertransport());
			for(TransportCommodity tc : transportCommoditiyList) {
				Commsku commsku = commskuManager.getByIdMappedCommodity(tc.getSkuId());
				tc.setCommskuObject(commsku);
			}
			orderTransport.setTransportCommoditiyList(transportCommoditiyList);
			order.setOrderTransportObject(orderTransport);
			
		}
		return orders;
	}
	
	/**
	 * 封装订单报关报文信息
	 * @param order
	 * @return
	 */
	public XmlRequest getOrderXmlRequest(Order order) {
		XmlRequest request = new XmlRequest();
		com.openteach.qsync.api.order.request.Body body = new com.openteach.qsync.api.order.request.Body();
		OrderInfo orderInfo = new OrderInfo();
		orderInfo.setJkfSign(this.getJkfSign());
		JkfOrderImportHead jkfOrderImportHead = new JkfOrderImportHead();
		jkfOrderImportHead.setCompanyName(configService.getDeclareCompanyName());
		jkfOrderImportHead.setCompanyCode(configService.getDeclareCompanyCode());
		jkfOrderImportHead.setIeFlag("I");
		DeclarePayType declarePayType = declarePayTypeManager.getDeclarePayType(order.getOnlinepay());
		jkfOrderImportHead.setPayType(declarePayType.getDeclarePayType());
		jkfOrderImportHead.setPayCompanyCode(declarePayType.getPlatformPayCompanyCode());
		jkfOrderImportHead.setPayNumber();
		jkfOrderImportHead.setTotalAmount(order.getAmount());
		jkfOrderImportHead.setOrderNo(order.getCode());
		jkfOrderImportHead.setOrderTaxAmount();
		jkfOrderImportHead.setFeeAmount(order.getTransPrice());
		jkfOrderImportHead.seteCommerceCode(configService.getDeclareRecordNo());
		jkfOrderImportHead.seteCommerceName(configService.getDeclareCompanyName());
		jkfOrderImportHead.setTradeTime(DateUtil.format(order.getOrdertime()));
		jkfOrderImportHead.setCurrCode(configService.getDeclareCurrency());
		jkfOrderImportHead.setTotalAmount(order.getAmount() + order.getTransPrice());
		jkfOrderImportHead.setConsigneeEmail();
		jkfOrderImportHead.setConsigneeTel(order.getOrderTransportObject().getPhonenumber());
		jkfOrderImportHead.setConsignee(order.getOrderTransportObject().getFirstname() + " " + order.getOrderTransportObject().getLastname());
		jkfOrderImportHead.setConsigneeAddress(StringUtils.defaultIfEmpty(
				order.getOrderTransportObject().getAddress1(), order.getOrderTransportObject().getAddress2()));
		jkfOrderImportHead.setTotalCount(order.getCutamount() == null ? 1 : order.getCutamount().intValue());
		jkfOrderImportHead.setPostMode(postMode);	//transportaion.type
		jkfOrderImportHead.setSalerCountry();		//order_transport.addressorCountry
		jkfOrderImportHead.setAddressorName();	//order_transport.addressorName
		jkfOrderImportHead.setPurchaserId(order.getMemberObject().getId().toString());
		jkfOrderImportHead.setLogisCompanyName(logisCompanyName);	//cc_kata_kplus_transportationcompany.name
		jkfOrderImportHead.setLogisCompanyCode(logisCompanyCode);	//cc_kata_kplus_transportationcompany.code
		jkfOrderImportHead.setZipCode(zipCode);	//cc_kata_kplus_transportationcompany.zip_code
		orderInfo.setJkfOrderImportHead(jkfOrderImportHead);
		
		List<JkfOrderDetail> jkfOrderDetailList = new ArrayList<JkfOrderDetail>();
		List<TransportCommodity> transportCommoditiyList = order.getOrderTransportObject().getTransportCommoditiyList();
		for(int i=0; i<transportCommoditiyList.size(); i++) {
			TransportCommodity tc = transportCommoditiyList.get(i);
			Commsku commsku = tc.getCommskuObject();
			JkfOrderDetail jkfOrderDetail = new JkfOrderDetail();
			jkfOrderDetail.setGoodsOrder(i);
			jkfOrderDetail.setGoodsName(commsku.getName());
			jkfOrderDetail.setGoodsNo(goodsNo);	//cc_kata_kplus_commodity.tariff
			jkfOrderDetail.setGoodsModel(commsku.getCommodity().getItemcode());
			jkfOrderDetail.setCountryCode(countryCode);	//cc_kata_kplus_commodity.sales_country
			jkfOrderDetail.setUnitPrice(tc.getPrice());
			jkfOrderDetail.setGoodsCount(tc.getDelivernum().doubleValue());
			jkfOrderDetail.setGoodsUnit(goodsUnit);	//cc_kata_kplus_commodity.unit
			jkfOrderDetail.setWeight(commsku.getCommodity().getWeight().doubleValue());
			jkfOrderDetailList.add(jkfOrderDetail);
		}
		orderInfo.setJkfOrderDetailList(jkfOrderDetailList);
		
		JkfGoodsPurchaser jkfGoodsPurchaser = new JkfGoodsPurchaser();
		jkfGoodsPurchaser.setId(order.getMember().toString());
		jkfGoodsPurchaser.setName(order.getMemberObject().getTruename());
		jkfGoodsPurchaser.setEmail(order.getMemberObject().getEmail());
		jkfGoodsPurchaser.setTelNumber(StringUtils.defaultIfEmpty(order.getMemberObject().getHandphone(), order.getMemberObject().getPhonenumber()));
		jkfGoodsPurchaser.setPaperType();	//kata_kplus_member.certificates_type
		jkfGoodsPurchaser.setPaperNumber();	//kata_kplus_member.certificates
		jkfGoodsPurchaser.setAddress(order.getMemberObject().getAddress());
		orderInfo.setJkfGoodsPurchaser(jkfGoodsPurchaser);
		
		request.setHead(head);
		request.setBody(body);
		return request;
	}
	
	/**
	 * 获取物流报关报文
	 * @param order
	 * @return
	 */
	public XmlRequest getLogisticsXmlRequest(Order order) {
		XmlRequest request = new XmlRequest();
		com.openteach.qsync.api.logistics.request.Body body = new com.openteach.qsync.api.logistics.request.Body();
		
		request.setHead(head);
		request.setBody(body);
		return request;
	}
	
	/**
	 * 获取个人物品报关报文
	 * @param order
	 * @return
	 */
	public XmlRequest getGoodsXmlRequest(Order order) {
		XmlRequest request = new XmlRequest();
		com.openteach.qsync.api.goods.request.Body body = new com.openteach.qsync.api.goods.request.Body();
		
		request.setHead(head);
		request.setBody(body);
		return request;
	}
	
	/**
	 * 获取运单报关报文
	 * @param order
	 * @return
	 */
	public XmlRequest getWaybillXmlRequest(Order order) {
		XmlRequest request = new XmlRequest();
		com.openteach.qsync.api.waybill.request.Body body = new com.openteach.qsync.api.waybill.request.Body();
		
		request.setHead(head);
		request.setBody(body);
		return request;
	}
	
	/**
	 * 读取配置文件后即初始化  note字段未指定
	 * 
	 * @return 请求签名信息
	 */
	public JkfSign getJkfSign() {
		return jkfSign;
	}
	public void setJkfSign(JkfSign jkfSign) {
		this.jkfSign = jkfSign;
	}
	public BaseHead getHead() {
		return head;
	}
	public void setHead(BaseHead head) {
		this.head = head;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		jkfSign = new JkfSign();
		jkfSign.setBusinessNo(configService.getDeclareBusinessNo());
		jkfSign.setBusinessType(configService.getDeclareBusinessType());
		jkfSign.setCompanyCode(configService.getDeclareCompanyCode());
		jkfSign.setDeclareType(configService.getDeclareType());
		
		head.setBusinessType(configService.getDeclareBusinessType());
		
		orderQuery = new OrderQuery();
		orderQuery.setStatus(OrderStatus.DELIVERED.ordinal());
		orderQuery.setPageSize(10L);
	}
}
