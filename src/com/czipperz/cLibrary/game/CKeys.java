package com.czipperz.cLibrary.game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * A class that allows for static access of the Key pressed values of every key on the keyboard without any additional adapters.  <strong>NOTE:</strong> DOES NOT STORE VALUES FOR MORE THAN ONE <code>JFrame.</code>
 * @author Chris Gregory
 * @see com.czipperz.cLibrary.game.CGameFrame
 * @see java.awt.event.KeyListener
 * @see com.czipperz.cLibrary.game.CKeyListener
 */
public class CKeys implements KeyListener {
	private static transient boolean isEscape;
	private static transient boolean isF1;
	private static transient boolean isF2;
	private static transient boolean isF3;
	private static transient boolean isF4;
	private static transient boolean isF5;
	private static transient boolean isF6;
	private static transient boolean isF7;
	private static transient boolean isF8;
	private static transient boolean isF9;        
	private static transient boolean isF10;       
	private static transient boolean isF11;       
	private static transient boolean isF12;       
	private static transient boolean isInsert;    
	private static transient boolean isHome;      
	private static transient boolean isPageUp;   
	private static transient boolean isDelete;    
	private static transient boolean isEnd;       
	private static transient boolean isPageDown; 
	private static transient boolean is1;         
	private static transient boolean is2;         
	private static transient boolean is3;         
	private static transient boolean is4;         
	private static transient boolean is5;         
	private static transient boolean is6;         
	private static transient boolean is7;         
	private static transient boolean is8;         
	private static transient boolean is9;         
	private static transient boolean is0;         
	private static transient boolean isMinus;     
	private static transient boolean isEquals;    
	private static transient boolean isBackSpace;
	private static transient boolean isTab;       
	private static transient boolean isQ;         
	private static transient boolean isW;         
	private static transient boolean isE;         
	private static transient boolean isR;         
	private static transient boolean isT;         
	private static transient boolean isY;         
	private static transient boolean isU;         
	private static transient boolean isI;         
	private static transient boolean isO;         
	private static transient boolean isP;         
	private static transient boolean isOpenBracket;
	private static transient boolean isCloseBracket;
	private static transient boolean isBackSlash;
	private static transient boolean isCapsLock; 
	private static transient boolean isA;         
	private static transient boolean isS;         
	private static transient boolean isD;         
	private static transient boolean isF;         
	private static transient boolean isG;         
	private static transient boolean isH;         
	private static transient boolean isJ;         
	private static transient boolean isK;         
	private static transient boolean isL;         
	private static transient boolean isSemiColon; 
	private static transient boolean isQuote;     
	private static transient boolean isEnter;     
	private static transient boolean isShift;     
	private static transient boolean isZ;         
	private static transient boolean isX;         
	private static transient boolean isC;         
	private static transient boolean isV;         
	private static transient boolean isB;         
	private static transient boolean isN;         
	private static transient boolean isM;         
	private static transient boolean isComma;     
	private static transient boolean isPeriod;    
	private static transient boolean isControl;   
	private static transient boolean isWindows;   
	private static transient boolean isAlt;       
	private static transient boolean isSpace;     
	private static transient boolean isLeft;      
	private static transient boolean isUp;        
	private static transient boolean isDown;      
	private static transient boolean isRight;     

	public static boolean isEscape() {
		return isEscape;
	}

	public static boolean isF1() {
		return isF1;
	}

	public static boolean isF2() {
		return isF2;
	}

	public static boolean isF3() {
		return isF3;
	}

	public static boolean isF4() {
		return isF4;
	}

	public static boolean isF5() {
		return isF5;
	}

	public static boolean isF6() {
		return isF6;
	}

	public static boolean isF7() {
		return isF7;
	}

	public static boolean isF8() {
		return isF8;
	}

	public static boolean isF9() {     
		return isF9;
	}

	public static boolean isF10() {       
		return isF10;
	}

	public static boolean isF11() {    
		return isF11;
	}

	public static boolean isF12() {      
		return isF12;
	}

	public static boolean isInsert() {  
		return isInsert;
	}

	public static boolean isHome() {    
		return isHome;
	}

	public static boolean isPageUp() {   
		return isPageUp;
	}

	public static boolean isDelete() {    
		return isDelete;
	}

	public static boolean isEnd() {       
		return isEnd;
	}

	public static boolean isPageDown() { 
		return isPageDown;
	}

	public static boolean is1() {         
		return is1;
	}

	public static boolean is2() {         
		return is2;
	}

	public static boolean is3() {         
		return is3;
	}

	public static boolean is4() {         
		return is4;
	}

	public static boolean is5() {         
		return is5;
	}

	public static boolean is6() {         
		return is6;
	}

	public static boolean is7() {         
		return is7;
	}

	public static boolean is8() {         
		return is8;
	}

	public static boolean is9() {         
		return is9;
	}

	public static boolean is0() {         
		return is0;
	}

	public static boolean isMinus() {     
		return isMinus;
	}

	public static boolean isEquals() {    
		return isEquals;
	}

	public static boolean isBackSpace() {
		return isBackSpace;
	}

	public static boolean isTab() {       
		return isTab;
	}

	public static boolean isQ() {         
		return isQ;
	}

	public static boolean isW() {         
		return isW;
	}

	public static boolean isE() {         
		return isE;
	}

	public static boolean isR() {         
		return isR;
	}

	public static boolean isT() {         
		return isT;
	}

	public static boolean isY() {         
		return isY;
	}

	public static boolean isU() {         
		return isU;
	}

	public static boolean isI() {         
		return isI;
	}

	public static boolean isO() {         
		return isO;
	}

	public static boolean isP() {         
		return isP;
	}

	public static boolean isOpenBracket() {
		return isOpenBracket;
	}

	public static boolean isCloseBracket() {
		return isCloseBracket;
	}

	public static boolean isBackSlash() {
		return isBackSlash;
	}

	public static boolean isCapsLock() { 
		return isCapsLock;
	}

	public static boolean isA() {         
		return isA;
	}

	public static boolean isS() {         
		return isS;
	}

	public static boolean isD() {         
		return isD;
	}

	public static boolean isF() {         
		return isF;
	}

	public static boolean isG() {         
		return isG;
	}

	public static boolean isH() {         
		return isH;
	}

	public static boolean isJ() {         
		return isJ;
	}

	public static boolean isK() {         
		return isK;
	}

	public static boolean isL() {        
		return isL;
	}

	public static boolean isSemiColon() { 
		return isSemiColon;
	}

	public static boolean isQuote() {     
		return isQuote;
	}

	public static boolean isEnter() {     
		return isEnter;
	}

	public static boolean isShift() {     
		return isShift;
	}

	public static boolean isZ() {         
		return isZ;
	}

	public static boolean isX() {         
		return isX;
	}

	public static boolean isC() {         
		return isC;
	}

	public static boolean isV() {         
		return isV;
	}

	public static boolean isB() {         
		return isB;
	}

	public static boolean isN() {         
		return isN;
	}

	public static boolean isM() {         
		return isM;
	}

	public static boolean isComma() {     
		return isComma;
	}

	public static boolean isPeriod() {    
		return isPeriod;
	}

	public static boolean isControl() {   
		return isControl;
	}

	public static boolean isWindows() {   
		return isWindows;
	}

	public static boolean isAlt() {       
		return isAlt;
	}

	public static boolean isSpace() {     
		return isSpace;
	}

	public static boolean isLeft() {      
		return isLeft;
	}

	public static boolean isUp() {        
		return isUp;
	}

	public static boolean isDown() {      
		return isDown;
	}

	public static boolean isRight() {     	
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
