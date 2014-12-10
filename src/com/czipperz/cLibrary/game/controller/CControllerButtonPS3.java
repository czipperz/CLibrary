package com.czipperz.cLibrary.game.controller;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import com.czipperz.cLibrary.game.CGameFrame;

public class CControllerButtonPS3 {
	private static BufferedImage buttonSquare = null, buttonTriangle = null, buttonCross = null, buttonCircle = null;
	private static BufferedImage dpadUp = null, dpadRight = null, dpadDown = null, dpadLeft = null;
	private static BufferedImage triggerRight = null, triggerLeft = null;
	private static String base = "sprites/PS3/";
	private static boolean setup = false;

	public static void setup() {
		if(setup) return;
		try {
			buttonSquare = ImageIO.read(new File(base + "button_Square.png"));
		} catch(Exception e) {
			e.printStackTrace();
		}
		try {
			buttonTriangle = ImageIO.read(new File(base + "button_Triangle.png"));
		} catch(Exception e) {
			e.printStackTrace();
		}
		try {
			buttonCross = ImageIO.read(new File(base + "button_cross.png"));
		} catch(Exception e) {
			e.printStackTrace();
		}
		try {
			buttonCircle = ImageIO.read(new File(base + "button_circle.png"));
		} catch(Exception e) {
			e.printStackTrace();
		}
		try {
			dpadUp = ImageIO.read(new File(base + "dpad_up.png"));
		} catch(Exception e) {
			e.printStackTrace();
		}
		try {
			dpadRight = ImageIO.read(new File(base + "dpad_right.png"));
		} catch(Exception e) {
			e.printStackTrace();
		}
		try {
			dpadDown = ImageIO.read(new File(base + "dpad_down.png"));
		} catch(Exception e) {
			e.printStackTrace();
		}
		try {
			dpadLeft = ImageIO.read(new File(base + "dpad_left.png"));
		} catch(Exception e) {
			e.printStackTrace();
		}
		try {
			triggerRight = ImageIO.read(new File(base + "trigger_right.png"));
		} catch(Exception e) {
			e.printStackTrace();
		}
		try {
			triggerLeft = ImageIO.read(new File(base + "trigger_left.png"));
		} catch(Exception e) {
			e.printStackTrace();
		}
		setup = true;
	}

	public static BufferedImage getButtonSquare() {
		setup();
		return buttonSquare;
	}

	public static BufferedImage getButtonTriangle() {
		setup();
		return buttonTriangle;
	}

	public static BufferedImage getButtonCross() {
		setup();
		return buttonCross;
	}

	public static BufferedImage getButtonCircle() {
		setup();
		return buttonCircle;
	}

	public static BufferedImage getDpadUp() {
		setup();
		return dpadUp;
	}

	public static BufferedImage getDpadRight() {
		setup();
		return dpadRight;
	}

	public static BufferedImage getDpadDown() {
		setup();
		return dpadDown;
	}

	public static BufferedImage getDpadLeft() {
		setup();
		return dpadLeft;
	}

	public static BufferedImage getTriggerRight() {
		setup();
		return triggerRight;
	}

	public static BufferedImage getTriggerLeft() {
		setup();
		return triggerLeft;
	}
}
