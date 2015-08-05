package io.czipperz.github.cLibrary.commands;


/**
* @author czipperz on 4/9/15.
*/
public class CCommandParameter {
    public final CCommandParameterType type;
    public String[] additionalValues;

    public boolean getOverRidesOthers()      { return overRidesOthers;   }
    public Predicate<String[]> getArgsPass() { return argsPass;          }
    public char getAliasSingleSwitch()       { return aliasSingleSwitch; }
    public String getAliasSingleSwitch()     { return aliasDoubleSwitch; }
    public Consuer<CBash> getMan()           { return man;               }
    public String[] getAdditionalValues()    { return additionalValues;  }
}
