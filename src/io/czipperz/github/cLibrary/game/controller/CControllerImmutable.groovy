package io.czipperz.github.cLibrary.game.controller

import groovy.transform.Immutable

/**
 * Created by czipperz on 4/9/15.
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
}
