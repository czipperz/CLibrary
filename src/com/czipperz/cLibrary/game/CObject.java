package com.czipperz.cLibrary.game;

import java.awt.Color;
import java.awt.Rectangle;

/**
 * An object that allows for IDing and Drawing, but doesn't supply drawing methods.
 * @author Chris Gregory
 * @see Comparable<T>
 * @see IIDDrawAble
 * @see CObjectDrawAble
 */
public abstract class CObject extends CIDAble implements IIDDrawAble {
	private boolean active = true;
	
	/**
	 * Compares the object to another object.  (compares the IDs)
	 * @see com.czipperz.cLibrary.game.CID
	 * @param the instance to compare this object to.
	 */
	public int compareTo(CObject other) {
		return this.getInstanceID().compareTo(other.getInstanceID());
	}
	
	/**
	 * Sets the object to be drawn.
	 * @return this instance for further method calls.
	 */
	public CObject setActive() {
		return setActive(true);
	}

	/**
	 * Sets the object to not be drawn.
	 * @return this instance for further method calls.
	 */
	public CObject setInactive() {
		return setActive(false);
	}

	/**
	 * Sets the object to be drawn acording to the boolean inputted.
	 * @return this instance for further method calls.
	 * @param active - whether the object will be drawn.
	 */
	public CObject setActive(boolean active) {
		this.active = active;
		return this;
	}
	
	public boolean needUpdate() {
		return active;
	}
	
	/**
	 * @return the "bounds" of the object on the screen. (assuming that it is being displayed on a CView with size set to the maximum)
	 */
	public abstract Rectangle getLocScreen();
	
	/**
	 * @return the <code>Color</code> that will be displayed to surround this sprite when it is toggled on by the CGameFrame.
	 * @link com.czipperz.cLibrary.game.CGameFrame
	 */
	public Color getOutlineColor() {
		return Color.BLACK;
	}
	
	/**
	 * @return {@link #getLocScreen()}
	 */
	public Rectangle getBounds() {
		return getLocScreen();
	}
}
