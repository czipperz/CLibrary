package io.czipperz.github.cLibrary.commandsNew

import io.czipperz.github.cLibrary.exceptions.CCommandExecutorUnfoundException

import java.security.InvalidParameterException

/**
 * @author czipperz on 4/9/15.
 */
class CCommandParserBash extends CCommandParser {
	public CCommandParser parse(ArrayList<CCommandExecutor> commandExecutors, String input) throws CCommandExecutorUnfoundException, InvalidParameterException {
		CCommandExecutor executor = null;

		String[] separatedBySpace = input.trim().split " "
		for(CCommandExecutor e : commandExecutors)
			if(e.callName.contains(separatedBySpace[0])) {
				executor = e;
				break
			}
		if(executor == null)
			throw new CCommandExecutorUnfoundException(input);


		ArrayList<CCommandParameter> params = new ArrayList<>();
		//If have params
		if(separatedBySpace.length > 1) {
			CCommandParameterType type = null
			ArrayList<String> extras = null

			for(int i = 1; i < separatedBySpace.length; i++) {
				while(true) {
					String s = separatedBySpace[i]
					//If not an option
					if (!s.startsWith("-")) {
						if (type == null) {
							type = new CCommandParameterTypeBlank()
							extras = new ArrayList<>()
						}
						if (!type.canHandleSecondArg)
							throw new InvalidParameterException("Can't handle second argument when it was given one.")
						extras.add s
						break
					} else {
						//Oooh shit
						if(type.needsSecondArg)
							throw new InvalidParameterException("Needs another argument but it wasn't given.")
						//Option
						while(true) {
							boolean b = false;
							if (s.startsWith("--")) {
								String x = s.substring(2)
								for (CCommandExecutor ce : commandExecutors) {
									for (CCommandParameterType ee : ce.potentialParameters) {
										if (ee.aliasDoubleSwitch == x) {
											type = ee;
											extras = new ArrayList<>()
											b = true
											break
										}
									}
									if(b)
										break
								}
								if(b)
									break
							} else {
								char x = s.substring(1, 2).toCharacter()
								for (CCommandExecutor ce : commandExecutors) {
									for (CCommandParameterType ee : ce.potentialParameters) {
										if (ee.aliasSingleSwitch == x) {
											type == ee
											extras = new ArrayList<>()
											break
										}
									}
									if(b)
										break
								}
								if(b)
									break
							}
							throw new InvalidParameterException("Couldn't parse $s")
						}
						//Reaches here if found a match (type is set)
					}
				}
			}

			/*
			//Stored previous param so can add args later
			CCommandParameter ccp = null;
			//for each param
			for (int i = 1; i < separatedBySpace.length; i++) {
				//get dat param
				String s = separatedBySpace[i];
				if (!s.startsWith("-")) {
					if (i == 1)
						params.add(ccp = new CCommandParameter(new CCommandParameterTypeBlank(false)));
					else
						ccp.additionalValues.add(s);
					break;
				} else for (CCommandParameterType p : executor.potentialParameters) {
					if (s.startsWith("--")) {
						if (("--" + p.aliasDoubleSwitch).equals(s)) {
							if (p.needsSecondArg)
								if (i + 1 >= separatedBySpace.length)
									throw new ArrayIndexOutOfBoundsException("This parameter requires a second part that was not supplied.");
							params.add(ccp = new CCommandParameter(p));
						}
					} else if (s.startsWith("-")) {
						boolean bb = false;
						for(char is : s.toCharArray()) {
							if(is == p.aliasSingleSwitch) {
								if(p.needsSecondArg && bb)
									throw new InvalidParameterException("Multiple single switch arguments that require multiple other arguments are in one spot. Needs better parsing");
								ccp = new CCommandParameter(p);
								params.add(ccp);
								if(ccp.type.needsSecondArg)
									bb = true;
							}
						}
					}
				}
			}*/
		}
		CCommandParameter[] ppp = new CCommandParameter[params.size()]
		for(int i = 0; i < ppp.length; i++) {
			ppp[i] = params[i]
		}

		return new CCommandInput(executor, separatedBySpace[0], ppp)
	}
}
