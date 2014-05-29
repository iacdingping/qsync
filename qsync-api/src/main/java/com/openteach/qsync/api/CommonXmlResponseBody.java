package com.openteach.qsync.api;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;

import com.openteach.qsync.api.JkfResult;

/**
 * 
 * @author rqq
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType (name="body")
public class CommonXmlResponseBody {

	/**
	 * 
	 */
	@XmlElementWrapper
	@XmlElement(required = true, name="jkfResult")
	private List<JkfResult> list;

	public List<JkfResult> getList() {
		return list;
	}

	public void setList(List<JkfResult> list) {
		this.list = list;
	}
}
