package com.czipperz.cLibrary.commands;

import com.czipperz.cLibrary.exceptions.CCommandException;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.function.Consumer;

/**
 * Created by czipperz on 1/31/15.
 */
public abstract class CCommandParser {
    public abstract CCommandInput parse(ArrayList<CCommandExecutor> possibleCommands, String input) throws CCommandException, InvalidParameterException;
    public CCommandInput parse(ArrayList<CCommandExecutor> possibleCommands, String input, Consumer<String> bash) {
        try {
            return parse(possibleCommands, input);
        } catch (CCommandException e) {
            e.printStackTrace();
        }
        return null;
    }
}
