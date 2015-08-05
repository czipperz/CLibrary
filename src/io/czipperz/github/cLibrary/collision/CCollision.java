package io.czipperz.github.cLibrary.collision;

import io.czipperz.github.cLibrary.functionalInterfaces.PredicateTriple;
import io.czipperz.github.cLibrary.imaging.CImageHelper;

import java.awt.Color;
import java.awt.image.RenderedImage;

/**
 * @author czipperz on 4/9/15.
 */
public final class CCollision implements Serializable {
    private boolean[][] stat;

    /**
     * Makes a Collision
     * @param image the image to create the
     * @param test takes input int x, int y, Color controller and returns a boolean.
     * Returns true if it should be in the background <br />
     * Example in Groovy: <code>&#123;int x, int y, Color c -> c == Color.WHITE&#125;</code><br />
     * Example in Java: <code>(int x, int y, Color c) -> c.equals(Color.WHITE);</code>
     * @return the CCollision object that it generates
     */
    public CCollision(RenderedImage image, PredicateTriple<Integer, Integer, Color> test) {
        Color[][] c = CImageHelper.getColorArray(image);
        boolean[][] result = new boolean[image.width][image.height];
        for(int x = 0; x < image.width; x++) {
            for(int y = 0; y < image.height; y++) {
                result[x][y] = c[x][y].getAlpha() == 0 || test.test(x, y, c[x][y]);
            }
        }
        stat = result;
    }

    private CCollision() {}

    public boolean[][] get() {
        return stat;
    }

    public int getLength() {
        return stat.length;
    }

    public int getLength(int i) {
        try {
            return stat[i].length;
        } catch(IndexOutOfBoundsException ignored) {
            return stat[0].length;
        }
    }

    protected void set(boolean[][] b) {
        stat = b;
    }

    protected void set(int x, int y, boolean b) {
        stat[x][y] = b;
    }

    public CCollision clone() {
        CCollision asdf = new CCollision();
        asdf.stat = stat.clone();
        return asdf;
    }
}
