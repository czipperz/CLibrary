package com.czipperz.cLibrary.imaging;

import com.czipperz.cLibrary.location.CRect;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class CImageUnanimated extends CImageBuffered {
	private BufferedImage image;
	
	public CImageUnanimated(BufferedImage image, Rectangle locScreen, Rectangle locImage) {
		super(locScreen, locImage);
		this.image = image;
	}
	
	public CImageUnanimated(File file, Rectangle locScreen, Rectangle locImage) {
		this(CImageBuffered.readImage(file), locScreen, locImage);
	}
	
	public CImageUnanimated(BufferedImage image, Point locScreen, Rectangle locImage) {
		this(image, new CRect(locScreen, image.getWidth(), image.getHeight()), locImage);
	}
	
	public CImageUnanimated(File file, Point locScreen, Rectangle locImage) {
		this(CImageBuffered.readImage(file), locScreen, locImage);
	}
	
	public CImageUnanimated(BufferedImage image, Point locScreen) {
		this(image, locScreen, new Rectangle(0, 0, image.getWidth(), image.getHeight()));
	}
	
	public CImageUnanimated(File file, Point locScreen) {
		this(CImageBuffered.readImage(file), locScreen);
	}

	public BufferedImage getCurrentImage() {
		return image;
	}
	
	public CImageUnanimated setImage(BufferedImage image) {
		this.image = image;
		return this;
	}
}
