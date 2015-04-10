package io.github.czipperz.cLibrary.game

import java.awt.Rectangle

/**
 * Created by czipperz on 4/9/15.
 */
abstract class CObject implements CDrawAble, Serializable {
	private boolean needUpdate = true;
	private boolean needDraw = true;
	final CGameFrame displayOn
	int depth
	Rectangle bounds

	CObject(CGameFrame displayOn, Rectangle bounds) {
		this.displayOn = displayOn
		displayOn.addObject(this)
		this.bounds = bounds
	}

	boolean needUpdate() {
		needUpdate
	}

	public void setNeedDraw(boolean draw) {
		this.needDraw = draw
	}

	boolean needDraw() {
		needDraw
	}

	public void setNeedUpdate(boolean update) {
		this.needUpdate = update
	}

	int compareTo(CDrawAble other) {
		return new CDepthSorter().compare(this, other)
	}
}
