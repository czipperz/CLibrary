package com.czipperz.cLibrary.gui;

import javax.swing.*;
import java.awt.*;

/**
 * A JFrame that shows errors inputed by the user and exits (<code>JFrame.<!----->EXIT_ON_CLOSE</code>) on closing if instructed to.
 * @author Chris Gregory
 */
public class CErrorWindow {
	public CErrorWindow(Exception e, boolean exitOnClose) {
		JFrame frame = new JFrame();
		frame.setSize(600,300);
		if(exitOnClose) {
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		} else {
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}
		frame.setTitle("Error");
		frame.getContentPane().setBackground(Color.WHITE);

		CTextArea area = new CTextArea();
		area.setBackground(Color.WHITE);
		area.setForeground(Color.RED);
		area.setEditable(false);
		area.setLineWrap(true);
		area.setWrapStyleWord(true);
		
		area.println(e.getMessage());
		StackTraceElement[] ei = e.getStackTrace();
		for(StackTraceElement i : ei) {
			area.println(i.toString());
		}
		
		CScrollPane pane = new CScrollPane(area);
		pane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		pane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		pane.setAutoScroll(true);

		frame.getContentPane().add(pane);
		frame.setVisible(true);
	}

	public CErrorWindow(String message, boolean exitOnClose) {
		this(new Exception(message), exitOnClose);
	}
	
	public CErrorWindow(Exception e) {
		this(e, false);
	}
	
	public CErrorWindow(String message) {
		this(message, false);
	}
}
