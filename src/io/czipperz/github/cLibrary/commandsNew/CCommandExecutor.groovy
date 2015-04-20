package io.czipperz.github.cLibrary.commandsNew

import io.czipperz.github.cLibrary.bash.CBash
import io.czipperz.github.cLibrary.bash.CBashSystem
import io.czipperz.github.cLibrary.exceptions.CCommandException

/**
 * @author czipperz on 4/19/15.
 */
abstract class CCommandExecutor {
	abstract void execute(CCommandInput input, CBash bash)
	void execute(CCommandInput input) {
		execute(input, new CBashSystem())
	}

	boolean canExecute(CCommandInput input) {
		callName.contains input.callName
	}

	abstract CCommandException whyNoExecute(CCommandInput input)
	abstract void man(CBash bash)

	abstract String[] getCallName()
	abstract CCommandParameterType[] getPotentialParameters()
}
