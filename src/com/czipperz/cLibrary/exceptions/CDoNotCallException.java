package com.czipperz.cLibrary.exceptions;

/**
 * A {@link RuntimeException} that indicates that the method should not be called.
 * @author Chris Gregory
 */
public class CDoNotCallException extends RuntimeException {
	public CDoNotCallException() {
		super("Do Not Call That Method!");
	}
}
