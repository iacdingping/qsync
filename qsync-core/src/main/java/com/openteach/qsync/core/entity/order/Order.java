package com.openteach.qsync.core.entity.order;

import javax.validation.constraints.NotNull;

import com.openteach.qsync.core.entity.info.Member;
import com.openteach.qsync.core.entity.logistics.Transportation;
import com.openteach.qsync.core.entity.logistics.Transportationcompany;



/**
 *
 * @author dingp email:dingp@51box.cn
 * @version 1.0
 * @since 1.0
 * */
public class Order {
	
	//alias
	public static final String TABLE_ALIAS = "Order";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_CODE = "code";
	public static final String ALIAS_APPRAISE = "appraise";
	public static final String ALIAS_CONTENT = "content";
	public static final String ALIAS_ORDERTIME = "ordertime";
	public static final String ALIAS_REMARK = "remark";
	public static final String ALIAS_GIFT = "gift";
	public static final String ALIAS_AMOUNT = "amount";
	public static final String ALIAS_CUTAMOUNT = "cutamount";
	public static final String ALIAS_INVOICETYPE = "invoicetype";
	public static final String ALIAS_INVOICECONTENT = "invoicecontent";
	public static final String ALIAS_ISCOUPON = "iscoupon";
	public static final String ALIAS_PAYTIME = "paytime";
	public static final String ALIAS_ONLINEPAY = "onlinepay";
	public static final String ALIAS_RETURN_STATUS = "returnStatus";
	public static final String ALIAS_PAY_STATUS = "payStatus";
	public static final String ALIAS_PAY_TYPE = "payType";
	public static final String ALIAS_TRANS_PRICE = "transPrice";
	public static final String ALIAS_IS_BIG_ORDER = "isBigOrder";
	public static final String ALIAS_IS_PACKAGE = "isPackage";
	public static final String ALIAS_STATUS = "status";
	public static final String ALIAS_SOURCE = "source";
	public static final String ALIAS_REPLACEMENT = "replacement";
	public static final String ALIAS_ISUSEREVALUATE = "isuserevaluate";
	public static final String ALIAS_ISSHOPEVALUATE = "isshopevaluate";
	public static final String ALIAS_MEMBER = "member";
	public static final String ALIAS_SHOP_ID = "shopId";
	public static final String ALIAS_CREATORADMIN = "creatoradmin";
	public static final String ALIAS_MODIFIERADMIN = "modifieradmin";
	public static final String ALIAS_CREATEDATETIME = "createdatetime";
	public static final String ALIAS_UPDATEDATETIME = "updatedatetime";
	public static final String ALIAS_ORDERTRANSPORT = "ordertransport";
	public static final String ALIAS_ISSTATEMENTED = "isstatemented";
	public static final String ALIAS_CCGROUP_ID = "ccgroupId";
	public static final String ALIAS_ORDERTYPE = "ordertype";
	public static final String ALIAS_AUTOCANCELTIME = "autocanceltime";
	public static final String ALIAS_CANCELSENTDTIME = "cancelsentdtime";
	public static final String ALIAS_YESNUMBER = "yesnumber";
	public static final String ALIAS_NONUMBER = "nonumber";
	public static final String ALIAS_COMMODITY_ID = "commodityId";
	public static final String ALIAS_SHOPCONTENT = "shopcontent";
	public static final String ALIAS_STARLEVEL = "starlevel";
	public static final String ALIAS_CANELTIME = "caneltime";
	public static final String ALIAS_SHOULDPAYMONEY = "shouldpaymoney";
	public static final String ALIAS_ISCANFINAL = "iscanfinal";
	public static final String ALIAS_PAYFREIGHTTIME = "payfreighttime";
	public static final String ALIAS_TOTALAMOUT = "totalamout";
	public static final String ALIAS_ISFREIGHT = "isfreight";
	public static final String ALIAS_PAYFREIGHT = "payfreight";
	public static final String ALIAS_TRANSPORTATION_ID = "transportationId";
	public static final String ALIAS_TRANSPORTATIONCOMPANY_ID = "transportationcompanyId";
	public static final String ALIAS_TRANSPORTNUMBER = "transportnumber";
	public static final String ALIAS_TRANSPORTREMARK = "transportremark";
	public static final String ALIAS_LOGISTICS_STATE = "物流跟踪状态 10 启运 20 抵港 30 到货 40 离开 50 签收";
	public static final String ALIAS_STATION_CODE = "场站代码";
	public static final String ALIAS_LICENSE_PLATE_NUMBER = "车牌号码";
	public static final String ALIAS_DECLARE_PAY_TYPE = "支付类型 01:银行卡支付 02:余额支付 03:其他";
	public static final String ALIAS_PAY_COMPANY_CODE = "支付公司编码";
	public static final String ALIAS_PAY_NUMBER = "支付单号";
	public static final String ALIAS_ORDER_TAX_AMOUNT = "订单税款";
	
	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START
    /**
     * id       db_column: id 
     */	
	private java.lang.Long id;
    /**
     * code       db_column: code 
     */	
	private java.lang.String code;
    /**
     * appraise       db_column: appraise 
     */	
	private java.lang.Integer appraise;
    /**
     * content       db_column: content 
     */	
	private java.lang.String content;
    /**
     * ordertime       db_column: ordertime 
     */	
	private java.util.Date ordertime;
    /**
     * remark       db_column: remark 
     */	
	private java.lang.String remark;
    /**
     * gift       db_column: gift 
     */	
	private java.lang.String gift;
    /**
     * amount       db_column: amount 
     */	
	private java.lang.Double amount;
    /**
     * cutamount       db_column: cutamount 
     */	
	private java.lang.Double cutamount;
    /**
     * invoicetype       db_column: invoicetype 
     */	
	private java.lang.Integer invoicetype;
    /**
     * invoicecontent       db_column: invoicecontent 
     */	
	private java.lang.String invoicecontent;
    /**
     * iscoupon       db_column: iscoupon 
     */	
	private java.lang.String iscoupon;
    /**
     * paytime       db_column: paytime 
     */	
	private java.util.Date paytime;
    /**
     * onlinepay       db_column: onlinepay 
     */	
	private java.lang.Integer onlinepay;
    /**
     * returnStatus       db_column: return_status 
     */	
	private java.lang.Integer returnStatus;
    /**
     * payStatus       db_column: pay_status 
     */	
	private java.lang.Integer payStatus;
    /**
     * payType       db_column: pay_type 
     */	
	private java.lang.Integer payType;
    /**
     * transPrice       db_column: trans_price 
     */	
	private java.lang.Double transPrice;
    /**
     * isBigOrder       db_column: is_big_order 
     */	
	private java.lang.String isBigOrder;
    /**
     * isPackage       db_column: is_package 
     */	
	private java.lang.String isPackage;
    /**
     * status       db_column: status 
     */	
	private java.lang.Integer status;
    /**
     * source       db_column: source 
     */	
	private java.lang.Integer source;
    /**
     * replacement       db_column: replacement 
     */	
	private java.lang.Integer replacement;
    /**
     * isuserevaluate       db_column: isuserevaluate 
     */	
	private java.lang.String isuserevaluate;
    /**
     * isshopevaluate       db_column: isshopevaluate 
     */	
	private java.lang.String isshopevaluate;
    /**
     * member       db_column: member 
     */	
	private java.lang.Long member;
	
