package io.github.czipperz.cLibrary.bash

/**
 * Created by czipperz on 4/8/15.
 */
class CBashSErr extends CBashBase {
	CBashSErr() {
		super(colorConsumer: {},stringConsumer: { println it }, flush: System.out.&flush);
	}
}
