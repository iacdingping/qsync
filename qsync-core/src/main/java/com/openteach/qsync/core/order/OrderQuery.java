/*
 * Powered By china-telcom
 * Since 2012 - 2014
 */

package com.openteach.qsync.core.order;

import com.openteach.qsync.core.PageQuery;


/**
 *
 * @author dingp email:dingp@51box.cn
 * @version 1.0
 * @since 1.0
 * */
public class OrderQuery extends PageQuery {
    

	/** id */
	private java.lang.Long id;
	/** code */
	private java.lang.String code;
	/** appraise */
	private java.lang.Integer appraise;
	/** content */
	private java.lang.String content;
	/** ordertime */
	private java.util.Date ordertimeBegin;
	private java.util.Date ordertimeEnd;
	/** remark */
	private java.lang.String remark;
	/** gift */
	private java.lang.String gift;
	/** amount */
	private java.lang.Double amount;
	/** cutamount */
	private java.lang.Double cutamount;
	/** invoicetype */
	private java.lang.Integer invoicetype;
	/** invoicecontent */
	private java.lang.String invoicecontent;
	/** iscoupon */
	private java.lang.String iscoupon;
	/** paytime */
	private java.util.Date paytimeBegin;
	private java.util.Date paytimeEnd;
	/** onlinepay */
	private java.lang.Integer onlinepay;
	/** returnStatus */
	private java.lang.Integer returnStatus;
	/** payStatus */
	private java.lang.Integer payStatus;
	/** payType */
	private java.lang.Integer payType;
	/** transPrice */
	private java.lang.Double transPrice;
	/** isBigOrder */
	private java.lang.String isBigOrder;
	/** isPackage */
	private java.lang.String isPackage;
	/** status */
	private java.lang.Integer status;
	/** source */
	private java.lang.Integer source;
	/** replacement */
	private java.lang.Integer replacement;
	/** isuserevaluate */
	private java.lang.String isuserevaluate;
	/** isshopevaluate */
	private java.lang.String isshopevaluate;
	/** member */
	private java.lang.Long member;
	/** shopId */
	private java.lang.Long shopId;
	/** creatoradmin */
	private java.lang.Long creatoradmin;
	/** modifieradmin */
	private java.lang.Long modifieradmin;
	/** createdatetime */
	private java.util.Date createdatetimeBegin;
	private java.util.Date createdatetimeEnd;
	/** updatedatetime */
	private java.util.Date updatedatetimeBegin;
	private java.util.Date updatedatetimeEnd;
	/** ordertransport */
	private java.lang.Long ordertransport;
	/** statementId */
	private java.lang.Long statementId;
	/** isstatemented */
	private java.lang.Integer isstatemented;
	/** ccgroupId */
	private java.lang.Long ccgroupId;
	/** ordertype */
	private java.lang.Integer ordertype;
	/** autocanceltime */
	private java.util.Date autocanceltimeBegin;
	private java.util.Date autocanceltimeEnd;
	/** cancelsentdtime */
	private java.util.Date cancelsentdtimeBegin;
	private java.util.Date cancelsentdtimeEnd;
	/** yesnumber */
	private java.lang.Integer yesnumber;
	/** nonumber */
	private java.lang.Integer nonumber;
	/** commodityId */
	private java.lang.Long commodityId;
	/** shopcontent */
	private java.lang.String shopcontent;
	/** starlevel */
	private java.lang.Integer starlevel;
	/** caneltime */
	private java.lang.String caneltime;
	/** shouldpaymoney */
	private java.lang.Double shouldpaymoney;
	/** iscanfinal */
	private java.lang.String iscanfinal;
	/** payfreighttime */
	private java.util.Date payfreighttimeBegin;
	private java.util.Date payfreighttimeEnd;
	/** totalamout */
	private java.lang.Double totalamout;
	/** isfreight */
	private java.lang.String isfreight;
	/** payfreight */
	private java.lang.String payfreight;
	/** transportationId */
	private java.lang.Long transportationId;
	/** transportationcompanyId */
	private java.lang.Long transportationcompanyId;
	/** transportnumber */
	private java.lang.String transportnumber;
	/** transportremark */
	private java.lang.String transportremark;

