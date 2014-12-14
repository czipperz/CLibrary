package com.czipperz.cLibrary.imaging;

import com.czipperz.cLibrary.location.CRect;

import java.awt.*;
import java.awt.geom.Dimension2D;
import java.awt.geom.Point2D;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;

public class CGraphics {
	private Graphics g;
	
	public CGraphics(Graphics g) {
		this.g = g;
	}

	public void clearRect(int x, int y, int width, int height) {
		g.clearRect(x, y, width, height);
	}
	
	public void clearRect(Point2D point, Dimension2D dimension) {
		clearRect(new CRect(point, dimension));
	}
	
	public void clearRect(int x, int y, Dimension2D dimension) {
		clearRect(new Point(x, y), dimension);
	}

	public void clearRect(Point2D point, int width, int height) {
		clearRect(point, new Dimension(width, height));
	}
	
	public void clearRect(Rectangle rect) {
		clearRect(rect.x, rect.y, rect.width, rect.height);
	}

	
	
	public void clipRect(int x, int y, int width, int height) {
		g.clipRect(x, y, width, height);
	}
	
	public void clipRect(Point2D point, Dimension2D dimension) {
		clipRect(new CRect(point, dimension));
	}
	
	public void clipRect(int x, int y, Dimension2D dimension) {
		clipRect(new Point(x, y), dimension);
	}

	public void clipRect(Point2D point, int width, int height) {
		clipRect(point, new Dimension(width, height));
	}
	
	public void clipRect(Rectangle rect) {
		clipRect(rect.x, rect.y, rect.width, rect.height);
	}

	
	
	public void copyArea(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5) {
		g.copyArea(arg0, arg1, arg2, arg3, arg4, arg5);
	}
	
	

	public Graphics create() {
		return g.create();
	}

	public Graphics create(int arg0, int arg1, int arg2, int arg3) {
		return g.create(arg0, arg1, arg2, arg3);
	}
	
	public void create(Point2D point, Dimension2D dimension) {
		create(new CRect(point, dimension));
	}
	
	public void create(int x, int y, Dimension2D dimension) {
		create(new Point(x, y), dimension);
	}

	public void create(Point2D point, int width, int height) {
		create(point, new Dimension(width, height));
	}
	
	public void create(Rectangle rect) {
		create(rect.x, rect.y, rect.width, rect.height);
	}

	
	
	public void dispose() {
		g.dispose();
	}

	public void draw3DRect(int arg0, int arg1, int arg2, int arg3, boolean arg4) {
		g.draw3DRect(arg0, arg1, arg2, arg3, arg4);
	}

	public void drawArc(int arg0, int arg1, int arg2, int arg3, int arg4,
			int arg5) {
		g.drawArc(arg0, arg1, arg2, arg3, arg4, arg5);
	}

	public void drawBytes(byte[] arg0, int arg1, int arg2, int arg3, int arg4) {
		g.drawBytes(arg0, arg1, arg2, arg3, arg4);
	}

	public void drawChars(char[] arg0, int arg1, int arg2, int arg3, int arg4) {
		g.drawChars(arg0, arg1, arg2, arg3, arg4);
	}
	
	

	public boolean drawImage(Image arg0, Rectangle locScreen, Rectangle locImage, ImageObserver arg4) {
		return g.drawImage(arg0, locScreen.x, locScreen.y, locScreen.x + locScreen.width, locScreen.y + locScreen.height, locImage.x, locImage.y, locImage.x + locImage.width, locImage.y + locImage.height, arg4);
	}
	
	public boolean drawImage(Image arg0, int arg1, int arg2, Color arg3, ImageObserver arg4) {
		return g.drawImage(arg0, arg1, arg2, arg3, arg4);
	}

	public boolean drawImage(Image arg0, int arg1, int arg2, ImageObserver arg3) {
		return g.drawImage(arg0, arg1, arg2, arg3);
	}

	public boolean drawImage(Image arg0, int arg1, int arg2, int arg3,
			int arg4, Color arg5, ImageObserver arg6) {
		return g.drawImage(arg0, arg1, arg2, arg3, arg4, arg5, arg6);
	}

	public boolean drawImage(Image arg0, int arg1, int arg2, int arg3,
			int arg4, ImageObserver arg5) {
		return g.drawImage(arg0, arg1, arg2, arg3, arg4, arg5);
	}

