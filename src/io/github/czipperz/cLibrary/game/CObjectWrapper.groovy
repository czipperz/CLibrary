package io.github.czipperz.cLibrary.game

import java.awt.Graphics
import java.awt.Rectangle

/**
 * Created by czipperz on 4/9/15.
 */
class CObjectWrapper extends CObject {
	private Closure tickcl, drawcl
	private Closure<Rectangle> boundscl
	CObjectWrapper(CGameFrame displayOn, Closure tick, Closure<Rectangle> bounds, Closure draw) {
		super(displayOn, bounds())
		this.tickcl = tick
		this.drawcl = draw
		this.boundscl = bounds
	}

	CDrawAble tick() {
		tickcl()
		this
	}

	void setBounds(Rectangle r) {}

	Rectangle getBounds() {
		boundscl()
	}

	CDrawAble draw(Graphics g) {
		drawcl g
		this
	}
}
