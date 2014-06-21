package com.openteach.qsync.core.goods;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;

import com.openteach.qsync.core.SpringTransactionalTestCase;
import com.openteach.qsync.core.dao.goods.UnitDao;
import com.openteach.qsync.core.entity.goods.Unit;
import com.openteach.qsync.core.query.goods.UnitQuery;
import com.openteach.qsync.util.common.DateUtil;

/**
 *
 * @author dingp email:dingp@51box.cn
 * @version 1.0
 * @since 1.0
 * */
@DirtiesContext
public class UnitDaoTest extends SpringTransactionalTestCase{
	@Autowired
	private UnitDao unitDao;
	
	/**
	 * 注意只能单个库测试
	 * 因为对删除使用到count方法计数进行对比
	 * @throws Exception
	 */
	@Test
	public void unitCurl() throws Exception {
		UnitQuery query = new UnitQuery();
		long startRows = unitDao.count(query);
		List<Unit> lists = unitDao.list(query);
		assertEquals(lists.size(), startRows);
		
		Unit unit = new Unit();
		/** id */
		/** name */
		unit.setName("1");
		/** code */
		unit.setCode("1");
		/** sort */
		unit.setSort("1");
		/** account */
		unit.setAccount("1");
		/** createdate */
		unit.setCreatedate(new java.util.Date());
		/** isdeleted */
		unit.setIsdeleted("1");
		
		unitDao.save(unit);
		long saveRows = unitDao.count(query);
		assertEquals(startRows + 1, saveRows);
		
		Unit unitQueried = unitDao.getById(unit.getId());
		assertNotNull("查询错误", unitQueried);
			assertEquals(unitQueried.getId(), unit.getId());
			assertEquals(unitQueried.getName(), unit.getName());
			assertEquals(unitQueried.getCode(), unit.getCode());
			assertEquals(unitQueried.getSort(), unit.getSort());
			assertEquals(unitQueried.getAccount(), unit.getAccount());
			assertEquals(DateUtil.format(unitQueried.getCreatedate(), "yyyy-mm-dd HH:MM"), 
				DateUtil.format(unit.getCreatedate(), "yyyy-mm-dd HH:MM"));
			assertEquals(unitQueried.getIsdeleted(), unit.getIsdeleted());
		
		/** name */
		unit.setName("2");
		/** code */
		unit.setCode("2");
		/** sort */
		unit.setSort("2");
		/** account */
		unit.setAccount("2");
		/** createdate */
		unit.setCreatedate(new java.util.Date());
		/** isdeleted */
		unit.setIsdeleted("2");
		
		unitDao.update(unit);
		Unit unitUpdated = unitDao.getById(unit.getId());
		assertEquals(unitUpdated.getName(), unit.getName());
		assertEquals(unitUpdated.getCode(), unit.getCode());
		assertEquals(unitUpdated.getSort(), unit.getSort());
		assertEquals(unitUpdated.getAccount(), unit.getAccount());
		assertEquals(DateUtil.format(unitUpdated.getCreatedate(), "yyyy-mm-dd HH:MM"), 
			DateUtil.format(unitUpdated.getCreatedate(), "yyyy-mm-dd HH:MM"));
		assertEquals(unitUpdated.getIsdeleted(), unit.getIsdeleted());
		
		//delete
		unitDao.deleteById(unit.getId());
		long deleteRows = unitDao.count(query);
		assertEquals(startRows, deleteRows);
	}
}
