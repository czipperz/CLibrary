package io.czipperz.github.cLibrary.commandsNew

import io.czipperz.github.cLibrary.bash.CBash
import io.czipperz.github.cLibrary.exceptions.CCommandException
import io.czipperz.github.cLibrary.exceptions.CParameterException

/**
* @author czipperz on 4/9/15.
*/
class CCommandExecutorMan extends CCommandExecutor {
	void execute(CCommandInput input, CBash bash) {
		man(bash)
	}

	void execute(CCommandInput input) throws CParameterException, UnsupportedOperationException {
		throw new UnsupportedOperationException("Must call this method with a bash terminal output (no other way to man something than to print it.)")
	}

	CCommandException whyNoExecute(CCommandInput input) {
		return null
	}

	void man(CBash bash) {
		//TODO: write
		bash
		.setBold(true).outln("\tNAME")
		.setBold(false).outln("man - a method that displays usage manuals for commands")
		.outln()
		.setBold(true).outln("\tSYNOPSIS")
		.out("man").setBold(false).outln(" page")
		.outln()
		.setBold(true).outln("\tDESCRIPTION")
		.setBold(false).out("man is the manual pager. Each page given to man will be attempted to be called. If none is found, an error will be displayed.")
	}

	String[] getCallName() {
		["man"]
	}

	CCommandParameterType[] getPotentialParameters() {
		[new CCommandParameterTypeBlank()]
	}
}
