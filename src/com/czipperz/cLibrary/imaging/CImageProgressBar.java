package com.czipperz.cLibrary.imaging;

import com.czipperz.cLibrary.game.CGameFrame;

import java.awt.*;

public class CImageProgressBar extends CImageDraw {
	private boolean vertical;
	private Color foreground, background;
	private int current, max;
	private Rectangle locScreen;
	private Dimension offset;

	public final static Color foregroundHealth = new Color(206, 0, 31);
	public final static Color backgroundHealth = new Color(117, 0, 18);
	public final static Color foregroundMana = new Color(62, 59, 255);
	public final static Color backgroundMana = new Color(36, 34, 148);
	public final static Color foregroundHealthPoisoned = new Color(97, 191, 38);
	public final static Color backgroundHealthPoisoned = new Color(59, 117, 23);
	public final static Color foregroundYellow = new Color(255, 229, 0);
	public final static Color backgroundYellow = new Color(130, 117, 0);

	public enum EProgressBarColorTypes {
		TYPE_HEALTH(foregroundHealth, backgroundHealth),
		TYPE_MANA(foregroundMana, backgroundMana),
		TYPE_HEALTH_POISONED(foregroundHealthPoisoned, backgroundHealthPoisoned),
		TYPE_YELLOW(foregroundYellow, backgroundYellow);

		private Color fore, back;

		private EProgressBarColorTypes(Color fore, Color back) {
			this.fore = fore;
			this.back = back;
		}

		public Color getForeground() {
			return fore;
		}

		public Color getBackground() {
			return back;
		}
	}

	public CImageProgressBar(CGameFrame displayOn, Color foreground, Color background, int currentStat, int maximumStat, boolean vertical, Rectangle locScreen) {
		super(displayOn);
		this.foreground = foreground;
		this.background = background;
		this.current = currentStat;
		this.max = maximumStat;
		this.vertical = vertical;
		this.locScreen = locScreen;
		this.offset = new Dimension(0, -10);
	}

	public CImageProgressBar(CGameFrame displayOn, Color foreground, Color background, int currentStat, int maximumStat, Rectangle locScreen) {
		this(displayOn, foreground, background, currentStat, maximumStat, false, locScreen);
	}

	public CImageProgressBar(CGameFrame displayOn, EProgressBarColorTypes color, int currentStat, int maximumStat, boolean vertical, Rectangle locScreen) {
		this(displayOn, color.getForeground(), color.getBackground(), currentStat, maximumStat, vertical, locScreen);
	}

	public CImageProgressBar(CGameFrame displayOn, EProgressBarColorTypes color, int currentStat, int maximumStat, Rectangle locScreen) {
		this(displayOn, color, currentStat, maximumStat, false, locScreen);
	}

	public CImageProgressBar draw(Graphics g) {
		if(!vertical) {
			//Creates a black border one pixel thick
			g.setColor(Color.BLACK);
			g.drawRect(locScreen.x, locScreen.y, locScreen.width, locScreen.height);
			g.setColor(background);
			g.fillRect(locScreen.x + 1, locScreen.y + 1, locScreen.width - 1, locScreen.height - 1);
			//Draws the percentage
			g.setColor(foreground);
			g.fillRect(locScreen.x + 1, locScreen.y + 1, (current * locScreen.width / max) - 1, locScreen.height - 1);
		}
		//Draws if vertical
		else if(vertical) {
			//Creates a black border one pixel thick
			g.setColor(Color.BLACK);
			g.drawRect(locScreen.x, locScreen.y, locScreen.width, locScreen.height);
			g.setColor(background);
			g.fillRect(locScreen.x + 1, locScreen.y + 1, locScreen.width - 1, locScreen.height - 1);
			//Draws the percentage
			g.setColor(foreground);
			g.fillRect(locScreen.x + 1, locScreen.y + 1 + locScreen.height - (current * locScreen.height / max), locScreen.width - 1, (current * locScreen.height / max) - 1);
		}
		return this;
	}
	
	public Rectangle getBounds() {
		return locScreen;
	}

	public boolean needUpdate() {
		return true;
	}

	public boolean isVertical() {
		return vertical;
	}

	public CImageProgressBar setVertical(boolean vertical) {
		this.vertical = vertical;
		return this;
	}

	public Color getForeground() {
		return foreground;
	}

	public CImageProgressBar setForeground(Color foreground) {
		this.foreground = foreground;
		return this;
	}

	public Color getBackground() {
		return background;
	}

	public CImageProgressBar setBackground(Color background) {
		this.background = background;
		return this;
	}

	public int getCurrent() {
		return current;
	}

	public CImageProgressBar setCurrent(int currentStat) {
		this.current = currentStat;
		return this;
	}

	public int getMax() {
		return max;
	}

	public CImageProgressBar setMax(int maximumStat) {
		this.max = maximumStat;
		return this;
	}

	public Dimension getOffset() {
		return offset;
	}

	public CImageProgressBar setOffset(Dimension offset) {
		this.offset = offset;
		return this;
	}
	
	public Color getCustomOutlineColor() {
		return Color.RED;
	}
}
