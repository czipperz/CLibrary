package io.czipperz.github.cLibrary.commands

import io.czipperz.github.cLibrary.bash.CBash

import java.util.concurrent.Callable
import java.util.function.Consumer
import java.util.function.Predicate

/**
* @author czipperz on 4/9/15.
*/
class CCommandParameterType {
	/** True if the aliases will override the others and take any possible
	 * String(s) that are given after. Example: <code>`pacman -Syu base-devel`</code>
	 * will apply base-devel to the <code>`-S`</code> because the <code>`-S`</code>
	 * will have `overRidesOther` as true. There will be an error if multiple aliases
	 * are provided with this as true. If none are provided with this as true then one
	 * that is last and has <code>`needsSecondArg==true`</code> or the last one if none
	 * need it, will take it. */
	final boolean overRidesOthers
	/** Use this to dictate if the additional arguments pass. */
	final Predicate<String[]> argsPass
	/** <code>`pacman -S`</code> would be <code>`S`</code>*/
	final char aliasSingleSwitch
	/** <code>`pacman --sync`</code> would be <code>`sync`</code> */
	final String aliasDoubleSwitch
	/** Takes an input of type CBash as to print out the man page. */
	final Consumer<CBash> man

	CCommandParameterType(boolean overRidesOthers = false, Predicate<String[]> argsPass, char aliasSingleSwitch,
	                      String aliasDoubleSwitch, Consumer<CBash> man) {
		this.overRidesOthers = overRidesOthers
		this.argsPass = argsPass
		this.aliasSingleSwitch = aliasSingleSwitch
		this.aliasDoubleSwitch = aliasDoubleSwitch
		this.man = man
	}
}
