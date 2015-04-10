package io.czipperz.github.cLibrary.bash

/**
 * Created by czipperz on 4/8/15.
 */
class CBashSOut extends CBashBase {
	CBashSOut() {
		this.with {colorConsumer: {}; stringConsumer: { System.err.println(it) }; flush: System.err.&flush}
	}
}
