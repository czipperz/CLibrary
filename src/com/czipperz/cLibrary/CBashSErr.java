package com.czipperz.cLibrary;

/**
 * Created by czipperz on 3/9/15.
 */
public class CBashSErr extends CBashBase {
    public CBashSErr() {
        super(c->{},System.err::print,System.err::flush);
    }
}
