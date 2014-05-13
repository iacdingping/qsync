package com.openteach.qsync.service.declare;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openteach.qsync.api.JkfSign;
import com.openteach.qsync.api.XmlRequest;
import com.openteach.qsync.api.order.request.JkfOrderImportHead;
import com.openteach.qsync.api.order.request.OrderInfo;
import com.openteach.qsync.core.ConfigService;
import com.openteach.qsync.core.OrderStatus;
import com.openteach.qsync.core.declare.DeclarePayType;
import com.openteach.qsync.core.declare.DeclarePayTypeManager;
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
	
	private JkfSign jkfSign;
	
	private OrderQuery orderQuery;
	
	public 	List<Order> listOrders() {
		List<Order> orders = orderManager.list(orderQuery);
		for(Order order : orders) {
			Member member = memberManager.getById(order.getMember());
			order.setMemberObject(member);
			
			OrderTransport orderTransport = orderTransportManager.getById(order.getOrdertransport());
			order.setOrderTransportObject(orderTransport);
		}
		return orders;
	}
	
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
	@Override
	public void afterPropertiesSet() throws Exception {
		jkfSign = new JkfSign();
		jkfSign.setBusinessNo(configService.getDeclareBusinessNo());
		jkfSign.setBusinessType(configService.getDeclareBusinessType());
		jkfSign.setCompanyCode(configService.getDeclareCompanyCode());
		jkfSign.setDeclareType(configService.getDeclareType());
		
		orderQuery = new OrderQuery();
		orderQuery.setStatus(OrderStatus.DELIVERED.ordinal());
		orderQuery.setPageSize(10L);
	}
}
