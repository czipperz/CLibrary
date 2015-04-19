package io.czipperz.github.cLibrary.game.controller

import org.lwjgl.input.Controller

/**
* @author czipperz on 4/9/15.
*/
class CControllerXBox extends CController {
	static final int buttonX = 2, buttonY = 3, buttonA = 0, buttonB = 1, buttonBack = 6

	CControllerXBox(Controller c) {
		super(c)
	}

	synchronized boolean isXPressed() {
		isButtonPressed(buttonX)
	}

	synchronized boolean isYPressed() {
		isButtonPressed(buttonY)
	}

	synchronized boolean isAPressed() {
		isButtonPressed(buttonA)
	}

	synchronized boolean isBPressed() {
		isButtonPressed(buttonB)
	}

	synchronized boolean isBackPressed() {
		isButtonPressed(buttonBack)
	}
}
