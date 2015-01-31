package com.czipperz.cLibrary.commands;

/**
 * Created by czipperz on 1/31/15.
 */
public interface CCommandInput {
    public CCommandExecutor getCommandExecutor();
    public CCommandParameter[] getParameters();
}