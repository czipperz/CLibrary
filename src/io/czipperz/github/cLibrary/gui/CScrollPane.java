package io.czipperz.github.cLibrary.gui;

import java.awt.event.AdjustmentListener;
import java.awt.event.AdjustmentEvent;

import javax.swing.JScrollPane;

/**
 * @author czipperz on 4/8/15.
 */
public class CScrollPane extends JScrollPane {
    private boolean autoScroll;

    public CScrollPane(CTextArea a) {
        super(a);
        autoScroll = false;
    }

    private final AdjustmentListener alist = new AdjustmentListener() {
            void adjustmentValueChanged(AdjustmentEvent it) {
                if(autoScroll && !it.valueIsAdjusting)
                    it.adjustable.value = it.adjustable.maximum;
            }
        };

    public boolean getAutoscroll() { return this.autoScroll; }
    public CScrollPane setAutoScroll(boolean isAuto) {
        if(isAuto && !autoScroll) {
            autoScroll = isAuto;
            this.verticalScrollBar.addAdjustmentListener(alist);
        } else {
            autoScroll = isAuto;
            this.verticalScrollBar.removeAdjustmentListener(alist);
        }
        return this;
    }
}
