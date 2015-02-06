package com.czipperz.cLibrary.commands;

import java.util.ArrayList;

/**
 * This class takes a <i>{@link com.czipperz.cLibrary.commands.CCommandParameterType}</i> object
 * and possible extra data provided after the switch and provides a consolidation point.
 * Created by czipperz on 1/31/15.
 */
public class CCommandParameter {
    private CCommandParameterType type;
    private ArrayList<String> values;

    public CCommandParameter(CCommandParameterType type) {
        this.type = type;
        this.values = new ArrayList<>();
    }

    public CCommandParameter(CCommandParameterType type, ArrayList<String> values) {
        this.type = type;
        this.values = values;
    }

    public CCommandParameter(CCommandParameterType type, String value) {
        this(type);
        this.values.add(value);
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

    public ArrayList<String> getAdditionalValues() {
        return values;
    }
}
