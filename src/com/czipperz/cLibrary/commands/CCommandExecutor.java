package com.czipperz.cLibrary.commands;

import com.czipperz.cLibrary.exceptions.CCommandException;
import com.czipperz.cLibrary.exceptions.CParameterException;

import java.util.function.Consumer;

/**
 * Created by czipperz on 1/30/15.
 */
public interface CCommandExecutor {
    public CCommandExecutor execute(CCommandInput input, Consumer<String> bash);
    public CCommandExecutor execute(CCommandInput input) throws CParameterException;

    public boolean canExecute(CCommandInput input);
    public CCommandException whyNoExecute(CCommandInput input);

    public CCommandExecutor man(Consumer<String> bash);

    public String getCallName();
    public CCommandParameterType[] getPotentialParameters();
}
