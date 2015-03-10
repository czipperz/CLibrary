package com.czipperz.cLibrary.commands;

import com.czipperz.cLibrary.CBash;
import com.czipperz.cLibrary.exceptions.CCommandException;
import com.czipperz.cLibrary.exceptions.CParameterException;

import java.util.ArrayList;

/**
 * Created by czipperz on 1/30/15.
 */
public abstract class CCommandExecutor {
    public abstract CCommandExecutor execute(CCommandInput input, CBash bash);
    public abstract CCommandExecutor execute(CCommandInput input) throws CParameterException;

    public boolean canExecute(CCommandInput input) {
        return input.getCommandExecutor().getCallName().equals(this.getCallName());
    }

    /**
     * Returns the reason that {@link #canExecute(com.czipperz.cLibrary.commands.CCommandInput)} cannot execute.
     * Returns null if it can't execute the input.
     * @param input the {@link com.czipperz.cLibrary.commands.CCommandInput} that it doesn't work on.
     * @return the reason (in Exception form) of why the {@link com.czipperz.cLibrary.commands.CCommandInput} can't execute.
     * @see com.czipperz.cLibrary.commands.CCommandExecutor
     */
    public abstract CCommandException whyNoExecute(CCommandInput input);

    public abstract CCommandExecutor man(CBash bash);

    public abstract String getCallName();
    public abstract ArrayList<CCommandParameterType> getPotentialParameters();
}
