package com.openteach.qsync.core.logistics;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;

import com.openteach.qsync.core.SpringTransactionalTestCase;
import com.openteach.qsync.core.dao.logistics.TransportCommodityDao;
import com.openteach.qsync.core.entity.logistics.TransportCommodity;
import com.openteach.qsync.core.query.logistics.TransportCommodityQuery;

/**
 *
 * @author dingp email:dingp@51box.cn
 * @version 1.0
 * @since 1.0
 * */
@DirtiesContext
public class TransportCommodityDaoTest extends SpringTransactionalTestCase{
	@Autowired
	private TransportCommodityDao transportCommodityDao;
	
	/**
	 * 注意只能单个库测试
	 * 因为对删除使用到count方法计数进行对比
	 * @throws Exception
	 */
	@Test
	public void transportCommodityCurl() throws Exception {
		TransportCommodityQuery query = new TransportCommodityQuery();
		long startRows = transportCommodityDao.count(query);
		List<TransportCommodity> lists = transportCommodityDao.list(query);
		assertEquals(lists.size(), startRows);
		
		TransportCommodity transportCommodity = new TransportCommodity();
		/** id */
		/** number */
		transportCommodity.setNumber(1);
		/** iscomment */
		transportCommodity.setIscomment(1);
		/** price */
		/** delivernum */
		transportCommodity.setDelivernum(1);
		/** source */
		transportCommodity.setSource(1);
		/** transportId */
		transportCommodity.setTransportId(1L);
		/** skuId */
		transportCommodity.setSkuId(1L);
		/** isreturn */
		transportCommodity.setIsreturn(1);
		/** 商品货号 保税进口业务，货号需与电子账册一致由仓储提供 */
		transportCommodity.setGoodsItemNo("1");
		
		transportCommodityDao.save(transportCommodity);
		long saveRows = transportCommodityDao.count(query);
		assertEquals(startRows + 1, saveRows);
		
		TransportCommodity transportCommodityQueried = transportCommodityDao.getById(transportCommodity.getId());
		assertNotNull("查询错误", transportCommodityQueried);
			assertEquals(transportCommodityQueried.getId(), transportCommodity.getId());
			assertEquals(transportCommodityQueried.getNumber(), transportCommodity.getNumber());
			assertEquals(transportCommodityQueried.getIscomment(), transportCommodity.getIscomment());
			assertEquals(transportCommodityQueried.getPrice(), transportCommodity.getPrice());
			assertEquals(transportCommodityQueried.getDelivernum(), transportCommodity.getDelivernum());
			assertEquals(transportCommodityQueried.getSource(), transportCommodity.getSource());
			assertEquals(transportCommodityQueried.getTransportId(), transportCommodity.getTransportId());
			assertEquals(transportCommodityQueried.getSkuId(), transportCommodity.getSkuId());
			assertEquals(transportCommodityQueried.getIsreturn(), transportCommodity.getIsreturn());
			assertEquals(transportCommodityQueried.getGoodsItemNo(), transportCommodity.getGoodsItemNo());
		
		/** number */
		transportCommodity.setNumber(2);
		/** iscomment */
		transportCommodity.setIscomment(2);
		/** price */
		/** delivernum */
		transportCommodity.setDelivernum(2);
		/** source */
		transportCommodity.setSource(2);
		/** transportId */
		transportCommodity.setTransportId(2L);
		/** skuId */
		transportCommodity.setSkuId(2L);
		/** isreturn */
		transportCommodity.setIsreturn(2);
		/** 商品货号 保税进口业务，货号需与电子账册一致由仓储提供 */
		transportCommodity.setGoodsItemNo("2");
		
		transportCommodityDao.update(transportCommodity);
		TransportCommodity transportCommodityUpdated = transportCommodityDao.getById(transportCommodity.getId());
		assertEquals(transportCommodityUpdated.getNumber(), transportCommodity.getNumber());
		assertEquals(transportCommodityUpdated.getIscomment(), transportCommodity.getIscomment());
		assertEquals(transportCommodityUpdated.getPrice(), transportCommodity.getPrice());
		assertEquals(transportCommodityUpdated.getDelivernum(), transportCommodity.getDelivernum());
		assertEquals(transportCommodityUpdated.getSource(), transportCommodity.getSource());
		assertEquals(transportCommodityUpdated.getTransportId(), transportCommodity.getTransportId());
		assertEquals(transportCommodityUpdated.getSkuId(), transportCommodity.getSkuId());
		assertEquals(transportCommodityUpdated.getIsreturn(), transportCommodity.getIsreturn());
		assertEquals(transportCommodityUpdated.getGoodsItemNo(), transportCommodity.getGoodsItemNo());
		
		//delete
		transportCommodityDao.deleteById(transportCommodity.getId());
		long deleteRows = transportCommodityDao.count(query);
		assertEquals(startRows, deleteRows);
	}
}
