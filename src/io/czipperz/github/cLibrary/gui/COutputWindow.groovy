package io.czipperz.github.cLibrary.gui

import javax.swing.*
import java.awt.*

/**
 * Created by czipperz on 4/8/15.
 */
class COutputWindow {
	JFrame frame
	CTextArea area
	CScrollPane pane

	public COutputWindow(boolean exitOnClose = false, boolean visible = true) {
		frame = new JFrame()
		frame.setSize(600,350)
		frame.defaultCloseOperation = exitOnClose ? JFrame.EXIT_ON_CLOSE : JFrame.DISPOSE_ON_CLOSE
		frame.title = ""
		frame.contentPane.background = Color.BLACK

		area = new CTextArea()
		area.background = Color.BLACK
		area.foreground = Color.WHITE
		area.editable = false
		area.lineWrap = true
		area.wrapStyleWord = true

		pane = new CScrollPane(area)
		pane.verticalScrollBarPolicy = ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED
		pane.horizontalScrollBarPolicy = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER
		pane.autoScroll = true

		frame.contentPane = pane
		frame.visible = true
	}

	COutputWindow print(String s) {
		area.print(s)
		this
	}

	COutputWindow println(String s) {
		area.println(s)
		this
	}
}
