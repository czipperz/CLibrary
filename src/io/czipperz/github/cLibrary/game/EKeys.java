package io.czipperz.github.cLibrary.game;

import java.awt.event.KeyEvent;

public enum EKeys {
	K_ESCAPE(KeyEvent.VK_ESCAPE),
	K_F1(KeyEvent.VK_F1),
	K_F2(KeyEvent.VK_F2),
	K_F3(KeyEvent.VK_F3),
	K_F4(KeyEvent.VK_F4),
	K_F5(KeyEvent.VK_F5),
	K_F6(KeyEvent.VK_F6),
	K_F7(KeyEvent.VK_F7),
	K_F8(KeyEvent.VK_F8),
	K_F9(KeyEvent.VK_F9),
	K_F10(KeyEvent.VK_F10),
	K_F11(KeyEvent.VK_F11),
	K_F12(KeyEvent.VK_F12),
	K_INSERT(KeyEvent.VK_INSERT),
	K_HOME(KeyEvent.VK_HOME),
	K_PAGE_UP(KeyEvent.VK_PAGE_UP),
	K_DELETE(KeyEvent.VK_DELETE),
	K_END(KeyEvent.VK_END),
	K_PAGE_DOWN(KeyEvent.VK_PAGE_DOWN),
	K_1(KeyEvent.VK_1),
	K_2(KeyEvent.VK_2),
	K_3(KeyEvent.VK_3),
	K_4(KeyEvent.VK_4),
	K_5(KeyEvent.VK_5),
	K_6(KeyEvent.VK_6),
	K_7(KeyEvent.VK_7),
	K_8(KeyEvent.VK_8),
	K_9(KeyEvent.VK_9),
	K_0(KeyEvent.VK_0),
	K_MINUS(KeyEvent.VK_MINUS),
	K_EQUALS(KeyEvent.VK_EQUALS),
	K_BACK_SPACE(KeyEvent.VK_BACK_SPACE),
	K_TAB(KeyEvent.VK_TAB),
	K_Q(KeyEvent.VK_Q),
	K_W(KeyEvent.VK_W),
	K_E(KeyEvent.VK_E),
	K_R(KeyEvent.VK_R),
	K_T(KeyEvent.VK_T),
	K_Y(KeyEvent.VK_Y),
	K_U(KeyEvent.VK_U),
	K_I(KeyEvent.VK_I),
	K_O(KeyEvent.VK_O),
	K_P(KeyEvent.VK_P),
	K_OPEN_BRACKET(KeyEvent.VK_OPEN_BRACKET),
	K_CLOSE_BRACKET(KeyEvent.VK_CLOSE_BRACKET),
	K_BACK_SLASH(KeyEvent.VK_BACK_SLASH),
	K_CAPS_LOCK(KeyEvent.VK_CAPS_LOCK),
	K_A(KeyEvent.VK_A),
	K_S(KeyEvent.VK_S),
	K_D(KeyEvent.VK_D),
	K_F(KeyEvent.VK_F),
	K_G(KeyEvent.VK_G),
	K_H(KeyEvent.VK_H),
	K_J(KeyEvent.VK_J),
	K_K(KeyEvent.VK_K),
	K_L(KeyEvent.VK_L),
	K_SEMI_COLON(KeyEvent.VK_SEMICOLON),
	K_QUOTE(KeyEvent.VK_QUOTE),
	K_ENTER(KeyEvent.VK_ENTER),
	K_SHIFT(KeyEvent.VK_SHIFT),
	K_Z(KeyEvent.VK_Z),
	K_X(KeyEvent.VK_X),
	K_C(KeyEvent.VK_C),
	K_V(KeyEvent.VK_V),
	K_B(KeyEvent.VK_B),
	K_N(KeyEvent.VK_N),
	K_M(KeyEvent.VK_M),
	K_COMMA(KeyEvent.VK_COMMA),
	K_PERIOD(KeyEvent.VK_PERIOD),
	K_CONTROL(KeyEvent.VK_CONTROL),
	K_WINDOWS(KeyEvent.VK_WINDOWS),
	K_ALT(KeyEvent.VK_ALT),
	K_SPACE(KeyEvent.VK_SPACE),
	K_LEFT(KeyEvent.VK_LEFT),
	K_UP(KeyEvent.VK_UP),
	K_DOWN(KeyEvent.VK_DOWN),
	K_RIGHT(KeyEvent.VK_RIGHT);
	
	final int value;
	
	EKeys(int value) {
		this.value = value;
	}
	
	public String toString() {
		String main = super.toString();
		StringBuilder b = new StringBuilder(main);
		b.deleteCharAt(0);
		b.deleteCharAt(0);
		char[] bl = b.toString().toLowerCase().toCharArray();
		bl[0] = Character.toUpperCase(bl[0]);
		return new String(bl);
	}
}
