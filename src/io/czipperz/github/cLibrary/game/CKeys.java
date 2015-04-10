package io.czipperz.github.cLibrary.game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * A class that allows for static access of the Key pressed values of every key on the keyboard without any additional adapters.  <strong>NOTE:</strong> DOES NOT STORE VALUES FOR MORE THAN ONE <code>JFrame.</code>
 * @author Chris Gregory
 * @see CGameFrame
 * @see KeyListener
 * @see CKeyListener
 */
public class CKeys implements KeyListener {
	private transient boolean isEscape;
	private transient boolean isF1;
	private transient boolean isF2;
	private transient boolean isF3;
	private transient boolean isF4;
	private transient boolean isF5;
	private transient boolean isF6;
	private transient boolean isF7;
	private transient boolean isF8;
	private transient boolean isF9;
	private transient boolean isF10;
	private transient boolean isF11;
	private transient boolean isF12;
	private transient boolean isInsert;
	private transient boolean isHome;
	private transient boolean isPageUp;
	private transient boolean isDelete;
	private transient boolean isEnd;
	private transient boolean isPageDown;
	private transient boolean is1;
	private transient boolean is2;
	private transient boolean is3;
	private transient boolean is4;
	private transient boolean is5;
	private transient boolean is6;
	private transient boolean is7;
	private transient boolean is8;
	private transient boolean is9;
	private transient boolean is0;
	private transient boolean isMinus;
	private transient boolean isEquals;
	private transient boolean isBackSpace;
	private transient boolean isTab;
	private transient boolean isQ;
	private transient boolean isW;
	private transient boolean isE;
	private transient boolean isR;
	private transient boolean isT;
	private transient boolean isY;
	private transient boolean isU;
	private transient boolean isI;
	private transient boolean isO;
	private transient boolean isP;
	private transient boolean isOpenBracket;
	private transient boolean isCloseBracket;
	private transient boolean isBackSlash;
	private transient boolean isCapsLock;
	private transient boolean isA;
	private transient boolean isS;
	private transient boolean isD;
	private transient boolean isF;
	private transient boolean isG;
	private transient boolean isH;
	private transient boolean isJ;
	private transient boolean isK;
	private transient boolean isL;
	private transient boolean isSemiColon;
	private transient boolean isQuote;
	private transient boolean isEnter;
	private transient boolean isShift;
	private transient boolean isZ;
	private transient boolean isX;
	private transient boolean isC;
	private transient boolean isV;
	private transient boolean isB;
	private transient boolean isN;
	private transient boolean isM;
	private transient boolean isComma;
	private transient boolean isPeriod;
	private transient boolean isControl;
	private transient boolean isWindows;
	private transient boolean isAlt;
	private transient boolean isSpace;
	private transient boolean isLeft;
	private transient boolean isUp;
	private transient boolean isDown;
	private transient boolean isRight;

	public boolean isEscape() {
		return isEscape;
	}

	public boolean isF1() {
		return isF1;
	}

	public boolean isF2() {
		return isF2;
	}

	public boolean isF3() {
		return isF3;
	}

	public boolean isF4() {
		return isF4;
	}

	public boolean isF5() {
		return isF5;
	}

	public boolean isF6() {
		return isF6;
	}

	public boolean isF7() {
		return isF7;
	}

	public boolean isF8() {
		return isF8;
	}

	public boolean isF9() {
		return isF9;
	}

	public boolean isF10() {
		return isF10;
	}

	public boolean isF11() {
		return isF11;
	}

	public boolean isF12() {
		return isF12;
	}

	public boolean isInsert() {
		return isInsert;
	}

	public boolean isHome() {
		return isHome;
	}

	public boolean isPageUp() {
		return isPageUp;
	}

	public boolean isDelete() {
		return isDelete;
	}

	public boolean isEnd() {
		return isEnd;
	}

	public boolean isPageDown() {
		return isPageDown;
	}

	public boolean is1() {
		return is1;
	}

	public boolean is2() {
		return is2;
	}