	private Member memberObject;
    /**
     * shopId       db_column: shop_id 
     */	
	private java.lang.Long shopId;
    /**
     * creatoradmin       db_column: creatoradmin 
     */	
	private java.lang.Long creatoradmin;
    /**
     * modifieradmin       db_column: modifieradmin 
     */	
	private java.lang.Long modifieradmin;
    /**
     * createdatetime       db_column: createdatetime 
     */	
	private java.util.Date createdatetime;
    /**
     * updatedatetime       db_column: updatedatetime 
     */	
	private java.util.Date updatedatetime;
    /**
     * ordertransport       db_column: ordertransport 
     */	
	private java.lang.Long ordertransport;
	private OrderTransport orderTransportObject;
    /**
     * isstatemented       db_column: isstatemented 
     */	
	private java.lang.Integer isstatemented;
    /**
     * ccgroupId       db_column: ccgroup_id 
     */	
	private java.lang.Long ccgroupId;
    /**
     * ordertype       db_column: ordertype 
     */	
	private java.lang.Integer ordertype;
    /**
     * autocanceltime       db_column: autocanceltime 
     */	
	private java.util.Date autocanceltime;
    /**
     * cancelsentdtime       db_column: cancelsentdtime 
     */	
	private java.util.Date cancelsentdtime;
    /**
     * yesnumber       db_column: yesnumber 
     */	
	private java.lang.Integer yesnumber;
    /**
     * nonumber       db_column: nonumber 
     */	
	private java.lang.Integer nonumber;
    /**
     * commodityId       db_column: commodity_id 
     */	
	private java.lang.Long commodityId;
    /**
     * shopcontent       db_column: shopcontent 
     */	
	private java.lang.String shopcontent;
    /**
     * starlevel       db_column: starlevel 
     */	
	private java.lang.Integer starlevel;
    /**
     * caneltime       db_column: caneltime 
     */	
	private java.lang.String caneltime;
    /**
     * shouldpaymoney       db_column: shouldpaymoney 
     */	
	private java.lang.Double shouldpaymoney;
    /**
     * iscanfinal       db_column: iscanfinal 
     */	
	private java.lang.String iscanfinal;
    /**
     * payfreighttime       db_column: payfreighttime 
     */	
	private java.util.Date payfreighttime;
    /**
     * totalamout       db_column: totalamout 
     */	
	private java.lang.Double totalamout;
    /**
     * isfreight       db_column: isfreight 
     */	
	private java.lang.String isfreight;
    /**
     * payfreight       db_column: payfreight 
     */	
	private java.lang.String payfreight;
    /**
     * transportationId       db_column: transportation_id 
     */	
	private java.lang.Long transportationId;
	private Transportation transportationObject;
    /**
     * transportationcompanyId       db_column: transportationcompany_id 
     */	
	private java.lang.Long transportationcompanyId;
	
