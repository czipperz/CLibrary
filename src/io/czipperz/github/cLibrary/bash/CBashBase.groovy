package io.czipperz.github.cLibrary.bash

import java.util.function.Consumer

/**
* @author czipperz on 4/8/15.
*/
abstract class CBashBase implements CBash {
	private final Consumer<String> stringConsumer;
	private final Closure flush;
	private final Consumer<Boolean> boldConsumer;

	public CBashBase(Consumer<String> stringConsumer, Closure flush, Consumer<Boolean> boldConsumer) {
		this.stringConsumer = stringConsumer
		this.flush = flush
		this.boldConsumer = boldConsumer
	}

	CBash out(s) {
		stringConsumer.accept(String.valueOf(s))
		this
	}

	CBash flush() {
		flush.call()
		this
	}

	CBash setBold(boolean b = true) {
		boldConsumer.accept(b)
		this
	}

	CBash setUBold() {
		setBold(false)
	}
}
