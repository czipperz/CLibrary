package com.czipperz.cLibrary.commands;

/**
 * Created by Chris on 2/8/2015.
 */
public class CCommandInputMan extends CCommandInput {
    public CCommandInputMan(String command) {
        super(new CCommandExecutorMan(), new CCommandParameter(new CCommandParameterTypeBlank(true), command));
    }
}
