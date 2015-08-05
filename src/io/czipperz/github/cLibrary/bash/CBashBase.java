package io.czipperz.github.cLibrary.bash;

import java.util.function.Consumer;

/**
* @author czipperz on 4/8/15.
*/
public abstract class CBashBase implements CBash {
	private final Consumer<String> stringConsumer;
	private final Runnable flush;
	private final Consumer<Boolean> boldConsumer;

	public CBashBase(Consumer<String> stringConsumer, Closure flush, Consumer<Boolean> boldConsumer) {
            this.stringConsumer = stringConsumer;
            this.flush = flush;
            this.boldConsumer = boldConsumer;
	}

	public CBash out(Object s) {
            stringConsumer.accept(String.valueOf(s));
            return this;
	}

	public CBash flush() {
            flush.run();
            return this;
	}

	public CBash setBold(boolean b) {
            boldConsumer.accept(b);
            return this;
	}
}
