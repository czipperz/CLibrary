package com.czipperz.cLibrary.exceptions;

import com.czipperz.cLibrary.commands.CCommandExecutor;

/**
 * Created by czipperz on 1/31/15.
 */
public class CCommandExecutorUnfoundException extends CCommandException {
    public CCommandExecutorUnfoundException(String command) {
        super(null, command);
    }

    public String getMessage() {
        return "No command was matched to the input \"" + command + "\"";
    }
}
