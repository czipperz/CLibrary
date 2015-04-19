package io.czipperz.github.cLibrary.bash

import java.awt.Color

/**
* @author czipperz on 4/8/15.
*/
interface CBash {
	CBash out(s)
	CBash flush()
	CBash setBold(boolean b)
}