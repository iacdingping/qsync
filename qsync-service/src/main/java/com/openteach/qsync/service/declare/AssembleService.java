package com.openteach.qsync.service.declare;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openteach.qsync.api.CommonXmlRequestHead;
import com.openteach.qsync.api.JkfSign;
import com.openteach.qsync.api.goods.request.GoodsDeclar;
import com.openteach.qsync.api.goods.request.GoodsDeclarDetail;
import com.openteach.qsync.api.goods.request.GoodsDeclarModule;
import com.openteach.qsync.api.goods.request.XmlGoodsDeclarRequest;
import com.openteach.qsync.api.goods.request.XmlGoodsDeclarRequestBody;
import com.openteach.qsync.api.logistics.request.JkfLogisticsInfo;
import com.openteach.qsync.api.logistics.request.Logistics;
import com.openteach.qsync.api.logistics.request.XmlLogisticsRequest;
import com.openteach.qsync.api.logistics.request.XmlLogisticsRequestBody;
import com.openteach.qsync.api.order.request.JkfGoodsPurchaser;
import com.openteach.qsync.api.order.request.JkfOrderDetail;
import com.openteach.qsync.api.order.request.JkfOrderImportHead;
import com.openteach.qsync.api.order.request.OrderInfo;
import com.openteach.qsync.api.order.request.XmlOrderRequest;
import com.openteach.qsync.api.order.request.XmlOrderRequestBody;
import com.openteach.qsync.api.waybill.request.WayBill;
import com.openteach.qsync.api.waybill.request.WayBillImportDto;
import com.openteach.qsync.api.waybill.request.XmlWaybillRequest;
import com.openteach.qsync.api.waybill.request.XmlWaybillRequestBody;
import com.openteach.qsync.core.ConfigService;
import com.openteach.qsync.core.entity.goods.Commsku;
import com.openteach.qsync.core.entity.info.Country;
import com.openteach.qsync.core.entity.logistics.TransportCommodity;
import com.openteach.qsync.core.entity.order.Order;
import com.openteach.qsync.core.manager.info.CountryManager;
import com.openteach.qsync.core.service.order.OrderService;
import com.openteach.qsync.util.common.DateUtil;

/**
 * 组装请求服务
 * 1、全部根据订单取数据
 * 2、物流数据是否应该分开
 * @author IAC-DINGPING
 *
 */
@Service
public class AssembleService {
	@Autowired private ConfigService configService;
	@Autowired private CountryManager countryManager;
	@Autowired private OrderService orderService;
	
	private AtomicLong sequence = new AtomicLong(1);

	private String generateSequence() {
		return System.currentTimeMillis() + "" + sequence.incrementAndGet();
	}
	
	public List<Order> listOrders() {
		return orderService.listOrders();
	}
	
	ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	Validator validator = factory.getValidator();
	
	public void mappingOrder(Order order) {
		orderService.mappingOrder(order);
		Set<ConstraintViolation<Order>> violations = validator.validate(order);
		StringBuffer buf = new StringBuffer();
		for (ConstraintViolation<Order> violation : violations) {
			buf.append(violation.getPropertyPath()).append(" ")
				.append(violation.getMessage()).append("\n");
		}
		if(buf.length() > 0)
			throw new DataAssembleException(buf.toString());
	}
	
