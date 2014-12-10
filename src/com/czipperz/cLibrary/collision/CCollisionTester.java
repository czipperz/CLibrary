package com.czipperz.cLibrary.collision;

import java.awt.Dimension;
import java.awt.geom.Point2D;

import com.czipperz.cLibrary.CStaticClass;
import com.czipperz.cLibrary.math.CMath;
import com.czipperz.cLibrary.util.collections.CArrayHelper;

/**
 * This class tests if your Entitys have collided.
 * @author Chris Gregory
 * @see {@link com.czipperz.cLibrary.collision.CCollision} - the collision class.
 * @see {@link com.czipperz.cLibrary.collision.CCollisionMaker} - to make a CCollision.
 */
public abstract class CCollisionTester {
	private CCollisionTester() {}
	/**
	 * This method provides a way to test if your Entitys have collided.
	 * @param object1 - the first object's CCollision map.
	 * @param object1x - the x location of the first object.
	 * @param object1y - the y location of the first object.
	 * @param object2 - the second object's CCollision map.
	 * @param object2x - the x location of the second object.
	 * @param object2y - the y location of the second object.
	 * @return true if there is <u>ANY</u> overlap of the two objects, false if there is <u>NONE</u>.
	 * @see com.czipperz.cLibrary.collision.CCollision
	 */
	public static boolean isCollision(final CCollision object1, final int object1x, final int object1y, final CCollision object2, final int object2x, final int object2y) {
		int distancex = object1x - object2x;
		int distancey = object1y - object2y;
		//If alligned:
		if(distancex == 0 && distancey == 0) {
			int[] w = new int[2];
			w[0] = object1.getLength(); w[1] = object2.getLength();
			int[] h = new int[2];
			h[0] = object1.getLength(0); h[1] = object2.getLength(0);
			
			int width = CMath.largestOf(w);
			int height = CMath.largestOf(h);
			try {
			for(int x = 0; x < width; x++) {
				try {
				for(int y = 0; y < height; y++) {
					if(object1.get()[x][y] && object2.get()[x][y]) {
						return true;
					}
				}
				} catch(Exception e) {}
			}
			} catch(Exception e) {}
			return false;
		}
		//Else allign itself (then recall):
		else {
			boolean[][] fo1 = object1.get();
			boolean[][] fo2 = object2.get();
			if(object1x > object2x) {
				int x = object1x - object2x;
				fo2 = CArrayHelper.snip(object2.get(), x, object2.getLength() - x);
			}
			else if(object1x < object2x) {
				int x = object2x - object1x;
				fo1 = CArrayHelper.snip(object2.get(), x, object2.getLength() - x);
			}
			if(object1y > object2y) {
				int y = object1y - object2y;
				for(int i = 0; i < object1.getLength(); i++) {
					fo2[i] = CArrayHelper.snip(object2.get()[i], y, object2.getLength(i) - y);
				}
			}
			else if(object1y < object2y) {
				int y = object2y - object1y;
				for(int i = 0; i < object1.getLength(); i++) {
					fo1[i] = CArrayHelper.snip(object1.get()[i], y, object1.getLength(i) - y);
				}
			}

			return isCollision(new CCollision(fo1), 0, 0, new CCollision(fo2), 0, 0);
		}
	}

	/**
	 * Restructures the <code>Point2D</code>s as ints and calls {@link #isCollision(com.czipperz.cLibrary.collision.CCollision, int, int, com.czipperz.cLibrary.collision.CCollision, int, int)}
	 */
	public static boolean isCollision(CCollision object1, Point2D object1Loc, CCollision object2, Point2D object2Loc) {
		return isCollision(object1, (int) object1Loc.getX(), (int) object2Loc.getY(), object2, (int) object2Loc.getX(), (int) object2Loc.getY());
	}
	
	/**
	 * Restructures the distance offsets as a point at 0, 0 and distancex, distancey and calls {@link #isCollision(com.czipperz.cLibrary.collision.CCollision, int, int, com.czipperz.cLibrary.collision.CCollision, int, int)}
	 */
	public static boolean isCollision(CCollision object1, CCollision object2, int distancex, int distancey) {
		return isCollision(object1, 0, 0, object2, distancex, distancey);
	}
	
	/**
	 * Restructures the Dimension offset as a point at 0, 0 and distance.width, distance.y and calls {@link #isCollision(com.czipperz.cLibrary.collision.CCollision, int, int, com.czipperz.cLibrary.collision.CCollision, int, int)}
	 */
	public static boolean isCollision(CCollision object1, CCollision object2, Dimension distance) {
		return isCollision(object1, object2, distance.width, distance.height);
	}
}
