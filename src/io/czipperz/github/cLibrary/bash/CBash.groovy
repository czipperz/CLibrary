package io.czipperz.github.cLibrary.bash

import java.awt.Color

/**
 * Created by czipperz on 4/8/15.
 */
interface CBash {
	CBash setColor(Color c)
	CBash out(s)
	CBash flush()
}