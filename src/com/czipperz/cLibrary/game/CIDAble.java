package com.czipperz.cLibrary.game;

/**
 * A basic interface that allows for IDing.
 * @author Chris Gregory
 * @see {@link #getClassID()}
 * @see {@link #getInstanceID()}
 * @see com.czipperz.cLibrary.game.CID
 * @see CIDWrapper
 * @see CIDDrawAble
 */
public interface CIDAble {
	/**
	 * @return The Class ID used to identify if this object is of <i><strong>EXACTLY</strong> THE SAME CLASS.</i>
	 * @see {@link #getInstanceID()}
	 */
	public CID getClassID();
	/**
	 * @return The Instance ID used to identify this and only this object.  <strong>NOTE: Please Don't copy Instance IDs EVER</strong>
	 * @see {@link #getClassID()}
	 */
	public CID getInstanceID();
}
