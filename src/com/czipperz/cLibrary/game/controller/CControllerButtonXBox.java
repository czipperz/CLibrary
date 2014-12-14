package com.czipperz.cLibrary.game.controller;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class CControllerButtonXBox {
	private static BufferedImage buttonX = null, buttonY = null, buttonA = null, buttonB = null;
	private static BufferedImage dpadUp = null, dpadRight = null, dpadDown = null, dpadLeft = null;
	private static BufferedImage triggerRight = null, triggerLeft = null;
	private static String base = "C:/Users/" + "Chris Gregory" + "/workspace/CLibrary/sprites/XBox/";

	public static void setup() {
		boolean finished = false;
		while(!finished)
			while(true) {
				try {
					finished = true;
					buttonX = ImageIO.read(new File(base + "button_x.png"));
					buttonY = ImageIO.read(new File(base + "button_y.png"));
					buttonA = ImageIO.read(new File(base + "button_a.png"));
					buttonB = ImageIO.read(new File(base + "button_b.png"));
					dpadUp = ImageIO.read(new File(base + "dpad_up.png"));
					dpadRight = ImageIO.read(new File(base + "dpad_right.png"));
					dpadDown = ImageIO.read(new File(base + "dpad_down.png"));
					dpadLeft = ImageIO.read(new File(base + "dpad_left.png"));
					triggerRight = ImageIO.read(new File(base + "trigger_right.png"));
					triggerLeft = ImageIO.read(new File(base + "trigger_left.png"));
				} catch(Exception e) {
					e.printStackTrace();
				}
				finished = true;
				break;
			}
	}

	public static BufferedImage getButtonX() {
		setup();
		return buttonX;
	}

	public static BufferedImage getButtonY() {
		setup();
		return buttonY;
	}

	public static BufferedImage getButtonA() {
		setup();
		return buttonA;
	}

	public static BufferedImage getButtonB() {
		setup();
		return buttonB;
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
