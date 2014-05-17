package com.openteach.qsync.core.order;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;

import com.openteach.qsync.core.SpringTransactionalTestCase;

/**
 *
 * @author dingp email:dingp@51box.cn
 * @version 1.0
 * @since 1.0
 * */
@DirtiesContext
public class OrderDaoTest extends SpringTransactionalTestCase{
	@Autowired
	private OrderDao orderDao;

	/**
	 * 注意只能单个库测试
	 * 因为对删除使用到count方法计数进行对比
	 * @throws Exception
	 */
	@Test
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
		order.setAmount(1.0);
		/** cutamount */
		order.setCutamount(1.0);
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
		order.setTransPrice(1.0);
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
		order.setShouldpaymoney(1.0);
		/** iscanfinal */
		order.setIscanfinal("1");
		/** payfreighttime */
		order.setPayfreighttime(new java.util.Date());
		/** totalamout */
		order.setTotalamout(1.0);
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
		
		orderDao.save(order);
		long saveRows = orderDao.count(query);
		assertEquals(startRows + 1, saveRows);
		
		Order OrderQueried = orderDao.getById(order.getId());
		assertNotNull("查询错误", OrderQueried);
		assertEquals(OrderQueried.getId(), order.getId());
		assertEquals(OrderQueried.getCode(), order.getCode());
		assertEquals(OrderQueried.getAppraise(), order.getAppraise());
		assertEquals(OrderQueried.getContent(), order.getContent());
		assertEquals(OrderQueried.getOrdertime(), order.getOrdertime());
		assertEquals(OrderQueried.getRemark(), order.getRemark());
		assertEquals(OrderQueried.getGift(), order.getGift());
		assertEquals(OrderQueried.getAmount(), order.getAmount());
		assertEquals(OrderQueried.getCutamount(), order.getCutamount());
		assertEquals(OrderQueried.getInvoicetype(), order.getInvoicetype());
		assertEquals(OrderQueried.getInvoicecontent(), order.getInvoicecontent());
		assertEquals(OrderQueried.getIscoupon(), order.getIscoupon());
		assertEquals(OrderQueried.getPaytime(), order.getPaytime());
		assertEquals(OrderQueried.getOnlinepay(), order.getOnlinepay());
		assertEquals(OrderQueried.getReturnStatus(), order.getReturnStatus());
		assertEquals(OrderQueried.getPayStatus(), order.getPayStatus());
		assertEquals(OrderQueried.getPayType(), order.getPayType());
		assertEquals(OrderQueried.getTransPrice(), order.getTransPrice());
		assertEquals(OrderQueried.getIsBigOrder(), order.getIsBigOrder());
		assertEquals(OrderQueried.getIsPackage(), order.getIsPackage());
		assertEquals(OrderQueried.getStatus(), order.getStatus());
		assertEquals(OrderQueried.getSource(), order.getSource());
		assertEquals(OrderQueried.getReplacement(), order.getReplacement());
		assertEquals(OrderQueried.getIsuserevaluate(), order.getIsuserevaluate());
		assertEquals(OrderQueried.getIsshopevaluate(), order.getIsshopevaluate());
		assertEquals(OrderQueried.getMember(), order.getMember());
		assertEquals(OrderQueried.getShopId(), order.getShopId());
		assertEquals(OrderQueried.getCreatoradmin(), order.getCreatoradmin());
		assertEquals(OrderQueried.getModifieradmin(), order.getModifieradmin());
		assertEquals(OrderQueried.getCreatedatetime(), order.getCreatedatetime());
		assertEquals(OrderQueried.getUpdatedatetime(), order.getUpdatedatetime());
		assertEquals(OrderQueried.getOrdertransport(), order.getOrdertransport());
		assertEquals(OrderQueried.getStatementId(), order.getStatementId());
		assertEquals(OrderQueried.getIsstatemented(), order.getIsstatemented());
		assertEquals(OrderQueried.getCcgroupId(), order.getCcgroupId());
		assertEquals(OrderQueried.getOrdertype(), order.getOrdertype());
		assertEquals(OrderQueried.getAutocanceltime(), order.getAutocanceltime());
		assertEquals(OrderQueried.getCancelsentdtime(), order.getCancelsentdtime());
		assertEquals(OrderQueried.getYesnumber(), order.getYesnumber());
		assertEquals(OrderQueried.getNonumber(), order.getNonumber());
		assertEquals(OrderQueried.getCommodityId(), order.getCommodityId());
		assertEquals(OrderQueried.getShopcontent(), order.getShopcontent());
		assertEquals(OrderQueried.getStarlevel(), order.getStarlevel());
		assertEquals(OrderQueried.getCaneltime(), order.getCaneltime());
		assertEquals(OrderQueried.getShouldpaymoney(), order.getShouldpaymoney());
		assertEquals(OrderQueried.getIscanfinal(), order.getIscanfinal());
		assertEquals(OrderQueried.getPayfreighttime(), order.getPayfreighttime());
		assertEquals(OrderQueried.getTotalamout(), order.getTotalamout());
		assertEquals(OrderQueried.getIsfreight(), order.getIsfreight());
		assertEquals(OrderQueried.getPayfreight(), order.getPayfreight());
		assertEquals(OrderQueried.getTransportationId(), order.getTransportationId());
		assertEquals(OrderQueried.getTransportationcompanyId(), order.getTransportationcompanyId());
		assertEquals(OrderQueried.getTransportnumber(), order.getTransportnumber());
		assertEquals(OrderQueried.getTransportremark(), order.getTransportremark());
		
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
		order.setAmount(2.0);
		/** cutamount */
		order.setCutamount(2.0);
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
		order.setTransPrice(2.0);
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
		order.setShouldpaymoney(2.0);
		/** iscanfinal */
		order.setIscanfinal("2");
		/** payfreighttime */
		order.setPayfreighttime(new java.util.Date());
		/** totalamout */
		order.setTotalamout(2.0);
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
		
