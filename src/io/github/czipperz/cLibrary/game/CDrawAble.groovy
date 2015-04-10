package io.github.czipperz.cLibrary.game

import java.awt.Graphics
import java.awt.Rectangle

/**
 * Created by czipperz on 4/8/15.
 */
trait CDrawAble implements Comparable<CDrawAble> {
	boolean needUpdateBefore() {
		return false
	}
	abstract boolean needUpdate()
	boolean needUpdateAfter() {
		return false
	}


	CDrawAble tickBefore() {
		return this
	}
	abstract CDrawAble tick()
	CDrawAble tickAfter() {
		return this
	}



	abstract int getDepth()
	abstract Rectangle getBounds()



	abstract boolean needDraw()
	abstract CDrawAble draw(Graphics g)



	abstract int compareTo(CDrawAble other)
}
