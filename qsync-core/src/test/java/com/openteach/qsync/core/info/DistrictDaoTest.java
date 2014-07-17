package com.openteach.qsync.core.info;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;

import com.openteach.qsync.core.SpringTransactionalTestCase;
import com.openteach.qsync.core.dao.info.DistrictDao;
import com.openteach.qsync.core.entity.info.District;
import com.openteach.qsync.core.query.info.DistrictQuery;
import com.openteach.qsync.util.common.DateUtil;

/**
 *
 * @author dingp email:dingp@51box.cn
 * @version 1.0
 * @since 1.0
 * */
@DirtiesContext
public class DistrictDaoTest extends SpringTransactionalTestCase{
	@Autowired
	private DistrictDao districtDao;
	
	/**
	 * 注意只能单个库测试
	 * 因为对删除使用到count方法计数进行对比
	 * @throws Exception
	 */
	@Test
	public void districtCurl() throws Exception {
		DistrictQuery query = new DistrictQuery();
		long startRows = districtDao.count(query);
		List<District> lists = districtDao.list(query);
		assertEquals(lists.size(), startRows);
		
		District district = new District();
		/** id */
		/** code */
		district.setCode("1");
		/** name */
		district.setName("1");
		/** isdeleted */
		district.setIsdeleted("1");
		/** creatorId */
		district.setCreatorId(1L);
		/** modifierId */
		district.setModifierId(1L);
		/** createdatetime */
		district.setCreatedatetime(new java.util.Date());
		/** updatedatetime */
		district.setUpdatedatetime(new java.util.Date());
		/** cityId */
		district.setCityId(1L);
		/** provinceId */
		district.setProvinceId(1L);
		/** countryId */
		district.setCountryId(1L);
		
		districtDao.save(district);
		long saveRows = districtDao.count(query);
		assertEquals(startRows + 1, saveRows);
		
		District districtQueried = districtDao.getById(district.getId());
		assertNotNull("查询错误", districtQueried);
			assertEquals(districtQueried.getId(), district.getId());
			assertEquals(districtQueried.getCode(), district.getCode());
			assertEquals(districtQueried.getName(), district.getName());
			assertEquals(districtQueried.getIsdeleted(), district.getIsdeleted());
			assertEquals(districtQueried.getCreatorId(), district.getCreatorId());
			assertEquals(districtQueried.getModifierId(), district.getModifierId());
			assertEquals(DateUtil.format(districtQueried.getCreatedatetime(), "yyyy-mm-dd HH:MM"), 
				DateUtil.format(district.getCreatedatetime(), "yyyy-mm-dd HH:MM"));
			assertEquals(DateUtil.format(districtQueried.getUpdatedatetime(), "yyyy-mm-dd HH:MM"), 
				DateUtil.format(district.getUpdatedatetime(), "yyyy-mm-dd HH:MM"));
			assertEquals(districtQueried.getCityId(), district.getCityId());
			assertEquals(districtQueried.getProvinceId(), district.getProvinceId());
			assertEquals(districtQueried.getCountryId(), district.getCountryId());
		
		/** code */
		district.setCode("2");
		/** name */
		district.setName("2");
		/** isdeleted */
		district.setIsdeleted("2");
		/** creatorId */
		district.setCreatorId(2L);
		/** modifierId */
		district.setModifierId(2L);
		/** createdatetime */
		district.setCreatedatetime(new java.util.Date());
		/** updatedatetime */
		district.setUpdatedatetime(new java.util.Date());
		/** cityId */
		district.setCityId(2L);
		/** provinceId */
		district.setProvinceId(2L);
		/** countryId */
		district.setCountryId(2L);
		
		districtDao.update(district);
		District districtUpdated = districtDao.getById(district.getId());
		assertEquals(districtUpdated.getCode(), district.getCode());
		assertEquals(districtUpdated.getName(), district.getName());
		assertEquals(districtUpdated.getIsdeleted(), district.getIsdeleted());
		assertEquals(districtUpdated.getCreatorId(), district.getCreatorId());
		assertEquals(districtUpdated.getModifierId(), district.getModifierId());
		assertEquals(DateUtil.format(districtUpdated.getCreatedatetime(), "yyyy-mm-dd HH:MM"), 
			DateUtil.format(districtUpdated.getCreatedatetime(), "yyyy-mm-dd HH:MM"));
		assertEquals(DateUtil.format(districtUpdated.getUpdatedatetime(), "yyyy-mm-dd HH:MM"), 
			DateUtil.format(districtUpdated.getUpdatedatetime(), "yyyy-mm-dd HH:MM"));
		assertEquals(districtUpdated.getCityId(), district.getCityId());
		assertEquals(districtUpdated.getProvinceId(), district.getProvinceId());
		assertEquals(districtUpdated.getCountryId(), district.getCountryId());
		
		//delete
		districtDao.deleteById(district.getId());
		long deleteRows = districtDao.count(query);
		assertEquals(startRows, deleteRows);
	}
}