	private Transportationcompany transportationcompanyObject;
    /**
     * transportnumber       db_column: transportnumber 
     */	
	private java.lang.String transportnumber;
    /**
     * transportremark       db_column: transportremark 
     */	
	private java.lang.String transportremark;
	/**
     * 物流跟踪状态 10 启运 20 抵港 30 到货 40 离开 50 签收       db_column: logistics_state 
     */	
	private java.lang.Integer logisticsState;
    /**
     * 场站代码       db_column: station_code 
     */	
	private java.lang.String stationCode;
    /**
     * 车牌号码       db_column: license_plate_number 
     */	
	private java.lang.String licensePlateNumber;
    /**
     * 支付类型 01:银行卡支付 02:余额支付 03:其他       db_column: declare_pay_type 
     */	
	@NotNull(message = "支付类型不能为空")
	private java.lang.String declarePayType;
    /**
     * 支付公司编码       db_column: pay_company_code 
     */	
	@NotNull(message = "支付公司编码不能为空")
	private java.lang.String payCompanyCode;
    /**
     * 支付单号       db_column: pay_number 
     */	
	@NotNull(message = "支付单号不能为空")
	private java.lang.String payNumber;
    /**
     * 订单税款       db_column: order_tax_amount 
     */	
	@NotNull(message = "订单税款不能为空")
	private java.lang.Double orderTaxAmount;
	/**
	 * 报关状态 初始状态 00000 从左到右 
	 * 第一位 1 初始化 第二位订单报关状态 第三位  物流报关状态 第四位运单报关状态 第五位 个人物品报关状态   
	 * 报关状态 0 未开始 1 报关中 2 报关完成 3 报关失败
	 */
	private java.lang.String declareStatus;
	@NotNull(message = "运输类型不能为空")
	private Integer transportationType;
	//columns END
	private Integer totalGoodsCount;
	private Double totalGoodsWeight;
	
	public Order(){
	}

	public java.lang.Long getId() {
		return id;
	}

	public void setId(java.lang.Long id) {
		this.id = id;
	}

