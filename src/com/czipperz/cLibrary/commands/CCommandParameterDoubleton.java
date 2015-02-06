package com.czipperz.cLibrary.commands;

import java.util.ArrayList;

/**
 * Created by czipperz on 1/31/15.
 */
public class CCommandParameterDoubleton extends CCommandParameter {
    private ArrayList<String> secondArg;

    public CCommandParameterDoubleton(CCommandParameterType type, ArrayList<String> secondArg) {
        super(type);
        this.secondArg = secondArg;
    }

    public ArrayList<String> getSecondArg() {
        return secondArg;
    }
}
