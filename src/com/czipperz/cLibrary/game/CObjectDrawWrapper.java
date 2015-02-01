package com.czipperz.cLibrary.game;

import com.czipperz.cLibrary.imaging.CImage;

import java.awt.*;

/**
 * A class that extends CObject.  Controls the depth and drawing part of the object.
 * It uses the CImage class as an input so that the programmer can control the drawing part.
 * @author Chris Gregory
 * @see com.czipperz.cLibrary.game.CObject
 * @see {@link #CObjectDrawWrapper(com.czipperz.cLibrary.game.CGameFrame, int, CImage)}
 * @see {@link #CObjectDrawWrapper(com.czipperz.cLibrary.game.CGameFrame, CImage)}
 */
public class CObjectDrawWrapper extends CObject {
	private int depth;
	private CImage image;
	
	/**
	 * Initializes the CObjectDrawWrapper.  The CGameFrame is set and is accessible by the object and others for later use.
     * This also adds this instance to the CGameFrame. <strong>NOTE: THIS DOES NOT MAKE THIS INSTANCE DRAW BY DEFAULT.  THERE MUST BE A CALL MADE TO ADD THIS TO ONE OR MORE <code>CView</code> (s).</strong><br />
	 * The depth dictates how deep the Object is displayed on the screen (negative infinity is on top). <br />
	 * The image is used to display the Object.  Its draw method will be called every time this Object is to be displayed on a CView.
	 * @param displayOn
	 * @param depth
	 * @param image
	 * @see for a constructor with default of 0 depth: {@link #CObjectDrawWrapper(com.czipperz.cLibrary.game.CGameFrame, CImage)}
	 */
	public CObjectDrawWrapper(CGameFrame displayOn, int depth, CImage image) {
		super(displayOn);
		this.depth = depth;
		this.image = image;
		displayOn.addObject(this);
	}
	
	/**
	 * Calls the main constructer with the depth set as 0.
	 * @param displayOn
	 * @param image
	 * @see {@link #CObjectDrawWrapper(CGameFrame, int, CImage)}
	 */
	public CObjectDrawWrapper(CGameFrame displayOn, CImage image) {
		this(displayOn, 0, image);
	}
	
	public int getDepth() {
		return depth;
	}
	
	/**
	 * Sets the depth of the Object (negative infinity is on top).
	 * @param depth
	 * @return this instance.
	 */
	public CObjectDrawWrapper setDepth(int depth) {
		this.depth = depth;
		return this;
	}

	/**
	 * @return the Image object this instance uses to draw itself.
	 */
	public CImage getImage() {
		return image;
	}
	
	/**
	 * Updates the image object.
	 * @param image
	 * @return this instance for more method calls.
	 */
	public CObjectDrawWrapper setImage(CImage image) {
		this.image = image;
		return this;
	}

	/**
	 * Calls the drawing method of the CImage.
	 */
	public CObjectDrawWrapper draw(Graphics g) {
		image.draw(g);
		return this;
	}

	public CDrawAble tick() {
		return this;
	}

	public Rectangle getBounds() {
		return image.getBounds();
	}

	public Rectangle getLocScreen() {
		return image.getLocScreen();
	}
	
	public Color getOutlineColor() {
		if(image.hasCustomOutlineColor()) {
			return image.getCustomOutlineColor();
		}
		return super.getOutlineColor();
	}
}
