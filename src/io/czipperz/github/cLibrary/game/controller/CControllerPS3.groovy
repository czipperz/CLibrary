package io.czipperz.github.cLibrary.game.controller

import org.lwjgl.input.Controller

/**
* @author czipperz on 4/9/15.
*/
class CControllerPS3 extends CController {
	static final int buttonSquare = 2, buttonTriangle = 3, buttonCross = 0, buttonCircle = 1, buttonSelect = 6
	CControllerPS3(Controller c) {
		super(c)
	}

	synchronized boolean isCrossPressed() {
		return isButtonPressed(buttonCross)
	}

	synchronized boolean isCirclePressed() {
		return isButtonPressed(buttonCircle)
	}

	synchronized boolean isTrianglePressed() {
		return isButtonPressed(buttonTriangle)
	}

	synchronized boolean isSquarePressed() {
		return isButtonPressed(buttonSquare)
	}

	synchronized boolean isSelectPressed() {
		return isButtonPressed(buttonSelect)
	}
}
