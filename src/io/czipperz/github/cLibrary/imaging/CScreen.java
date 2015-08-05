package io.czipperz.github.cLibrary.imaging;

import io.czipperz.github.cLibrary.location.CRect;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

/**
* @author czipperz on 4/8/15.
*/
public class CScreen {
	public static Dimension getSize() {
		return Toolkit.getDefaultToolkit().getScreenSize();
	}

	public static BufferedImage capture() throws AWTException {
		return new Robot().createScreenCapture(new CRect(0,0,size).toRectangle());
	}

	public static BufferedImage capture(JFrame frame) {
		BufferedImage bi = new BufferedImage(frame.width, frame.height, BufferedImage.TYPE_INT_ARGB);
		frame.paint(bi.graphics);
		return bi;
	}

	public static BufferedImage captureSave(String filePath, String extension = "png") throws IOException, AWTException {
		BufferedImage bi = capture();
		ImageIO.write(bi, extension, new File(filePath));
		return bi;
	}

	public static BufferedImage captureSave(String filePath, String extension = "png", JFrame frame) {
		BufferedImage bi = capture(frame);
		ImageIO.write(bi, extension, new File(filePath));
		return bi;
	}
}
