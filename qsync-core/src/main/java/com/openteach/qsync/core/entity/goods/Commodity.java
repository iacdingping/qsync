package com.openteach.qsync.core.entity.goods;

import javax.validation.constraints.NotNull;



/**
 *
 * @author dingp email:dingp@51box.cn
 * @version 1.0
 * @since 1.0
 * */
public class Commodity {
	
	//alias
	public static final String TABLE_ALIAS = "Commodity";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_NAME = "name";
	public static final String ALIAS_ITEMCODE = "itemcode";
	public static final String ALIAS_DESCRIPTION = "description";
	public static final String ALIAS_PKGLIST = "pkglist";
	public static final String ALIAS_SELLSERVICE = "sellservice";
	public static final String ALIAS_PROPS = "props";
	public static final String ALIAS_PROPS_NAME = "propsName";
	public static final String ALIAS_CID = "cid";
	public static final String ALIAS_CLASSALL = "classall";
	public static final String ALIAS_LISTORDER = "listorder";
	public static final String ALIAS_ISDELETED = "isdeleted";
	public static final String ALIAS_SOURCE = "source";
	public static final String ALIAS_BRAND_ID = "brandId";
	public static final String ALIAS_CATEGORY_ID = "categoryId";
	public static final String ALIAS_ORIGINALPRICE = "originalprice";
	public static final String ALIAS_SALEPRICE = "saleprice";
	public static final String ALIAS_VALID = "valid";
	public static final String ALIAS_AUDIT = "audit";
	public static final String ALIAS_SHOP_ID = "shopId";
	public static final String ALIAS_SALE_NUMBER = "saleNumber";
	public static final String ALIAS_STOCK = "stock";
	public static final String ALIAS_SHOP_HOT_RECOMMEND = "shopHotRecommend";
	public static final String ALIAS_VALID_TIME = "validTime";
	public static final String ALIAS_AUDIT_TIME = "auditTime";
	public static final String ALIAS_LAST_TRADING_TIME = "lastTradingTime";
	public static final String ALIAS_UPDATEDATETIME = "updatedatetime";
	public static final String ALIAS_CREATEDATETIME = "createdatetime";
	public static final String ALIAS_CREATORADMIN = "creatoradmin";
	public static final String ALIAS_MODIFIERADMIN = "modifieradmin";
	public static final String ALIAS_PICURL = "picurl";
	public static final String ALIAS_INFO = "info";
	public static final String ALIAS_FOOTSIZE = "footsize";
	public static final String ALIAS_FOOTSIZEMAX = "footsizemax";
	public static final String ALIAS_DESIGNTIME = "designtime";
	public static final String ALIAS_PORT = "port";
	public static final String ALIAS_SUPPLYABILITY = "supplyability";
	public static final String ALIAS_FALAGECOMMODITY = "falagecommodity";
	public static final String ALIAS_SIZEPAIRS = "sizepairs";
	public static final String ALIAS_MINIMUM = "minimum";
	public static final String ALIAS_PREPAREMUM = "preparemum";
	public static final String ALIAS_PREPARETIME = "preparetime";
	public static final String ALIAS_ORDERUNIT = "orderunit";
	public static final String ALIAS_SEOKEYWORD = "seokeyword";
	public static final String ALIAS_SEODESCRIPTION = "seodescription";
	public static final String ALIAS_VONDORCODE = "vondorcode";
	public static final String ALIAS_LENGTH = "length";
	public static final String ALIAS_WIDTH = "width";
	public static final String ALIAS_HEIGHT = "height";
	public static final String ALIAS_WEIGHT = "weight";
	public static final String ALIAS_TARIFF = "行邮税号 必须已备案，且与参数说明文档中的行邮税号中的税号一致";
	public static final String ALIAS_SALES_COUNTRY = "产销国";
	public static final String ALIAS_UNIT = "申报计量单位 见计量单位代码";
	public static final String ALIAS_UNIT_DESC = "申报计量单位描述";
	public static final String ALIAS_SPECIFICATION = "商品规格、型号";
	
	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START
    /**
     * id       db_column: id 
     */	
	private java.lang.Long id;
    /**
     * name       db_column: name 
     */	
	private java.lang.String name;
    /**
     * itemcode       db_column: itemcode 
     */	
	@NotNull
	private java.lang.String itemcode;
    /**
     * description       db_column: description 
     */	
	private java.lang.String description;
    /**
     * pkglist       db_column: pkglist 
     */	
	private java.lang.String pkglist;
    /**
     * sellservice       db_column: sellservice 
     */	
	private java.lang.String sellservice;
    /**
     * props       db_column: props 
     */	
	private java.lang.String props;
    /**
     * propsName       db_column: props_name 
     */	
	private java.lang.String propsName;
    /**
     * cid       db_column: cid 
     */	
	private java.lang.Long cid;
    /**
     * classall       db_column: classall 
     */	
	private java.lang.String classall;
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
     * brandId       db_column: brand_id 
     */	
	private java.lang.Long brandId;
    /**
     * categoryId       db_column: category_id 
     */	
	private java.lang.Long categoryId;
    /**
     * originalprice       db_column: originalprice 
     */	
	private java.lang.Double originalprice;
    /**
     * saleprice       db_column: saleprice 
     */	
	private java.lang.Double saleprice;
    /**
     * valid       db_column: valid 
     */	
	private java.lang.String valid;
    /**
     * audit       db_column: audit 
     */	
	private java.lang.Integer audit;
    /**
     * shopId       db_column: shop_id 
     */	
	private java.lang.Long shopId;
    /**
     * saleNumber       db_column: sale_number 
     */	
	private java.lang.Integer saleNumber;
    /**
     * stock       db_column: stock 
     */	
	private java.lang.Integer stock;
    /**
     * shopHotRecommend       db_column: shop_hot_recommend 
     */	
	private java.lang.String shopHotRecommend;
    /**
     * validTime       db_column: valid_time 
     */	
	private java.util.Date validTime;
    /**
     * auditTime       db_column: audit_time 
     */	
	private java.util.Date auditTime;
    /**
     * lastTradingTime       db_column: last_trading_time 
     */	
	private java.util.Date lastTradingTime;
    /**
     * updatedatetime       db_column: updatedatetime 
     */	
	private java.util.Date updatedatetime;
    /**
     * createdatetime       db_column: createdatetime 
     */	
	private java.util.Date createdatetime;
    /**
     * creatoradmin       db_column: creatoradmin 
     */	
	private java.lang.Long creatoradmin;
    /**
     * modifieradmin       db_column: modifieradmin 
     */	
	private java.lang.Long modifieradmin;
    /**
     * picurl       db_column: picurl 
     */	
	private java.lang.String picurl;
    /**
     * info       db_column: info 
     */	
	private java.lang.String info;
    /**
     * footsize       db_column: footsize 
     */	
	private java.lang.String footsize;
    /**
     * footsizemax       db_column: footsizemax 
     */	
	private java.lang.String footsizemax;
    /**
     * designtime       db_column: designtime 
     */	
	private java.lang.String designtime;
    /**
     * port       db_column: port 
     */	
	private java.lang.String port;
    /**
     * supplyability       db_column: supplyability 
     */	
	private java.lang.String supplyability;
    /**
     * falagecommodity       db_column: falagecommodity 
     */	
	private java.lang.Integer falagecommodity;
    /**
     * sizepairs       db_column: sizepairs 
     */	
	private java.lang.Integer sizepairs;
    /**
     * minimum       db_column: minimum 
     */	
	private java.lang.Integer minimum;
    /**
     * preparemum       db_column: preparemum 
     */	
	private java.lang.Integer preparemum;
    /**
     * preparetime       db_column: preparetime 
     */	
	private java.lang.Integer preparetime;
    /**
     * orderunit       db_column: orderunit 
     */	
	private java.lang.Integer orderunit;
    /**
     * seokeyword       db_column: seokeyword 
     */	
	private java.lang.String seokeyword;
    /**
     * seodescription       db_column: seodescription 
     */	
	private java.lang.String seodescription;
    /**
     * vondorcode       db_column: vondorcode 
     */	
	private java.lang.String vondorcode;
    /**
     * length       db_column: length 
     */	
	private java.lang.Double length;
    /**
     * width       db_column: width 
     */	
	private java.lang.Double width;
    /**
     * height       db_column: height 
     */	
	private java.lang.Double height;
    /**
     * weight       db_column: weight 
     */	
	@NotNull
	private java.lang.Integer weight;
    /**
     * 行邮税号 必须已备案，且与参数说明文档中的行邮税号中的税号一致       db_column: tariff 
     */	
	@NotNull
	private java.lang.String tariff;
    /**
     * 产销国       db_column: sales_country 
     */	
	@NotNull
	private java.lang.Long salesCountry;
    /**
     * 申报计量单位 见计量单位代码       db_column: unit 
     */	
	@NotNull
	private java.lang.String unit;
    /**
     * 申报计量单位描述       db_column: unit_desc 
     */	
	@NotNull
	private java.lang.String unitDesc;
    /**
     * 商品规格、型号       db_column: specification 
     */	
	@NotNull
	private java.lang.String specification;
	//columns END

