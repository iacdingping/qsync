package com.openteach.qsync.api.waybill.request;

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
	private List<WayBill> wayBillList;

	public List<WayBill> getWayBillList() {
		return wayBillList;
	}

	public void setWayBillList(List<WayBill> wayBillList) {
		this.wayBillList = wayBillList;
	}
}
