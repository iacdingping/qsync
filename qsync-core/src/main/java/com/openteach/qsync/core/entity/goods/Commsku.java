package com.openteach.qsync.core.entity.goods;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;



/**
 *
 * @author dingp email:dingp@51box.cn
 * @version 1.0
 * @since 1.0
 * */
public class Commsku {
	
	//alias
	public static final String TABLE_ALIAS = "Commsku";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_SKUCODE = "skucode";
	public static final String ALIAS_BARCODE = "barcode";
	public static final String ALIAS_PROPERTIES = "properties";
	public static final String ALIAS_QUANTITY = "quantity";
	public static final String ALIAS_NAME = "name";
	public static final String ALIAS_PICURL = "picurl";
	public static final String ALIAS_VALID = "valid";
	public static final String ALIAS_VALIDDATE = "validdate";
	public static final String ALIAS_SELLNUM = "sellnum";
	public static final String ALIAS_COSTPRICE = "costprice";
	public static final String ALIAS_ORIGINALPRICE = "originalprice";
	public static final String ALIAS_SALEPRICE = "saleprice";
	public static final String ALIAS_BUYPRICE = "buyprice";
	public static final String ALIAS_SCORE = "score";
	public static final String ALIAS_LISTORDER = "listorder";
	public static final String ALIAS_ISDELETED = "isdeleted";
	public static final String ALIAS_SOURCE = "source";
	public static final String ALIAS_ITEM_ID = "itemId";
	public static final String ALIAS_ISPRICE = "isprice";
	public static final String ALIAS_SHOP_ID = "shopId";
	public static final String ALIAS_CREATORADMIN = "creatoradmin";
	public static final String ALIAS_MODIFIERADMIN = "modifieradmin";
	public static final String ALIAS_CREATEDATETIME = "createdatetime";
	public static final String ALIAS_UPDATEDATETIME = "updatedatetime";
	public static final String ALIAS_COMMENT = "comment";
	public static final String ALIAS_GOOD = "good";
	public static final String ALIAS_COMM = "comm";
	public static final String ALIAS_BAD = "bad";
	public static final String ALIAS_STOCK = "stock";
	
	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START
    /**
     * id       db_column: id 
     */	
	private java.lang.Long id;
    /**
     * skucode       db_column: skucode 
     */	
	private java.lang.String skucode;
    /**
     * barcode       db_column: barcode 
     */	
	private java.lang.String barcode;
    /**
     * properties       db_column: properties 
     */	
	@NotNull
	private java.lang.String properties;
    /**
     * quantity       db_column: quantity 
     */	
	private java.lang.Integer quantity;
    /**
     * name       db_column: name 
     */	
	@NotNull
	private java.lang.String name;
    /**
     * picurl       db_column: picurl 
     */	
	private java.lang.String picurl;
    /**
     * valid       db_column: valid 
     */	
	private java.lang.String valid;
    /**
     * validdate       db_column: validdate 
     */	
	private java.util.Date validdate;
    /**
     * sellnum       db_column: sellnum 
     */	
	private java.lang.Integer sellnum;
    /**
     * costprice       db_column: costprice 
     */	
	private java.lang.Double costprice;
    /**
     * originalprice       db_column: originalprice 
     */	
	private java.lang.Double originalprice;
    /**
     * saleprice       db_column: saleprice 
     */	
	private java.lang.Double saleprice;
    /**
     * buyprice       db_column: buyprice 
     */	
	private java.lang.Double buyprice;
    /**
     * score       db_column: score 
     */	
	private java.lang.Integer score;
    /**
     * listorder       db_column: listorder 
     */	
	private java.lang.Integer listorder;
    /**
     * isdeleted       db_column: isdeleted 
     */	
	private java.lang.String isdeleted;
    /**
     * source       db_column: source 
     */	
	private java.lang.Integer source;
    /**
     * itemId       db_column: item_id 
     */	
	private java.lang.Long itemId;
	@Valid
	private Commodity commodityObject;
    /**
     * isprice       db_column: isprice 
     */	
	private java.lang.String isprice;
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
     * comment       db_column: comment 
     */	
	private java.lang.Integer comment;
    /**
     * good       db_column: good 
     */	
	private java.lang.Integer good;
    /**
     * comm       db_column: comm 
     */	
	private java.lang.Integer comm;
    /**
     * bad       db_column: bad 
     */	
	private java.lang.Integer bad;
    /**
     * stock       db_column: stock 
     */	
	private java.lang.Integer stock;
	//columns END

