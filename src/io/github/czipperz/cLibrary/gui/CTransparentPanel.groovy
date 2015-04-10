package io.github.czipperz.cLibrary.gui

import javax.swing.JPanel
import java.awt.Color

/**
 * Created by czipperz on 4/8/15.
 */
class CTransparentPanel extends JPanel {
	CTransparentPanel() {
		opaque = false
		background = new Color(0,0,0,0)
	}
}
