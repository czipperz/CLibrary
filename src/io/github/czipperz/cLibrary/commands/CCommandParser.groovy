package io.github.czipperz.cLibrary.commands

import io.github.czipperz.cLibrary.bash.CBash
import io.github.czipperz.cLibrary.exceptions.CCommandException

import java.security.InvalidParameterException

/**
 * Created by czipperz on 4/9/15.
 */
abstract class CCommandParser {
	abstract CCommandInput parse(ArrayList<CCommandExecutor> possibleCommands, String input) throws CCommandException, InvalidParameterException

	CCommandInput parse(ArrayList<CCommandExecutor> possibleCommands, String input, CBash bash) {
		try {
			return parse(possibleCommands, input)
		} catch(CCommandException e) {
			e.printStackTrace(new PrintStream(System.out) {
				void println(String s) {
					bash.out(s)
				}
			})
		}
		throw new UnsupportedOperationException("Cannot parse $input")
	}
}
