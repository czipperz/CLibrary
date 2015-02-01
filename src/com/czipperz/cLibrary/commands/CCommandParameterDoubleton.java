package com.czipperz.cLibrary.commands;

/**
 * Created by czipperz on 1/31/15.
 */
public class CCommandParameterDoubleton extends CCommandParameter {
    private String secondArg;

    public CCommandParameterDoubleton(CCommandParameterType type, String secondArg) {
        super(type);
        this.secondArg = secondArg;
    }

    public String getSecondArg() {
        return secondArg;
    }
}
