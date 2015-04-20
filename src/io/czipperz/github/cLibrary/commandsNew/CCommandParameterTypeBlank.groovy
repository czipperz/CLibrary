package io.czipperz.github.cLibrary.commandsNew

/**
 * @author czipperz on 4/19/15.
 */
class CCommandParameterTypeBlank extends CCommandParameterType {
	CCommandParameterTypeBlank() {
		super({it.length >= 1}, "-".toCharacter(), "--", {})
	}
}
