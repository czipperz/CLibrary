package io.github.czipperz.cLibrary.exceptions;

import com.czipperz.cLibrary.commands.CCommandExecutor;

/**
 * Created by czipperz on 1/30/15.
 */
public abstract class CParameterException extends CCommandException {
    public CParameterException(CCommandExecutor commandFailed, String command) {
        super(commandFailed, command);
    }
}
