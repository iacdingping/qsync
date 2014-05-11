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
		transportCommodity.setPrice(1.0);
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
		
		transportCommodityDao.save(transportCommodity);
		long saveRows = transportCommodityDao.count(query);
		assertEquals(startRows + 1, saveRows);
		
		TransportCommodity TransportCommodityQueried = transportCommodityDao.getById(transportCommodity.getId());
		assertNotNull("查询错误", TransportCommodityQueried);
		assertEquals(TransportCommodityQueried.getId(), transportCommodity.getId());
		assertEquals(TransportCommodityQueried.getNumber(), transportCommodity.getNumber());
		assertEquals(TransportCommodityQueried.getIscomment(), transportCommodity.getIscomment());
		assertEquals(TransportCommodityQueried.getPrice(), transportCommodity.getPrice());
		assertEquals(TransportCommodityQueried.getDelivernum(), transportCommodity.getDelivernum());
		assertEquals(TransportCommodityQueried.getSource(), transportCommodity.getSource());
		assertEquals(TransportCommodityQueried.getTransportId(), transportCommodity.getTransportId());
		assertEquals(TransportCommodityQueried.getSkuId(), transportCommodity.getSkuId());
		assertEquals(TransportCommodityQueried.getIsreturn(), transportCommodity.getIsreturn());
		
		/** number */
		transportCommodity.setNumber(2);
		/** iscomment */
		transportCommodity.setIscomment(2);
		/** price */
		transportCommodity.setPrice(2.0);
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
		
		//delete
		transportCommodityDao.deleteById(transportCommodity.getId());
		long deleteRows = transportCommodityDao.count(query);
		assertEquals(startRows, deleteRows);
	}
}
