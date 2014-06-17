package com.openteach.qsync.core.goods;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;

import com.openteach.qsync.core.SpringTransactionalTestCase;
import com.openteach.qsync.core.dao.goods.CategoryDao;
import com.openteach.qsync.core.entity.goods.Category;
import com.openteach.qsync.core.query.goods.CategoryQuery;
import com.openteach.qsync.util.common.DateUtil;

/**
 *
 * @author dingp email:dingp@51box.cn
 * @version 1.0
 * @since 1.0
 * */
@DirtiesContext
public class CategoryDaoTest extends SpringTransactionalTestCase{
	@Autowired
	private CategoryDao categoryDao;
	
	/**
	 * 注意只能单个库测试
	 * 因为对删除使用到count方法计数进行对比
	 * @throws Exception
	 */
	@Test
	public void categoryCurl() throws Exception {
		CategoryQuery query = new CategoryQuery();
		long startRows = categoryDao.count(query);
		List<Category> lists = categoryDao.list(query);
		assertEquals(lists.size(), startRows);
		
		Category category = new Category();
		/** id */
		/** name */
		category.setName("1");
		/** picurl */
		category.setPicurl("1");
		/** pic */
		category.setPic("1");
		/** isparent */
		category.setIsparent("1");
		/** isshow */
		category.setIsshow("1");
		/** listorder */
		category.setListorder(1);
		/** isdeleted */
		category.setIsdeleted("1");
		/** cid */
		category.setCid(1L);
		/** source */
		category.setSource(1);
		/** highid */
		category.setHighid(1L);
		/** creatoradmin */
		category.setCreatoradmin(1L);
		/** modifieradmin */
		category.setModifieradmin(1L);
		/** createdatetime */
		category.setCreatedatetime(new java.util.Date());
		/** updatedatetime */
		category.setUpdatedatetime(new java.util.Date());
		/** seokeyword */
		category.setSeokeyword("1");
		/** seodescription */
		category.setSeodescription("1");
		/** taxrate */
		/** 行邮税号 必须已备案，且与参数说明文档中的行邮税号中的税号一致 */
		category.setTariff("1");
		
		categoryDao.save(category);
		long saveRows = categoryDao.count(query);
		assertEquals(startRows + 1, saveRows);
		
		Category categoryQueried = categoryDao.getById(category.getId());
		assertNotNull("查询错误", categoryQueried);
			assertEquals(categoryQueried.getId(), category.getId());
			assertEquals(categoryQueried.getName(), category.getName());
			assertEquals(categoryQueried.getPicurl(), category.getPicurl());
			assertEquals(categoryQueried.getPic(), category.getPic());
			assertEquals(categoryQueried.getIsparent(), category.getIsparent());
			assertEquals(categoryQueried.getIsshow(), category.getIsshow());
			assertEquals(categoryQueried.getListorder(), category.getListorder());
			assertEquals(categoryQueried.getIsdeleted(), category.getIsdeleted());
			assertEquals(categoryQueried.getCid(), category.getCid());
			assertEquals(categoryQueried.getSource(), category.getSource());
			assertEquals(categoryQueried.getHighid(), category.getHighid());
			assertEquals(categoryQueried.getCreatoradmin(), category.getCreatoradmin());
			assertEquals(categoryQueried.getModifieradmin(), category.getModifieradmin());
			assertEquals(DateUtil.format(categoryQueried.getCreatedatetime(), "yyyy-mm-dd HH:MM"), 
				DateUtil.format(category.getCreatedatetime(), "yyyy-mm-dd HH:MM"));
			assertEquals(DateUtil.format(categoryQueried.getUpdatedatetime(), "yyyy-mm-dd HH:MM"), 
				DateUtil.format(category.getUpdatedatetime(), "yyyy-mm-dd HH:MM"));
			assertEquals(categoryQueried.getSeokeyword(), category.getSeokeyword());
			assertEquals(categoryQueried.getSeodescription(), category.getSeodescription());
			assertEquals(categoryQueried.getTaxrate(), category.getTaxrate());
			assertEquals(categoryQueried.getTariff(), category.getTariff());
		
		/** name */
		category.setName("2");
		/** picurl */
		category.setPicurl("2");
		/** pic */
		category.setPic("2");
		/** isparent */
		category.setIsparent("2");
		/** isshow */
		category.setIsshow("2");
		/** listorder */
		category.setListorder(2);
		/** isdeleted */
		category.setIsdeleted("2");
		/** cid */
		category.setCid(2L);
		/** source */
		category.setSource(2);
		/** highid */
		category.setHighid(2L);
		/** creatoradmin */
		category.setCreatoradmin(2L);
		/** modifieradmin */
		category.setModifieradmin(2L);
		/** createdatetime */
		category.setCreatedatetime(new java.util.Date());
		/** updatedatetime */
		category.setUpdatedatetime(new java.util.Date());
		/** seokeyword */
		category.setSeokeyword("2");
		/** seodescription */
		category.setSeodescription("2");
		/** taxrate */
		/** 行邮税号 必须已备案，且与参数说明文档中的行邮税号中的税号一致 */
		category.setTariff("2");
		
		categoryDao.update(category);
		Category categoryUpdated = categoryDao.getById(category.getId());
		assertEquals(categoryUpdated.getName(), category.getName());
		assertEquals(categoryUpdated.getPicurl(), category.getPicurl());
		assertEquals(categoryUpdated.getPic(), category.getPic());
		assertEquals(categoryUpdated.getIsparent(), category.getIsparent());
		assertEquals(categoryUpdated.getIsshow(), category.getIsshow());
		assertEquals(categoryUpdated.getListorder(), category.getListorder());
		assertEquals(categoryUpdated.getIsdeleted(), category.getIsdeleted());
		assertEquals(categoryUpdated.getCid(), category.getCid());
		assertEquals(categoryUpdated.getSource(), category.getSource());
		assertEquals(categoryUpdated.getHighid(), category.getHighid());
		assertEquals(categoryUpdated.getCreatoradmin(), category.getCreatoradmin());
		assertEquals(categoryUpdated.getModifieradmin(), category.getModifieradmin());
		assertEquals(DateUtil.format(categoryUpdated.getCreatedatetime(), "yyyy-mm-dd HH:MM"), 
			DateUtil.format(categoryUpdated.getCreatedatetime(), "yyyy-mm-dd HH:MM"));
		assertEquals(DateUtil.format(categoryUpdated.getUpdatedatetime(), "yyyy-mm-dd HH:MM"), 
			DateUtil.format(categoryUpdated.getUpdatedatetime(), "yyyy-mm-dd HH:MM"));
		assertEquals(categoryUpdated.getSeokeyword(), category.getSeokeyword());
		assertEquals(categoryUpdated.getSeodescription(), category.getSeodescription());
		assertEquals(categoryUpdated.getTaxrate(), category.getTaxrate());
		assertEquals(categoryUpdated.getTariff(), category.getTariff());
		
		//delete
		categoryDao.deleteById(category.getId());
		long deleteRows = categoryDao.count(query);
		assertEquals(startRows, deleteRows);
	}
}
