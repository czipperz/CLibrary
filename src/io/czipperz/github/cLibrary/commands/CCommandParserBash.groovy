package io.czipperz.github.cLibrary.commands

import io.czipperz.github.cLibrary.exceptions.CCommandExecutorUnfoundException

import java.security.InvalidParameterException

/**
 * Created by czipperz on 4/9/15.
 */
class CCommandParserBash extends CCommandParser {
	public CCommandInput parse(ArrayList<CCommandExecutor> commandExecutors, String input) throws CCommandExecutorUnfoundException, InvalidParameterException {
		CCommandExecutor executor = null;

		String[] seperatedBySpace = input.split(" ");
		for(CCommandExecutor e : commandExecutors) {
			if(e.callName.equals(seperatedBySpace[0])) {
				executor = e;
				break;
			}
		}
		if(executor == null) {
			throw new CCommandExecutorUnfoundException(input);
		}


		ArrayList<CCommandParameter> params = new ArrayList<>();
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
						params.add(ccp = new CCommandParameter(new CCommandParameterTypeBlank(false)));
					else
						ccp.additionalValues.add(s);
					break;
				} else for (CCommandParameterType p : executor.potentialParameters) {
					if (s.startsWith("--")) {
						if (("--" + p.aliasDoubleSwitch).equals(s)) {
							if (p.needsSecondArg())
								if (i + 1 >= seperatedBySpace.length)
									throw new ArrayIndexOutOfBoundsException("This parameter requires a second part that was not supplied.");
							params.add(ccp = new CCommandParameter(p));
						}
					} else if (s.startsWith("-")) {
						boolean bb = false;
						for(char is : s.toCharArray()) {
							if(is == p.aliasSingleSwitch) {
								if(p.needsSecondArg() && bb)
									throw new InvalidParameterException("Multiple single switch arguments that require multiple other arguments are in one spot. Needs better parsing");
								ccp = new CCommandParameter(p);
								params.add(ccp);
								if(ccp.type.needsSecondArg())
									bb = true;
							}
						}
					}
				}
			}
		}

		return new CCommandInputDefault(executor, params);
	}
}
