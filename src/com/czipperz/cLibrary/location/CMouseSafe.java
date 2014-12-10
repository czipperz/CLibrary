package com.czipperz.cLibrary.location;

import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Robot;
import java.awt.geom.Point2D;

/**
 * A class that wraps the methods of <code>CMouseUnsafe</code> that were "unsafe".  <strong>NOTE: <u>ALL</strong> <code>AWTException</code>s</u> normally thrown have called upon them <code>e.printStackTrace()</code> instead.
 * @author Chris Gregory
 * @see java.awt.Robot
 * @see java.awt.MouseInfo
 * @see CMouseUnsafe
 * @see com.czipperz.cLibrary.game.CMouse
 */
public abstract class CMouseSafe extends CMouseUnsafe {
	public static void setLocation(int x, int y) {
		try {
			new Robot().mouseMove(x, y);
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}

	public static void setLocation(double x, double y) {
		setLocation((int) x, (int) y);
	}

	public static void setLocation(Point2D p) {
		setLocation(p.getX(), p.getY());
	}

	public static void mousePress(int buttons) {
		try {
			new Robot().mousePress(buttons);
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}

	public static void mouseRelease(int buttons) {
		try {
			new Robot().mouseRelease(buttons);
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}

	public static void mouseClick(int buttons) {
		mousePress(buttons);
		mouseRelease(buttons);
	}

	public static void mouseWheel(int wheelAmt) {
		try {
			new Robot().mouseWheel(wheelAmt);
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}
}