	public void drawImage(Image image, Rectangle locScreen, ImageObserver object) {
		this.drawImage(image, locScreen.x, locScreen.y, locScreen.width, locScreen.height, object);
	}

	public boolean drawImage(Image arg0, int arg1, int arg2, int arg3,
			int arg4, int arg5, int arg6, int arg7, int arg8, Color arg9,
			ImageObserver arg10) {
		return g.drawImage(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7,
				arg8, arg9, arg10);
	}

	public boolean drawImage(Image arg0, int arg1, int arg2, int arg3,
			int arg4, int arg5, int arg6, int arg7, int arg8, ImageObserver arg9) {
		return g.drawImage(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7,
				arg8, arg9);
	}
	
	

	public void drawLine(int arg0, int arg1, int arg2, int arg3) {
		g.drawLine(arg0, arg1, arg2, arg3);
	}

	public void drawOval(int arg0, int arg1, int arg2, int arg3) {
		g.drawOval(arg0, arg1, arg2, arg3);
	}
	
	public void drawPolygon(int[] arg0, int[] arg1, int arg2) {
		g.drawPolygon(arg0, arg1, arg2);
	}

	public void drawPolygon(Polygon arg0) {
		g.drawPolygon(arg0);
	}

	public void drawPolyline(int[] arg0, int[] arg1, int arg2) {
		g.drawPolyline(arg0, arg1, arg2);
	}

	public void drawRect(int arg0, int arg1, int arg2, int arg3) {
		g.drawRect(arg0, arg1, arg2, arg3);
	}
	
	public void drawRect(Point2D point, Dimension2D dimension) {
		drawRect(new CRect(point, dimension));
	}
	
	public void drawRect(int x, int y, Dimension2D dimension) {
		drawRect(new Point(x, y), dimension);
	}

	public void drawRect(Point2D point, int width, int height) {
		drawRect(point, new Dimension(width, height));
	}
	
	public void drawRect(Rectangle rect) {
		drawRect(rect.x, rect.y, rect.width, rect.height);
	}
	
	

	public void drawRoundRect(int arg0, int arg1, int arg2, int arg3, int arg4,
			int arg5) {
		g.drawRoundRect(arg0, arg1, arg2, arg3, arg4, arg5);
	}
	
	public void drawRoundRect(Point2D point, Dimension2D dimension, int arg2, int arg3) {
		drawRoundRect(new CRect(point, dimension), arg2, arg3);
	}
	
	public void drawRoundRect(int x, int y, Dimension2D dimension, int arg2, int arg3) {
		drawRoundRect(new Point(x, y), dimension, arg2, arg3);
	}

	public void drawRoundRect(Point2D point, int width, int height, int arg2, int arg3) {
		drawRoundRect(point, new Dimension(width, height), arg2, arg3);
	}
	
	public void drawRoundRect(Rectangle rect, int arg2, int arg3) {
		drawRoundRect(rect.x, rect.y, rect.width, rect.height, arg2, arg3);
	}
	
	

	public void drawString(AttributedCharacterIterator arg0, int arg1, int arg2) {
		g.drawString(arg0, arg1, arg2);
	}

	public void drawString(String arg0, int arg1, int arg2) {
		g.drawString(arg0, arg1, arg2);
	}
	
	

	public boolean equals(Object arg0) {
		return g.equals(arg0);
	}

	public void fill3DRect(int arg0, int arg1, int arg2, int arg3, boolean arg4) {
		g.fill3DRect(arg0, arg1, arg2, arg3, arg4);
	}

	public void fillArc(int arg0, int arg1, int arg2, int arg3, int arg4,
			int arg5) {
		g.fillArc(arg0, arg1, arg2, arg3, arg4, arg5);
	}
	
	

	public void fillOval(int arg0, int arg1, int arg2, int arg3) {
		g.fillOval(arg0, arg1, arg2, arg3);
	}
	
	public void fillOval(Point2D point, Dimension2D dimension) {
		fillOval(new CRect(point, dimension));
	}
	
	public void fillOval(int x, int y, Dimension2D dimension) {
		fillOval(new Point(x, y), dimension);
	}

	public void fillOval(Point2D point, int width, int height) {
		fillOval(point, new Dimension(width, height));
	}
	
	public void fillOval(Rectangle rect) {
		fillOval(rect.x, rect.y, rect.width, rect.height);
	}
	
	

