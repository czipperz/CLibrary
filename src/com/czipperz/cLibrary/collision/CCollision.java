package com.czipperz.cLibrary.collision;

import java.io.Serializable;


/**
 * A class that contains the information needed to test Collisions of GameObjects.
 * <br />The <u>mutator methods are UNAVAILABLE</u> to classes outside the package (<code>default</code> not <code>public</code>)
 * @author Chris Gregory
 * @see {@link CCollisionMaker} - to make a CCollision.
 * @see {@link CCollisionTester} - to test overlap between two CCollisions.
 */
public class CCollision implements Serializable {
	private boolean[][] stat;

	/**
	 * The default constructor for Collisions.  DO NOT MAKE A COLLISION YOURSELF, ALWAYS CALL com.czipperz.helpers.collisionHelpers.CollisionMaker.getCollision(BufferedImage, Background).
	 * @author Chris Gregory
	 */
	CCollision() {}

	/**
	 * The constructor used by {@link CCollisionMaker}.  DO NOT MAKE A COLLISION YOURSELF, ALWAYS CALL com.czipperz.helpers.collisionHelpers.CollisionMaker.getCollision(BufferedImage, Background).
	 * @see {@link CCollisionMaker#getCollision(java.awt.image.RenderedImage)}
	 * @see {@link CCollisionMaker#getCollision(java.awt.image.RenderedImage, java.awt.Color)}
	 * @see {@link CCollisionMaker#getCollision(java.awt.image.RenderedImage, java.awt.Color[])}
	 * @see {@link CCollisionMaker#getCollision(java.awt.image.RenderedImage, java.awt.Color[][])}
	 * @param b - the boolean[][] for this instance of Collision to hold
	 * @author Chris Gregory
	 */
	CCollision(boolean[][] b) {
		stat = b;
	}
	
	/**
	 * Makes a clone of the other {@link CCollision}.
	 * @param c - the other CCollision to clone.
	 */
	public CCollision(CCollision c) {
		stat = c.get().clone();
	}

	/**
	 * Returns the boolean[][] for Collision Testing.  DO NOT USE YOURSELF, ALWAYS CALL THROW com.czipperz.helpers.collisionHelpers.CollisionTester.isCollision(GameObject, GameObject).
	 * @return b - the boolean[][] this instance of Collision holds
	 * @author Chris Gregory
	 */
	public boolean[][] get() {
		return stat;
	}

	/**
	 * Returns the length of the boolean[][].
	 * @return l - the length of the boolean[][] this instance of Collision holds
	 * @author Chris Gregory
	 */
	public int getLength() {
		return stat.length;
	}

	/**
	 * Returns the length of the boolean[] at position i of the boolean[][].
	 * @param i - the indicator of the boolean[] to recieve the length of
	 * @return l - the length of the boolean[] at position i of the boolean[][] this instance of Collision holds
	 * @author Chris Gregory
	 */
	public int getLength(int i) {
		try {
			return stat[i].length;
		} catch(Exception e) {
			return stat[0].length;
		}
	}

	/**
	 * Sets the Collision's boolean[][] to b.  DO NOT USE.
	 * @param b - what the boolean[][] this instance of Collision holds will be set to
	 * @author Chris Gregory
	 */
	protected void set(boolean[][] b) {
		stat = b;
	}

	/**
	 * Sets an individual part of the boolean[][] to the value. DO NOT USE.
	 * @param x - the x location to set the value b
	 * @param y - the y location to set the value b
	 * @param b - the value to set at location (x, y)
	 * @author Chris Gregory
	 */
	protected void set(int x, int y, boolean b) {
		try {
			stat[x][y] = b;
		} catch(Exception e) {}
	}
	
	public CCollision clone() {
		return new CCollision(this);
	}
}
