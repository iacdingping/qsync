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
	 * @param String responseKey
	 * @param responseClass
	 * @return
	 * @throws ApiException
	 */
	XmlResponse sync(XmlRequest request, String responseKey, Class<? extends XmlResponse> responseClass) throws ApiException;
	
	/**
	 * 
	 * @param request
	 * @param callback
	 * @param String responseKey
	 * @param responseClass
	 */
	void async(XmlRequest request, Callback callback, String responseKey, Class<? extends XmlResponse> responseClass);
	
	/**
	 * 
	 * @param request
	 * @param callback
	 * @param context
	 * @param String responseKey
	 * @param responseClass
	 */
	void async(XmlRequest request, Callback callback, Object context, String responseKey, Class<? extends XmlResponse> responseClass);
}
