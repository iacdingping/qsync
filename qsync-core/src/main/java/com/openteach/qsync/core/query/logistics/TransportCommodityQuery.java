package com.openteach.qsync.core.query.logistics;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.openteach.qsync.core.PageQuery;


/**
 *
 * @author dingp email:dingp@51box.cn
 * @version 1.0
 * @since 1.0
 * */
public class TransportCommodityQuery extends PageQuery {
    

	/** id */
	private java.lang.Long id;
	/** number */
	private java.lang.Integer number;
	/** iscomment */
	private java.lang.Integer iscomment;
	/** price */
	private java.lang.Double price;
	/** delivernum */
	private java.lang.Integer delivernum;
	/** source */
	private java.lang.Integer source;
	/** transportId */
	private java.lang.Long transportId;
	/** skuId */
	private java.lang.Long skuId;
	/** isreturn */
	private java.lang.Integer isreturn;
	/** 商品货号 保税进口业务，货号需与电子账册一致由仓储提供 */
	private java.lang.String goodsItemNo;

	public java.lang.Long getId() {
		return this.id;
	}
	
	public void setId(java.lang.Long value) {
		this.id = value;
	}
	
	public java.lang.Integer getNumber() {
		return this.number;
	}
	
	public void setNumber(java.lang.Integer value) {
		this.number = value;
	}
	
	public java.lang.Integer getIscomment() {
		return this.iscomment;
	}
	
	public void setIscomment(java.lang.Integer value) {
		this.iscomment = value;
	}
	
	public java.lang.Double getPrice() {
		return this.price;
	}
	
	public void setPrice(java.lang.Double value) {
		this.price = value;
	}
	
	public java.lang.Integer getDelivernum() {
		return this.delivernum;
	}
	
	public void setDelivernum(java.lang.Integer value) {
		this.delivernum = value;
	}
	
	public java.lang.Integer getSource() {
		return this.source;
	}
	
	public void setSource(java.lang.Integer value) {
		this.source = value;
	}
	
	public java.lang.Long getTransportId() {
		return this.transportId;
	}
	
	public void setTransportId(java.lang.Long value) {
		this.transportId = value;
	}
	
	public java.lang.Long getSkuId() {
		return this.skuId;
	}
	
	public void setSkuId(java.lang.Long value) {
		this.skuId = value;
	}
	
	public java.lang.Integer getIsreturn() {
		return this.isreturn;
	}
	
	public void setIsreturn(java.lang.Integer value) {
		this.isreturn = value;
	}
	
	public java.lang.String getGoodsItemNo() {
		return this.goodsItemNo;
	}
	
	public void setGoodsItemNo(java.lang.String value) {
		this.goodsItemNo = value;
	}
	

	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.MULTI_LINE_STYLE);
	}
	
}

