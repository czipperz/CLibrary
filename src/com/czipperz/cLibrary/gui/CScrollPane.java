package com.czipperz.cLibrary.gui;

import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

import javax.swing.JScrollPane;

public class CScrollPane extends JScrollPane {
	private static final long serialVersionUID = -1566253300903991951L;
	private boolean autoScroll;

	public CScrollPane(CTextArea a) {
		super(a);
		autoScroll = false;
	}

	public CScrollPane setAutoScroll(boolean isAuto) {
		if(isAuto && !autoScroll) {
			this.autoScroll = isAuto;
			this.getVerticalScrollBar().addAdjustmentListener(new AdjustmentListener() {
				public void adjustmentValueChanged(AdjustmentEvent e) {
					if (isAutoScroll()) {
						if (!e.getValueIsAdjusting()) {
							e.getAdjustable().setValue(e.getAdjustable().getMaximum());
						}
					}
				}
			});
		}
		return this;
	}
	
	public boolean isAutoScroll() {
		return autoScroll;
	}
}
