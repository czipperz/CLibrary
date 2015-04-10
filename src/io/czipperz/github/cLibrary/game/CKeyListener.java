package io.czipperz.github.cLibrary.game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * This class allows for the user to only use the pressed, released, and typed events AS THEY CHOSE in the form as follows: <br />
 * pressed | released | typed + keyName + (KeyEvent e).  Examples: pressedA(KeyEvent e), releasedF3(KeyEvent e), typedDown(KeyEvent e)
 * @author Chris Gregory
 * @see KeyListener
 * @see CKeys for static boolean values
 */
public class CKeyListener implements KeyListener {
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			pressedEscape(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_F1) {
			pressedF1(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_F2) {
			pressedF2(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_F3) {
			pressedF3(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_F4) {
			pressedF4(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_F5) {
			pressedF5(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_F6) {
			pressedF6(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_F7) {
			pressedF7(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_F8) {
			pressedF8(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_F9) {
			pressedF9(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_F10) {
			pressedF10(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_F11) {
			pressedF11(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_F12) {
			pressedF12(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_INSERT) {
			pressedInsert(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_HOME) {
			pressedHome(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_PAGE_UP) {
			pressedPageUp(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_DELETE) {
			pressedDelete(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_END) {
			pressedEnd(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_PAGE_DOWN) {
			pressedPageDown(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_1) {
			pressed1(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_2) {
			pressed2(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_3) {
			pressed3(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_4) {
			pressed4(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_5) {
			pressed5(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_6) {
			pressed6(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_7) {
			pressed7(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_8) {
			pressed8(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_9) {
			pressed9(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_0) {
			pressed0(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_MINUS) {
			pressedMinus(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_EQUALS) {
			pressedEquals(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
			pressedBackspace(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_TAB) {
			pressedTab(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_Q) {
			pressedQ(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_W) {
			pressedW(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_E) {
			pressedE(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_R) {
			pressedR(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_T) {
			pressedT(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_Y) {
			pressedY(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_U) {
			pressedU(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_I) {
			pressedI(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_O) {
			pressedO(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_P) {
			pressedP(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_OPEN_BRACKET) {
			pressedBracketsOpen(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_CLOSE_BRACKET) {
			pressedBracketsClosed(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_BACK_SLASH) {
			pressedBackslash(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_CAPS_LOCK) {
			pressedCapsLock(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_A) {
			pressedA(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_S) {
			pressedS(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_D) {
			pressedD(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_F) {
			pressedF(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_G) {
			pressedG(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_H) {
			pressedH(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_J) {
			pressedJ(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_K) {
			pressedK(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_L) {
			pressedL(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_SEMICOLON) {
			pressedSemiColon(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_QUOTE) {
			pressedApostrophy(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			pressedEnter(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_SHIFT) {
			pressedShift(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_Z) {
			pressedZ(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_X) {
			pressedX(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_C) {
			pressedC(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_V) {
			pressedV(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_B) {
			pressedB(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_N) {
			pressedN(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_M) {
			pressedM(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_COMMA) {
			pressedComma(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_PERIOD) {
			pressedPeriod(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_CONTROL) {
			pressedControl(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_WINDOWS) {
			pressedWindowsButton(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_ALT) {
			pressedAlternative(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			pressedSpace(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			pressedLeft(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			pressedUp(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			pressedDown(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			pressedRight(e);
		}
	}

	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			releasedEscape(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_F1) {
			releasedF1(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_F2) {
			releasedF2(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_F3) {
			releasedF3(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_F4) {
			releasedF4(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_F5) {
			releasedF5(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_F6) {
			releasedF6(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_F7) {
			releasedF7(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_F8) {
			releasedF8(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_F9) {
			releasedF9(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_F10) {
			releasedF10(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_F11) {
			releasedF11(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_F12) {
			releasedF12(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_INSERT) {
			releasedInsert(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_HOME) {
			releasedHome(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_PAGE_UP) {
			releasedPageUp(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_DELETE) {
			releasedDelete(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_END) {
			releasedEnd(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_PAGE_DOWN) {
			releasedPageDown(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_1) {
			released1(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_2) {
			released2(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_3) {
			released3(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_4) {
			released4(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_5) {
			released5(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_6) {
			released6(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_7) {
			released7(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_8) {
			released8(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_9) {
			released9(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_0) {
			released0(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_MINUS) {
			releasedMinus(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_EQUALS) {
			releasedEquals(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
			releasedBackspace(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_TAB) {
			releasedTab(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_Q) {
			releasedQ(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_W) {
			releasedW(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_E) {
			releasedE(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_R) {
			releasedR(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_T) {
			releasedT(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_Y) {
			releasedY(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_U) {
			releasedU(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_I) {
			releasedI(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_O) {
			releasedO(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_P) {
			releasedP(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_OPEN_BRACKET) {
			releasedBracketsOpen(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_CLOSE_BRACKET) {
			releasedBracketsClosed(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_BACK_SLASH) {
			releasedBackslash(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_CAPS_LOCK) {
			releasedCapsLock(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_A) {
			releasedA(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_S) {
			releasedS(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_D) {
			releasedD(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_F) {
			releasedF(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_G) {
			releasedG(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_H) {
			releasedH(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_J) {
			releasedJ(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_K) {
			releasedK(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_L) {
			releasedL(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_SEMICOLON) {
			releasedSemiColon(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_QUOTE) {
			releasedApostrophy(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			releasedEnter(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_SHIFT) {
			releasedShift(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_Z) {
			releasedZ(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_X) {
			releasedX(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_C) {
			releasedC(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_V) {
			releasedV(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_B) {
			releasedB(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_N) {
			releasedN(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_M) {
			releasedM(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_COMMA) {
			releasedComma(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_PERIOD) {
			releasedPeriod(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_CONTROL) {
			releasedControl(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_WINDOWS) {
			releasedWindowsButton(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_ALT) {
			releasedAlternative(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			releasedSpace(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			releasedLeft(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			releasedUp(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			releasedDown(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			releasedRight(e);
		}
	}

	public void keyTyped(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			typedEscape(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_F1) {
			typedF1(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_F2) {
			typedF2(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_F3) {
			typedF3(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_F4) {
			typedF4(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_F5) {
			typedF5(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_F6) {
			typedF6(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_F7) {
			typedF7(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_F8) {
			typedF8(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_F9) {
			typedF9(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_F10) {
			typedF10(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_F11) {
			typedF11(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_F12) {
			typedF12(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_INSERT) {
			typedInsert(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_HOME) {
			typedHome(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_PAGE_UP) {
			typedPageUp(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_DELETE) {
			typedDelete(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_END) {
			typedEnd(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_PAGE_DOWN) {
			typedPageDown(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_1) {
			typed1(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_2) {
			typed2(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_3) {
			typed3(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_4) {
			typed4(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_5) {
			typed5(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_6) {
			typed6(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_7) {
			typed7(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_8) {
			typed8(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_9) {
			typed9(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_0) {
			typed0(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_MINUS) {
			typedMinus(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_EQUALS) {
			typedEquals(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
			typedBackspace(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_TAB) {
			typedTab(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_Q) {
			typedQ(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_W) {
			typedW(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_E) {
			typedE(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_R) {
			typedR(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_T) {
			typedT(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_Y) {
			typedY(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_U) {
			typedU(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_I) {
			typedI(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_O) {
			typedO(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_P) {
			typedP(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_OPEN_BRACKET) {
			typedBracketsOpen(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_CLOSE_BRACKET) {
			typedBracketsClosed(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_BACK_SLASH) {
			typedBackslash(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_CAPS_LOCK) {
			typedCapsLock(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_A) {
			typedA(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_S) {
			typedS(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_D) {
			typedD(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_F) {
			typedF(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_G) {
			typedG(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_H) {
			typedH(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_J) {
			typedJ(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_K) {
			typedK(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_L) {
			typedL(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_SEMICOLON) {
			typedSemiColon(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_QUOTE) {
			typedApostrophy(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			typedEnter(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_SHIFT) {
			typedShift(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_Z) {
			typedZ(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_X) {
			typedX(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_C) {
			typedC(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_V) {
			typedV(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_B) {
			typedB(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_N) {
			typedN(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_M) {
			typedM(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_COMMA) {
			typedComma(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_PERIOD) {
			typedPeriod(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_CONTROL) {
			typedControl(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_WINDOWS) {
			typedWindowsButton(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_ALT) {
			typedAlternative(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			typedSpace(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			typedLeft(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			typedUp(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			typedDown(e);
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			typedRight(e);
		}
	}


	public void pressedEscape(KeyEvent e) {

	}

	public void releasedEscape(KeyEvent e) {

	}

	public void typedEscape(KeyEvent e) {

	}

	public void pressedF1(KeyEvent e) {

	}

	public void releasedF1(KeyEvent e) {

	}

	public void typedF1(KeyEvent e) {

	}

	public void pressedF2(KeyEvent e) {

	}

	public void releasedF2(KeyEvent e) {

	}

	public void typedF2(KeyEvent e) {

	}

	public void pressedF3(KeyEvent e) {

	}

	public void releasedF3(KeyEvent e) {

	}

	public void typedF3(KeyEvent e) {

	}

	public void pressedF4(KeyEvent e) {

	}

	public void releasedF4(KeyEvent e) {

	}

	public void typedF4(KeyEvent e) {

	}

	public void pressedF5(KeyEvent e) {

	}

	public void releasedF5(KeyEvent e) {

	}

	public void typedF5(KeyEvent e) {

	}

	public void pressedF6(KeyEvent e) {

	}

	public void releasedF6(KeyEvent e) {

	}

	public void typedF6(KeyEvent e) {

	}

	public void pressedF7(KeyEvent e) {

	}

	public void releasedF7(KeyEvent e) {

	}

	public void typedF7(KeyEvent e) {

	}

	public void pressedF8(KeyEvent e) {

	}

	public void releasedF8(KeyEvent e) {

	}

	public void typedF8(KeyEvent e) {

	}

	public void pressedF9(KeyEvent e) {

	}

	public void releasedF9(KeyEvent e) {

	}

	public void typedF9(KeyEvent e) {

	}

	public void pressedF10(KeyEvent e) {

	}

	public void releasedF10(KeyEvent e) {

	}

	public void typedF10(KeyEvent e) {

	}

	public void pressedF11(KeyEvent e) {

	}

	public void releasedF11(KeyEvent e) {

	}

	public void typedF11(KeyEvent e) {

	}

	public void pressedF12(KeyEvent e) {

	}

	public void releasedF12(KeyEvent e) {

	}

	public void typedF12(KeyEvent e) {

	}

	public void pressedInsert(KeyEvent e) {

	}

	public void releasedInsert(KeyEvent e) {

	}

	public void typedInsert(KeyEvent e) {

	}

	public void pressedHome(KeyEvent e) {

	}

	public void releasedHome(KeyEvent e) {

	}

	public void typedHome(KeyEvent e) {

	}

	public void pressedPageUp(KeyEvent e) {

	}

	public void releasedPageUp(KeyEvent e) {

	}

	public void typedPageUp(KeyEvent e) {

	}

	public void pressedDelete(KeyEvent e) {

	}

	public void releasedDelete(KeyEvent e) {

	}

	public void typedDelete(KeyEvent e) {

	}

	public void pressedEnd(KeyEvent e) {

	}

	public void releasedEnd(KeyEvent e) {

	}

	public void typedEnd(KeyEvent e) {

	}

	public void pressedPageDown(KeyEvent e) {

	}

	public void releasedPageDown(KeyEvent e) {

	}

	public void typedPageDown(KeyEvent e) {

	}

	public void pressed1(KeyEvent e) {

	}

	public void released1(KeyEvent e) {

	}

	public void typed1(KeyEvent e) {

	}

	public void pressed2(KeyEvent e) {

	}

	public void released2(KeyEvent e) {

	}

	public void typed2(KeyEvent e) {

	}

	public void pressed3(KeyEvent e) {

	}

	public void released3(KeyEvent e) {

	}

	public void typed3(KeyEvent e) {

	}

	public void pressed4(KeyEvent e) {

	}

	public void released4(KeyEvent e) {

	}

	public void typed4(KeyEvent e) {

	}

	public void pressed5(KeyEvent e) {

	}

	public void released5(KeyEvent e) {

	}

	public void typed5(KeyEvent e) {

	}

	public void pressed6(KeyEvent e) {

	}

	public void released6(KeyEvent e) {

	}

	public void typed6(KeyEvent e) {

	}

	public void pressed7(KeyEvent e) {

	}

	public void released7(KeyEvent e) {

	}

	public void typed7(KeyEvent e) {

	}

	public void pressed8(KeyEvent e) {

	}

	public void released8(KeyEvent e) {

	}

	public void typed8(KeyEvent e) {

	}

	public void pressed9(KeyEvent e) {

	}

	public void released9(KeyEvent e) {

	}

	public void typed9(KeyEvent e) {

	}

	public void pressed0(KeyEvent e) {

	}

	public void released0(KeyEvent e) {

	}

	public void typed0(KeyEvent e) {

	}

	public void pressedMinus(KeyEvent e) {

	}

	public void releasedMinus(KeyEvent e) {

	}

	public void typedMinus(KeyEvent e) {

	}

	public void pressedEquals(KeyEvent e) {

	}

	public void releasedEquals(KeyEvent e) {

	}

	public void typedEquals(KeyEvent e) {

	}

	public void pressedBackspace(KeyEvent e) {

	}

	public void releasedBackspace(KeyEvent e) {

	}

	public void typedBackspace(KeyEvent e) {

	}

	public void pressedTab(KeyEvent e) {

	}

	public void releasedTab(KeyEvent e) {

	}

	public void typedTab(KeyEvent e) {

	}

	public void pressedQ(KeyEvent e) {

	}

	public void releasedQ(KeyEvent e) {

	}

	public void typedQ(KeyEvent e) {

	}

	public void pressedW(KeyEvent e) {

	}

	public void releasedW(KeyEvent e) {

	}

	public void typedW(KeyEvent e) {

	}

	public void pressedE(KeyEvent e) {

	}

	public void releasedE(KeyEvent e) {

	}

	public void typedE(KeyEvent e) {

	}

	public void pressedR(KeyEvent e) {

	}

	public void releasedR(KeyEvent e) {

	}

	public void typedR(KeyEvent e) {

	}

	public void pressedT(KeyEvent e) {

	}

	public void releasedT(KeyEvent e) {

	}

	public void typedT(KeyEvent e) {

	}

	public void pressedY(KeyEvent e) {

	}

	public void releasedY(KeyEvent e) {

	}

	public void typedY(KeyEvent e) {

	}

	public void pressedU(KeyEvent e) {

	}

	public void releasedU(KeyEvent e) {

	}

	public void typedU(KeyEvent e) {

	}

	public void pressedI(KeyEvent e) {

	}

	public void releasedI(KeyEvent e) {

	}

	public void typedI(KeyEvent e) {

	}

	public void pressedO(KeyEvent e) {

	}

	public void releasedO(KeyEvent e) {

	}

	public void typedO(KeyEvent e) {

	}

	public void pressedP(KeyEvent e) {

	}

	public void releasedP(KeyEvent e) {

	}

	public void typedP(KeyEvent e) {

	}

	public void pressedBracketsOpen(KeyEvent e) {

	}

	public void releasedBracketsOpen(KeyEvent e) {

	}

	public void typedBracketsOpen(KeyEvent e) {

	}

	public void pressedBracketsClosed(KeyEvent e) {

	}

	public void releasedBracketsClosed(KeyEvent e) {

	}

	public void typedBracketsClosed(KeyEvent e) {

	}

	public void pressedBackslash(KeyEvent e) {

	}

	public void releasedBackslash(KeyEvent e) {

	}

	public void typedBackslash(KeyEvent e) {

	}

	public void pressedCapsLock(KeyEvent e) {

	}

	public void releasedCapsLock(KeyEvent e) {

	}

	public void typedCapsLock(KeyEvent e) {

	}

	public void pressedA(KeyEvent e) {

	}

	public void releasedA(KeyEvent e) {

	}

	public void typedA(KeyEvent e) {

	}

	public void pressedS(KeyEvent e) {

	}

	public void releasedS(KeyEvent e) {

	}

	public void typedS(KeyEvent e) {

	}

	public void pressedD(KeyEvent e) {

	}

	public void releasedD(KeyEvent e) {

	}

	public void typedD(KeyEvent e) {

	}

	public void pressedF(KeyEvent e) {

	}

	public void releasedF(KeyEvent e) {

	}

	public void typedF(KeyEvent e) {

	}

	public void pressedG(KeyEvent e) {

	}

	public void releasedG(KeyEvent e) {

	}

	public void typedG(KeyEvent e) {

	}

	public void pressedH(KeyEvent e) {

	}

	public void releasedH(KeyEvent e) {

	}

	public void typedH(KeyEvent e) {

	}

	public void pressedJ(KeyEvent e) {

	}

	public void releasedJ(KeyEvent e) {

	}

	public void typedJ(KeyEvent e) {

	}

	public void pressedK(KeyEvent e) {

	}

	public void releasedK(KeyEvent e) {

	}

	public void typedK(KeyEvent e) {

	}

	public void pressedL(KeyEvent e) {

	}

	public void releasedL(KeyEvent e) {

	}

	public void typedL(KeyEvent e) {

	}

	public void pressedSemiColon(KeyEvent e) {

	}

	public void releasedSemiColon(KeyEvent e) {

	}

	public void typedSemiColon(KeyEvent e) {

	}

	public void pressedApostrophy(KeyEvent e) {

	}

	public void releasedApostrophy(KeyEvent e) {

	}

	public void typedApostrophy(KeyEvent e) {

	}

	public void pressedEnter(KeyEvent e) {

	}

	public void releasedEnter(KeyEvent e) {

	}

	public void typedEnter(KeyEvent e) {

	}

	public void pressedShift(KeyEvent e) {

	}

	public void releasedShift(KeyEvent e) {

	}

	public void typedShift(KeyEvent e) {

	}

	public void pressedZ(KeyEvent e) {

	}

	public void releasedZ(KeyEvent e) {

	}

	public void typedZ(KeyEvent e) {

	}

	public void pressedX(KeyEvent e) {

	}

	public void releasedX(KeyEvent e) {

	}

	public void typedX(KeyEvent e) {

	}

	public void pressedC(KeyEvent e) {

	}

	public void releasedC(KeyEvent e) {

	}

	public void typedC(KeyEvent e) {

	}

	public void pressedV(KeyEvent e) {

	}

	public void releasedV(KeyEvent e) {

	}

	public void typedV(KeyEvent e) {

	}

	public void pressedB(KeyEvent e) {

	}

	public void releasedB(KeyEvent e) {

	}

	public void typedB(KeyEvent e) {

	}

	public void pressedN(KeyEvent e) {

	}

	public void releasedN(KeyEvent e) {

	}

	public void typedN(KeyEvent e) {

	}

	public void pressedM(KeyEvent e) {

	}

	public void releasedM(KeyEvent e) {

	}

	public void typedM(KeyEvent e) {

	}

	public void pressedComma(KeyEvent e) {

	}

	public void releasedComma(KeyEvent e) {

	}

	public void typedComma(KeyEvent e) {

	}

	public void pressedPeriod(KeyEvent e) {

	}

	public void releasedPeriod(KeyEvent e) {

	}

	public void typedPeriod(KeyEvent e) {

	}

	public void pressedControl(KeyEvent e) {

	}

	public void releasedControl(KeyEvent e) {

	}

	public void typedControl(KeyEvent e) {

	}

	public void pressedWindowsButton(KeyEvent e) {

	}

	public void releasedWindowsButton(KeyEvent e) {

	}

	public void typedWindowsButton(KeyEvent e) {

	}

	public void pressedAlternative(KeyEvent e) {

	}

	public void releasedAlternative(KeyEvent e) {

	}

	public void typedAlternative(KeyEvent e) {

	}

	public void pressedSpace(KeyEvent e) {

	}

	public void releasedSpace(KeyEvent e) {

	}

	public void typedSpace(KeyEvent e) {

	}

	public void pressedLeft(KeyEvent e) {

	}

	public void releasedLeft(KeyEvent e) {

	}

	public void typedLeft(KeyEvent e) {

	}

	public void pressedUp(KeyEvent e) {

	}

	public void releasedUp(KeyEvent e) {

	}

	public void typedUp(KeyEvent e) {

	}

	public void pressedDown(KeyEvent e) {

	}

	public void releasedDown(KeyEvent e) {

	}

	public void typedDown(KeyEvent e) {

	}

	public void pressedRight(KeyEvent e) {

	}

	public void releasedRight(KeyEvent e) {

	}

	public void typedRight(KeyEvent e) {

	}
}
