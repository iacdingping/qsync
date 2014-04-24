package com.openteach.qsync.api.logistics;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * 
 * @author rqq
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wayBill")
public class WayBill {
	
	/**
	 * 
	 */
	@XmlElement(required = true)
	private JkfSign jkfSign;
	
	/**
	 * 
	 */
	@XmlElement(required = true)
	private WayBillImportDto wayBillImportDto;

	public JkfSign getJkfSign() {
		return jkfSign;
	}

	public void setJkfSign(JkfSign jkfSign) {
		this.jkfSign = jkfSign;
	}

	public WayBillImportDto getWayBillImportDto() {
		return wayBillImportDto;
	}

	public void setWayBillImportDto(WayBillImportDto wayBillImportDto) {
		this.wayBillImportDto = wayBillImportDto;
	}
}
