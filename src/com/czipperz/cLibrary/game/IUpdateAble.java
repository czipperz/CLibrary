package com.czipperz.cLibrary.game;

public interface IUpdateAble {
	public default IUpdateAble updateBefore() {return this;}
	public IUpdateAble update();
	public default IUpdateAble updateAfter() {return this;}
}
