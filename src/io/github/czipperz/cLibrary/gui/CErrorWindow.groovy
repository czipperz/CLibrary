package io.github.czipperz.cLibrary.gui

import com.czipperz.cLibrary.gui.CScrollPane
import com.czipperz.cLibrary.gui.CTextArea

import javax.swing.JFrame
import javax.swing.ScrollPaneConstants
import java.awt.Color

/**
 * Created by czipperz on 4/8/15.
 */
class CErrorWindow {
	CErrorWindow(Exception e, boolean exitOnClose = false) {
		def frame = new JFrame()
		frame.setSize(600,300)
		frame.defaultCloseOperation = exitOnClose ? JFrame.EXIT_ON_CLOSE : JFrame.DISPOSE_ON_CLOSE
		frame.title = "Error"
		frame.contentPane.background = Color.WHITE

		def area = new CTextArea();
		area.background = Color.WHITE
		area.foreground = Color.RED
		area.editable = false
		area.lineWrap = true
		area.wrapStyleWord = true

		area.println e.getMessage()
		e.stackTrace.collect() {
			area.println it.toString()
		}

		def pane = new CScrollPane(area)
		pane.verticalScrollBarPolicy = ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED
		pane.horizontalScrollBar = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER
		pane.autoScroll = true

		frame.contentPane.add(pane)
		frame.visible = true
	}
}
