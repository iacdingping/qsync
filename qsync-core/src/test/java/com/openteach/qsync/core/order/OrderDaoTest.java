package com.openteach.qsync.core.order;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;

import com.openteach.qsync.core.SpringTransactionalTestCase;
import com.openteach.qsync.core.dao.order.OrderDao;
import com.openteach.qsync.core.entity.order.Order;
import com.openteach.qsync.core.query.order.OrderQuery;
import com.openteach.qsync.util.common.DateUtil;

/**
 * 
 * @author dingp email:dingp@51box.cn
 * @version 1.0
 * @since 1.0
 * */
@DirtiesContext
public class OrderDaoTest extends SpringTransactionalTestCase {
	@Autowired
	private OrderDao orderDao;

	@Test
	public void updateDeclareStatus() throws Exception {
		Map<String, Object> params = new HashMap<String, Object>(2);
		params.put("id", -1L);
		params.put("declareStatus", "test");
		int count = orderDao.updateDeclareStatus(params);
		assertEquals(count, 0);
	}
	
	/**
	 * 注意只能单个库测试 因为对删除使用到count方法计数进行对比
	 * 
	 * @throws Exception
	 */
	public void orderCurl() throws Exception {
		OrderQuery query = new OrderQuery();
		long startRows = orderDao.count(query);
		List<Order> lists = orderDao.list(query);
		assertEquals(lists.size(), startRows);

		Order order = new Order();
		/** id */
		/** code */
		order.setCode("1");
		/** appraise */
		order.setAppraise(1);
		/** content */
		order.setContent("1");
		/** ordertime */
		order.setOrdertime(new java.util.Date());
		/** remark */
		order.setRemark("1");
		/** gift */
		order.setGift("1");
		/** amount */
		/** cutamount */
		/** invoicetype */
		order.setInvoicetype(1);
		/** invoicecontent */
		order.setInvoicecontent("1");
		/** iscoupon */
		order.setIscoupon("1");
		/** paytime */
		order.setPaytime(new java.util.Date());
		/** onlinepay */
		order.setOnlinepay(1);
		/** returnStatus */
		order.setReturnStatus(1);
		/** payStatus */
		order.setPayStatus(1);
		/** payType */
		order.setPayType(1);
		/** transPrice */
		/** isBigOrder */
		order.setIsBigOrder("1");
		/** isPackage */
		order.setIsPackage("1");
		/** status */
		order.setStatus(1);
		/** source */
		order.setSource(1);
		/** replacement */
		order.setReplacement(1);
		/** isuserevaluate */
		order.setIsuserevaluate("1");
		/** isshopevaluate */
		order.setIsshopevaluate("1");
		/** member */
		order.setMember(1L);
		/** shopId */
		order.setShopId(1L);
		/** creatoradmin */
		order.setCreatoradmin(1L);
		/** modifieradmin */
		order.setModifieradmin(1L);
		/** createdatetime */
		order.setCreatedatetime(new java.util.Date());
		/** updatedatetime */
		order.setUpdatedatetime(new java.util.Date());
		/** ordertransport */
		order.setOrdertransport(1L);
		/** statementId */
		order.setStatementId(1L);
		/** isstatemented */
		order.setIsstatemented(1);
		/** ccgroupId */
		order.setCcgroupId(1L);
		/** ordertype */
		order.setOrdertype(1);
		/** autocanceltime */
		order.setAutocanceltime(new java.util.Date());
		/** cancelsentdtime */
		order.setCancelsentdtime(new java.util.Date());
		/** yesnumber */
		order.setYesnumber(1);
		/** nonumber */
		order.setNonumber(1);
		/** commodityId */
		order.setCommodityId(1L);
		/** shopcontent */
		order.setShopcontent("1");
		/** starlevel */
		order.setStarlevel(1);
		/** caneltime */
		order.setCaneltime("1");
		/** shouldpaymoney */
		/** iscanfinal */
		order.setIscanfinal("1");
		/** payfreighttime */
		order.setPayfreighttime(new java.util.Date());
		/** totalamout */
		/** isfreight */
		order.setIsfreight("1");
		/** payfreight */
		order.setPayfreight("1");
		/** transportationId */
		order.setTransportationId(1L);
		/** transportationcompanyId */
		order.setTransportationcompanyId(1L);
		/** transportnumber */
		order.setTransportnumber("1");
		/** transportremark */
		order.setTransportremark("1");
		/** 物流跟踪状态 10 启运 20 抵港 30 到货 40 离开 50 签收 */
		order.setLogisticsState(1);
		/** 场站代码 */
		order.setStationCode("1");
		/** 车牌号码 */
		order.setLicensePlateNumber("1");
		/** 支付类型 01:银行卡支付 02:余额支付 03:其他 */
		order.setDeclarePayType("1");
		/** 支付公司编码 */
		order.setPayCompanyCode("1");
		/** 支付单号 */
		order.setPayNumber("1");
		/** 订单税款 */

		orderDao.save(order);
		long saveRows = orderDao.count(query);
		assertEquals(startRows + 1, saveRows);

		Order orderQueried = orderDao.getById(order.getId());
		assertNotNull("查询错误", orderQueried);
		assertEquals(orderQueried.getId(), order.getId());
		assertEquals(orderQueried.getCode(), order.getCode());
		assertEquals(orderQueried.getAppraise(), order.getAppraise());
		assertEquals(orderQueried.getContent(), order.getContent());
		assertEquals(DateUtil.format(orderQueried.getOrdertime(),
				"yyyy-mm-dd HH:MM"), DateUtil.format(order.getOrdertime(),
				"yyyy-mm-dd HH:MM"));
		assertEquals(orderQueried.getRemark(), order.getRemark());
		assertEquals(orderQueried.getGift(), order.getGift());
		assertEquals(orderQueried.getAmount(), order.getAmount());
		assertEquals(orderQueried.getCutamount(), order.getCutamount());
		assertEquals(orderQueried.getInvoicetype(), order.getInvoicetype());
		assertEquals(orderQueried.getInvoicecontent(),
				order.getInvoicecontent());
		assertEquals(orderQueried.getIscoupon(), order.getIscoupon());
		assertEquals(
				DateUtil.format(orderQueried.getPaytime(), "yyyy-mm-dd HH:MM"),
				DateUtil.format(order.getPaytime(), "yyyy-mm-dd HH:MM"));
		assertEquals(orderQueried.getOnlinepay(), order.getOnlinepay());
		assertEquals(orderQueried.getReturnStatus(), order.getReturnStatus());
		assertEquals(orderQueried.getPayStatus(), order.getPayStatus());
		assertEquals(orderQueried.getPayType(), order.getPayType());
		assertEquals(orderQueried.getTransPrice(), order.getTransPrice());
		assertEquals(orderQueried.getIsBigOrder(), order.getIsBigOrder());
		assertEquals(orderQueried.getIsPackage(), order.getIsPackage());
		assertEquals(orderQueried.getStatus(), order.getStatus());
		assertEquals(orderQueried.getSource(), order.getSource());
		assertEquals(orderQueried.getReplacement(), order.getReplacement());
		assertEquals(orderQueried.getIsuserevaluate(),
				order.getIsuserevaluate());
		assertEquals(orderQueried.getIsshopevaluate(),
				order.getIsshopevaluate());
		assertEquals(orderQueried.getMember(), order.getMember());
		assertEquals(orderQueried.getShopId(), order.getShopId());
		assertEquals(orderQueried.getCreatoradmin(), order.getCreatoradmin());
		assertEquals(orderQueried.getModifieradmin(), order.getModifieradmin());
		assertEquals(DateUtil.format(orderQueried.getCreatedatetime(),
				"yyyy-mm-dd HH:MM"), DateUtil.format(order.getCreatedatetime(),
				"yyyy-mm-dd HH:MM"));
		assertEquals(DateUtil.format(orderQueried.getUpdatedatetime(),
				"yyyy-mm-dd HH:MM"), DateUtil.format(order.getUpdatedatetime(),
				"yyyy-mm-dd HH:MM"));
		assertEquals(orderQueried.getOrdertransport(),
				order.getOrdertransport());
		assertEquals(orderQueried.getStatementId(), order.getStatementId());
		assertEquals(orderQueried.getIsstatemented(), order.getIsstatemented());
		assertEquals(orderQueried.getCcgroupId(), order.getCcgroupId());
		assertEquals(orderQueried.getOrdertype(), order.getOrdertype());
		assertEquals(DateUtil.format(orderQueried.getAutocanceltime(),
				"yyyy-mm-dd HH:MM"), DateUtil.format(order.getAutocanceltime(),
				"yyyy-mm-dd HH:MM"));
		assertEquals(DateUtil.format(orderQueried.getCancelsentdtime(),
				"yyyy-mm-dd HH:MM"), DateUtil.format(
				order.getCancelsentdtime(), "yyyy-mm-dd HH:MM"));
		assertEquals(orderQueried.getYesnumber(), order.getYesnumber());
		assertEquals(orderQueried.getNonumber(), order.getNonumber());
		assertEquals(orderQueried.getCommodityId(), order.getCommodityId());
		assertEquals(orderQueried.getShopcontent(), order.getShopcontent());
		assertEquals(orderQueried.getStarlevel(), order.getStarlevel());
		assertEquals(orderQueried.getCaneltime(), order.getCaneltime());
		assertEquals(orderQueried.getShouldpaymoney(),
				order.getShouldpaymoney());
		assertEquals(orderQueried.getIscanfinal(), order.getIscanfinal());
		assertEquals(DateUtil.format(orderQueried.getPayfreighttime(),
				"yyyy-mm-dd HH:MM"), DateUtil.format(order.getPayfreighttime(),
				"yyyy-mm-dd HH:MM"));
		assertEquals(orderQueried.getTotalamout(), order.getTotalamout());
		assertEquals(orderQueried.getIsfreight(), order.getIsfreight());
		assertEquals(orderQueried.getPayfreight(), order.getPayfreight());
		assertEquals(orderQueried.getTransportationId(),
				order.getTransportationId());
		assertEquals(orderQueried.getTransportationcompanyId(),
				order.getTransportationcompanyId());
		assertEquals(orderQueried.getTransportnumber(),
				order.getTransportnumber());
		assertEquals(orderQueried.getTransportremark(),
				order.getTransportremark());
		assertEquals(orderQueried.getLogisticsState(),
				order.getLogisticsState());
		assertEquals(orderQueried.getStationCode(), order.getStationCode());
		assertEquals(orderQueried.getLicensePlateNumber(),
				order.getLicensePlateNumber());
		assertEquals(orderQueried.getDeclarePayType(),
				order.getDeclarePayType());
		assertEquals(orderQueried.getPayCompanyCode(),
				order.getPayCompanyCode());
		assertEquals(orderQueried.getPayNumber(), order.getPayNumber());
		assertEquals(orderQueried.getOrderTaxAmount(),
				order.getOrderTaxAmount());

		/** code */
		order.setCode("2");
		/** appraise */
		order.setAppraise(2);
		/** content */
		order.setContent("2");
		/** ordertime */
		order.setOrdertime(new java.util.Date());
		/** remark */
		order.setRemark("2");
		/** gift */
		order.setGift("2");
		/** amount */
		/** cutamount */
		/** invoicetype */
		order.setInvoicetype(2);
		/** invoicecontent */
		order.setInvoicecontent("2");
		/** iscoupon */
		order.setIscoupon("2");
		/** paytime */
		order.setPaytime(new java.util.Date());
		/** onlinepay */
		order.setOnlinepay(2);
		/** returnStatus */
		order.setReturnStatus(2);
		/** payStatus */
		order.setPayStatus(2);
		/** payType */
		order.setPayType(2);
		/** transPrice */
		/** isBigOrder */
		order.setIsBigOrder("2");
		/** isPackage */
		order.setIsPackage("2");
		/** status */
		order.setStatus(2);
		/** source */
		order.setSource(2);
		/** replacement */
		order.setReplacement(2);
		/** isuserevaluate */
		order.setIsuserevaluate("2");
		/** isshopevaluate */
		order.setIsshopevaluate("2");
		/** member */
		order.setMember(2L);
		/** shopId */
		order.setShopId(2L);
		/** creatoradmin */
		order.setCreatoradmin(2L);
		/** modifieradmin */
		order.setModifieradmin(2L);
		/** createdatetime */
		order.setCreatedatetime(new java.util.Date());
		/** updatedatetime */
		order.setUpdatedatetime(new java.util.Date());
		/** ordertransport */
		order.setOrdertransport(2L);
		/** statementId */
		order.setStatementId(2L);
		/** isstatemented */
		order.setIsstatemented(2);
		/** ccgroupId */
		order.setCcgroupId(2L);
		/** ordertype */
		order.setOrdertype(2);
		/** autocanceltime */
		order.setAutocanceltime(new java.util.Date());
		/** cancelsentdtime */
		order.setCancelsentdtime(new java.util.Date());
		/** yesnumber */
		order.setYesnumber(2);
		/** nonumber */
		order.setNonumber(2);
		/** commodityId */
		order.setCommodityId(2L);
		/** shopcontent */
		order.setShopcontent("2");
		/** starlevel */
		order.setStarlevel(2);
		/** caneltime */
		order.setCaneltime("2");
		/** shouldpaymoney */
		/** iscanfinal */
		order.setIscanfinal("2");
		/** payfreighttime */
		order.setPayfreighttime(new java.util.Date());
		/** totalamout */
		/** isfreight */
		order.setIsfreight("2");
		/** payfreight */
		order.setPayfreight("2");
		/** transportationId */
		order.setTransportationId(2L);
		/** transportationcompanyId */
		order.setTransportationcompanyId(2L);
		/** transportnumber */
		order.setTransportnumber("2");
		/** transportremark */
		order.setTransportremark("2");
		/** 物流跟踪状态 10 启运 20 抵港 30 到货 40 离开 50 签收 */
		order.setLogisticsState(2);
		/** 场站代码 */
		order.setStationCode("2");
		/** 车牌号码 */
		order.setLicensePlateNumber("2");
		/** 支付类型 01:银行卡支付 02:余额支付 03:其他 */
		order.setDeclarePayType("2");
		/** 支付公司编码 */
		order.setPayCompanyCode("2");
		/** 支付单号 */
		order.setPayNumber("2");
		/** 订单税款 */

		orderDao.update(order);
		Order orderUpdated = orderDao.getById(order.getId());
		assertEquals(orderUpdated.getCode(), order.getCode());
		assertEquals(orderUpdated.getAppraise(), order.getAppraise());
		assertEquals(orderUpdated.getContent(), order.getContent());
		assertEquals(DateUtil.format(orderUpdated.getOrdertime(),
				"yyyy-mm-dd HH:MM"), DateUtil.format(
				orderUpdated.getOrdertime(), "yyyy-mm-dd HH:MM"));
		assertEquals(orderUpdated.getRemark(), order.getRemark());
		assertEquals(orderUpdated.getGift(), order.getGift());
		assertEquals(orderUpdated.getAmount(), order.getAmount());
		assertEquals(orderUpdated.getCutamount(), order.getCutamount());
		assertEquals(orderUpdated.getInvoicetype(), order.getInvoicetype());
		assertEquals(orderUpdated.getInvoicecontent(),
				order.getInvoicecontent());
		assertEquals(orderUpdated.getIscoupon(), order.getIscoupon());
		assertEquals(
				DateUtil.format(orderUpdated.getPaytime(), "yyyy-mm-dd HH:MM"),
				DateUtil.format(orderUpdated.getPaytime(), "yyyy-mm-dd HH:MM"));
		assertEquals(orderUpdated.getOnlinepay(), order.getOnlinepay());
		assertEquals(orderUpdated.getReturnStatus(), order.getReturnStatus());
		assertEquals(orderUpdated.getPayStatus(), order.getPayStatus());
		assertEquals(orderUpdated.getPayType(), order.getPayType());
		assertEquals(orderUpdated.getTransPrice(), order.getTransPrice());
		assertEquals(orderUpdated.getIsBigOrder(), order.getIsBigOrder());
		assertEquals(orderUpdated.getIsPackage(), order.getIsPackage());
		assertEquals(orderUpdated.getStatus(), order.getStatus());
		assertEquals(orderUpdated.getSource(), order.getSource());
		assertEquals(orderUpdated.getReplacement(), order.getReplacement());
		assertEquals(orderUpdated.getIsuserevaluate(),
				order.getIsuserevaluate());
		assertEquals(orderUpdated.getIsshopevaluate(),
				order.getIsshopevaluate());
		assertEquals(orderUpdated.getMember(), order.getMember());
		assertEquals(orderUpdated.getShopId(), order.getShopId());
		assertEquals(orderUpdated.getCreatoradmin(), order.getCreatoradmin());
		assertEquals(orderUpdated.getModifieradmin(), order.getModifieradmin());
		assertEquals(DateUtil.format(orderUpdated.getCreatedatetime(),
				"yyyy-mm-dd HH:MM"), DateUtil.format(
				orderUpdated.getCreatedatetime(), "yyyy-mm-dd HH:MM"));
		assertEquals(DateUtil.format(orderUpdated.getUpdatedatetime(),
				"yyyy-mm-dd HH:MM"), DateUtil.format(
				orderUpdated.getUpdatedatetime(), "yyyy-mm-dd HH:MM"));
		assertEquals(orderUpdated.getOrdertransport(),
				order.getOrdertransport());
		assertEquals(orderUpdated.getStatementId(), order.getStatementId());
		assertEquals(orderUpdated.getIsstatemented(), order.getIsstatemented());
		assertEquals(orderUpdated.getCcgroupId(), order.getCcgroupId());
		assertEquals(orderUpdated.getOrdertype(), order.getOrdertype());
		assertEquals(DateUtil.format(orderUpdated.getAutocanceltime(),
				"yyyy-mm-dd HH:MM"), DateUtil.format(
				orderUpdated.getAutocanceltime(), "yyyy-mm-dd HH:MM"));
		assertEquals(DateUtil.format(orderUpdated.getCancelsentdtime(),
				"yyyy-mm-dd HH:MM"), DateUtil.format(
				orderUpdated.getCancelsentdtime(), "yyyy-mm-dd HH:MM"));
		assertEquals(orderUpdated.getYesnumber(), order.getYesnumber());
		assertEquals(orderUpdated.getNonumber(), order.getNonumber());
		assertEquals(orderUpdated.getCommodityId(), order.getCommodityId());
		assertEquals(orderUpdated.getShopcontent(), order.getShopcontent());
		assertEquals(orderUpdated.getStarlevel(), order.getStarlevel());
		assertEquals(orderUpdated.getCaneltime(), order.getCaneltime());
		assertEquals(orderUpdated.getShouldpaymoney(),
				order.getShouldpaymoney());
		assertEquals(orderUpdated.getIscanfinal(), order.getIscanfinal());
		assertEquals(DateUtil.format(orderUpdated.getPayfreighttime(),
				"yyyy-mm-dd HH:MM"), DateUtil.format(
				orderUpdated.getPayfreighttime(), "yyyy-mm-dd HH:MM"));
		assertEquals(orderUpdated.getTotalamout(), order.getTotalamout());
		assertEquals(orderUpdated.getIsfreight(), order.getIsfreight());
		assertEquals(orderUpdated.getPayfreight(), order.getPayfreight());
		assertEquals(orderUpdated.getTransportationId(),
				order.getTransportationId());
		assertEquals(orderUpdated.getTransportationcompanyId(),
				order.getTransportationcompanyId());
		assertEquals(orderUpdated.getTransportnumber(),
				order.getTransportnumber());
		assertEquals(orderUpdated.getTransportremark(),
				order.getTransportremark());
		assertEquals(orderUpdated.getLogisticsState(),
				order.getLogisticsState());
		assertEquals(orderUpdated.getStationCode(), order.getStationCode());
		assertEquals(orderUpdated.getLicensePlateNumber(),
				order.getLicensePlateNumber());
		assertEquals(orderUpdated.getDeclarePayType(),
				order.getDeclarePayType());
		assertEquals(orderUpdated.getPayCompanyCode(),
				order.getPayCompanyCode());
		assertEquals(orderUpdated.getPayNumber(), order.getPayNumber());
		assertEquals(orderUpdated.getOrderTaxAmount(),
				order.getOrderTaxAmount());

		// delete
		orderDao.deleteById(order.getId());
		long deleteRows = orderDao.count(query);
		assertEquals(startRows, deleteRows);
	}
}
