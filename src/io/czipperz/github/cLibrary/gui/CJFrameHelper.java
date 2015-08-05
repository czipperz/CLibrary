package io.czipperz.github.cLibrary.gui;

import javax.swing.*;
import java.awt.*;

/**
 * @author czipperz on 4/8/15.
 */
public final class CJFrameHelper {
    private CJFrameHelper() {}

    public static void setUpDefaultJFrame(JFrame frame) {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void setUpDefaultJFrame(JFrame frame, int width, int height) {
        frame.setSize(width, height);
        setUpDefaultJFrame(frame);
    }

    public static void setUpDefaultJFrame(JFrame frame, Dimension s) {
        setUpDefaultJFrame(frame, s.width, s.height);
    }

    public static void setUnclosable(JFrame frame) {
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    }

    public static void setUnclosable(JFrame frame, int sx, int sy) {
        frame.setSize(sx, sy);
        setUnclosable(frame);
    }

    public static void setUnclosable(JFrame frame, Dimension s) {
        frame.setSize(s.width, s.height);
        setUnclosable(frame);
    }
}
