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
		 */
		void onSucceed(XmlResponse response);
		
		/**
		 * 
		 * @param exception
		 */
		void onFailed(ApiException exception);
	}
	
	/**
	 * 
	 * @param request
	 * @return
	 * @throws ApiException
	 */
	public XmlResponse syncRequest(XmlRequest request) throws ApiException;
	
	/**
	 * 
	 * @param request
	 * @param callback
	 */
	public void asyncRequest(XmlRequest request, Callback callback);
}
