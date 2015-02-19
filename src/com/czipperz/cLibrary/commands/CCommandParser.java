package com.czipperz.cLibrary.commands;

import com.czipperz.cLibrary.CBash;
import com.czipperz.cLibrary.exceptions.CCommandException;

import java.io.IOException;
import java.io.PrintStream;
import java.security.InvalidParameterException;
import java.util.ArrayList;

/**
 * Created by czipperz on 1/31/15.
 */
public abstract class CCommandParser {
    public abstract CCommandInput parse(ArrayList<CCommandExecutor> possibleCommands, String input) throws CCommandException, InvalidParameterException;

    public CCommandInput parse(ArrayList<CCommandExecutor> possibleCommands, String input, CBash bash) throws IOException {
        try {
            return parse(possibleCommands, input);
        } catch (CCommandException e) {
            e.printStackTrace(new PrintStream(System.out) {
                public void println(String s) {
                    try {
                        bash.println(s);
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            });
        }
        return null;
    }
}
