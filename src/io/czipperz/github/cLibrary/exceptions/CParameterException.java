package io.czipperz.github.cLibrary.exceptions;

import io.czipperz.github.cLibrary.commands.CCommandExecutor;

/**
 * @author czipperz on 1/30/15.
 */
public abstract class CParameterException extends CCommandException {
    public CParameterException(CCommandExecutor commandFailed, String command) {
        super(commandFailed, command);
    }
}
