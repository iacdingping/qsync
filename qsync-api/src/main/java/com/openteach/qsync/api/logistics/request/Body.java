package com.openteach.qsync.api.logistics.request;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;

import com.openteach.qsync.api.BaseBody;

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
	private List<Logistics> logisticsList;

	public List<Logistics> getLogisticsList() {
		return logisticsList;
	}

	public void setLogisticsList(List<Logistics> logisticsList) {
		this.logisticsList = logisticsList;
	}
}
