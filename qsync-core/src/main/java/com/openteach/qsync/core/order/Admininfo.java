/*
 * Powered By china-telcom
 * Since 2012 - 2014
 */

package com.openteach.qsync.core.order;

import com.openteach.qsync.core.order.Admininfo;
import com.openteach.qsync.core.order.AdmininfoDao;
import com.openteach.qsync.core.order.AdmininfoManager;
import com.openteach.qsync.core.order.AdmininfoQuery;


/**
 *
 * @author dingp email:dingp@51box.cn
 * @version 1.0
 * @since 1.0
 * */
public class Admininfo {
	
	//alias
	public static final String TABLE_ALIAS = "Admininfo";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_NAME = "name";
	public static final String ALIAS_PASSWORD = "password";
	public static final String ALIAS_TRUENAME = "truename";
	public static final String ALIAS_TELEPHONE = "telephone";
	public static final String ALIAS_HANDPHONE = "handphone";
	public static final String ALIAS_QQ = "qq";
	public static final String ALIAS_ALIWW = "aliww";
	public static final String ALIAS_EMAIL = "email";
	public static final String ALIAS_LASTLOGTIME = "lastlogtime";
	public static final String ALIAS_ISDELETED = "isdeleted";
	public static final String ALIAS_ROLE_ID = "roleId";
	public static final String ALIAS_DEPART_ID = "departId";
	
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
     * password       db_column: password 
     */	
	private java.lang.String password;
    /**
     * truename       db_column: truename 
     */	
	private java.lang.String truename;
    /**
     * telephone       db_column: telephone 
     */	
	private java.lang.String telephone;
    /**
     * handphone       db_column: handphone 
     */	
	private java.lang.String handphone;
    /**
     * qq       db_column: qq 
     */	
	private java.lang.String qq;
    /**
     * aliww       db_column: aliww 
     */	
	private java.lang.String aliww;
    /**
     * email       db_column: email 
     */	
	private java.lang.String email;
    /**
     * lastlogtime       db_column: lastlogtime 
     */	
	private java.util.Date lastlogtime;
    /**
     * isdeleted       db_column: isdeleted 
     */	
	private java.lang.String isdeleted;
    /**
     * roleId       db_column: role_id 
     */	
	private java.lang.Long roleId;
    /**
     * departId       db_column: depart_id 
     */	
	private java.lang.Long departId;
	//columns END

	public Admininfo(){
	}

