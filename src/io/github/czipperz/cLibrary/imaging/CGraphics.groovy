package io.github.czipperz.cLibrary.imaging

import io.github.czipperz.cLibrary.location.CRect

import java.awt.*
import java.awt.geom.Dimension2D
import java.awt.geom.Point2D
import java.awt.geom.Rectangle2D
import java.awt.image.ImageObserver
import java.text.AttributedCharacterIterator

/**
 * Created by czipperz on 4/8/15.
 */
class CGraphics {
	Graphics g

	CGraphics(Graphics g) {
		this.g = g
	}

	CGraphics clearRect(int x, int y, int width, int height) {
		g.clearRect(x,y,width,height)
		this
	}

	CGraphics clearRect(Point2D p, Dimension2D d) {
		clearRect(new CRect(p,d))
	}

	CGraphics clearRect(int x, int y, Dimension2D dim) {
		clearRect(x,y,dim.width,dim.height)
	}

	CGraphics clearRect(Point2D p, int width, int height) {
		clearRect(p.x,p.y,width,height)
	}

	CGraphics clearRect(Rectangle2D rect) {
		clearRect(rect.x,rect.y,rect.width,rect.height)
	}

	CGraphics clearRect(double x, double y, double width, double height) {
		clearRect((int)x,(int)y,(int)width,(int)height)
	}




	CGraphics clipRect(int x, int y, int width, int height) {
		g.clipRect(x,y,width,height)
		this
	}

	CGraphics clipRect(Point2D p, Dimension2D d) {
		clipRect(new CRect(p,d))
	}

	CGraphics clipRect(int x, int y, Dimension2D dim) {
		clipRect(x,y,dim.width,dim.height)
	}

	CGraphics clipRect(Point2D p, int width, int height) {
		clipRect(p.x,p.y,width,height)
	}

	CGraphics clipRect(Rectangle2D rect) {
		clipRect(rect.x,rect.y,rect.width,rect.height)
	}

	CGraphics clipRect(double x, double y, double width, double height) {
		clipRect((int)x,(int)y,(int)width,(int)height)
	}




	CGraphics copyArea(int v1, int v2, int v3, int v4, int v5, int v6) {
		g.copyArea(v1,v2,v3,v4,v5,v6)
		this
	}



	Graphics create() {
		g.create()
	}

	Graphics create(int x, int y, int width, int height) {
		g.create(x,y,width,height)
	}

	Graphics create(Point2D p, Dimension2D d) {
		create(new CRect(p,d))
	}

	Graphics create(int x, int y, Dimension2D dim) {
		create(x,y,dim.width,dim.height)
	}

	Graphics create(Point2D p, int width, int height) {
		create(p.x,p.y,width,height)
	}

	Graphics create(Rectangle2D rect) {
		create(rect.x,rect.y,rect.width,rect.height)
	}

	Graphics create(double x, double y, double width, double height) {
		create((int)x,(int)y,(int)width,(int)height)
	}



	CGraphics dispose() {
		g.dispose()
		this
	}

	CGraphics draw3DRect(int arg0, int arg1, int arg2, int arg3, boolean arg4) {
		g.draw3DRect(arg0, arg1, arg2, arg3, arg4);
		this
	}

	CGraphics drawArc(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5) {
		g.drawArc(arg0, arg1, arg2, arg3, arg4, arg5);
		this
	}

	CGraphics drawBytes(byte[] arg0, int arg1, int arg2, int arg3, int arg4) {
		g.drawBytes(arg0, arg1, arg2, arg3, arg4);
		this
	}

	CGraphics drawChars(char[] arg0, int arg1, int arg2, int arg3, int arg4) {
		g.drawChars(arg0, arg1, arg2, arg3, arg4);
		this
	}



	CGraphics drawImage(Image arg0, Rectangle locScreen, Rectangle locImage, ImageObserver arg4) {
		g.drawImage(arg0, locScreen.@x, locScreen.@y, locScreen.@x + locScreen.@width, locScreen.@y + locScreen.@height,
				locImage.@x, locImage.@y, locImage.@x + locImage.@width, locImage.@y + locImage.@height, arg4);
		this
	}

	CGraphics drawImage(Image arg0, int arg1, int arg2, Color arg3, ImageObserver arg4) {
		g.drawImage(arg0, arg1, arg2, arg3, arg4);
		this
	}

	CGraphics drawImage(Image arg0, int arg1, int arg2, ImageObserver arg3) {
		g.drawImage(arg0, arg1, arg2, arg3);
		this
	}

	CGraphics drawImage(Image arg0, int arg1, int arg2, int arg3,
	                         int arg4, Color arg5, ImageObserver arg6) {
		g.drawImage(arg0, arg1, arg2, arg3, arg4, arg5, arg6);
		this
	}