	public boolean is3() {
		return is3;
	}

	public boolean is4() {
		return is4;
	}

	public boolean is5() {
		return is5;
	}

	public boolean is6() {
		return is6;
	}

	public boolean is7() {
		return is7;
	}

	public boolean is8() {
		return is8;
	}

	public boolean is9() {
		return is9;
	}

	public boolean is0() {
		return is0;
	}

	public boolean isMinus() {
		return isMinus;
	}

	public boolean isEquals() {
		return isEquals;
	}

	public boolean isBackSpace() {
		return isBackSpace;
	}

	public boolean isTab() {
		return isTab;
	}

	public boolean isQ() {
		return isQ;
	}

	public boolean isW() {
		return isW;
	}

	public boolean isE() {
		return isE;
	}

	public boolean isR() {
		return isR;
	}

	public boolean isT() {
		return isT;
	}

	public boolean isY() {
		return isY;
	}

	public boolean isU() {
		return isU;
	}

	public boolean isI() {
		return isI;
	}

	public boolean isO() {
		return isO;
	}

	public boolean isP() {
		return isP;
	}

	public boolean isOpenBracket() {
		return isOpenBracket;
	}

	public boolean isCloseBracket() {
		return isCloseBracket;
	}

	public boolean isBackSlash() {
		return isBackSlash;
	}

	public boolean isCapsLock() {
		return isCapsLock;
	}

	public boolean isA() {
		return isA;
	}

	public boolean isS() {
		return isS;
	}

	public boolean isD() {
		return isD;
	}

	public boolean isF() {
		return isF;
	}

	public boolean isG() {
		return isG;
	}

	public boolean isH() {
		return isH;
	}

	public boolean isJ() {
		return isJ;
	}

	public boolean isK() {
		return isK;
	}

	public boolean isL() {
		return isL;
	}

	public boolean isSemiColon() {
		return isSemiColon;
	}

	public boolean isQuote() {
		return isQuote;
	}

	public boolean isEnter() {
		return isEnter;
	}

	public boolean isShift() {
		return isShift;
	}

	public boolean isZ() {
		return isZ;
	}

	public boolean isX() {
		return isX;
	}

	public boolean isC() {
		return isC;
	}

	public boolean isV() {
		return isV;
	}

	public boolean isB() {
		return isB;
	}

	public boolean isN() {
		return isN;
	}

	public boolean isM() {
		return isM;
	}

	public boolean isComma() {
		return isComma;
	}

	public boolean isPeriod() {
		return isPeriod;
	}


	public boolean isControl() {
		return isControl;
	}

	public boolean isWindows() {
		return isWindows;
	}

	public boolean isAlt() {
		return isAlt;
	}

	public boolean isSpace() {
		return isSpace;
	}

	public boolean isLeft() {
		return isLeft;
	}

	public boolean isUp() {
		return isUp;
	}

	public boolean isDown() {
		return isDown;
	}

	public boolean isRight() {
		return isRight;
	}
	
