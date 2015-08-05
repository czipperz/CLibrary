package io.czipperz.github.cLibrary.imaging;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.RenderedImage;
import java.awt.image.WritableRaster;

/**
 * @author czipperz 
 */
public final class CImageHelper {
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
     * @author czipperz
     * @param image - the BufferedImage to make the array of Color[][] from.
     * @return Color[][] - each pixel is accounted for at c[x][y]
     * @see java.awt.image.BufferedImage
     * @see java.awt.Color
     */
    public static Color[][] getColorArray(RenderedImage image) {
        int w = image.getWidth();
        int h = image.getHeight();
        Color[][] s = new Color[w][h];
        for(int x = 0; x < image.getWidth(); x++) {
            for(int y = 0; y < image.getHeight(); y++) {
                s[x][y] = getPixel(image, x, y);
            }
        }
        return s;
    }

    /**
     * This method gets the Color of a pixel at x, y in the BufferedImage.
     *
     * @author czipperz
     * @param BufferedImage image
     * @param int x - the x coordinate to get the image
     * @param int y - the y coordinate to get the image
     * @return Color - the Color the pixel displays
     */
    public static Color getPixel(RenderedImage image, int x, int y) {
        int color = toBufferedImage(image).getRGB(x, y);

        int  red = (color & 0x00ff0000) >> 16;
        int  green = (color & 0x0000ff00) >> 8;
        int  blue = color & 0x000000ff;
        int alpha = (color >> 24) & 0xff;
        return new Color(red, green, blue, alpha);
    }

    public static BufferedImage readFile(File f) {
        try {
            return ImageIO.read(f);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean write(RenderedImage image, File f, String extension) {
        try {
            ImageIO.write(image, extension, f);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean writePNG(RenderedImage image, File f) {
        return write(image, f, "png");
    }

    public static boolean writeGIF(RenderedImage image, File f) {
        return write(image, f, "gif");
    }

    public static boolean writeJPG(RenderedImage image, File f) {
        return write(image, f, "jpg");
    }
}
