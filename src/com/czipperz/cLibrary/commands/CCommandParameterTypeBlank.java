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

    public char getAliasSingleSwitch() {
        return '-';
    }

    public String getAliasDoubleSwitch() {
        return "-";
    }

    public boolean hasAliasSingleSwitch() {
        return false;
    }

    public boolean hasAliasDoubleSwitch() {
        return false;
    }
}
