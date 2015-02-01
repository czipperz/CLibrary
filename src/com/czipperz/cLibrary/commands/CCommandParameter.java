package com.czipperz.cLibrary.commands;

/**
 * Created by czipperz on 1/31/15.
 */
public abstract class CCommandParameter {
    private CCommandParameterType type;

    public CCommandParameter(CCommandParameterType type) {
        this.type = type;
    }

    public CCommandParameterType getType() {
        return type;
    }

    public String man() {
        return type.man();
    }

    public String getAliasSingleSwitch() {
        return type.getAliasSingleSwitch();
    }

    public String getAliasDoubleSwitch() {
        return type.getAliasDoubleSwitch();
    }
}
