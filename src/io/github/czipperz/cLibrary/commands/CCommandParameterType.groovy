package io.github.czipperz.cLibrary.commands

/**
 * Created by czipperz on 4/9/15.
 */
abstract class CCommandParameterType {
	abstract String man()

	abstract boolean needsSecondArg()



	boolean hasAliasSingleSwitch() {
		aliasSingleSwitch != '-'
	}
	abstract char getAliasSingleSwitch()



	boolean hasAliasDoubleSwitch() {
		!aliasDoubleSwitch.equals("-")
	}
	abstract String getAliasDoubleSwitch()
}
