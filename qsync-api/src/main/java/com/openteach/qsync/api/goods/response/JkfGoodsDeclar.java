package com.openteach.qsync.api.goods.response;

import java.util.Date;

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
@XmlType(namespace="goods.response", name = "jkfGoodsDeclar")
public class JkfGoodsDeclar {

	/**
	 * 
	 */
	@XmlElement(required = true)
	private String personalGoodsFormNo;
	
	/**
	 * 
	 */
	@XmlElement(required = true)
	private String approveResult;
	
	/**
	 * 
	 */
	@XmlElement(required = true)
	private String approveComment;
	
	/**
	 * 
	 */
	@XmlElement(required = true)
	private Date processTime;
}
