package com.openteach.qsync.api.logistics.response;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;

import com.openteach.qsync.api.BaseBody;
import com.openteach.qsync.api.JkfResult;

/**
 * 
 * @author rqq
 *
 */
public class Body extends BaseBody {

	/**
	 * 
	 */
	@XmlElement(required = true)
	private List<JkfResult> list;

	public List<JkfResult> getList() {
		return list;
	}

	public void setList(List<JkfResult> list) {
		this.list = list;
	}
}
