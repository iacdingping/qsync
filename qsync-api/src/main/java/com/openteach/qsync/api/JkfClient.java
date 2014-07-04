package com.openteach.qsync.api;

import com.openteach.qcity.qsync.common.api.TaskStatus;
import com.openteach.qsync.api.exception.ApiException;

/**
 * 
 * @author rqq
 *
 */
public interface JkfClient {

	/**
	 * 
	 * @author rqq
	 *
	 */
	public static interface Callback {
		
		/**
		 * 
		 * @param exception
		 * @param context
		 */
		void onFailed(ApiException exception, Object context);
		
		/**
		 * 需要设置response的taskStatus
		 * @param response
		 * @param context
		 */
		void onStateChanged(XmlResponse response, Object context);
	}
	
	/**
	 * 
	 * @param request
	 * @param responseKey
	 * @param responseClass
	 * @param isRecovered
	 * @return
	 * @throws ApiException
	 */
	XmlResponse sync(XmlRequest request, String responseKey, Class<? extends XmlResponse> responseClass, boolean isRecovered) throws ApiException;
	
	/**
	 * 
	 * @param request
	 * @param callback
	 * @param responseKey
	 * @param responseClass
	 * @param isRecovered
	 */
	void async(XmlRequest request, Callback callback, String responseKey, Class<? extends XmlResponse> responseClass, boolean isRecovered);
	
	/**
	 * 
	 * @param request
	 * @param callback
	 * @param context
	 * @param responseKey
	 * @param responseClass
	 * @param isRecovered
	 */
	void async(XmlRequest request, Callback callback, Object context, String responseKey, Class<? extends XmlResponse> responseClass, boolean isRecovered);
	
	/**
	 * 更新状态
	 * @param businessNo
	 * @param status
	 * @param message
	 * @return
	 */
	boolean updateStatus(String businessNo, TaskStatus status, String message);
}
