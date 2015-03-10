package com.czipperz.cLibrary.exceptions;

import java.io.PrintWriter;
import java.util.function.Consumer;

/**
 * Created by Chris on 2/5/2015.
 */
public class CExceptionParser {
    public static void feed(Exception e, Consumer<String> bash) {
            PrintWriter pw = new PrintWriter(System.out) {
                public void print(String s) {
                    bash.accept(s);
                }
            };
            e.printStackTrace(pw);
    }
}
