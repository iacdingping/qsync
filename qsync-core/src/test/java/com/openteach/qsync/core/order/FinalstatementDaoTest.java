/*
 * Powered By china-telcom
 * Since 2012 - 2014
 */

package com.openteach.qsync.core.order;

import com.openteach.qsync.core.order.Finalstatement;
import com.openteach.qsync.core.order.FinalstatementDao;
import com.openteach.qsync.core.order.FinalstatementManager;
import com.openteach.qsync.core.order.FinalstatementQuery;


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
public class FinalstatementDaoTest extends SpringTransactionalTestCase{
	@Autowired
	private FinalstatementDao finalstatementDao;

	/**
	 * 注意只能单个库测试
	 * 因为对删除使用到count方法计数进行对比
	 * @throws Exception
	 */
	@Test
	public void finalstatementCurl() throws Exception {
		FinalstatementQuery query = new FinalstatementQuery();
		long startRows = finalstatementDao.count(query);
		List<Finalstatement> lists = finalstatementDao.list(query);
		assertEquals(lists.size(), startRows);
		
		Finalstatement finalstatement = new Finalstatement();
		/** id */
		/** code */
		finalstatement.setCode("1");
		/** suppliercode */
		finalstatement.setSuppliercode("1");
		/** suppliername */
		finalstatement.setSuppliername("1");
		/** isfinal */
		finalstatement.setIsfinal(1);
		/** totalamount */
		finalstatement.setTotalamount(1);
		/** ccshopId */
		finalstatement.setCcshopId(1L);
		/** createDatetime */
		finalstatement.setCreateDatetime(new java.util.Date());
		/** updatedatetime */
		finalstatement.setUpdatedatetime(new java.util.Date());
		/** isdeleted */
		finalstatement.setIsdeleted("1");
		/** iscomplete */
		finalstatement.setIscomplete("1");
		/** operatepeople */
		finalstatement.setOperatepeople(1L);
		/** modeifier */
		finalstatement.setModeifier(1L);
		
		finalstatementDao.save(finalstatement);
		long saveRows = finalstatementDao.count(query);
		assertEquals(startRows + 1, saveRows);
		
		Finalstatement FinalstatementQueried = finalstatementDao.getById(finalstatement.getId());
		assertNotNull("查询错误", FinalstatementQueried);
		assertEquals(FinalstatementQueried.getId(), finalstatement.getId());
		assertEquals(FinalstatementQueried.getCode(), finalstatement.getCode());
		assertEquals(FinalstatementQueried.getSuppliercode(), finalstatement.getSuppliercode());
		assertEquals(FinalstatementQueried.getSuppliername(), finalstatement.getSuppliername());
		assertEquals(FinalstatementQueried.getIsfinal(), finalstatement.getIsfinal());
		assertEquals(FinalstatementQueried.getTotalamount(), finalstatement.getTotalamount());
		assertEquals(FinalstatementQueried.getCcshopId(), finalstatement.getCcshopId());
		assertEquals(FinalstatementQueried.getCreateDatetime(), finalstatement.getCreateDatetime());
		assertEquals(FinalstatementQueried.getUpdatedatetime(), finalstatement.getUpdatedatetime());
		assertEquals(FinalstatementQueried.getIsdeleted(), finalstatement.getIsdeleted());
		assertEquals(FinalstatementQueried.getIscomplete(), finalstatement.getIscomplete());
		assertEquals(FinalstatementQueried.getOperatepeople(), finalstatement.getOperatepeople());
		assertEquals(FinalstatementQueried.getModeifier(), finalstatement.getModeifier());
		
		/** code */
		finalstatement.setCode("2");
		/** suppliercode */
		finalstatement.setSuppliercode("2");
		/** suppliername */
		finalstatement.setSuppliername("2");
		/** isfinal */
		finalstatement.setIsfinal(2);
		/** totalamount */
		finalstatement.setTotalamount(2);
		/** ccshopId */
		finalstatement.setCcshopId(2L);
		/** createDatetime */
		finalstatement.setCreateDatetime(new java.util.Date());
		/** updatedatetime */
		finalstatement.setUpdatedatetime(new java.util.Date());
		/** isdeleted */
		finalstatement.setIsdeleted("2");
		/** iscomplete */
		finalstatement.setIscomplete("2");
		/** operatepeople */
		finalstatement.setOperatepeople(2L);
		/** modeifier */
		finalstatement.setModeifier(2L);
		
		finalstatementDao.update(finalstatement);
		Finalstatement finalstatementUpdated = finalstatementDao.getById(finalstatement.getId());
		assertEquals(finalstatementUpdated.getCode(), finalstatement.getCode());
		assertEquals(finalstatementUpdated.getSuppliercode(), finalstatement.getSuppliercode());
		assertEquals(finalstatementUpdated.getSuppliername(), finalstatement.getSuppliername());
		assertEquals(finalstatementUpdated.getIsfinal(), finalstatement.getIsfinal());
		assertEquals(finalstatementUpdated.getTotalamount(), finalstatement.getTotalamount());
		assertEquals(finalstatementUpdated.getCcshopId(), finalstatement.getCcshopId());
		assertEquals(finalstatementUpdated.getCreateDatetime(), finalstatement.getCreateDatetime());
		assertEquals(finalstatementUpdated.getUpdatedatetime(), finalstatement.getUpdatedatetime());
		assertEquals(finalstatementUpdated.getIsdeleted(), finalstatement.getIsdeleted());
		assertEquals(finalstatementUpdated.getIscomplete(), finalstatement.getIscomplete());
		assertEquals(finalstatementUpdated.getOperatepeople(), finalstatement.getOperatepeople());
		assertEquals(finalstatementUpdated.getModeifier(), finalstatement.getModeifier());
		
		//delete
		finalstatementDao.deleteById(finalstatement.getId());
		long deleteRows = finalstatementDao.count(query);
		assertEquals(startRows, deleteRows);
	}
}
