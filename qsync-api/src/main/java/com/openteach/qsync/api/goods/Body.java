package com.openteach.qsync.api.goods;

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
	private List<GoodsDeclarModule> goodsDeclarModuleList;

	public List<GoodsDeclarModule> getGoodsDeclarModuleList() {
		return goodsDeclarModuleList;
	}

	public void setGoodsDeclarModuleList(
			List<GoodsDeclarModule> goodsDeclarModuleList) {
		this.goodsDeclarModuleList = goodsDeclarModuleList;
	}
}