	/**
	 * 封装订单报关报文信息
	 * @param order
	 * @return
	 */
	public XmlOrderRequest getOrderXmlRequest(Order order) {
		XmlOrderRequest request = new XmlOrderRequest();
		XmlOrderRequestBody body = new XmlOrderRequestBody();
		OrderInfo orderInfo = new OrderInfo();
		JkfOrderImportHead jkfOrderImportHead = new JkfOrderImportHead();
		jkfOrderImportHead.setCompanyName(configService.getCompanyName());
		jkfOrderImportHead.setCompanyCode(configService.getCompanyCode());
		jkfOrderImportHead.setIeFlag("I");
		jkfOrderImportHead.setPayType(order.getDeclarePayType());	//cc_kata_kplus_order.declare_pay_type
		jkfOrderImportHead.setPayCompanyCode(order.getPayCompanyCode());		//cc_kata_kplus_order.pay_company_code
		jkfOrderImportHead.setPayNumber(order.getPayNumber());	//cc_kata_kplus_order.pay_number
		jkfOrderImportHead.setOrderTotalAmount(order.getAmount());
		jkfOrderImportHead.setOrderNo(order.getCode());
		jkfOrderImportHead.setOrderTaxAmount(order.getOrderTaxAmount());	//cc_kata_kplus_order.order_tax_amount
		jkfOrderImportHead.setOrderGoodsAmount(order.getAmount());	//订单货款
		jkfOrderImportHead.setFeeAmount(order.getTransPrice());
		jkfOrderImportHead.seteCommerceCode(configService.getDeclareRecordNo());
		jkfOrderImportHead.seteCommerceName(configService.getDeclareRecordName());
		jkfOrderImportHead.setTradeTime(DateUtil.format(order.getOrdertime()));
		jkfOrderImportHead.setCurrCode(configService.getDeclareCurrency());
		jkfOrderImportHead.setTotalAmount(order.getAmount() + order.getTransPrice() + order.getOrderTaxAmount()); // 成交总价 = 支付价格（订单价格）+ 运费 + 税款
		jkfOrderImportHead.setConsigneeEmail(order.getOrderTransportObject().getConsigneeEmail());	//cc_kata_kplus_order_transport.consignee_email
		jkfOrderImportHead.setConsigneeTel(order.getOrderTransportObject().getPhonenumber());
		jkfOrderImportHead.setConsignee(order.getOrderTransportObject().getCongsignee());
		jkfOrderImportHead.setConsigneeAddress(StringUtils.defaultIfEmpty(
				order.getOrderTransportObject().getAddress1(), order.getOrderTransportObject().getAddress2()));
		jkfOrderImportHead.setTotalCount(order.getTotalGoodsCount());
		jkfOrderImportHead.setPostMode(order.getTransportationType().toString());	//cc_kata_kplus_order transportaion_type
		Country country = countryManager.getById(order.getOrderTransportObject().getAddressorCountry());
		if(country == null) {
			throw new DataAssembleException("order.orderTransportObject.addressorCountry may not be null");
		}
		if(StringUtils.isBlank(country.getCountryCode())) {
			throw new DataAssembleException("order.orderTransportObject.addressorCountry.countryCode may not be null");
		}
		jkfOrderImportHead.setSalerCountry(country.getCountryCode());		//order_transport.addressorCountry
		jkfOrderImportHead.setAddressorName(order.getOrderTransportObject().getAddressorName());	//order_transport.addressorName
		jkfOrderImportHead.setPurchaserId(order.getMemberObject().getId().toString());
		jkfOrderImportHead.setLogisCompanyName(order.getTransportationcompanyObject().getName());	//cc_kata_kplus_transportationcompany.name
		jkfOrderImportHead.setLogisCompanyCode(order.getTransportationcompanyObject().getCode());	//cc_kata_kplus_transportationcompany.code
		jkfOrderImportHead.setZipCode(order.getTransportationcompanyObject().getZipCode());	//??? cc_kata_kplus_transportationcompany.zip_code 
		orderInfo.setJkfOrderImportHead(jkfOrderImportHead);
		
		List<JkfOrderDetail> jkfOrderDetailList = new ArrayList<JkfOrderDetail>();
		List<TransportCommodity> transportCommoditiyList = order.getOrderTransportObject().getTransportCommodityList();
		for(int i=0; i<transportCommoditiyList.size(); i++) {
			TransportCommodity tc = transportCommoditiyList.get(i);
			Commsku commsku = tc.getCommskuObject();
			JkfOrderDetail jkfOrderDetail = new JkfOrderDetail();
			jkfOrderDetail.setGoodsOrder(i);
			jkfOrderDetail.setGoodsName(commsku.getName());
			jkfOrderDetail.setGoodsNo(commsku.getCommodityObject().getCategoryObject().getTariff());	//cc_kata_kplus_category.tariff
			jkfOrderDetail.setGoodsModel(commsku.getCommodityObject().getItemcode());
			Country country2 = countryManager.getById(commsku.getCommodityObject().getSalesCountry());
			if(country2 == null) {
				throw new DataAssembleException("order.orderTransportObject.transportCommodityList[i] may not be null");
			}
			if(StringUtils.isBlank(country2.getCountryCode())) {
				throw new DataAssembleException("order.orderTransportObject.transportCommodityList[i].countryCode may not be null");
			}
			jkfOrderDetail.setCountryCode(country2.getCountryCode());	//cc_kata_kplus_commodity.sales_country
			jkfOrderDetail.setUnitPrice(tc.getPrice());
			jkfOrderDetail.setGoodsCount(tc.getDelivernum().doubleValue());
			jkfOrderDetail.setGoodsUnit(commsku.getCommodityObject().getUnitObject().getCode());	//cc_kata_kplus_unit.code
			jkfOrderDetail.setWeight(commsku.getCommodityObject().getWeight().doubleValue());
			jkfOrderDetailList.add(jkfOrderDetail);
		}
		orderInfo.setJkfOrderDetailList(jkfOrderDetailList);
		
		JkfGoodsPurchaser jkfGoodsPurchaser = new JkfGoodsPurchaser();
		jkfGoodsPurchaser.setId(order.getMember().toString());
		jkfGoodsPurchaser.setName(order.getMemberObject().getTruename());
		jkfGoodsPurchaser.setEmail(order.getMemberObject().getEmail());
		jkfGoodsPurchaser.setTelNumber(order.getMemberObject().getPhonenumber());
		jkfGoodsPurchaser.setPaperType(order.getMemberObject().getCertificatesType());	//kata_kplus_member.certificates_type
		jkfGoodsPurchaser.setPaperNumber(order.getMemberObject().getCertificates());	//kata_kplus_member.certificates
		jkfGoodsPurchaser.setAddress(order.getMemberObject().getAddress());
		orderInfo.setJkfGoodsPurchaser(jkfGoodsPurchaser);
		body.setOrderInfoList(Arrays.asList(orderInfo));
		
		JkfSign jkfSign = new JkfSign();
		jkfSign.setBusinessType(configService.getDeclareBusinessType());
		jkfSign.setCompanyCode(configService.getCompanyCode());
		jkfSign.setDeclareType(configService.getDeclareType());
		jkfSign.setBusinessNo(generateSequence());
		orderInfo.setJkfSign(jkfSign);
		CommonXmlRequestHead head = new CommonXmlRequestHead(); 
		head.setBusinessType(CommonXmlRequestHead.IMPORTORDER);
		request.setHead(head);
		request.setBody(body);
		return request;
	}
	
