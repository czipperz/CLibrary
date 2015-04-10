package io.github.czipperz.cLibrary.location

import java.awt.MouseInfo
import java.awt.Robot
import java.awt.geom.Point2D

/**
 * Created by czipperz on 4/8/15.
 */
class CMouseUnsafe {
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
		new Robot().mouseMove(x, y)
	}

	static Closure setLocation(double x, double y) {
		setLocation((int) x, (int) y)
	}

	static void setLocation(Point2D p) {
		setLocation(p.x, p.y)
	}

	static void mousePress(int button) {
		new Robot().mousePress(button)
	}

	static void mouseRelease(int button) {
		new Robot().mouseRelease(button)
	}

	static void mouseClick(int button) {
		mousePress(button)
		mouseRelease(button)
	}

	static void mouseWheel(int wheelAmt) {
		new Robot().mouseWheel(wheelAmt)
	}
}
