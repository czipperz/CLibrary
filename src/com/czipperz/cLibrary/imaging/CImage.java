package com.czipperz.cLibrary.imaging;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.io.Serializable;

/**
 * PLEASE Do not directly extend unless seek it wise.  CImageDraw has all the things you should need for drawing custom sprites, not premade for you. CImageBuffered has all the things you should need for drawing images, premade for you.
 * @author Chris Gregory
 */
public abstract class CImage implements Serializable {
	private Rectangle locScreen;
	
	public CImage(Rectangle locScreen) {
		this.locScreen = locScreen;
	}
	
	public Rectangle getBounds() {
		return locScreen;
	}
	
	public Rectangle getLocScreen() {
		return locScreen;
	}

	public CImage setLocScreen(Rectangle locScreen) {
		this.locScreen = locScreen;
		return this;
	}
	
	/**
	 * Make sure to use the getLocScreen() or getBounds() locations.
	 * @param g
	 * @return this instance of CImage.
	 */
	public abstract CImage draw(Graphics g);

	public boolean hasCustomOutlineColor() {
		try {
			getCustomOutlineColor();
		} catch(Throwable t) {
			return false;
		}
		return true;
	}
	
	public abstract Color getCustomOutlineColor();
}
