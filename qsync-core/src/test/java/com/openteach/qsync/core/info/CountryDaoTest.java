package com.openteach.qsync.core.info;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;

import com.openteach.qsync.core.SpringTransactionalTestCase;
import com.openteach.qsync.core.dao.info.CountryDao;
import com.openteach.qsync.core.entity.info.Country;
import com.openteach.qsync.core.query.info.CountryQuery;
import com.openteach.qsync.util.common.DateUtil;

/**
 *
 * @author dingp email:dingp@51box.cn
 * @version 1.0
 * @since 1.0
 * */
@DirtiesContext
public class CountryDaoTest extends SpringTransactionalTestCase{
	@Autowired
	private CountryDao countryDao;
	
	/**
	 * 注意只能单个库测试
	 * 因为对删除使用到count方法计数进行对比
	 * @throws Exception
	 */
	@Test
	public void countryCurl() throws Exception {
		CountryQuery query = new CountryQuery();
		long startRows = countryDao.count(query);
		List<Country> lists = countryDao.list(query);
		assertEquals(lists.size(), startRows);
		
		Country country = new Country();
		/** id */
		/** code */
		country.setCode("1");
		/** name */
		country.setName("1");
		/** area */
		country.setArea("1");
		/** isdeleted */
		country.setIsdeleted("1");
		/** creatorId */
		country.setCreatorId(1L);
		/** modifierId */
		country.setModifierId(1L);
		/** createdatetime */
		country.setCreatedatetime(new java.util.Date());
		/** updatedatetime */
		country.setUpdatedatetime(new java.util.Date());
		/** 国别代码 见报文参数2.国别代码 */
		country.setCountryCode("1");
		
		countryDao.save(country);
		long saveRows = countryDao.count(query);
		assertEquals(startRows + 1, saveRows);
		
		Country countryQueried = countryDao.getById(country.getId());
		assertNotNull("查询错误", countryQueried);
			assertEquals(countryQueried.getId(), country.getId());
			assertEquals(countryQueried.getCode(), country.getCode());
			assertEquals(countryQueried.getName(), country.getName());
			assertEquals(countryQueried.getArea(), country.getArea());
			assertEquals(countryQueried.getIsdeleted(), country.getIsdeleted());
			assertEquals(countryQueried.getCreatorId(), country.getCreatorId());
			assertEquals(countryQueried.getModifierId(), country.getModifierId());
			assertEquals(DateUtil.format(countryQueried.getCreatedatetime(), "yyyy-mm-dd HH:MM"), 
				DateUtil.format(country.getCreatedatetime(), "yyyy-mm-dd HH:MM"));
			assertEquals(DateUtil.format(countryQueried.getUpdatedatetime(), "yyyy-mm-dd HH:MM"), 
				DateUtil.format(country.getUpdatedatetime(), "yyyy-mm-dd HH:MM"));
			assertEquals(countryQueried.getCountryCode(), country.getCountryCode());
		
		/** code */
		country.setCode("2");
		/** name */
		country.setName("2");
		/** area */
		country.setArea("2");
		/** isdeleted */
		country.setIsdeleted("2");
		/** creatorId */
		country.setCreatorId(2L);
		/** modifierId */
		country.setModifierId(2L);
		/** createdatetime */
		country.setCreatedatetime(new java.util.Date());
		/** updatedatetime */
		country.setUpdatedatetime(new java.util.Date());
		/** 国别代码 见报文参数2.国别代码 */
		country.setCountryCode("2");
		
		countryDao.update(country);
		Country countryUpdated = countryDao.getById(country.getId());
		assertEquals(countryUpdated.getCode(), country.getCode());
		assertEquals(countryUpdated.getName(), country.getName());
		assertEquals(countryUpdated.getArea(), country.getArea());
		assertEquals(countryUpdated.getIsdeleted(), country.getIsdeleted());
		assertEquals(countryUpdated.getCreatorId(), country.getCreatorId());
		assertEquals(countryUpdated.getModifierId(), country.getModifierId());
		assertEquals(DateUtil.format(countryUpdated.getCreatedatetime(), "yyyy-mm-dd HH:MM"), 
			DateUtil.format(countryUpdated.getCreatedatetime(), "yyyy-mm-dd HH:MM"));
		assertEquals(DateUtil.format(countryUpdated.getUpdatedatetime(), "yyyy-mm-dd HH:MM"), 
			DateUtil.format(countryUpdated.getUpdatedatetime(), "yyyy-mm-dd HH:MM"));
		assertEquals(countryUpdated.getCountryCode(), country.getCountryCode());
		
		//delete
		countryDao.deleteById(country.getId());
		long deleteRows = countryDao.count(query);
		assertEquals(startRows, deleteRows);
	}
}
