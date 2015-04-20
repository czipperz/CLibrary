package io.czipperz.github.cLibrary.commands

import groovy.transform.Immutable

/**
* @author czipperz on 4/9/15.
*/
@Immutable
class CCommandParameter {
	@Delegate final CCommandParameterType type
	String[] additionalValues
}