	public java.lang.String getCode() {
		return code;
	}

	public void setCode(java.lang.String code) {
		this.code = code;
	}

	public java.lang.Integer getAppraise() {
		return appraise;
	}

	public void setAppraise(java.lang.Integer appraise) {
		this.appraise = appraise;
	}

	public java.lang.String getContent() {
		return content;
	}

	public void setContent(java.lang.String content) {
		this.content = content;
	}

	public java.util.Date getOrdertime() {
		return ordertime;
	}

	public void setOrdertime(java.util.Date ordertime) {
		this.ordertime = ordertime;
	}

	public java.lang.String getRemark() {
		return remark;
	}

	public void setRemark(java.lang.String remark) {
		this.remark = remark;
	}

	public java.lang.String getGift() {
		return gift;
	}

	public void setGift(java.lang.String gift) {
		this.gift = gift;
	}

	public java.lang.Double getAmount() {
		return amount;
	}

	public void setAmount(java.lang.Double amount) {
		this.amount = amount;
	}

	public java.lang.Double getCutamount() {
		return cutamount;
	}

	public void setCutamount(java.lang.Double cutamount) {
		this.cutamount = cutamount;
	}

	public java.lang.Integer getInvoicetype() {
		return invoicetype;
	}

	public void setInvoicetype(java.lang.Integer invoicetype) {
		this.invoicetype = invoicetype;
	}

	public java.lang.String getInvoicecontent() {
		return invoicecontent;
	}

	public void setInvoicecontent(java.lang.String invoicecontent) {
		this.invoicecontent = invoicecontent;
	}

	public java.lang.String getIscoupon() {
		return iscoupon;
	}

	public void setIscoupon(java.lang.String iscoupon) {
		this.iscoupon = iscoupon;
	}

	public java.util.Date getPaytime() {
		return paytime;
	}

	public void setPaytime(java.util.Date paytime) {
		this.paytime = paytime;
	}

	public java.lang.Integer getOnlinepay() {
		return onlinepay;
	}

	public void setOnlinepay(java.lang.Integer onlinepay) {
		this.onlinepay = onlinepay;
	}

	public java.lang.Integer getReturnStatus() {
		return returnStatus;
	}

	public void setReturnStatus(java.lang.Integer returnStatus) {
		this.returnStatus = returnStatus;
	}

	public java.lang.Integer getPayStatus() {
		return payStatus;
	}

	public void setPayStatus(java.lang.Integer payStatus) {
		this.payStatus = payStatus;
	}

	public java.lang.Integer getPayType() {
		return payType;
	}

	public void setPayType(java.lang.Integer payType) {
		this.payType = payType;
	}

	public java.lang.Double getTransPrice() {
		return transPrice;
	}

	public void setTransPrice(java.lang.Double transPrice) {
		this.transPrice = transPrice;
	}

	public java.lang.String getIsBigOrder() {
		return isBigOrder;
	}

	public void setIsBigOrder(java.lang.String isBigOrder) {
		this.isBigOrder = isBigOrder;
	}

	public java.lang.String getIsPackage() {
		return isPackage;
	}

	public void setIsPackage(java.lang.String isPackage) {
		this.isPackage = isPackage;
	}

	public java.lang.Integer getStatus() {
		return status;
	}

	public void setStatus(java.lang.Integer status) {
		this.status = status;
	}

	public java.lang.Integer getSource() {
		return source;
	}

	public void setSource(java.lang.Integer source) {
		this.source = source;
	}

	public java.lang.Integer getReplacement() {
		return replacement;
	}

	public void setReplacement(java.lang.Integer replacement) {
		this.replacement = replacement;
	}

	public java.lang.String getIsuserevaluate() {
		return isuserevaluate;
	}

	public void setIsuserevaluate(java.lang.String isuserevaluate) {
		this.isuserevaluate = isuserevaluate;
	}

	public java.lang.String getIsshopevaluate() {
		return isshopevaluate;
	}

	public void setIsshopevaluate(java.lang.String isshopevaluate) {
		this.isshopevaluate = isshopevaluate;
	}

	public java.lang.Long getMember() {
		return member;
	}

