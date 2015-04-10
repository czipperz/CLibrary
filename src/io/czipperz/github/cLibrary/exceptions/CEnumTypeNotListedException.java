package io.czipperz.github.cLibrary.exceptions;

/**
 * This {@link RuntimeException} is called when testing an enum for various values and the value of the enum is not one listed in the if, if else.<u></u>.<u></u>.<u></u> statement.
 * @author Chris Gregory
 *
 */
public class CEnumTypeNotListedException extends RuntimeException {
	private static final long serialVersionUID = -3385899201246306865L;
	
	public CEnumTypeNotListedException() {
		super("The enum type was not listed, and caused a code error.");
	}

	public static CEnumTypeNotListedException it() throws CEnumTypeNotListedException {
		throw new CEnumTypeNotListedException();
	}
}
