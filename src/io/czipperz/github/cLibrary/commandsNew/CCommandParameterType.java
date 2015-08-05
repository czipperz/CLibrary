package io.czipperz.github.cLibrary.commandsNew

import groovy.transform.Immutable
import io.czipperz.github.cLibrary.bash.CBash

import java.util.function.Consumer
import java.util.function.Predicate

/**
 * @author czipperz on 4/19/15.
 */
@Immutable
class CCommandParameterType {
	Predicate<String[]> argsPass
	char aliasSingleSwitch
	String aliasDoubleSwitch
	Consumer<CBash> man
}
