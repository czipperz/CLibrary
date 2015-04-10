package io.github.czipperz.cLibrary.imaging

import java.awt.Color
import java.awt.Graphics2D
import java.awt.geom.AffineTransform
import java.awt.image.BufferedImage
import java.awt.image.ColorModel
import java.awt.image.RenderedImage
import java.awt.image.WritableRaster

/**
 * Created by czipperz on 4/9/15.
 */
final class CImageHelper {
	private CImageHelper() {}

	/**
	 * Rotates the given image by the angle given.
	 * @param image
	 * @param angleDegrees - the angle in degrees
	 * @return the rotated image.
	 */
	public static BufferedImage rotateImageDegrees(BufferedImage image, double angleDegrees) {
		if(angleDegrees % 360 == 0)
			return image;
		return rotateImageRadians(image, Math.toRadians(angleDegrees));
	}

	/**
	 * Rotates the given image by the angle given.
	 * @param image
	 * @param angleRadians - the angle in radians
	 * @return the rotated image.
	 */
	public static BufferedImage rotateImageRadians(BufferedImage image, double angleRadians) {
		if(Math.toDegrees(angleRadians) % 360.0 == 0.0)
			return image;
		int w = image.getWidth();
		int h = image.getHeight();
		int type = image.getType();

		BufferedImage daImage = new BufferedImage((int) (w * 2), (int) (h * 2), type);
		Graphics2D g = daImage.createGraphics();

		double x = (h - w)/2;
		double y = (w - h)/2;
		AffineTransform at = AffineTransform.getTranslateInstance(x + w / 4, y + h / 4);

		at.rotate(angleRadians, w/3.0, h/3.0);
		g.drawImage(image, at, null);
		g.dispose();

		return daImage;
	}

	public static BufferedImage toBufferedImage(RenderedImage image) {
		if(image instanceof BufferedImage) {
			return (BufferedImage) image;
		}
		ColorModel cm = image.getColorModel();
		int width = image.getWidth();
		int height = image.getHeight();
		WritableRaster raster = cm.createCompatibleWritableRaster(width, height);
		boolean isAlphaPremultiplied = cm.isAlphaPremultiplied();
		Hashtable<String, Object> properties = new Hashtable<String, Object>();
		String[] keys = image.getPropertyNames();
		if(keys != null) {
			for(int i = 0; i < keys.length; i++) {
				properties.put(keys[i], image.getProperty(keys[i]));
			}
		}
		BufferedImage result = new BufferedImage(cm, raster, isAlphaPremultiplied, properties);
		image.copyData(raster);
		return result;
	}

	public static BufferedImage[] toBufferedImage(RenderedImage[] images) {
		BufferedImage[] result = new BufferedImage[images.length];
		for(int i = 0; i < result.length; i++) {
			result[i] = toBufferedImage(images[i]);
		}
		return result;
	}

	/**
	 * This method creates a 2D array of Color[][] which can be used for pixel testing and/or manipulation.
	 *
	 * @author Chris Gregory
	 * @param image - the BufferedImage to make the array of Color[][] from.
	 * @return Color[][] - each pixel is accounted for at c[x][y]
	 * @see java.awt.image.BufferedImage
	 * @see java.awt.Color
	 */
	public static Color[][] getColorArray(RenderedImage image) {
		int w = image.getWidth();
		int h = image.getHeight();
		Color[][] s = new Color[w][h];
		BufferedImage bi = toBufferedImage(image)
		for(int x = 0; x < image.getWidth(); x++) {
			for(int y = 0; y < image.getHeight(); y++) {
				s[x][y] = new Color(bi.getRGB(x,y))
			}
		}
		return s;
	}

	/**
	 * This method gets the Color of a pixel at x, y in the BufferedImage.
	 *
	 * @author Chris Gregory
	 * @param image - this must be a BufferedImage {@link #toBufferedImage(RenderedImage)}
	 * @param x the x coordinate to get the image
	 * @param y the y coordinate to get the image
	 * @return Color - the Color the pixel displays
	 */
	public static Color getPixel(BufferedImage image, int x, int y) {
		return new Color(toBufferedImage(image).getRGB(x,y));
	}
}
