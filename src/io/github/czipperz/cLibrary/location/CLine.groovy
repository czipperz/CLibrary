package io.github.czipperz.cLibrary.location

import com.czipperz.cLibrary.exceptions.CEnumTypeNotListedException
import com.czipperz.cLibrary.location.CRect

import java.awt.Graphics
import java.awt.Point
import java.awt.geom.Line2D
import java.awt.geom.Point2D
import java.awt.geom.Rectangle2D
import java.security.InvalidParameterException

/**
 * Created by czipperz on 4/8/15.
 */
class CLine extends Line2D implements Serializable {
	Point start, end
	int width
	EWidthTypes type;

	enum EWidthTypes {
		TYPE_ABOVE,
		TYPE_BELOW,
		TYPE_LEFT,
		TYPE_RIGHT,
	}

	CLine(Point start = new Point(), Point end = new Point()) {
		this.start = start
		this.end = end
	}

	void setWidth(int width) {
		if(width < 1)
			throw new InvalidParameterException("Invalid line width")
		this.width = width;
	}

	void draw(Graphics g) {
		for(int i = 0; i < width; i++) {
			switch(type) {
				case EWidthTypes.TYPE_LEFT:
					g.drawLine(start.x - i, start.y, end.x - i, end.y)
					break
				case EWidthTypes.TYPE_RIGHT:
					g.drawLine(start.x + i, start.y, end.x + i, end.y)
					break
				case EWidthTypes.TYPE_ABOVE:
					g.drawLine(start.x, end.y - i, end.x, end.y - i)
					break
				case EWidthTypes.TYPE_BELOW:
					g.drawLine(start.x, end.x + i, end.x, end.y + i)
					break
				default:
					throw new CEnumTypeNotListedException()
			}
		}
		this
	}

	Rectangle2D getBounds2D() {
		new CRect(start, end);
	}

	Point2D getP1() {
		start;
	}

	Point2D getP2() {
		end;
	}

	double X1 = start.&x
	double X2 = end.&x
	double Y1 = start.&y
	double Y2 = end.&y

	void setLine(double x1, double y1, double x2, double y2) {
		start.x = (int) x1;
		start.y = (int) y1;
		end.x = (int) x2;
		end.y = (int) y2;
	}
}
