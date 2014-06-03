package com.openteach.qsync.api;

import com.openteach.qsync.api.utils.JaxbUtils;


/**
 * 
 * @author rqq
 *
 */
public abstract class XmlRequest {
	
	public static final String DEFAULT_VERSION = "1.0.0";
	
	/**
	 * 
	 */
	private String responseFileNameKey;
	
	/**
	 * 
	 * @return
	 */
	public String toXml() {
		return JaxbUtils.convertToXml(this);
	}
	
	public String getResponseFileNameKey() {
		return responseFileNameKey;
	}

	public void setResponseFileNameKey(String responseFileNameKey) {
		this.responseFileNameKey = responseFileNameKey;
	}
}
