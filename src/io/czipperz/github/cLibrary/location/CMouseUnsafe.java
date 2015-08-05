package io.czipperz.github.cLibrary.location;

import java.awt.*;
import java.awt.geom.Point2D;

/**
 * @author czipperz on 4/8/15.
 */
public class CMouseUnsafe {
    public static CPoint getLocation() {
        return new CPoint(MouseInfo.pointerInfo.location);
    }

    public static int getX() {
        return location.getX();
    }
    public static int getY() {
        return location.getY();
    }

    public static void setLocation(int x, int y) {
        new Robot().mouseMove(x, y);
    }

    public static void setLocation(double x, double y) {
        setLocation((int) x, (int) y);
    }

    public static void setLocation(Point2D p) {
        setLocation(p.x, p.y);
    }

    public static void mousePress(int button) {
        new Robot().mousePress(button);
    }

    public static void mouseRelease(int button) {
        new Robot().mouseRelease(button);
    }

    public static void mouseClick(int button) {
        mousePress(button);
        mouseRelease(button);
    }

    public static void mouseWheel(int wheelAmt) {
        new Robot().mouseWheel(wheelAmt);
    }
}
