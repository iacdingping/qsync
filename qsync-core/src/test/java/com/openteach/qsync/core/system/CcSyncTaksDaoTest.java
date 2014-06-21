package com.openteach.qsync.core.system;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;

import com.openteach.qsync.core.SpringTransactionalTestCase;
import com.openteach.qsync.core.dao.system.CcSyncTaksDao;
import com.openteach.qsync.core.entity.system.CcSyncTaks;
import com.openteach.qsync.core.query.system.CcSyncTaksQuery;
import com.openteach.qsync.util.common.DateUtil;

/**
 *
 * @author dingp email:dingp@51box.cn
 * @version 1.0
 * @since 1.0
 * */
@DirtiesContext
public class CcSyncTaksDaoTest extends SpringTransactionalTestCase{
	@Autowired
	private CcSyncTaksDao ccSyncTaksDao;
	
	/**
	 * 注意只能单个库测试
	 * 因为对删除使用到count方法计数进行对比
	 * @throws Exception
	 */
	//@Test
	public void ccSyncTaksCurl() throws Exception {
		CcSyncTaksQuery query = new CcSyncTaksQuery();
		long startRows = ccSyncTaksDao.count(query);
		List<CcSyncTaks> lists = ccSyncTaksDao.list(query);
		assertEquals(lists.size(), startRows);
		
		CcSyncTaks ccSyncTaks = new CcSyncTaks();
		/** id */
		/** generator */
		ccSyncTaks.setGenerator("1");
		/** type */
		ccSyncTaks.setType("1");
		/** status */
		ccSyncTaks.setStatus("1");
		/** xmlRequest */
		ccSyncTaks.setXmlRequest("1");
		/** xmlResponse */
		ccSyncTaks.setXmlResponse("1");
		/** exception */
		ccSyncTaks.setException("1");
		/** gmtCreate */
		ccSyncTaks.setGmtCreate(new java.util.Date());
		/** gmtModified */
		ccSyncTaks.setGmtModified(new java.util.Date());
		
		ccSyncTaksDao.save(ccSyncTaks);
		long saveRows = ccSyncTaksDao.count(query);
		assertEquals(startRows + 1, saveRows);
		
		CcSyncTaks ccSyncTaksQueried = ccSyncTaksDao.getById(ccSyncTaks.getId());
		assertNotNull("查询错误", ccSyncTaksQueried);
			assertEquals(ccSyncTaksQueried.getId(), ccSyncTaks.getId());
			assertEquals(ccSyncTaksQueried.getGenerator(), ccSyncTaks.getGenerator());
			assertEquals(ccSyncTaksQueried.getType(), ccSyncTaks.getType());
			assertEquals(ccSyncTaksQueried.getStatus(), ccSyncTaks.getStatus());
			assertEquals(ccSyncTaksQueried.getXmlRequest(), ccSyncTaks.getXmlRequest());
			assertEquals(ccSyncTaksQueried.getXmlResponse(), ccSyncTaks.getXmlResponse());
			assertEquals(ccSyncTaksQueried.getException(), ccSyncTaks.getException());
			assertEquals(DateUtil.format(ccSyncTaksQueried.getGmtCreate(), "yyyy-mm-dd HH:MM"), 
				DateUtil.format(ccSyncTaks.getGmtCreate(), "yyyy-mm-dd HH:MM"));
			assertEquals(DateUtil.format(ccSyncTaksQueried.getGmtModified(), "yyyy-mm-dd HH:MM"), 
				DateUtil.format(ccSyncTaks.getGmtModified(), "yyyy-mm-dd HH:MM"));
		
		/** generator */
		ccSyncTaks.setGenerator("2");
		/** type */
		ccSyncTaks.setType("2");
		/** status */
		ccSyncTaks.setStatus("2");
		/** xmlRequest */
		ccSyncTaks.setXmlRequest("2");
		/** xmlResponse */
		ccSyncTaks.setXmlResponse("2");
		/** exception */
		ccSyncTaks.setException("2");
		/** gmtCreate */
		ccSyncTaks.setGmtCreate(new java.util.Date());
		/** gmtModified */
		ccSyncTaks.setGmtModified(new java.util.Date());
		
		ccSyncTaksDao.update(ccSyncTaks);
		CcSyncTaks ccSyncTaksUpdated = ccSyncTaksDao.getById(ccSyncTaks.getId());
		assertEquals(ccSyncTaksUpdated.getGenerator(), ccSyncTaks.getGenerator());
		assertEquals(ccSyncTaksUpdated.getType(), ccSyncTaks.getType());
		assertEquals(ccSyncTaksUpdated.getStatus(), ccSyncTaks.getStatus());
		assertEquals(ccSyncTaksUpdated.getXmlRequest(), ccSyncTaks.getXmlRequest());
		assertEquals(ccSyncTaksUpdated.getXmlResponse(), ccSyncTaks.getXmlResponse());
		assertEquals(ccSyncTaksUpdated.getException(), ccSyncTaks.getException());
		assertEquals(DateUtil.format(ccSyncTaksUpdated.getGmtCreate(), "yyyy-mm-dd HH:MM"), 
			DateUtil.format(ccSyncTaksUpdated.getGmtCreate(), "yyyy-mm-dd HH:MM"));
		assertEquals(DateUtil.format(ccSyncTaksUpdated.getGmtModified(), "yyyy-mm-dd HH:MM"), 
			DateUtil.format(ccSyncTaksUpdated.getGmtModified(), "yyyy-mm-dd HH:MM"));
		
		//delete
		ccSyncTaksDao.deleteById(ccSyncTaks.getId());
		long deleteRows = ccSyncTaksDao.count(query);
		assertEquals(startRows, deleteRows);
	}
	
	//@Test
	public void ccSyncTaksQueryTest() {
		CcSyncTaksQuery query = new CcSyncTaksQuery();
		query.setInStatus(Arrays.asList("abc", "多状态查询"));
		long c = ccSyncTaksDao.count(query);
		assertEquals(c, 0L);
	}
	
	@Test
	public void findPageTest() {
		CcSyncTaksQuery query = new CcSyncTaksQuery();
		query.setInStatus(Arrays.asList("DOING", "多状态查询"));
		query.setPage(3);
		query.setPageSize(2);
		List<CcSyncTaks> c = ccSyncTaksDao.findPage(query);
		System.out.println(c.size());
	}
	
}
