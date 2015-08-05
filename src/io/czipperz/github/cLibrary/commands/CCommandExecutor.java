package io.czipperz.github.cLibrary.commands;

import io.czipperz.github.cLibrary.bash.CBash;
import io.czipperz.github.cLibrary.exceptions.CCommandException;
import io.czipperz.github.cLibrary.exceptions.CParameterException;

/**
* @author czipperz on 4/9/15.
*/
public abstract class CCommandExecutor {
    public abstract void execute(CCommandInput input, CBash bash);
    public abstract void execute(CCommandInput input) throws CParameterException;

    public boolean canExecute(CCommandInput input) {
        return input.commandExecutor.callName.equals(this.callName);
    }

    public abstract CCommandException whyNoExecute(CCommandInput input);
    public abstract void man(CBash bash);

    public abstract String[] getCallName();
    public abstract CCommandParameterType[] getPotentialParameters();
}
