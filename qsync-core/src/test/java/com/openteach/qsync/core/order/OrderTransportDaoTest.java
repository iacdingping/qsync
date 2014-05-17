package com.openteach.qsync.core.order;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;

import com.openteach.qsync.core.SpringTransactionalTestCase;
import com.openteach.qsync.core.dao.order.OrderTransportDao;
import com.openteach.qsync.core.entity.order.OrderTransport;
import com.openteach.qsync.core.query.order.OrderTransportQuery;

/**
 *
 * @author dingp email:dingp@51box.cn
 * @version 1.0
 * @since 1.0
 * */
@DirtiesContext
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
		/** 发件人国别 */
		orderTransport.setAddressorCountry(1L);
		/** 发件人城市 */
		orderTransport.setAddressorCity("1");
		/** 发件人姓名 */
		orderTransport.setAddressorName("1");
		/** 收件人邮编 */
		orderTransport.setZipCode("1");
		/** 收件人邮箱 */
		orderTransport.setConsigneeEmail("1");
		
		orderTransportDao.save(orderTransport);
		long saveRows = orderTransportDao.count(query);
		assertEquals(startRows + 1, saveRows);
		
		OrderTransport orderTransportQueried = orderTransportDao.getById(orderTransport.getId());
		assertNotNull("查询错误", orderTransportQueried);
			assertEquals(orderTransportQueried.getId(), orderTransport.getId());
			assertEquals(orderTransportQueried.getCode(), orderTransport.getCode());
			assertEquals(orderTransportQueried.getCongsignee(), orderTransport.getCongsignee());
			assertEquals(orderTransportQueried.getPlace(), orderTransport.getPlace());
			assertEquals(orderTransportQueried.getWaybillnumber(), orderTransport.getWaybillnumber());
			assertEquals(orderTransportQueried.getPostnumber(), orderTransport.getPostnumber());
			assertEquals(orderTransportQueried.getSource(), orderTransport.getSource());
			assertEquals(orderTransportQueried.getCountryId(), orderTransport.getCountryId());
			assertEquals(orderTransportQueried.getProvinceId(), orderTransport.getProvinceId());
			assertEquals(orderTransportQueried.getCityId(), orderTransport.getCityId());
			assertEquals(orderTransportQueried.getDistrictId(), orderTransport.getDistrictId());
			assertEquals(orderTransportQueried.getOrderId(), orderTransport.getOrderId());
			assertEquals(orderTransportQueried.getPhonecountry(), orderTransport.getPhonecountry());
			assertEquals(orderTransportQueried.getPhonearea(), orderTransport.getPhonearea());
			assertEquals(orderTransportQueried.getPhone(), orderTransport.getPhone());
			assertEquals(orderTransportQueried.getFaxcountry(), orderTransport.getFaxcountry());
			assertEquals(orderTransportQueried.getFaxarea(), orderTransport.getFaxarea());
			assertEquals(orderTransportQueried.getFax(), orderTransport.getFax());
			assertEquals(orderTransportQueried.getHandphonecountry(), orderTransport.getHandphonecountry());
			assertEquals(orderTransportQueried.getHandphone(), orderTransport.getHandphone());
			assertEquals(orderTransportQueried.getFirstname(), orderTransport.getFirstname());
			assertEquals(orderTransportQueried.getLastname(), orderTransport.getLastname());
			assertEquals(orderTransportQueried.getAddress1(), orderTransport.getAddress1());
			assertEquals(orderTransportQueried.getAddress2(), orderTransport.getAddress2());
			assertEquals(orderTransportQueried.getScity(), orderTransport.getScity());
			assertEquals(orderTransportQueried.getSprovince(), orderTransport.getSprovince());
			assertEquals(orderTransportQueried.getPhonenumber(), orderTransport.getPhonenumber());
			assertEquals(orderTransportQueried.getAddressorCountry(), orderTransport.getAddressorCountry());
			assertEquals(orderTransportQueried.getAddressorCity(), orderTransport.getAddressorCity());
			assertEquals(orderTransportQueried.getAddressorName(), orderTransport.getAddressorName());
			assertEquals(orderTransportQueried.getZipCode(), orderTransport.getZipCode());
			assertEquals(orderTransportQueried.getConsigneeEmail(), orderTransport.getConsigneeEmail());
		
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
		/** 发件人国别 */
		orderTransport.setAddressorCountry(2L);
		/** 发件人城市 */
		orderTransport.setAddressorCity("2");
		/** 发件人姓名 */
		orderTransport.setAddressorName("2");
		/** 收件人邮编 */
		orderTransport.setZipCode("2");
		/** 收件人邮箱 */
		orderTransport.setConsigneeEmail("2");
		
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
		assertEquals(orderTransportUpdated.getAddressorCountry(), orderTransport.getAddressorCountry());
		assertEquals(orderTransportUpdated.getAddressorCity(), orderTransport.getAddressorCity());
		assertEquals(orderTransportUpdated.getAddressorName(), orderTransport.getAddressorName());
		assertEquals(orderTransportUpdated.getZipCode(), orderTransport.getZipCode());
		assertEquals(orderTransportUpdated.getConsigneeEmail(), orderTransport.getConsigneeEmail());
		
		//delete
		orderTransportDao.deleteById(orderTransport.getId());
		long deleteRows = orderTransportDao.count(query);
		assertEquals(startRows, deleteRows);
	}
}
