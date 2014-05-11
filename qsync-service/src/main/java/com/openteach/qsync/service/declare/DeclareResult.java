package com.openteach.qsync.service.declare;

/**
 * 申报结果 上传ftp 结果
 * @author IAC-DINGPING
 *
 */
public class DeclareResult {

	private boolean success;
	/**
	 * 文件名
	 */
	private String fileName;
	private String message;
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
