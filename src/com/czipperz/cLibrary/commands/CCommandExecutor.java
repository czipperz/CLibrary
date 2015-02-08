package com.czipperz.cLibrary.commands;

import com.czipperz.cLibrary.exceptions.CCommandException;
import com.czipperz.cLibrary.exceptions.CParameterException;

import java.util.ArrayList;
import java.util.function.Consumer;

/**
 * Created by czipperz on 1/30/15.
 */
public interface CCommandExecutor {
    public CCommandExecutor execute(CCommandInput input, Consumer<String> bash);
    public CCommandExecutor execute(CCommandInput input) throws CParameterException;

    public default boolean canExecute(CCommandInput input) {
        return input.getCommandExecutor().getCallName().equals(this.getCallName());
    }

    /**
     * Returns the reason that {@link #canExecute(com.czipperz.cLibrary.commands.CCommandInput)} cannot execute.
     * Returns null if it can't execute the input.
     * @param input the {@link com.czipperz.cLibrary.commands.CCommandInput} that it doesn't work on.
     * @return the reason (in Exception form) of why the {@link com.czipperz.cLibrary.commands.CCommandInput} can't execute.
     * @see com.czipperz.cLibrary.commands.CCommandExecutor
     */
    public CCommandException whyNoExecute(CCommandInput input);

    public CCommandExecutor man(Consumer<String> bash);

    public String getCallName();
    public ArrayList<CCommandParameterType> getPotentialParameters();
}
