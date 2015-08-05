package io.czipperz.github.cLibrary.gui

import javax.swing.*
import java.awt.*

/**
* @author czipperz on 4/8/15.
*/
class CTransparentPanel extends JPanel {
	CTransparentPanel() {
		opaque = false
		background = new Color(0,0,0,0)
	}
}
