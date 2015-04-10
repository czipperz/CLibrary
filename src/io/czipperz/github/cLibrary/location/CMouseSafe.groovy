package io.czipperz.github.cLibrary.location

import java.awt.*
import java.awt.geom.Point2D

/**
 * Created by czipperz on 4/8/15.
 */
class CMouseSafe {
	static CPoint getLocation() {
		return new CPoint(MouseInfo.pointerInfo.location)
	}

	static int getX() {
		location.getX()
	}

	static int getY() {
		location.getY()
	}

	static void setLocation(int x, int y) {
		try {
			new Robot().mouseMove(x, y)
		} catch(AWTException e) {
			e.printStackTrace()
		}
	}

	static void setLocation(double x, double y) {
		setLocation((int) x, (int) y)
	}

	static void setLocation(Point2D p) {
		setLocation(p.getX(), p.getY())
	}

	static void mousePress(int button) {
		try {
			new Robot().mousePress(button);
		} catch(AWTException e) {
			e.printStackTrace()
		}
	}

	static void mouseRelease(int button) {
		try {
			new Robot().mouseRelease(button)
		} catch(AWTException e) {
			e.printStackTrace()
		}
	}

	static void mouseClick(int button) {
		mousePress(button)
		mouseRelease(button)
	}

	static void mouseWheel(int wheelAmt) {
		try {
			new Robot().mouseWheel(wheelAmt)
		} catch(AWTException e) {
			e.printStackTrace()
		}
	}
}
