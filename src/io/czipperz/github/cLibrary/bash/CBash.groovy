package io.czipperz.github.cLibrary.bash

/**
* @author czipperz on 4/8/15.
*/
trait CBash {
	abstract CBash out(s)
	CBash outln(s) {
		out(s)
		out("\n")
	}
	CBash outln() {
		out("\n")
	}
	abstract CBash flush()
	abstract CBash setBold(boolean b)
	CBash setBold() {
		setBold(true)
	}
	CBash setUBold() {
		setBold(false)
	}
}
