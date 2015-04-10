package io.github.czipperz.cLibrary.game.controller

import io.github.czipperz.cLibrary.location.CPoint
import org.lwjgl.LWJGLException
import org.lwjgl.input.Controller
import org.lwjgl.input.Controllers

/**
 * Created by czipperz on 4/9/15.
 */
abstract class CController {
	static final int BUTTON_LEFT_BUMPER = 4, BUTTON_RIGHT_BUMPER = 5, BUTTON_LEFT_JOYSTICK = 8, BUTTON_RIGHT_JOYSTICK = 9, BUTTON_START = 7;

	static final float DEAD_ZONE = 0.06f

	private static boolean setup = false
	static boolean usingController

	static double getAngleLeft(Controller c) {
		CPoint.getAngle(new CPoint(0,0), new CPoint(c.getXAxisValue(), c.getYAxisValue()))
	}

	static double getAngleRight(Controller c) {
		CPoint.getAngle(new CPoint(0,0), new CPoint(c.getRXAxisValue(), c.getRYAxisValue()))
	}

	static void setUsingController(boolean usingController) {
		if(usingController)
			try {
				setup();
				CController.usingController = true
			} catch(Exception e) {
				CController.usingController = false
				e.printStackTrace()
			}
		else
			CController.usingController = false
	}

	private static void setup() throws LWJGLException, RuntimeException {
		if(setup) {
			return
		}
		Controllers.create()
		Controllers.poll()
		for(int i = 0; i < Controllers.controllerCount; i++) {
			Controller c = Controllers.getController(i)
			c.setXAxisDeadZone DEAD_ZONE
			c.setYAxisDeadZone DEAD_ZONE
			c.setZAxisDeadZone DEAD_ZONE
			c.setRXAxisDeadZone DEAD_ZONE
			c.setRYAxisDeadZone DEAD_ZONE
		}
	}

	static boolean isSetup() {
		return setup
	}





	final Controller c;

	boolean antiCrossRight = false, antiCrossLeft = false;
	boolean autoAntiCrossRight = true, autoAntiCrossLeft = true;

	CController(Controller c) {
		this.c = c
		c.poll()
	}

	CControllerImmutable toCControllerImmutable() {
		immutable()
	}

	CControllerImmutable toImmutable() {
		immutable()
	}

	CControllerImmutable immutable() {
		int axisCount = c.getAxisCount();
		def axisName = new String[axisCount];
		def axisValue = new float[axisCount];
		def deadZone = new float[axisCount];
		for(int i = 0; i < axisCount; i++) {
			axisName[i] = c.getAxisName(i);
			axisValue[i] = c.getAxisValue(i);
			deadZone[i] = c.getDeadZone(i);
		}
		int buttonCount = c.getButtonCount();
		def buttonName = new String[buttonCount];
		def buttonPressed = new boolean[buttonCount];
		for(int i = 0; i < buttonCount; i++) {
			buttonName[i] = c.getButtonName(i);
			buttonPressed[i] = c.isButtonPressed(i);
		}
		int index = c.getIndex();
		String name = c.getName();
		float povX = c.getPovX();
		float povY = c.getPovY();
		int rumblerCount = c.getRumblerCount();
		String[] rumblerName = new String[rumblerCount];
		for(int i = 0; i < rumblerCount; i++) {
			rumblerName[i] = c.getRumblerName(i);
		}
		float rxDZ = c.getRXAxisDeadZone();
		float rxVal = c.getRXAxisValue();
		float ryDZ = c.getRXAxisDeadZone();
		float ryVal = c.getRYAxisValue();
		float rzDZ = c.getRZAxisDeadZone();
		float rzVal = c.getRZAxisValue();

		float xDZ = c.getXAxisDeadZone();
		float xVal = c.getXAxisValue();
		float yDZ = c.getXAxisDeadZone();
		float yVal = c.getYAxisValue();
		float zDZ = c.getZAxisDeadZone();
		float zVal = c.getZAxisValue();

		boolean x = Math.abs(rxVal) > rxDZ;
		boolean y = Math.abs(ryVal) > ryDZ;
		if(autoAntiCrossRight)
			if(x || y)
				def antiCrossRight = true;
			else
				def antiCrossRight = false;
		if(antiCrossRight) {
			rxVal = c.getRXAxisValue();
			ryVal = c.getRYAxisValue();
			if(!x && !y) {
				rxVal = 0;
				ryVal = 0;
			}
		} else  {
			rxVal = x ? rxVal : 0;
			ryVal = y ? ryVal : 0;
		}

		x = Math.abs(xVal) > xDZ;
		y = Math.abs(yVal) > yDZ;
		if(autoAntiCrossLeft) {
			if(x || y)
				def antiCrossLeft = true;
			else
				def antiCrossLeft = false;
		}
		if(antiCrossLeft) {
			if(x || y) {
				xVal = 0;
				yVal = 0;
			}
		} else  {
			xVal = x ? xVal : 0;
			yVal = y ? yVal : 0;
		}
		return new CControllerImmutable(axisCount,axisName,axisValue,deadZone,buttonCount,buttonName,
				buttonPressed,index,name,povX,povY,rumblerCount,rumblerName,rxDZ,rxVal,ryDZ,ryVal,rzDZ,
				rzVal,xDZ,xVal,yDZ,yVal,zDZ,zVal,antiCrossRight,antiCrossLeft,autoAntiCrossRight,autoAntiCrossLeft);
	}