	/**
	 * 获取物流报关报文
	 * @param order
	 * @deprecated 物流数据由ems申报 不需要我们报关
	 * @return
	 */
	public XmlLogisticsRequest getLogisticsXmlRequest(Order order) {
		XmlLogisticsRequest request = new XmlLogisticsRequest();
		XmlLogisticsRequestBody body = new XmlLogisticsRequestBody();
		Logistics logistics = new Logistics();
		JkfLogisticsInfo jkfLogisticsInfo = new JkfLogisticsInfo();
		jkfLogisticsInfo.setLogisticsCompanyNo(order.getTransportationcompanyObject().getCode());
		jkfLogisticsInfo.setLogisticsCompanyName(order.getTransportationcompanyObject().getName());
		jkfLogisticsInfo.setLogisticsWaybillNo(order.getOrderTransportObject().getWaybillnumber());
		jkfLogisticsInfo.setLogisticsTraceState(order.getLogisticsState());	// cc_kata_kplus_order.logistics_state
		jkfLogisticsInfo.setWeight(order.getTotalGoodsWeight());
		jkfLogisticsInfo.setPieceNumber(order.getTotalGoodsCount());
		jkfLogisticsInfo.setHandleTimeStr(order.getOrdertime());
		jkfLogisticsInfo.setStationCode(order.getStationCode());//cc_kata_kplus_order.station_code
		jkfLogisticsInfo.setLicensePlateNumber(order.getLicensePlateNumber()); //cc_kata_kplus_order.license_plate_number
		logistics.setJkfLogisticsInfo(jkfLogisticsInfo);
		
		JkfSign jkfSign = new JkfSign();
		jkfSign.setBusinessType(configService.getDeclareBusinessType());
		jkfSign.setCompanyCode(configService.getCompanyCode());
		jkfSign.setDeclareType(configService.getDeclareType());
		jkfSign.setBusinessNo(generateSequence());
		jkfSign.setNote("物流数据报关备注");
		
		logistics.setJkfSign(jkfSign);
		body.setLogisticsList(Arrays.asList(logistics));
		
		CommonXmlRequestHead head = new CommonXmlRequestHead();
		head.setBusinessType(CommonXmlRequestHead.LOGISTICS_INFO);
		request.setHead(head);
		request.setBody(body);
		return request;
	}
	
