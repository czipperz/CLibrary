package com.czipperz.cLibrary.gameNew;

import com.czipperz.cLibrary.game.CDepthSorter;
import com.czipperz.cLibrary.game.CView;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * Created by Chris on 2/16/2015.
 */
public class CGamePanel extends JPanel {
    private CGameFrame linkedFrame;

    public CGamePanel(CGameFrame linkedFrame) {
        super(true);
        this.linkedFrame = linkedFrame;
    }

    public void paintComponent(Graphics g) {
        List<CView> views = linkedFrame.getViews();
        views.sort(new CDepthSorter());
        views.stream().forEachOrdered(v -> {
            if(v.needDraw())
                v.draw(g);
        });
    }
}
