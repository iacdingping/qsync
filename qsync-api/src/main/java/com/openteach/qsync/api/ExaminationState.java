package com.openteach.qsync.api;

public enum ExaminationState {

	NOT_ACCESS(32, "不接受申报", false),
	EXAMINATION_PASS(99, "电子审单通过", true),
	REFUSED(42, "接单拒绝", false),
	REVOKE(80, "申报单撤销", false),
	ASSEMBLY_LINE_PASS(51, "流水线自动放行", true),
	DERECT_PASS(53, "直接放行", true),
	HANDSEL_PASS(52, "手工放行", true),
	UNKNOW(-999999, "未知状态", false);
	
	public ExaminationState getByState(Integer state) {
		for(ExaminationState es : ExaminationState.values()) {
			if(es.getState().intValue() == state.intValue()) 
				return es;
		}
		return UNKNOW;
	}
	
	private Integer state;
	private String desc;
	private boolean success = false;
	private ExaminationState(Integer state, String desc, boolean success) {
		this.state = state;
		this.desc = desc;
		this.success = success;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
}
