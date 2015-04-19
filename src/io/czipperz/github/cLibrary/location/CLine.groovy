package io.czipperz.github.cLibrary.location

import io.czipperz.github.cLibrary.exceptions.CEnumTypeNotListedException
import io.czipperz.github.cLibrary.game.CDrawAble

import java.awt.*
import java.awt.geom.Line2D
import java.awt.geom.Point2D
import java.awt.geom.Rectangle2D
import java.security.InvalidParameterException

/**
* @author czipperz on 4/8/15.
*/
class CLine extends Line2D implements Serializable, CDrawAble {
	Point P1, P2
	int width
	EWidthTypes type;

	enum EWidthTypes {
		TYPE_ABOVE,
		TYPE_BELOW,
		TYPE_LEFT,
		TYPE_RIGHT,
	}

	CLine(Point P1 = new Point(), Point P2 = new Point()) {
		this.P1 = P1
		this.P2 = P2
	}

	void setWidth(int width) {
		if(width < 1)
			throw new InvalidParameterException("Invalid line width")
		this.width = width;
	}

	CDrawAble draw(Graphics g) {
		for(int i = 0; i < width; i++) {
			switch(type) {
				case EWidthTypes.TYPE_LEFT:
					g.drawLine(P1.x - i, (int) P1.y, P2.x - i, (int) P2.y)
					break
				case EWidthTypes.TYPE_RIGHT:
					g.drawLine(P1.x + i, (int) P1.y, P2.x + i, (int) P2.y)
					break
				case EWidthTypes.TYPE_ABOVE:
					g.drawLine((int) P1.x, P2.y - i, (int) P2.x, P2.y - i)
					break
				case EWidthTypes.TYPE_BELOW:
					g.drawLine((int) P1.x, P2.x + i, (int) P2.x, P2.y + i)
					break
				default:
					throw new CEnumTypeNotListedException()
			}
		}
		this
	}

	boolean needUpdate() {
		return false
	}

	CDrawAble tick() {
		this
	}

	Rectangle2D getBounds2D() {
		new CRect(P1, P2);
	}

	Point2D getP1() {
		P1;
	}

	double getX1() {
		return P1.x
	}

	double getY1() {
		return P1.y
	}

	double getX2() {
		return P2.x
	}

	double getY2() {
		return P2.y
	}

	Point2D getP2() {
		P2;
	}

	void setLine(double x1, double y1, double x2, double y2) {
		P1.x = (int) x1;
		P1.y = (int) y1;
		P2.x = (int) x2;
		P2.y = (int) y2;
	}
}
