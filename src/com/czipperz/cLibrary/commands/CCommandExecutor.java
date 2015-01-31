package com.czipperz.cLibrary.commands;

import com.czipperz.cLibrary.exceptions.CCommandException;
import com.czipperz.cLibrary.exceptions.CParameterException;

import java.util.function.Consumer;

/**
 * Created by czipperz on 1/30/15.
 */
public interface CCommandExecutor {
    public CCommandExecutor execute(String input, Consumer<String> bash);
    public CCommandExecutor execute(String input) throws CParameterException;

    public boolean canExecute(String input);
    public CCommandException whyNoExecute(String input);

    public CCommandExecutor man(Consumer<String> bash);

    public CCommandParameter[] getPotentialParameters();
}
