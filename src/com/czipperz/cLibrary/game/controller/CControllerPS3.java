package com.czipperz.cLibrary.game.controller;

import org.lwjgl.input.Controller;

/**
 * A wrapper for a LWJGL Controller
 * @author Chris Gregory
 */
public abstract class CControllerPS3 extends CController {
	public static final int buttonSquare = 2, buttonTriangle = 3, buttonCross = 0, buttonCircle = 1, buttonSelect = 6;
	
	public CControllerPS3(Controller _c) {
		super(_c);
	}

	public synchronized boolean isCrossPressed() {
		return buttonPressed[buttonCross];
	}

	public synchronized boolean isCirclePressed() {
		return buttonPressed[buttonCircle];
	}

	public synchronized boolean isTrianglePressed() {
		return buttonPressed[buttonTriangle];
	}

	public synchronized boolean isSquarePressed() {
		return buttonPressed[buttonSquare];
	}

	public synchronized boolean isSelectPressed() {
		return buttonPressed[buttonSelect];
	}
}
