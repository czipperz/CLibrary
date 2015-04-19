package io.czipperz.github.cLibrary.exceptions;

/**
 * A {@link RuntimeException} that indicates that the method should not be called.
 * @author czipperz
 */
public class CDoNotCallException extends RuntimeException {
	public CDoNotCallException() {
		super("Do Not Call That Method!");
	}
}
