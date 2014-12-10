package com.czipperz.cLibrary.game.controller;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Controller;
import org.lwjgl.input.Controllers;

/**
 * To be able to use this class, you must have imported the .dll files and the JInput and LWJGL jars.
 * @author Chris Gregory
 *
 */
public class CControllersHandler {
	public static void pollAll() throws LWJGLException {
		Controllers.create();
		Controllers.poll();
	}

	public static Controller[] getControllers() throws LWJGLException {
		pollAll();
		int count = Controllers.getControllerCount();
		Controller[] controllers = new Controller[count];
		for(int i = 0; i < count; i++) {
			controllers[i] = Controllers.getController(i);
		}
		return controllers;
	}

	public static void runDisplay() throws LWJGLException {
		pollAll();
		for(int i = 0; i < Controllers.getControllerCount(); i++) {
			Controller c = Controllers.getController(i);
			System.out.println("Controller recognized. INDEX: " + c.getIndex() + ", NAME: " + c.getName());
		}
	}
}
