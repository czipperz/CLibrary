package com.czipperz.cLibrary.gui;

import javax.swing.*;
import java.awt.*;

public class CTransparentPanel extends JPanel {
	private static final long serialVersionUID = -4336911404271989190L;

	public CTransparentPanel() {
		this.setOpaque(false);
		this.setBackground(new Color(0, 0, 0, 0));
	}
}