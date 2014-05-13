package com.openteach.qsync.core.goods;

import com.openteach.qsync.core.PageQuery;


/**
 *
 * @author dingp email:dingp@51box.cn
 * @version 1.0
 * @since 1.0
 * */
public class CommskuQuery extends PageQuery {
    

	/** id */
	private java.lang.Long id;
	/** skucode */
	private java.lang.String skucode;
	/** barcode */
	private java.lang.String barcode;
	/** properties */
	private java.lang.String properties;
	/** quantity */
	private java.lang.Integer quantity;
	/** name */
	private java.lang.String name;
	/** picurl */
	private java.lang.String picurl;
	/** valid */
	private java.lang.String valid;
	/** validdate */
	private java.util.Date validdateBegin;
	private java.util.Date validdateEnd;
	/** sellnum */
	private java.lang.Integer sellnum;
	/** costprice */
	private java.lang.Double costprice;
	/** originalprice */
	private java.lang.Double originalprice;
	/** saleprice */
	private java.lang.Double saleprice;
	/** buyprice */
	private java.lang.Double buyprice;
	/** score */
	private java.lang.Integer score;
	/** listorder */
	private java.lang.Integer listorder;
	/** isdeleted */
	private java.lang.String isdeleted;
	/** source */
	private java.lang.Integer source;
	/** itemId */
	private java.lang.Long itemId;
	/** isprice */
	private java.lang.String isprice;
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
	/** comment */
	private java.lang.Integer comment;
	/** good */
	private java.lang.Integer good;
	/** comm */
	private java.lang.Integer comm;
	/** bad */
	private java.lang.Integer bad;
	/** stock */
	private java.lang.Integer stock;

	public java.lang.Long getId() {
		return this.id;
	}
	
	public void setId(java.lang.Long value) {
		this.id = value;
	}
	
	public java.lang.String getSkucode() {
		return this.skucode;
	}
	
	public void setSkucode(java.lang.String value) {
		this.skucode = value;
	}
	
	public java.lang.String getBarcode() {
		return this.barcode;
	}
	
	public void setBarcode(java.lang.String value) {
		this.barcode = value;
	}
	
	public java.lang.String getProperties() {
		return this.properties;
	}
	
	public void setProperties(java.lang.String value) {
		this.properties = value;
	}
	
	public java.lang.Integer getQuantity() {
		return this.quantity;
	}
	
	public void setQuantity(java.lang.Integer value) {
		this.quantity = value;
	}
	
	public java.lang.String getName() {
		return this.name;
	}
	
	public void setName(java.lang.String value) {
		this.name = value;
	}
	
	public java.lang.String getPicurl() {
		return this.picurl;
	}
	
	public void setPicurl(java.lang.String value) {
		this.picurl = value;
	}
	
	public java.lang.String getValid() {
		return this.valid;
	}
	
	public void setValid(java.lang.String value) {
		this.valid = value;
	}
	
	public java.util.Date getValiddateBegin() {
		return this.validdateBegin;
	}
	
	public void setValiddateBegin(java.util.Date value) {
		this.validdateBegin = value;
	}	
	
	public java.util.Date getValiddateEnd() {
		return this.validdateEnd;
	}
	
	public void setValiddateEnd(java.util.Date value) {
		this.validdateEnd = value;
	}
	
	public java.lang.Integer getSellnum() {
		return this.sellnum;
	}
	
	public void setSellnum(java.lang.Integer value) {
		this.sellnum = value;
	}
	
	public java.lang.Double getCostprice() {
		return this.costprice;
	}
	
	public void setCostprice(java.lang.Double value) {
		this.costprice = value;
	}
	
	public java.lang.Double getOriginalprice() {
		return this.originalprice;
	}
	
	public void setOriginalprice(java.lang.Double value) {
		this.originalprice = value;
	}
	
	public java.lang.Double getSaleprice() {
		return this.saleprice;
	}
	
	public void setSaleprice(java.lang.Double value) {
		this.saleprice = value;
	}
	
	public java.lang.Double getBuyprice() {
		return this.buyprice;
	}
	
	public void setBuyprice(java.lang.Double value) {
		this.buyprice = value;
	}
	
	public java.lang.Integer getScore() {
		return this.score;
	}
	
	public void setScore(java.lang.Integer value) {
		this.score = value;
	}
	
	public java.lang.Integer getListorder() {
		return this.listorder;
	}
	
	public void setListorder(java.lang.Integer value) {
		this.listorder = value;
	}
	
	public java.lang.String getIsdeleted() {
		return this.isdeleted;
	}
	
	public void setIsdeleted(java.lang.String value) {
		this.isdeleted = value;
	}
	
	public java.lang.Integer getSource() {
		return this.source;
	}
	
	public void setSource(java.lang.Integer value) {
		this.source = value;
	}
	
	public java.lang.Long getItemId() {
		return this.itemId;
	}
	
	public void setItemId(java.lang.Long value) {
		this.itemId = value;
	}
	
	public java.lang.String getIsprice() {
		return this.isprice;
	}
	
	public void setIsprice(java.lang.String value) {
		this.isprice = value;
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
	
	public java.lang.Integer getComment() {
		return this.comment;
	}
	
	public void setComment(java.lang.Integer value) {
		this.comment = value;
	}
	
	public java.lang.Integer getGood() {
		return this.good;
	}
	
	public void setGood(java.lang.Integer value) {
		this.good = value;
	}
	
	public java.lang.Integer getComm() {
		return this.comm;
	}
	
	public void setComm(java.lang.Integer value) {
		this.comm = value;
	}
	
	public java.lang.Integer getBad() {
		return this.bad;
	}
	
	public void setBad(java.lang.Integer value) {
		this.bad = value;
	}
	
	public java.lang.Integer getStock() {
		return this.stock;
	}
	
	public void setStock(java.lang.Integer value) {
		this.stock = value;
	}
	
}

