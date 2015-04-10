package io.czipperz.github.cLibrary

import io.czipperz.github.cLibrary.bash.CBash
import io.czipperz.github.cLibrary.bash.CBashSOut

/**
 * Created by czipperz on 4/8/15.
 */
class Test {
	CBash out = new CBashSOut();

	public static void main(String[] args) {
		new CBashSOut().println("asdf")
	}
}
