package io.github.czipperz.cLibrary.game.controller

import org.lwjgl.input.Controller

/**
 * Created by czipperz on 4/9/15.
 */
class CControllerXBox extends CController {
	static final int buttonX = 2, buttonY = 3, buttonA = 0, buttonB = 1, buttonBack = 6

	CControllerXBox(Controller c) {
		super(c)
	}

	synchronized boolean isXPressed() {
		getButtonPressed()[buttonX]
	}

	synchronized boolean isYPressed() {
		getButtonPressed()[buttonY]
	}

	synchronized boolean isAPressed() {
		getButtonPressed()[buttonA]
	}

	synchronized boolean isBPressed() {
		getButtonPressed()[buttonB]
	}

	synchronized boolean isBackPressed() {
		getButtonPressed()[buttonBack]
	}
}
