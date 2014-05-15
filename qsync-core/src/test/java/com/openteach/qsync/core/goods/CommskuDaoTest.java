package com.openteach.qsync.core.goods;

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
public class CommskuDaoTest extends SpringTransactionalTestCase{
	@Autowired
	private CommskuDao commskuDao;

	/**
	 * 注意只能单个库测试
	 * 因为对删除使用到count方法计数进行对比
	 * @throws Exception
	 */
	@Test
	public void commskuCurl() throws Exception {
		CommskuQuery query = new CommskuQuery();
		long startRows = commskuDao.count(query);
		List<Commsku> lists = commskuDao.list(query);
		assertEquals(lists.size(), startRows);
		
		Commsku commsku = new Commsku();
		/** id */
		/** skucode */
		commsku.setSkucode("1");
		/** barcode */
		commsku.setBarcode("1");
		/** properties */
		commsku.setProperties("1");
		/** quantity */
		commsku.setQuantity(1);
		/** name */
		commsku.setName("1");
		/** picurl */
		commsku.setPicurl("1");
		/** valid */
		commsku.setValid("1");
		/** validdate */
		commsku.setValiddate(new java.util.Date());
		/** sellnum */
		commsku.setSellnum(1);
		/** costprice */
		commsku.setCostprice(1.0);
		/** originalprice */
		commsku.setOriginalprice(1.0);
		/** saleprice */
		commsku.setSaleprice(1.0);
		/** buyprice */
		commsku.setBuyprice(1.0);
		/** score */
		commsku.setScore(1);
		/** listorder */
		commsku.setListorder(1);
		/** isdeleted */
		commsku.setIsdeleted("1");
		/** source */
		commsku.setSource(1);
		/** itemId */
		commsku.setItemId(1L);
		/** isprice */
		commsku.setIsprice("1");
		/** shopId */
		commsku.setShopId(1L);
		/** creatoradmin */
		commsku.setCreatoradmin(1L);
		/** modifieradmin */
		commsku.setModifieradmin(1L);
		/** createdatetime */
		commsku.setCreatedatetime(new java.util.Date());
		/** updatedatetime */
		commsku.setUpdatedatetime(new java.util.Date());
		/** comment */
		commsku.setComment(1);
		/** good */
		commsku.setGood(1);
		/** comm */
		commsku.setComm(1);
		/** bad */
		commsku.setBad(1);
		/** stock */
		commsku.setStock(1);
		
		commskuDao.save(commsku);
		long saveRows = commskuDao.count(query);
		assertEquals(startRows + 1, saveRows);
		
		Commsku CommskuQueried = commskuDao.getById(commsku.getId());
		assertNotNull("查询错误", CommskuQueried);
		assertEquals(CommskuQueried.getId(), commsku.getId());
		assertEquals(CommskuQueried.getSkucode(), commsku.getSkucode());
		assertEquals(CommskuQueried.getBarcode(), commsku.getBarcode());
		assertEquals(CommskuQueried.getProperties(), commsku.getProperties());
		assertEquals(CommskuQueried.getQuantity(), commsku.getQuantity());
		assertEquals(CommskuQueried.getName(), commsku.getName());
		assertEquals(CommskuQueried.getPicurl(), commsku.getPicurl());
		assertEquals(CommskuQueried.getValid(), commsku.getValid());
		assertEquals(CommskuQueried.getValiddate(), commsku.getValiddate());
		assertEquals(CommskuQueried.getSellnum(), commsku.getSellnum());
		assertEquals(CommskuQueried.getCostprice(), commsku.getCostprice());
		assertEquals(CommskuQueried.getOriginalprice(), commsku.getOriginalprice());
		assertEquals(CommskuQueried.getSaleprice(), commsku.getSaleprice());
		assertEquals(CommskuQueried.getBuyprice(), commsku.getBuyprice());
		assertEquals(CommskuQueried.getScore(), commsku.getScore());
		assertEquals(CommskuQueried.getListorder(), commsku.getListorder());
		assertEquals(CommskuQueried.getIsdeleted(), commsku.getIsdeleted());
		assertEquals(CommskuQueried.getSource(), commsku.getSource());
		assertEquals(CommskuQueried.getItemId(), commsku.getItemId());
		assertEquals(CommskuQueried.getIsprice(), commsku.getIsprice());
		assertEquals(CommskuQueried.getShopId(), commsku.getShopId());
		assertEquals(CommskuQueried.getCreatoradmin(), commsku.getCreatoradmin());
		assertEquals(CommskuQueried.getModifieradmin(), commsku.getModifieradmin());
		assertEquals(CommskuQueried.getCreatedatetime(), commsku.getCreatedatetime());
		assertEquals(CommskuQueried.getUpdatedatetime(), commsku.getUpdatedatetime());
		assertEquals(CommskuQueried.getComment(), commsku.getComment());
		assertEquals(CommskuQueried.getGood(), commsku.getGood());
		assertEquals(CommskuQueried.getComm(), commsku.getComm());
		assertEquals(CommskuQueried.getBad(), commsku.getBad());
		assertEquals(CommskuQueried.getStock(), commsku.getStock());
		
		/** skucode */
		commsku.setSkucode("2");
		/** barcode */
		commsku.setBarcode("2");
		/** properties */
		commsku.setProperties("2");
		/** quantity */
		commsku.setQuantity(2);
		/** name */
		commsku.setName("2");
		/** picurl */
		commsku.setPicurl("2");
		/** valid */
		commsku.setValid("2");
		/** validdate */
		commsku.setValiddate(new java.util.Date());
		/** sellnum */
		commsku.setSellnum(2);
		/** costprice */
		commsku.setCostprice(2.0);
		/** originalprice */
		commsku.setOriginalprice(2.0);
		/** saleprice */
		commsku.setSaleprice(2.0);
		/** buyprice */
		commsku.setBuyprice(2.0);
		/** score */
		commsku.setScore(2);
		/** listorder */
		commsku.setListorder(2);
		/** isdeleted */
		commsku.setIsdeleted("2");
		/** source */
		commsku.setSource(2);
		/** itemId */
		commsku.setItemId(2L);
		/** isprice */
		commsku.setIsprice("2");
		/** shopId */
		commsku.setShopId(2L);
		/** creatoradmin */
		commsku.setCreatoradmin(2L);
		/** modifieradmin */
		commsku.setModifieradmin(2L);
		/** createdatetime */
		commsku.setCreatedatetime(new java.util.Date());
		/** updatedatetime */
		commsku.setUpdatedatetime(new java.util.Date());
		/** comment */
		commsku.setComment(2);
		/** good */
		commsku.setGood(2);
		/** comm */
		commsku.setComm(2);
		/** bad */
		commsku.setBad(2);
		/** stock */
		commsku.setStock(2);
		
		commskuDao.update(commsku);
		Commsku commskuUpdated = commskuDao.getById(commsku.getId());
		assertEquals(commskuUpdated.getSkucode(), commsku.getSkucode());
		assertEquals(commskuUpdated.getBarcode(), commsku.getBarcode());
		assertEquals(commskuUpdated.getProperties(), commsku.getProperties());
		assertEquals(commskuUpdated.getQuantity(), commsku.getQuantity());
		assertEquals(commskuUpdated.getName(), commsku.getName());
		assertEquals(commskuUpdated.getPicurl(), commsku.getPicurl());
		assertEquals(commskuUpdated.getValid(), commsku.getValid());
		assertEquals(commskuUpdated.getValiddate(), commsku.getValiddate());
		assertEquals(commskuUpdated.getSellnum(), commsku.getSellnum());
		assertEquals(commskuUpdated.getCostprice(), commsku.getCostprice());
		assertEquals(commskuUpdated.getOriginalprice(), commsku.getOriginalprice());
		assertEquals(commskuUpdated.getSaleprice(), commsku.getSaleprice());
		assertEquals(commskuUpdated.getBuyprice(), commsku.getBuyprice());
		assertEquals(commskuUpdated.getScore(), commsku.getScore());
		assertEquals(commskuUpdated.getListorder(), commsku.getListorder());
		assertEquals(commskuUpdated.getIsdeleted(), commsku.getIsdeleted());
		assertEquals(commskuUpdated.getSource(), commsku.getSource());
		assertEquals(commskuUpdated.getItemId(), commsku.getItemId());
		assertEquals(commskuUpdated.getIsprice(), commsku.getIsprice());
		assertEquals(commskuUpdated.getShopId(), commsku.getShopId());
		assertEquals(commskuUpdated.getCreatoradmin(), commsku.getCreatoradmin());
		assertEquals(commskuUpdated.getModifieradmin(), commsku.getModifieradmin());
		assertEquals(commskuUpdated.getCreatedatetime(), commsku.getCreatedatetime());
		assertEquals(commskuUpdated.getUpdatedatetime(), commsku.getUpdatedatetime());
		assertEquals(commskuUpdated.getComment(), commsku.getComment());
		assertEquals(commskuUpdated.getGood(), commsku.getGood());
		assertEquals(commskuUpdated.getComm(), commsku.getComm());
		assertEquals(commskuUpdated.getBad(), commsku.getBad());
		assertEquals(commskuUpdated.getStock(), commsku.getStock());
		
		//delete
		commskuDao.deleteById(commsku.getId());
		long deleteRows = commskuDao.count(query);
		assertEquals(startRows, deleteRows);
	}
}
