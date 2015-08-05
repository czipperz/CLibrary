package io.czipperz.github.cLibrary.location;

import java.awt.*;
import java.awt.geom.Dimension2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.RenderedImage;
import java.util.List;

/**
 * @author czipperz on 4/8/15.
 */
public class CRect extends Rectangle2D implements Serializable {
    private double x, y, width, height;

    public CRect(double x = 0, double y = 0, double width, double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    public CRect(RenderedImage image)                        { this(image.width, image.height);                          }
    public CRect(Point2D point, Dimension2D size)            { this(point.x, point.y, size.width, size.height);          }
    public CRect(double x, double y, Dimension2D size)       { this(x, y, size.width, size.height);                      }
    public CRect(Point2D point, double width, double height) { this(point.x, point.y, width, height);                    }
    public CRect(Point2D start, Point2D end)                 { this(start.x, start.y, end.x - start.x, end.y - start.x); }
    public CRect(Rectangle2D rect)                           { this(rect.x,rect.y,rect.width,rect.height);               }
    public CRect()                                           { this(0,0,0,0);                                            }



    public List<Integer> getValues() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add x;
        list.add y;
        list.add width;
        list.add height;
        return list;
    }

    public CPoint toCPoint() { return new CPoint(x, y); }

    public Point toPoint() { return new Point((int)x, (int)y); }

    public Rectangle toRectangle() { return new Rectangle((int)width, (int)height); }

    public CRectImmutable toCRectImmutable() { return immutable(); }
    public CRectImmutable toImmutable() { return immutable(); }

    public CRectImmutable immutable() { return new CRectImmutable(x,y,width,height); }

    public void setRect(double v, double v1, double v2, double v3) {
        x = v;
        y = v1;
        width = v2;
        height = v3;
    }

    public int outcode(double var1, double var3) {
        int var5 = 0;
        if(this.width <= 0) {
            var5 |= 5;
        } else if(var1 < (double)this.x) {
            var5 |= 1;
        } else if(var1 > (double)this.x + (double)this.width) {
            var5 |= 4;
        }

        if(height <= 0) {
            var5 |= 10;
        } else if(var3 < (double)this.y) {
            var5 |= 2;
        } else if(var3 > (double)this.y + (double)this.height) {
            var5 |= 8;
        }

        return var5;
    }

    public Rectangle2D createIntersection(Rectangle2D rectangle2D) {
        Double d = new Double();
        intersect(this, rectangle2D, d);
        return d;
    }

    public Rectangle2D createUnion(Rectangle2D rectangle2D) {
        Double d = new Double();
        union(this, rectangle2D, d);
        return d;
    }

    public boolean isEmpty() { return width <= 0 || height <= 0; }

    public boolean equals(Object other) {
        if(other instanceof Rectangle2D) {
            boolean a = true;
            if(other instanceof CRect) {
                a = other.speed == speed;
            }
            return a && other.x == x && other.y == y && other.width == width && other.height == height;
        }
        return false;
    }

    public String toString() { return getClass().name+" [x="+x+", y="+y+", width="+width+", height="+height+"], speed="+speed; }

    public static double getShortestDistance(Rectangle2D first, Rectangle2D second) {
        while(true) {
            if(first.x > second.x + second.width || first.y > second.y + second.height) { break; }
            if(first.x > second.x && first.x < second.x + second.width) {
                if(first.y < second.y && first.y + first.height > second.y) { return 0.0; }
                if(first.y > second.y && first.y < second.y + second.height) { return 0.0; }
                break;
            }
            if(first.x < second.x) {
                if(first.x + first.width > second.x) {
                    if(first.y > second.y && first.y < second.y + second.height) { return 0.0; }
                    if(first.y < second.y && first.y + first.height > second.y) { return 0.0; }
                }
                break;
            }
            break;
        }
        double[] fx = [first.x, first.x + first.width]
            , fy = [first.y, first.y + first.height]
            , sx = [second.x, second.x + second.width]
            , sy = [second.y, second.y + second.height];

        double result = Double.MAX_VALUE;
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
        return outer.x <= inner.x
            && outer.x + outer.width >= inner.x + inner.width
            && outer.y <= inner.y
            && outer.y + outer.height >= inner.y + inner.height;
    }

    public static boolean somePartContains(Rectangle one, Rectangle two) {
        return one.x > two.x
            && (one.x <= two.x + two.width  || one.x + one.width  >= two.x)
            && one.y > two.y
            && (one.y <= two.y + two.height || one.y + one.height >= two.y);
    }

    public static boolean noPartContains(Rectangle one, Rectangle two) {
        return !somePartContains(one, two);
    }
}
