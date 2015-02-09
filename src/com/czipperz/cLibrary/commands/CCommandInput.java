package com.czipperz.cLibrary.commands;

import java.util.ArrayList;

/**
 * Created by czipperz on 1/31/15.
 */
public abstract class CCommandInput {
    private CCommandExecutor commandExecutor;
    private ArrayList<CCommandParameter> parameters;

    public CCommandInput(CCommandExecutor commandExecutor) {
        this.commandExecutor = commandExecutor;
        this.parameters = new ArrayList<>();
    }

    public CCommandInput(CCommandExecutor commandExecutor, CCommandParameter parameter) {
        this(commandExecutor);
        this.parameters.add(parameter);
    }

    public CCommandInput(CCommandExecutor commandExecutor, ArrayList<CCommandParameter> parameters) {
        this.commandExecutor = commandExecutor;
        this.parameters = parameters;
    }

    public CCommandExecutor getCommandExecutor() {
        return commandExecutor;
    }
    public ArrayList<CCommandParameter> getParameters() {
        return parameters;
    }
}