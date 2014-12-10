package com.czipperz.cLibrary.exceptions;

import com.czipperz.cLibrary.gui.CErrorWindow;

/**
 * Generates error windows with the given text.
 * @author Chris Gregory
 */
public abstract class CErrorHelper {
	public static void exit(String message, String classCalled, String methodCalled) {
		new CErrorWindow("ErrorHelper is exiting.\n" + classCalled + " told it to in method:\n" + methodCalled + "\nMessage:\n\n" + message + "\n\nEnd of error message.", true);
	}

	public static void exit(Exception e, String classCalled, String methodCalled) {
		new CErrorWindow("ErrorHelper is exiting.\n" + classCalled + " told it to in method:\n" + methodCalled + "\nMessage:\n\n" + e.getMessage() + "\n\nEnd of error message.", true);
	}

	public static void show(String message, String classCalled, String methodCalled) {
		new CErrorWindow("ErrorHelper is exiting.\n" + classCalled + " told it to in method:\n" + methodCalled + "\nMessage:\n\n" + message + "\n\nEnd of error message.", false);
	}

	public static void show(Exception e, String classCalled, String methodCalled) {
		new CErrorWindow("ErrorHelper is exiting.\n" + classCalled + " told it to in method:\n" + methodCalled + "\nMessage:\n\n" + e.getMessage() + "\n\nEnd of error message.", false);
	}
}
