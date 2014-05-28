package com.openteach.qsync.api.logistics.request;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;

import com.openteach.qsync.api.BaseBody;

/**
 * 
 * @author rqq
 *
 */
@XmlType (namespace="logistics.request", name="body")
public class Body extends BaseBody {

	/**
	 * 
	 */
	@XmlElementWrapper
	@XmlElement(required = true, name="logistics")
	private List<Logistics> logisticsList;

	public List<Logistics> getLogisticsList() {
		return logisticsList;
	}

	public void setLogisticsList(List<Logistics> logisticsList) {
		this.logisticsList = logisticsList;
	}
}
