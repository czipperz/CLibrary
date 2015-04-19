package io.czipperz.github.cLibrary.exceptions;

import io.czipperz.github.cLibrary.commands.CCommandExecutor;

/**
 * @author czipperz on 1/30/15.
 */
public abstract class CCommandException extends Exception {
    protected CCommandExecutor commandFailed;
    protected String command;

    public CCommandException(CCommandExecutor commandFailed, String command) {
        this.commandFailed = commandFailed;
        this.command = command;
    }

    public abstract String getMessage();
}
