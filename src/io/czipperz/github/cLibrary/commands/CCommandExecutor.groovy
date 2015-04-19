package io.czipperz.github.cLibrary.commands

import io.czipperz.github.cLibrary.bash.CBash
import io.czipperz.github.cLibrary.exceptions.CCommandException
import io.czipperz.github.cLibrary.exceptions.CParameterException

/**
* @author czipperz on 4/9/15.
*/
abstract class CCommandExecutor {
	abstract CCommandInput execute(CCommandInput input, CBash bash)
	abstract CCommandInput execute(CCommandInput input) throws CParameterException

	boolean canExecute(CCommandInput input) {
		input.commandExecutor.callName.equals this.callName
	}

	abstract CCommandException whyNoExecute(CCommandInput input)
	abstract void man(CBash bash)

	abstract String[] getCallName()
	abstract CCommandParameterType[] getPotentialParameters()
}
