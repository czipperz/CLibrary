package io.czipperz.github.cLibrary.bash

/**
 * This class models the System.{out|err} objects by switching between them using {@link CBashSystem#setBold(boolean)}
 * @author czipperz on 4/18/15.
 */
class CBashSystem implements CBash {
	private boolean bool = false;
	synchronized CBash out(Object s) {
		if(bool) System.err.print s
		else System.out.print s
		this
	}

	CBash flush() {
		System.err.flush()
		System.out.flush()
		this
	}

	synchronized CBash setBold(boolean b) {
		flush()
		bool = b
		this
	}
}
