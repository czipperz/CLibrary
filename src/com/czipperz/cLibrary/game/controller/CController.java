package com.czipperz.cLibrary.game.controller;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Controller;
import org.lwjgl.input.Controllers;

import com.czipperz.cLibrary.location.CPoint;

public abstract class CController {
	public static final int BUTTON_LEFT_BUMPER = 4, BUTTON_RIGHT_BUMPER = 5, BUTTON_LEFT_JOYSTICK = 8, BUTTON_RIGHT_JOYSTICK = 9, BUTTON_START = 7;

	private static boolean SETUP = false;
    private static boolean USING_CONTROLLER;

    /**
     * Returns the radian measure of the angles on the <b>left JOYSTICK</b>.
     * @param c the controller to get the angle for.
     * @return the double radian measure
     */
	public static double getAngleLeft(Controller c) {
		return CPoint.getAngleRadians(new CPoint(0, 0), new CPoint(c.getXAxisValue(), c.getYAxisValue()));
	}

    /**
     * Returns the radian measure of the angles on the <b>right JOYSTICK</b>.
     * @param c the controller to get the angle for.
     * @return the double radian measure
     */
	public static double getAngleRight(Controller c) {
		return CPoint.getAngleRadians(new CPoint(0, 0), new CPoint(c.getRXAxisValue(), c.getRYAxisValue()));
	}

	public static void setUsingController(boolean usingController) {
		if(usingController) {
			try {
				setup();
                CController.USING_CONTROLLER = true;
			} catch (Exception e) {
				CController.USING_CONTROLLER = false;
				e.printStackTrace();
				return;
			}
		} else
			CController.USING_CONTROLLER = false;
	}

	public static boolean isUsingController() {
		return USING_CONTROLLER;
	}

	public static final float DEAD_ZONE = 0.06f;
	
	private static void setup() throws LWJGLException, RuntimeException {
		if(SETUP) {
			return;
		}
		Controllers.create();
		Controllers.poll();
		for(int i = 0; i < Controllers.getControllerCount(); i++) {
			Controller c = Controllers.getController(i);
			c.setXAxisDeadZone(DEAD_ZONE);
			c.setYAxisDeadZone(DEAD_ZONE);
			c.setZAxisDeadZone(DEAD_ZONE);
			c.setRXAxisDeadZone(DEAD_ZONE);
			c.setRYAxisDeadZone(DEAD_ZONE);
		}
		SETUP = true;
	}
	
	
	private Controller c = null;
	private int axisCount = -1;
	private String[] axisName = null;
	private float[] axisValue = null;
	private float[] deadZone = null;
	private int buttonCount = -1;
	private String[] buttonName = null;
	boolean[] buttonPressed = null;
	private int index = -1;
	private String name = null;
	private float povX = -1, povY = -1;
	private int rumblerCount = -1;
	private String[] rumblerName = null;
	private float rxDZ = DEAD_ZONE, rxVal = 0;
	private float ryDZ = DEAD_ZONE, ryVal = 0;
	private float rzDZ = DEAD_ZONE, rzVal = 0;
	private float xDZ = DEAD_ZONE, xVal = 0;
	private float yDZ = DEAD_ZONE, yVal = 0;
	private float zDZ = DEAD_ZONE, zVal = 0;
	private float rxAxisDeadZone = 0, rxAxisValue = 0;
	private float ryAxisDeadZone = 0, ryAxisValue = 0;
	private float rzAxisDeadZone = 0, rzAxisValue = 0;
	private float xAxisDeadZone = 0, xAxisValue = 0;
	private float yAxisDeadZone = 0, yAxisValue = 0;
	private float zAxisDeadZone = 0, zAxisValue = 0;

	private boolean antiCrossRight = false, antiCrossLeft = false;
	private boolean autoAntiCrossRight = true, autoAntiCrossLeft = true;

	public CController(Controller _c) {
		c = _c;
		pollThisOnly();
	}

	public synchronized CController setAutoAntiCrossRight(boolean _autoAntiCross) {
		autoAntiCrossRight = _autoAntiCross;
		return this;
	}

	public boolean isAutoAntiCrossRight() {
		return autoAntiCrossRight;
	}

	public synchronized CController setAntiCrossRight(boolean _antiCross) {
		if(autoAntiCrossRight)
			throw new UnsupportedOperationException();
		antiCrossRight = _antiCross;
		return this;
	}

	public boolean isAntiCrossRight() {
		return antiCrossRight;
	}

