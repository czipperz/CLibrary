package io.czipperz.github.cLibrary.gui;

import javax.swing.*;
import java.awt.*;

/**
 * @author czipperz on 4/8/15.
 */
public class CErrorWindow {
    public CErrorWindow(Exception e, boolean exitOnClose = false) {
        JFrame frame = new JFrame();
        frame.setSize(600,300);
        frame.setDefaultCloseOperation(exitOnClose ? JFrame.EXIT_ON_CLOSE : JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Error");
        frame.getContentPane().setBackground(Color.WHITE);

        CTextArea area = new CTextArea();
        area.setBackground    (Color.WHITE);
        area.setForeground    (Color.RED);
        area.setEditable      (false);
        area.setLineWrap      (true);
        area.setWrapStyleWord (true);

        area.println(e.getMessage());
        e.stackTrace.collect() {;
            area.println(it.toString());
        }

        CScrollPane pane = new CScrollPane(area);
        pane.setVerticalScrollBarPolicy (ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        pane.setHorizontalScrollBar     (ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        pane.setAutoScroll(true);

        frame.getContentPane().add(pane);
        frame.setVisible(true);
    }
}
