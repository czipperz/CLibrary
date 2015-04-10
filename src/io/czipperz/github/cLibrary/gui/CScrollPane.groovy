package io.czipperz.github.cLibrary.gui

import javax.swing.JScrollPane

/**
 * Created by czipperz on 4/8/15.
 */
class CScrollPane extends JScrollPane {
	boolean autoScroll

	CScrollPane(CTextArea a) {
		super(a)
		autoScroll = false
	}

	private final alist = {
		if(autoScroll && !it.valueIsAdjusting)
			it.adjustable.value = it.adjustable.maximum
	}

	CScrollPane setAutoScroll(boolean isAuto) {
		if(isAuto && !autoScroll) {
			autoScroll = isAuto
			this.verticalScrollBar.addAdjustmentListener(alist)
		} else {
			autoScroll = isAuto
			this.verticalScrollBar.removeAdjustmentListener(alist)
		}
		this
	}
}
