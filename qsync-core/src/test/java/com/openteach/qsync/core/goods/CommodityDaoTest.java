package com.openteach.qsync.core.goods;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;

import com.openteach.qsync.core.SpringTransactionalTestCase;

/**
 *
 * @author dingp email:dingp@51box.cn
 * @version 1.0
 * @since 1.0
 * */
@DirtiesContext
public class CommodityDaoTest extends SpringTransactionalTestCase{
	@Autowired
	private CommodityDao commodityDao;

	/**
	 * 注意只能单个库测试
	 * 因为对删除使用到count方法计数进行对比
	 * @throws Exception
	 */
	@Test
	public void commodityCurl() throws Exception {
		CommodityQuery query = new CommodityQuery();
		long startRows = commodityDao.count(query);
		List<Commodity> lists = commodityDao.list(query);
		assertEquals(lists.size(), startRows);
		
		Commodity commodity = new Commodity();
		/** id */
		/** name */
		commodity.setName("1");
		/** itemcode */
		commodity.setItemcode("1");
		/** description */
		commodity.setDescription("1");
		/** pkglist */
		commodity.setPkglist("1");
		/** sellservice */
		commodity.setSellservice("1");
		/** props */
		commodity.setProps("1");
		/** propsName */
		commodity.setPropsName("1");
		/** cid */
		commodity.setCid(1L);
		/** classall */
		commodity.setClassall("1");
		/** listorder */
		commodity.setListorder(1);
		/** isdeleted */
		commodity.setIsdeleted("1");
		/** source */
		commodity.setSource(1);
		/** brandId */
		commodity.setBrandId(1L);
		/** categoryId */
		commodity.setCategoryId(1L);
		/** originalprice */
		commodity.setOriginalprice(1.0);
		/** saleprice */
		commodity.setSaleprice(1.0);
		/** valid */
		commodity.setValid("1");
		/** audit */
		commodity.setAudit(1);
		/** shopId */
		commodity.setShopId(1L);
		/** saleNumber */
		commodity.setSaleNumber(1);
		/** stock */
		commodity.setStock(1);
		/** shopHotRecommend */
		commodity.setShopHotRecommend("1");
		/** validTime */
		commodity.setValidTime(new java.util.Date());
		/** auditTime */
		commodity.setAuditTime(new java.util.Date());
		/** lastTradingTime */
		commodity.setLastTradingTime(new java.util.Date());
		/** updatedatetime */
		commodity.setUpdatedatetime(new java.util.Date());
		/** createdatetime */
		commodity.setCreatedatetime(new java.util.Date());
		/** creatoradmin */
		commodity.setCreatoradmin(1L);
		/** modifieradmin */
		commodity.setModifieradmin(1L);
		/** picurl */
		commodity.setPicurl("1");
		/** info */
		commodity.setInfo("1");
		/** footsize */
		commodity.setFootsize("1");
		/** footsizemax */
		commodity.setFootsizemax("1");
		/** designtime */
		commodity.setDesigntime("1");
		/** port */
		commodity.setPort("1");
		/** supplyability */
		commodity.setSupplyability("1");
		/** falagecommodity */
		commodity.setFalagecommodity(1);
		/** sizepairs */
		commodity.setSizepairs(1);
		/** minimum */
		commodity.setMinimum(1);
		/** preparemum */
		commodity.setPreparemum(1);
		/** preparetime */
		commodity.setPreparetime(1);
		/** orderunit */
		commodity.setOrderunit(1);
		/** seokeyword */
		commodity.setSeokeyword("1");
		/** seodescription */
		commodity.setSeodescription("1");
		/** vondorcode */
		commodity.setVondorcode("1");
		/** length */
		commodity.setLength(1.0);
		/** width */
		commodity.setWidth(1.0);
		/** height */
		commodity.setHeight(1.0);
		/** weight */
		commodity.setWeight(1);
		
		commodityDao.save(commodity);
		long saveRows = commodityDao.count(query);
		assertEquals(startRows + 1, saveRows);
		
		Commodity CommodityQueried = commodityDao.getById(commodity.getId());
		assertNotNull("查询错误", CommodityQueried);
		assertEquals(CommodityQueried.getId(), commodity.getId());
		assertEquals(CommodityQueried.getName(), commodity.getName());
		assertEquals(CommodityQueried.getItemcode(), commodity.getItemcode());
		assertEquals(CommodityQueried.getDescription(), commodity.getDescription());
		assertEquals(CommodityQueried.getPkglist(), commodity.getPkglist());
		assertEquals(CommodityQueried.getSellservice(), commodity.getSellservice());
		assertEquals(CommodityQueried.getProps(), commodity.getProps());
		assertEquals(CommodityQueried.getPropsName(), commodity.getPropsName());
		assertEquals(CommodityQueried.getCid(), commodity.getCid());
		assertEquals(CommodityQueried.getClassall(), commodity.getClassall());
		assertEquals(CommodityQueried.getListorder(), commodity.getListorder());
		assertEquals(CommodityQueried.getIsdeleted(), commodity.getIsdeleted());
		assertEquals(CommodityQueried.getSource(), commodity.getSource());
		assertEquals(CommodityQueried.getBrandId(), commodity.getBrandId());
		assertEquals(CommodityQueried.getCategoryId(), commodity.getCategoryId());
		assertEquals(CommodityQueried.getOriginalprice(), commodity.getOriginalprice());
		assertEquals(CommodityQueried.getSaleprice(), commodity.getSaleprice());
		assertEquals(CommodityQueried.getValid(), commodity.getValid());
		assertEquals(CommodityQueried.getAudit(), commodity.getAudit());
		assertEquals(CommodityQueried.getShopId(), commodity.getShopId());
		assertEquals(CommodityQueried.getSaleNumber(), commodity.getSaleNumber());
		assertEquals(CommodityQueried.getStock(), commodity.getStock());
		assertEquals(CommodityQueried.getShopHotRecommend(), commodity.getShopHotRecommend());
		assertEquals(CommodityQueried.getValidTime(), commodity.getValidTime());
		assertEquals(CommodityQueried.getAuditTime(), commodity.getAuditTime());
		assertEquals(CommodityQueried.getLastTradingTime(), commodity.getLastTradingTime());
		assertEquals(CommodityQueried.getUpdatedatetime(), commodity.getUpdatedatetime());
		assertEquals(CommodityQueried.getCreatedatetime(), commodity.getCreatedatetime());
		assertEquals(CommodityQueried.getCreatoradmin(), commodity.getCreatoradmin());
		assertEquals(CommodityQueried.getModifieradmin(), commodity.getModifieradmin());
		assertEquals(CommodityQueried.getPicurl(), commodity.getPicurl());
		assertEquals(CommodityQueried.getInfo(), commodity.getInfo());
		assertEquals(CommodityQueried.getFootsize(), commodity.getFootsize());
		assertEquals(CommodityQueried.getFootsizemax(), commodity.getFootsizemax());
		assertEquals(CommodityQueried.getDesigntime(), commodity.getDesigntime());
		assertEquals(CommodityQueried.getPort(), commodity.getPort());
		assertEquals(CommodityQueried.getSupplyability(), commodity.getSupplyability());
		assertEquals(CommodityQueried.getFalagecommodity(), commodity.getFalagecommodity());
		assertEquals(CommodityQueried.getSizepairs(), commodity.getSizepairs());
		assertEquals(CommodityQueried.getMinimum(), commodity.getMinimum());
		assertEquals(CommodityQueried.getPreparemum(), commodity.getPreparemum());
		assertEquals(CommodityQueried.getPreparetime(), commodity.getPreparetime());
		assertEquals(CommodityQueried.getOrderunit(), commodity.getOrderunit());
		assertEquals(CommodityQueried.getSeokeyword(), commodity.getSeokeyword());
		assertEquals(CommodityQueried.getSeodescription(), commodity.getSeodescription());
		assertEquals(CommodityQueried.getVondorcode(), commodity.getVondorcode());
		assertEquals(CommodityQueried.getLength(), commodity.getLength());
		assertEquals(CommodityQueried.getWidth(), commodity.getWidth());
		assertEquals(CommodityQueried.getHeight(), commodity.getHeight());
		assertEquals(CommodityQueried.getWeight(), commodity.getWeight());
		
		/** name */
		commodity.setName("2");
		/** itemcode */
		commodity.setItemcode("2");
		/** description */
		commodity.setDescription("2");
		/** pkglist */
		commodity.setPkglist("2");
		/** sellservice */
		commodity.setSellservice("2");
		/** props */
		commodity.setProps("2");
		/** propsName */
		commodity.setPropsName("2");
		/** cid */
		commodity.setCid(2L);
		/** classall */
		commodity.setClassall("2");
		/** listorder */
		commodity.setListorder(2);
		/** isdeleted */
		commodity.setIsdeleted("2");
		/** source */
		commodity.setSource(2);
		/** brandId */
		commodity.setBrandId(2L);
		/** categoryId */
		commodity.setCategoryId(2L);
		/** originalprice */
		commodity.setOriginalprice(2.0);
		/** saleprice */
		commodity.setSaleprice(2.0);
		/** valid */
		commodity.setValid("2");
		/** audit */
		commodity.setAudit(2);
		/** shopId */
		commodity.setShopId(2L);
		/** saleNumber */
		commodity.setSaleNumber(2);
		/** stock */
		commodity.setStock(2);
		/** shopHotRecommend */
		commodity.setShopHotRecommend("2");
		/** validTime */
		commodity.setValidTime(new java.util.Date());
		/** auditTime */
		commodity.setAuditTime(new java.util.Date());
		/** lastTradingTime */
		commodity.setLastTradingTime(new java.util.Date());
		/** updatedatetime */
		commodity.setUpdatedatetime(new java.util.Date());
		/** createdatetime */
		commodity.setCreatedatetime(new java.util.Date());
		/** creatoradmin */
		commodity.setCreatoradmin(2L);
		/** modifieradmin */
		commodity.setModifieradmin(2L);
		/** picurl */
		commodity.setPicurl("2");
		/** info */
		commodity.setInfo("2");
		/** footsize */
		commodity.setFootsize("2");
		/** footsizemax */
		commodity.setFootsizemax("2");
		/** designtime */
		commodity.setDesigntime("2");
		/** port */
		commodity.setPort("2");
		/** supplyability */
		commodity.setSupplyability("2");
		/** falagecommodity */
		commodity.setFalagecommodity(2);
		/** sizepairs */
		commodity.setSizepairs(2);
		/** minimum */
		commodity.setMinimum(2);
		/** preparemum */
		commodity.setPreparemum(2);
		/** preparetime */
		commodity.setPreparetime(2);
		/** orderunit */
		commodity.setOrderunit(2);
		/** seokeyword */
		commodity.setSeokeyword("2");
		/** seodescription */
		commodity.setSeodescription("2");
		/** vondorcode */
		commodity.setVondorcode("2");
		/** length */
		commodity.setLength(2.0);
		/** width */
		commodity.setWidth(2.0);
		/** height */
		commodity.setHeight(2.0);
		/** weight */
		commodity.setWeight(2);
		
		commodityDao.update(commodity);
		Commodity commodityUpdated = commodityDao.getById(commodity.getId());
		assertEquals(commodityUpdated.getName(), commodity.getName());
		assertEquals(commodityUpdated.getItemcode(), commodity.getItemcode());
		assertEquals(commodityUpdated.getDescription(), commodity.getDescription());
		assertEquals(commodityUpdated.getPkglist(), commodity.getPkglist());
		assertEquals(commodityUpdated.getSellservice(), commodity.getSellservice());
		assertEquals(commodityUpdated.getProps(), commodity.getProps());
		assertEquals(commodityUpdated.getPropsName(), commodity.getPropsName());
		assertEquals(commodityUpdated.getCid(), commodity.getCid());
		assertEquals(commodityUpdated.getClassall(), commodity.getClassall());
		assertEquals(commodityUpdated.getListorder(), commodity.getListorder());
		assertEquals(commodityUpdated.getIsdeleted(), commodity.getIsdeleted());
		assertEquals(commodityUpdated.getSource(), commodity.getSource());
		assertEquals(commodityUpdated.getBrandId(), commodity.getBrandId());
		assertEquals(commodityUpdated.getCategoryId(), commodity.getCategoryId());
		assertEquals(commodityUpdated.getOriginalprice(), commodity.getOriginalprice());
		assertEquals(commodityUpdated.getSaleprice(), commodity.getSaleprice());
		assertEquals(commodityUpdated.getValid(), commodity.getValid());
		assertEquals(commodityUpdated.getAudit(), commodity.getAudit());
		assertEquals(commodityUpdated.getShopId(), commodity.getShopId());
		assertEquals(commodityUpdated.getSaleNumber(), commodity.getSaleNumber());
		assertEquals(commodityUpdated.getStock(), commodity.getStock());
		assertEquals(commodityUpdated.getShopHotRecommend(), commodity.getShopHotRecommend());
		assertEquals(commodityUpdated.getValidTime(), commodity.getValidTime());
		assertEquals(commodityUpdated.getAuditTime(), commodity.getAuditTime());
		assertEquals(commodityUpdated.getLastTradingTime(), commodity.getLastTradingTime());
		assertEquals(commodityUpdated.getUpdatedatetime(), commodity.getUpdatedatetime());
		assertEquals(commodityUpdated.getCreatedatetime(), commodity.getCreatedatetime());
		assertEquals(commodityUpdated.getCreatoradmin(), commodity.getCreatoradmin());
		assertEquals(commodityUpdated.getModifieradmin(), commodity.getModifieradmin());
		assertEquals(commodityUpdated.getPicurl(), commodity.getPicurl());
		assertEquals(commodityUpdated.getInfo(), commodity.getInfo());
		assertEquals(commodityUpdated.getFootsize(), commodity.getFootsize());
		assertEquals(commodityUpdated.getFootsizemax(), commodity.getFootsizemax());
		assertEquals(commodityUpdated.getDesigntime(), commodity.getDesigntime());
		assertEquals(commodityUpdated.getPort(), commodity.getPort());
		assertEquals(commodityUpdated.getSupplyability(), commodity.getSupplyability());
		assertEquals(commodityUpdated.getFalagecommodity(), commodity.getFalagecommodity());
		assertEquals(commodityUpdated.getSizepairs(), commodity.getSizepairs());
		assertEquals(commodityUpdated.getMinimum(), commodity.getMinimum());
		assertEquals(commodityUpdated.getPreparemum(), commodity.getPreparemum());
		assertEquals(commodityUpdated.getPreparetime(), commodity.getPreparetime());
		assertEquals(commodityUpdated.getOrderunit(), commodity.getOrderunit());
		assertEquals(commodityUpdated.getSeokeyword(), commodity.getSeokeyword());
		assertEquals(commodityUpdated.getSeodescription(), commodity.getSeodescription());
		assertEquals(commodityUpdated.getVondorcode(), commodity.getVondorcode());
		assertEquals(commodityUpdated.getLength(), commodity.getLength());
		assertEquals(commodityUpdated.getWidth(), commodity.getWidth());
		assertEquals(commodityUpdated.getHeight(), commodity.getHeight());
		assertEquals(commodityUpdated.getWeight(), commodity.getWeight());
		
		//delete
		commodityDao.deleteById(commodity.getId());
		long deleteRows = commodityDao.count(query);
		assertEquals(startRows, deleteRows);
	}
}
