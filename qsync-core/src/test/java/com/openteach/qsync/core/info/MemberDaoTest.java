package com.openteach.qsync.core.info;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;

import com.openteach.qsync.core.SpringTransactionalTestCase;
import com.openteach.qsync.core.dao.info.MemberDao;
import com.openteach.qsync.core.entity.info.Member;
import com.openteach.qsync.core.query.info.MemberQuery;
import com.openteach.qsync.util.common.DateUtil;

/**
 *
 * @author dingp email:dingp@51box.cn
 * @version 1.0
 * @since 1.0
 * */
@DirtiesContext
public class MemberDaoTest extends SpringTransactionalTestCase{
	@Autowired
	private MemberDao memberDao;
	
	/**
	 * 注意只能单个库测试
	 * 因为对删除使用到count方法计数进行对比
	 * @throws Exception
	 */
	@Test
	public void memberCurl() throws Exception {
		MemberQuery query = new MemberQuery();
		long startRows = memberDao.count(query);
		List<Member> lists = memberDao.list(query);
		assertEquals(lists.size(), startRows);
		
		Member member = new Member();
		/** id */
		/** username */
		member.setUsername("1");
		/** picurl */
		member.setPicurl("1");
		/** randomcode */
		member.setRandomcode("1");
		/** email */
		member.setEmail("1");
		/** password */
		member.setPassword("1");
		/** status */
		member.setStatus(1);
		/** leftamount */
		/** regtime */
		member.setRegtime(new java.util.Date());
		/** truename */
		member.setTruename("1");
		/** handphone */
		member.setHandphone("1");
		/** telephone */
		member.setTelephone("1");
		/** payamount */
		/** score */
		member.setScore(1);
		/** lastlogtime */
		member.setLastlogtime(new java.util.Date());
		/** secondlogtime */
		member.setSecondlogtime(new java.util.Date());
		/** sex */
		member.setSex(1);
		/** birthday */
		member.setBirthday(new java.util.Date());
		/** age */
		member.setAge(1);
		/** nickname */
		member.setNickname("1");
		/** source */
		member.setSource(1);
		/** sourceid */
		member.setSourceid("1");
		/** ordertime */
		member.setOrdertime(new java.util.Date());
		/** restpasstime */
		member.setRestpasstime(new java.util.Date());
		/** isdeleted */
		member.setIsdeleted(1);
		/** countryId */
		member.setCountryId(1L);
		/** provinceId */
		member.setProvinceId(1L);
		/** cityId */
		member.setCityId(1L);
		/** address */
		member.setAddress("1");
		/** company */
		member.setCompany("1");
		/** firstname */
		member.setFirstname("1");
		/** lastname */
		member.setLastname("1");
		/** grade */
		member.setGrade(1);
		/** code */
		member.setCode("1");
		/** companyphonecountry */
		member.setCompanyphonecountry("1");
		/** companyphonearea */
		member.setCompanyphonearea("1");
		/** companyphone */
		member.setCompanyphone("1");
		/** companyfaxcountry */
		member.setCompanyfaxcountry("1");
		/** companyfaxarea */
		member.setCompanyfaxarea("1");
		/** companyfax */
		member.setCompanyfax("1");
		/** companyhandphonecountry */
		member.setCompanyhandphonecountry("1");
		/** companyhandphone */
		member.setCompanyhandphone("1");
		/** established */
		member.setEstablished(new java.util.Date());
		/** registrationid */
		member.setRegistrationid("1");
		/** productsscope */
		member.setProductsscope("1");
		/** salesvolume */
		member.setSalesvolume("1");
		/** importvolume */
		member.setImportvolume("1");
		/** description */
		member.setDescription("1");
		/** title */
		member.setTitle(1);
		/** companyaddress */
		member.setCompanyaddress("1");
		/** website */
		member.setWebsite("1");
		/** companycountryId */
		member.setCompanycountryId(1L);
		/** companyprovinceId */
		member.setCompanyprovinceId(1L);
		/** companycityId */
		member.setCompanycityId(1L);
		/** newnew */
		member.setNewnew("1");
		/** feedback */
		member.setFeedback("1");
		/** tradeguide */
		member.setTradeguide("1");
		/** optimizationhints */
		member.setOptimizationhints("1");
		/** vipaudit */
		member.setVipaudit(1);
		/** address1 */
		member.setAddress1("1");
		/** address2 */
		member.setAddress2("1");
		/** scity */
		member.setScity("1");
		/** sprovince */
		member.setSprovince("1");
		/** zip */
		member.setZip("1");
		/** phonenumber */
		member.setPhonenumber("1");
		/** ccity */
		member.setCcity("1");
		/** cprovince */
		member.setCprovince("1");
		/** positon */
		member.setPositon("1");
		/** contactmail */
		member.setContactmail("1");
		/** postalcode */
		member.setPostalcode("1");
		/** closecount */
		member.setClosecount(1);
		/** closeTime */
		member.setCloseTime(new java.util.Date());
		/** 证件类型 01:身份证（试点期间只能是身份证） 02:护照 03:其他 */
		member.setCertificatesType("1");
		/** 证件号码 */
		member.setCertificates("1");
		
		memberDao.save(member);
		long saveRows = memberDao.count(query);
		assertEquals(startRows + 1, saveRows);
		
		Member memberQueried = memberDao.getById(member.getId());
		assertNotNull("查询错误", memberQueried);
			assertEquals(memberQueried.getId(), member.getId());
			assertEquals(memberQueried.getUsername(), member.getUsername());
			assertEquals(memberQueried.getPicurl(), member.getPicurl());
			assertEquals(memberQueried.getRandomcode(), member.getRandomcode());
			assertEquals(memberQueried.getEmail(), member.getEmail());
			assertEquals(memberQueried.getPassword(), member.getPassword());
			assertEquals(memberQueried.getStatus(), member.getStatus());
			assertEquals(memberQueried.getLeftamount(), member.getLeftamount());
			assertEquals(DateUtil.format(memberQueried.getRegtime(), "yyyy-mm-dd HH:MM"), 
				DateUtil.format(member.getRegtime(), "yyyy-mm-dd HH:MM"));
			assertEquals(memberQueried.getTruename(), member.getTruename());
			assertEquals(memberQueried.getHandphone(), member.getHandphone());
			assertEquals(memberQueried.getTelephone(), member.getTelephone());
			assertEquals(memberQueried.getPayamount(), member.getPayamount());
			assertEquals(memberQueried.getScore(), member.getScore());
			assertEquals(DateUtil.format(memberQueried.getLastlogtime(), "yyyy-mm-dd HH:MM"), 
				DateUtil.format(member.getLastlogtime(), "yyyy-mm-dd HH:MM"));
			assertEquals(DateUtil.format(memberQueried.getSecondlogtime(), "yyyy-mm-dd HH:MM"), 
				DateUtil.format(member.getSecondlogtime(), "yyyy-mm-dd HH:MM"));
			assertEquals(memberQueried.getSex(), member.getSex());
			assertEquals(DateUtil.format(memberQueried.getBirthday(), "yyyy-mm-dd HH:MM"), 
				DateUtil.format(member.getBirthday(), "yyyy-mm-dd HH:MM"));
			assertEquals(memberQueried.getAge(), member.getAge());
			assertEquals(memberQueried.getNickname(), member.getNickname());
			assertEquals(memberQueried.getSource(), member.getSource());
			assertEquals(memberQueried.getSourceid(), member.getSourceid());
			assertEquals(DateUtil.format(memberQueried.getOrdertime(), "yyyy-mm-dd HH:MM"), 
				DateUtil.format(member.getOrdertime(), "yyyy-mm-dd HH:MM"));
			assertEquals(DateUtil.format(memberQueried.getRestpasstime(), "yyyy-mm-dd HH:MM"), 
				DateUtil.format(member.getRestpasstime(), "yyyy-mm-dd HH:MM"));
			assertEquals(memberQueried.getIsdeleted(), member.getIsdeleted());
			assertEquals(memberQueried.getCountryId(), member.getCountryId());
			assertEquals(memberQueried.getProvinceId(), member.getProvinceId());
			assertEquals(memberQueried.getCityId(), member.getCityId());
			assertEquals(memberQueried.getAddress(), member.getAddress());
			assertEquals(memberQueried.getCompany(), member.getCompany());
			assertEquals(memberQueried.getFirstname(), member.getFirstname());
			assertEquals(memberQueried.getLastname(), member.getLastname());
			assertEquals(memberQueried.getGrade(), member.getGrade());
			assertEquals(memberQueried.getCode(), member.getCode());
			assertEquals(memberQueried.getCompanyphonecountry(), member.getCompanyphonecountry());
			assertEquals(memberQueried.getCompanyphonearea(), member.getCompanyphonearea());
			assertEquals(memberQueried.getCompanyphone(), member.getCompanyphone());
			assertEquals(memberQueried.getCompanyfaxcountry(), member.getCompanyfaxcountry());
			assertEquals(memberQueried.getCompanyfaxarea(), member.getCompanyfaxarea());
			assertEquals(memberQueried.getCompanyfax(), member.getCompanyfax());
			assertEquals(memberQueried.getCompanyhandphonecountry(), member.getCompanyhandphonecountry());
			assertEquals(memberQueried.getCompanyhandphone(), member.getCompanyhandphone());
			assertEquals(DateUtil.format(memberQueried.getEstablished(), "yyyy-mm-dd HH:MM"), 
				DateUtil.format(member.getEstablished(), "yyyy-mm-dd HH:MM"));
			assertEquals(memberQueried.getRegistrationid(), member.getRegistrationid());
			assertEquals(memberQueried.getProductsscope(), member.getProductsscope());
			assertEquals(memberQueried.getSalesvolume(), member.getSalesvolume());
			assertEquals(memberQueried.getImportvolume(), member.getImportvolume());
			assertEquals(memberQueried.getDescription(), member.getDescription());
			assertEquals(memberQueried.getTitle(), member.getTitle());
			assertEquals(memberQueried.getCompanyaddress(), member.getCompanyaddress());
			assertEquals(memberQueried.getWebsite(), member.getWebsite());
			assertEquals(memberQueried.getCompanycountryId(), member.getCompanycountryId());
			assertEquals(memberQueried.getCompanyprovinceId(), member.getCompanyprovinceId());
			assertEquals(memberQueried.getCompanycityId(), member.getCompanycityId());
			assertEquals(memberQueried.getNewnew(), member.getNewnew());
			assertEquals(memberQueried.getFeedback(), member.getFeedback());
			assertEquals(memberQueried.getTradeguide(), member.getTradeguide());
			assertEquals(memberQueried.getOptimizationhints(), member.getOptimizationhints());
			assertEquals(memberQueried.getVipaudit(), member.getVipaudit());
			assertEquals(memberQueried.getAddress1(), member.getAddress1());
			assertEquals(memberQueried.getAddress2(), member.getAddress2());
			assertEquals(memberQueried.getScity(), member.getScity());
			assertEquals(memberQueried.getSprovince(), member.getSprovince());
			assertEquals(memberQueried.getZip(), member.getZip());
			assertEquals(memberQueried.getPhonenumber(), member.getPhonenumber());
			assertEquals(memberQueried.getCcity(), member.getCcity());
			assertEquals(memberQueried.getCprovince(), member.getCprovince());
			assertEquals(memberQueried.getPositon(), member.getPositon());
			assertEquals(memberQueried.getContactmail(), member.getContactmail());
			assertEquals(memberQueried.getPostalcode(), member.getPostalcode());
			assertEquals(memberQueried.getClosecount(), member.getClosecount());
			assertEquals(DateUtil.format(memberQueried.getCloseTime(), "yyyy-mm-dd HH:MM"), 
				DateUtil.format(member.getCloseTime(), "yyyy-mm-dd HH:MM"));
			assertEquals(memberQueried.getCertificatesType(), member.getCertificatesType());
			assertEquals(memberQueried.getCertificates(), member.getCertificates());
		
		/** username */
		member.setUsername("2");
		/** picurl */
		member.setPicurl("2");
		/** randomcode */
		member.setRandomcode("2");
		/** email */
		member.setEmail("2");
		/** password */
		member.setPassword("2");
		/** status */
		member.setStatus(2);
		/** leftamount */
		/** regtime */
		member.setRegtime(new java.util.Date());
		/** truename */
		member.setTruename("2");
		/** handphone */
		member.setHandphone("2");
		/** telephone */
		member.setTelephone("2");
		/** payamount */
		/** score */
		member.setScore(2);
		/** lastlogtime */
		member.setLastlogtime(new java.util.Date());
		/** secondlogtime */
		member.setSecondlogtime(new java.util.Date());
		/** sex */
		member.setSex(2);
		/** birthday */
		member.setBirthday(new java.util.Date());
		/** age */
		member.setAge(2);
		/** nickname */
		member.setNickname("2");
		/** source */
		member.setSource(2);
		/** sourceid */
		member.setSourceid("2");
		/** ordertime */
		member.setOrdertime(new java.util.Date());
		/** restpasstime */
		member.setRestpasstime(new java.util.Date());
		/** isdeleted */
		member.setIsdeleted(2);
		/** countryId */
		member.setCountryId(2L);
		/** provinceId */
		member.setProvinceId(2L);
		/** cityId */
		member.setCityId(2L);
		/** address */
		member.setAddress("2");
		/** company */
		member.setCompany("2");
		/** firstname */
		member.setFirstname("2");
		/** lastname */
		member.setLastname("2");
		/** grade */
		member.setGrade(2);
		/** code */
		member.setCode("2");
		/** companyphonecountry */
		member.setCompanyphonecountry("2");
		/** companyphonearea */
		member.setCompanyphonearea("2");
		/** companyphone */
		member.setCompanyphone("2");
		/** companyfaxcountry */
		member.setCompanyfaxcountry("2");
		/** companyfaxarea */
		member.setCompanyfaxarea("2");
		/** companyfax */
		member.setCompanyfax("2");
		/** companyhandphonecountry */
		member.setCompanyhandphonecountry("2");
		/** companyhandphone */
		member.setCompanyhandphone("2");
		/** established */
		member.setEstablished(new java.util.Date());
		/** registrationid */
		member.setRegistrationid("2");
		/** productsscope */
		member.setProductsscope("2");
		/** salesvolume */
		member.setSalesvolume("2");
		/** importvolume */
		member.setImportvolume("2");
		/** description */
		member.setDescription("2");
		/** title */
		member.setTitle(2);
		/** companyaddress */
		member.setCompanyaddress("2");
		/** website */
		member.setWebsite("2");
		/** companycountryId */
		member.setCompanycountryId(2L);
		/** companyprovinceId */
		member.setCompanyprovinceId(2L);
		/** companycityId */
		member.setCompanycityId(2L);
		/** newnew */
		member.setNewnew("2");
		/** feedback */
		member.setFeedback("2");
		/** tradeguide */
		member.setTradeguide("2");
		/** optimizationhints */
		member.setOptimizationhints("2");
		/** vipaudit */
		member.setVipaudit(2);
		/** address1 */
		member.setAddress1("2");
		/** address2 */
		member.setAddress2("2");
		/** scity */
		member.setScity("2");
		/** sprovince */
		member.setSprovince("2");
		/** zip */
		member.setZip("2");
		/** phonenumber */
		member.setPhonenumber("2");
		/** ccity */
		member.setCcity("2");
		/** cprovince */
		member.setCprovince("2");
		/** positon */
		member.setPositon("2");
		/** contactmail */
		member.setContactmail("2");
		/** postalcode */
		member.setPostalcode("2");
		/** closecount */
		member.setClosecount(2);
		/** closeTime */
		member.setCloseTime(new java.util.Date());
		/** 证件类型 01:身份证（试点期间只能是身份证） 02:护照 03:其他 */
		member.setCertificatesType("2");
		/** 证件号码 */
		member.setCertificates("2");
		
		memberDao.update(member);
		Member memberUpdated = memberDao.getById(member.getId());
		assertEquals(memberUpdated.getUsername(), member.getUsername());
		assertEquals(memberUpdated.getPicurl(), member.getPicurl());
		assertEquals(memberUpdated.getRandomcode(), member.getRandomcode());
		assertEquals(memberUpdated.getEmail(), member.getEmail());
		assertEquals(memberUpdated.getPassword(), member.getPassword());
		assertEquals(memberUpdated.getStatus(), member.getStatus());
		assertEquals(memberUpdated.getLeftamount(), member.getLeftamount());
		assertEquals(DateUtil.format(memberUpdated.getRegtime(), "yyyy-mm-dd HH:MM"), 
			DateUtil.format(memberUpdated.getRegtime(), "yyyy-mm-dd HH:MM"));
		assertEquals(memberUpdated.getTruename(), member.getTruename());
		assertEquals(memberUpdated.getHandphone(), member.getHandphone());
		assertEquals(memberUpdated.getTelephone(), member.getTelephone());
		assertEquals(memberUpdated.getPayamount(), member.getPayamount());
		assertEquals(memberUpdated.getScore(), member.getScore());
		assertEquals(DateUtil.format(memberUpdated.getLastlogtime(), "yyyy-mm-dd HH:MM"), 
			DateUtil.format(memberUpdated.getLastlogtime(), "yyyy-mm-dd HH:MM"));
		assertEquals(DateUtil.format(memberUpdated.getSecondlogtime(), "yyyy-mm-dd HH:MM"), 
			DateUtil.format(memberUpdated.getSecondlogtime(), "yyyy-mm-dd HH:MM"));
		assertEquals(memberUpdated.getSex(), member.getSex());
		assertEquals(DateUtil.format(memberUpdated.getBirthday(), "yyyy-mm-dd HH:MM"), 
			DateUtil.format(memberUpdated.getBirthday(), "yyyy-mm-dd HH:MM"));
		assertEquals(memberUpdated.getAge(), member.getAge());
		assertEquals(memberUpdated.getNickname(), member.getNickname());
		assertEquals(memberUpdated.getSource(), member.getSource());
		assertEquals(memberUpdated.getSourceid(), member.getSourceid());
		assertEquals(DateUtil.format(memberUpdated.getOrdertime(), "yyyy-mm-dd HH:MM"), 
			DateUtil.format(memberUpdated.getOrdertime(), "yyyy-mm-dd HH:MM"));
		assertEquals(DateUtil.format(memberUpdated.getRestpasstime(), "yyyy-mm-dd HH:MM"), 
			DateUtil.format(memberUpdated.getRestpasstime(), "yyyy-mm-dd HH:MM"));
		assertEquals(memberUpdated.getIsdeleted(), member.getIsdeleted());
		assertEquals(memberUpdated.getCountryId(), member.getCountryId());
		assertEquals(memberUpdated.getProvinceId(), member.getProvinceId());
		assertEquals(memberUpdated.getCityId(), member.getCityId());
		assertEquals(memberUpdated.getAddress(), member.getAddress());
		assertEquals(memberUpdated.getCompany(), member.getCompany());
		assertEquals(memberUpdated.getFirstname(), member.getFirstname());
		assertEquals(memberUpdated.getLastname(), member.getLastname());
		assertEquals(memberUpdated.getGrade(), member.getGrade());
		assertEquals(memberUpdated.getCode(), member.getCode());
		assertEquals(memberUpdated.getCompanyphonecountry(), member.getCompanyphonecountry());
		assertEquals(memberUpdated.getCompanyphonearea(), member.getCompanyphonearea());
		assertEquals(memberUpdated.getCompanyphone(), member.getCompanyphone());
		assertEquals(memberUpdated.getCompanyfaxcountry(), member.getCompanyfaxcountry());
		assertEquals(memberUpdated.getCompanyfaxarea(), member.getCompanyfaxarea());
		assertEquals(memberUpdated.getCompanyfax(), member.getCompanyfax());
		assertEquals(memberUpdated.getCompanyhandphonecountry(), member.getCompanyhandphonecountry());
		assertEquals(memberUpdated.getCompanyhandphone(), member.getCompanyhandphone());
		assertEquals(DateUtil.format(memberUpdated.getEstablished(), "yyyy-mm-dd HH:MM"), 
			DateUtil.format(memberUpdated.getEstablished(), "yyyy-mm-dd HH:MM"));
		assertEquals(memberUpdated.getRegistrationid(), member.getRegistrationid());
		assertEquals(memberUpdated.getProductsscope(), member.getProductsscope());
		assertEquals(memberUpdated.getSalesvolume(), member.getSalesvolume());
		assertEquals(memberUpdated.getImportvolume(), member.getImportvolume());
		assertEquals(memberUpdated.getDescription(), member.getDescription());
		assertEquals(memberUpdated.getTitle(), member.getTitle());
		assertEquals(memberUpdated.getCompanyaddress(), member.getCompanyaddress());
		assertEquals(memberUpdated.getWebsite(), member.getWebsite());
		assertEquals(memberUpdated.getCompanycountryId(), member.getCompanycountryId());
		assertEquals(memberUpdated.getCompanyprovinceId(), member.getCompanyprovinceId());
		assertEquals(memberUpdated.getCompanycityId(), member.getCompanycityId());
		assertEquals(memberUpdated.getNewnew(), member.getNewnew());
		assertEquals(memberUpdated.getFeedback(), member.getFeedback());
		assertEquals(memberUpdated.getTradeguide(), member.getTradeguide());
		assertEquals(memberUpdated.getOptimizationhints(), member.getOptimizationhints());
		assertEquals(memberUpdated.getVipaudit(), member.getVipaudit());
		assertEquals(memberUpdated.getAddress1(), member.getAddress1());
		assertEquals(memberUpdated.getAddress2(), member.getAddress2());
		assertEquals(memberUpdated.getScity(), member.getScity());
		assertEquals(memberUpdated.getSprovince(), member.getSprovince());
		assertEquals(memberUpdated.getZip(), member.getZip());
		assertEquals(memberUpdated.getPhonenumber(), member.getPhonenumber());
		assertEquals(memberUpdated.getCcity(), member.getCcity());
		assertEquals(memberUpdated.getCprovince(), member.getCprovince());
		assertEquals(memberUpdated.getPositon(), member.getPositon());
		assertEquals(memberUpdated.getContactmail(), member.getContactmail());
		assertEquals(memberUpdated.getPostalcode(), member.getPostalcode());
		assertEquals(memberUpdated.getClosecount(), member.getClosecount());
		assertEquals(DateUtil.format(memberUpdated.getCloseTime(), "yyyy-mm-dd HH:MM"), 
			DateUtil.format(memberUpdated.getCloseTime(), "yyyy-mm-dd HH:MM"));
		assertEquals(memberUpdated.getCertificatesType(), member.getCertificatesType());
		assertEquals(memberUpdated.getCertificates(), member.getCertificates());
		
		//delete
		memberDao.deleteById(member.getId());
		long deleteRows = memberDao.count(query);
		assertEquals(startRows, deleteRows);
	}
}