	synchronized CController setAutoAntiCrossRight(boolean antiCross = true) {
		autoAntiCrossRight = antiCross
		this
	}

	synchronized CController setAntiCrossRight(boolean antiCross = true) {
		if(autoAntiCrossRight)
			throw new UnsupportedOperationException()
		antiCrossRight = antiCross
		this
	}

	synchronized  CController setAutoAntiCrossLeft(boolean antiCross = true) {
		autoAntiCrossLeft = antiCross
		this
	}

	synchronized CController setAntiCrossLeft(boolean antiCross = true) {
		if(autoAntiCrossLeft)
			throw new UnsupportedOperationException()
		antiCrossLeft = antiCross
		this
	}

	synchronized String getName() {c.name}
	synchronized int getIndex() {c.index}
	synchronized int getButtonCount() {c.buttonCount}
	synchronized String getButtonName(int index) {c.getButtonName(index)}
	synchronized boolean isButtonPressed(int index) {c.getButtonName(index)}
	synchronized boolean isLeftBumperPressed() {isButtonPressed(BUTTON_LEFT_BUMPER)}
	synchronized boolean isRightBumperPressed() {isButtonPressed(BUTTON_RIGHT_BUMPER)}
	synchronized boolean isLeftJoystickPressed() {isButtonPressed(BUTTON_LEFT_JOYSTICK)}
	synchronized boolean isRightJoystickPressed() {isButtonPressed(BUTTON_RIGHT_JOYSTICK)}
	synchronized boolean isStartPressed() {isButtonPressed(BUTTON_START)}
	synchronized float getPovX() {c.povX}
	synchronized float getPovY() {c.povY}
	synchronized int getAxisCount() {return axisCount}
	synchronized String getAxisName(int index) {c.getAxisName(index)}
	synchronized float getAxisValue(int index) {c.getAxisValue(index)}
	synchronized int getRumblerCount() {return rumblerCount}
	synchronized String getRumblerName(int index) {c.getRumblerName(index)}
	synchronized CController setRumblerStrength(int index, float strength) {c.setRumblerStrength(index, strength);this}


	synchronized CController setDeadZone(float zone) {
		setXAxisDeadZone(zone)
		setYAxisDeadZone(zone)
		setZAxisDeadZone(zone)
		setRXAxisDeadZone(zone)
		setRYAxisDeadZone(zone)
		setRZAxisDeadZone(zone)
	}
	synchronized float getXAxisValue() {c.getXAxisValue()}
	synchronized float getXAxisDeadZone() {c.getXAxisDeadZone()}
	synchronized CController setXAxisDeadZone(float zone) {c.setXAxisDeadZone(zone);this}
	synchronized float getYAxisValue() {c.getYAxisValue()}
	synchronized float getYAxisDeadZone() {c.getYAxisDeadZone()}
	synchronized CController setYAxisDeadZone(float zone) {c.setYAxisDeadZone(zone)}
	synchronized float getZAxisValue() {c.getZAxisValue()}
	synchronized float getZAxisDeadZone() {c.getZAxisDeadZone()}
	synchronized CController setZAxisDeadZone(float zone) {c.setZAxisDeadZone(zone);this}
	synchronized float getRXAxisValue() {c.getRXAxisValue()}
	synchronized float getRXAxisDeadZone() {c.getRXAxisDeadZone()}
	synchronized CController setRXAxisDeadZone(float zone) {c.setRXAxisDeadZone(zone)}
	synchronized float getRYAxisValue() {c.getRYAxisValue()}
	synchronized float getRYAxisDeadZone() {c.getRYAxisDeadZone()}
	synchronized CController setRYAxisDeadZone(float zone) {c.setRYAxisDeadZone(zone);this}
	synchronized float getRZAxisValue() {c.getRZAxisValue()}
	synchronized float getRZAxisDeadZone() {c.getRZAxisDeadZone()}
	synchronized CController setRZAxisDeadZone(float zone) {c.setRZAxisDeadZone(zone)}
}
