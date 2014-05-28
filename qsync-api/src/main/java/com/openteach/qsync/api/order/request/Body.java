package com.openteach.qsync.api.order.request;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.openteach.qsync.api.BaseBody;

/**
 * 商品订单发送跨境电商平台报文
 * @author IAC-DINGPING
 *
 */
@XmlRootElement(name="body", namespace="order.request")
public class Body extends BaseBody {

	/**
	 * 
	 */
	@XmlElementWrapper
	@XmlElement(required = true, name="orderInfo")
	private List<OrderInfo> orderInfoList;

	public List<OrderInfo> getOrderInfoList() {
		return orderInfoList;
	}

	public void setOrderInfoList(List<OrderInfo> orderInfoList) {
		this.orderInfoList = orderInfoList;
	}
}
