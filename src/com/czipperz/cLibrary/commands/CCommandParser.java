package com.czipperz.cLibrary.commands;

import com.czipperz.cLibrary.exceptions.CCommandException;

/**
 * Created by czipperz on 1/31/15.
 */
public interface CCommandParser {
    public CCommandInput parse(CCommandExecutor[] possibleCommands, String input) throws CCommandException;
}
