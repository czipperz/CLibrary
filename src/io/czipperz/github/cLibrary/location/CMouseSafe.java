package io.czipperz.github.cLibrary.location;

import java.awt.*;
import java.awt.geom.Point2D;

/**
 * @author czipperz on 4/8/15.
 */
public class CMouseSafe {
    public static CPoint getLocation() { return new CPoint(MouseInfo.pointerInfo.location); }

    public static int getX() { return location.getX(); }
    public static int getY() { return location.getY(); }

    public static void setLocation(int x, int y) {
        try {
            new Robot().mouseMove(x, y);
        } catch(AWTException e) {
            e.printStackTrace();
        }
    }

    public static void setLocation(double x, double y) { return setLocation((int) x, (int) y); }

    public static void setLocation(Point2D p) { return setLocation(p.getX(), p.getY()); }

    public static void mousePress(int button) {
        try {
            new Robot().mousePress(button);
        } catch(AWTException e) {
            e.printStackTrace();
        }
    }

    public static void mouseRelease(int button) {
        try {
            new Robot().mouseRelease(button);
        } catch(AWTException e) {
            e.printStackTrace();
        }
    }

    public static void mouseClick(int button) {
        mousePress(button);
        mouseRelease(button);
    }

    public static void mouseWheel(int wheelAmt) {
        try {
            new Robot().mouseWheel(wheelAmt);
        } catch(AWTException e) {
            e.printStackTrace();
        }
    }
}
