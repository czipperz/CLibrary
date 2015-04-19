package io.czipperz.github.cLibrary.commands

import io.czipperz.github.cLibrary.bash.CBash
import io.czipperz.github.cLibrary.exceptions.CCommandException
import io.czipperz.github.cLibrary.exceptions.CParameterException

/**
 * Created by czipperz on 4/9/15.
 */
class CCommandExecutorMan extends CCommandExecutor {
	CCommandExecutor execute(CCommandInput input, CBash bash) {
		man(bash)
	}

	CCommandExecutor execute(CCommandInput input) throws CParameterException, UnsupportedOperationException {
		throw new UnsupportedOperationException("Must call this method with  a bash terminal output (no other way to man something than to print it.)")
	}

	CCommandException whyNoExecute(CCommandInput input) {
		return null
	}

	CCommandExecutor man(CBash bash) {
		//TODO: write
		this
	}

	String[] getCallName() {
		["man"]
	}

	ArrayList<CCommandParameterType> getPotentialParameters() {
		return new ArrayList<CCommandParameterType>()
	}
}