	public void setMember(java.lang.Long member) {
		this.member = member;
	}

	public Member getMemberObject() {
		return memberObject;
	}

	public void setMemberObject(Member memberObject) {
		this.memberObject = memberObject;
	}

	public java.lang.Long getShopId() {
		return shopId;
	}

	public void setShopId(java.lang.Long shopId) {
		this.shopId = shopId;
	}

	public java.lang.Long getCreatoradmin() {
		return creatoradmin;
	}

	public void setCreatoradmin(java.lang.Long creatoradmin) {
		this.creatoradmin = creatoradmin;
	}

	public java.lang.Long getModifieradmin() {
		return modifieradmin;
	}

	public void setModifieradmin(java.lang.Long modifieradmin) {
		this.modifieradmin = modifieradmin;
	}

	public java.util.Date getCreatedatetime() {
		return createdatetime;
	}

	public void setCreatedatetime(java.util.Date createdatetime) {
		this.createdatetime = createdatetime;
	}

	public java.util.Date getUpdatedatetime() {
		return updatedatetime;
	}

	public void setUpdatedatetime(java.util.Date updatedatetime) {
		this.updatedatetime = updatedatetime;
	}

	public java.lang.Long getOrdertransport() {
		return ordertransport;
	}

	public void setOrdertransport(java.lang.Long ordertransport) {
		this.ordertransport = ordertransport;
	}

	public OrderTransport getOrderTransportObject() {
		return orderTransportObject;
	}

	public void setOrderTransportObject(OrderTransport orderTransportObject) {
		this.orderTransportObject = orderTransportObject;
	}

	public java.lang.Integer getIsstatemented() {
		return isstatemented;
	}

	public void setIsstatemented(java.lang.Integer isstatemented) {
		this.isstatemented = isstatemented;
	}

	public java.lang.Long getCcgroupId() {
		return ccgroupId;
	}

	public void setCcgroupId(java.lang.Long ccgroupId) {
		this.ccgroupId = ccgroupId;
	}

	public java.lang.Integer getOrdertype() {
		return ordertype;
	}

	public void setOrdertype(java.lang.Integer ordertype) {
		this.ordertype = ordertype;
	}

	public java.util.Date getAutocanceltime() {
		return autocanceltime;
	}

	public void setAutocanceltime(java.util.Date autocanceltime) {
		this.autocanceltime = autocanceltime;
	}

	public java.util.Date getCancelsentdtime() {
		return cancelsentdtime;
	}

	public void setCancelsentdtime(java.util.Date cancelsentdtime) {
		this.cancelsentdtime = cancelsentdtime;
	}

	public java.lang.Integer getYesnumber() {
		return yesnumber;
	}

	public void setYesnumber(java.lang.Integer yesnumber) {
		this.yesnumber = yesnumber;
	}

	public java.lang.Integer getNonumber() {
		return nonumber;
	}

	public void setNonumber(java.lang.Integer nonumber) {
		this.nonumber = nonumber;
	}

	public java.lang.Long getCommodityId() {
		return commodityId;
	}

	public void setCommodityId(java.lang.Long commodityId) {
		this.commodityId = commodityId;
	}

	public java.lang.String getShopcontent() {
		return shopcontent;
	}

	public void setShopcontent(java.lang.String shopcontent) {
		this.shopcontent = shopcontent;
	}

	public java.lang.Integer getStarlevel() {
		return starlevel;
	}

	public void setStarlevel(java.lang.Integer starlevel) {
		this.starlevel = starlevel;
	}

	public java.lang.String getCaneltime() {
		return caneltime;
	}

	public void setCaneltime(java.lang.String caneltime) {
		this.caneltime = caneltime;
	}

	public java.lang.Double getShouldpaymoney() {
		return shouldpaymoney;
	}

	public void setShouldpaymoney(java.lang.Double shouldpaymoney) {
		this.shouldpaymoney = shouldpaymoney;
	}

	public java.lang.String getIscanfinal() {
		return iscanfinal;
	}

	public void setIscanfinal(java.lang.String iscanfinal) {
		this.iscanfinal = iscanfinal;
	}

