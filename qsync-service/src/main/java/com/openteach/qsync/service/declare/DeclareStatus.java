package com.openteach.qsync.service.declare;

/**
 * 申报状态
 * 申报开始 0 -> 数据预载入 1 -> 申报提交失败 2<br>
 * *****************************************  -> 申报提交成功 3<br>
 * 
 * 申报回执<br>
 * 申报回执获取超时 4<br>
 * 申报回执失败 5<br>
 * 申报回执成功 6<br>
 * @author IAC-DINGPING
 *
 */
public enum DeclareStatus {

	START, 
	PREPARED,
	DECLARE_ACCESS_FAILURE,
	DECLARE_ACCESS_SUCCESS,
	
	RECEIPT_RECEIVE_TIMEOUT,
	RECEIPT_FAULURE,
	RECEIPT_SUCCESS;
}
