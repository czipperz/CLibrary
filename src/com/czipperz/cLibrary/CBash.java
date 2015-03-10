package com.czipperz.cLibrary;

import java.awt.*;

/**
 * Created by Chris on 2/16/2015.
 */
public interface CBash {
    public CBash setColor(Color c);
    public CBash print(String s);
    public CBash flush();


    /*
       These methods just call the abstract print(String) method.
     */
    public default CBash print(boolean b) {
        return print(Boolean.toString(b));
    }
    public default CBash print(char c) {
        return print(Character.toString(c));
    }
    public default CBash print(int i) {
        return print(Integer.toString(i));
    }
    public default CBash print(byte b) {
        return print(Byte.toString(b));
    }
    public default CBash print(double d) {
        return print(Double.toString(d));
    }
    public default CBash print(float d) {
        return print(Float.toString(d));
    }
    public default CBash print(short d) {
        return print(Short.toString(d));
    }
    public default CBash print(long d) {
        return print(Long.toString(d));
    }

    public default CBash println() {
        return print("\n");
    }
    public default CBash println(String s) {
        return print(s).println();
    }
    public default CBash println(boolean b) {
        return println(Boolean.toString(b));
    }
    public default CBash println(char c) {
        return println(Character.toString(c));
    }
    public default CBash println(int i) {
        return println(Integer.toString(i));
    }
    public default CBash println(byte b) {
        return println(Byte.toString(b));
    }
    public default CBash println(double d) {
        return println(Double.toString(d));
    }
    public default CBash println(float f) {
        return println(Float.toString(f));
    }
    public default CBash println(short s) {
        return println(Short.toString(s));
    }
    public default CBash println(long d) {
        return println(Long.toString(d));
    }
}
