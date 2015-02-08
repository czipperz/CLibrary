package com.czipperz.cLibrary.commands;

/**
 * This interface describes the type of <i>{@link CCommandParameter}</i>
 * <br /><br />
 * This class is setup as that usages must test to see if there is a switch, then test compatibility with the switches.
 *
 * Created by czipperz on 1/30/15.
 */
public abstract class CCommandParameterType {


    public abstract String man();

    /**
     * For an example that would return true see: <i>vim -t "man()" CCommandParameterType</i> would open cause the man() text to be searched in CCommandParameterType.
     * False modifiers are things like -h or -v (help and verbose, respectively) that don't need a second argument.
     *
     * @return true if this object needs a second value (not preceded by a switch).
     * @return false if this object doesn't need a second value, standing by itself.
     */
    public abstract boolean needsSecondArg();

    public boolean hasAliasSingleSwitch() {
        return getAliasSingleSwitch() != '-';
    }

    /**
     * Returns the single letter alias of the {@link CCommandParameterType}
     * For example, <i>tar -h</i> would call the help {@link CCommandParameterType}.
     * @return the singleton switch (ex. h would be returned for -h)
     * If this returns '-', then there isn't a single switch alias.
     */
    public abstract char getAliasSingleSwitch();

    public boolean hasAliasDoubleSwitch() {
        return !getAliasDoubleSwitch().equals("-");
    }

    /**
     * Returns the full name alias of the {@link CCommandParameterType}
     * For example, <i>tar --help</i> would call the help {@link CCommandParameterType}.
     * @return the doubleton switch (ex. help would be returned for --help).
     * If this return "-", then there isn't a double switch alias.
     */
    public abstract String getAliasDoubleSwitch();
}
