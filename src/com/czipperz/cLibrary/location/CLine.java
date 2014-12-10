package com.czipperz.cLibrary.location;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.Serializable;
import java.security.InvalidParameterException;

import com.czipperz.cLibrary.exceptions.CEnumTypeNotListedException;

public class CLine extends Line2D implements Serializable {
	private static final long serialVersionUID = 4562728086780386239L;
	private Point start, end;
	private int width;
	private EWidthTypes type;
	
	public enum EWidthTypes {
		/**
		 * Graphs above the line.
		 */
		TYPE_ABOVE,
		/**
		 * Graphs below the line.
		 */
		TYPE_BELOW,
		/**
		 * Graphs to the left of the line.
		 */
		TYPE_LEFT,
		/**
		 * Graphs to the right of the line.
		 */
		TYPE_RIGHT
	}

	public CLine() {
		this(new Point(), new Point());
	}
	
	public CLine(Point start, Point end) {
		this.start = start;
		this.end = end;
	}
	
	public Point getStart() {
		return start;
	}

	public CLine setStart(Point start) {
		this.start = start;
		return this;
	}

	public Point getEnd() {
		return end;
	}

	public CLine setEnd(Point end) {
		this.end = end;
		return this;
	}
	
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		if(width < 1) {
			throw new InvalidParameterException("Invalid line width");
		}
		this.width = width;
	}

	public EWidthTypes getType() {
		return type;
	}

	public void setType(EWidthTypes type) {
		this.type = type;
	}

	public CLine draw(Graphics g) {
		EWidthTypes t = this.type;
		Point s = this.start;
		Point e = this.end;
		for(int i = 0; i < width; i++) {
			if(t == EWidthTypes.TYPE_LEFT) {
				g.drawLine(s.x - i, s.y, e.x - i, e.y);
			}
			else if(t == EWidthTypes.TYPE_RIGHT) {
				g.drawLine(s.x + i, s.y, e.x + i, e.y);
			}
			else if(t == EWidthTypes.TYPE_ABOVE) {
				g.drawLine(s.x, e.y - i, e.x, e.y - i);
			}
			else if(t == EWidthTypes.TYPE_BELOW) {
				g.drawLine(s.x, e.x + i, e.x, e.y + i);
			}
			else {
				throw new CEnumTypeNotListedException();
			}
		}
		return this;
	}

	public Rectangle2D getBounds2D() {
		return new CRect(start, end);
	}

	public Point2D getP1() {
		return start;
	}

	public Point2D getP2() {
		return end;
	}

	public double getX1() {
		return start.x;
	}

	public double getX2() {
		return end.y;
	}

	public double getY1() {
		return start.y;
	}

	public double getY2() {
		return end.y;
	}

	public void setLine(double x1, double y1, double x2, double y2) {
		start.x = (int) x1;
		start.y = (int) y1;
		end.x = (int) x2;
		end.y = (int) y2;
	}
}
