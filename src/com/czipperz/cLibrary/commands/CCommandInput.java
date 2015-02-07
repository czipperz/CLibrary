package com.czipperz.cLibrary.commands;

import java.util.ArrayList;

/**
 * Created by czipperz on 1/31/15.
 */
public interface CCommandInput {
    public CCommandExecutor getCommandExecutor();
    public ArrayList<CCommandParameter> getParameters();
}