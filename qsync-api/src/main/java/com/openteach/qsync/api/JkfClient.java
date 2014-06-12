package com.openteach.qsync.api;

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
		 * @param response
		 * @param context
		 */
		void onSucceed(XmlResponse response, Object context);
		
		/**
		 * 
		 * @param exception
		 * @param context
		 */
		void onFailed(ApiException exception, Object context);
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
}
