package io.github.czipperz.cLibrary.game.controller

import org.lwjgl.input.Controller

/**
 * Created by czipperz on 4/9/15.
 */
class CControllerPS3 extends CController {
	static final int buttonSquare = 2, buttonTriangle = 3, buttonCross = 0, buttonCircle = 1, buttonSelect = 6
	CControllerPS3(Controller c) {
		super(c)
	}

	synchronized boolean isCrossPressed() {
		return getButtonPressed()[buttonCross]
	}

	synchronized boolean isCirclePressed() {
		return getButtonPressed()[buttonCircle]
	}

	synchronized boolean isTrianglePressed() {
		return getButtonPressed()[buttonTriangle]
	}

	synchronized boolean isSquarePressed() {
		return getButtonPressed()[buttonSquare]
	}

	synchronized boolean isSelectPressed() {
		return getButtonPressed()[buttonSelect]
	}
}
