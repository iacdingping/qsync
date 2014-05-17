package com.openteach.qsync.core.declare;

/**
 * 支付类型 01:银行卡支付 02:余额支付 03:其他
 * 平台支付方式 1paypal 2skril 都属于第三方支付 ？
 * @author IAC-DINGPING
 * @see DeclarePayType
 */
public enum DeclarePayTypeEmun {
	BANK_CARD("01"), 
	BALANCE("02"), 
	OTHER("03");
	
	private String type;
	private DeclarePayTypeEmun(String type) {
		this.type = type;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