		orderDao.update(order);
		Order orderUpdated = orderDao.getById(order.getId());
		assertEquals(orderUpdated.getCode(), order.getCode());
		assertEquals(orderUpdated.getAppraise(), order.getAppraise());
		assertEquals(orderUpdated.getContent(), order.getContent());
		assertEquals(orderUpdated.getOrdertime(), order.getOrdertime());
		assertEquals(orderUpdated.getRemark(), order.getRemark());
		assertEquals(orderUpdated.getGift(), order.getGift());
		assertEquals(orderUpdated.getAmount(), order.getAmount());
		assertEquals(orderUpdated.getCutamount(), order.getCutamount());
		assertEquals(orderUpdated.getInvoicetype(), order.getInvoicetype());
		assertEquals(orderUpdated.getInvoicecontent(), order.getInvoicecontent());
		assertEquals(orderUpdated.getIscoupon(), order.getIscoupon());
		assertEquals(orderUpdated.getPaytime(), order.getPaytime());
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
		assertEquals(orderUpdated.getIsuserevaluate(), order.getIsuserevaluate());
		assertEquals(orderUpdated.getIsshopevaluate(), order.getIsshopevaluate());
		assertEquals(orderUpdated.getMember(), order.getMember());
		assertEquals(orderUpdated.getShopId(), order.getShopId());
		assertEquals(orderUpdated.getCreatoradmin(), order.getCreatoradmin());
		assertEquals(orderUpdated.getModifieradmin(), order.getModifieradmin());
		assertEquals(orderUpdated.getCreatedatetime(), order.getCreatedatetime());
		assertEquals(orderUpdated.getUpdatedatetime(), order.getUpdatedatetime());
		assertEquals(orderUpdated.getOrdertransport(), order.getOrdertransport());
		assertEquals(orderUpdated.getStatementId(), order.getStatementId());
		assertEquals(orderUpdated.getIsstatemented(), order.getIsstatemented());
		assertEquals(orderUpdated.getCcgroupId(), order.getCcgroupId());
		assertEquals(orderUpdated.getOrdertype(), order.getOrdertype());
		assertEquals(orderUpdated.getAutocanceltime(), order.getAutocanceltime());
		assertEquals(orderUpdated.getCancelsentdtime(), order.getCancelsentdtime());
		assertEquals(orderUpdated.getYesnumber(), order.getYesnumber());
		assertEquals(orderUpdated.getNonumber(), order.getNonumber());
		assertEquals(orderUpdated.getCommodityId(), order.getCommodityId());
		assertEquals(orderUpdated.getShopcontent(), order.getShopcontent());
		assertEquals(orderUpdated.getStarlevel(), order.getStarlevel());
		assertEquals(orderUpdated.getCaneltime(), order.getCaneltime());
		assertEquals(orderUpdated.getShouldpaymoney(), order.getShouldpaymoney());
		assertEquals(orderUpdated.getIscanfinal(), order.getIscanfinal());
		assertEquals(orderUpdated.getPayfreighttime(), order.getPayfreighttime());
		assertEquals(orderUpdated.getTotalamout(), order.getTotalamout());
		assertEquals(orderUpdated.getIsfreight(), order.getIsfreight());
		assertEquals(orderUpdated.getPayfreight(), order.getPayfreight());
		assertEquals(orderUpdated.getTransportationId(), order.getTransportationId());
		assertEquals(orderUpdated.getTransportationcompanyId(), order.getTransportationcompanyId());
		assertEquals(orderUpdated.getTransportnumber(), order.getTransportnumber());
		assertEquals(orderUpdated.getTransportremark(), order.getTransportremark());
		
		//delete
		orderDao.deleteById(order.getId());
		long deleteRows = orderDao.count(query);
		assertEquals(startRows, deleteRows);
	}
}
