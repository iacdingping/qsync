package com.openteach.qsync.api;

import javax.xml.bind.annotation.XmlAttribute;

import com.openteach.qsync.api.utils.JaxbUtils;


/**
 * 
 * @author rqq
 *
 */
public abstract class XmlRequest {
	
	public static final String DEFAULT_VERSION = "1.0.0";
	
	@XmlAttribute(required = true)
	private String version = DEFAULT_VERSION;
	
	/**
	 * 
	 * @return
	 */
	public String toXml() {
		return JaxbUtils.convertToXml(this);
	}
}
