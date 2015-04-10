package io.github.czipperz.cLibrary.game

import java.awt.Graphics
import java.awt.Rectangle

/**
 * Created by czipperz on 4/9/15.
 */
class CObjectWrapper extends CObject {
	private Closure tick, draw
	private Closure<Rectangle> bounds
	CObjectWrapper(CGameFrame displayOn, Closure tick, Closure<Rectangle> bounds, Closure draw) {
		super(displayOn)
		this.tick = tick
		this.draw = draw
		this.bounds = bounds
	}

	CDrawAble tick() {
		tick.call()
		this
	}

	Rectangle getBounds() {
		return bounds()
	}

	CDrawAble draw(Graphics g) {
		draw.call()
		this
	}
}
