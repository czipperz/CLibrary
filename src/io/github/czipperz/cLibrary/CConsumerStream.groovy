package io.github.czipperz.cLibrary

import groovy.transform.Immutable

import java.util.function.Consumer

/**
 * Created by czipperz on 4/8/15.
 */
class CConsumerStream {
	OutputStream stream
	Consumer<IOException> consumer

	void accept(String t) {
		try {
			stream.write(t.getBytes())
		} catch(IOException e) {
				consumer.accept(e)
		}
	}
}
