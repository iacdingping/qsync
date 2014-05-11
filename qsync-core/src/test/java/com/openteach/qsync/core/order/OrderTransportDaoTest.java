package com.openteach.qsync.core.order;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;

import com.openteach.qsync.core.SpringTransactionalTestCase;

/**
 *
 * @author dingp email:dingp@51box.cn
 * @version 1.0
 * @since 1.0
 * */
@DirtiesContext
@ContextConfiguration(locations = { "classpath:spring/applicationContext-dao.xml" })
public class OrderTransportDaoTest extends SpringTransactionalTestCase{
	@Autowired
	private OrderTransportDao orderTransportDao;

	/**
	 * 注意只能单个库测试
	 * 因为对删除使用到count方法计数进行对比
	 * @throws Exception
	 */
	@Test
	public void orderTransportCurl() throws Exception {
		OrderTransportQuery query = new OrderTransportQuery();
		long startRows = orderTransportDao.count(query);
		List<OrderTransport> lists = orderTransportDao.list(query);
		assertEquals(lists.size(), startRows);
		
		OrderTransport orderTransport = new OrderTransport();
		/** id */
		/** code */
		orderTransport.setCode("1");
		/** congsignee */
		orderTransport.setCongsignee("1");
		/** place */
		orderTransport.setPlace("1");
		/** waybillnumber */
		orderTransport.setWaybillnumber("1");
		/** postnumber */
		orderTransport.setPostnumber("1");
		/** source */
		orderTransport.setSource(1);
		/** countryId */
		orderTransport.setCountryId(1L);
		/** provinceId */
		orderTransport.setProvinceId(1L);
		/** cityId */
		orderTransport.setCityId(1L);
		/** districtId */
		orderTransport.setDistrictId(1L);
		/** orderId */
		orderTransport.setOrderId(1L);
		/** phonecountry */
		orderTransport.setPhonecountry("1");
		/** phonearea */
		orderTransport.setPhonearea("1");
		/** phone */
		orderTransport.setPhone("1");
		/** faxcountry */
		orderTransport.setFaxcountry("1");
		/** faxarea */
		orderTransport.setFaxarea("1");
		/** fax */
		orderTransport.setFax("1");
		/** handphonecountry */
		orderTransport.setHandphonecountry("1");
		/** handphone */
		orderTransport.setHandphone("1");
		/** firstname */
		orderTransport.setFirstname("1");
		/** lastname */
		orderTransport.setLastname("1");
		/** address1 */
		orderTransport.setAddress1("1");
		/** address2 */
		orderTransport.setAddress2("1");
		/** scity */
		orderTransport.setScity("1");
		/** sprovince */
		orderTransport.setSprovince("1");
		/** phonenumber */
		orderTransport.setPhonenumber("1");
		
		orderTransportDao.save(orderTransport);
		long saveRows = orderTransportDao.count(query);
		assertEquals(startRows + 1, saveRows);
		
		OrderTransport OrderTransportQueried = orderTransportDao.getById(orderTransport.getId());
		assertNotNull("查询错误", OrderTransportQueried);
		assertEquals(OrderTransportQueried.getId(), orderTransport.getId());
		assertEquals(OrderTransportQueried.getCode(), orderTransport.getCode());
		assertEquals(OrderTransportQueried.getCongsignee(), orderTransport.getCongsignee());
		assertEquals(OrderTransportQueried.getPlace(), orderTransport.getPlace());
		assertEquals(OrderTransportQueried.getWaybillnumber(), orderTransport.getWaybillnumber());
		assertEquals(OrderTransportQueried.getPostnumber(), orderTransport.getPostnumber());
		assertEquals(OrderTransportQueried.getSource(), orderTransport.getSource());
		assertEquals(OrderTransportQueried.getCountryId(), orderTransport.getCountryId());
		assertEquals(OrderTransportQueried.getProvinceId(), orderTransport.getProvinceId());
		assertEquals(OrderTransportQueried.getCityId(), orderTransport.getCityId());
		assertEquals(OrderTransportQueried.getDistrictId(), orderTransport.getDistrictId());
		assertEquals(OrderTransportQueried.getOrderId(), orderTransport.getOrderId());
		assertEquals(OrderTransportQueried.getPhonecountry(), orderTransport.getPhonecountry());
		assertEquals(OrderTransportQueried.getPhonearea(), orderTransport.getPhonearea());
		assertEquals(OrderTransportQueried.getPhone(), orderTransport.getPhone());
		assertEquals(OrderTransportQueried.getFaxcountry(), orderTransport.getFaxcountry());
		assertEquals(OrderTransportQueried.getFaxarea(), orderTransport.getFaxarea());
		assertEquals(OrderTransportQueried.getFax(), orderTransport.getFax());
		assertEquals(OrderTransportQueried.getHandphonecountry(), orderTransport.getHandphonecountry());
		assertEquals(OrderTransportQueried.getHandphone(), orderTransport.getHandphone());
		assertEquals(OrderTransportQueried.getFirstname(), orderTransport.getFirstname());
		assertEquals(OrderTransportQueried.getLastname(), orderTransport.getLastname());
		assertEquals(OrderTransportQueried.getAddress1(), orderTransport.getAddress1());
		assertEquals(OrderTransportQueried.getAddress2(), orderTransport.getAddress2());
		assertEquals(OrderTransportQueried.getScity(), orderTransport.getScity());
		assertEquals(OrderTransportQueried.getSprovince(), orderTransport.getSprovince());
		assertEquals(OrderTransportQueried.getPhonenumber(), orderTransport.getPhonenumber());
		
		/** code */
		orderTransport.setCode("2");
		/** congsignee */
		orderTransport.setCongsignee("2");
		/** place */
		orderTransport.setPlace("2");
		/** waybillnumber */
		orderTransport.setWaybillnumber("2");
		/** postnumber */
		orderTransport.setPostnumber("2");
		/** source */
		orderTransport.setSource(2);
		/** countryId */
		orderTransport.setCountryId(2L);
		/** provinceId */
		orderTransport.setProvinceId(2L);
		/** cityId */
		orderTransport.setCityId(2L);
		/** districtId */
		orderTransport.setDistrictId(2L);
		/** orderId */
		orderTransport.setOrderId(2L);
		/** phonecountry */
		orderTransport.setPhonecountry("2");
		/** phonearea */
		orderTransport.setPhonearea("2");
		/** phone */
		orderTransport.setPhone("2");
		/** faxcountry */
		orderTransport.setFaxcountry("2");
		/** faxarea */
		orderTransport.setFaxarea("2");
		/** fax */
		orderTransport.setFax("2");
		/** handphonecountry */
		orderTransport.setHandphonecountry("2");
		/** handphone */
		orderTransport.setHandphone("2");
		/** firstname */
		orderTransport.setFirstname("2");
		/** lastname */
		orderTransport.setLastname("2");
		/** address1 */
		orderTransport.setAddress1("2");
		/** address2 */
		orderTransport.setAddress2("2");
		/** scity */
		orderTransport.setScity("2");
		/** sprovince */
		orderTransport.setSprovince("2");
		/** phonenumber */
		orderTransport.setPhonenumber("2");
		
		orderTransportDao.update(orderTransport);
		OrderTransport orderTransportUpdated = orderTransportDao.getById(orderTransport.getId());
		assertEquals(orderTransportUpdated.getCode(), orderTransport.getCode());
		assertEquals(orderTransportUpdated.getCongsignee(), orderTransport.getCongsignee());
		assertEquals(orderTransportUpdated.getPlace(), orderTransport.getPlace());
		assertEquals(orderTransportUpdated.getWaybillnumber(), orderTransport.getWaybillnumber());
		assertEquals(orderTransportUpdated.getPostnumber(), orderTransport.getPostnumber());
		assertEquals(orderTransportUpdated.getSource(), orderTransport.getSource());
		assertEquals(orderTransportUpdated.getCountryId(), orderTransport.getCountryId());
		assertEquals(orderTransportUpdated.getProvinceId(), orderTransport.getProvinceId());
		assertEquals(orderTransportUpdated.getCityId(), orderTransport.getCityId());
		assertEquals(orderTransportUpdated.getDistrictId(), orderTransport.getDistrictId());
		assertEquals(orderTransportUpdated.getOrderId(), orderTransport.getOrderId());
		assertEquals(orderTransportUpdated.getPhonecountry(), orderTransport.getPhonecountry());
		assertEquals(orderTransportUpdated.getPhonearea(), orderTransport.getPhonearea());
		assertEquals(orderTransportUpdated.getPhone(), orderTransport.getPhone());
		assertEquals(orderTransportUpdated.getFaxcountry(), orderTransport.getFaxcountry());
		assertEquals(orderTransportUpdated.getFaxarea(), orderTransport.getFaxarea());
		assertEquals(orderTransportUpdated.getFax(), orderTransport.getFax());
		assertEquals(orderTransportUpdated.getHandphonecountry(), orderTransport.getHandphonecountry());
		assertEquals(orderTransportUpdated.getHandphone(), orderTransport.getHandphone());
		assertEquals(orderTransportUpdated.getFirstname(), orderTransport.getFirstname());
		assertEquals(orderTransportUpdated.getLastname(), orderTransport.getLastname());
		assertEquals(orderTransportUpdated.getAddress1(), orderTransport.getAddress1());
		assertEquals(orderTransportUpdated.getAddress2(), orderTransport.getAddress2());
		assertEquals(orderTransportUpdated.getScity(), orderTransport.getScity());
		assertEquals(orderTransportUpdated.getSprovince(), orderTransport.getSprovince());
		assertEquals(orderTransportUpdated.getPhonenumber(), orderTransport.getPhonenumber());
		
		//delete
		orderTransportDao.deleteById(orderTransport.getId());
		long deleteRows = orderTransportDao.count(query);
		assertEquals(startRows, deleteRows);
	}
}
