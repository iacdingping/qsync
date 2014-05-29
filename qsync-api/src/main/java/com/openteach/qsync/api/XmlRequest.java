package com.openteach.qsync.api;

import java.util.Arrays;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.openteach.qsync.api.goods.request.GoodsDeclar;
import com.openteach.qsync.api.goods.request.GoodsDeclarModule;
import com.openteach.qsync.api.utils.JaxbUtils;


/**
 * 
 * @author rqq
 *
 */
public class XmlRequest {
	
	public static final String DEFAULT_VERSION = "1.0.0";
	
	/**
	 * 
	 * @return
	 */
	public String toXml() {
		return JaxbUtils.convertToXml(this);
	}
}
