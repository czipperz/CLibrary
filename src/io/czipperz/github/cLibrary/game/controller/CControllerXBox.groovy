package io.czipperz.github.cLibrary.game.controller

import groovy.transform.SelfType

/**
* @author czipperz on 4/9/15.
*/
@SelfType(CController)
trait CControllerXBox {
	static final int buttonX = 2, buttonY = 3, buttonA = 0, buttonB = 1, buttonBack = 6

	synchronized boolean isXPressed() {
		((CController) this).isButtonPressed(buttonX)
	}

	synchronized boolean isYPressed() {
		((CController) this).isButtonPressed(buttonY)
	}

	synchronized boolean isAPressed() {
		((CController) this).isButtonPressed(buttonA)
	}

	synchronized boolean isBPressed() {
		((CController) this).isButtonPressed(buttonB)
	}

	synchronized boolean isBackPressed() {
		((CController) this).isButtonPressed(buttonBack)
	}
}
