package com.czipperz.cLibrary.imaging;

import com.czipperz.cLibrary.game.CGameFrame;

import java.awt.*;

public abstract class CImageDraw extends CImage {
	private CGameFrame displayOn;
	
	public CImageDraw(CGameFrame displayOn) {
		this(displayOn, displayOn.getBounds());
	}
	
	public CImageDraw(CGameFrame displayOn, Rectangle locScreen) {
		super(locScreen);
		this.displayOn = displayOn;
	}

	public CGameFrame getDisplayOn() {
		return displayOn;
	}

	public CImageDraw setDisplayOn(CGameFrame displayOn) {
		this.displayOn = displayOn;
		return this;
	}
}
