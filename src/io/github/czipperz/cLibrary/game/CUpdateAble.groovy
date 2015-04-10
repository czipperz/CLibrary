package io.github.czipperz.cLibrary.game

/**
 * Created by czipperz on 4/9/15.
 */
trait CUpdateAble {
	CUpdateAble updateBefore() {
		return this
	}
	abstract CUpdateAble update()
	CUpdateAble updateAfter() {
		return this
	}
}
