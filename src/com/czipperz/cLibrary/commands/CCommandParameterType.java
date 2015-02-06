package com.czipperz.cLibrary.commands;

/**
 * This interface describes the type of <i>{@link CCommandParameter}</i>
 * <br /><br />
 * This class is setup as that usages must test to see if there is a switch, then test compatibility with the switches.
 *
 * Created by czipperz on 1/30/15.
 */
public interface CCommandParameterType {
    public String man();

    /**
     * For an example that would return true see: <i>vim -t "man()" CCommandParameterType</i> would open cause the man() text to be searched in CCommandParameterType.
     * False modifiers are things like -h or -v (help and verbose, respectively) that don't need a second argument.
     *
     * @return true if this object needs a second value (not preceded by a switch).
     * @return false if this object doesn't need a second value, standing by itself.
     */
    public boolean needsSecondArg();

    /**
     * Returns the single letter alias of the {@link CCommandParameterType}
     * For example, <i>tar -h</i> would call the help {@link CCommandParameterType}.
     * @return the singleton switch (ex. h would be returned for -h)
     */
    public char getAliasSingleSwitch();

    /**
     * Returns the full name alias of the {@link CCommandParameterType}
     * For example, <i>tar --help</i> would call the help {@link CCommandParameterType}.
     * @return the doubleton switch (ex. help would be returned for --help)
     */
    public String getAliasDoubleSwitch();
}
