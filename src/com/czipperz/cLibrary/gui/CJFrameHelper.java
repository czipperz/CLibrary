package com.czipperz.cLibrary.gui;

import java.awt.Dimension;

import javax.swing.JFrame;

import com.czipperz.cLibrary.CStaticClass;

/**
 * These methods set up the JFrame in a particular manner but DOES NOT MAKE IT VISIBLE.
 * @author Chris
 */
public final class CJFrameHelper {
	private CJFrameHelper() {}
	
	public static void setUpDefaultJFrame(JFrame frame, int sx, int sy) {
		frame.setSize(sx, sy);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void setUpDefaultJFrame(JFrame frame, Dimension s) {
		frame.setSize(s.width, s.height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void setUpDefaultJFrame(JFrame frame) {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void setUnclosable(JFrame frame, int sx, int sy) {
		frame.setSize(sx, sy);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	}
	
	public static void setUnclosable(JFrame frame, Dimension s) {
		frame.setSize(s.width, s.height);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	}

	public static void setUnclosable(JFrame frame) {
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	}
	
	public String toString() {
		return "A JFrameHelper";
	}
}