	public Commsku(){
	}

	public Commsku(
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
	public void setSkucode(java.lang.String value) {
		this.skucode = value;
	}
	public java.lang.String getSkucode() {
		return this.skucode;
	}
	public void setBarcode(java.lang.String value) {
		this.barcode = value;
	}
	public java.lang.String getBarcode() {
		return this.barcode;
	}
	public void setProperties(java.lang.String value) {
		this.properties = value;
	}
	public java.lang.String getProperties() {
		return this.properties;
	}
	public void setQuantity(java.lang.Integer value) {
		this.quantity = value;
	}
	public java.lang.Integer getQuantity() {
		return this.quantity;
	}
	public void setName(java.lang.String value) {
		this.name = value;
	}
	@NotNull
	public java.lang.String getName() {
		return this.name;
	}
	public void setPicurl(java.lang.String value) {
		this.picurl = value;
	}
	public java.lang.String getPicurl() {
		return this.picurl;
	}
	public void setValid(java.lang.String value) {
		this.valid = value;
	}
	public java.lang.String getValid() {
		return this.valid;
	}
	public void setValiddate(java.util.Date value) {
		this.validdate = value;
	}
	public java.util.Date getValiddate() {
		return this.validdate;
	}
	public void setSellnum(java.lang.Integer value) {
		this.sellnum = value;
	}
	public java.lang.Integer getSellnum() {
		return this.sellnum;
	}
	public void setCostprice(java.lang.Double value) {
		this.costprice = value;
	}
	public java.lang.Double getCostprice() {
		return this.costprice;
	}
	public void setOriginalprice(java.lang.Double value) {
		this.originalprice = value;
	}
	public java.lang.Double getOriginalprice() {
		return this.originalprice;
	}
	public void setSaleprice(java.lang.Double value) {
		this.saleprice = value;
	}
	public java.lang.Double getSaleprice() {
		return this.saleprice;
	}
	public void setBuyprice(java.lang.Double value) {
		this.buyprice = value;
	}
	public java.lang.Double getBuyprice() {
		return this.buyprice;
	}
	public void setScore(java.lang.Integer value) {
		this.score = value;
	}
	public java.lang.Integer getScore() {
		return this.score;
	}
	public void setListorder(java.lang.Integer value) {
		this.listorder = value;
	}
	public java.lang.Integer getListorder() {
		return this.listorder;
	}
	public void setIsdeleted(java.lang.String value) {
		this.isdeleted = value;
	}
	public java.lang.String getIsdeleted() {
		return this.isdeleted;
	}
	public void setSource(java.lang.Integer value) {
		this.source = value;
	}
	public java.lang.Integer getSource() {
		return this.source;
	}
	public void setItemId(java.lang.Long value) {
		this.itemId = value;
	}
	public java.lang.Long getItemId() {
		return this.itemId;
	}
	@NotNull
	public Commodity getCommodityObject() {
		return commodityObject;
	}
	public void setCommodityObject(Commodity commodityObject) {
		this.commodityObject = commodityObject;
	}
	public void setIsprice(java.lang.String value) {
		this.isprice = value;
	}
	public java.lang.String getIsprice() {
		return this.isprice;
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
	public void setComment(java.lang.Integer value) {
		this.comment = value;
	}
	public java.lang.Integer getComment() {
		return this.comment;
	}
	public void setGood(java.lang.Integer value) {
		this.good = value;
	}
	public java.lang.Integer getGood() {
		return this.good;
	}
	public void setComm(java.lang.Integer value) {
		this.comm = value;
	}
	public java.lang.Integer getComm() {
		return this.comm;
	}
	public void setBad(java.lang.Integer value) {
		this.bad = value;
	}
	public java.lang.Integer getBad() {
		return this.bad;
	}
	public void setStock(java.lang.Integer value) {
		this.stock = value;
	}
	public java.lang.Integer getStock() {
		return this.stock;
	}
}

