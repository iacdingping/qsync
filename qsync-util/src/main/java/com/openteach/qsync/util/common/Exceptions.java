package com.openteach.qsync.util.common;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * 关于异常的工具类.
 * 
 * @author calvin
 */
public class Exceptions {

	/**
	 * 将CheckedException转换为UncheckedException.
	 */
	public static RuntimeException unchecked(Exception e) {
		if (e instanceof RuntimeException) {
			return (RuntimeException) e;
		} else {
			return new RuntimeException(e);
		}
	}

	/**
	 * 将ErrorStack转化为String.
	 */
	public static String getStackTraceAsString(Throwable e) {
		StringWriter stringWriter = new StringWriter();
		e.printStackTrace(new PrintWriter(stringWriter));
		return stringWriter.toString();
	}

	public static String getCurrentStackTrace() {
		StringBuffer sb = new StringBuffer();
		for(StackTraceElement ste : Thread.currentThread().getStackTrace()) { 
			sb.append("at ").append(ste.getClassName()).append(".").append(ste.getMethodName()).append("(").append(ste.getLineNumber()).append(")").append("\n");
		}
		return sb.toString();
	}
	
	/**
	 * 判断异常是否由某些底层的异常引起.
	 */
	public static boolean isCausedBy(Exception ex, Class<? extends Exception>... causeExceptionClasses) {
		Throwable cause = ex.getCause();
		while (cause != null) {
			for (Class<? extends Exception> causeClass : causeExceptionClasses) {
				if (causeClass.isInstance(cause)) {
					return true;
				}
			}
			cause = cause.getCause();
		}
		return false;
	}
	
	public static void main(String[] args) {
		System.out.println(getCurrentStackTrace());
	}
}
