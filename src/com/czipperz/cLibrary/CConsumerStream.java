package com.czipperz.cLibrary;

import java.io.IOException;
import java.io.OutputStream;
import java.util.function.Consumer;

/**
 * Created by czipperz on 3/9/15.
 */
public class CConsumerStream  implements Consumer<String> {
    private OutputStream stream;
    private Consumer<IOException> consumer;

    public CConsumerStream(OutputStream stream, Consumer<IOException> consumer) {
        this.stream = stream;
        this.consumer = consumer;
    }
    public void accept(String t) {
        try {
            stream.write(t.getBytes());
        } catch (IOException e) {
            try {
                consumer.accept(e);
            } catch(RuntimeException e1) {
                e1.printStackTrace();
            }
        }
    }
}
