package io.czipperz.github.cLibrary.commands

import io.github.czipperz.cLibrary.commands.CCommandExecutor
import io.github.czipperz.cLibrary.commands.CCommandParameter

/**
 * Created by czipperz on 4/9/15.
 */
class CCommandInputDefault extends io.github.czipperz.cLibrary.commands.CCommandInput {
	CCommandInputDefault(CCommandExecutor commandExecutor) {
		super(commandExecutor)
	}

	CCommandInputDefault(CCommandExecutor commandExecutor, CCommandParameter parameter) {
		super(commandExecutor, parameter)
	}

	CCommandInputDefault(CCommandExecutor commandExecutor, ArrayList<CCommandParameter> parameters) {
		super(commandExecutor, parameters)
	}
}