	public java.lang.Long getId() {
		return this.id;
	}
	
	public void setId(java.lang.Long value) {
		this.id = value;
	}
	
	public java.lang.String getCode() {
		return this.code;
	}
	
	public void setCode(java.lang.String value) {
		this.code = value;
	}
	
	public java.lang.Integer getAppraise() {
		return this.appraise;
	}
	
	public void setAppraise(java.lang.Integer value) {
		this.appraise = value;
	}
	
	public java.lang.String getContent() {
		return this.content;
	}
	
	public void setContent(java.lang.String value) {
		this.content = value;
	}
	
	public java.util.Date getOrdertimeBegin() {
		return this.ordertimeBegin;
	}
	
	public void setOrdertimeBegin(java.util.Date value) {
		this.ordertimeBegin = value;
	}	
	
	public java.util.Date getOrdertimeEnd() {
		return this.ordertimeEnd;
	}
	
	public void setOrdertimeEnd(java.util.Date value) {
		this.ordertimeEnd = value;
	}
	
	public java.lang.String getRemark() {
		return this.remark;
	}
	
	public void setRemark(java.lang.String value) {
		this.remark = value;
	}
	
	public java.lang.String getGift() {
		return this.gift;
	}
	
	public void setGift(java.lang.String value) {
		this.gift = value;
	}
	
	public java.lang.Double getAmount() {
		return this.amount;
	}
	
	public void setAmount(java.lang.Double value) {
		this.amount = value;
	}
	
	public java.lang.Double getCutamount() {
		return this.cutamount;
	}
	
	public void setCutamount(java.lang.Double value) {
		this.cutamount = value;
	}
	
	public java.lang.Integer getInvoicetype() {
		return this.invoicetype;
	}
	
	public void setInvoicetype(java.lang.Integer value) {
		this.invoicetype = value;
	}
	
	public java.lang.String getInvoicecontent() {
		return this.invoicecontent;
	}
	
	public void setInvoicecontent(java.lang.String value) {
		this.invoicecontent = value;
	}
	
	public java.lang.String getIscoupon() {
		return this.iscoupon;
	}
	
	public void setIscoupon(java.lang.String value) {
		this.iscoupon = value;
	}
	
	public java.util.Date getPaytimeBegin() {
		return this.paytimeBegin;
	}
	
	public void setPaytimeBegin(java.util.Date value) {
		this.paytimeBegin = value;
	}	
	
	public java.util.Date getPaytimeEnd() {
		return this.paytimeEnd;
	}
	
	public void setPaytimeEnd(java.util.Date value) {
		this.paytimeEnd = value;
	}
	
	public java.lang.Integer getOnlinepay() {
		return this.onlinepay;
	}
	
	public void setOnlinepay(java.lang.Integer value) {
		this.onlinepay = value;
	}
	
	public java.lang.Integer getReturnStatus() {
		return this.returnStatus;
	}
	
	public void setReturnStatus(java.lang.Integer value) {
		this.returnStatus = value;
	}
	
	public java.lang.Integer getPayStatus() {
		return this.payStatus;
	}
	
	public void setPayStatus(java.lang.Integer value) {
		this.payStatus = value;
	}
	
	public java.lang.Integer getPayType() {
		return this.payType;
	}
	
	public void setPayType(java.lang.Integer value) {
		this.payType = value;
	}
	
	public java.lang.Double getTransPrice() {
		return this.transPrice;
	}
	
	public void setTransPrice(java.lang.Double value) {
		this.transPrice = value;
	}
	
	public java.lang.String getIsBigOrder() {
		return this.isBigOrder;
	}
	
