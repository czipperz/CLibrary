package com.czipperz.cLibrary.game;

import com.czipperz.cLibrary.game.IDrawAble;

import java.util.Comparator;

/**
 * Created by Chris Gregory on 10/22/2014.
 */

public class CDepthSorter implements Comparator<IDrawAble> {
    public int compare(IDrawAble a, IDrawAble b) {
        return b.getDepth() - a.getDepth();
    }
}
