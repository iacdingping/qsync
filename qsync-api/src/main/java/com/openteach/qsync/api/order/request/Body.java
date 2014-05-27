package com.openteach.qsync.api.order.request;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import com.openteach.qsync.api.BaseBody;

/**
 * 商品订单发送跨境电商平台报文
 * @author IAC-DINGPING
 *
 */
@XmlType (namespace="order.request", name="body")
public class Body extends BaseBody {

	/**
	 * 
	 */
	@XmlElement(required = true)
	private List<OrderInfo> orderInfoList;

	public List<OrderInfo> getOrderInfoList() {
		return orderInfoList;
	}

	public void setOrderInfoList(List<OrderInfo> orderInfoList) {
		this.orderInfoList = orderInfoList;
	}
}
