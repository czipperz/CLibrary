package com.czipperz.cLibrary.commands;

/**
 * Created by Chris on 2/3/2015.
 */
public class CCommandParameterTypeBlank implements CCommandParameterType {
    public String man() {
        return null;
    }

    public boolean needsSecondArg() {
        return false;
    }

    public String getAliasSingleSwitch() {
        return "";
    }

    public String getAliasDoubleSwitch() {
        return "--";
    }
}
