package io.czipperz.github.cLibrary.game

/**
 * Created by czipperz on 4/9/15.
 */
trait CUpdateAble {
	CUpdateAble updateBefore() {
		this
	}
	abstract CUpdateAble update()
	CUpdateAble updateAfter() {
		this
	}
}
