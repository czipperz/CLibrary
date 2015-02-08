package com.czipperz.cLibrary.commands;

import java.util.ArrayList;

/**
 * Created by Chris on 2/6/2015.
 */
public class CCommandInputDefault extends CCommandInput {
    public CCommandInputDefault(CCommandExecutor commandExecutor) {
        super(commandExecutor);
    }

    public CCommandInputDefault(CCommandExecutor commandExecutor, CCommandParameter parameter) {
        super(commandExecutor, parameter);
    }

    public CCommandInputDefault(CCommandExecutor commandExecutor, ArrayList<CCommandParameter> parameters) {
        super(commandExecutor, parameters);
    }
}
