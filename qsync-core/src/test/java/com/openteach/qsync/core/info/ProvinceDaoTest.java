package com.openteach.qsync.core.info;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;

import com.openteach.qsync.core.SpringTransactionalTestCase;
import com.openteach.qsync.core.dao.info.ProvinceDao;
import com.openteach.qsync.core.entity.info.Province;
import com.openteach.qsync.core.query.info.ProvinceQuery;
import com.openteach.qsync.util.common.DateUtil;

/**
 *
 * @author dingp email:dingp@51box.cn
 * @version 1.0
 * @since 1.0
 * */
@DirtiesContext
public class ProvinceDaoTest extends SpringTransactionalTestCase{
	@Autowired
	private ProvinceDao provinceDao;
	
	/**
	 * 注意只能单个库测试
	 * 因为对删除使用到count方法计数进行对比
	 * @throws Exception
	 */
	@Test
	public void provinceCurl() throws Exception {
		ProvinceQuery query = new ProvinceQuery();
		long startRows = provinceDao.count(query);
		List<Province> lists = provinceDao.list(query);
		assertEquals(lists.size(), startRows);
		
		Province province = new Province();
		/** id */
		/** code */
		province.setCode("1");
		/** name */
		province.setName("1");
		/** isdeleted */
		province.setIsdeleted("1");
		/** countryId */
		province.setCountryId(1L);
		/** creatorId */
		province.setCreatorId(1L);
		/** modifierId */
		province.setModifierId(1L);
		/** createdatetime */
		province.setCreatedatetime(new java.util.Date());
		/** updatedatetime */
		province.setUpdatedatetime(new java.util.Date());
		
		provinceDao.save(province);
		long saveRows = provinceDao.count(query);
		assertEquals(startRows + 1, saveRows);
		
		Province provinceQueried = provinceDao.getById(province.getId());
		assertNotNull("查询错误", provinceQueried);
			assertEquals(provinceQueried.getId(), province.getId());
			assertEquals(provinceQueried.getCode(), province.getCode());
			assertEquals(provinceQueried.getName(), province.getName());
			assertEquals(provinceQueried.getIsdeleted(), province.getIsdeleted());
			assertEquals(provinceQueried.getCountryId(), province.getCountryId());
			assertEquals(provinceQueried.getCreatorId(), province.getCreatorId());
			assertEquals(provinceQueried.getModifierId(), province.getModifierId());
			assertEquals(DateUtil.format(provinceQueried.getCreatedatetime(), "yyyy-mm-dd HH:MM"), 
				DateUtil.format(province.getCreatedatetime(), "yyyy-mm-dd HH:MM"));
			assertEquals(DateUtil.format(provinceQueried.getUpdatedatetime(), "yyyy-mm-dd HH:MM"), 
				DateUtil.format(province.getUpdatedatetime(), "yyyy-mm-dd HH:MM"));
		
		/** code */
		province.setCode("2");
		/** name */
		province.setName("2");
		/** isdeleted */
		province.setIsdeleted("2");
		/** countryId */
		province.setCountryId(2L);
		/** creatorId */
		province.setCreatorId(2L);
		/** modifierId */
		province.setModifierId(2L);
		/** createdatetime */
		province.setCreatedatetime(new java.util.Date());
		/** updatedatetime */
		province.setUpdatedatetime(new java.util.Date());
		
		provinceDao.update(province);
		Province provinceUpdated = provinceDao.getById(province.getId());
		assertEquals(provinceUpdated.getCode(), province.getCode());
		assertEquals(provinceUpdated.getName(), province.getName());
		assertEquals(provinceUpdated.getIsdeleted(), province.getIsdeleted());
		assertEquals(provinceUpdated.getCountryId(), province.getCountryId());
		assertEquals(provinceUpdated.getCreatorId(), province.getCreatorId());
		assertEquals(provinceUpdated.getModifierId(), province.getModifierId());
		assertEquals(DateUtil.format(provinceUpdated.getCreatedatetime(), "yyyy-mm-dd HH:MM"), 
			DateUtil.format(provinceUpdated.getCreatedatetime(), "yyyy-mm-dd HH:MM"));
		assertEquals(DateUtil.format(provinceUpdated.getUpdatedatetime(), "yyyy-mm-dd HH:MM"), 
			DateUtil.format(provinceUpdated.getUpdatedatetime(), "yyyy-mm-dd HH:MM"));
		
		//delete
		provinceDao.deleteById(province.getId());
		long deleteRows = provinceDao.count(query);
		assertEquals(startRows, deleteRows);
	}
}
