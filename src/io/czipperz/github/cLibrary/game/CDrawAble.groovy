package io.czipperz.github.cLibrary.game

import java.awt.Graphics
import java.awt.Rectangle

/**
* @author czipperz on 4/8/15.
*/
trait CDrawAble implements Comparable<CDrawAble> {
	int depth = 0
	Rectangle bounds
	boolean needDraw



	boolean needUpdateBefore() {
		false
	}
	abstract boolean needUpdate()
	boolean needUpdateAfter() {
		false
	}



	CDrawAble tickBefore() {
		this
	}
	abstract CDrawAble tick()
	CDrawAble tickAfter() {
		this
	}



	abstract CDrawAble draw(Graphics g)



	int compareTo(CDrawAble other) {
		new CDepthSorter().compare(this, other)
	}
}