	/**
	 * DO NOT CALL THIS METHOD!!!
	 */
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			isEscape = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_F1) {
			isF1 = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_F2) {
			isF2 = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_F3) {
			isF3 = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_F4) {
			isF4 = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_F5) {
			isF5 = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_F6) {
			isF6 = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_F7) {
			isF7 = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_F8) {
			isF8 = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_F9) {
			isF9 = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_F10) {
			isF10 = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_F11) {
			isF11 = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_F12) {
			isF12 = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_INSERT) {
			isInsert = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_HOME) {
			isHome = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_PAGE_UP) {
			isPageUp = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_DELETE) {
			isDelete = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_END) {
			isEnd = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_PAGE_DOWN) {
			isPageDown = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_1) {
			is1 = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_2) {
			is2 = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_3) {
			is3 = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_4) {
			is4 = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_5) {
			is5 = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_6) {
			is6 = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_7) {
			is7 = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_8) {
			is8 = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_9) {
			is9 = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_0) {
			is0 = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_MINUS) {
			isMinus = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_EQUALS) {
			isEquals = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
			isBackSpace = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_TAB) {
			isTab = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_Q) {
			isQ = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_W) {
			isW = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_E) {
			isE = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_R) {
			isR = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_T) {
			isT = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_Y) {
			isY = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_U) {
			isU = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_I) {
			isI = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_O) {
			isO = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_P) {
			isP = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_OPEN_BRACKET) {
			isOpenBracket = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_CLOSE_BRACKET) {
			isCloseBracket = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_BACK_SLASH) {
			isBackSlash = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_CAPS_LOCK) {
			isCapsLock = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_A) {
			isA = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_S) {
			isS = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_D) {
			isD = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_F) {
			isF = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_G) {
			isG = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_H) {
			isH = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_J) {
			isJ = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_K) {
			isK = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_L) {
			isL = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_SEMICOLON) {
			isSemiColon = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_QUOTE) {
			isQuote = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			isEnter = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_SHIFT) {
			isShift = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_Z) {
			isZ = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_X) {
			isX = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_C) {
			isC = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_V) {
			isV = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_B) {
			isB = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_N) {
			isN = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_M) {
			isM = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_COMMA) {
			isComma = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_PERIOD) {
			isPeriod = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_CONTROL) {
			isControl = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_WINDOWS) {
			isWindows = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_ALT) {
			isAlt = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			isSpace = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			isLeft = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			isUp = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			isDown = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			isRight = true;
		}
	}

	/**
	 * DO NOT CALL THIS METHOD!!!
	 */
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			isEscape = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_F1) {
			isF1 = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_F2) {
			isF2 = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_F3) {
			isF3 = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_F4) {
			isF4 = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_F5) {
			isF5 = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_F6) {
			isF6 = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_F7) {
			isF7 = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_F8) {
			isF8 = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_F9) {
			isF9 = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_F10) {
			isF10 = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_F11) {
			isF11 = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_F12) {
			isF12 = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_INSERT) {
			isInsert = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_HOME) {
			isHome = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_PAGE_UP) {
			isPageUp = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_DELETE) {
			isDelete = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_END) {
			isEnd = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_PAGE_DOWN) {
			isPageDown = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_1) {
			is1 = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_2) {
			is2 = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_3) {
			is3 = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_4) {
			is4 = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_5) {
			is5 = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_6) {
			is6 = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_7) {
			is7 = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_8) {
			is8 = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_9) {
			is9 = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_0) {
			is0 = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_MINUS) {
			isMinus = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_EQUALS) {
			isEquals = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
			isBackSpace = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_TAB) {
			isTab = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_Q) {
			isQ = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_W) {
			isW = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_E) {
			isE = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_R) {
			isR = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_T) {
			isT = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_Y) {
			isY = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_U) {
			isU = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_I) {
			isI = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_O) {
			isO = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_P) {
			isP = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_OPEN_BRACKET) {
			isOpenBracket = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_CLOSE_BRACKET) {
			isCloseBracket = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_BACK_SLASH) {
			isBackSlash = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_CAPS_LOCK) {
			isCapsLock = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_A) {
			isA = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_S) {
			isS = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_D) {
			isD = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_F) {
			isF = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_G) {
			isG = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_H) {
			isH = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_J) {
			isJ = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_K) {
			isK = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_L) {
			isL = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_SEMICOLON) {
			isSemiColon = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_QUOTE) {
			isQuote = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			isEnter = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_SHIFT) {
			isShift = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_Z) {
			isZ = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_X) {
			isX = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_C) {
			isC = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_V) {
			isV = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_B) {
			isB = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_N) {
			isN = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_M) {
			isM = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_COMMA) {
			isComma = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_PERIOD) {
			isPeriod = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_CONTROL) {
			isControl = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_WINDOWS) {
			isWindows = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_ALT) {
			isAlt = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			isSpace = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			isLeft = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			isUp = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			isDown = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			isRight = false;
		}
	}

	public void keyTyped(KeyEvent e) {}
}
