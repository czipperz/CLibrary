package com.czipperz.cLibrary.commands;

import java.util.ArrayList;

/**
 * Created by Chris on 2/6/2015.
 */
public class CCommandInputDefault implements CCommandInput {
    private CCommandExecutor executor;
    private ArrayList<CCommandParameter> parameters;

    public CCommandInputDefault(CCommandExecutor executor, ArrayList<CCommandParameter> parameters) {
        this.executor = executor;
        this.parameters = parameters;
    }

    public CCommandExecutor getCommandExecutor() {
        return executor;
    }

    public ArrayList<CCommandParameter> getParameters() {
        return parameters;
    }
}
