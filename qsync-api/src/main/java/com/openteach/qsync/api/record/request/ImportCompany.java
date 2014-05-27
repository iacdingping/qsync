package com.openteach.qsync.api.record.request;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace="record.request", name = "ImportCompany")
public class ImportCompany {

	/**
	 * 
	 */
	@XmlElement(required = true)
	private String busiId;
	
	/**
	 * 
	 */
	@XmlElement(required = false)
	private String companyCode;
	
	/**
	 * 
	 */
	@XmlElement(required = true)
	private String orgCode;
	
	/**
	 * 
	 */
	@XmlElement(required = true)
	private String companyName;
	
	/**
	 * 
	 */
	@XmlElement(required = true)
	private int companyType;
	
	/**
	 * 
	 */
	@XmlElement(required = true)
	private String companyAddress;
	
	/**
	 * 
	 */
	@XmlElement(required = false)
	private double registeredCapital;
	
	/**
	 * 
	 */
	@XmlElement(required = false)
	private double totalInvestment;
	
	/**
	 * 
	 */
	@XmlElement(required = true)
	private String contactPerson;
	
	/**
	 * 
	 */
	@XmlElement(required = true)
	private String contactInfo;
	
	/**
	 * 
	 */
	@XmlElement(required = false)
	private String faxNo;
	
	/**
	 * 
	 */
	@XmlElement(required = false)
	private String zipCode;
	
	/**
	 * 
	 */
	@XmlElement(required = true)
	private String websiteUrl;
	
	/**
	 * 
	 */
	@XmlElement(required = true)
	private String email;
	
	/**
	 * 
	 */
	@XmlElement(required = true)
	private String customsCode;
}
