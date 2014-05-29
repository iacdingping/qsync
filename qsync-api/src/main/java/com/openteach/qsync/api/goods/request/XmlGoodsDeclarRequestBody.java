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
public class XmlGoodsDeclarRequestBody {

	/**
	 * 
	 */
	@XmlElementWrapper
	@XmlElement(required = true, name="goodsDeclarModule")
	private List<GoodsDeclarModule> goodsDeclarModuleList;

	public List<GoodsDeclarModule> getGoodsDeclarModuleList() {
		return goodsDeclarModuleList;
	}

	public void setGoodsDeclarModuleList(
			List<GoodsDeclarModule> goodsDeclarModuleList) {
		this.goodsDeclarModuleList = goodsDeclarModuleList;
	}
}
