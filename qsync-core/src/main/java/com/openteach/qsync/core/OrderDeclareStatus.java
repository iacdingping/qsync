package com.openteach.qsync.core;

/**
 * 
 * @author IAC-DINGPING
 *
 */
public enum OrderDeclareStatus {

	READY("00000", "初始化状态"),
	INITIALIZE("10000", "加载进内存");
	
	private String value;
	private String desc;
	private OrderDeclareStatus(String value, String desc) {
		this.value = value;
		this.desc = desc;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
}
