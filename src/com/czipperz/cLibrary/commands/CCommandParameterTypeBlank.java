package com.czipperz.cLibrary.commands;

/**
 * Created by Chris on 2/3/2015.
 */
public class CCommandParameterTypeBlank extends CCommandParameterType {
    private boolean needsSecondArg;

    public CCommandParameterTypeBlank(boolean needsSecondArg) {
        this.needsSecondArg = needsSecondArg;
    }

    public String man() {
        return null;
    }

    public boolean needsSecondArg() {
        return needsSecondArg;
    }

    public char getAliasSingleSwitch() {
        return '-';
    }

    public String getAliasDoubleSwitch() {
        return "-";
    }
}
