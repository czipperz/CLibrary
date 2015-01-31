package com.czipperz.cLibrary.game;

public interface CUpdateAble {
	public default CUpdateAble updateBefore() {return this;}
	public CUpdateAble update();
	public default CUpdateAble updateAfter() {return this;}
}
