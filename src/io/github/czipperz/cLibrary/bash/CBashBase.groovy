package io.github.czipperz.cLibrary.bash

import groovy.transform.Immutable

import java.awt.Color
import java.util.function.Consumer

/**
 * Created by czipperz on 4/8/15.
 */
abstract class CBashBase implements CBash {
	final Consumer<Color> colorConsumer;
	final Consumer<String> stringConsumer;
	final Runnable flush;

	CBash setColor(Color c) {
		colorConsumer.accept(c)
		return this
	}

	CBash out(s) {
		stringConsumer.accept(String.valueOf(s))
		return null
	}

	CBash flush() {
		flush.run()
		return null
	}
}
