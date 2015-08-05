package io.czipperz.github.cLibrary.location;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.List;

/**
 * @author czipperz on 4/8/15.
 */
public class CPoint extends Point2D implements Serializable {
    private double x, y;

    public CPoint(double x = 0, double y = 0) {
        this.x = x;
        this.y = y;
    }

    public CPoint(int x, int y) {
        this((double) x, (double) y);
    }

    public CPoint(Point2D p) {
        this(p.x, p.y);
    }

    public List<Integer> getValues() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(x);
        list.add(y);
        return list;
    }

    public CPointImmutable toCPointImmutable() {
        return immutable();
    }

    public CPointImmutable toImmutable() {
        return immutable();
    }

    public CPointImmutable immutable() {
        return new CPointImmutable(x,y);
    }

    public Point toPoint() {
        return new Point(xInt, yInt);
    }

    public void setLocation(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void setLocation(int x, int y) {
        setLocation((double) x, (double) y);
    }

    public void setLocationRel(double x, double y) {
        setLocation(x + this.x, y + this.y);
    }

    public void setLocationRel(int x, int y) {
        setLocation(((double) x) + this.x, ((double) y) + this.y);
    }

    public double getAt(int index) {
        switch(index) {
        case (0):
            return x;
        case (1):
            return y;
        default:
            throw new Exception("Wrong coordinate index, use 0 or 1");
        }
    }

    public void putAt(int index, double d) {
        switch(index) {
        case (0):
            x = d;
            break;
        case (1):
            y = d;
            break;
        default:
            throw new Exception("Wrong coordinate index, use 0 or 1");
        }
    }

    public double getAngle(Point2D target) {
        return Math.atan2(target.y - y, target.x - x);
    }

    public static double getAngle(Point2D center, Point2D target) {
        return Math.atan2(target.y - center.y, target.x - center.x);
    }

    public boolean equals(o) {
        return o instanceof Point2D && x == ((Point2D) o).x && y == ((Point2D) o).y;
    }
}
