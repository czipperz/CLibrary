package io.github.czipperz.cLibrary.location

import java.awt.Point
import java.awt.geom.Point2D

/**
 * Created by czipperz on 4/8/15.
 */
class CPoint extends Point2D implements Serializable {
	double x, y

	public CPoint(double x = 0, double y = 0) {
		this.x = x
		this.y = y
	}

	CPoint(int x, int y) {
		this((double) x, (double) y)
	}

	CPoint(Point2D p) {
		this(p.x, p.y)
	}

	List<Integer> getValues() {
		def list = new ArrayList<Integer>()
		list.add x
		list.add y
		list
	}

	CPointImmutable toCPointImmutable() {
		immutable()
	}

	CPointImmutable toImmutable() {
		immutable()
	}

	CPointImmutable immutable() {
		new CPointImmutable(x,y)
	}

	Point toPoint() {
		new Point(xInt, yInt)
	}

	void setLocation(double x, double y) {
		this.x = x
		this.y = y
	}

	void setLocation(int x, int y) {
		setLocation((double) x, (double) y)
	}

	void setLocationRel(double x, double y) {
		setLocation(x + this.x, y + this.y)
	}

	void setLocationRel(int x, int y) {
		setLocation(((double) x) + this.x, ((double) y) + this.y)
	}

	double getAt(int index) {
		switch(index) {
			case (0):
				return x
			case (1):
				return y
			default:
				throw new Exception("Wrong coordinate index, use 0 or 1")
		}
	}

	void putAt(int index, double d) {
		switch(index) {
			case (0):
				x = d; break
			case (1):
				y = d; break
			default:
				throw new Exception("Wrong coordinate index, use 0 or 1")
		}
	}

	double getAngle(Point2D target) {
		Math.atan2(target.y - y, target.x - x)
	}

	static double getAngle(Point2D center, Point2D target) {
		Math.atan2(target.y - center.y, target.x - center.x)
	}

	boolean equals(o) {
		o instanceof Point2D && x == ((Point2D) o).x && y == ((Point2D) o).y
	}
}
