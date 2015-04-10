package io.czipperz.github.cLibrary.commands

/**
 * Created by czipperz on 4/9/15.
 */
class CCommandParameterTypeBlank extends CCommandParameterType {
	private boolean needsSecondArg

	public CCommandParameterTypeBlank(boolean needsSecondArg) {
		this.needsSecondArg = needsSecondArg
	}

	String man() {
		return null
	}

	boolean needsSecondArg() {
		needsSecondArg
	}

	char getAliasSingleSwitch() {
		return "-".toCharacter()
	}

	String getAliasDoubleSwitch() {
		return "-"
	}
}
