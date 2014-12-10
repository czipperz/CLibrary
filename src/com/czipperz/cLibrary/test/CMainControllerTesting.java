package com.czipperz.cLibrary.test;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Controller;
import org.lwjgl.input.Controllers;

public class CMainControllerTesting {
	public static void main(String[] args) {
		try {
			Controllers.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
		Controllers.poll();
		Controller c = Controllers.getController(0);
		while(true) {
			c.poll();
			System.out.println(c.getXAxisValue());
		}
	}
}
