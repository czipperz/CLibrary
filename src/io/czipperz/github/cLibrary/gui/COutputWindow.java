package io.czipperz.github.cLibrary.gui;

import javax.swing.*;
import java.awt.*;

/**
 * @author czipperz on 4/8/15.
 */
public class COutputWindow {
    private JFrame frame;
    private CTextArea area;
    private CScrollPane pane;

    public COutputWindow(boolean exitOnClose = false, boolean visible = true) {
        frame = new JFrame                ();
        frame.setSize                     (600,350);
        frame.setDefaultCloseOperation    (exitOnClose ? JFrame.EXIT_ON_CLOSE : JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle                    ("");
        frame.getContentPane              ().setBackground(Color.BLACK);

        area = new CTextArea              ();
        area.setBackground                (Color.BLACK);
        area.setForeground                (Color.WHITE);
        area.setEditable                  (false);
        area.setLineWrap                  (true);
        area.setWrapStyleWord             (true);

        pane = new CScrollPane            (area);
        pane.setVerticalScrollBarPolicy   (ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        pane.setHorizontalScrollBarPolicy (ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        pane.setAutoScroll                (true);

        frame.setContentPane              (pane);
        frame.setVisible                  (true);
    }

    public COutputWindow print(String s) {
        area.print(s);
        return this;
    }

    public COutputWindow println(String s) {
        area.println(s);
        return this;
    }
}
