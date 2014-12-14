package com.czipperz.cLibrary.util;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.security.InvalidParameterException;

public class CColor {
	public static final CColor SKY_BLUE = new CColor(5, 238, 250);
	public static final CColor BLUE = new CColor(Color.BLUE);
	public static final CColor RED = new CColor(Color.RED);
	public static final CColor LIME = new CColor(Color.GREEN);
	public static final CColor YELLOW = new CColor(Color.YELLOW);
	public static final CColor PINK = new CColor(Color.PINK);
	public static final CColor MAGENTA = new CColor(Color.MAGENTA);
	public static final CColor BLACK = new CColor(Color.BLACK);
	public static final CColor CYAN = new CColor(Color.CYAN);
	public static final CColor DARK_GRAY = new CColor(Color.DARK_GRAY);
	public static final CColor LIGHT_GRAY = new CColor(Color.LIGHT_GRAY);
	public static final CColor GRAY = new CColor(Color.GRAY);
	public static final CColor WHITE = new CColor(Color.WHITE);
	public static final CColor DARK_PURPLE = new CColor(128, 0, 128, 255);
	public static final CColor PURPLE = new CColor(139, 0, 139, 255);
	public static final CColor DARK_BROWN = new CColor(139, 69, 19, 255);
	public static final CColor NAVY = new CColor(0, 0, 128, 255);
	public static final CColor SPRING_GREEN = new CColor(0, 225, 127, 255);
	public static final CColor GREEN = new CColor(0, 128, 0, 255);
	public static final CColor INDIGO = new CColor(75, 0, 130, 255);
	public static final CColor ORANGE = new CColor(255, 140, 0, 255);
	public static final CColor COFFEE = new CColor("C0FFEE");
	
	private int red, green, blue, alpha;
	
	public CColor() throws InvalidParameterException {
		this(255, 255, 255, 255);
	}

	public CColor(int red, int green, int blue) throws InvalidParameterException {
		this(red, green, blue, 255);
	}
	
	public CColor(int red, int green, int blue, int alpha) throws InvalidParameterException {
		if(red > 255 || red < 0) {
			throw new InvalidParameterException("Red value can't be " + red + ", must be within 0 and 255.");
		}
		if(green > 255 || green < 0) {
			throw new InvalidParameterException("Green value can't be " + green + ", must be within 0 and 255.");
		}
		if(blue > 255 || blue < 0) {
			throw new InvalidParameterException("Blue value can't be " + blue + ", must be within 0 and 255.");
		}
		if(alpha > 255 || alpha < 0) {
			throw new InvalidParameterException("Alpha value can't be " + alpha + ", must be within 0 and 255.");
		}
		this.red = red;
		this.green = green;
		this.blue = blue;
		this.alpha = alpha;
	}
	
	public CColor(Color c) throws InvalidParameterException {
		this(c.getRed(), c.getGreen(), c.getBlue(), c.getAlpha());
	}
	
	public CColor(CColor c) throws InvalidParameterException {
		this(c.getRed(), c.getGreen(), c.getBlue(), c.getAlpha());
	}

	public CColor(int rgb) throws InvalidParameterException {
		this(new Color(rgb));
	}

	public CColor(String string) {
		if(string.length() != 6 && string.length() != 8)
			throw new InvalidParameterException("String inputed: " + string + " must be of length 6 or 8");
		String r = string.substring(0, 2);
		red = Integer.parseInt(r, 16);
		String g = string.substring(2, 2);
		green = Integer.parseInt(g, 16);
		String b = string.substring(4, 2);
		blue = Integer.parseInt(b, 16);
		if(string.length() == 8) {
			String a = string.substring(6, 2);
			alpha = Integer.parseInt(a, 16);
		}
	}

	public int getGreen() {
		return green;
	}

	public void setGreen(int green) throws InvalidParameterException {
		if(green > 255 || green < 0) {
			throw new InvalidParameterException("Green value can't be " + green + ", must be within 0 and 255.");
		}
		this.green = green;
	}

	public int getBlue() {
		return blue;
	}

	public void setBlue(int blue) throws InvalidParameterException {
		if(blue > 255 || blue < 0) {
			throw new InvalidParameterException("Blue value can't be " + blue + ", must be within 0 and 255.");
		}
		this.blue = blue;
	}

	public int getAlpha() {
		return alpha;
	}