	public void setIsBigOrder(java.lang.String value) {
		this.isBigOrder = value;
	}
	
	public java.lang.String getIsPackage() {
		return this.isPackage;
	}
	
	public void setIsPackage(java.lang.String value) {
		this.isPackage = value;
	}
	
	public java.lang.Integer getStatus() {
		return this.status;
	}
	
	public void setStatus(java.lang.Integer value) {
		this.status = value;
	}
	
	public java.lang.Integer getSource() {
		return this.source;
	}
	
	public void setSource(java.lang.Integer value) {
		this.source = value;
	}
	
	public java.lang.Integer getReplacement() {
		return this.replacement;
	}
	
	public void setReplacement(java.lang.Integer value) {
		this.replacement = value;
	}
	
	public java.lang.String getIsuserevaluate() {
		return this.isuserevaluate;
	}
	
	public void setIsuserevaluate(java.lang.String value) {
		this.isuserevaluate = value;
	}
	
	public java.lang.String getIsshopevaluate() {
		return this.isshopevaluate;
	}
	
	public void setIsshopevaluate(java.lang.String value) {
		this.isshopevaluate = value;
	}
	
	public java.lang.Long getMember() {
		return this.member;
	}
	
	public void setMember(java.lang.Long value) {
		this.member = value;
	}
	
	public java.lang.Long getShopId() {
		return this.shopId;
	}
	
	public void setShopId(java.lang.Long value) {
		this.shopId = value;
	}
	
	public java.lang.Long getCreatoradmin() {
		return this.creatoradmin;
	}
	
	public void setCreatoradmin(java.lang.Long value) {
		this.creatoradmin = value;
	}
	
	public java.lang.Long getModifieradmin() {
		return this.modifieradmin;
	}
	
	public void setModifieradmin(java.lang.Long value) {
		this.modifieradmin = value;
	}
	
	public java.util.Date getCreatedatetimeBegin() {
		return this.createdatetimeBegin;
	}
	
	public void setCreatedatetimeBegin(java.util.Date value) {
		this.createdatetimeBegin = value;
	}	
	
	public java.util.Date getCreatedatetimeEnd() {
		return this.createdatetimeEnd;
	}
	
	public void setCreatedatetimeEnd(java.util.Date value) {
		this.createdatetimeEnd = value;
	}
	
	public java.util.Date getUpdatedatetimeBegin() {
		return this.updatedatetimeBegin;
	}
	
	public void setUpdatedatetimeBegin(java.util.Date value) {
		this.updatedatetimeBegin = value;
	}	
	
	public java.util.Date getUpdatedatetimeEnd() {
		return this.updatedatetimeEnd;
	}
	
	public void setUpdatedatetimeEnd(java.util.Date value) {
		this.updatedatetimeEnd = value;
	}
	
	public java.lang.Long getOrdertransport() {
		return this.ordertransport;
	}
	
	public void setOrdertransport(java.lang.Long value) {
		this.ordertransport = value;
	}
	
	public java.lang.Long getStatementId() {
		return this.statementId;
	}
	
	public void setStatementId(java.lang.Long value) {
		this.statementId = value;
	}
	
	public java.lang.Integer getIsstatemented() {
		return this.isstatemented;
	}
	
	public void setIsstatemented(java.lang.Integer value) {
		this.isstatemented = value;
	}
	
	public java.lang.Long getCcgroupId() {
		return this.ccgroupId;
	}
	
	public void setCcgroupId(java.lang.Long value) {
		this.ccgroupId = value;
	}
	
	public java.lang.Integer getOrdertype() {
		return this.ordertype;
	}
	
	public void setOrdertype(java.lang.Integer value) {
		this.ordertype = value;
	}
	
	public java.util.Date getAutocanceltimeBegin() {
		return this.autocanceltimeBegin;
	}
	
	public void setAutocanceltimeBegin(java.util.Date value) {
		this.autocanceltimeBegin = value;
	}	
	
