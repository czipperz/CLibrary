package com.czipperz.cLibrary.game.directions;

/**
 * This is a class that has an embedded enum.  Use one of the other variables to test against.
 * <br /><strong>NOTE:</strong> <code>LEFT</code> IS EQUAL TO <code>RIGHT</code>, <strong>and</strong> <code>LEFT</code> IS EQUAL TO <code>WEST</code>.
 * @author Chris Gregory
 * @see {@link #HORIZONTAL}
 * @see {@link #VERTICAL}
 * @see {@link EDirectionsBasicDifferential} for variables where LEFT != RIGHT
 */
public class EDirectionsBasic {
	/**
	 * The base type for UP and DOWN calculations.  See other names that reference this variable in the See More.
	 * @see {@link #EAST}
	 * @see {@link #WEST}
	 * @see {@link #LEFT}
	 * @see {@link #RIGHT}
	 */
	public static final EDirections HORIZONTAL = EDirections.HOR;
	/**
	 * @see #HORIZONTAL
	 */
	public static final EDirections EAST_WEST = EDirections.HOR;
	/**
	 * @see #HORIZONTAL
	 */
	public static final EDirections WEST_EAST = EDirections.HOR;
	/**
	 * @see #HORIZONTAL
	 */
	public static final EDirections LEFT_RIGHT = EDirections.HOR;
	/**
	 * @see #HORIZONTAL
	 */
	public static final EDirections RIGHT_LEFT = EDirections.HOR;
	
	/**
	 * The base type for UP and DOWN calculations.  See other names that reference this variable in the See More.
	 * @see {@link #NORTH}
	 * @see {@link #SOUTH}
	 * @see {@link #UP}
	 * @see {@link #DOWN}
	 */
	public static final EDirections	VERTICAL = EDirections.VER;
	/**
	 * @see #VERTICAL
	 */
	public static final EDirections	NORTH_SOUTH = EDirections.VER;
	/**
	 * @see #VERTICAL
	 */
	public static final EDirections	SOUTH_NORTH = EDirections.VER;
	/**
	 * @see #VERTICAL
	 */
	public static final EDirections	UP_DOWN = EDirections.VER;
	/**
	 * @see #VERTICAL
	 */
	public static final EDirections	DOWN_UP = EDirections.VER;
	
	private enum EDirections {
		HOR, VER;
	}
	
	private EDirectionsBasic() {}
}
