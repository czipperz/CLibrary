package com.czipperz.cLibrary.game;

import java.awt.*;

/**
 * A basic interface that allows the CGameFrame to draw appropriately the Object.
 * @author Chris Gregory
 * @see com.czipperz.cLibrary.game.CGameFrame
 */
public interface CDrawAble extends Comparable<CDrawAble> {
	/**
	 * Called by the CGameFrame.  Put your drawing code here.
	 * @param g - the Graphics to drawn on.
	 * @return this
	 */
	public CDrawAble draw(Graphics g);



	/**
	 * Where you update the object so it is ready for the next draw events. Called before the other two ticks.
	 * @return this
	 */
	public default CDrawAble tickBefore() {
		return this;
	}
	/**
	 * Where you update the object so it is ready for the next draw events. Called inbetween the other two ticks. Usually where most code goes.
	 * @return this
	 */
	public CDrawAble tick();
	/**
	 * Where you update the object so it is ready for the next draw events. Called after the other two ticks.
	 * @return this
	 */
	public default CDrawAble tickAfter() {
		return this;
	}



	/**
	 * Returns the depth of the object (negative infinity means drawn last).
	 * Therefore the lower number depth will be on top to the viewer's eye.
	 * @return
	 */
	public int getDepth();
	/**
	 * Return a Rectangle that represents the boundaries of the object on the CGameFrame.
	 * @return a Rectangle object that represents the boundaries of the object.
	 */
	public Rectangle getBounds();
	/**
	 * Tells the update processor if you want this object to be ticked.
	 * @return true to updated the object, false if to not be.
	 */
	public boolean needUpdate();
	/**
	 * Tells the rendering processor if you want the object to be drawn.
	 * @return true to draw the object, false if to not be.
	 */
	public boolean needDraw();

    public int compareTo(CDrawAble other);
}
