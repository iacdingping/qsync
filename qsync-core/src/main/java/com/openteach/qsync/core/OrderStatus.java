package com.openteach.qsync.core;

/**
 * 现货订单状态 - 团批预定订单状态
 * <ul>
 * <li>0已取消 - 已取消</li>
 * <li>1待支付 - 待支付</li>
 * <li>2已确认 - 预付款已付</li>
 * <li>3准备中 - 准备中</li>
 * <li>4已发货 - 已发货</li>
 * <li>5已收货 - 已收货</li>
 * <li>6完成 - 完成</li>
 * <li>7订单 - 争议订单</li>
 * <li>8争议解决 - 争议解决</li>
 * <li>9NULL - 已确认</li>
 * </ul>
 * @author IAC-DINGPING
 *
 */
public enum OrderStatus {

	CANCEL,
	TOBE_PAY,
	SPOT_COMFIRMED_GROUP_PAIED,
	PREPARE,
	DELIVERED,
	RECEIVED,
	FINISHED,
	DISPUTE,
	DISPUTE_RESOLVED,
	GROUP_COMFIRMED;
}
