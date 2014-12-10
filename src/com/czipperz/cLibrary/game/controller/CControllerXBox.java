package com.czipperz.cLibrary.game.controller;

import org.lwjgl.input.Controller;

public abstract class CControllerXBox extends CController {
	public static final int buttonX = 2, buttonY = 3, buttonA  = 0, buttonB = 1, buttonBack = 6;
	
	public CControllerXBox(Controller _c) {
		super(_c);
	}
	
	public synchronized boolean isXPressed() {
		return buttonPressed[buttonX];
	}
	
	public synchronized boolean isYPressed() {
		return buttonPressed[buttonY];
	}
	
	public synchronized boolean isAPressed() {
		return buttonPressed[buttonA];
	}
	
	public synchronized boolean isBPressed() {
		return buttonPressed[buttonB];
	}
	
	public synchronized boolean isBackPressed() {
		return buttonPressed[buttonBack];
	}
}
