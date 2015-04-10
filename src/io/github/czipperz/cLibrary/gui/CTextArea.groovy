package io.github.czipperz.cLibrary.gui

import javax.swing.JScrollPane
import javax.swing.JTextArea
import java.awt.Color

/**
 * Created by czipperz on 4/8/15.
 */
class CTextArea extends JTextArea {
	JScrollPane scrollPane

	CTextArea setUpDefault() {
		lineWrap = true
		wrapStyleWord = true
		editable = false
		this
	}

	CTextArea println(String s) {
		print("$s\n")
	}

	CTextArea print(String s) {
		append(s)
		this
	}

	CTextArea println(String s, Color c) {
		foreground = c
		println s
	}

	CTextArea print(String s, Color c) {
		foreground = c
		print s
	}
}
