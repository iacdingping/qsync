package com.openteach.qsync.core.declare;

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
public class DeclarePayTypeDaoTest extends SpringTransactionalTestCase{
	@Autowired
	private DeclarePayTypeDao declarePayTypeDao;

	/**
	 * 注意只能单个库测试
	 * 因为对删除使用到count方法计数进行对比
	 * @throws Exception
	 */
	@Test
	public void declarePayTypeCurl() throws Exception {
		DeclarePayTypeQuery query = new DeclarePayTypeQuery();
		long startRows = declarePayTypeDao.count(query);
		List<DeclarePayType> lists = declarePayTypeDao.list(query);
		assertEquals(lists.size(), startRows);
		
		DeclarePayType declarePayType = new DeclarePayType();
		/** id */
		/** 电商平台支付方式 1 paypal 2 skril */
		declarePayType.setPlatformPayType(1);
		/** 支付公司编码 */
		declarePayType.setPlatformPayCompanyCode("1");
		/** 报关支付类型 01:银行卡支付 02:余额支付 03:其他 */
		declarePayType.setDeclarePayType("1");
		/** isdeleted */
		declarePayType.setIsdeleted("1");
		/** createdatetime */
		declarePayType.setCreatedatetime(new java.util.Date());
		/** updatedatetime */
		declarePayType.setUpdatedatetime(new java.util.Date());
		
		declarePayTypeDao.save(declarePayType);
		long saveRows = declarePayTypeDao.count(query);
		assertEquals(startRows + 1, saveRows);
		
		DeclarePayType DeclarePayTypeQueried = declarePayTypeDao.getById(declarePayType.getId());
		assertNotNull("查询错误", DeclarePayTypeQueried);
		assertEquals(DeclarePayTypeQueried.getId(), declarePayType.getId());
		assertEquals(DeclarePayTypeQueried.getPlatformPayType(), declarePayType.getPlatformPayType());
		assertEquals(DeclarePayTypeQueried.getPlatformPayCompanyCode(), declarePayType.getPlatformPayCompanyCode());
		assertEquals(DeclarePayTypeQueried.getDeclarePayType(), declarePayType.getDeclarePayType());
		assertEquals(DeclarePayTypeQueried.getIsdeleted(), declarePayType.getIsdeleted());
		assertEquals(DeclarePayTypeQueried.getCreatedatetime(), declarePayType.getCreatedatetime());
		assertEquals(DeclarePayTypeQueried.getUpdatedatetime(), declarePayType.getUpdatedatetime());
		
		/** 电商平台支付方式 1 paypal 2 skril */
		declarePayType.setPlatformPayType(2);
		/** 支付公司编码 */
		declarePayType.setPlatformPayCompanyCode("2");
		/** 报关支付类型 01:银行卡支付 02:余额支付 03:其他 */
		declarePayType.setDeclarePayType("2");
		/** isdeleted */
		declarePayType.setIsdeleted("2");
		/** createdatetime */
		declarePayType.setCreatedatetime(new java.util.Date());
		/** updatedatetime */
		declarePayType.setUpdatedatetime(new java.util.Date());
		
		declarePayTypeDao.update(declarePayType);
		DeclarePayType declarePayTypeUpdated = declarePayTypeDao.getById(declarePayType.getId());
		assertEquals(declarePayTypeUpdated.getPlatformPayType(), declarePayType.getPlatformPayType());
		assertEquals(declarePayTypeUpdated.getPlatformPayCompanyCode(), declarePayType.getPlatformPayCompanyCode());
		assertEquals(declarePayTypeUpdated.getDeclarePayType(), declarePayType.getDeclarePayType());
		assertEquals(declarePayTypeUpdated.getIsdeleted(), declarePayType.getIsdeleted());
		assertEquals(declarePayTypeUpdated.getCreatedatetime(), declarePayType.getCreatedatetime());
		assertEquals(declarePayTypeUpdated.getUpdatedatetime(), declarePayType.getUpdatedatetime());
		
		//delete
		declarePayTypeDao.deleteById(declarePayType.getId());
		long deleteRows = declarePayTypeDao.count(query);
		assertEquals(startRows, deleteRows);
	}
}
