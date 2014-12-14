package com.czipperz.cLibrary.game;

import java.util.Comparator;

/**
 * Created by Chris Gregory on 10/22/2014.
 */

public class CDepthSorter implements Comparator<IDrawAble> {
    public int compare(IDrawAble o1, IDrawAble o2) {
        return o2.getDepth() - o1.getDepth();
    }
}