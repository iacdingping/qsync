package com.openteach.qsync.api;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

/**
 * 
 * @author rqq
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "body")
@XmlSeeAlso({
	com.openteach.qsync.api.goods.request.Body.class,
	com.openteach.qsync.api.logistics.request.Body.class,
	com.openteach.qsync.api.order.request.Body.class,
	com.openteach.qsync.api.waybill.request.Body.class
	})
public class BaseBody {

}