	public synchronized CController setAutoAntiCrossLeft(boolean _autoAntiCross) {
		autoAntiCrossLeft = _autoAntiCross;
		return this;
	}

	public boolean isAutoAntiCrossLeft() {
		return autoAntiCrossLeft;
	}

	public synchronized CController setAntiCrossLeft(boolean _antiCross) {
		if(autoAntiCrossLeft)
			throw new UnsupportedOperationException();
		antiCrossLeft = _antiCross;
		return this;
	}

	public boolean isAntiCrossLeft() {
		return antiCrossLeft;
	}

	public synchronized CController pollThisOnly() {
		axisCount = c.getAxisCount();
		axisName = new String[axisCount];
		axisValue = new float[axisCount];
		deadZone = new float[axisCount];
		for(int i = 0; i < axisCount; i++) {
			axisName[i] = c.getAxisName(i);
			axisValue[i] = c.getAxisValue(i);
			deadZone[i] = c.getDeadZone(i);
		}
		buttonCount = c.getButtonCount();
		buttonName = new String[buttonCount];
		buttonPressed = new boolean[buttonCount];
		for(int i = 0; i < buttonCount; i++) {
			buttonName[i] = c.getButtonName(i);
			buttonPressed[i] = c.isButtonPressed(i);
		}
		index = c.getIndex();
		name = c.getName();
		povX = c.getPovX();
		povY = c.getPovY();
		rumblerCount = c.getRumblerCount();
		rumblerName = new String[rumblerCount];
		for(int i = 0; i < rumblerCount; i++) {
			rumblerName[i] = c.getRumblerName(i);
		}
		rxAxisDeadZone = c.getRXAxisDeadZone();
		rxAxisValue = c.getRXAxisValue();
		ryAxisDeadZone = c.getRXAxisDeadZone();
		ryAxisValue = c.getRYAxisValue();
		rzAxisDeadZone = c.getRZAxisDeadZone();
		rzAxisValue = c.getRZAxisValue();
		xAxisDeadZone = c.getXAxisDeadZone();
		xAxisValue = c.getXAxisValue();
		yAxisDeadZone = c.getXAxisDeadZone();
		yAxisValue = c.getYAxisValue();
		zAxisDeadZone = c.getZAxisDeadZone();
		zAxisValue = c.getZAxisValue();

		boolean x = Math.abs(rxAxisValue) > rxDZ;
		boolean y = Math.abs(ryAxisValue) > ryDZ;
		if(autoAntiCrossRight) {
			if(x || y)
				antiCrossRight = true;
			else
				antiCrossRight = false;
		}
		if(antiCrossRight) {
			rxVal = rxAxisValue;
			ryVal = ryAxisValue;
			if(!x && !y) {
				rxVal = 0;
				ryVal = 0;
			}
		} else  {
			rxVal = x ? rxAxisValue : 0;
			ryVal = y ? ryAxisValue : 0;
		}
		
		x = Math.abs(xAxisValue) > xDZ;
		y = Math.abs(yAxisValue) > yDZ;
		if(autoAntiCrossLeft) {
			if(x || y)
				antiCrossLeft = true;
			else
				antiCrossLeft = false;
		}
		if(antiCrossLeft) {
			xVal = xAxisValue;
			yVal = yAxisValue;
			if(!x && !y) {
				xVal = 0;
				yVal = 0;
			}
		} else  {
			xVal = x ? xAxisValue : 0;
			yVal = y ? yAxisValue : 0;
		}
		return this;
	}

	public synchronized CController pollBoth() {
		c.poll();
		pollThisOnly();
		return this;
	}

	public Controller getController() {
		return c;
	}

	public synchronized String getName() {
		return name;
	}

	public synchronized int getIndex() {
		return index;
	}

	public synchronized int getButtonCount() {
		return buttonCount;
	}

	public synchronized String getButtonName(int index) {
		return buttonName[index];
	}

	public synchronized boolean isButtonPressed(int index) {
		return buttonPressed[index];
	}
	
	public synchronized boolean isLeftBumperPressed() {
		return buttonPressed[BUTTON_LEFT_BUMPER];
	}
	
	public synchronized boolean isRightBumperPressed() {
		return buttonPressed[BUTTON_RIGHT_BUMPER];
	}
	
	public synchronized boolean isLeftJoystickPressed() {
		return buttonPressed[BUTTON_LEFT_JOYSTICK];
	}

	public synchronized boolean isRightJoystickPressed() {
		return buttonPressed[BUTTON_RIGHT_JOYSTICK];
	}
	