	private final static long BASE_ID = 10000000000000L;
	
	/**
	 * 获取个人物品报关报文
	 * @param order
	 * @return
	 */
	public XmlGoodsDeclarRequest getGoodsXmlRequest(Order order) {
		XmlGoodsDeclarRequest request = new XmlGoodsDeclarRequest();
		XmlGoodsDeclarRequestBody body = new XmlGoodsDeclarRequestBody();
		GoodsDeclarModule goodsDeclarModule = new GoodsDeclarModule();
		
		GoodsDeclar goodsDeclar = new GoodsDeclar();
		goodsDeclarModule.setGoodsDeclar(goodsDeclar);
		goodsDeclar.setAccountBookNo(configService.getDeclareAccountBookNo());	//账册编号 由仓储企业提供
		goodsDeclar.setInOutFlag("I");
		goodsDeclar.setPreEntryNumber(configService.getDeclareRecordNo().substring(configService.getDeclareRecordNo().length() - 4) + (BASE_ID + order.getId() + System.currentTimeMillis()));	// 4位电商编码只要填后四位就行了
		goodsDeclar.setImportType(configService.getDeclareType());
		goodsDeclar.setInOutDateStr(order.getOrdertime());
		goodsDeclar.setInOutPortNumber(configService.getDeclareInOutPortNumber());
		goodsDeclar.setArrivedPort(configService.getDeclareArrivedPort());
		goodsDeclar.setTransportTool(order.getTransportationObject().getName());
		goodsDeclar.setTransportToolFltNo(order.getTransportationObject().getToolFltNo());	//cc_kata_kplus_transportation.tool_flt_no
		goodsDeclar.setTransportTypeCode(order.getTransportationObject().getTypeCode());	//cc_kata_kplus_transportation.type_code
		goodsDeclar.setDeclareCompanyType(configService.getDeclareCompanyType());
		goodsDeclar.setDeclareCompanyCode(configService.getDeclareCompanyCode());
		goodsDeclar.setDeclareCompanyName(configService.getDeclareCompanyName());
		goodsDeclar.setEeBusinessCompanyCode(configService.getDeclareRecordNo());
		goodsDeclar.setEeBusinessCompanyName(configService.getDeclareRecordName());
		goodsDeclar.setOrderNumber(order.getCode());
		goodsDeclar.setSubCarriageNo(order.getOrderTransportObject().getWaybillnumber());	//分运单号与总运单号填一样的数据
		Country fromCountry = countryManager.getById(order.getTransportationObject().getFromCountry());
		if(fromCountry == null) {
			throw new DataAssembleException("order.transportationObject.fromCountry may not be null");
		}
		if(StringUtils.isBlank(fromCountry.getCountryCode())) {
			throw new DataAssembleException("order.transportationObject.fromCountry.countryCode may not be null");
		}
		goodsDeclar.setFromCountry(fromCountry.getCountryCode());	//cc_kata_kplus_transportation.from_country
		goodsDeclar.setPieceNumber(order.getTotalGoodsCount());
		goodsDeclar.setRoughWeight(order.getTotalGoodsWeight());
		goodsDeclar.setNetWeight(order.getTotalGoodsWeight());
		goodsDeclar.setPackType(order.getTransportationObject().getPackType());	//cc_kata_kplus_transportation.pack_type
		goodsDeclar.setRemark("");
		goodsDeclar.setDeclarePortCode(configService.getDeclareInOutPortNumber());
		goodsDeclar.setEnteringPerson("9999");
		goodsDeclar.setEnteringCompanyName("9999");
		goodsDeclar.setDeclarantCode("");
		goodsDeclar.setGoodsYardCode(configService.getDeclareGoodsYardCode());
		goodsDeclar.setSender(order.getOrderTransportObject().getAddressorName());	// cc_kata_kplus_order_transport.addressor_name
		goodsDeclar.setReceiver(order.getOrderTransportObject().getCongsignee());
		Country senderCountry = countryManager.getById(order.getOrderTransportObject().getAddressorCountry());
		if(senderCountry == null) {
			throw new DataAssembleException("order.orderTransportObject.addressorCountry may not be null");
		}
		if(StringUtils.isBlank(senderCountry.getCountryCode())) {
			throw new DataAssembleException("order.orderTransportObject.addressorCountry.countryCode may not be null");
		}
		goodsDeclar.setSenderCountry(senderCountry.getCountryCode());  //cc_kata_kplus_order_transport.addressor_country
		goodsDeclar.setSenderCity(order.getOrderTransportObject().getAddressorCity());	//cc_kata_kplus_order_transport.addressor_city
		goodsDeclar.setReceiverPapersType(order.getMemberObject().getCertificatesType().substring(1));	//???kata_kplus_member.certificates_type
		goodsDeclar.setReceiverPapersNo(order.getMemberObject().getCertificates());	//???kata_kplus_member.certificates
		//worth见302
		goodsDeclar.setCurrency(configService.getDeclareCurrency());
		
		List<TransportCommodity> transportCommoditiyList = order.getOrderTransportObject().getTransportCommodityList();
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<transportCommoditiyList.size() && i<=3; i++) {
			TransportCommodity tc = transportCommoditiyList.get(i);
			Commsku commsku = tc.getCommskuObject();
			sb.append(commsku.getName()).append("，");
		}
		if(sb.length() > 0) 
			sb.deleteCharAt(sb.length() - 1);
		goodsDeclar.setMajorGoodsName(sb.toString());
		goodsDeclar.setInternalAreaCompanyName(configService.getDeclareInternalAreaCompanyName());
		goodsDeclar.setInternalAreaCompanyNo(configService.getDeclareInternalAreaCompanyNo());
		goodsDeclar.setApplicationFormNo(order.getTransportationObject().getApplicationFormNo());	//cc_kata_kplus_transportation.application_form_no
		goodsDeclar.setIsAuthorize((byte)0);
		Double worth = 0.0;
		List<GoodsDeclarDetail> goodsDeclarDetails = new ArrayList<GoodsDeclarDetail>();
		goodsDeclarModule.setGoodsDeclarDetails(goodsDeclarDetails);
		for(int i=0; i<transportCommoditiyList.size() && i<=3; i++) {
			TransportCommodity tc = transportCommoditiyList.get(i);
			Commsku commsku = tc.getCommskuObject();
			GoodsDeclarDetail cdd = new GoodsDeclarDetail();
			cdd.setGoodsOrder(i);
			cdd.setMailTaxNo(commsku.getCommodityObject().getCategoryObject().getTariff());	//cc_kata_kplus_category.tariff
			cdd.setGoodsItemNo(tc.getGoodsItemNo()); // 由仓储提供 cc_kata_kplus_transport_commodity.goods_item_no   保税区 出物品   
			cdd.setGoodsName(commsku.getName());
			cdd.setGoodsSpecification(commsku.getProperties());	//cc_kata_kplus_commodity.properties
			Country country = countryManager.getById(commsku.getCommodityObject().getSalesCountry());
			if(country == null) {
				throw new DataAssembleException("order.orderTransportObject.transportCommodityList(i).commsku.commodityObject.salesCountry may not be null");
			}
			if(StringUtils.isBlank(country.getCountryCode())) {
				throw new DataAssembleException("order.orderTransportObject.transportCommodityList(i).commsku.commodityObject.countryCode may not be null");
			}
			cdd.setProductionMarketingCountry(country.getCountryCode());	//cc_kata_kplus_commodity.sales_country
			cdd.setBargainCurrency(configService.getDeclareCurrency());
			cdd.setBargainTotalPrices(tc.getPrice() * tc.getDelivernum());
			cdd.setDeclarePrice(tc.getPrice());
			cdd.setDeclareTotalPrices(tc.getPrice() * tc.getDelivernum());
			worth += cdd.getDeclareTotalPrices();
			cdd.setPurpose("");
			cdd.setDeclareCount(tc.getDelivernum());
			cdd.setDeclareMeasureUnit(commsku.getCommodityObject().getUnitObject().getCode());	//cc_kata_kplus_unit.code
			cdd.setGoodsRoughWeight(commsku.getCommodityObject().getWeight());
			cdd.setFirstUnit(commsku.getCommodityObject().getUnitObject().getCode());	//cc_kata_kplus_unit.code
			cdd.setFirstCount(tc.getDelivernum());
			
			cdd.setSecondUnit(commsku.getCommodityObject().getUnitObject().getCode());	// 第一单位与第二单位一样???
			cdd.setSecondCount(tc.getDelivernum());			//同上 ???
			goodsDeclarDetails.add(cdd);
		}
		goodsDeclar.setWorth(worth);
		
