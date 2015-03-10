package com.czipperz.cLibrary;

/**
 * Created by czipperz on 3/9/15.
 */
public class CBashSOut extends CBashBase {
    public CBashSOut() {
        super(c->{},System.out::print,System.out::flush);
    }
}
