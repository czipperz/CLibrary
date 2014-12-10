package com.czipperz.cLibrary.imaging;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Calendar;

public class CImageAnimated extends CImageBuffered {
	private BufferedImage[] images;
	private int index;
	private int msBS;
	private long time;

	public CImageAnimated(BufferedImage[] images, int startingIndex, int milisecondsBetweenSwitches, Rectangle locScreen, Rectangle locImage) {
		super(locScreen, locImage);
		this.images = images;
		this.index = startingIndex;
		this.msBS = milisecondsBetweenSwitches;
		this.time = Calendar.getInstance().getTimeInMillis();
	}

	public CImageAnimated(BufferedImage[] images, int milisecondsBetweenSwitches, Rectangle locScreen, Rectangle locImage) {
		this(images, 0, milisecondsBetweenSwitches, locScreen, locImage);
	}

	public BufferedImage getCurrentImage() {
		long t2 = Calendar.getInstance().getTimeInMillis();
		int t3 = (int) (t2 - time);
		synchronized(this) {
			int difs = (int)(t3/msBS);
			index += difs;
			while(index > images.length) {
				index -= images.length;
			}
			time += difs * msBS;
		}
		return images[index];
	}
	
	public BufferedImage[] getImages() {
		return images;
	}
	
	public CImageAnimated setImages(BufferedImage[] images) {
		this.images = images;
		return this;
	}
	
	public int getIndex() {
		return index;
	}
	
	public CImageAnimated setIndex(int index) {
		this.index = index;
		return this;
	}
	
	public int getMilisecondsBetweenSwitches() {
		return msBS;
	}
	
	public CImageAnimated setMilisecondsBetweenSwitches(int milisecondsBetweenSwitches) {
		this.msBS = milisecondsBetweenSwitches;
		return this;
	}
	
	public long getTime() {
		return time;
	}
}
