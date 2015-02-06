package com.czipperz.cLibrary.commands;

import com.czipperz.cLibrary.exceptions.CCommandExecutorUnfoundException;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.function.Consumer;

/**
 * Created by czipperz on 1/31/15.
 */
public class CCommandParserBash implements CCommandParser {
    public CCommandInput parse(ArrayList<CCommandExecutor> commandExecutors, String input) throws CCommandExecutorUnfoundException, InvalidParameterException {
        CCommandExecutor executor = null;

        String[] seperatedBySpace = input.split(" ");
        for(CCommandExecutor e : commandExecutors) {
            if(e.getCallName().equals(seperatedBySpace[0])) {
                executor = e;
                break;
            }
        }
        if(executor == null) {
            throw new CCommandExecutorUnfoundException(input);
        }
        final CCommandExecutor finalExecutor = executor;

        final ArrayList<CCommandParameter> params = new ArrayList<>();

        //If have params
        if(seperatedBySpace.length > 1) {
            //Stored previous param so can add args later
            CCommandParameter ccp = null;
            //for each param
            for (int i = 1; i < seperatedBySpace.length; i++) {
                //get dat param
                String s = seperatedBySpace[i];
                if (!s.startsWith("-")) {
                    if (i == 1)
                        params.add(ccp = new CCommandParameter(new CCommandParameterTypeBlank()));
                    else
                        ccp.getAdditionalValues().add(s);
                    break;
                } else for (CCommandParameterType p : executor.getPotentialParameters()) {
                    if (s.startsWith("--")) {
                        if (("--" + p.getAliasDoubleSwitch()).equals(s)) {
                            if (p.needsSecondArg())
                                if (i + 1 >= seperatedBySpace.length)
                                    throw new ArrayIndexOutOfBoundsException("This parameter requires a second part that was not supplied.");
                            params.add(ccp = new CCommandParameter(p));
                        }
                    } else if (s.startsWith("-")) {
                        boolean bb = false;
                        for(char is : s.toCharArray()) {
                            if(is == p.getAliasSingleSwitch()) {
                                if(p.needsSecondArg() && bb)
                                    throw new InvalidParameterException("Multiple single switch arguments that require multiple other arguments are in one spot. Needs better parsing");
                                ccp = new CCommandParameter(p);
                                params.add(ccp);
                                if(ccp.getType().needsSecondArg())
                                    bb = true;
                            }
                        }
                    }
                }
            }
        }

        return new CCommandInput() {
            public CCommandExecutor getCommandExecutor() {
                return finalExecutor;
            }

            public ArrayList<CCommandParameter> getParameters() {
                return params;
            }
        };
    }

    public CCommandInput parse(ArrayList<CCommandExecutor> possibleCommands, String input, Consumer<String> bash) {
        try {
            return parse(possibleCommands, input);
        } catch(InvalidParameterException e) {

        } catch (CCommandExecutorUnfoundException e) {

        }
        return null;
    }
}
