package io.czipperz.github.cLibrary.game.controller

import groovy.transform.Immutable

/**
* @author czipperz on 4/9/15.
*/
@Immutable
class CControllerImmutable {
	int axisCount;
	String[] axisName;
	float[] axisValue;
	float[] deadZone;
	int buttonCount;
	String[] buttonName;
	boolean[] buttonPressed;
	int index;
	String name;
	float povX, povY;
	int rumblerCount;
	String[] rumblerName;
	float rxDZ, rxVal;
	float ryDZ, ryVal;
	float rzDZ, rzVal;
	float xDZ, xVal;
	float yDZ, yVal;
	float zDZ, zVal;

	boolean antiCrossRight, antiCrossLeft;
	boolean autoAntiCrossRight, autoAntiCrossLeft;

	public synchronized boolean isLeftBumperPressed() {
		isButtonPressed(BUTTON_LEFT_BUMPER)
	}

	public synchronized boolean isRightBumperPressed() {
		isButtonPressed(BUTTON_RIGHT_BUMPER)
	}

	public synchronized boolean isLeftJoystickPressed() {
		isButtonPressed(BUTTON_LEFT_JOYSTICK)
	}

	public synchronized boolean isRightJoystickPressed() {
		isButtonPressed(BUTTON_RIGHT_JOYSTICK)
	}
}
