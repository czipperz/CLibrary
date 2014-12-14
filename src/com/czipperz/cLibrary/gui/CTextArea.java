package com.czipperz.cLibrary.gui;

import javax.swing.*;
import java.awt.*;

public class CTextArea extends JTextArea {
	private static final long serialVersionUID = 3321834594121643706L;
	private JScrollPane scroller;

	public CTextArea() {
		super();
	}

	public CTextArea setUpDefault() {
		this.setLineWrap(true);
		this.setWrapStyleWord(true);
		this.setEditable(false);

		return this;
	}

	public JScrollPane getScrollPane() {
		return scroller;
	}

	public CTextArea println(String s) {
		this.append(s + "\n");
		return this;
	}

	public CTextArea print(String s) {
		this.append(s);
		return this;
	}
	
	public CTextArea println(String s, Color c) {
		this.setForeground(c);
		return this.println(s);
	}
	
	public CTextArea print(String s, Color c) {
		this.setForeground(c);
		return this.print(s);
	}
}
