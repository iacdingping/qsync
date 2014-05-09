/*
 * Powered By china-telcom
 * Since 2012 - 2014
 */

package com.openteach.qsync.core.order;

import com.openteach.qsync.core.order.Admininfo;
import com.openteach.qsync.core.order.AdmininfoDao;
import com.openteach.qsync.core.order.AdmininfoManager;
import com.openteach.qsync.core.order.AdmininfoQuery;


import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springside.modules.test.spring.SpringTransactionalTestCase;

/**
 *
 * @author dingp email:dingp@51box.cn
 * @version 1.0
 * @since 1.0
 * */
@DirtiesContext
@ContextConfiguration(locations = { "classpath:spring/applicationContext-dao.xml" })
public class AdmininfoDaoTest extends SpringTransactionalTestCase{
	@Autowired
	private AdmininfoDao admininfoDao;

	/**
	 * 注意只能单个库测试
	 * 因为对删除使用到count方法计数进行对比
	 * @throws Exception
	 */
	@Test
	public void admininfoCurl() throws Exception {
		AdmininfoQuery query = new AdmininfoQuery();
		long startRows = admininfoDao.count(query);
		List<Admininfo> lists = admininfoDao.list(query);
		assertEquals(lists.size(), startRows);
		
		Admininfo admininfo = new Admininfo();
		/** id */
		/** name */
		admininfo.setName("1");
		/** password */
		admininfo.setPassword("1");
		/** truename */
		admininfo.setTruename("1");
		/** telephone */
		admininfo.setTelephone("1");
		/** handphone */
		admininfo.setHandphone("1");
		/** qq */
		admininfo.setQq("1");
		/** aliww */
		admininfo.setAliww("1");
		/** email */
		admininfo.setEmail("1");
		/** lastlogtime */
		admininfo.setLastlogtime(new java.util.Date());
		/** isdeleted */
		admininfo.setIsdeleted("1");
		/** roleId */
		admininfo.setRoleId(1L);
		/** departId */
		admininfo.setDepartId(1L);
		
		admininfoDao.save(admininfo);
		long saveRows = admininfoDao.count(query);
		assertEquals(startRows + 1, saveRows);
		
		Admininfo AdmininfoQueried = admininfoDao.getById(admininfo.getId());
		assertNotNull("查询错误", AdmininfoQueried);
		assertEquals(AdmininfoQueried.getId(), admininfo.getId());
		assertEquals(AdmininfoQueried.getName(), admininfo.getName());
		assertEquals(AdmininfoQueried.getPassword(), admininfo.getPassword());
		assertEquals(AdmininfoQueried.getTruename(), admininfo.getTruename());
		assertEquals(AdmininfoQueried.getTelephone(), admininfo.getTelephone());
		assertEquals(AdmininfoQueried.getHandphone(), admininfo.getHandphone());
		assertEquals(AdmininfoQueried.getQq(), admininfo.getQq());
		assertEquals(AdmininfoQueried.getAliww(), admininfo.getAliww());
		assertEquals(AdmininfoQueried.getEmail(), admininfo.getEmail());
		assertEquals(AdmininfoQueried.getLastlogtime(), admininfo.getLastlogtime());
		assertEquals(AdmininfoQueried.getIsdeleted(), admininfo.getIsdeleted());
		assertEquals(AdmininfoQueried.getRoleId(), admininfo.getRoleId());
		assertEquals(AdmininfoQueried.getDepartId(), admininfo.getDepartId());
		
		/** name */
		admininfo.setName("2");
		/** password */
		admininfo.setPassword("2");
		/** truename */
		admininfo.setTruename("2");
		/** telephone */
		admininfo.setTelephone("2");
		/** handphone */
		admininfo.setHandphone("2");
		/** qq */
		admininfo.setQq("2");
		/** aliww */
		admininfo.setAliww("2");
		/** email */
		admininfo.setEmail("2");
		/** lastlogtime */
		admininfo.setLastlogtime(new java.util.Date());
		/** isdeleted */
		admininfo.setIsdeleted("2");
		/** roleId */
		admininfo.setRoleId(2L);
		/** departId */
		admininfo.setDepartId(2L);
		
		admininfoDao.update(admininfo);
		Admininfo admininfoUpdated = admininfoDao.getById(admininfo.getId());
		assertEquals(admininfoUpdated.getName(), admininfo.getName());
		assertEquals(admininfoUpdated.getPassword(), admininfo.getPassword());
		assertEquals(admininfoUpdated.getTruename(), admininfo.getTruename());
		assertEquals(admininfoUpdated.getTelephone(), admininfo.getTelephone());
		assertEquals(admininfoUpdated.getHandphone(), admininfo.getHandphone());
		assertEquals(admininfoUpdated.getQq(), admininfo.getQq());
		assertEquals(admininfoUpdated.getAliww(), admininfo.getAliww());
		assertEquals(admininfoUpdated.getEmail(), admininfo.getEmail());
		assertEquals(admininfoUpdated.getLastlogtime(), admininfo.getLastlogtime());
		assertEquals(admininfoUpdated.getIsdeleted(), admininfo.getIsdeleted());
		assertEquals(admininfoUpdated.getRoleId(), admininfo.getRoleId());
		assertEquals(admininfoUpdated.getDepartId(), admininfo.getDepartId());
		
		//delete
		admininfoDao.deleteById(admininfo.getId());
		long deleteRows = admininfoDao.count(query);
		assertEquals(startRows, deleteRows);
	}
}
