package io.czipperz.github.cLibrary.commandsNew

import groovy.transform.Immutable

/**
 * @author czipperz on 4/19/15.
 */
@Immutable
class CCommandParameter {
	@Delegate CCommandParameterType type
	String[] additionalValues
}
