package com.czipperz.cLibrary.frc;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;

/**
 * Created by Chris on 2/16/2015.
 */
public class Controller {
    private Joystick j;

    public Controller(Joystick j) {
        this.j = j;
    }

    public double getLX() {
        return this.j.getRawAxis(0);
    }

    public double getRX() {
        return this.j.getRawAxis(4);
    }

    public double getLY() {
        return -this.j.getRawAxis(1);
    }

    public double getRY() {
        return -this.j.getRawAxis(5);
    }

    public double getTriggers() {
        return j.getRawAxis(2) + j.getRawAxis(3);
    }

    public double getTriggerLeft() {
        return j.getRawAxis(2);
    }

    public double getTriggerRight() {
        return j.getRawAxis(3);
    }

    public Joystick getJoystick() {
        return j;
    }

    public boolean leftBumper() {
        return j.getBumper(GenericHID.Hand.kLeft);
    }

    public boolean rightBumper() {
        return j.getBumper(GenericHID.Hand.kRight);
    }

    public double getZ() {
        return j.getZ();
    }

    public double getZLeft() {
        return j.getZ(GenericHID.Hand.kLeft);
    }

    public double getZRight() {
        return j.getZ(GenericHID.Hand.kRight);
    }
}
