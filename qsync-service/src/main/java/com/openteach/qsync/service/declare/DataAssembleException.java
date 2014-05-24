package com.openteach.qsync.service.declare;

/**
 * 
 * @author rqq
 *
 */
public class DataAssembleException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5859312751524049064L;

	/*
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 * 
	 * Constructors.
	 * 
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 */
	public DataAssembleException() {
        super();
    }

    public DataAssembleException(String msg) {
        super(msg);
    }

    public DataAssembleException(Throwable cause) {
        super(cause);
    }

    public DataAssembleException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
