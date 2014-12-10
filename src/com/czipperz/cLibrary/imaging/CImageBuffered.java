package com.czipperz.cLibrary.imaging;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public abstract class CImageBuffered extends CImage {
	private Rectangle locImage;
	
	public CImageBuffered(Rectangle locScreen, Rectangle locImage) {
		super(locScreen);
		this.locImage = locImage;
	}
	
	public abstract BufferedImage getCurrentImage();
	
	public Rectangle getLocImage() {
		return locImage;
	}
	
	public CImage setLocImage(Rectangle locImage) {
		this.locImage = locImage;
		return this;
	}

	public CImage draw(Graphics g) {
		g.drawImage(getCurrentImage(), getLocScreen().x, getLocScreen().y, getLocScreen().x + getLocScreen().width, getLocScreen().y + getLocScreen().height, locImage.x, locImage.y, locImage.x + locImage.width, locImage.y + locImage.height, null);
		return this;
	}

	public static BufferedImage readImage(File file) {
		try {
			BufferedImage image = ImageIO.read(file);
			return image;
		} catch (IOException e) {
			throw new RuntimeException("Exception of class " + e.getClass().getName() + " (IOException,) Message: " + e.getMessage());
		}
	}
	
	public Color getCustomOutlineColor() {
		return Color.GREEN;
	}
}
