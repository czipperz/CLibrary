package com.czipperz.cLibrary.game.directions;


/**
 * This is a class that has an embedded enum.  Use one of the other variables to test against.
 * <br /><strong>NOTE:</strong> <code>LEFT</code> IS NOT EQUAL TO <code>RIGHT</code>, <strong>but</strong> <code>LEFT</code> IS EQUAL TO <code>WEST</code>.
 * @author Chris Gregory
 * @see {@link #HORIZONTAL}
 * @see {@link #VERTICAL}
 * @see {@link #NORTH_EAST}
 * @see {@link #NORTH_WEST}
 * @see {@link com.czipperz.cLibrary.game.directions.EDirectionsAdvanced} for variables where LEFT == RIGHT
 */
public class EDirectionsAdvancedDifferential {
	/**
	 * The base type for LEFT and WEST calculations.  See other names that reference this variable in the See More.
	 * @see {@link #WEST}
	 */
	public static final EDirections LEFT = EDirections.LEFT;
	/**
	 * @see {@link #LEFT}
	 */
	public static final EDirections WEST = LEFT;

	/**
	 * The base type for RIGHT and EAST calculations.  See other names that reference this variable in the See More.
	 * @see {@link #WEST}
	 */
	public static final EDirections RIGHT = EDirections.RIGHT;
	/**
	 * @see {@link #RIGHT}
	 */
	public static final EDirections EAST = RIGHT;

	/**
	 * The base type for UP and NORTH calculations.  See other names that reference this variable in the See More.
	 * @see {@link #NORTH}
	 * @see {@link #UP}
	 */
	public static final EDirections UP = EDirections.UP;
	/**
	 * @see {@link #UP}
	 */
	public static final EDirections NORTH = UP;

	/**
	 * The base type for DOWN and SOUTH calculations.  See other names that reference this variable in the See More.
	 * @see {@link #NORTH}
	 * @see {@link #UP}
	 */
	public static final EDirections DOWN = EDirections.DOWN;
	/**
	 * @see {@link #DOWN}
	 */
	public static final EDirections SOUTH = DOWN;

	/**
	 * The base type for UP_RIGHT and NORTH_EAST calculations.  See other names that reference this variable in the See More.
	 * @see {@link #NORTH_EAST}
	 */
	public static final EDirections UP_RIGHT = EDirections.UP_RIGHT;
	/**
	 * @see {@link #UP_RIGHT}
	 */
	public static final EDirections NORTH_EAST = UP_RIGHT;
	
	/**
	 * The base type for DOWN_LEFT and SOUT_WEST calculations.  See other names that reference this variable in the See More.
	 * @see {@link #SOUTH_WEST}
	 */
	public static final EDirections DOWN_LEFT = EDirections.DOWN_LEFT;
	/**
	 * @see {@link #DOWN_LEFT}
	 */
	public static final EDirections SOUTH_WEST = DOWN_LEFT;

	/**
	 * The base type for UP_LEFT and NORTH_WEST calculations.  See other names that reference this variable in the See More.
	 * @see {@link #NORTH_WEST}
	 */
	public static final EDirections UP_LEFT= EDirections.UP_LEFT;
	/**
	 * @see {@link #UP_LEFT}
	 */
	public static final EDirections NORTH_WEST = UP_LEFT;

	/**
	 * The base type for DOWN_RIGHT and SOUTH_EAST calculations.  See other names that reference this variable in the See More.
	 * @see {@link #SOUTH_EAST}
	 */
	public static final EDirections DOWN_RIGHT = EDirections.DOWN_RIGHT;
	/**
	 * @see {@link #DOWN_RIGHT}
	 */
	public static final EDirections SOUTH_EAST = DOWN_RIGHT;
	
	private enum EDirections {
		LEFT, RIGHT, UP, DOWN, UP_LEFT, UP_RIGHT, DOWN_LEFT, DOWN_RIGHT;
	}
	
	private EDirectionsAdvancedDifferential() {}
}
