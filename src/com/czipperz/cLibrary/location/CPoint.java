package com.czipperz.cLibrary.location;

import java.awt.Point;
import java.awt.geom.Point2D;
import java.io.Serializable;

/**
 * A class used as an alternative to Point.  It utilizes doubles instead of integers to store data.
 * @see java.awt.Point
 * @author Chris Gregory
 */
public class CPoint extends Point2D implements Serializable {
	private static final long serialVersionUID = -3999099452993279385L;
	private double x;
	private double y;

	/**
	 * Creates a new CPoint at location (0, 0) - the default.
	 * @author Chris Gregory
	 */
	public CPoint() {
		this(0, 0);
	}

	/**
	 * Creates a new CPoint at location (x, y).
	 * @param x - the x location of this CPoint
	 * @param y - the y location of this CPoint
	 * @author Chris Gregory
	 */
	public CPoint(double x, double y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Creates a new CPoint at location (x, y).
	 * @param x - the x location of this CPoint
	 * @param y - the y location of this CPoint
	 * @author Chris Gregory
	 */
	public CPoint(int x, int y) {
		this((double) x, (double) y);
	}

	/**
	 * Creates a new CPoint at location p.
	 * @param p - the location of this CPoint
	 * @author Chris Gregory
	 */
	public CPoint(Point2D p) {
		this(p.getX(), p.getY());
	}

	/**
	 * Returns the x location of the CPoint.
	 * @return x - the x location of the CPoint
	 * @author Chris Gregory
	 */
	public double getX() {
		return x;
	}

	/**
	 * Returns the x location of the CPoint as an integer.
	 * @return x - the x location of the CPoint as an integer
	 * @author Chris Gregory
	 */
	public int getXInt() {
		return (int) x;
	}

	/**
	 * Returns the y location of the CPoint.
	 * @return y - the y location of the CPoint
	 * @author Chris Gregory
	 */
	public double getY() {
		return y;
	}

	/**
	 * Returns the y location of the CPoint as an integer.
	 * @return y - the y location of the CPoint as an integer
	 * @author Chris Gregory
	 */
	public int getYInt() {
		return (int) y;
	}

	/**
	 * Returns an instance of Point representing the CPoint.
	 * @return a Point representing the CPoint
	 * @author Chris Gregory
	 */
	public Point toPoint() {
		return new Point((int) x, (int) y);
	}

	/**
	 * Sets the CPoint's x location to the parameter x.
	 * @param x - the new x
	 * @return this instance of CPoint - used for chain calling
	 * @author Chris Gregory
	 */
	public CPoint setX(double x) {
		setLocation(x, getY());
		return this;
	}

	/**
	 * Sets the CPoint's x location to the parameter x.
	 * @param x - the new x
	 * @return this instance of CPoint - used for chain calling
	 * @author Chris Gregory
	 */
	public CPoint setX(int x) {
		return setX((double) x);
	}

	/**
	 * Moves the CPoint's x location relative to the parameters x.
	 * @param x - distance to be added to the current x
	 * @return this instance of CPoint - used for chain calling
	 * @author Chris Gregory
	 */
	public CPoint setXRel(double x) {
		setX(x + getX());
		return this;
	}

	/**
	 * Moves the CPoint's x location relative to the parameters x.
	 * @param x - distance to be added to the current x
	 * @return this instance of CPoint - used for chain calling
	 * @author Chris Gregory
	 */
	public CPoint setXRel(int x) {
		return setXRel((double) x);
	}

	/**
	 * Sets the CPoint's y location to the parameter y.
	 * @param y - the new y
	 * @return this instance of CPoint - used for chain calling
	 * @author Chris Gregory
	 */
	public CPoint setY(double y) {
		setLocation(getX(), y);
		return this;
	}

	/**
	 * Sets the CPoint's y location to the parameter y.
	 * @param y - the new y
	 * @return this instance of CPoint - used for chain calling
	 * @author Chris Gregory
	 */
	public CPoint setY(int y) {
		return setY((double) y);
	}

	/**
	 * Moves the CPoint's y location relative to the parameters y.
	 * @param y - distance to be added to the current y
	 * @return this instance of CPoint - used for chain calling
	 * @author Chris Gregory
	 */
	public CPoint setYRel(double y) {
		setY(y + getY());
		return this;
	}

	/**
	 * Moves the CPoint's y location relative to the parameters y.
	 * @param y - distance to be added to the current y
	 * @return this instance of CPoint - used for chain calling
	 * @author Chris Gregory
	 */
	public CPoint setYRel(int y) {
		return setYRel((double) y);
	}

	/**
	 * Sets the CPoint's location to the parameters x and y.  Call this to avoid recursion.
	 * @param setX - the new x
	 * @param setY - the new y
	 * @author Chris Gregory
	 */
	public void setLocation(double setX, double setY) {
		x = setX;
		y = setY;
	}

	/**
	 * Sets the CPoint's location to the parameters x and y.
	 * @param setX - the new x
	 * @param setY - the new y
	 * @author Chris Gregory
	 */
	public CPoint setLocation(int setX, int setY) {
		setLocation((double) setX, (double) setY);
		return this;
	}

	/**
	 * Moves the CPoint's location relative to the parameters x and y.
	 * @param setX - distance to be added to the current x
	 * @param setY - distance to be added to the current y
	 * @author Chris Gregory
	 */
	public CPoint setLocationRel(double setX, double setY) {
		setLocation(setX + getX(), setY + getY());
		return this;
	}

	/**
	 * Moves the CPoint's location relative to the parameters x and y.
	 * @param setX - distance to be added to the current x
	 * @param setY - distance to be added to the current y
	 * @author Chris Gregory
	 */
	public CPoint setLocationRel(int setX, int setY) {
		setLocationRel((double) setX, (double) setY);
		return this;
	}

	/**
	 * Sets the location of the CPoint to that of the Point2D p.
	 * @param p - the new location of the CPoint.
	 * @author Chris Gregory
	 */
	public void setLocation(Point2D p) {
		setLocation(p.getX(), p.getY());
	}

	public String toString() {
		return "(" + getX() + ", " + getY() + ")";
	}

	public boolean equals(Object o) {
		return o instanceof CPoint && this.x == ((Point2D) o).getX() && this.y == ((Point2D) o).getY();
	}
	
	/**
	 * Returns the clockwise angle from the north of the CPoint (the center) of the line between the CPoint and the target.
	 * @param target
	 * @return the angle in radians
	 */
	public double getAngleRadians(Point2D target) {
		double angle = Math.atan2(target.getY() - y, target.getX() - x);
		angle += Math.toRadians(90);
		
		while(angle < Math.toRadians(0)) {
			angle += Math.toRadians(360);
		}
		
		return angle;
	}
	
	/**
	 * Returns the clockwise angle from the north of the CPoint (the center) of the line between the CPoint and the target.
	 * @param target
	 * @return the angle in degrees
	 */
	public double getAngleDegrees(Point2D target) {
		double angle = Math.atan2(target.getY() - y, target.getX() - x);
		angle += 90;
		
		while(angle < 0) {
			angle += 360;
		}
		
		return angle;
	}
	
	/**
	 * Returns the clockwise angle from the north of the center and of the line between the center and the target.
	 * @param center
	 * @param target
	 * @return the angle in radians
	 */
	public static double getAngleRadians(Point2D center, Point2D target) {
		double angle = Math.atan2(target.getY() - center.getY(), target.getX() - center.getX());
		angle += Math.toRadians(90.0);
		
		while(angle < Math.toRadians(0)) {
			angle += Math.toRadians(360);
		}
		
		return angle;
	}
	
	/**
	 * Returns the clockwise angle from the north of the center and of the line between the center and the target.
	 * @param center
	 * @param target
	 * @return the angle in degrees
	 */
	public static double getAngleDegrees(Point2D center, Point2D target) {
		double angle = Math.toDegrees(Math.atan2(target.getY() - center.getY(), target.getX() - center.getX()));
		angle += 90.0;
		
		while(angle < 0) {
			angle += 360;
		}
		
		return angle;
	}
}