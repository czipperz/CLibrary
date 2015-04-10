package io.czipperz.github.cLibrary.commands

/**
 * Created by czipperz on 4/9/15.
 */
class CCommandInputMan extends CCommandInput {
	CCommandInputMan(String command) {
		super(new CCommandExecutorMan(), new CCommandParameter(new CCommandParameterTypeBlank(true), command))
	}
}
