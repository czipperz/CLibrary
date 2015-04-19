package io.czipperz.github.cLibrary.game.controller

import io.czipperz.github.cLibrary.location.CPoint
import org.lwjgl.LWJGLException
import org.lwjgl.input.Controller
import org.lwjgl.input.Controllers

/**
* @author czipperz on 4/9/15.
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
				usingController = true
			} catch(Exception e) {
				usingController = false
				e.printStackTrace()
			}
		else
			usingController = false
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





	final Controller controller;

	boolean antiCrossRight = false, antiCrossLeft = false;
	boolean autoAntiCrossRight = true, autoAntiCrossLeft = true;

	CController(Controller controller) {
		this.controller = controller
		controller.poll()
	}

	CControllerImmutable toCControllerImmutable() {
		immutable()
	}

	CControllerImmutable toImmutable() {
		immutable()
	}

	CControllerImmutable immutable() {
		int axisCount = controller.getAxisCount();
		def axisName = new String[axisCount];
		def axisValue = new float[axisCount];
		def deadZone = new float[axisCount];
		for(int i = 0; i < axisCount; i++) {
			axisName[i] = controller.getAxisName(i);
			axisValue[i] = controller.getAxisValue(i);
			deadZone[i] = controller.getDeadZone(i);
		}
		int buttonCount = controller.getButtonCount();
		def buttonName = new String[buttonCount];
		def buttonPressed = new boolean[buttonCount];
		for(int i = 0; i < buttonCount; i++) {
			buttonName[i] = controller.getButtonName(i);
			buttonPressed[i] = controller.isButtonPressed(i);
		}
		int index = controller.getIndex();
		String name = controller.getName();
		float povX = controller.getPovX();
		float povY = controller.getPovY();
		int rumblerCount = controller.getRumblerCount();
		String[] rumblerName = new String[rumblerCount];
		for(int i = 0; i < rumblerCount; i++) {
			rumblerName[i] = controller.getRumblerName(i);
		}
		float rxDZ = controller.getRXAxisDeadZone();
		float rxVal = controller.getRXAxisValue();
		float ryDZ = controller.getRXAxisDeadZone();
		float ryVal = controller.getRYAxisValue();
		float rzDZ = controller.getRZAxisDeadZone();
		float rzVal = controller.getRZAxisValue();

		float xDZ = controller.getXAxisDeadZone();
		float xVal = controller.getXAxisValue();
		float yDZ = controller.getXAxisDeadZone();
		float yVal = controller.getYAxisValue();
		float zDZ = controller.getZAxisDeadZone();
		float zVal = controller.getZAxisValue();

		boolean x = Math.abs(rxVal) > rxDZ;
		boolean y = Math.abs(ryVal) > ryDZ;
		if(autoAntiCrossRight)
			if(x || y)
				def antiCrossRight = true;
			else
				def antiCrossRight = false;
		if(antiCrossRight) {
			rxVal = controller.getRXAxisValue();
			ryVal = controller.getRYAxisValue();
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

	synchronized CController setAutoAntiCrossLeft(boolean antiCross = true) {
		autoAntiCrossLeft = antiCross
		this
	}

	synchronized CController setAntiCrossLeft(boolean antiCross = true) {
		if(autoAntiCrossLeft)
			throw new UnsupportedOperationException()
		antiCrossLeft = antiCross
		this
	}

	synchronized String getName() {controller.name}
	synchronized int getIndex() {controller.index}
	synchronized int getButtonCount() {controller.buttonCount}
	synchronized String getButtonName(int index) {controller.getButtonName(index)}
	synchronized boolean isButtonPressed(int index) {controller.getButtonName(index)}
	synchronized boolean isLeftBumperPressed() {isButtonPressed(BUTTON_LEFT_BUMPER)}
	synchronized boolean isRightBumperPressed() {isButtonPressed(BUTTON_RIGHT_BUMPER)}
	synchronized boolean isLeftJoystickPressed() {isButtonPressed(BUTTON_LEFT_JOYSTICK)}
	synchronized boolean isRightJoystickPressed() {isButtonPressed(BUTTON_RIGHT_JOYSTICK)}
	synchronized boolean isStartPressed() {isButtonPressed(BUTTON_START)}
	synchronized float getPovX() {controller.povX}
	synchronized float getPovY() {controller.povY}
	synchronized int getAxisCount() {return axisCount}
	synchronized String getAxisName(int index) {controller.getAxisName(index)}
	synchronized float getAxisValue(int index) {controller.getAxisValue(index)}
	synchronized int getRumblerCount() {return rumblerCount}
	synchronized String getRumblerName(int index) {controller.getRumblerName(index)}
	synchronized CController setRumblerStrength(int index, float strength) {controller.setRumblerStrength(index, strength);this}


	synchronized CController setDeadZone(float zone) {
		setXAxisDeadZone(zone)
		setYAxisDeadZone(zone)
		setZAxisDeadZone(zone)
		setRXAxisDeadZone(zone)
		setRYAxisDeadZone(zone)
		setRZAxisDeadZone(zone)
	}
	synchronized float getXAxisValue() {controller.getXAxisValue()}
	synchronized float getXAxisDeadZone() {controller.getXAxisDeadZone()}
	synchronized CController setXAxisDeadZone(float zone) {controller.setXAxisDeadZone(zone);this}
	synchronized float getYAxisValue() {controller.getYAxisValue()}
	synchronized float getYAxisDeadZone() {controller.getYAxisDeadZone()}
	synchronized CController setYAxisDeadZone(float zone) {controller.setYAxisDeadZone(zone)}
	synchronized float getZAxisValue() {controller.getZAxisValue()}
	synchronized float getZAxisDeadZone() {controller.getZAxisDeadZone()}
	synchronized CController setZAxisDeadZone(float zone) {controller.setZAxisDeadZone(zone);this}
	synchronized float getRXAxisValue() {controller.getRXAxisValue()}
	synchronized float getRXAxisDeadZone() {controller.getRXAxisDeadZone()}
	synchronized CController setRXAxisDeadZone(float zone) {controller.setRXAxisDeadZone(zone)}
	synchronized float getRYAxisValue() {controller.getRYAxisValue()}
	synchronized float getRYAxisDeadZone() {controller.getRYAxisDeadZone()}
	synchronized CController setRYAxisDeadZone(float zone) {controller.setRYAxisDeadZone(zone);this}
	synchronized float getRZAxisValue() {controller.getRZAxisValue()}
	synchronized float getRZAxisDeadZone() {controller.getRZAxisDeadZone()}
	synchronized CController setRZAxisDeadZone(float zone) {controller.setRZAxisDeadZone(zone)}
}
