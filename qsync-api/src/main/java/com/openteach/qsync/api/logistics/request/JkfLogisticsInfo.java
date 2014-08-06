package com.openteach.qsync.api.logistics.request;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.openteach.qsync.api.utils.JaxbDateSerializer;

/**
 * 
 * @author rqq
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "jkfLogisticsInfo")
public class JkfLogisticsInfo {

	/**
	 * 
	 */
	@XmlElement(required = true)
	private String logisticsCompanyNo;
	
	/**
	 * 
	 */
	@XmlElement(required = true)
	private String logisticsCompanyName;
	
	/**
	 * 
	 */
	@XmlElement(required = true)
	private String logisticsWaybillNo;
	
	/**
	 * 
	 */
	@XmlElement(required = true)
	private Integer logisticsTraceState;
	
	/**
	 * 
	 */
	@XmlElement(required = true)
	private Double weight;
	
	/**
	 * 
	 */
	@XmlElement(required = true)
	private Integer pieceNumber;
	
	/**
	 * 
	 */
	@XmlElement(required = true)
	@XmlJavaTypeAdapter(JaxbDateSerializer.class)
	private Date handleTimeStr;
	
	/**
	 * 
	 */
	@XmlElement(required = true)
	private String stationCode;
	
	/**
	 * 
	 */
	@XmlElement(required = true)
	private String licensePlateNumber;

	public String getLogisticsCompanyNo() {
		return logisticsCompanyNo;
	}

	public void setLogisticsCompanyNo(String logisticsCompanyNo) {
		this.logisticsCompanyNo = logisticsCompanyNo;
	}

	public String getLogisticsCompanyName() {
		return logisticsCompanyName;
	}

	public void setLogisticsCompanyName(String logisticsCompanyName) {
		this.logisticsCompanyName = logisticsCompanyName;
	}

	public String getLogisticsWaybillNo() {
		return logisticsWaybillNo;
	}

	public void setLogisticsWaybillNo(String logisticsWaybillNo) {
		this.logisticsWaybillNo = logisticsWaybillNo;
	}

	public Integer getLogisticsTraceState() {
		return logisticsTraceState;
	}

	public void setLogisticsTraceState(Integer logisticsTraceState) {
		this.logisticsTraceState = logisticsTraceState;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public Integer getPieceNumber() {
		return pieceNumber;
	}

	public void setPieceNumber(Integer pieceNumber) {
		this.pieceNumber = pieceNumber;
	}

	public Date getHandleTimeStr() {
		return handleTimeStr;
	}

	public void setHandleTimeStr(Date handleTimeStr) {
		this.handleTimeStr = handleTimeStr;
	}

	public String getStationCode() {
		return stationCode;
	}

	public void setStationCode(String stationCode) {
		this.stationCode = stationCode;
	}

	public String getLicensePlateNumber() {
		return licensePlateNumber;
	}

	public void setLicensePlateNumber(String licensePlateNumber) {
		this.licensePlateNumber = licensePlateNumber;
	}
}
