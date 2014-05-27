package com.openteach.qsync.api;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * 
 * @author rqq
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso({
	com.openteach.qsync.api.goods.request.Body.class,
	com.openteach.qsync.api.goods.response.Body.class,
	com.openteach.qsync.api.logistics.request.Body.class,
	com.openteach.qsync.api.logistics.response.Body.class,
	com.openteach.qsync.api.order.request.Body.class,
	com.openteach.qsync.api.waybill.request.Body.class,
	com.openteach.qsync.api.waybill.response.Body.class,
	com.openteach.qsync.api.record.request.Body.class,
	com.openteach.qsync.api.record.response.Body.class
	})
public class BaseBody {

}
