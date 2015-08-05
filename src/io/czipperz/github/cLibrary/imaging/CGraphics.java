package io.czipperz.github.cLibrary.imaging;

import io.czipperz.github.cLibrary.location.CRect;

import java.awt.*;
import java.awt.geom.Dimension2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;

/**
 * @author czipperz on 4/8/15.
 */
public class CGraphics {
    private Graphics g;

    public CGraphics(Graphics g) {
        this.g = g;
    }

    public CGraphics clearRect(int x, int y, int width, int height) {
        g.clearRect(x,y,width,height);
        return this;
    }

    public CGraphics clearRect(Point2D p, Dimension2D d) { return clearRect(new CRect(p,d)); }

    public CGraphics clearRect(int x, int y, Dimension2D dim) { return clearRect(x,y,dim.width,dim.height); }

    public CGraphics clearRect(Point2D p, int width, int height) { return clearRect(p.x,p.y,width,height); }

    public CGraphics clearRect(Rectangle2D rect) { return clearRect(rect.x,rect.y,rect.width,rect.height); }

    public CGraphics clearRect(double x, double y, double width, double height) { return clearRect((int)x,(int)y,(int)width,(int)height); }




    public CGraphics clipRect(int x, int y, int width, int height) {
        g.clipRect(x,y,width,height);
        return this;
    }

    public CGraphics clipRect(Point2D p, Dimension2D d) { return clipRect(new CRect(p,d)); }

    public CGraphics clipRect(int x, int y, Dimension2D dim) { return clipRect(x,y,dim.width,dim.height); }

    public CGraphics clipRect(Point2D p, int width, int height) { return clipRect(p.x,p.y,width,height); }

    public CGraphics clipRect(Rectangle2D rect) { return clipRect(rect.x,rect.y,rect.width,rect.height); }

    public CGraphics clipRect(double x, double y, double width, double height) { return clipRect((int)x,(int)y,(int)width,(int)height); }




    public CGraphics copyArea(int v1, int v2, int v3, int v4, int v5, int v6) {
        g.copyArea(v1,v2,v3,v4,v5,v6);
        return this;
    }



    public Graphics create() { return g.create(); }

    public Graphics create(int x, int y, int width, int height) { return g.create(x,y,width,height); }

    public Graphics create(Point2D p, Dimension2D d) { return create(new CRect(p,d)); }

    public Graphics create(int x, int y, Dimension2D dim) { return create(x,y,dim.width,dim.height); }

    public Graphics create(Point2D p, int width, int height) { return create(p.x,p.y,width,height); }

    public Graphics create(Rectangle2D rect) { return create(rect.x,rect.y,rect.width,rect.height); }

    public Graphics create(double x, double y, double width, double height) { return create((int)x,(int)y,(int)width,(int)height); }



    public CGraphics dispose() {
        g.dispose();
        return this;
    }

    public CGraphics draw3DRect(int arg0, int arg1, int arg2, int arg3, boolean arg4) {
        g.draw3DRect(arg0, arg1, arg2, arg3, arg4);
        return this;
    }

    public CGraphics drawArc(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5) {
        g.drawArc(arg0, arg1, arg2, arg3, arg4, arg5);
        return this;
    }

    public CGraphics drawBytes(byte[] arg0, int arg1, int arg2, int arg3, int arg4) {
        g.drawBytes(arg0, arg1, arg2, arg3, arg4);
        return this;
    }

    public CGraphics drawChars(char[] arg0, int arg1, int arg2, int arg3, int arg4) {
        g.drawChars(arg0, arg1, arg2, arg3, arg4);
        return this;
    }



    public CGraphics drawImage(Image arg0, Rectangle locScreen, Rectangle locImage, ImageObserver arg4) {
        g.drawImage(arg0, locScreen.@x, locScreen.@y, locScreen.@x + locScreen.@width, locScreen.@y + locScreen.@height,
                    locImage.@x, locImage.@y, locImage.@x + locImage.@width, locImage.@y + locImage.@height, arg4);
        return this;
    }

    public CGraphics drawImage(Image arg0, int arg1, int arg2, Color arg3, ImageObserver arg4) {
        g.drawImage(arg0, arg1, arg2, arg3, arg4);
        return this;
    }

    public CGraphics drawImage(Image arg0, int arg1, int arg2, ImageObserver arg3) {
        g.drawImage(arg0, arg1, arg2, arg3);
        return this;
    }

    public CGraphics drawImage(Image arg0, int arg1, int arg2, int arg3,
                        int arg4, Color arg5, ImageObserver arg6) {
        g.drawImage(arg0, arg1, arg2, arg3, arg4, arg5, arg6);
        return this;
    }

    public CGraphics drawImage(Image arg0, int arg1, int arg2, int arg3,
                        int arg4, ImageObserver arg5) {
        g.drawImage(arg0, arg1, arg2, arg3, arg4, arg5);
        return this;
    }

