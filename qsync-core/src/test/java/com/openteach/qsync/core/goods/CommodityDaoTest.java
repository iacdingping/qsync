package com.openteach.qsync.core.goods;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;

import com.openteach.qsync.core.SpringTransactionalTestCase;
import com.openteach.qsync.core.dao.goods.CommodityDao;
import com.openteach.qsync.core.entity.goods.Commodity;
import com.openteach.qsync.core.query.goods.CommodityQuery;
import com.openteach.qsync.util.common.DateUtil;

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
		/** saleprice */
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
		/** width */
		/** height */
		/** weight */
		commodity.setWeight(1);
		/** 产销国 */
		commodity.setSalesCountry(1L);
		/** 申报计量单位 见计量单位代码 */
		commodity.setUnit("1");
		/** 申报计量单位描述 */
		commodity.setUnitDesc("1");
		/** 商品规格、型号 */
		commodity.setSpecification("1");
		
		commodityDao.save(commodity);
		long saveRows = commodityDao.count(query);
		assertEquals(startRows + 1, saveRows);
		
		Commodity commodityQueried = commodityDao.getById(commodity.getId());
		assertNotNull("查询错误", commodityQueried);
			assertEquals(commodityQueried.getId(), commodity.getId());
			assertEquals(commodityQueried.getName(), commodity.getName());
			assertEquals(commodityQueried.getItemcode(), commodity.getItemcode());
			assertEquals(commodityQueried.getDescription(), commodity.getDescription());
			assertEquals(commodityQueried.getPkglist(), commodity.getPkglist());
			assertEquals(commodityQueried.getSellservice(), commodity.getSellservice());
			assertEquals(commodityQueried.getProps(), commodity.getProps());
			assertEquals(commodityQueried.getPropsName(), commodity.getPropsName());
			assertEquals(commodityQueried.getCid(), commodity.getCid());
			assertEquals(commodityQueried.getClassall(), commodity.getClassall());
			assertEquals(commodityQueried.getListorder(), commodity.getListorder());
			assertEquals(commodityQueried.getIsdeleted(), commodity.getIsdeleted());
			assertEquals(commodityQueried.getSource(), commodity.getSource());
			assertEquals(commodityQueried.getBrandId(), commodity.getBrandId());
			assertEquals(commodityQueried.getCategoryId(), commodity.getCategoryId());
			assertEquals(commodityQueried.getOriginalprice(), commodity.getOriginalprice());
			assertEquals(commodityQueried.getSaleprice(), commodity.getSaleprice());
			assertEquals(commodityQueried.getValid(), commodity.getValid());
			assertEquals(commodityQueried.getAudit(), commodity.getAudit());
			assertEquals(commodityQueried.getShopId(), commodity.getShopId());
			assertEquals(commodityQueried.getSaleNumber(), commodity.getSaleNumber());
			assertEquals(commodityQueried.getStock(), commodity.getStock());
			assertEquals(commodityQueried.getShopHotRecommend(), commodity.getShopHotRecommend());
			assertEquals(DateUtil.format(commodityQueried.getValidTime(), "yyyy-mm-dd HH:MM"), 
				DateUtil.format(commodity.getValidTime(), "yyyy-mm-dd HH:MM"));
			assertEquals(DateUtil.format(commodityQueried.getAuditTime(), "yyyy-mm-dd HH:MM"), 
				DateUtil.format(commodity.getAuditTime(), "yyyy-mm-dd HH:MM"));
			assertEquals(DateUtil.format(commodityQueried.getLastTradingTime(), "yyyy-mm-dd HH:MM"), 
				DateUtil.format(commodity.getLastTradingTime(), "yyyy-mm-dd HH:MM"));
			assertEquals(DateUtil.format(commodityQueried.getUpdatedatetime(), "yyyy-mm-dd HH:MM"), 
				DateUtil.format(commodity.getUpdatedatetime(), "yyyy-mm-dd HH:MM"));
			assertEquals(DateUtil.format(commodityQueried.getCreatedatetime(), "yyyy-mm-dd HH:MM"), 
				DateUtil.format(commodity.getCreatedatetime(), "yyyy-mm-dd HH:MM"));
			assertEquals(commodityQueried.getCreatoradmin(), commodity.getCreatoradmin());
			assertEquals(commodityQueried.getModifieradmin(), commodity.getModifieradmin());
			assertEquals(commodityQueried.getPicurl(), commodity.getPicurl());
			assertEquals(commodityQueried.getInfo(), commodity.getInfo());
			assertEquals(commodityQueried.getFootsize(), commodity.getFootsize());
			assertEquals(commodityQueried.getFootsizemax(), commodity.getFootsizemax());
			assertEquals(commodityQueried.getDesigntime(), commodity.getDesigntime());
			assertEquals(commodityQueried.getPort(), commodity.getPort());
			assertEquals(commodityQueried.getSupplyability(), commodity.getSupplyability());
			assertEquals(commodityQueried.getFalagecommodity(), commodity.getFalagecommodity());
			assertEquals(commodityQueried.getSizepairs(), commodity.getSizepairs());
			assertEquals(commodityQueried.getMinimum(), commodity.getMinimum());
			assertEquals(commodityQueried.getPreparemum(), commodity.getPreparemum());
			assertEquals(commodityQueried.getPreparetime(), commodity.getPreparetime());
			assertEquals(commodityQueried.getOrderunit(), commodity.getOrderunit());
			assertEquals(commodityQueried.getSeokeyword(), commodity.getSeokeyword());
			assertEquals(commodityQueried.getSeodescription(), commodity.getSeodescription());
			assertEquals(commodityQueried.getVondorcode(), commodity.getVondorcode());
			assertEquals(commodityQueried.getLength(), commodity.getLength());
			assertEquals(commodityQueried.getWidth(), commodity.getWidth());
			assertEquals(commodityQueried.getHeight(), commodity.getHeight());
			assertEquals(commodityQueried.getWeight(), commodity.getWeight());
			assertEquals(commodityQueried.getSalesCountry(), commodity.getSalesCountry());
			assertEquals(commodityQueried.getUnit(), commodity.getUnit());
			assertEquals(commodityQueried.getUnitDesc(), commodity.getUnitDesc());
			assertEquals(commodityQueried.getSpecification(), commodity.getSpecification());
		
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
		/** saleprice */
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
		/** width */
		/** height */
		/** weight */
		commodity.setWeight(2);
		/** 产销国 */
		commodity.setSalesCountry(2L);
		/** 申报计量单位 见计量单位代码 */
		commodity.setUnit("2");
		/** 申报计量单位描述 */
		commodity.setUnitDesc("2");
		/** 商品规格、型号 */
		commodity.setSpecification("2");
		
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
		assertEquals(DateUtil.format(commodityUpdated.getValidTime(), "yyyy-mm-dd HH:MM"), 
			DateUtil.format(commodityUpdated.getValidTime(), "yyyy-mm-dd HH:MM"));
		assertEquals(DateUtil.format(commodityUpdated.getAuditTime(), "yyyy-mm-dd HH:MM"), 
			DateUtil.format(commodityUpdated.getAuditTime(), "yyyy-mm-dd HH:MM"));
		assertEquals(DateUtil.format(commodityUpdated.getLastTradingTime(), "yyyy-mm-dd HH:MM"), 
			DateUtil.format(commodityUpdated.getLastTradingTime(), "yyyy-mm-dd HH:MM"));
		assertEquals(DateUtil.format(commodityUpdated.getUpdatedatetime(), "yyyy-mm-dd HH:MM"), 
			DateUtil.format(commodityUpdated.getUpdatedatetime(), "yyyy-mm-dd HH:MM"));
		assertEquals(DateUtil.format(commodityUpdated.getCreatedatetime(), "yyyy-mm-dd HH:MM"), 
			DateUtil.format(commodityUpdated.getCreatedatetime(), "yyyy-mm-dd HH:MM"));
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
		assertEquals(commodityUpdated.getSalesCountry(), commodity.getSalesCountry());
		assertEquals(commodityUpdated.getUnit(), commodity.getUnit());
		assertEquals(commodityUpdated.getUnitDesc(), commodity.getUnitDesc());
		assertEquals(commodityUpdated.getSpecification(), commodity.getSpecification());
		
		//delete
		commodityDao.deleteById(commodity.getId());
		long deleteRows = commodityDao.count(query);
		assertEquals(startRows, deleteRows);
	}
}
