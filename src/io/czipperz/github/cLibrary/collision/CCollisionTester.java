package io.czipperz.github.cLibrary.collision;

import io.czipperz.github.cLibrary.CMath;
import io.czipperz.github.cLibrary.util.collections.CArrayHelper;

import java.awt.geom.Point2D;

/**
 * @author czipperz on 4/9/15.
 */
final class CCollisionTester {
    private CCollisionTester() {}

    public static boolean isCollision(CCollision object1, int object1X = 0, int object1Y = 0, CCollision object2, int object2X, int object2Y) {
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
                    } catch(Exception e) {
                        e.printStackTrace();
                    }
                }
            } catch(Exception e) {
                e.printStackTrace();
            }
            return false;
        }
        //Else allign itself (then recall):
        else {
            boolean[][] allignedObject1 = object1.get();
            boolean[][] allignedObject2 = object2.get();
            if(object1X > object2X) {
                int x = distanceX;
                allignedObject2 = CArrayHelper.snip(object2.get(), x, object2.getLength() - x);
            } else {
                int x = -distanceX;
                allignedObject1 = CArrayHelper.snip(object2.get(), x, object2.getLength() - x);
            }

            if(object1Y > object2Y) {
                int y = distanceY;
                for(int i = 0; i < object1.getLength(); i++) {
                    allignedObject2[i] = CArrayHelper.snip(object2.get()[i], y, object2.getLength(i) - y);
                }
            } else {
                int y = -distanceY;
                for(int i = 0; i < object1.getLength(); i++) {
                    allignedObject1[i] = CArrayHelper.snip(object1.get()[i], y, object1.getLength(i) - y);
                }
            }

            return isCollision(new CCollision(allignedObject1), new CCollision(allignedObject2), 0, 0);
        }
    }

    public static boolean isCollision(CCollision object1, Point2D object1Loc, CCollision object2, Point2D object2Loc) {
        isCollision(object1, (int) object1Loc.x, (int) object1Loc.y, object2, (int) object2Loc.x, (int) object2Loc.y);
    }
}