    public CGraphics drawImage(Image image, Rectangle locScreen, ImageObserver object) {
        return drawImage(image, locScreen.@x, locScreen.@y, locScreen.@width, locScreen.@height, object);
    }

    public CGraphics drawImage(Image arg0, int arg1, int arg2, int arg3,
                        int arg4, int arg5, int arg6, int arg7, int arg8, Color arg9,
                        ImageObserver arg10) {
        g.drawImage(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9,arg10);
        return this;
    }

    public CGraphics drawImage(Image arg0, int arg1, int arg2, int arg3,
                        int arg4, int arg5, int arg6, int arg7, int arg8, ImageObserver arg9) {
        g.drawImage(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9);
        return this;
    }



    public CGraphics drawLine(int arg0, int arg1, int arg2, int arg3) {
        g.drawLine(arg0, arg1, arg2, arg3);
        return this;
    }

    public CGraphics drawOval(int arg0, int arg1, int arg2, int arg3) {
        g.drawOval(arg0, arg1, arg2, arg3);
        return this;
    }

    public CGraphics drawPolygon(int[] arg0, int[] arg1, int arg2) {
        g.drawPolygon(arg0, arg1, arg2);
        return this;
    }

    public CGraphics drawPolygon(Polygon arg0) {
        g.drawPolygon(arg0);
        return this;
    }

    public CGraphics drawPolyline(int[] arg0, int[] arg1, int arg2) {
        g.drawPolyline(arg0, arg1, arg2);
        return this;
    }

    public CGraphics drawRect(int arg0, int arg1, int arg2, int arg3) {
        g.drawRect(arg0, arg1, arg2, arg3);
        return this;
    }

    public CGraphics drawRect(Point2D point, Dimension2D dimension) {
        drawRect(new CRect(point, dimension).toRectangle());
        return this;
    }

    public CGraphics drawRect(int x, int y, Dimension2D dimension) {
        drawRect(new Point(x, y), dimension);
        return this;
    }

    public CGraphics drawRect(Point2D point, int width, int height) {
        drawRect(point, new Dimension(width, height));
        return this;
    }

    public CGraphics drawRect(Rectangle rect) {
        drawRect(rect.@x, rect.@y, rect.@width, rect.@height);
        return this;
    }



    public CGraphics drawRoundRect(int arg0, int arg1, int arg2, int arg3, int arg4,
                            int arg5) {
        g.drawRoundRect(arg0, arg1, arg2, arg3, arg4, arg5);
        return this;
    }

    public CGraphics drawRoundRect(Point2D point, Dimension2D dimension, int arg2, int arg3) {
        drawRoundRect(new CRect(point, dimension).toRectangle(), arg2, arg3);
        return this;
    }

    public CGraphics drawRoundRect(int x, int y, Dimension2D dimension, int arg2, int arg3) {
        drawRoundRect(new Point(x, y), dimension, arg2, arg3);
        return this;
    }

    public CGraphics drawRoundRect(Point2D point, int width, int height, int arg2, int arg3) {
        drawRoundRect(point, new Dimension(width, height), arg2, arg3);
        return this;
    }

    public CGraphics drawRoundRect(Rectangle rect, int arg2, int arg3) {
        drawRoundRect(rect.@x,rect.@y,rect.@width,rect.@height,arg2,arg3);
        return this;
    }



    public CGraphics drawString(AttributedCharacterIterator arg0, int arg1, int arg2) {
        g.drawString(arg0, arg1, arg2);
        return this;
    }

    public CGraphics drawString(String arg0, int arg1, int arg2) {
        g.drawString(arg0, arg1, arg2);
        return this;
    }



    public boolean equals(Object arg0) { return g.equals(arg0); }

    public CGraphics fill3DRect(int arg0, int arg1, int arg2, int arg3, boolean arg4) {
        g.fill3DRect(arg0, arg1, arg2, arg3, arg4);
        return this;
    }

    public CGraphics fillArc(int arg0, int arg1, int arg2, int arg3, int arg4,
                      int arg5) {
        g.fillArc(arg0, arg1, arg2, arg3, arg4, arg5);
        return this;
    }



    public CGraphics fillOval(int arg0, int arg1, int arg2, int arg3) {
        g.fillOval(arg0, arg1, arg2, arg3);
        return this;
    }

    public CGraphics fillOval(Point2D point, Dimension2D dimension) {
        fillOval(new CRect(point, dimension).toRectangle());
        return this;
    }

    public CGraphics fillOval(int x, int y, Dimension2D dimension) {
        fillOval(new Point(x, y), dimension);
        return this;
    }

    public CGraphics fillOval(Point2D point, int width, int height) {
        fillOval(point, new Dimension(width, height));
        return this;
    }