	public java.util.Date getAutocanceltimeEnd() {
		return this.autocanceltimeEnd;
	}
	
	public void setAutocanceltimeEnd(java.util.Date value) {
		this.autocanceltimeEnd = value;
	}
	
	public java.util.Date getCancelsentdtimeBegin() {
		return this.cancelsentdtimeBegin;
	}
	
	public void setCancelsentdtimeBegin(java.util.Date value) {
		this.cancelsentdtimeBegin = value;
	}	
	
	public java.util.Date getCancelsentdtimeEnd() {
		return this.cancelsentdtimeEnd;
	}
	
	public void setCancelsentdtimeEnd(java.util.Date value) {
		this.cancelsentdtimeEnd = value;
	}
	
	public java.lang.Integer getYesnumber() {
		return this.yesnumber;
	}
	
	public void setYesnumber(java.lang.Integer value) {
		this.yesnumber = value;
	}
	
	public java.lang.Integer getNonumber() {
		return this.nonumber;
	}
	
	public void setNonumber(java.lang.Integer value) {
		this.nonumber = value;
	}
	
	public java.lang.Long getCommodityId() {
		return this.commodityId;
	}
	
	public void setCommodityId(java.lang.Long value) {
		this.commodityId = value;
	}
	
	public java.lang.String getShopcontent() {
		return this.shopcontent;
	}
	
	public void setShopcontent(java.lang.String value) {
		this.shopcontent = value;
	}
	
	public java.lang.Integer getStarlevel() {
		return this.starlevel;
	}
	
	public void setStarlevel(java.lang.Integer value) {
		this.starlevel = value;
	}
	
	public java.lang.String getCaneltime() {
		return this.caneltime;
	}
	
	public void setCaneltime(java.lang.String value) {
		this.caneltime = value;
	}
	
	public java.lang.Double getShouldpaymoney() {
		return this.shouldpaymoney;
	}
	
	public void setShouldpaymoney(java.lang.Double value) {
		this.shouldpaymoney = value;
	}
	
	public java.lang.String getIscanfinal() {
		return this.iscanfinal;
	}
	
	public void setIscanfinal(java.lang.String value) {
		this.iscanfinal = value;
	}
	
	public java.util.Date getPayfreighttimeBegin() {
		return this.payfreighttimeBegin;
	}
	
	public void setPayfreighttimeBegin(java.util.Date value) {
		this.payfreighttimeBegin = value;
	}	
	
	public java.util.Date getPayfreighttimeEnd() {
		return this.payfreighttimeEnd;
	}
	
	public void setPayfreighttimeEnd(java.util.Date value) {
		this.payfreighttimeEnd = value;
	}
	
	public java.lang.Double getTotalamout() {
		return this.totalamout;
	}
	
	public void setTotalamout(java.lang.Double value) {
		this.totalamout = value;
	}
	
	public java.lang.String getIsfreight() {
		return this.isfreight;
	}
	
	public void setIsfreight(java.lang.String value) {
		this.isfreight = value;
	}
	
	public java.lang.String getPayfreight() {
		return this.payfreight;
	}
	
	public void setPayfreight(java.lang.String value) {
		this.payfreight = value;
	}
	
	public java.lang.Long getTransportationId() {
		return this.transportationId;
	}
	
	public void setTransportationId(java.lang.Long value) {
		this.transportationId = value;
	}
	
	public java.lang.Long getTransportationcompanyId() {
		return this.transportationcompanyId;
	}
	
	public void setTransportationcompanyId(java.lang.Long value) {
		this.transportationcompanyId = value;
	}
	
	public java.lang.String getTransportnumber() {
		return this.transportnumber;
	}
	
	public void setTransportnumber(java.lang.String value) {
		this.transportnumber = value;
	}
	
	public java.lang.String getTransportremark() {
		return this.transportremark;
	}
	
	public void setTransportremark(java.lang.String value) {
		this.transportremark = value;
	}
}
