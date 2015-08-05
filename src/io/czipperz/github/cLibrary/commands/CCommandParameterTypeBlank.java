package io.czipperz.github.cLibrary.commands

/**
* @author czipperz on 4/18/15.
*/
class CCommandParameterTypeBlank extends CCommandParameterType {
	CCommandParameterTypeBlank() {
		super(false, true, "-".toCharacter(), "--", {})
	}
}
