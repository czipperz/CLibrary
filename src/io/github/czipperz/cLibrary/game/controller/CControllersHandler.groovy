package io.github.czipperz.cLibrary.game.controller

import org.lwjgl.LWJGLException
import org.lwjgl.input.Controller
import org.lwjgl.input.Controllers

/**
 * Created by czipperz on 4/9/15.
 */
class CControllersHandler {
	static void pollAll() throws LWJGLException {
		Controllers.poll()
	}

	static Controller[] getControllers() throws LWJGLException {
		pollAll()
		def controllers = new Controller[Controllers.getControllerCount()]
		for(int i = 0; i < Controllers.getControllerCount(); i++) {
			controllers[i] = Controllers.getController(i)
		}
		controllers
	}

	static void runDisplay() throws LWJGLException {
		pollAll()
		def controllers = getControllers()
		for(int i = 0; i < controllers.length; i++) {
			println "Controller recognized. INDEX: $i, NAME: ${controllers[i].name}"
		}
	}
}
