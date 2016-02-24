package com.openteach.qsync.service.declare;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

import javax.annotation.PostConstruct;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openteach.qsync.api.CommonXmlRequestHead;
import com.openteach.qsync.api.JkfSign;
import com.openteach.qsync.api.goods.request.GoodsDeclare;
import com.openteach.qsync.api.goods.request.GoodsDeclareDetail;
import com.openteach.qsync.api.goods.request.GoodsDeclareModule;
import com.openteach.qsync.api.goods.request.XmlGoodsDeclarRequest;
import com.openteach.qsync.api.goods.request.XmlGoodsDeclareRequestBody;
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
import com.openteach.qsync.core.entity.info.City;
import com.openteach.qsync.core.entity.info.Country;
import com.openteach.qsync.core.entity.info.Province;
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
	
	private Validator validator;
	private ResourceBundle bundle;
	
	@PostConstruct
	public void init() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
		bundle = ResourceBundle.getBundle("messages");
	}
	
	public void mappingOrder(Order order) {
		orderService.mappingOrder(order);
		Set<ConstraintViolation<Order>> violations = validator.validate(order);
		StringBuffer buf = new StringBuffer();
		for (ConstraintViolation<Order> violation : violations) {
			if(buf.length() == 0) {
				buf.append("\n");
			}
			buf.append(violation.getPropertyPath()).append(" ")
				.append(violation.getMessage()).append(" 不能为空").append("\n");
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
		jkfOrderImportHead.setOrderTotalAmount(order.getCommskuAmount() + order.getTransPrice() + order.getOrderTaxAmount());		//订单总金额就是货款+运费+税款
		jkfOrderImportHead.setOrderNo(order.getCode());
		jkfOrderImportHead.setOrderTaxAmount(order.getOrderTaxAmount());	//cc_kata_kplus_order.order_tax_amount
		jkfOrderImportHead.setOrderGoodsAmount(order.getCommskuAmount());	//订单货款
		jkfOrderImportHead.setFeeAmount(order.getTransPrice());
		jkfOrderImportHead.seteCommerceCode(configService.getDeclareRecordNo());
		jkfOrderImportHead.seteCommerceName(configService.getDeclareRecordName());
		jkfOrderImportHead.setTradeTime(DateUtil.format(order.getOrdertime()));
		jkfOrderImportHead.setCurrCode(configService.getDeclareCurrency());
		jkfOrderImportHead.setTotalAmount(order.getCommskuAmount()); // 成交总价 = 支付价格（订单价格）+ 运费 + 税款
		jkfOrderImportHead.setConsigneeEmail(StringUtils.defaultIfEmpty(order.getOrderTransportObject().getConsigneeEmail(), order.getMemberObject().getEmail()));	//cc_kata_kplus_order_transport.consignee_email
		jkfOrderImportHead.setConsigneeTel(StringUtils.defaultIfEmpty(order.getOrderTransportObject().getPhonenumber(), order.getOrderTransportObject().getHandphone()));
		jkfOrderImportHead.setConsignee(order.getOrderTransportObject().getCongsignee());
		jkfOrderImportHead.setConsigneeAddress(order.getOrderTransportObject().getPlace());
//		jkfOrderImportHead.setTotalCount(order.getTotalGoodsCount());
		jkfOrderImportHead.setTotalCount(1);
		jkfOrderImportHead.setPostMode(order.getTransportationType().toString());	//cc_kata_kplus_order transportaion_type
		Country country = countryManager.getById(order.getOrderTransportObject().getAddressorCountry());
		if(country == null) {
			throw new DataAssembleException("order.orderTransportObject.addressorCountry 外键无对应的country");
		}
		if(StringUtils.isBlank(country.getCountryCode())) {
			throw new DataAssembleException("order.orderTransportObject.addressorCountry.countryCode 国别码不能为空");
		}
		jkfOrderImportHead.setSenderCountry(country.getCountryCode());		//order_transport.addressorCountry
		jkfOrderImportHead.setSenderName(order.getOrderTransportObject().getAddressorName());	//order_transport.addressorName
		jkfOrderImportHead.setPurchaserId(order.getMemberObject().getId().toString());
		jkfOrderImportHead.setLogisCompanyName(order.getOrderTransportObject().getLogistics());	//order_transport.logistics
		jkfOrderImportHead.setLogisCompanyCode(order.getOrderTransportObject().getWaybillCode());	//cc_kata_kplus_transportationcompany.waybillcode
		jkfOrderImportHead.setZipCode(order.getOrderTransportObject().getWaybillZipCode());	//??? cc_kata_kplus_transportationcompany.waybill_zip_code
		jkfOrderImportHead.setUserProcotol(configService.getUserProtocal());
		orderInfo.setJkfOrderImportHead(jkfOrderImportHead);
		
		List<JkfOrderDetail> jkfOrderDetailList = new ArrayList<JkfOrderDetail>();
		List<TransportCommodity> transportCommoditiyList = order.getOrderTransportObject().getTransportCommodityList();
		for(int i=0; i<transportCommoditiyList.size(); i++) {
			TransportCommodity tc = transportCommoditiyList.get(i);
			Commsku commsku = tc.getCommskuObject();
			JkfOrderDetail jkfOrderDetail = new JkfOrderDetail();
			jkfOrderDetail.setGoodsOrder(i + 1);
			//jkfOrderDetail.setItemNo("");				//TODO: 新增 项号 2015.11.12
			jkfOrderDetail.setSourceNo(commsku.getSkucode());				//TODO: 新增 料号 2015.11.12
			jkfOrderDetail.setGoodsName(commsku.getName());
			jkfOrderDetail.setCodeTs(commsku.getCommodityObject().getCategoryObject().getTariff());	//cc_kata_kplus_category.tariff
			jkfOrderDetail.setGoodsModel(commsku.getProperties());
			Country country2 = countryManager.getById(commsku.getCommodityObject().getSalesCountry());
			if(country2 == null) {
				throw new DataAssembleException("order.orderTransportObject.transportCommodityList[" + i + "].commskuObject.CommodityObject.SalesCountry 产销国 不能为空");
			}
			if(StringUtils.isBlank(country2.getCountryCode())) {
				throw new DataAssembleException("order.orderTransportObject.transportCommodityList[" + i + "]commskuObject.CommodityObject.SalesCountry 产销国别代码 不能为空");
			}
			jkfOrderDetail.setOriginCountry(country2.getCountryCode());	//cc_kata_kplus_commodity.sales_country
			jkfOrderDetail.setUnitPrice(tc.getPrice());
			jkfOrderDetail.setGoodsCount(tc.getDelivernum().doubleValue());
			jkfOrderDetail.setGoodsUnit(commsku.getCommodityObject().getUnitObject().getCode());	//cc_kata_kplus_unit.code
			jkfOrderDetail.setGrossWeight(commsku.getCommodityObject().getWeight());
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
//		jkfGoodsPurchaser.setAddress(order.getMemberObject().getAddress());
		jkfGoodsPurchaser.setAddress(order.getOrderTransportObject().getPlace());	//购买人地址也改成收货地址
		orderInfo.setJkfGoodsPurchaser(jkfGoodsPurchaser);
		body.setOrderInfoList(Arrays.asList(orderInfo));
		
		JkfSign jkfSign = new JkfSign();
//		jkfSign.setBusinessType(configService.getDeclareBusinessType());
		jkfSign.setBusinessType(CommonXmlRequestHead.IMPORTORDER);
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
//		jkfLogisticsInfo.setLogisticsCompanyNo();
		jkfLogisticsInfo.setLogisticsCompanyName(order.getOrderTransportObject().getLogistics());
		jkfLogisticsInfo.setLogisticsWaybillNo(order.getOrderTransportObject().getWaybillnumber());
		jkfLogisticsInfo.setLogisticsTraceState(order.getLogisticsState());	// cc_kata_kplus_order.logistics_state
		jkfLogisticsInfo.setWeight(order.getShippingWeight());
		jkfLogisticsInfo.setPieceNumber(order.getTotalGoodsCount());
//		jkfLogisticsInfo.setPieceNumber(1);
		jkfLogisticsInfo.setHandleTimeStr(order.getOrdertime());
		jkfLogisticsInfo.setStationCode(order.getStationCode());//cc_kata_kplus_order.station_code
		jkfLogisticsInfo.setLicensePlateNumber(order.getLicensePlateNumber()); //cc_kata_kplus_order.license_plate_number
		logistics.setJkfLogisticsInfo(jkfLogisticsInfo);
		
		JkfSign jkfSign = new JkfSign();
//		jkfSign.setBusinessType(configService.getDeclareBusinessType());
		jkfSign.setBusinessType(CommonXmlRequestHead.LOGISTICS_INFO);
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
	
	private String generatePreEntryNO(Order order) {
		return configService.getDeclareRecordNo().substring(configService.getDeclareRecordNo().length() - 4) + (BASE_ID + order.getId());
	}
	
	/**
	 * 获取个人物品报关报文
	 * @param order
	 * @return
	 */
	public XmlGoodsDeclarRequest getGoodsXmlRequest(Order order) {
		XmlGoodsDeclarRequest request = new XmlGoodsDeclarRequest();
		XmlGoodsDeclareRequestBody body = new XmlGoodsDeclareRequestBody();
		GoodsDeclareModule goodsDeclarModule = new GoodsDeclareModule();
		
		GoodsDeclare goodsDeclar = new GoodsDeclare();
		goodsDeclarModule.setGoodsDeclare(goodsDeclar);
		goodsDeclar.setAccountBookNo(order.getType().intValue() == 1 ? configService.getDeclareAccountBookNo() : "");	//账册编号 由仓储企业提供 直邮模式不填写账册编号
		goodsDeclar.setIeFlag("I");
		goodsDeclar.setPreEntryNumber(generatePreEntryNO(order));	// 4位电商编码只要填后四位就行了
		goodsDeclar.setImportType(order.getType().intValue() == 1 ? "1" : "0");	// 1 保税区（1） 2直邮（0）
		goodsDeclar.setInOutDateStr(new Date());
		goodsDeclar.setIePort(configService.getDeclareInOutPortNumber());
		goodsDeclar.setDestinationPort(configService.getDeclareArrivedPort());
		goodsDeclar.setTrafName(order.getOrderTransportObject().getToolFltName());
		goodsDeclar.setVoyageNo(order.getOrderTransportObject().getToolFltNo());	//cc_kata_kplus_order_transport.tool_flt_no
		goodsDeclar.setTrafMode(order.getOrderTransportObject().getTypeCode());	//cc_kata_kplus_order_transport.type_code
		goodsDeclar.setDeclareCompanyType(configService.getDeclareCompanyType());
		
		// 直邮与保税 企业编码进行区分 2015.4.22
		goodsDeclar.setDeclareCompanyCode(order.getType().intValue() == 1 ? 
				configService.getDeclareCompanyCode() : configService.getDeclareDirectCompanyCode());
		
		goodsDeclar.setDeclareCompanyName(configService.getDeclareCompanyName());
		goodsDeclar.seteCommerceCode(configService.getDeclareRecordNo());
		goodsDeclar.seteCommerceName(configService.getDeclareRecordName());
		goodsDeclar.setOrderNo(order.getCode());
		goodsDeclar.setWayBill(order.getOrderTransportObject().getWaybillnumber());	//分运单号与总运单号填一样的数据
		
//		goodsDeclar.setFromCountry(order.getOrderTransportObject().getFromCountry());	//cc_kata_kplus_order_transport.from_country
//		goodsDeclar.setPieceNumber(order.getTotalGoodsCount());		//件数用永远固定成1
		goodsDeclar.setPackNo(1);
		goodsDeclar.setGrossWeight(order.getShippingWeight());
		goodsDeclar.setNetWeight(order.getGrossWeight());
		goodsDeclar.setWarpType(order.getOrderTransportObject().getPackType().toString());	//cc_kata_kplus_transportation.pack_type
		goodsDeclar.setRemark("");
		goodsDeclar.setDeclPort(configService.getDeclareInOutPortNumber());
		goodsDeclar.setEnteringPerson("9999");
		goodsDeclar.setEnteringCompanyName("9999");
		goodsDeclar.setDeclarantNo("");
		goodsDeclar.setCustomsField(configService.getDeclareGoodsYardCode());
		goodsDeclar.setSenderName(order.getOrderTransportObject().getAddressorName());	// cc_kata_kplus_order_transport.addressor_name
		goodsDeclar.setConsignee(order.getOrderTransportObject().getCongsignee());
		Country senderCountry = countryManager.getById(order.getOrderTransportObject().getAddressorCountry());
		if(senderCountry == null) {
			throw new DataAssembleException("order.orderTransportObject.addressorCountry 发件人国别不能为空");
		}
		if(StringUtils.isBlank(senderCountry.getCountryCode())) {
			throw new DataAssembleException("order.orderTransportObject.addressorCountry.countryCode 发件人国别代码不能为空");
		}
		goodsDeclar.setSenderCountry(senderCountry.getCountryCode());  //cc_kata_kplus_order_transport.addressor_country
		goodsDeclar.setSenderCity(order.getOrderTransportObject().getAddressorCity());	//cc_kata_kplus_order_transport.addressor_city
		goodsDeclar.setPaperType(order.getMemberObject().getCertificatesType().substring(1));	//kata_kplus_member.certificates_type 
		goodsDeclar.setPaperNumber(order.getMemberObject().getCertificates());	//kata_kplus_member.certificates
		//worth见302
		goodsDeclar.setCurrCode(configService.getDeclareCurrency());
		
		List<TransportCommodity> transportCommoditiyList = order.getOrderTransportObject().getTransportCommodityList();
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<transportCommoditiyList.size() && i<=3; i++) {
			TransportCommodity tc = transportCommoditiyList.get(i);
			Commsku commsku = tc.getCommskuObject();
			sb.append(commsku.getName()).append("，");
		}
		if(sb.length() > 0) 
			sb.deleteCharAt(sb.length() - 1);
		goodsDeclar.setMainGName(sb.toString());
		goodsDeclar.setInternalAreaCompanyName(order.getType().intValue() == 1 ? configService.getDeclareInternalAreaCompanyName() : "");	// 区内企业name 直邮模式下为空
		goodsDeclar.setInternalAreaCompanyNo(order.getType().intValue() == 1 ? configService.getDeclareInternalAreaCompanyNo() : "");	//仓储企业名称  直邮模式下为空
		goodsDeclar.setApplicationFormNo(order.getType().intValue() == 1 ? order.getOrderTransportObject().getApplicationFormNo() : "");	//cc_kata_kplus_order_transport.application_form_no  分送集单申请编号  直邮模式下为空
		goodsDeclar.setIsAuthorize((byte)0);
		Double worth = 0.0;
		List<GoodsDeclareDetail> goodsDeclarDetails = new ArrayList<GoodsDeclareDetail>();
		goodsDeclarModule.setGoodsDeclareDetails(goodsDeclarDetails);
		for(int i=0; i<transportCommoditiyList.size(); i++) {
			TransportCommodity tc = transportCommoditiyList.get(i);
			Commsku commsku = tc.getCommskuObject();
			GoodsDeclareDetail cdd = new GoodsDeclareDetail();
			cdd.setGoodsOrder(i + 1);
			cdd.setCodeTs(commsku.getCommodityObject().getCategoryObject().getTariff());	//cc_kata_kplus_category.tariff
			cdd.setGoodsItemNo(commsku.getSkucode()); // 由仓储提供 cc_kata_kplus_transport_commodity.goods_item_no 商品货号 保税区 出物品  直邮模式下为空  
			cdd.setGoodsName(commsku.getName());
			cdd.setGoodsModel(commsku.getProperties());	//cc_kata_kplus_commodity.properties
			Country country = countryManager.getById(commsku.getCommodityObject().getSalesCountry());
			if(country == null) {
				throw new DataAssembleException("order.orderTransportObject.transportCommodityList(i).commsku.commodityObject.salesCountry 产销国不能为空");
			}
			if(StringUtils.isBlank(country.getCountryCode())) {
				throw new DataAssembleException("order.orderTransportObject.transportCommodityList(i).commsku.commodityObject.salesCountry.countryCode 产销国编码不能为空");
			}
			cdd.setOriginCountry(country.getCountryCode());	//cc_kata_kplus_commodity.sales_country
			goodsDeclar.setTradeCountry(country.getCountryCode());	//cc_kata_kplus_commodity.sales_country  269行 from_country 改成产销国
			cdd.setTradeCurr(configService.getDeclareCurrency());
			cdd.setTradeTotal(tc.getPrice() * tc.getDelivernum());
			cdd.setDeclPrice(tc.getPrice());
			cdd.setDeclTotalPrice(tc.getPrice() * tc.getDelivernum());
			worth += cdd.getDeclTotalPrice();
			cdd.setUseTo("");
			cdd.setDeclareCount(tc.getDelivernum());
			cdd.setGoodsUnit(commsku.getCommodityObject().getUnitObject().getCode());	//cc_kata_kplus_unit.code
			cdd.setGoodsGrossWeight(commsku.getCommodityObject().getWeight());
			cdd.setFirstUnit(commsku.getCommodityObject().getUnitObject().getCode());	//cc_kata_kplus_unit.code
			cdd.setFirstCount(tc.getDelivernum());
			
			cdd.setSecondUnit(commsku.getCommodityObject().getUnitObject().getCode());	// 第一单位与第二单位一样???
			cdd.setSecondCount(tc.getDelivernum());			//同上 ???
			cdd.setProductRecordNo("");						//TODO: 产品国检备案编号 新增 2015.11.12
			cdd.setWebSite("");								//TODO: 商品网址 新增 2015.11.12
			goodsDeclarDetails.add(cdd);
		}
		goodsDeclar.setWorth(worth);
		
		body.setGoodsDeclareModuleList(Arrays.asList(goodsDeclarModule));
		JkfSign jkfSign = new JkfSign();
//		jkfSign.setBusinessType(configService.getDeclareBusinessType());
		jkfSign.setBusinessType(CommonXmlRequestHead.PERSONAL_GOODS_DECLAR);
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
//		dto.setPackageNo(order.getTotalGoodsCount());
		dto.setPackageNo(1);
		dto.setWeight(order.getShippingWeight());
		dto.setNetWeight(order.getGrossWeight());
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
//		Country addressorCountry = countryManager.getById(order.getOrderTransportObject().getAddressorCountry());
//		if(addressorCountry == null) {
//			throw new DataAssembleException("order.orderTransportObject.addressorCountry.salesCountry may not be null");
//		}
//		if(StringUtils.isBlank(addressorCountry.getCountryCode())) {
//			throw new DataAssembleException("order.orderTransportObject.addressorCountry.salesCountry.countryCode may not be null");
//		}
		dto.setSendArea(order.getOrderTransportObject().getAddressorCity());	//cc_kata_kplus_order_transport.addressor_city
		String consigneeArea = "";
		Province province = order.getOrderTransportObject().getProvinceObject();
		City city = order.getOrderTransportObject().getCityObject();
		if(province != null) {
			consigneeArea = consigneeArea + province.getName();
		}
		if(city != null) {
			consigneeArea = consigneeArea + city.getName();
		}
		dto.setConsigneeArea(consigneeArea);
		dto.setConsignee(order.getOrderTransportObject().getCongsignee());
		dto.setConsigneeAddress(order.getOrderTransportObject().getPlace());
		dto.setConsigneeTel(StringUtils.defaultIfEmpty(order.getOrderTransportObject().getPhonenumber(), order.getOrderTransportObject().getHandphone()));
		dto.setZipCode(order.getOrderTransportObject().getZipCode());	//cc_kata_kplus_order_transport.zip_code
		dto.setCustomsCode(configService.getDeclareCustomsCode());
		dto.setWorth(order.getCommskuAmount());
		dto.setImportDateString(new Date());
		dto.setCurrCode(configService.getDeclareCurrency());
		
		JkfSign jkfSign = new JkfSign();
		jkfSign.setBusinessType(CommonXmlRequestHead.IMPORTBILL);
//		jkfSign.setBusinessType(configService.getDeclareBusinessType());
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

	public Order getOrder(Long id) {
		return orderService.getOrderById(id);
	}
}
