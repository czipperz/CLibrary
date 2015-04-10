package io.czipperz.github.cLibrary.gui

import javax.swing.*
import java.awt.*

/**
 * Created by czipperz on 4/8/15.
 */
final class CJFrameHelper {
	private CJFrameHelper() {}

	static void setUpDefaultJFrame(JFrame frame) {
		frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
	}

	static void setUpDefaultJFrame(JFrame frame, int width, int height) {
		frame.setSize(width, height)
		setUpDefaultJFrame(frame)
	}

	static void setUpDefaultJFrame(JFrame frame, Dimension s) {
		setUpDefaultJFrame(frame, s.@width, s.@height)
	}

	static void setUnclosable(JFrame frame) {
		frame.defaultCloseOperation = JFrame.DO_NOTHING_ON_CLOSE
	}

	static void setUnclosable(JFrame frame, int sx, int sy) {
		frame.setSize(sx, sy)
		setUnclosable(frame)
	}

	static void setUnclosable(JFrame frame, Dimension s) {
		frame.setSize(s.@width, s.@height)
		setUnclosable(frame)
	}
}