    public CGraphics fillOval(Rectangle rect) {
        fillOval(rect.@x, rect.@y, rect.@width, rect.@height);
        return this;
    }



    public CGraphics fillPolygon(int[] arg0, int[] arg1, int arg2) {
        g.fillPolygon(arg0, arg1, arg2);
        return this;
    }

    public CGraphics fillPolygon(Polygon arg0) {
        g.fillPolygon(arg0);
        return this;
    }

    public CGraphics fillRect(int arg0, int arg1, int arg2, int arg3) {
        g.fillRect(arg0, arg1, arg2, arg3);
        return this;
    }

    public CGraphics fillRect(Point2D point, Dimension2D dimension) {
        fillRect(new CRect(point, dimension).toRectangle());
        return this;
    }

    public CGraphics fillRect(int x, int y, Dimension2D dimension) {
        fillRect(new Point(x, y), dimension);
        return this;
    }

    public CGraphics fillRect(Point2D point, int width, int height) {
        fillRect(point, new Dimension(width, height));
        return this;
    }

    public CGraphics fillRect(Rectangle rect) {
        fillRect(rect.@x, rect.@y, rect.@width, rect.@height);
        return this;
    }



    public CGraphics fillRoundRect(int x, int y, int width, int height, int arg4,
                            int arg5) {
        g.fillRoundRect(x, y, width, height, arg4, arg5);
        return this;
    }

    public CGraphics fillRoundRect(Point2D point, Dimension2D dimension, int arg2, int arg3) {
        fillRoundRect(new CRect(point, dimension).toRectangle(), arg2, arg3);
        return this;
    }

    public CGraphics fillRoundRect(int x, int y, Dimension2D dimension, int arg2, int arg3) {
        fillRoundRect(new Point(x, y), dimension, arg2, arg3);
        return this;
    }

    public CGraphics fillRoundRect(Point2D point, int width, int height, int arg2, int arg3) {
        fillRoundRect(point, new Dimension(width, height), arg2, arg3);
        return this;
    }

    public CGraphics fillRoundRect(Rectangle rect, int arg2, int arg3) {
        fillRoundRect(rect.@x, rect.@y, rect.@width, rect.@height, arg2, arg3);
        return this;
    }



    public CGraphics finalizeGraphics() {
        g.finalize();
        return this;
    }

    public Shape getClip() { return g.getClip(); }

    public Rectangle getClipBounds() { return g.getClipBounds(); }

    public Rectangle getClipBounds(Rectangle arg0) { return g.getClipBounds(arg0); }

    public Color getColor() { return g.getColor(); }

    public Font getFont() { return g.getFont(); }

    public FontMetrics getFontMetrics() { return g.getFontMetrics(); }

    public FontMetrics getFontMetrics(Font arg0) { return g.getFontMetrics(arg0); }

    public int hashCode() { return g.hashCode(); }



    public boolean hitClip(int arg0, int arg1, int arg2, int arg3) { return g.hitClip(arg0, arg1, arg2, arg3); }

    public boolean hitClip(Point2D point, Dimension2D dimension) { return hitClip(new CRect(point, dimension).toRectangle()); }

    public boolean hitClip(int x, int y, Dimension2D dimension) { return hitClip(new Point(x, y), dimension); }

    public boolean hitClip(Point2D point, int width, int height) { return hitClip(point, new Dimension(width, height)); }

    public boolean hitClip(Rectangle rect) { return hitClip(rect.@x, rect.@y, rect.@width, rect.@height); }



    public CGraphics setClip(int arg0, int arg1, int arg2, int arg3) {
        g.setClip(arg0, arg1, arg2, arg3);
        return this;
    }

    public CGraphics setClip(Point2D point, Dimension2D dimension) { return setClip(new CRect(point, dimension)); }

    public CGraphics setClip(int x, int y, Dimension2D dimension) { return setClip(new Point(x, y), dimension); }

    public CGraphics setClip(Point2D point, int width, int height) { return setClip(point, new Dimension(width, height)); }

    public CGraphics setClip(Rectangle rect) { return setClip(rect.@x, rect.@y, rect.@width, rect.@height); }



    public CGraphics setClip(Shape arg0) {
        g.setClip(arg0);
        return this;
    }

    public CGraphics setColor(Color arg0) {
        g.setColor(arg0);
        return this;
    }

    public CGraphics setFont(Font arg0) {
        g.setFont(arg0);
        return this;
    }

    public CGraphics setPaintMode() {
        g.setPaintMode();
        return this;
    }

    public CGraphics setXORMode(Color arg0) {
        g.setXORMode(arg0);
        return this;
    }

    public String toString() { return g.toString(); }

    public CGraphics translate(int arg0, int arg1) {
        g.translate(arg0, arg1);
        return this;
    }
}
