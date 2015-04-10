package io.czipperz.github.cLibrary.commands

/**
 * Created by czipperz on 4/9/15.
 */
abstract class CCommandInput {
	private CCommandExecutor commandExecutor
	private ArrayList<CCommandParameter> parameters

	CCommandInput(CCommandExecutor commandExecutor, ArrayList<CCommandParameter> parameters = new ArrayList<>()) {
		this.commandExecutor
		this.parameters = parameters
	}

	CCommandInput(CCommandExecutor commandExecutor, CCommandParameter parameter) {
		this(commandExecutor)
		parameters.add parameter
	}

	CCommandExecutor getCommandExecutor() {
		return commandExecutor
	}

	ArrayList<CCommandParameter> getParameters() {
		return parameters
	}
}