	public void fillPolygon(int[] arg0, int[] arg1, int arg2) {
		g.fillPolygon(arg0, arg1, arg2);
	}

	public void fillPolygon(Polygon arg0) {
		g.fillPolygon(arg0);
	}

	public void fillRect(int arg0, int arg1, int arg2, int arg3) {
		g.fillRect(arg0, arg1, arg2, arg3);
	}
	
	public void fillRect(Point2D point, Dimension2D dimension) {
		fillRect(new CRect(point, dimension));
	}
	
	public void fillRect(int x, int y, Dimension2D dimension) {
		fillRect(new Point(x, y), dimension);
	}

	public void fillRect(Point2D point, int width, int height) {
		fillRect(point, new Dimension(width, height));
	}
	
	public void fillRect(Rectangle rect) {
		fillRect(rect.x, rect.y, rect.width, rect.height);
	}
	
	

	public void fillRoundRect(int arg0, int arg1, int arg2, int arg3, int arg4,
			int arg5) {
		g.fillRoundRect(arg0, arg1, arg2, arg3, arg4, arg5);
	}
	
	public void fillRoundRect(Point2D point, Dimension2D dimension, int arg2, int arg3) {
		fillRoundRect(new CRect(point, dimension), arg2, arg3);
	}
	
	public void fillRoundRect(int x, int y, Dimension2D dimension, int arg2, int arg3) {
		fillRoundRect(new Point(x, y), dimension, arg2, arg3);
	}

	public void fillRoundRect(Point2D point, int width, int height, int arg2, int arg3) {
		fillRoundRect(point, new Dimension(width, height), arg2, arg3);
	}
	
	public void fillRoundRect(Rectangle rect, int arg2, int arg3) {
		fillRoundRect(rect.x, rect.y, rect.width, rect.height, arg2, arg3);
	}
	
	

	public void finalize() {
		g.finalize();
	}

	public Shape getClip() {
		return g.getClip();
	}

	public Rectangle getClipBounds() {
		return g.getClipBounds();
	}

	public Rectangle getClipBounds(Rectangle arg0) {
		return g.getClipBounds(arg0);
	}

	public Color getColor() {
		return g.getColor();
	}

	public Font getFont() {
		return g.getFont();
	}

	public FontMetrics getFontMetrics() {
		return g.getFontMetrics();
	}

	public FontMetrics getFontMetrics(Font arg0) {
		return g.getFontMetrics(arg0);
	}

	public int hashCode() {
		return g.hashCode();
	}

	
	
	public boolean hitClip(int arg0, int arg1, int arg2, int arg3) {
		return g.hitClip(arg0, arg1, arg2, arg3);
	}
	
	public void hitClip(Point2D point, Dimension2D dimension) {
		hitClip(new CRect(point, dimension));
	}
	
	public void hitClip(int x, int y, Dimension2D dimension) {
		hitClip(new Point(x, y), dimension);
	}

	public void hitClip(Point2D point, int width, int height) {
		hitClip(point, new Dimension(width, height));
	}
	
	public void hitClip(Rectangle rect) {
		hitClip(rect.x, rect.y, rect.width, rect.height);
	}
	
	

	public void setClip(int arg0, int arg1, int arg2, int arg3) {
		g.setClip(arg0, arg1, arg2, arg3);
	}
	
	public void setClip(Point2D point, Dimension2D dimension) {
		setClip(new CRect(point, dimension));
	}
	
	public void setClip(int x, int y, Dimension2D dimension) {
		setClip(new Point(x, y), dimension);
	}

	public void setClip(Point2D point, int width, int height) {
		setClip(point, new Dimension(width, height));
	}
	
	public void setClip(Rectangle rect) {
		setClip(rect.x, rect.y, rect.width, rect.height);
	}
	
	

	public void setClip(Shape arg0) {
		g.setClip(arg0);
	}

	public void setColor(Color arg0) {
		g.setColor(arg0);
	}

	public void setFont(Font arg0) {
		g.setFont(arg0);
	}

	public void setPaintMode() {
		g.setPaintMode();
	}

	public void setXORMode(Color arg0) {
		g.setXORMode(arg0);
	}

	public String toString() {
		return g.toString();
	}

	public void translate(int arg0, int arg1) {
		g.translate(arg0, arg1);
	}
}
