package com.czipperz.cLibrary.location;

import java.awt.*;
import java.awt.geom.Dimension2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.RenderedImage;
import java.io.Serializable;

public class CRect extends Rectangle implements Serializable {
	public int speed;

	public CRect(RenderedImage image) {
		super(image.getWidth(), image.getHeight());
	}

	public CRect(Point2D point, Dimension2D size) {
		super((int) point.getX(), (int) point.getY(), (int) size.getWidth(), (int) size.getHeight());
	}

	public CRect(double x, double y, Dimension2D size) {
		this(x, y, size.getWidth(), size.getHeight());
	}

	public CRect(Point2D point, double width, double height) {
		this(point.getX(), point.getY(), width, height);
	}

	public CRect(Dimension2D size) {
		this(size.getWidth(), size.getHeight());
	}

	public CRect(double x, double y, double width, double height) {
		this((int) x, (int) y, (int) width, (int) height);
	}

	public CRect(Rectangle2D rect) {
		super((int) rect.getX(), (int) rect.getY(), (int) rect.getWidth(), (int) rect.getHeight());
	}

	public CRect(Point2D start, Point2D end) {
		this(start.getX(), start.getY(), end.getX() - start.getX(), end.getY() - start.getY());
	}

	public CRect(Point2D start, int width, int height) {
		super((int) start.getX(), (int) start.getY(), width, height);
	}

	public CRect(int width, int height) {
		super(width, height);
	}

	public CRect(int x, int y, int width, int height) {
		super(x, y, width, height);
	}

	public CRect(double width, double height) {
		this((int) width, (int) height);
	}

	public CRect() {
		super();
	}

	public Point toPoint() {
		return new Point(x, y);
	}

	public CPoint toCPoint() {
		return new CPoint(x, y);
	}

	public String toString() {
		return "(" + x + ", " + y + ") to (" + (x + width) + ", " + (y + height) + ")";
	}

	public boolean isInside(Point2D point) {
		return isInside(this, point);
	}

	public static boolean isInside(CRect rect, Point2D point) {
		return rect.x < point.getX() && rect.y < point.getY() && (rect.x + rect.width) > point.getX() && (rect.y + rect.height) > point.getY();
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public CRect moveUp() {
		y -= speed;
		return this;
	}

	public CRect moveDown() {
		y += speed;
		return this;
	}

	public CRect moveLeft() {
		x -= speed;
		return this;
	}

	public CRect moveRight() {
		x += speed;
		return this;
	}

	public CRect moveUp(int speed) {
		y -= speed;
		return this;
	}

	public CRect moveDown(int speed) {
		y += speed;
		return this;
	}

	public CRect moveLeft(int speed) {
		x -= speed;
		return this;
	}

	public CRect moveRight(int speed) {
		x += speed;
		return this;
	}

	public Rectangle toRectangle() {
		return this;
	}

	public static double getShortestDistance(Rectangle2D first, Rectangle2D second) {
		while(true) {
			if(first.getX() > second.getX() + second.getWidth() || first.getY() > second.getY() + second.getHeight()) {
				break;
			}
			if(first.getX() > second.getX() && first.getX() < second.getX() + second.getWidth()) {
				if(first.getY() < second.getY() && first.getY() + first.getHeight() > second.getY()) {
					return 0.0;
				}
				if(first.getY() > second.getY() && first.getY() < second.getY() + second.getHeight()) {
					return 0.0;
				}
				break;
			}
			if(first.getX() < second.getX()) {
				if(first.getX() + first.getWidth() > second.getX()) {
					if(first.getY() > second.getY() && first.getY() < second.getY() + second.getHeight()) {
						return 0.0;
					}
					if(first.getY() < second.getY() && first.getY() + first.getHeight() > second.getY()) {
						return 0.0;
					}
				}
				break;
			}
			break;
		}
		double[] fx = new double[] {first.getX(), first.getX() + first.getWidth()};
		double[] fy = new double[] {first.getY(), first.getY() + first.getHeight()};
		double[] sx = new double[] {second.getX(), second.getX() + second.getWidth()};
		double[] sy = new double[] {second.getY(), second.getY() + second.getHeight()};

		double result = java.lang.Double.MAX_VALUE;
		for(double q : fx) {
			for(double w : fy) {
				for(double e : sx) {
					for(double r : sy) {
						double a = Point2D.distance(q, w, e, r);
						if(a < result) {
							result = a;
						}
					}
				}
			}
		}
		return result;
	}
	
	public static boolean totallyContains(Rectangle outer, Rectangle inner) {
		return outer.x <= inner.x && outer.x + outer.width >= inner.x + inner.width && outer.y <= inner.y && outer.y + outer.height >= inner.y + inner.height;
	}
	
	public static boolean somePartContains(Rectangle one, Rectangle two) {
		boolean x = false, y = false;
		
		if(one.x > two.x)
			if(one.x <= two.x + two.width)
				x = true;
		else
			if(one.x + one.width >= two.x)
				x = true;

		if(one.y > two.y)
			if(one.y <= two.y + two.height)
				y = true;
		else
			if(one.y + one.height >= two.y)
				y = true;
		
		return x && y;
	}
	
	public static boolean noPartContains(Rectangle one, Rectangle two) {
		return !somePartContains(one, two);
	}
}
