package io.czipperz.github.cLibrary.collision

import io.czipperz.github.cLibrary.imaging.CImageHelper

import java.awt.Color
import java.awt.image.RenderedImage

/**
 * Created by czipperz on 4/9/15.
 */
final class CCollisionMaker {
	private CCollisionMaker() {}

	/**
	 * Makes a Collision
	 * @param image the image to create the
	 * @param test takes input int x, int y, Color controller and returns a boolean.
	 * Returns true if it should be in the background <br />
	 * Example: <code>{int x, int y, Color controller -> controller.equals(Color.WHITE)}</code>
	 * @return the CCollision object that it generates
	 */
	static CCollision getCollision(RenderedImage image, Closure<Boolean> test) {
		Color[][] c = CImageHelper.getColorArray(image)
		def result = new boolean[image.width][image.height]
		for(int x = 0; x < image.width; x++) {
			for(int y = 0; y < image.height; y++) {
				result[x][y] = c[x][y].getAlpha() == 0 || test(x, y, c[x][y])
			}
		}
		new CCollision(result)
	}
}
