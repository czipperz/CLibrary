package io.czipperz.github.cLibrary.exceptions;

import io.czipperz.github.cLibrary.commands.CCommandExecutor;

/**
 * Created by czipperz on 1/30/15.
 */
public class CCommandParameterOutOfBoundsException extends CParameterException {
    private boolean isTooMany;

    public CCommandParameterOutOfBoundsException(CCommandExecutor commandFailed, String command, boolean isTooMany, int paramBounds) {
        super(commandFailed, command);
        this.isTooMany = isTooMany;
    }

    public boolean isTooMany() {
        return isTooMany;
    }

    public boolean isTooLittle() {
        return !isTooMany;
    }

    public String getMessage() {
        return "There were too " + (isTooMany?"many":"little") + " parameters in that method call.";
    }

}
