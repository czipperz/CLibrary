package com.czipperz.cLibrary.collision;

import com.czipperz.cLibrary.CMath;
import com.czipperz.cLibrary.util.collections.CArrayHelper;

import java.awt.*;
import java.awt.geom.Point2D;

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
	 * @param object1X - the x location of the first object.
	 * @param object1Y - the y location of the first object.
	 * @param object2 - the second object's CCollision map.
	 * @param object2X - the x location of the second object.
	 * @param object2Y - the y location of the second object.
	 * @return true if there is <u>ANY</u> overlap of the two objects, false if there is <u>NONE</u>.
	 * @see com.czipperz.cLibrary.collision.CCollision
	 */
	public static boolean isCollision(final CCollision object1, final int object1X, final int object1Y, final CCollision object2, final int object2X, final int object2Y) {
		int distanceX = object1X - object2X;
		int distanceY = object1Y - object2Y;
		//If alligned:
		if(distanceX == 0 && distanceY == 0) {
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
			boolean[][] allignedObject1 = object1.get();
			boolean[][] allignedObject2 = object2.get();
			if(object1X > object2X) {
				int x = object1X - object2X;
				allignedObject2 = CArrayHelper.snip(object2.get(), x, object2.getLength() - x);
			}
			else if(object1X < object2X) {
				int x = object2X - object1X;
				allignedObject1 = CArrayHelper.snip(object2.get(), x, object2.getLength() - x);
			}
			if(object1Y > object2Y) {
				int y = object1Y - object2Y;
				for(int i = 0; i < object1.getLength(); i++) {
					allignedObject2[i] = CArrayHelper.snip(object2.get()[i], y, object2.getLength(i) - y);
				}
			}
			else if(object1Y < object2Y) {
				int y = object2Y - object1Y;
				for(int i = 0; i < object1.getLength(); i++) {
					allignedObject1[i] = CArrayHelper.snip(object1.get()[i], y, object1.getLength(i) - y);
				}
			}

			return isCollision(new CCollision(allignedObject1), 0, 0, new CCollision(allignedObject2), 0, 0);
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
	public static boolean isCollision(CCollision object1, CCollision object2, Dimension offset) {
		return isCollision(object1, object2, offset.width, offset.height);
	}
}
