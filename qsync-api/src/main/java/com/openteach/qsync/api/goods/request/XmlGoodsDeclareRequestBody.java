package com.openteach.qsync.api.goods.request;

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
@XmlType (name="body")
public class XmlGoodsDeclareRequestBody {

	/**
	 * 
	 */
	@XmlElementWrapper
	@XmlElement(required = true, name="goodsDeclareModule")
	private List<GoodsDeclareModule> goodsDeclareModuleList;

	public List<GoodsDeclareModule> getGoodsDeclareModuleList() {
		return goodsDeclareModuleList;
	}
	public void setGoodsDeclareModuleList(
			List<GoodsDeclareModule> goodsDeclareModuleList) {
		this.goodsDeclareModuleList = goodsDeclareModuleList;
	}

}
