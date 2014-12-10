package com.czipperz.cLibrary.game.directions;

/**
 * This is a class that has an embedded enum.  Use one of the other variables to test against.
 * <br /><strong>NOTE:</strong> <code>LEFT</code> IS NOT EQUAL TO <code>RIGHT</code>, <strong>but</strong> <code>LEFT</code> IS EQUAL TO <code>WEST</code>.
 * @author Chris Gregory
 * @see {@link #LEFT}
 * @see {@link #RIGHT}
 * @see {@link #UP}
 * @see {@link #DOWN}
 * @see {@link com.czipperz.cLibrary.game.directions.EDirectionsBasic} for variables where LEFT == RIGHT
 */
public class EDirectionsBasicDifferential {
	/**
	 * The base type for LEFT or WEST calculations.  See other names that reference this variable in See More.
	 * @see #WEST
	 */
	public static final EDirections LEFT = EDirections.LEFT;
	/**
	 * @see #LEFT
	 */
	public static final EDirections WEST = LEFT;

	/**
	 * The base type for RIGHT or EAST calculations.  See other names that reference this variable in See More.
	 * @see #RIGHT
	 */
	public static final EDirections RIGHT = EDirections.RIGHT;
	/**
	 * @see #RIGHT
	 */
	public static final EDirections EAST = RIGHT;

	/**
	 * The base type for UP or NORTH calculations.  See other names that reference this variable in See More.
	 * @see #NORTH
	 */
	public static final EDirections UP = EDirections.UP;
	/**
	 * @see #UP
	 */
	public static final EDirections NORTH = UP;
	
	/**
	 * The base type for DOWN or SOUTH calculations.  See other names that reference this variable in See More.
	 * @see #SOUTH
	 */
	public static final EDirections DOWN = EDirections.DOWN;
	/**
	 * @see #DOWN
	 */
	public static final EDirections SOUTH = DOWN;

	private enum EDirections {
		LEFT, RIGHT, UP, DOWN;
	}
	
	private EDirectionsBasicDifferential() {}
}
