package com.czipperz.cLibrary.commands;

import com.czipperz.cLibrary.exceptions.CCommandException;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.function.Consumer;

/**
 * Created by czipperz on 1/31/15.
 */
public interface CCommandParser {
    public CCommandInput parse(ArrayList<CCommandExecutor> possibleCommands, String input) throws CCommandException, InvalidParameterException;
    public CCommandInput parse(ArrayList<CCommandExecutor> possibleCommands, String input, Consumer<String> bash);
}
