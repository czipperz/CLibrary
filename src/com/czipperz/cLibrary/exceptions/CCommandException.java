package com.czipperz.cLibrary.exceptions;

import com.czipperz.cLibrary.commands.CCommandExecutor;

/**
 * Created by czipperz on 1/30/15.
 */
public abstract class CCommandException extends Exception {
    protected CCommandExecutor commandFailed;
    protected String command;

    public CCommandException(CCommandExecutor commandFailed, String command) {
        this.commandFailed = commandFailed;
        this.command = command;
    }
}
