package com.openteach.qsync.core.service.order;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.openteach.qsync.core.ConfigService;
import com.openteach.qsync.core.OrderDeclareStatus;
import com.openteach.qsync.core.OrderStatus;
import com.openteach.qsync.core.entity.goods.Commsku;
import com.openteach.qsync.core.entity.info.Member;
import com.openteach.qsync.core.entity.logistics.TransportCommodity;
import com.openteach.qsync.core.entity.logistics.Transportation;
import com.openteach.qsync.core.entity.logistics.Transportationcompany;
import com.openteach.qsync.core.entity.order.Order;
import com.openteach.qsync.core.entity.order.OrderTransport;
import com.openteach.qsync.core.manager.goods.CommskuManager;
import com.openteach.qsync.core.manager.info.CountryManager;
import com.openteach.qsync.core.manager.info.MemberManager;
import com.openteach.qsync.core.manager.logistics.TransportCommodityManager;
import com.openteach.qsync.core.manager.logistics.TransportationManager;
import com.openteach.qsync.core.manager.logistics.TransportationcompanyManager;
import com.openteach.qsync.core.manager.order.OrderManager;
import com.openteach.qsync.core.manager.order.OrderTransportManager;
import com.openteach.qsync.core.query.order.OrderQuery;

@Service
@Transactional
public class OrderService {

	@Autowired private ConfigService configService;
	@Autowired private OrderManager orderManager;
	@Autowired private MemberManager memberManager;
	@Autowired private CountryManager countryManager;
	@Autowired private OrderTransportManager orderTransportManager;
	@Autowired private TransportCommodityManager transportCommodityManager;
	@Autowired private CommskuManager commskuManager;
	@Autowired private TransportationManager transportationManager;
	@Autowired private TransportationcompanyManager transportationcompanyManager;
	
	private OrderQuery orderQuery;
	
	@PostConstruct
	public void initial() {
		orderQuery = new OrderQuery();
		orderQuery.setStatus(OrderStatus.DELIVERED.ordinal());
		orderQuery.setPageSize(10L);
		orderQuery.setDeclareStatus(OrderDeclareStatus.READY.getValue());
	}
	
	public 	List<Order> listOrders() {
		List<Order> orders = orderManager.list(orderQuery);
		for(Order order : orders) {
			orderManager.updateDeclareStatus(order.getId(), OrderDeclareStatus.INITIALIZE.getValue());
		}
		return orders;
	}
	
	public void mappingOrder(Order order) {
		Member member = memberManager.getById(order.getMember());
		order.setMemberObject(member);
		
		Transportation transportation = transportationManager.getById(order.getTransportationId());
		order.setTransportationObject(transportation);
		Transportationcompany transportationcompany = transportationcompanyManager.getById(order.getTransportationcompanyId());
		order.setTransportationcompanyObject(transportationcompany);
		
		OrderTransport orderTransport = orderTransportManager.getById(order.getOrdertransport());
		List<TransportCommodity> transportCommodityList = transportCommodityManager.listByOrderTransport(order.getOrdertransport());
		int totalGoodsCount = 0;
		double totalGoodsWeight = 0.0;
		for(TransportCommodity tc : transportCommodityList) {
			Commsku commsku = commskuManager.getByIdMappedCommodityAndCategory(tc.getSkuId());
			tc.setCommskuObject(commsku);
			//计算总件数与总重量
			totalGoodsCount += tc.getDelivernum() == null ? 0 : tc.getDelivernum().intValue();
			Integer weight = tc.getCommskuObject().getCommodityObject().getWeight() == null ?
					0 : tc.getCommskuObject().getCommodityObject().getWeight();
			totalGoodsWeight += tc.getDelivernum() == null ? 0 : tc.getDelivernum().intValue() * weight;
		}
		order.setTotalGoodsCount(totalGoodsCount);
		order.setTotalGoodsWeight(totalGoodsWeight);
		orderTransport.setTransportCommodityList(transportCommodityList);;
		order.setOrderTransportObject(orderTransport);
	}
}