	public void setAlpha(int alpha) throws InvalidParameterException {
		if(alpha > 255 || alpha < 0) {
			throw new InvalidParameterException("Alpha value can't be " + alpha + ", must be within 0 and 255.");
		}
		this.alpha = alpha;
	}

	public int getRed() {
		return red;
	}

	public void setRed(int red) throws InvalidParameterException {
		if(red > 255 || red < 0) {
			throw new InvalidParameterException("Red value can't be " + red + ", must be within 0 and 255.");
		}
		this.red = red;
	}
	
	public void set(int rgb) throws InvalidParameterException {
		Color c = new Color(rgb);
		setRed(c.getRed());
		setGreen(c.getGreen());
		setBlue(c.getBlue());
		setAlpha(c.getAlpha());
	}
	
	public void set(Color c) throws InvalidParameterException {
		set(c.getRGB());
	}
	
	public void set(CColor c) throws InvalidParameterException {
		red = c.getRed();
		green = c.getGreen();
		blue = c.getBlue();
		alpha = c.getAlpha();
	}
	
	public CColor newRed(int red) throws InvalidParameterException {
		return new CColor(red, green, blue, alpha);
	}
	
	public CColor newGreen(int green) throws InvalidParameterException {
		return new CColor(red, green, blue, alpha);
	}
	
	public CColor newBlue(int blue) throws InvalidParameterException {
		return new CColor(red, green, blue, alpha);
	}
	
	public CColor newAlpha(int alpha) throws InvalidParameterException {
		return new CColor(red, green, blue, alpha);
	}
	
	public static CColor blendOver(CColor c, CColor d) {
		BufferedImage image = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
		Graphics g = image.getGraphics();
		Color a, b;
		boolean bo = c.alpha == 255 && d.alpha == 255;
		if(bo) {
			a = c.newAlpha(100).toColor();
			b = d.newAlpha(100).toColor();
		} else {
			a = c.toColor();
			b = d.toColor();
		}
		g.setColor(b);
		g.fillRect(0, 0, 1, 1);
		g.setColor(a);
		g.fillRect(0, 0, 1, 1);
		CColor co = new CColor(image.getRGB(0, 0));
		g.dispose();
		image.flush();
		if(bo) {
			return co.newAlpha(255);
		}
		return co;
	}
	
	public static CColor blendOver(Color c, Color d) {
		return blendOver(new CColor(c), new CColor(d));
	}
	
	/**
	 * Mixes the two CColors at the ratio given (applied to c, then 100 - ratio applied to d)
	 * @param c - the first CColor.
	 * @param d - the second CColor.
	 * @param ratio - the mixing rate of the CColors.  50 means average of both, 10 means c's values are mult. by 0.1 and added to d's values mult. by 0.9.
	 * @throws java.security.InvalidParameterException - if the ratio is > 100 or < 0.
	 * @return the resulting CColor.
	 */
	public static CColor mix(CColor c, CColor d, int ratio) throws InvalidParameterException {
		double rat = ((double) ratio) / 100.0;
		int r = (int)(c.red * rat + d.red * (100 - rat));
		int g = (int)(c.green * rat + d.green * (100 - rat));
		int b = (int)(c.blue * rat + d.blue * (100 - rat));
		int a = (int)(c.alpha * rat + d.alpha * (100 - rat));
		return new CColor(r, g, b, a);
	}
	
	/**
	 * Calls {@link #mix(CColor, CColor, int)} with the parameters c and d as CColors.
	 * @see #mix(CColor, CColor, int)
	 * @param c
	 * @param d
	 */
	public static CColor mix(Color c, Color d, int ratio) {
		return mix(new CColor(c), new CColor(d), ratio);
	}
	
	/**
	 * Calls {@link #mix(CColor, CColor, int)} with the parameters c, d, 50.
	 * @see #mix(CColor, CColor, int)
	 * @param c
	 * @param d
	 */
	public static CColor mix(CColor c, CColor d) {
		return mix(c, d, 50);
	}
	
	/**
	 * Calls {@link #mix(CColor, CColor)} with the parameters c and d as CColors.
	 * @param c
	 * @param d
	 * @see #mix(CColor, CColor)
	 * @see #mix(CColor, CColor, int)
	 */
	public static CColor mix(Color c, Color d) {
		return mix(new CColor(c), new CColor(d));
	}
	
	public Color toColor() {
		return new Color(red, green, blue, alpha);
	}
	
	public CColor clone() {
		return new CColor(this);
	}
}
