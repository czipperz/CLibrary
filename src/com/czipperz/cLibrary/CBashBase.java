package com.czipperz.cLibrary;

import java.awt.*;
import java.util.function.Consumer;

/**
 * Created by czipperz on 3/9/15.
 */
public abstract class CBashBase implements CBash {
    private final Consumer<Color> colorConsumer;
    private final Consumer<String> stringConsumer;
    private Runnable flush;

    public CBashBase(Consumer<Color> colorConsumer, Consumer<String> stringConsumer, Runnable flush) {
        this.colorConsumer = colorConsumer;
        this.stringConsumer = stringConsumer;
        this.flush = flush;
    }

    public CBash setColor(Color c) {
        colorConsumer.accept(c);
        return this;
    }

    public CBash print(String s) {
        stringConsumer.accept(s);
        return this;
    }

    public CBash flush() {
        flush.run();
        return this;
    }
}