	CGraphics drawImage(Image arg0, int arg1, int arg2, int arg3,
	                         int arg4, ImageObserver arg5) {
		g.drawImage(arg0, arg1, arg2, arg3, arg4, arg5);
		this
	}

	CGraphics drawImage(Image image, Rectangle locScreen, ImageObserver object) {
		this.drawImage(image, locScreen.@x, locScreen.@y, locScreen.@width, locScreen.@height, object);
	}

	CGraphics drawImage(Image arg0, int arg1, int arg2, int arg3,
	                         int arg4, int arg5, int arg6, int arg7, int arg8, Color arg9,
	                         ImageObserver arg10) {
		g.drawImage(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9,arg10)
		this
	}

	CGraphics drawImage(Image arg0, int arg1, int arg2, int arg3,
	                         int arg4, int arg5, int arg6, int arg7, int arg8, ImageObserver arg9) {
		g.drawImage(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7,
				arg8, arg9);
		this
	}



	CGraphics drawLine(int arg0, int arg1, int arg2, int arg3) {
		g.drawLine(arg0, arg1, arg2, arg3);
		this
	}

	CGraphics drawOval(int arg0, int arg1, int arg2, int arg3) {
		g.drawOval(arg0, arg1, arg2, arg3);
		this
	}

	CGraphics drawPolygon(int[] arg0, int[] arg1, int arg2) {
		g.drawPolygon(arg0, arg1, arg2);
		this
	}

	CGraphics drawPolygon(Polygon arg0) {
		g.drawPolygon(arg0);
		this
	}

	CGraphics drawPolyline(int[] arg0, int[] arg1, int arg2) {
		g.drawPolyline(arg0, arg1, arg2);
		this
	}

	CGraphics drawRect(int arg0, int arg1, int arg2, int arg3) {
		g.drawRect(arg0, arg1, arg2, arg3);
		this
	}

	CGraphics drawRect(Point2D point, Dimension2D dimension) {
		drawRect(new CRect(point, dimension).toRectangle());
		this
	}

	CGraphics drawRect(int x, int y, Dimension2D dimension) {
		drawRect(new Point(x, y), dimension);
		this
	}

	CGraphics drawRect(Point2D point, int width, int height) {
		drawRect(point, new Dimension(width, height));
		this
	}

	CGraphics drawRect(Rectangle rect) {
		drawRect(rect.@x, rect.@y, rect.@width, rect.@height);
		this
	}



	CGraphics drawRoundRect(int arg0, int arg1, int arg2, int arg3, int arg4,
	                          int arg5) {
		g.drawRoundRect(arg0, arg1, arg2, arg3, arg4, arg5);
		this
	}

	CGraphics drawRoundRect(Point2D point, Dimension2D dimension, int arg2, int arg3) {
		drawRoundRect(new CRect(point, dimension).toRectangle(), arg2, arg3);
		this
	}

	CGraphics drawRoundRect(int x, int y, Dimension2D dimension, int arg2, int arg3) {
		drawRoundRect(new Point(x, y), dimension, arg2, arg3);
		this
	}

	CGraphics drawRoundRect(Point2D point, int width, int height, int arg2, int arg3) {
		drawRoundRect(point, new Dimension(width, height), arg2, arg3);
		this
	}

	CGraphics drawRoundRect(Rectangle rect, int arg2, int arg3) {
		drawRoundRect(rect.@x,rect.@y,rect.@width,rect.@height,arg2,arg3)
		this
	}



	CGraphics drawString(AttributedCharacterIterator arg0, int arg1, int arg2) {
		g.drawString(arg0, arg1, arg2);
		this
	}

	CGraphics drawString(String arg0, int arg1, int arg2) {
		g.drawString(arg0, arg1, arg2);
		this
	}



	boolean equals(Object arg0) {
		g.equals(arg0);
	}

	CGraphics fill3DRect(int arg0, int arg1, int arg2, int arg3, boolean arg4) {
		g.fill3DRect(arg0, arg1, arg2, arg3, arg4);
		this
	}

	CGraphics fillArc(int arg0, int arg1, int arg2, int arg3, int arg4,
	                    int arg5) {
		g.fillArc(arg0, arg1, arg2, arg3, arg4, arg5);
		this
	}



	CGraphics fillOval(int arg0, int arg1, int arg2, int arg3) {
		g.fillOval(arg0, arg1, arg2, arg3);
		this
	}

	CGraphics fillOval(Point2D point, Dimension2D dimension) {
		fillOval(new CRect(point, dimension).toRectangle());
		this
	}

	CGraphics fillOval(int x, int y, Dimension2D dimension) {
		fillOval(new Point(x, y), dimension);
		this
	}

	CGraphics fillOval(Point2D point, int width, int height) {
		fillOval(point, new Dimension(width, height));
		this
	}

