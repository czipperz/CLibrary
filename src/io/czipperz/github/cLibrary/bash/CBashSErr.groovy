package io.czipperz.github.cLibrary.bash

/**
 * Created by czipperz on 4/8/15.
 */
class CBashSErr extends CBashBase {
	CBashSErr() {
		this.with {colorConsumer: {}; stringConsumer: { println it }; flush: System.out.&flush}
	}
}
