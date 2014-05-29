package com.openteach.qsync.api.logistics.request;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;

/**
 * 
 * @author rqq
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "body")
public class XmlLogisticsRequestBody {

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
