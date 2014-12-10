package com.czipperz.cLibrary.imaging;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class CScreen {
	public static Dimension getSize() {
		return Toolkit.getDefaultToolkit().getScreenSize();
	}
	
	public static BufferedImage capture() throws AWTException {
		return new Robot().createScreenCapture(new Rectangle(0, 0, getSize().width, getSize().height));
	}
	
	public static BufferedImage capture(JFrame frame) {
		BufferedImage bI = new BufferedImage(frame.getWidth(), frame.getHeight(), BufferedImage.TYPE_INT_ARGB);
		frame.paint(bI.getGraphics());
		return bI;
	}
	
	public static BufferedImage captureSave(String filePath) throws IOException, AWTException {
		BufferedImage c = capture();
		ImageIO.write(c, "png", new File(filePath));
		return c;
	}
	
	public static BufferedImage captureSave(String filePath, String extension) throws IOException, AWTException {
		BufferedImage c = capture();
		ImageIO.write(c, extension, new File(filePath));
		return c;
	}
	
	public static void captureSave(final long timeLater, final String filePath) {
		new Thread(new Runnable() {
			public void run() {
				try {
					Thread.sleep(timeLater);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				try {
					captureSave(filePath);
				} catch (IOException e) {
					e.printStackTrace();
				} catch (AWTException e) {
					e.printStackTrace();
				}
			}
		}).start();
	}
	
	public static void captureSave(final long timeLater, final String filePath, final String extension) {
		new Thread(new Runnable() {
			public void run() {
				try {
					Thread.sleep(timeLater);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				try {
					captureSave(filePath, extension);
				} catch (IOException e) {
					e.printStackTrace();
				} catch (AWTException e) {
					e.printStackTrace();
				}
			}
		}).start();
	}
	
	public static BufferedImage captureSave(String filePath, JFrame frame) throws IOException, AWTException {
		BufferedImage c = capture(frame);
		ImageIO.write(c, "png", new File(filePath));
		return c;
	}
	
	public static BufferedImage captureSave(String filePath, String extension, JFrame frame) throws IOException, AWTException {
		BufferedImage c = capture(frame);
		ImageIO.write(c, extension, new File(filePath));
		return c;
	}
	
	public static void captureSave(final long timeLater, final String filePath, final JFrame frame) {
		new Thread(new Runnable() {
			public void run() {
				try {
					Thread.sleep(timeLater);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				try {
					captureSave(filePath, frame);
				} catch (IOException e) {
					e.printStackTrace();
				} catch (AWTException e) {
					e.printStackTrace();
				}
			}
		}).start();
	}
	
	public static void captureSave(final long timeLater, final String filePath, final String extension, final JFrame frame) {
		new Thread(new Runnable() {
			public void run() {
				try {
					Thread.sleep(timeLater);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				try {
					captureSave(filePath, extension, frame);
				} catch (IOException e) {
					e.printStackTrace();
				} catch (AWTException e) {
					e.printStackTrace();
				}
			}
		}).start();
	}
}
