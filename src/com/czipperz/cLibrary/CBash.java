package com.czipperz.cLibrary;

import java.io.IOException;
import java.io.OutputStream;
import java.util.function.Consumer;

/**
 * Created by Chris on 2/16/2015.
 */
public class CBash {
    private enum InputMethods {Stream, Consumer}

    private InputMethods method;
    private OutputStream stream;
    private Consumer<String> consumer;

    public CBash(OutputStream stream) {
        method = InputMethods.Stream;
        this.stream = stream;
    }

    public CBash(Consumer<String> consumer) {
        method = InputMethods.Stream;
        this.consumer = consumer;
    }

    public CBash print(String s) throws IOException {
        if(method == InputMethods.Consumer) consumer.accept(s);
        else stream.write(s.getBytes());
        return this;
    }

    public CBash print(boolean b) throws IOException {
        if(method == InputMethods.Consumer) consumer.accept(b ? "true" : "false");
        else stream.write(b ? "true".getBytes() : "false".getBytes());
        return this;
    }

    public CBash print(char c) throws IOException {
        if(method == InputMethods.Consumer) consumer.accept(((Character) c).toString());
        else stream.write(c);
        return this;
    }

    public CBash print(int i) throws IOException {
        if(method == InputMethods.Consumer) consumer.accept(((Integer) i).toString());
        else stream.write(((Integer) i).byteValue());
        return this;
    }

    public CBash print(byte b) throws IOException {
        if(method == InputMethods.Consumer) consumer.accept(((Byte) b).toString());
        else stream.write(b);
        return this;
    }

    public CBash print(double d) throws IOException {
        if(method == InputMethods.Consumer) consumer.accept(((Double) d).toString());
        else stream.write(((Double) d).byteValue());
        return this;
    }

    public CBash print(float d) throws IOException {
        if(method == InputMethods.Consumer) consumer.accept(((Float) d).toString());
        else stream.write(((Float) d).byteValue());
        return this;
    }

    public CBash print(short d) throws IOException {
        if(method == InputMethods.Consumer) consumer.accept(((Short) d).toString());
        else stream.write(((Short) d).byteValue());
        return this;
    }

    public CBash print(long d) throws IOException {
        if(method == InputMethods.Consumer) consumer.accept(((Long) d).toString());
        else stream.write(((Long) d).byteValue());
        return this;
    }

    public CBash println(String s) throws IOException {
        if(method == InputMethods.Consumer) {
            consumer.accept(s);
            consumer.accept("\n");
        }
        else {
            stream.write(s.getBytes());
            stream.write("\n".getBytes());
        }
        return this;
    }

    public CBash println(boolean b) throws IOException {
        if(method == InputMethods.Consumer) {
            consumer.accept(b ? "true" : "false");
            consumer.accept("\n");
        }
        else {
            stream.write(b ? "true".getBytes() : "false".getBytes());
            stream.write("\n".getBytes());
        }
        return this;
    }

    public CBash println(char c) throws IOException {
        if(method == InputMethods.Consumer) {
            consumer.accept(((Character) c).toString());
            consumer.accept("\n");
        }
        else {
            stream.write(c);
            stream.write("\n".getBytes());
        }
        return this;
    }

    public CBash println(int i) throws IOException {
        if(method == InputMethods.Consumer) {
            consumer.accept(((Integer) i).toString());
            consumer.accept("\n");
        }
        else {
            stream.write(((Integer) i).byteValue());
            stream.write("\n".getBytes());
        }
        return this;
    }

    public CBash println(byte b) throws IOException {
        if(method == InputMethods.Consumer) {
            consumer.accept(((Byte) b).toString());
            consumer.accept("\n");
        }
        else {
            stream.write(b);
            stream.write("\n".getBytes());
        }
        return this;
    }

    public CBash println(double d) throws IOException {
        if(method == InputMethods.Consumer) {
            consumer.accept(((Double) d).toString());
            consumer.accept("\n");
        }
        else {
            stream.write(((Double) d).byteValue());
            stream.write("\n".getBytes());
        }
        return this;
    }

    public CBash println(float d) throws IOException {
        if(method == InputMethods.Consumer) {
            consumer.accept(((Float) d).toString());
            consumer.accept("\n");
        }
        else {
            stream.write(((Float) d).byteValue());
            stream.write("\n".getBytes());
        }
        return this;
    }

    public CBash println(short d) throws IOException {
        if(method == InputMethods.Consumer) {
            consumer.accept(((Short) d).toString());
            consumer.accept("\n");
        }
        else {
            stream.write(((Short) d).byteValue());
            stream.write("\n".getBytes());
        }
        return this;
    }

    public CBash println(long d) throws IOException {
        if(method == InputMethods.Consumer) {
            consumer.accept(((Long) d).toString());
            consumer.accept("\n");
        }
        else {
            stream.write(((Long) d).byteValue());
            stream.write("\n".getBytes());
        }
        return this;
    }
}
