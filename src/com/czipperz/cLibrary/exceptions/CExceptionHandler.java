package com.czipperz.cLibrary.exceptions;


/**
 * An abstract class that converts an {@link Exception} to a {@link RuntimeException}
 * @author Chris Gregory
 */
public final class CExceptionHandler {
	private CExceptionHandler() {}
	public static RuntimeException handle(Exception e) {
		if(e instanceof RuntimeException)
			return (RuntimeException) e;
		return new RuntimeException(e);
	}
}
