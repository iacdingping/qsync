package com.openteach.qsync.task;

import com.openteach.qsync.api.CommonXmlResponse;
import com.openteach.qsync.api.XmlRequest;
import com.openteach.qsync.api.XmlResponse;
import com.openteach.qsync.api.goods.request.XmlGoodsDeclarRequest;
import com.openteach.qsync.api.logistics.request.XmlLogisticsRequest;
import com.openteach.qsync.api.order.request.XmlOrderRequest;
import com.openteach.qsync.api.utils.JaxbUtils;
import com.openteach.qsync.api.waybill.request.XmlWaybillRequest;
import com.openteach.qsync.core.TaskType;
import com.openteach.qsync.core.entity.system.CcSyncTaks;

/**
 * 
 * @author rqq
 *
 */
public class TaskUtils {

	/**
	 * 
	 * @param t
	 * @return
	 */
	public static Object[] formXml(CcSyncTaks t) {
		XmlRequest r = null;
		Class<? extends XmlResponse> clazz = null;
		TaskType type = TaskType.valueOf(t.getType());
		if(TaskType.GOODS_DECLARE == type) {
			r = JaxbUtils.converyToJavaBean(t.getXmlRequest(), XmlGoodsDeclarRequest.class);
			clazz = CommonXmlResponse.class;
		} else if(TaskType.LOGISTICS_DECLARE == type) {
			r = JaxbUtils.converyToJavaBean(t.getXmlRequest(), XmlLogisticsRequest.class);
			clazz = CommonXmlResponse.class;
		} else if(TaskType.ORDER_DECLARE == type) {
			r = JaxbUtils.converyToJavaBean(t.getXmlRequest(), XmlOrderRequest.class);
			clazz = CommonXmlResponse.class;
		} else if(TaskType.WAY_BILL_DECLARE == type) {
			r = JaxbUtils.converyToJavaBean(t.getXmlRequest(), XmlWaybillRequest.class);
			clazz = CommonXmlResponse.class;
		}
		if(null == r || null == clazz) {
			return null;
		}
		return new Object[]{type, r, clazz};
	}
}
