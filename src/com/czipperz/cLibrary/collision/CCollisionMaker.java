package com.czipperz.cLibrary.collision;

import com.czipperz.cLibrary.imaging.CImageHelper;

import java.awt.*;
import java.awt.image.RenderedImage;

/**
 * This class creates Collisions used by {@link CCollisionTester}.
 * @author Chris Gregory
 * @see {@link com.czipperz.cLibrary.collision.CCollision} - the collision class.
 * @see {@link CCollisionTester} - to test overlap between two CCollisions.
 */
public final class CCollisionMaker {
	private CCollisionMaker() {}
	/**
	 * This method creates a {@link com.czipperz.cLibrary.collision.CCollision} Object which can be used for collision testing, true means has substance (not the Color background), false means has no substance (the Color background).
	 * @author Chris Gregory
	 * @param image - the BufferedImage to make the array of boolean[][] from.
	 * @param background - the Color to test if the pixel is the background.
	 * @return Collision - true means has substance (not the Color background), false means has no substance (the Color background).
	 * @see {@link java.awt.image.BufferedImage}
	 * @see {@link java.awt.Color}
	 */
	public static CCollision getCollision(RenderedImage image, Color background) {
		Color[][] c = CImageHelper.getColorArray(image);
		boolean[][] result = new boolean[image.getWidth()][image.getHeight()];
		for(int x = 0; x < image.getWidth(); x++) {
			for(int y = 0; y < image.getWidth(); y++) {
				result[x][y] = true;
				if(c[x][y].equals(background) || c[x][y].getAlpha() == 0) {
					result[x][y] = false;
				}
			}
		}
		return new CCollision(result);
	}

	/**
	 * This method creates a {@link com.czipperz.cLibrary.collision.CCollision} Object which can be used for collision testing, true means has substance (not the Color background), false means has no substance (the Color background).
	 * @author Chris Gregory
	 * @param image - the BufferedImage to make the array of boolean[][] from.
	 * @param background - the Color[] to test if the pixel is the background. (all Colors in the Array are backgrounds.)
	 * @return Collision - true means has substance (not the Color background), false means has no substance (the Color background).
	 * @see {@link java.awt.image.BufferedImage}
	 * @see {@link java.awt.Color}
	 */
	public static CCollision getCollision(RenderedImage image, Color[] background) {
		Color[][] c = CImageHelper.getColorArray(image);
		boolean[][] result = new boolean[image.getWidth()][image.getHeight()];
		for(int x = 0; x < image.getWidth(); x++) {
			for(int y = 0; y < image.getWidth(); y++) {
				result[x][y] = true;
				for(int i = 0; i < background.length; i++) {
					if(c[x][y].equals(background[i]))
						result[x][y] = false;
				}
				if(c[x][y].getAlpha() == 0) {
					result[x][y] = false;
				}
			}
		}
		return new CCollision(result);
	}

	/**
	 * This method creates a {@link com.czipperz.cLibrary.collision.CCollision} Object which can be used for collision testing, true means has substance (not the Color background), false means has no substance (the Color background).
	 * @author Chris Gregory
	 * @param image - the BufferedImage to make the array of boolean[][] from.
	 * @param background - the Color[][] to test if the pixel is the background. (Overlay a Color[][] from another image to find the differences)
	 * @return Collision - true means has substance (not the Color background), false means has no substance (the Color background).
	 * @see {@link java.awt.image.BufferedImage}
	 * @see {@link java.awt.Color}
	 */
	public static CCollision getCollision(RenderedImage image, Color[][] background) {
		Color[][] c = CImageHelper.getColorArray(image);
		boolean[][] result = new boolean[image.getWidth()][image.getHeight()];
		for(int x = 0; x < image.getWidth(); x++) {
			for(int y = 0; y < image.getWidth(); y++) {
				result[x][y] = true;
				if(c[x][y].equals(background[x][y]) || c[x][y].getAlpha() == 0) {
					result[x][y] = false;
				}
			}
		}
		return new CCollision(result);
	}

	/**
	 * This method creates a {@link com.czipperz.cLibrary.collision.CCollision} Object that can be used for collision testing, true means has substance, false means has no substance.
	 * @param image - the BufferedImage to make the boolean[][] from.
	 * @return Collision - true means has substance (non-transparent), false means has no substance (transparent).
	 * @author Chris Gregory
	 * @see {@link java.awt.image.BufferedImage}
	 * @see {@link java.awt.Color}
	 */
	public static CCollision getCollision(RenderedImage image) {
		Color[][] c = CImageHelper.getColorArray(image);
		boolean[][] result = new boolean[image.getWidth()][image.getHeight()];
		for(int x = 0; x < image.getWidth(); x++) {
			for(int y = 0; y < image.getWidth(); y++) {
				result[x][y] = true;
				if(c[x][y].equals(c[x][y].getAlpha() == 0)) {
					result[x][y] = false;
				}
			}
		}
		return new CCollision(result);
	}
}
