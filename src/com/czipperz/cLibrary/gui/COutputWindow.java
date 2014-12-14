package com.czipperz.cLibrary.gui;

import javax.swing.*;
import java.awt.*;

public class COutputWindow {
	private JFrame frame;
	private CTextArea area;
	private CScrollPane pane;

	public COutputWindow() {
		this(true);
	}
	
	public COutputWindow(boolean visible) {
		this(false, visible);
	}
	
	public COutputWindow(boolean exitOnClose, boolean visible) {
		frame = new JFrame();
		frame.setSize(600,350);
		if(exitOnClose == true)
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		else
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setTitle("");
		frame.getContentPane().setBackground(Color.BLACK);
		
		area = new CTextArea();
		area.setBackground(Color.BLACK);
		area.setForeground(Color.WHITE);
		area.setEditable(false);
		area.setLineWrap(true);
		area.setWrapStyleWord(true);
		
		pane = new CScrollPane(area);
		pane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		pane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		pane.setAutoScroll(true);
		
		frame.setContentPane(pane);
		frame.setVisible(visible);
	}
	
	public JFrame getFrame() {
		return frame;
	}
	
	public COutputWindow setFrame(JFrame frame) {
		this.frame = frame;
		return this;
	}
	
	public CTextArea getTextArea() {
		return area;
	}
	
	public COutputWindow setTextArea(CTextArea textArea) {
		this.area = textArea;
		return this;
	}

	public COutputWindow print(String s) {
		area.print(s);
		return this;
	}

	public COutputWindow println(String s) {
		area.println(s);
		return this;
	}
}
