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
	 * @param responseClass
	 * @return
	 * @throws ApiException
	 */
	XmlResponse sync(XmlRequest request, Class<? extends XmlResponse> responseClass) throws ApiException;
	
	/**
	 * 
	 * @param request
	 * @param callback
	 * @param responseClass
	 */
	void async(XmlRequest request, Callback callback, Class<? extends XmlResponse> responseClass);
	
	/**
	 * 
	 * @param request
	 * @param callback
	 * @param context
	 * @param responseClass
	 */
	void async(XmlRequest request, Callback callback, Object context, Class<? extends XmlResponse> responseClass);
}
