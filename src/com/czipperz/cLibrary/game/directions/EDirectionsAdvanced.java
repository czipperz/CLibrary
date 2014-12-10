package com.czipperz.cLibrary.game.directions;

/**
 * This is a class that has an embedded enum.  Use one of the other variables to test against.
 * <br /><strong>NOTE:</strong> <code>LEFT</code> IS EQUAL TO <code>RIGHT</code>, <strong>and</strong> <code>LEFT</code> IS EQUAL TO <code>WEST</code>.
 * @author Chris Gregory
 * @see {@link #HORIZONTAL}
 * @see {@link #VERTICAL}
 * @see {@link #NORTH_EAST}
 * @see {@link #NORTH_WEST}
 * @see {@link EDirectionsAdvancedDifferential} for variables where LEFT != RIGHT
 */
public class EDirectionsAdvanced {
	/**
	 * The base type for LEFT and RIGHT calculations.  See other names that reference this variable in the See More.
	 * @see {@link #EAST}
	 * @see {@link #WEST}
	 * @see {@link #LEFT}
	 * @see {@link #RIGHT}
	 */
	public static final EDirections HORIZONTAL = EDirections.HOR;
	/**
	 * @see {@link #HORIZONTAL}
	 */
	public static final EDirections EAST_WEST = HORIZONTAL;
	/**
	 * @see {@link #HORIZONTAL}
	 */
	public static final EDirections WEST_EAST = HORIZONTAL;
	/**
	 * @see {@link #HORIZONTAL}
	 */
	public static final EDirections LEFT_RIGHT = HORIZONTAL;
	/**
	 * @see {@link #HORIZONTAL}
	 */
	public static final EDirections RIGHT_LEFT = HORIZONTAL;

	/**
	 * The base type for UP and DOWN calculations.  See other names that reference this variable in the See More.
	 * @see {@link #NORTH}
	 * @see {@link #SOUTH}
	 * @see {@link #UP}
	 * @see {@link #DOWN}
	 */
	public static final EDirections VERTICAL = EDirections.VER;
	/**
	 * @see {@link #VERTICAL}
	 */
	public static final EDirections NORTH_SOUTH = VERTICAL;
	/**
	 * @see {@link #VERTICAL}
	 */
	public static final EDirections SOUTH_NORTH = VERTICAL;
	/**
	 * @see {@link #VERTICAL}
	 */
	public static final EDirections UP_DOWN = VERTICAL;
	/**
	 * @see {@link #VERTICAL}
	 */
	public static final EDirections DOWN_UP = VERTICAL;

	/**
	 * The base type for NORTH_EAST and SOUTH_WEST calculations.  See other names that reference this variable in the See More.
	 * @see {@link #NORTH_EAST}
	 * @see {@link #SOUTH_WEST}
	 * @see {@link #UP_RIGHT}
	 * @see {@link #DOWN_LEFT}
	 */
	public static final EDirections NORTH_EAST = EDirections.UP_RIGHT;
	/**
	 * @see {@link #NORTH_EAST}
	 */
	public static final EDirections SOUTH_WEST = EDirections.UP_RIGHT;
	/**
	 * @see {@link #NORTH_EAST}
	 */
	public static final EDirections UP_RIGHT = EDirections.UP_RIGHT;
	/**
	 * @see {@link #NORTH_EAST}
	 */
	public static final EDirections DOWN_LEFT = EDirections.UP_RIGHT;

	/**
	 * The base type for NORTH_WEST and SOUTH_EAST calculations.  See other names that reference this variable in the See More.
	 * @see {@link #NORTH_WEST}
	 * @see {@link #SOUTH_EAST}
	 * @see {@link #UP_LEFT}
	 * @see {@link #DOWN_RIGHT}
	 */
	public static final EDirections SOUTH_EAST = EDirections.UP_LEFT;
	/**
	 * @see {@link #NORTH_WEST}
	 */
	public static final EDirections NORTH_WEST = EDirections.UP_LEFT;
	/**
	 * @see {@link #NORTH_WEST}
	 */
	public static final EDirections UP_LEFT= EDirections.UP_LEFT;
	/**
	 * @see {@link #NORTH_WEST}
	 */
	public static final EDirections DOWN_RIGHT = EDirections.UP_LEFT;
	
	private enum EDirections {
		HOR, VER, UP_LEFT, UP_RIGHT
	}
	
	private EDirectionsAdvanced() {}
}
