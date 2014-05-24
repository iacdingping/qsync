package com.openteach.qsync.core.dao.order;

import java.util.Map;

import com.openteach.qsync.core.BaseMyBatisRepository;
import com.openteach.qsync.core.MyBatisRepository;
import com.openteach.qsync.core.entity.order.Order;


/**
 *
 * @author dingp email:dingp@51box.cn
 * @version 1.0
 * @since 1.0
 * */
@MyBatisRepository
public interface OrderDao extends BaseMyBatisRepository<Order,java.lang.Long>{

	int updateDeclareStatus(Map<String, Object> params);

}