	public java.util.Date getPayfreighttime() {
		return payfreighttime;
	}

	public void setPayfreighttime(java.util.Date payfreighttime) {
		this.payfreighttime = payfreighttime;
	}

	public java.lang.Double getTotalamout() {
		return totalamout;
	}

	public void setTotalamout(java.lang.Double totalamout) {
		this.totalamout = totalamout;
	}

	public java.lang.String getIsfreight() {
		return isfreight;
	}

	public void setIsfreight(java.lang.String isfreight) {
		this.isfreight = isfreight;
	}

	public java.lang.String getPayfreight() {
		return payfreight;
	}

	public void setPayfreight(java.lang.String payfreight) {
		this.payfreight = payfreight;
	}

	public java.lang.Long getTransportationId() {
		return transportationId;
	}

	public void setTransportationId(java.lang.Long transportationId) {
		this.transportationId = transportationId;
	}

	public Transportation getTransportationObject() {
		return transportationObject;
	}

	public void setTransportationObject(Transportation transportationObject) {
		this.transportationObject = transportationObject;
	}

	public java.lang.Long getTransportationcompanyId() {
		return transportationcompanyId;
	}

	public void setTransportationcompanyId(java.lang.Long transportationcompanyId) {
		this.transportationcompanyId = transportationcompanyId;
	}

	public Transportationcompany getTransportationcompanyObject() {
		return transportationcompanyObject;
	}

	public void setTransportationcompanyObject(
			Transportationcompany transportationcompanyObject) {
		this.transportationcompanyObject = transportationcompanyObject;
	}

	public java.lang.String getTransportnumber() {
		return transportnumber;
	}

	public void setTransportnumber(java.lang.String transportnumber) {
		this.transportnumber = transportnumber;
	}

	public java.lang.String getTransportremark() {
		return transportremark;
	}

	public void setTransportremark(java.lang.String transportremark) {
		this.transportremark = transportremark;
	}

	public java.lang.Integer getLogisticsState() {
		return logisticsState;
	}

	public void setLogisticsState(java.lang.Integer logisticsState) {
		this.logisticsState = logisticsState;
	}

	public java.lang.String getStationCode() {
		return stationCode;
	}

	public void setStationCode(java.lang.String stationCode) {
		this.stationCode = stationCode;
	}

	public java.lang.String getLicensePlateNumber() {
		return licensePlateNumber;
	}

	public void setLicensePlateNumber(java.lang.String licensePlateNumber) {
		this.licensePlateNumber = licensePlateNumber;
	}

	public java.lang.String getDeclarePayType() {
		return declarePayType;
	}

	public void setDeclarePayType(java.lang.String declarePayType) {
		this.declarePayType = declarePayType;
	}

	public java.lang.String getPayCompanyCode() {
		return payCompanyCode;
	}

	public void setPayCompanyCode(java.lang.String payCompanyCode) {
		this.payCompanyCode = payCompanyCode;
	}

	public java.lang.String getPayNumber() {
		return payNumber;
	}

	public void setPayNumber(java.lang.String payNumber) {
		this.payNumber = payNumber;
	}

	public java.lang.Double getOrderTaxAmount() {
		return orderTaxAmount;
	}

	public void setOrderTaxAmount(java.lang.Double orderTaxAmount) {
		this.orderTaxAmount = orderTaxAmount;
	}

	public java.lang.String getDeclareStatus() {
		return declareStatus;
	}

	public void setDeclareStatus(java.lang.String declareStatus) {
		this.declareStatus = declareStatus;
	}

	public Integer getTransportationType() {
		return transportationType;
	}

	public void setTransportationType(Integer transportationType) {
		this.transportationType = transportationType;
	}

	public Integer getTotalGoodsCount() {
		return totalGoodsCount;
	}

	public void setTotalGoodsCount(Integer totalGoodsCount) {
		this.totalGoodsCount = totalGoodsCount;
	}

	public Double getTotalGoodsWeight() {
		return totalGoodsWeight;
	}

	public void setTotalGoodsWeight(Double totalGoodsWeight) {
		this.totalGoodsWeight = totalGoodsWeight;
	}

}

