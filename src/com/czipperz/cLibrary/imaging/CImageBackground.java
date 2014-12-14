package com.czipperz.cLibrary.imaging;

import com.czipperz.cLibrary.game.CGameFrame;

import java.awt.*;

public class CImageBackground extends CImageDraw {
	private Color color;
	
	public CImageBackground(CGameFrame displayOn, Color color) {
		super(displayOn);
		this.color = color;
	}
	
	public CImageBackground draw(Graphics g) {
		g.setColor(color);
		g.fillRect(0, 0, getDisplayOn().getWidth(), getDisplayOn().getHeight());
		return this;
	}
	
	public CImageBackground drawVertex(Graphics g) {
		return draw(g);
	}

	public Rectangle getBounds() {
		return new Rectangle(0, 0, getDisplayOn().getWidth(), getDisplayOn().getHeight());
	}

	public static int getDefaultDepth() {
		return 2147483629;
	}

	public Color getCustomOutlineColor() {
		return Color.BLACK;
	}
}
