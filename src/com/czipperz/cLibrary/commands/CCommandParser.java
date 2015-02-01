package com.czipperz.cLibrary.commands;

import java.util.function.Function;

/**
 * Created by czipperz on 1/31/15.
 */
public interface CCommandParser extends Function<String, CCommandInput> {
    public default CCommandInput apply(String input) {
        return parse(input);
    }

    public CCommandInput parse(String input);
}
