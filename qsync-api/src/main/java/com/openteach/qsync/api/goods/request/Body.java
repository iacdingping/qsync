package com.openteach.qsync.api.goods.request;

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
@XmlType (namespace="goods.request", name="body")
public class Body extends BaseBody {

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