	public Admininfo(
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
	public void setPassword(java.lang.String value) {
		this.password = value;
	}
	public java.lang.String getPassword() {
		return this.password;
	}
	public void setTruename(java.lang.String value) {
		this.truename = value;
	}
	public java.lang.String getTruename() {
		return this.truename;
	}
	public void setTelephone(java.lang.String value) {
		this.telephone = value;
	}
	public java.lang.String getTelephone() {
		return this.telephone;
	}
	public void setHandphone(java.lang.String value) {
		this.handphone = value;
	}
	public java.lang.String getHandphone() {
		return this.handphone;
	}
	public void setQq(java.lang.String value) {
		this.qq = value;
	}
	public java.lang.String getQq() {
		return this.qq;
	}
	public void setAliww(java.lang.String value) {
		this.aliww = value;
	}
	public java.lang.String getAliww() {
		return this.aliww;
	}
	public void setEmail(java.lang.String value) {
		this.email = value;
	}
	public java.lang.String getEmail() {
		return this.email;
	}
	public void setLastlogtime(java.util.Date value) {
		this.lastlogtime = value;
	}
	public java.util.Date getLastlogtime() {
		return this.lastlogtime;
	}
	public void setIsdeleted(java.lang.String value) {
		this.isdeleted = value;
	}
	public java.lang.String getIsdeleted() {
		return this.isdeleted;
	}
	public void setRoleId(java.lang.Long value) {
		this.roleId = value;
	}
	public java.lang.Long getRoleId() {
		return this.roleId;
	}
	public void setDepartId(java.lang.Long value) {
		this.departId = value;
	}
	public java.lang.Long getDepartId() {
		return this.departId;
	}
	
	private Set provinces = new HashSet(0);
	public void setProvinces(Set<Province> province){
		this.provinces = province;
	}
	
	public Set<Province> getProvinces() {
		return provinces;
	}
	
	private Set categoryValues = new HashSet(0);
	public void setCategoryValues(Set<CategoryValue> categoryValue){
		this.categoryValues = categoryValue;
	}
	
	public Set<CategoryValue> getCategoryValues() {
		return categoryValues;
	}
	
	private Set skuMessages = new HashSet(0);
	public void setSkuMessages(Set<SkuMessage> skuMessage){
		this.skuMessages = skuMessage;
	}
	
	public Set<SkuMessage> getSkuMessages() {
		return skuMessages;
	}
	
	private Set articles = new HashSet(0);
	public void setArticles(Set<Article> article){
		this.articles = article;
	}
	
	public Set<Article> getArticles() {
		return articles;
	}
	
	private Set salesmans = new HashSet(0);
	public void setSalesmans(Set<Salesman> salesman){
		this.salesmans = salesman;
	}
	
	public Set<Salesman> getSalesmans() {
		return salesmans;
	}
	
	private Set purchaseSkus = new HashSet(0);
	public void setPurchaseSkus(Set<PurchaseSku> purchaseSku){
		this.purchaseSkus = purchaseSku;
	}
	
	public Set<PurchaseSku> getPurchaseSkus() {
		return purchaseSkus;
	}
	
	private Set messageModels = new HashSet(0);
	public void setMessageModels(Set<MessageModel> messageModel){
		this.messageModels = messageModel;
	}
	
	public Set<MessageModel> getMessageModels() {
		return messageModels;
	}
	
	private Set logisticsAddressers = new HashSet(0);
	public void setLogisticsAddressers(Set<LogisticsAddresser> logisticsAddresser){
		this.logisticsAddressers = logisticsAddresser;
	}
	
	public Set<LogisticsAddresser> getLogisticsAddressers() {
		return logisticsAddressers;
	}
	
	private Set categoryProps = new HashSet(0);
	public void setCategoryProps(Set<CategoryProp> categoryProp){
		this.categoryProps = categoryProp;
	}
	
	public Set<CategoryProp> getCategoryProps() {
		return categoryProps;
	}
	
	private Set saless = new HashSet(0);
	public void setSaless(Set<Sales> sales){
		this.saless = sales;
	}
	
	public Set<Sales> getSaless() {
		return saless;
	}
	
	private Set discountgroups = new HashSet(0);
	public void setDiscountgroups(Set<Discountgroup> discountgroup){
		this.discountgroups = discountgroup;
	}
	
	public Set<Discountgroup> getDiscountgroups() {
		return discountgroups;
	}
	
	private Set brands = new HashSet(0);
	public void setBrands(Set<Brand> brand){
		this.brands = brand;
	}
	
	public Set<Brand> getBrands() {
		return brands;
	}
	
	private Set postages = new HashSet(0);
	public void setPostages(Set<Postage> postage){
		this.postages = postage;
	}
	
	public Set<Postage> getPostages() {
		return postages;
	}
	
	private Set bathcoupons = new HashSet(0);
	public void setBathcoupons(Set<Bathcoupon> bathcoupon){
		this.bathcoupons = bathcoupon;
	}
	
	public Set<Bathcoupon> getBathcoupons() {
		return bathcoupons;
	}
	
	private Set activitys = new HashSet(0);
	public void setActivitys(Set<Activity> activity){
		this.activitys = activity;
	}
	
	public Set<Activity> getActivitys() {
		return activitys;
	}
	
	private Set orderStatuss = new HashSet(0);
	public void setOrderStatuss(Set<OrderStatus> orderStatus){
		this.orderStatuss = orderStatus;
	}
	
	public Set<OrderStatus> getOrderStatuss() {
		return orderStatuss;
	}
	
	private Set adverts = new HashSet(0);
	public void setAdverts(Set<Advert> advert){
		this.adverts = advert;
	}
	
	public Set<Advert> getAdverts() {
		return adverts;
	}
	
	private Set checkSkuStocks = new HashSet(0);
	public void setCheckSkuStocks(Set<CheckSkuStock> checkSkuStock){
		this.checkSkuStocks = checkSkuStock;
	}
	
	public Set<CheckSkuStock> getCheckSkuStocks() {
		return checkSkuStocks;
	}
	
	private Set districts = new HashSet(0);
	public void setDistricts(Set<District> district){
		this.districts = district;
	}
	
	public Set<District> getDistricts() {
		return districts;
	}
	
	private Set orderReturns = new HashSet(0);
	public void setOrderReturns(Set<OrderReturn> orderReturn){
		this.orderReturns = orderReturn;
	}
	
	public Set<OrderReturn> getOrderReturns() {
		return orderReturns;
	}
	
	private Set skuStocks = new HashSet(0);
	public void setSkuStocks(Set<SkuStock> skuStock){
		this.skuStocks = skuStock;
	}
	
	public Set<SkuStock> getSkuStocks() {
		return skuStocks;
	}
	
	private Set letters = new HashSet(0);
	public void setLetters(Set<Letter> letter){
		this.letters = letter;
	}
	
	public Set<Letter> getLetters() {
		return letters;
	}
	
	private Set logisticss = new HashSet(0);
	public void setLogisticss(Set<Logistics> logistics){
		this.logisticss = logistics;
	}
	
	public Set<Logistics> getLogisticss() {
		return logisticss;
	}
	
	private Set returnNotes = new HashSet(0);
	public void setReturnNotes(Set<ReturnNote> returnNote){
		this.returnNotes = returnNote;
	}
	
	public Set<ReturnNote> getReturnNotes() {
		return returnNotes;
	}
	
	private Set messageGroups = new HashSet(0);
	public void setMessageGroups(Set<MessageGroup> messageGroup){
		this.messageGroups = messageGroup;
	}
	
	public Set<MessageGroup> getMessageGroups() {
		return messageGroups;
	}
	
	private Set finalstatements = new HashSet(0);
	public void setFinalstatements(Set<Finalstatement> finalstatement){
		this.finalstatements = finalstatement;
	}
	
	public Set<Finalstatement> getFinalstatements() {
		return finalstatements;
	}
	
	private Set articles = new HashSet(0);
	public void setArticles(Set<Article> article){
		this.articles = article;
	}
	
	public Set<Article> getArticles() {
		return articles;
	}
	
	private Set skuPics = new HashSet(0);
	public void setSkuPics(Set<SkuPic> skuPic){
		this.skuPics = skuPic;
	}
	
	public Set<SkuPic> getSkuPics() {
		return skuPics;
	}
	
	private Set shopClassifys = new HashSet(0);
	public void setShopClassifys(Set<ShopClassify> shopClassify){
		this.shopClassifys = shopClassify;
	}
	
	public Set<ShopClassify> getShopClassifys() {
		return shopClassifys;
	}
	
	private Set shippingItems = new HashSet(0);
	public void setShippingItems(Set<ShippingItem> shippingItem){
		this.shippingItems = shippingItem;
	}
	
	public Set<ShippingItem> getShippingItems() {
		return shippingItems;
	}
	
	private Set orderReturns = new HashSet(0);
	public void setOrderReturns(Set<OrderReturn> orderReturn){
		this.orderReturns = orderReturn;
	}
	
	public Set<OrderReturn> getOrderReturns() {
		return orderReturns;
	}
	
	private Set logisticss = new HashSet(0);
	public void setLogisticss(Set<Logistics> logistics){
		this.logisticss = logistics;
	}
	
	public Set<Logistics> getLogisticss() {
		return logisticss;
	}
	
	private Set categoryProps = new HashSet(0);
	public void setCategoryProps(Set<CategoryProp> categoryProp){
		this.categoryProps = categoryProp;
	}
	
	public Set<CategoryProp> getCategoryProps() {
		return categoryProps;
	}
	
	private Set articleClasss = new HashSet(0);
	public void setArticleClasss(Set<ArticleClass> articleClass){
		this.articleClasss = articleClass;
	}
	
	public Set<ArticleClass> getArticleClasss() {
		return articleClasss;
	}
	
	private Set payments = new HashSet(0);
	public void setPayments(Set<Payment> payment){
		this.payments = payment;
	}
	
	public Set<Payment> getPayments() {
		return payments;
	}
	
	private Set batchRechargeCards = new HashSet(0);
	public void setBatchRechargeCards(Set<BatchRechargeCard> batchRechargeCard){
		this.batchRechargeCards = batchRechargeCard;
	}
	
	public Set<BatchRechargeCard> getBatchRechargeCards() {
		return batchRechargeCards;
	}
	
	private Set batchMemberCards = new HashSet(0);
	public void setBatchMemberCards(Set<BatchMemberCard> batchMemberCard){
		this.batchMemberCards = batchMemberCard;
	}
	
	public Set<BatchMemberCard> getBatchMemberCards() {
		return batchMemberCards;
	}
	
	private Set saless = new HashSet(0);
	public void setSaless(Set<Sales> sales){
		this.saless = sales;
	}
	
	public Set<Sales> getSaless() {
		return saless;
	}
	
	private Set memberGrades = new HashSet(0);
	public void setMemberGrades(Set<MemberGrade> memberGrade){
		this.memberGrades = memberGrade;
	}
	
	public Set<MemberGrade> getMemberGrades() {
		return memberGrades;
	}
	
	private Set purchaseOrders = new HashSet(0);
	public void setPurchaseOrders(Set<PurchaseOrder> purchaseOrder){
		this.purchaseOrders = purchaseOrder;
	}
	
	public Set<PurchaseOrder> getPurchaseOrders() {
		return purchaseOrders;
	}
	
	private Set insaless = new HashSet(0);
	public void setInsaless(Set<Insales> insales){
		this.insaless = insales;
	}
	
	public Set<Insales> getInsaless() {
		return insaless;
	}
	
	private Set busmanGoldcoinApplys = new HashSet(0);
	public void setBusmanGoldcoinApplys(Set<BusmanGoldcoinApply> busmanGoldcoinApply){
		this.busmanGoldcoinApplys = busmanGoldcoinApply;
	}
	
	public Set<BusmanGoldcoinApply> getBusmanGoldcoinApplys() {
		return busmanGoldcoinApplys;
	}
	
	private Set skuMessages = new HashSet(0);
	public void setSkuMessages(Set<SkuMessage> skuMessage){
		this.skuMessages = skuMessage;
	}
	
	public Set<SkuMessage> getSkuMessages() {
		return skuMessages;
	}
	
	private Set commskus = new HashSet(0);
	public void setCommskus(Set<Commsku> commsku){
		this.commskus = commsku;
	}
	
	public Set<Commsku> getCommskus() {
		return commskus;
	}
	
	private Set pageMentions = new HashSet(0);
	public void setPageMentions(Set<PageMention> pageMention){
		this.pageMentions = pageMention;
	}
	
	public Set<PageMention> getPageMentions() {
		return pageMentions;
	}
	
	private Set shippingItems = new HashSet(0);
	public void setShippingItems(Set<ShippingItem> shippingItem){
		this.shippingItems = shippingItem;
	}
	
	public Set<ShippingItem> getShippingItems() {
		return shippingItems;
	}
	
	private Set shopMessages = new HashSet(0);
	public void setShopMessages(Set<ShopMessage> shopMessage){
		this.shopMessages = shopMessage;
	}
	
	public Set<ShopMessage> getShopMessages() {
		return shopMessages;
	}
	
	private Set shippings = new HashSet(0);
	public void setShippings(Set<Shipping> shipping){
		this.shippings = shipping;
	}
	
	public Set<Shipping> getShippings() {
		return shippings;
	}
	
	private Set categorys = new HashSet(0);
	public void setCategorys(Set<Category> category){
		this.categorys = category;
	}
	
	public Set<Category> getCategorys() {
		return categorys;
	}
	
	private Set busmanConsumeRecords = new HashSet(0);
	public void setBusmanConsumeRecords(Set<BusmanConsumeRecord> busmanConsumeRecord){
		this.busmanConsumeRecords = busmanConsumeRecord;
	}
	
	public Set<BusmanConsumeRecord> getBusmanConsumeRecords() {
		return busmanConsumeRecords;
	}
	
	private Set logisticsAddressers = new HashSet(0);
	public void setLogisticsAddressers(Set<LogisticsAddresser> logisticsAddresser){
		this.logisticsAddressers = logisticsAddresser;
	}
	
	public Set<LogisticsAddresser> getLogisticsAddressers() {
		return logisticsAddressers;
	}
	
	private Set emails = new HashSet(0);
	public void setEmails(Set<Email> email){
		this.emails = email;
	}
	
	public Set<Email> getEmails() {
		return emails;
	}
	
	private Set storehouseins = new HashSet(0);
	public void setStorehouseins(Set<Storehousein> storehousein){
		this.storehouseins = storehousein;
	}
	
	public Set<Storehousein> getStorehouseins() {
		return storehouseins;
	}
	
	private Set orders = new HashSet(0);
	public void setOrders(Set<Order> order){
		this.orders = order;
	}
	
	public Set<Order> getOrders() {
		return orders;
	}
	
	private Set drawbacks = new HashSet(0);
	public void setDrawbacks(Set<Drawback> drawback){
		this.drawbacks = drawback;
	}
	
	public Set<Drawback> getDrawbacks() {
		return drawbacks;
	}
	
	private Set keyWords = new HashSet(0);
	public void setKeyWords(Set<KeyWord> keyWord){
		this.keyWords = keyWord;
	}
	
	public Set<KeyWord> getKeyWords() {
		return keyWords;
	}
	
	private Set storehouses = new HashSet(0);
	public void setStorehouses(Set<Storehouse> storehouse){
		this.storehouses = storehouse;
	}
	
	public Set<Storehouse> getStorehouses() {
		return storehouses;
	}
	
	private Set adverts = new HashSet(0);
	public void setAdverts(Set<Advert> advert){
		this.adverts = advert;
	}
	
	public Set<Advert> getAdverts() {
		return adverts;
	}
	
	private Set suppliers = new HashSet(0);
	public void setSuppliers(Set<Supplier> supplier){
		this.suppliers = supplier;
	}
	
	public Set<Supplier> getSuppliers() {
		return suppliers;
	}
	
	private Set articleClasss = new HashSet(0);
	public void setArticleClasss(Set<ArticleClass> articleClass){
		this.articleClasss = articleClass;
	}
	
	public Set<ArticleClass> getArticleClasss() {
		return articleClasss;
	}
	
	private Set brands = new HashSet(0);
	public void setBrands(Set<Brand> brand){
		this.brands = brand;
	}
	
	public Set<Brand> getBrands() {
		return brands;
	}
	
	private Set storehouseTransfers = new HashSet(0);
	public void setStorehouseTransfers(Set<StorehouseTransfer> storehouseTransfer){
		this.storehouseTransfers = storehouseTransfer;
	}
	
	public Set<StorehouseTransfer> getStorehouseTransfers() {
		return storehouseTransfers;
	}
	
	private Set storehouseWastes = new HashSet(0);
	public void setStorehouseWastes(Set<StorehouseWaste> storehouseWaste){
		this.storehouseWastes = storehouseWaste;
	}
	
	public Set<StorehouseWaste> getStorehouseWastes() {
		return storehouseWastes;
	}
	
	private Set activitys = new HashSet(0);
	public void setActivitys(Set<Activity> activity){
		this.activitys = activity;
	}
	
	public Set<Activity> getActivitys() {
		return activitys;
	}
	
	private Set memberGroups = new HashSet(0);
	public void setMemberGroups(Set<MemberGroup> memberGroup){
		this.memberGroups = memberGroup;
	}
	
	public Set<MemberGroup> getMemberGroups() {
		return memberGroups;
	}
	
	private Set countrys = new HashSet(0);
	public void setCountrys(Set<Country> country){
		this.countrys = country;
	}
	
	public Set<Country> getCountrys() {
		return countrys;
	}
	
	private Set discountgroups = new HashSet(0);
	public void setDiscountgroups(Set<Discountgroup> discountgroup){
		this.discountgroups = discountgroup;
	}
	
	public Set<Discountgroup> getDiscountgroups() {
		return discountgroups;
	}
	
	private Set commskus = new HashSet(0);
	public void setCommskus(Set<Commsku> commsku){
		this.commskus = commsku;
	}
	
	public Set<Commsku> getCommskus() {
		return commskus;
	}
	
	private Set orderStatuss = new HashSet(0);
	public void setOrderStatuss(Set<OrderStatus> orderStatus){
		this.orderStatuss = orderStatus;
	}
	
	public Set<OrderStatus> getOrderStatuss() {
		return orderStatuss;
	}
	
	private Set onlineservices = new HashSet(0);
	public void setOnlineservices(Set<Onlineservice> onlineservice){
		this.onlineservices = onlineservice;
	}
	
	public Set<Onlineservice> getOnlineservices() {
		return onlineservices;
	}
	
	private Set returnNotes = new HashSet(0);
	public void setReturnNotes(Set<ReturnNote> returnNote){
		this.returnNotes = returnNote;
	}
	
	public Set<ReturnNote> getReturnNotes() {
		return returnNotes;
	}
	
	private Set categoryValues = new HashSet(0);
	public void setCategoryValues(Set<CategoryValue> categoryValue){
		this.categoryValues = categoryValue;
	}
	
	public Set<CategoryValue> getCategoryValues() {
		return categoryValues;
	}
	
	private Set commoditys = new HashSet(0);
	public void setCommoditys(Set<Commodity> commodity){
		this.commoditys = commodity;
	}
	
	public Set<Commodity> getCommoditys() {
		return commoditys;
	}
	
	private Set postages = new HashSet(0);
	public void setPostages(Set<Postage> postage){
		this.postages = postage;
	}
	
	public Set<Postage> getPostages() {
		return postages;
	}
	
	private Set missionorderss = new HashSet(0);
	public void setMissionorderss(Set<Missionorders> missionorders){
		this.missionorderss = missionorders;
	}
	
	public Set<Missionorders> getMissionorderss() {
		return missionorderss;
	}
	
	private Set goleScopes = new HashSet(0);
	public void setGoleScopes(Set<GoleScope> goleScope){
		this.goleScopes = goleScope;
	}
	
	public Set<GoleScope> getGoleScopes() {
		return goleScopes;
	}
	
	private Set shopapplyStatuss = new HashSet(0);
	public void setShopapplyStatuss(Set<ShopapplyStatus> shopapplyStatus){
		this.shopapplyStatuss = shopapplyStatus;
	}
	
	public Set<ShopapplyStatus> getShopapplyStatuss() {
		return shopapplyStatuss;
	}
	
	private Set categorys = new HashSet(0);
	public void setCategorys(Set<Category> category){
		this.categorys = category;
	}
	
	public Set<Category> getCategorys() {
		return categorys;
	}
	
	private Set rechargeCards = new HashSet(0);
	public void setRechargeCards(Set<RechargeCard> rechargeCard){
		this.rechargeCards = rechargeCard;
	}
	
	public Set<RechargeCard> getRechargeCards() {
		return rechargeCards;
	}
	
	private Set orders = new HashSet(0);
	public void setOrders(Set<Order> order){
		this.orders = order;
	}
	
	public Set<Order> getOrders() {
		return orders;
	}
	
	private Set busmanRechargeRecords = new HashSet(0);
	public void setBusmanRechargeRecords(Set<BusmanRechargeRecord> busmanRechargeRecord){
		this.busmanRechargeRecords = busmanRechargeRecord;
	}
	
	public Set<BusmanRechargeRecord> getBusmanRechargeRecords() {
		return busmanRechargeRecords;
	}
	
	private Set purchaseReturnOrders = new HashSet(0);
	public void setPurchaseReturnOrders(Set<PurchaseReturnOrder> purchaseReturnOrder){
		this.purchaseReturnOrders = purchaseReturnOrder;
	}
	
	public Set<PurchaseReturnOrder> getPurchaseReturnOrders() {
		return purchaseReturnOrders;
	}
	
	private Set groups = new HashSet(0);
	public void setGroups(Set<Group> group){
		this.groups = group;
	}
	
	public Set<Group> getGroups() {
		return groups;
	}
	
	private Set groups = new HashSet(0);
	public void setGroups(Set<Group> group){
		this.groups = group;
	}
	
	public Set<Group> getGroups() {
		return groups;
	}
	
	private Set smss = new HashSet(0);
	public void setSmss(Set<Sms> sms){
		this.smss = sms;
	}
	
	public Set<Sms> getSmss() {
		return smss;
	}
	
	private Set storehouseouts = new HashSet(0);
	public void setStorehouseouts(Set<Storehouseout> storehouseout){
		this.storehouseouts = storehouseout;
	}
	
	public Set<Storehouseout> getStorehouseouts() {
		return storehouseouts;
	}
	
	private Set adminlogs = new HashSet(0);
	public void setAdminlogs(Set<Adminlog> adminlog){
		this.adminlogs = adminlog;
	}
	
	public Set<Adminlog> getAdminlogs() {
		return adminlogs;
	}
	
	private Set insaless = new HashSet(0);
	public void setInsaless(Set<Insales> insales){
		this.insaless = insales;
	}
	
	public Set<Insales> getInsaless() {
		return insaless;
	}
	
	private Set shippings = new HashSet(0);
	public void setShippings(Set<Shipping> shipping){
		this.shippings = shipping;
	}
	
	public Set<Shipping> getShippings() {
		return shippings;
	}
	
	private Department department;
	
	public void setDepartment(Department department){
		this.department = department;
	}
	
	public Department getDepartment() {
		return department;
	}
	
	private Role role;
	
	public void setRole(Role role){
		this.role = role;
	}
	
	public Role getRole() {
		return role;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Admininfo == false) return false;
		if(this == obj) return true;
		Admininfo other = (Admininfo)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

