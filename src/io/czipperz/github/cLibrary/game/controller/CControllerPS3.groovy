package io.czipperz.github.cLibrary.game.controller

import groovy.transform.SelfType

/**
* @author czipperz on 4/9/15.
*/
@SelfType(CController)
trait CControllerPS3 {
	static final int buttonSquare = 2, buttonTriangle = 3, buttonCross = 0, buttonCircle = 1, buttonSelect = 6

	synchronized boolean isCrossPressed() {
		((CController) this).isButtonPressed(buttonCross)
	}

	synchronized boolean isCirclePressed() {
		((CController) this).isButtonPressed(buttonCircle)
	}

	synchronized boolean isTrianglePressed() {
		((CController) this).isButtonPressed(buttonTriangle)
	}

	synchronized boolean isSquarePressed() {
		((CController) this).isButtonPressed(buttonSquare)
	}

	synchronized boolean isSelectPressed() {
		((CController) this).isButtonPressed(buttonSelect)
	}
}