		body.setGoodsDeclarModuleList(Arrays.asList(goodsDeclarModule));
		JkfSign jkfSign = new JkfSign();
		jkfSign.setBusinessType(configService.getDeclareBusinessType());
		jkfSign.setCompanyCode(configService.getCompanyCode());
		jkfSign.setDeclareType(configService.getDeclareType());
		jkfSign.setBusinessNo(generateSequence());
		jkfSign.setNote("个人物品报关");
		goodsDeclarModule.setJkfSign(jkfSign);
		
		CommonXmlRequestHead head = new CommonXmlRequestHead();
		head.setBusinessType(CommonXmlRequestHead.PERSONAL_GOODS_DECLAR);
		request.setHead(head);
		request.setBody(body);
		return request;
	}
	
	/**
	 * 获取运单报关报文
	 * @param order
	 * @return
	 */
	public XmlWaybillRequest getWaybillXmlRequest(Order order) {
		XmlWaybillRequest request = new XmlWaybillRequest();
		XmlWaybillRequestBody body = new XmlWaybillRequestBody();
		
		WayBill wayBill = new WayBill();
		
		WayBillImportDto dto = new WayBillImportDto();
		wayBill.setWayBillImportDto(dto);
		dto.setWayBillNo(order.getOrderTransportObject().getWaybillnumber());
		dto.setTotalWayBill(order.getOrderTransportObject().getWaybillnumber());
		dto.setPackageNo(order.getTotalGoodsCount());
		dto.setWeight(order.getTotalGoodsWeight());
		dto.setNetWeight(order.getTotalGoodsWeight());
		List<TransportCommodity> transportCommoditiyList = order.getOrderTransportObject().getTransportCommodityList();
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<transportCommoditiyList.size() && i<=3; i++) {
			TransportCommodity tc = transportCommoditiyList.get(i);
			Commsku commsku = tc.getCommskuObject();
			sb.append(commsku.getName()).append("，");
		}
		if(sb.length() > 0) 
			sb.deleteCharAt(sb.length() - 1);
		dto.setGoodsName(sb.toString());
		Country addressorCountry = countryManager.getById(order.getOrderTransportObject().getAddressorCountry());
		if(addressorCountry == null) {
			throw new DataAssembleException("order.orderTransportObject.addressorCountry.salesCountry may not be null");
		}
		if(StringUtils.isBlank(addressorCountry.getCountryCode())) {
			throw new DataAssembleException("order.orderTransportObject.addressorCountry.salesCountry.countryCode may not be null");
		}
		dto.setSendArea(addressorCountry.getName() + order.getOrderTransportObject().getAddressorCity());	//cc_kata_kplus_order_transport.addressor_country + addressor_city
		dto.setConsigneeArea(order.getOrderTransportObject().getAddressorCity());
		dto.setConsigneeAddress(StringUtils.defaultIfEmpty(
				order.getOrderTransportObject().getAddress1(), order.getOrderTransportObject().getAddress2()));
		dto.setConsignee(order.getOrderTransportObject().getCongsignee());
		dto.setConsigneeTel(order.getOrderTransportObject().getPhonenumber());
		dto.setZipCode(order.getOrderTransportObject().getZipCode());	//cc_kata_kplus_order_transport.zip_code
		dto.setCustomsCode(configService.getDeclareCustomsCode());
		dto.setWorth(order.getTotalamout());
		dto.setImportDateString(order.getOrdertime());
		dto.setCurrCode(configService.getDeclareCurrency());
		
		JkfSign jkfSign = new JkfSign();
		jkfSign.setBusinessType(configService.getDeclareBusinessType());
		jkfSign.setCompanyCode(configService.getCompanyCode());
		jkfSign.setDeclareType(configService.getDeclareType());
		jkfSign.setBusinessNo(generateSequence());
		wayBill.setJkfSign(jkfSign);
		body.setWayBillList(Arrays.asList(wayBill));
		
		CommonXmlRequestHead head = new CommonXmlRequestHead();
		head.setBusinessType(CommonXmlRequestHead.IMPORTBILL);
		request.setHead(head);
		request.setBody(body);
		return request;
	}
}
