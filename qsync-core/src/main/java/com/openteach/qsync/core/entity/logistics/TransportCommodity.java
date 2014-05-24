package com.openteach.qsync.core.entity.logistics;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.openteach.qsync.core.entity.goods.Commsku;



/**
 *
 * @author dingp email:dingp@51box.cn
 * @version 1.0
 * @since 1.0
 * */
public class TransportCommodity {
	
	//alias
	public static final String TABLE_ALIAS = "TransportCommodity";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_NUMBER = "number";
	public static final String ALIAS_ISCOMMENT = "iscomment";
	public static final String ALIAS_PRICE = "price";
	public static final String ALIAS_DELIVERNUM = "delivernum";
	public static final String ALIAS_SOURCE = "source";
	public static final String ALIAS_TRANSPORT_ID = "transportId";
	public static final String ALIAS_SKU_ID = "skuId";
	public static final String ALIAS_ISRETURN = "isreturn";
	public static final String ALIAS_GOODS_ITEM_NO = "商品货号 保税进口业务，货号需与电子账册一致由仓储提供";
	
	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START
    /**
     * id       db_column: id 
     */	
	private java.lang.Long id;
    /**
     * number       db_column: number 
     */	
	private java.lang.Integer number;
    /**
     * iscomment       db_column: iscomment 
     */	
	private java.lang.Integer iscomment;
    /**
     * price       db_column: price 
     */	
	private java.lang.Double price;
    /**
     * delivernum       db_column: delivernum 
     */	
	@NotNull
	private java.lang.Integer delivernum;
    /**
     * source       db_column: source 
     */	
	private java.lang.Integer source;
    /**
     * transportId       db_column: transport_id 
     */	
	private java.lang.Long transportId;
    /**
     * skuId       db_column: sku_id 
     */	
	private java.lang.Long skuId;
	@Valid
	private Commsku commskuObject;
    /**
     * isreturn       db_column: isreturn 
     */	
	private java.lang.Integer isreturn;
    /**
     * 商品货号 保税进口业务，货号需与电子账册一致由仓储提供       db_column: goods_item_no 
     */	
	private java.lang.String goodsItemNo;
	//columns END

	public TransportCommodity(){
	}

	public TransportCommodity(
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
	public void setNumber(java.lang.Integer value) {
		this.number = value;
	}
	public java.lang.Integer getNumber() {
		return this.number;
	}
	public void setIscomment(java.lang.Integer value) {
		this.iscomment = value;
	}
	public java.lang.Integer getIscomment() {
		return this.iscomment;
	}
	public void setPrice(java.lang.Double value) {
		this.price = value;
	}
	@NotNull
	public java.lang.Double getPrice() {
		return this.price;
	}
	public void setDelivernum(java.lang.Integer value) {
		this.delivernum = value;
	}
	@NotNull
	public java.lang.Integer getDelivernum() {
		return this.delivernum;
	}
	public void setSource(java.lang.Integer value) {
		this.source = value;
	}
	public java.lang.Integer getSource() {
		return this.source;
	}
	public void setTransportId(java.lang.Long value) {
		this.transportId = value;
	}
	public java.lang.Long getTransportId() {
		return this.transportId;
	}
	public void setSkuId(java.lang.Long value) {
		this.skuId = value;
	}
	public java.lang.Long getSkuId() {
		return this.skuId;
	}
	@NotNull
	public Commsku getCommskuObject() {
		return commskuObject;
	}
	public void setCommskuObject(Commsku commskuObject) {
		this.commskuObject = commskuObject;
	}
	public void setIsreturn(java.lang.Integer value) {
		this.isreturn = value;
	}
	public java.lang.Integer getIsreturn() {
		return this.isreturn;
	}
	public void setGoodsItemNo(java.lang.String value) {
		this.goodsItemNo = value;
	}
	@NotNull
	public java.lang.String getGoodsItemNo() {
		return this.goodsItemNo;
	}
}

