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
	 * @return
	 * @throws ApiException
	 */
	XmlResponse sync(XmlRequest request) throws ApiException;
	
	/**
	 * 
	 * @param request
	 * @param callback
	 */
	void async(XmlRequest request, Callback callback);
	
	/**
	 * 
	 * @param request
	 * @param callback
	 * @param context
	 */
	void async(XmlRequest request, Callback callback, Object context);
}
