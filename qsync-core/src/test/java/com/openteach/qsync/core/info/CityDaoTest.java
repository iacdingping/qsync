package com.openteach.qsync.core.info;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;

import com.openteach.qsync.core.SpringTransactionalTestCase;
import com.openteach.qsync.core.dao.info.CityDao;
import com.openteach.qsync.core.entity.info.City;
import com.openteach.qsync.core.query.info.CityQuery;
import com.openteach.qsync.util.common.DateUtil;

/**
 *
 * @author dingp email:dingp@51box.cn
 * @version 1.0
 * @since 1.0
 * */
@DirtiesContext
public class CityDaoTest extends SpringTransactionalTestCase{
	@Autowired
	private CityDao cityDao;
	
	/**
	 * 注意只能单个库测试
	 * 因为对删除使用到count方法计数进行对比
	 * @throws Exception
	 */
	@Test
	public void cityCurl() throws Exception {
		CityQuery query = new CityQuery();
		long startRows = cityDao.count(query);
		List<City> lists = cityDao.list(query);
		assertEquals(lists.size(), startRows);
		
		City city = new City();
		/** id */
		/** code */
		city.setCode("1");
		/** name */
		city.setName("1");
		/** isdeleted */
		city.setIsdeleted("1");
		/** creatorId */
		city.setCreatorId(1L);
		/** modifierId */
		city.setModifierId(1L);
		/** createdatetime */
		city.setCreatedatetime(new java.util.Date());
		/** updatedatetime */
		city.setUpdatedatetime(new java.util.Date());
		/** provinceId */
		city.setProvinceId(1L);
		/** countryId */
		city.setCountryId(1L);
		
		cityDao.save(city);
		long saveRows = cityDao.count(query);
		assertEquals(startRows + 1, saveRows);
		
		City cityQueried = cityDao.getById(city.getId());
		assertNotNull("查询错误", cityQueried);
			assertEquals(cityQueried.getId(), city.getId());
			assertEquals(cityQueried.getCode(), city.getCode());
			assertEquals(cityQueried.getName(), city.getName());
			assertEquals(cityQueried.getIsdeleted(), city.getIsdeleted());
			assertEquals(cityQueried.getCreatorId(), city.getCreatorId());
			assertEquals(cityQueried.getModifierId(), city.getModifierId());
			assertEquals(DateUtil.format(cityQueried.getCreatedatetime(), "yyyy-mm-dd HH:MM"), 
				DateUtil.format(city.getCreatedatetime(), "yyyy-mm-dd HH:MM"));
			assertEquals(DateUtil.format(cityQueried.getUpdatedatetime(), "yyyy-mm-dd HH:MM"), 
				DateUtil.format(city.getUpdatedatetime(), "yyyy-mm-dd HH:MM"));
			assertEquals(cityQueried.getProvinceId(), city.getProvinceId());
			assertEquals(cityQueried.getCountryId(), city.getCountryId());
		
		/** code */
		city.setCode("2");
		/** name */
		city.setName("2");
		/** isdeleted */
		city.setIsdeleted("2");
		/** creatorId */
		city.setCreatorId(2L);
		/** modifierId */
		city.setModifierId(2L);
		/** createdatetime */
		city.setCreatedatetime(new java.util.Date());
		/** updatedatetime */
		city.setUpdatedatetime(new java.util.Date());
		/** provinceId */
		city.setProvinceId(2L);
		/** countryId */
		city.setCountryId(2L);
		
		cityDao.update(city);
		City cityUpdated = cityDao.getById(city.getId());
		assertEquals(cityUpdated.getCode(), city.getCode());
		assertEquals(cityUpdated.getName(), city.getName());
		assertEquals(cityUpdated.getIsdeleted(), city.getIsdeleted());
		assertEquals(cityUpdated.getCreatorId(), city.getCreatorId());
		assertEquals(cityUpdated.getModifierId(), city.getModifierId());
		assertEquals(DateUtil.format(cityUpdated.getCreatedatetime(), "yyyy-mm-dd HH:MM"), 
			DateUtil.format(cityUpdated.getCreatedatetime(), "yyyy-mm-dd HH:MM"));
		assertEquals(DateUtil.format(cityUpdated.getUpdatedatetime(), "yyyy-mm-dd HH:MM"), 
			DateUtil.format(cityUpdated.getUpdatedatetime(), "yyyy-mm-dd HH:MM"));
		assertEquals(cityUpdated.getProvinceId(), city.getProvinceId());
		assertEquals(cityUpdated.getCountryId(), city.getCountryId());
		
		//delete
		cityDao.deleteById(city.getId());
		long deleteRows = cityDao.count(query);
		assertEquals(startRows, deleteRows);
	}
}