	public synchronized boolean isStartPressed() {
		return buttonPressed[BUTTON_START];
	}
	
	public synchronized float getPovX() {
		return povX;
	}

	public synchronized float getPovY() {
		return povY;
	}

	public synchronized int getAxisCount() {
		return axisCount;
	}

	public synchronized String getAxisName(int index) {
		return axisName[index];
	}

	public synchronized float getAxisValue(int index) {
		return axisValue[index];
	}

	public synchronized int getRumblerCount() {
		return rumblerCount;
	}

	public synchronized String getRumblerName(int index) {
		return rumblerName[index];
	}

	public CController setRumblerStrength(int index, float strength) {
		c.setRumblerStrength(index, strength);
		return this;
	}

	public synchronized float getXAxisValue() {
		return xVal;
	}

	public synchronized float getXAxisDeadZone() {
		return xDZ;
	}

	public synchronized CController setXAxisDeadZone(float zone) {
		xDZ = zone;
		return this;
	}

	public synchronized float getYAxisValue() {
		return yVal;
	}

	public synchronized float getYAxisDeadZone() {
		return yDZ;
	}

	public synchronized CController setYAxisDeadZone(float zone) {
		yDZ = zone;
		return this;
	}

	public synchronized float getZAxisValue() {
		return zVal;
	}

	public synchronized float getZAxisDeadZone() {
		return zDZ;
	}

	public synchronized CController setZAxisDeadZone(float zone) {
		zDZ = zone;
		return this;
	}

	public synchronized float getRXAxisValue() {
		return rxVal;
	}

	public synchronized float getRXAxisDeadZone() {
		return rxDZ;
	}

	public synchronized CController setRXAxisDeadZone(float zone) {
		rxDZ = zone;
		return this;
	}

	public synchronized float getRYAxisValue() {
		return ryVal;
	}

	public synchronized float getRYAxisDeadZone() {
		return ryDZ;
	}

	public synchronized CController setRYAxisDeadZone(float zone) {
		ryDZ = zone;
		return this;
	}

	public synchronized float getRZAxisValue() {
		return rzVal;
	}

	public synchronized float getRZAxisDeadZone() {
		return rzDZ;
	}

	public synchronized CController setRZAxisDeadZone(float zone) {
		rzDZ = zone;
		return this;
	}

	
	
	
	public synchronized float getXAxisValueActual() {
		return xAxisValue;
	}

	public synchronized float getXAxisDeadZoneActual() {
		return xAxisDeadZone;
	}

	public synchronized CController setXAxisDeadZoneActual(float zone) {
		c.setXAxisDeadZone(zone);
		xAxisDeadZone = zone;
		return this;
	}

	public synchronized float getYAxisValueActual() {
		return yAxisValue;
	}

	public synchronized float getYAxisDeadZoneActual() {
		return yAxisDeadZone;
	}

	public synchronized CController setYAxisDeadZoneActual(float zone) {
		c.setYAxisDeadZone(zone);
		yAxisDeadZone = zone;
		return this;
	}

	public synchronized float getZAxisValueActual() {
		return zAxisValue;
	}

	public synchronized float getZAxisDeadZoneActual() {
		return zAxisDeadZone;
	}

	public synchronized CController setZAxisDeadZoneActual(float zone) {
		c.setZAxisDeadZone(zone);
		zAxisDeadZone = zone;
		return this;
	}

	public synchronized float getRXAxisValueActual() {
		return rzAxisValue;
	}

	public synchronized float getRXAxisDeadZoneActual() {
		return rxAxisDeadZone;
	}

	public synchronized CController setRXAxisDeadZoneActual(float zone) {
		c.setRXAxisDeadZone(zone);
		rxAxisDeadZone = zone;
		return this;
	}

	public synchronized float getRYAxisValueActual() {
		return ryAxisValue;
	}

	public synchronized float getRYAxisDeadZoneActual() {
		return ryAxisDeadZone;
	}

	public synchronized CController setRYAxisDeadZoneActual(float zone) {
		c.setRYAxisDeadZone(zone);
		ryAxisDeadZone = zone;
		return this;
	}

	public synchronized float getRZAxisValueActual() {
		return rzAxisValue;
	}

	public synchronized float getRZAxisDeadZoneActual() {
		return rzAxisDeadZone;
	}

	public synchronized CController setRZAxisDeadZoneActual(float zone) {
		c.setRZAxisDeadZone(zone);
		rzAxisDeadZone = zone;
		return this;
	}
}
