package io.czipperz.github.cLibrary.exceptions;

/**
 * @author czipperz on 1/31/15.
 */
public class CCommandExecutorUnfoundException extends CCommandException {
    public CCommandExecutorUnfoundException(String command) {
        super(null, command);
    }

    public String getMessage() {
        return "No command was matched to the input \"" + command + "\"";
    }
}
