package io.czipperz.github.cLibrary.game

/**
 * Created by czipperz on 4/8/15.
 */
class CDepthSorter implements Comparator<CDrawAble> {
	public int compare(CDrawAble o1, CDrawAble o2) {
		return o2.depth - o1.depth
	}
}
