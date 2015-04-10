package io.czipperz.github.cLibrary.imaging

import io.czipperz.github.cLibrary.location.CRect

import javax.imageio.ImageIO
import javax.swing.JFrame
import java.awt.AWTException
import java.awt.Dimension
import java.awt.Robot
import java.awt.Toolkit
import java.awt.image.BufferedImage

/**
 * Created by czipperz on 4/8/15.
 */
class CScreen {
	static Dimension getSize() {
		return Toolkit.getDefaultToolkit().getScreenSize()
	}

	static BufferedImage capture() throws AWTException {
		return new Robot().createScreenCapture(new CRect(0,0,size).toRectangle())
	}

	static BufferedImage capture(JFrame frame) {
		def bi = new BufferedImage(frame.width, frame.height, BufferedImage.TYPE_INT_ARGB)
		frame.paint(bi.graphics)
		bi
	}

	static BufferedImage captureSave(String filePath, String extension = "png") throws IOException, AWTException {
		def bi = capture()
		ImageIO.write(bi, extension, new File(filePath))
		bi
	}

	static BufferedImage captureSave(String filePath, String extension = "png", JFrame frame) {
		def bi = capture(frame)
		ImageIO.write(bi, extension, new File(filePath))
		bi
	}
}