	CGraphics fillOval(Rectangle rect) {
		fillOval(rect.@x, rect.@y, rect.@width, rect.@height);
		this
	}



	CGraphics fillPolygon(int[] arg0, int[] arg1, int arg2) {
		g.fillPolygon(arg0, arg1, arg2);
		this
	}

	CGraphics fillPolygon(Polygon arg0) {
		g.fillPolygon(arg0);
		this
	}

	CGraphics fillRect(int arg0, int arg1, int arg2, int arg3) {
		g.fillRect(arg0, arg1, arg2, arg3);
		this
	}

	CGraphics fillRect(Point2D point, Dimension2D dimension) {
		fillRect(new CRect(point, dimension).toRectangle());
		this
	}

	CGraphics fillRect(int x, int y, Dimension2D dimension) {
		fillRect(new Point(x, y), dimension);
		this
	}

	CGraphics fillRect(Point2D point, int width, int height) {
		fillRect(point, new Dimension(width, height));
		this
	}

	CGraphics fillRect(Rectangle rect) {
		fillRect(rect.@x, rect.@y, rect.@width, rect.@height);
		this
	}



	CGraphics fillRoundRect(int x, int y, int width, int height, int arg4,
	                          int arg5) {
		g.fillRoundRect(x, y, width, height, arg4, arg5);
		this
	}

	CGraphics fillRoundRect(Point2D point, Dimension2D dimension, int arg2, int arg3) {
		fillRoundRect(new CRect(point, dimension).toRectangle(), arg2, arg3);
		this
	}

	CGraphics fillRoundRect(int x, int y, Dimension2D dimension, int arg2, int arg3) {
		fillRoundRect(new Point(x, y), dimension, arg2, arg3);
		this
	}

	CGraphics fillRoundRect(Point2D point, int width, int height, int arg2, int arg3) {
		fillRoundRect(point, new Dimension(width, height), arg2, arg3);
		this
	}

	CGraphics fillRoundRect(Rectangle rect, int arg2, int arg3) {
		fillRoundRect(rect.@x, rect.@y, rect.@width, rect.@height, arg2, arg3);
		this
	}



	CGraphics finalizeGraphics() {
		g.finalize();
		this
	}

	Shape getClip() {
		return g.getClip();
	}

	Rectangle getClipBounds() {
		return g.getClipBounds();
	}

	Rectangle getClipBounds(Rectangle arg0) {
		return g.getClipBounds(arg0);
	}

	Color getColor() {
		return g.getColor();
	}

	Font getFont() {
		return g.getFont();
	}

	FontMetrics getFontMetrics() {
		return g.getFontMetrics();
	}

	FontMetrics getFontMetrics(Font arg0) {
		return g.getFontMetrics(arg0);
	}

	int hashCode() {
		return g.hashCode();
	}



	boolean hitClip(int arg0, int arg1, int arg2, int arg3) {
		return g.hitClip(arg0, arg1, arg2, arg3);
	}

	boolean hitClip(Point2D point, Dimension2D dimension) {
		hitClip(new CRect(point, dimension).toRectangle());
	}

	boolean hitClip(int x, int y, Dimension2D dimension) {
		hitClip(new Point(x, y), dimension);
	}

	boolean hitClip(Point2D point, int width, int height) {
		hitClip(point, new Dimension(width, height));
	}

	boolean hitClip(Rectangle rect) {
		hitClip(rect.@x, rect.@y, rect.@width, rect.@height);
	}



	CGraphics setClip(int arg0, int arg1, int arg2, int arg3) {
		g.setClip(arg0, arg1, arg2, arg3);
		this
	}

	CGraphics setClip(Point2D point, Dimension2D dimension) {
		setClip(new CRect(point, dimension));
	}

	CGraphics setClip(int x, int y, Dimension2D dimension) {
		setClip(new Point(x, y), dimension);
	}

	CGraphics setClip(Point2D point, int width, int height) {
		setClip(point, new Dimension(width, height));
	}

	CGraphics setClip(Rectangle rect) {
		setClip(rect.@x, rect.@y, rect.@width, rect.@height);
	}



	CGraphics setClip(Shape arg0) {
		g.setClip(arg0);
		this
	}

	CGraphics setColor(Color arg0) {
		g.setColor(arg0);
		this
	}

	CGraphics setFont(Font arg0) {
		g.setFont(arg0);
		this
	}

	CGraphics setPaintMode() {
		g.setPaintMode();
		this
	}

	CGraphics setXORMode(Color arg0) {
		g.setXORMode(arg0);
		this
	}

	String toString() {
		return g.toString();
	}

	CGraphics translate(int arg0, int arg1) {
		g.translate(arg0, arg1);
		this
	}
}