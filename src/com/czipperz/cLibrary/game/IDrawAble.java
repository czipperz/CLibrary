package com.czipperz.cLibrary.game;

import java.awt.*;

/**
 * A basic interface that allows the CGameFrame to draw appropriately the Object.
 * @author Chris Gregory
 * @see com.czipperz.cLibrary.game.CGameFrame
 */
public interface IDrawAble extends Comparable<IDrawAble> {
	
	/**
	 * Called by the CGameFrame.  Put your drawing code here.
	 * @param g - the Graphics to be displayed.
	 * @return this
	 */
	public IDrawAble draw(Graphics g);
	/**
	 * Returns the depth of the object (negative infinity means drawn last).
	 * Therefore the lower number depth will be on top to the viewer's eye.
	 * @return
	 */
	public int getDepth();
	/**
	 * Return a Rectangle that represents the boundaries of the object.
	 * @return a Rectangle object that represents the boundaries of the object.
	 */
	public Rectangle getBounds();
	/**
	 * Tells the rendering processor if you want the object to be drawn.
	 * @return true to be drawn the object, false if to not be.
	 */
	public boolean needUpdate();
}
