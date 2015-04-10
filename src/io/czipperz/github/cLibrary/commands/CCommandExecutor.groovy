package io.czipperz.github.cLibrary.commands

import io.czipperz.github.cLibrary.bash.CBash
import io.czipperz.github.cLibrary.exceptions.CCommandException
import io.czipperz.github.cLibrary.exceptions.CParameterException

/**
 * Created by czipperz on 4/9/15.
 */
abstract class CCommandExecutor {
	abstract CCommandExecutor execute(CCommandInput input, CBash bash)
	abstract CCommandExecutor execute(CCommandInput input) throws CParameterException

	boolean canExecute(CCommandInput input) {
		input.commandExecutor.callName == this.callName
	}

	abstract CCommandException whyNoExecute(CCommandInput input)
	abstract CCommandExecutor man(CBash bash)

	abstract String[] getCallName()
	abstract ArrayList<CCommandParameterType> getPotentialParameters()
}
