package io.czipperz.github.cLibrary.commands

import groovy.transform.Immutable

/**
* @author czipperz on 4/9/15.
*/
@Immutable
class CCommandInput {
	CCommandExecutor commandExecutor
	String callName
	CCommandParameter[] parameters
}
