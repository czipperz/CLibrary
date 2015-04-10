package io.github.czipperz.cLibrary.game

import java.awt.Rectangle

/**
 * Created by czipperz on 4/9/15.
 */
abstract class CObject implements CDrawAble, Serializable {
	private boolean needUpdate = true;
	final CGameFrame displayOn

	CObject(CGameFrame displayOn, Rectangle bounds) {
		this.displayOn = displayOn
		displayOn.addObject(this)
		this.bounds = bounds
	}

	boolean needUpdate() {
		needUpdate
	}

	public void setNeedUpdate(boolean update) {
		this.needUpdate = update
	}
}
