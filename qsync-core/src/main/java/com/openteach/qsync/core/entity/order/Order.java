package com.openteach.qsync.core.entity.order;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.openteach.qsync.core.entity.info.Member;



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
	@NotNull(message="订单编号")
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
	@NotNull(message="成交时间")
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
	@NotNull(message="订单总金额")
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
	@NotNull(message="运费")
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
	
	@Valid
	@NotNull(message="订单表对应外键member")
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
	@Valid
	@NotNull(message="order 对应 order_transport 外键")
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
	@NotNull
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
    /**
     * transportationcompanyId       db_column: transportationcompany_id 
     */	
	private java.lang.Long transportationcompanyId;
	
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
	@NotNull(message="支付类型")
	private java.lang.String declarePayType;
    /**
     * 支付公司编码       db_column: pay_company_code 
     */	
	@NotNull(message="支付公司编码")
	private java.lang.String payCompanyCode;
    /**
     * 支付单号       db_column: pay_number 
     */	
	@NotNull(message="支付单号")
	private java.lang.String payNumber;
    /**
     * 订单税款       db_column: order_tax_amount 
     */	
	@NotNull(message="订单税款")
	private java.lang.Double orderTaxAmount;
	/**
	 * 报关状态 初始状态 00000 从左到右 
	 * 第一位 1 初始化 第二位订单报关状态 第三位  物流报关状态 第四位运单报关状态 第五位 个人物品报关状态   
	 * 报关状态 0 未开始 1 报关中 2 报关完成 3 报关失败
	 */
	private java.lang.String declareStatus;
	@NotNull(message="发货方式（物流方式）")
	private Integer transportationType;
	//columns END
	@NotNull(message="总件数")
	private Integer totalGoodsCount;
	@NotNull(message="毛重。总重量（ems称重）")
	private Double shippingWeight;
	@NotNull(message="总重量（所有物品重量）")
	private Double grossWeight;
	/**
	 * 报关返回值
	 */
	private Integer returnType;
	/**
	 * 是否同步标志 Y|N
	 */
	private String isSync;
	
	/**
	 * 物品总价
	 */
	@NotNull(message="货款")
	private Double commskuAmount;
	public Order(){
	}

	public Order(
		java.lang.Long id
	){
		this.id = id;
	}

	public void setId(java.lang.Long value) {
		this.id = value;
	}
	public java.lang.Long getId() {
		return this.id;
	}
	public void setCode(java.lang.String value) {
		this.code = value;
	}
	public java.lang.String getCode() {
		return this.code;
	}
	public void setAppraise(java.lang.Integer value) {
		this.appraise = value;
	}
	public java.lang.Integer getAppraise() {
		return this.appraise;
	}
	public void setContent(java.lang.String value) {
		this.content = value;
	}
	public java.lang.String getContent() {
		return this.content;
	}
	public void setOrdertime(java.util.Date value) {
		this.ordertime = value;
	}
	public java.util.Date getOrdertime() {
		return this.ordertime;
	}
	public void setRemark(java.lang.String value) {
		this.remark = value;
	}
	public java.lang.String getRemark() {
		return this.remark;
	}
	public void setGift(java.lang.String value) {
		this.gift = value;
	}
	public java.lang.String getGift() {
		return this.gift;
	}
	public void setAmount(java.lang.Double value) {
		this.amount = value;
	}
	public java.lang.Double getAmount() {
		return this.amount;
	}
	public void setCutamount(java.lang.Double value) {
		this.cutamount = value;
	}
	public java.lang.Double getCutamount() {
		return this.cutamount;
	}
	public void setInvoicetype(java.lang.Integer value) {
		this.invoicetype = value;
	}
	public java.lang.Integer getInvoicetype() {
		return this.invoicetype;
	}
	public void setInvoicecontent(java.lang.String value) {
		this.invoicecontent = value;
	}
	public java.lang.String getInvoicecontent() {
		return this.invoicecontent;
	}
	public void setIscoupon(java.lang.String value) {
		this.iscoupon = value;
	}
	public java.lang.String getIscoupon() {
		return this.iscoupon;
	}
	public void setPaytime(java.util.Date value) {
		this.paytime = value;
	}
	public java.util.Date getPaytime() {
		return this.paytime;
	}
	public void setOnlinepay(java.lang.Integer value) {
		this.onlinepay = value;
	}
	public java.lang.Integer getOnlinepay() {
		return this.onlinepay;
	}
	public void setReturnStatus(java.lang.Integer value) {
		this.returnStatus = value;
	}
	public java.lang.Integer getReturnStatus() {
		return this.returnStatus;
	}
	public void setPayStatus(java.lang.Integer value) {
		this.payStatus = value;
	}
	public java.lang.Integer getPayStatus() {
		return this.payStatus;
	}
	public void setPayType(java.lang.Integer value) {
		this.payType = value;
	}
	public java.lang.Integer getPayType() {
		return this.payType;
	}
	public void setTransPrice(java.lang.Double value) {
		this.transPrice = value;
	}
	public java.lang.Double getTransPrice() {
		return this.transPrice;
	}
	public void setIsBigOrder(java.lang.String value) {
		this.isBigOrder = value;
	}
	public java.lang.String getIsBigOrder() {
		return this.isBigOrder;
	}
	public void setIsPackage(java.lang.String value) {
		this.isPackage = value;
	}
	public java.lang.String getIsPackage() {
		return this.isPackage;
	}
	public void setStatus(java.lang.Integer value) {
		this.status = value;
	}
	public java.lang.Integer getStatus() {
		return this.status;
	}
	public void setSource(java.lang.Integer value) {
		this.source = value;
	}
	public java.lang.Integer getSource() {
		return this.source;
	}
	public void setReplacement(java.lang.Integer value) {
		this.replacement = value;
	}
	public java.lang.Integer getReplacement() {
		return this.replacement;
	}
	public void setIsuserevaluate(java.lang.String value) {
		this.isuserevaluate = value;
	}
	public java.lang.String getIsuserevaluate() {
		return this.isuserevaluate;
	}
	public void setIsshopevaluate(java.lang.String value) {
		this.isshopevaluate = value;
	}
	public java.lang.String getIsshopevaluate() {
		return this.isshopevaluate;
	}
	public void setMember(java.lang.Long value) {
		this.member = value;
	}
	public java.lang.Long getMember() {
		return this.member;
	}
	
	public Member getMemberObject() {
		return memberObject;
	}
	public void setMemberObject(Member memberObject) {
		this.memberObject = memberObject;
	}
	public void setShopId(java.lang.Long value) {
		this.shopId = value;
	}
	public java.lang.Long getShopId() {
		return this.shopId;
	}
	public void setCreatoradmin(java.lang.Long value) {
		this.creatoradmin = value;
	}
	public java.lang.Long getCreatoradmin() {
		return this.creatoradmin;
	}
	public void setModifieradmin(java.lang.Long value) {
		this.modifieradmin = value;
	}
	public java.lang.Long getModifieradmin() {
		return this.modifieradmin;
	}
	public void setCreatedatetime(java.util.Date value) {
		this.createdatetime = value;
	}
	public java.util.Date getCreatedatetime() {
		return this.createdatetime;
	}
	public void setUpdatedatetime(java.util.Date value) {
		this.updatedatetime = value;
	}
	public java.util.Date getUpdatedatetime() {
		return this.updatedatetime;
	}
	public void setOrdertransport(java.lang.Long value) {
		this.ordertransport = value;
	}
	public java.lang.Long getOrdertransport() {
		return this.ordertransport;
	}
	
	public OrderTransport getOrderTransportObject() {
		return orderTransportObject;
	}
	public void setOrderTransportObject(OrderTransport orderTransportObject) {
		this.orderTransportObject = orderTransportObject;
	}
	public void setIsstatemented(java.lang.Integer value) {
		this.isstatemented = value;
	}
	public java.lang.Integer getIsstatemented() {
		return this.isstatemented;
	}
	public void setCcgroupId(java.lang.Long value) {
		this.ccgroupId = value;
	}
	public java.lang.Long getCcgroupId() {
		return this.ccgroupId;
	}
	public void setOrdertype(java.lang.Integer value) {
		this.ordertype = value;
	}
	public java.lang.Integer getOrdertype() {
		return this.ordertype;
	}
	public void setAutocanceltime(java.util.Date value) {
		this.autocanceltime = value;
	}
	public java.util.Date getAutocanceltime() {
		return this.autocanceltime;
	}
	public void setCancelsentdtime(java.util.Date value) {
		this.cancelsentdtime = value;
	}
	public java.util.Date getCancelsentdtime() {
		return this.cancelsentdtime;
	}
	public void setYesnumber(java.lang.Integer value) {
		this.yesnumber = value;
	}
	public java.lang.Integer getYesnumber() {
		return this.yesnumber;
	}
	public void setNonumber(java.lang.Integer value) {
		this.nonumber = value;
	}
	public java.lang.Integer getNonumber() {
		return this.nonumber;
	}
	public void setCommodityId(java.lang.Long value) {
		this.commodityId = value;
	}
	public java.lang.Long getCommodityId() {
		return this.commodityId;
	}
	public void setShopcontent(java.lang.String value) {
		this.shopcontent = value;
	}
	public java.lang.String getShopcontent() {
		return this.shopcontent;
	}
	public void setStarlevel(java.lang.Integer value) {
		this.starlevel = value;
	}
	public java.lang.Integer getStarlevel() {
		return this.starlevel;
	}
	public void setCaneltime(java.lang.String value) {
		this.caneltime = value;
	}
	public java.lang.String getCaneltime() {
		return this.caneltime;
	}
	public void setShouldpaymoney(java.lang.Double value) {
		this.shouldpaymoney = value;
	}
	public java.lang.Double getShouldpaymoney() {
		return this.shouldpaymoney;
	}
	public void setIscanfinal(java.lang.String value) {
		this.iscanfinal = value;
	}
	public java.lang.String getIscanfinal() {
		return this.iscanfinal;
	}
	public void setPayfreighttime(java.util.Date value) {
		this.payfreighttime = value;
	}
	public java.util.Date getPayfreighttime() {
		return this.payfreighttime;
	}
	public void setTotalamout(java.lang.Double value) {
		this.totalamout = value;
	}
	public java.lang.Double getTotalamout() {
		return this.totalamout;
	}
	public void setIsfreight(java.lang.String value) {
		this.isfreight = value;
	}
	public java.lang.String getIsfreight() {
		return this.isfreight;
	}
	public void setPayfreight(java.lang.String value) {
		this.payfreight = value;
	}
	public java.lang.String getPayfreight() {
		return this.payfreight;
	}
	public void setTransportationId(java.lang.Long value) {
		this.transportationId = value;
	}
	public java.lang.Long getTransportationId() {
		return this.transportationId;
	}
	public void setTransportationcompanyId(java.lang.Long value) {
		this.transportationcompanyId = value;
	}
	public java.lang.Long getTransportationcompanyId() {
		return this.transportationcompanyId;
	}
	public void setTransportnumber(java.lang.String value) {
		this.transportnumber = value;
	}
	public java.lang.String getTransportnumber() {
		return this.transportnumber;
	}
	public void setTransportremark(java.lang.String value) {
		this.transportremark = value;
	}
	public java.lang.String getTransportremark() {
		return this.transportremark;
	}
	public void setLogisticsState(java.lang.Integer value) {
		this.logisticsState = value;
	}
	public java.lang.Integer getLogisticsState() {
		return this.logisticsState;
	}
	public void setStationCode(java.lang.String value) {
		this.stationCode = value;
	}
	public java.lang.String getStationCode() {
		return this.stationCode;
	}
	public void setLicensePlateNumber(java.lang.String value) {
		this.licensePlateNumber = value;
	}
	public java.lang.String getLicensePlateNumber() {
		return this.licensePlateNumber;
	}
	
	public Integer getTotalGoodsCount() {
		return totalGoodsCount;
	}
	public void setTotalGoodsCount(Integer totalGoodsCount) {
		this.totalGoodsCount = totalGoodsCount;
	}
	
	public Double getShippingWeight() {
		return shippingWeight;
	}

	public void setShippingWeight(Double shippingWeight) {
		this.shippingWeight = shippingWeight;
	}

	public Double getGrossWeight() {
		return grossWeight;
	}

	public void setGrossWeight(Double grossWeight) {
		this.grossWeight = grossWeight;
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

	public Integer getReturnType() {
		return returnType;
	}

	public void setReturnType(Integer returnType) {
		this.returnType = returnType;
	}

	public String getIsSync() {
		return isSync;
	}

	public void setIsSync(String isSync) {
		this.isSync = isSync;
	}

	public Double getCommskuAmount() {
		return commskuAmount;
	}

	public void setCommskuAmount(Double commskuAmount) {
		this.commskuAmount = commskuAmount;
	}

}
