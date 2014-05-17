package com.openteach.qsync.core.manager.info;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.openteach.qsync.core.PageList;
import com.openteach.qsync.core.PageQuery;
import com.openteach.qsync.core.dao.info.MemberDao;
import com.openteach.qsync.core.entity.info.Member;
import com.openteach.qsync.core.query.info.MemberQuery;


/**
 *
 * @author dingp email:dingp@51box.cn
 * @version 1.0
 * @since 1.0
 * */
@Service
@Transactional
public class MemberManager {

	@Autowired
	private MemberDao memberDao;
	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性,请注意大小写*/
	public void setMemberDao(MemberDao dao) {
		this.memberDao = dao;
	}
	
	/** 
	 * 创建Member
	 **/
	public Member save(Member member) {
	    Assert.notNull(member,"'member' must be not null");
	    this.memberDao.save(member);
	    return member;
	}
	
	/** 
	 * 更新Member
	 **/	
    public Member update(Member member) {
        Assert.notNull(member,"'member' must be not null");
        this.memberDao.update(member);
        return member;
    }	
    
	/** 
	 * 删除Member
	 **/
    public void deleteById(java.lang.Long id) {
        this.memberDao.deleteById(id);
    }
    
	/** 
	 * 根据ID得到Member
	 **/    
    public Member getById(java.lang.Long id) {
        return this.memberDao.getById(id);
    }
    
	/** 
	 * 统计总数Member
	 **/ 
	public Long count(PageQuery query) {
		return memberDao.count(query);
	}
	
	/** 
	 * list Member
	 **/ 
	public List<Member> list(PageQuery query) {
		return memberDao.list(query);
	}
	
	/** 
	 * 分页查询: Member
	 **/      
	@Transactional(readOnly=true)
	public PageList<Member> findPage(MemberQuery query) {
	    Assert.notNull(query,"'query' must be not null");
		return new PageList<Member>(list(query), 
				query.getPage(), query.getPageSize(), count(query));
	}
	
}
