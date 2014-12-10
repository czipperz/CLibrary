package com.czipperz.cLibrary.location;

import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Robot;
import java.awt.geom.Point2D;

/**
 * A class that wraps all mouse events.  <strong>NOTE:</strong> methods may throw <code>AWTException</code>.
 * @author Chris Gregory
 * @see java.awt.Robot
 * @see java.awt.AWTException
 * @see java.awt.MouseInfo
 * @see com.czipperz.cLibrary.location.CMouseSafe
 * @see CMouse
 */
public abstract class CMouseUnsafe {
	public static CPoint getLocation() {
		return new CPoint(MouseInfo.getPointerInfo().getLocation());
	}
	
	public static int getX() {
		return MouseInfo.getPointerInfo().getLocation().x;
	}
	
	public static int getY() {
		return MouseInfo.getPointerInfo().getLocation().y;
	}
	
	public static void setLocation(int x, int y) throws AWTException {
		new Robot().mouseMove(x, y);
	}
	
	public static void setLocation(double x, double y) throws AWTException {
		setLocation((int) x, (int) y);
	}
	
	public static void setLocation(Point2D p) throws AWTException {
		setLocation(p.getX(), p.getY());
	}
	
	public static void mousePress(int buttons) throws AWTException {
		new Robot().mousePress(buttons);
	}
	
	public static void mouseRelease(int buttons) throws AWTException {
		new Robot().mouseRelease(buttons);
	}
	
	public static void mouseClick(int buttons) throws AWTException {
		mousePress(buttons);
		mouseRelease(buttons);
	}
	
	public static void mouseWheel(int wheelAmt) throws AWTException {
		new Robot().mouseWheel(wheelAmt);
	}
}
