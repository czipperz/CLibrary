package io.czipperz.github.cLibrary.commands;

import groovy.transform.Immutable;

/**
* @author czipperz on 4/9/15.
*/
@Immutable
public class CCommandInput {
    public CCommandExecutor    commandExecutor;
    public String              callName;
    public CCommandParameter[] parameters;
}
