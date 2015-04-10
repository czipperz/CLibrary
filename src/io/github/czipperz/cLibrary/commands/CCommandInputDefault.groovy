package io.github.czipperz.cLibrary.commands

/**
 * Created by czipperz on 4/9/15.
 */
class CCommandInputDefault extends CCommandInput {
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
