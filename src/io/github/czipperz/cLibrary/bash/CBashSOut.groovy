package io.github.czipperz.cLibrary.bash

/**
 * Created by czipperz on 4/8/15.
 */
class CBashSOut extends CBashBase {
	CBashSOut() {
		super(colorConsumer: {},stringConsumer: { System.err.println(it) }, flush: System.err.&flush);
	}
}
