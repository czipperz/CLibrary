package com.czipperz.cLibrary.game;

import com.czipperz.cLibrary.imaging.CImage;

import java.awt.*;

public abstract class CEntitySubtype extends CObjectDrawWrapper {
	public CEntitySubtype(CGameFrame displayOn, CImage image) {
		super(displayOn, image);
	}
	
	public CEntitySubtype(CGameFrame displayOn, int depth, CImage image) {
		super(displayOn, depth, image);
	}

	public abstract Dimension getOffset();

	public abstract CEntitySubtype setOffset(Dimension offset);

	public boolean drawBeforeEntity() {
		return false;
	}
	
	public boolean drawAfterEntity() {
		return !drawBeforeEntity();
	}
}
