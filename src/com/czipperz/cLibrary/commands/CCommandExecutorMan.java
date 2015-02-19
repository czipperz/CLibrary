package com.czipperz.cLibrary.commands;

import com.czipperz.cLibrary.CBash;
import com.czipperz.cLibrary.exceptions.CCommandException;
import com.czipperz.cLibrary.exceptions.CExceptionParser;
import com.czipperz.cLibrary.exceptions.CParameterException;

import java.util.ArrayList;
import java.util.function.Consumer;

/**
 * Created by Chris on 2/8/2015.
 */
public class CCommandExecutorMan extends CCommandExecutor {
    public CCommandExecutor execute(CCommandInput input, CBash bash) {
        return man(bash);
    }

    public CCommandExecutor execute(CCommandInput input) throws CParameterException, UnsupportedOperationException {
        throw new UnsupportedOperationException("Must call this method with a bash terminal input (no other way to man something than to print it.)");
    }

    public CCommandException whyNoExecute(CCommandInput input) {
        return null;
    }

    public CCommandExecutor man(CBash bash) {
        //TODO: write this

        return this;
    }

    public String getCallName() {
        return "man";
    }

    public ArrayList<CCommandParameterType> getPotentialParameters() {
        return new ArrayList<>();
    }
}