	public Commodity(){
	}

	public Commodity(
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
	public void setName(java.lang.String value) {
		this.name = value;
	}
	public java.lang.String getName() {
		return this.name;
	}
	public void setItemcode(java.lang.String value) {
		this.itemcode = value;
	}
	public java.lang.String getItemcode() {
		return this.itemcode;
	}
	public void setDescription(java.lang.String value) {
		this.description = value;
	}
	public java.lang.String getDescription() {
		return this.description;
	}
	public void setPkglist(java.lang.String value) {
		this.pkglist = value;
	}
	public java.lang.String getPkglist() {
		return this.pkglist;
	}
	public void setSellservice(java.lang.String value) {
		this.sellservice = value;
	}
	public java.lang.String getSellservice() {
		return this.sellservice;
	}
	public void setProps(java.lang.String value) {
		this.props = value;
	}
	public java.lang.String getProps() {
		return this.props;
	}
	public void setPropsName(java.lang.String value) {
		this.propsName = value;
	}
	public java.lang.String getPropsName() {
		return this.propsName;
	}
	public void setCid(java.lang.Long value) {
		this.cid = value;
	}
	public java.lang.Long getCid() {
		return this.cid;
	}
	public void setClassall(java.lang.String value) {
		this.classall = value;
	}
	public java.lang.String getClassall() {
		return this.classall;
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
	public void setBrandId(java.lang.Long value) {
		this.brandId = value;
	}
	public java.lang.Long getBrandId() {
		return this.brandId;
	}
	public void setCategoryId(java.lang.Long value) {
		this.categoryId = value;
	}
	public java.lang.Long getCategoryId() {
		return this.categoryId;
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
	public void setValid(java.lang.String value) {
		this.valid = value;
	}
	public java.lang.String getValid() {
		return this.valid;
	}
	public void setAudit(java.lang.Integer value) {
		this.audit = value;
	}
	public java.lang.Integer getAudit() {
		return this.audit;
	}
	public void setShopId(java.lang.Long value) {
		this.shopId = value;
	}
	public java.lang.Long getShopId() {
		return this.shopId;
	}
	public void setSaleNumber(java.lang.Integer value) {
		this.saleNumber = value;
	}
	public java.lang.Integer getSaleNumber() {
		return this.saleNumber;
	}
	public void setStock(java.lang.Integer value) {
		this.stock = value;
	}
	public java.lang.Integer getStock() {
		return this.stock;
	}
	public void setShopHotRecommend(java.lang.String value) {
		this.shopHotRecommend = value;
	}
	public java.lang.String getShopHotRecommend() {
		return this.shopHotRecommend;
	}
	public void setValidTime(java.util.Date value) {
		this.validTime = value;
	}
	public java.util.Date getValidTime() {
		return this.validTime;
	}
	public void setAuditTime(java.util.Date value) {
		this.auditTime = value;
	}
	public java.util.Date getAuditTime() {
		return this.auditTime;
	}
	public void setLastTradingTime(java.util.Date value) {
		this.lastTradingTime = value;
	}
	public java.util.Date getLastTradingTime() {
		return this.lastTradingTime;
	}
	public void setUpdatedatetime(java.util.Date value) {
		this.updatedatetime = value;
	}
	public java.util.Date getUpdatedatetime() {
		return this.updatedatetime;
	}
	public void setCreatedatetime(java.util.Date value) {
		this.createdatetime = value;
	}
	public java.util.Date getCreatedatetime() {
		return this.createdatetime;
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
	public void setPicurl(java.lang.String value) {
		this.picurl = value;
	}
	public java.lang.String getPicurl() {
		return this.picurl;
	}
	public void setInfo(java.lang.String value) {
		this.info = value;
	}
	public java.lang.String getInfo() {
		return this.info;
	}
	public void setFootsize(java.lang.String value) {
		this.footsize = value;
	}
	public java.lang.String getFootsize() {
		return this.footsize;
	}
	public void setFootsizemax(java.lang.String value) {
		this.footsizemax = value;
	}
	public java.lang.String getFootsizemax() {
		return this.footsizemax;
	}
	public void setDesigntime(java.lang.String value) {
		this.designtime = value;
	}
	public java.lang.String getDesigntime() {
		return this.designtime;
	}
	public void setPort(java.lang.String value) {
		this.port = value;
	}
	public java.lang.String getPort() {
		return this.port;
	}
	public void setSupplyability(java.lang.String value) {
		this.supplyability = value;
	}
	public java.lang.String getSupplyability() {
		return this.supplyability;
	}
	public void setFalagecommodity(java.lang.Integer value) {
		this.falagecommodity = value;
	}
	public java.lang.Integer getFalagecommodity() {
		return this.falagecommodity;
	}
	public void setSizepairs(java.lang.Integer value) {
		this.sizepairs = value;
	}
	public java.lang.Integer getSizepairs() {
		return this.sizepairs;
	}
	public void setMinimum(java.lang.Integer value) {
		this.minimum = value;
	}
	public java.lang.Integer getMinimum() {
		return this.minimum;
	}
	public void setPreparemum(java.lang.Integer value) {
		this.preparemum = value;
	}
	public java.lang.Integer getPreparemum() {
		return this.preparemum;
	}
	public void setPreparetime(java.lang.Integer value) {
		this.preparetime = value;
	}
	public java.lang.Integer getPreparetime() {
		return this.preparetime;
	}
	public void setOrderunit(java.lang.Integer value) {
		this.orderunit = value;
	}
	public java.lang.Integer getOrderunit() {
		return this.orderunit;
	}
	public void setSeokeyword(java.lang.String value) {
		this.seokeyword = value;
	}
	public java.lang.String getSeokeyword() {
		return this.seokeyword;
	}
	public void setSeodescription(java.lang.String value) {
		this.seodescription = value;
	}
	public java.lang.String getSeodescription() {
		return this.seodescription;
	}
	public void setVondorcode(java.lang.String value) {
		this.vondorcode = value;
	}
	public java.lang.String getVondorcode() {
		return this.vondorcode;
	}
	public void setLength(java.lang.Double value) {
		this.length = value;
	}
	public java.lang.Double getLength() {
		return this.length;
	}
	public void setWidth(java.lang.Double value) {
		this.width = value;
	}
	public java.lang.Double getWidth() {
		return this.width;
	}
	public void setHeight(java.lang.Double value) {
		this.height = value;
	}
	public java.lang.Double getHeight() {
		return this.height;
	}
	public void setWeight(java.lang.Integer value) {
		this.weight = value;
	}
	@NotNull
	public java.lang.Integer getWeight() {
		return this.weight;
	}
	public void setTariff(java.lang.String value) {
		this.tariff = value;
	}
	@NotNull
	public java.lang.String getTariff() {
		return this.tariff;
	}
	@NotNull
	public java.lang.Long getSalesCountry() {
		return salesCountry;
	}
	public void setSalesCountry(java.lang.Long salesCountry) {
		this.salesCountry = salesCountry;
	}
	public void setUnit(java.lang.String value) {
		this.unit = value;
	}
	@NotNull
	public java.lang.String getUnit() {
		return this.unit;
	}
	public void setUnitDesc(java.lang.String value) {
		this.unitDesc = value;
	}
	@NotNull
	public java.lang.String getUnitDesc() {
		return this.unitDesc;
	}
	public void setSpecification(java.lang.String value) {
		this.specification = value;
	}
	@NotNull
	public java.lang.String getSpecification() {
		return this.specification;
	}
}

