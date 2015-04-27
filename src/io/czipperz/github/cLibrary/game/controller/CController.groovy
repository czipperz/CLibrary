package io.czipperz.github.cLibrary.game.controller

import io.czipperz.github.cLibrary.location.CPoint
import org.lwjgl.LWJGLException
import org.lwjgl.input.Controller
import org.lwjgl.input.Controllers

/**
 * Created by czipperz on 4/26/15.
 */
class CController {
    static final int BUTTON_LEFT_BUMPER = 4, BUTTON_RIGHT_BUMPER = 5, BUTTON_LEFT_JOYSTICK = 8, BUTTON_RIGHT_JOYSTICK = 9, BUTTON_START = 7;
    static final float DEAD_ZONE = 0.06f
    private static boolean setup = false
    static boolean usingController

    static double getAngleLeft(Controller c) {
        CPoint.getAngle(new CPoint(0, 0), new CPoint(c.getXAxisValue(), c.getYAxisValue()))
    }

    static double getAngleRight(Controller c) {
        CPoint.getAngle(new CPoint(0, 0), new CPoint(c.getRXAxisValue(), c.getRYAxisValue()))
    }

    static void setUsingController(boolean usingController) {
        if (usingController)
            try {
                setup();
                usingController = true
            } catch (Exception e) {
                usingController = false
                e.printStackTrace()
            }
        else
            usingController = false
    }

    private static void setup() throws LWJGLException, RuntimeException {
        if (setup) {
            return
        }
        Controllers.create()
        Controllers.poll()
        for (int i = 0; i < Controllers.controllerCount; i++) {
            Controller c = Controllers.getController(i)
            c.setXAxisDeadZone DEAD_ZONE
            c.setYAxisDeadZone DEAD_ZONE
            c.setZAxisDeadZone DEAD_ZONE
            c.setRXAxisDeadZone DEAD_ZONE
            c.setRYAxisDeadZone DEAD_ZONE
        }
    }


    @Delegate Controller controller;

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
        for (int i = 0; i < axisCount; i++) {
            axisName[i] = controller.getAxisName(i);
            axisValue[i] = controller.getAxisValue(i);
            deadZone[i] = controller.getDeadZone(i);
        }
        int buttonCount = controller.getButtonCount();
        def buttonName = new String[buttonCount];
        def buttonPressed = new boolean[buttonCount];
        for (int i = 0; i < buttonCount; i++) {
            buttonName[i] = controller.getButtonName(i);
            buttonPressed[i] = controller.isButtonPressed(i);
        }
        int index = controller.getIndex();
        String name = controller.getName();
        float povX = controller.getPovX();
        float povY = controller.getPovY();
        int rumblerCount = controller.getRumblerCount();
        String[] rumblerName = new String[rumblerCount];
        for (int i = 0; i < rumblerCount; i++) {
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
        if (autoAntiCrossRight)
            if (x || y)
                def antiCrossRight = true;
            else
                def antiCrossRight = false;
        if (antiCrossRight) {
            rxVal = controller.getRXAxisValue();
            ryVal = controller.getRYAxisValue();
            if (!x && !y) {
                rxVal = 0;
                ryVal = 0;
            }
        } else {
            rxVal = x ? rxVal : 0;
            ryVal = y ? ryVal : 0;
        }

        x = Math.abs(xVal) > xDZ;
        y = Math.abs(yVal) > yDZ;
        if (autoAntiCrossLeft) {
            if (x || y)
                def antiCrossLeft = true;
            else
                def antiCrossLeft = false;
        }
        if (antiCrossLeft) {
            if (x || y) {
                xVal = 0;
                yVal = 0;
            }
        } else {
            xVal = x ? xVal : 0;
            yVal = y ? yVal : 0;
        }
        return new CControllerImmutable(axisCount, axisName, axisValue, deadZone, buttonCount, buttonName,
                buttonPressed, index, name, povX, povY, rumblerCount, rumblerName, rxDZ, rxVal, ryDZ, ryVal, rzDZ,
                rzVal, xDZ, xVal, yDZ, yVal, zDZ, zVal, antiCrossRight, antiCrossLeft, autoAntiCrossRight, autoAntiCrossLeft);
    }

    public synchronized void setAntiCrossRight(boolean antiCross) {
        if (autoAntiCrossRight)
            throw new UnsupportedOperationException()
        antiCrossRight = antiCross
    }

    public synchronized void setAntiCrossLeft(boolean antiCross) {
        if (autoAntiCrossLeft)
            throw new UnsupportedOperationException()
        antiCrossLeft = antiCross
    }

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

    public synchronized CController setDeadZone(float zone) {
        setXAxisDeadZone(zone)
        setYAxisDeadZone(zone)
        setZAxisDeadZone(zone)
        setRXAxisDeadZone(zone)
        setRYAxisDeadZone(zone)
        setRZAxisDeadZone(zone)
    }
}
