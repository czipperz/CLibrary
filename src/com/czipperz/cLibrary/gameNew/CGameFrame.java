package com.czipperz.cLibrary.gameNew;

import com.czipperz.cLibrary.CBash;
import com.czipperz.cLibrary.game.*;
import com.czipperz.cLibrary.util.CThread;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

/**
 * Created by 997robotics1 on 2/10/2015.
 */
public class CGameFrame extends JFrame implements MouseListener, MouseMotionListener {
    //Lists
    private List objects = new LinkedList<>();
    private List views = new LinkedList<>();
    private List updaters = new LinkedList<>();
    //Objects
    private CThread updateThread;
    //Inputs
    private CMouse mouse;
    private CKeys keys;
    private CKeySingleListener keySingleListener;
    //Bash spam (fps)
    private boolean allowConsoleSpam = false;
    private CBash bash;
    //Overlays
    private boolean overlayEnabled = false;
    private boolean isF7 = false, showData = false;
    private boolean isF8 = false, showBorders = false;
    //Rendering
    private long lastTime = System.nanoTime();
    private double amountOfTicks = 60;
    private double ns = 1000000000 / amountOfTicks;
    private double delta = 0;
    private long timer = System.currentTimeMillis();
    private int frames = 0;
    private CGamePanel panel;

    public List<CIDDrawAble> getObjects() {
        return objects;
    }

    public List<CView> getViews() {
        return views;
    }

    public List<CUpdateAble> getUpdaters() {
        return updaters;
    }

    public CMouse getMouse() {
        return mouse;
    }

    public CKeys getKeys() {
        return keys;
    }

    public void setAllowConsoleSpam(boolean allowConsoleSpam) {
        this.allowConsoleSpam = allowConsoleSpam;
    }

    public boolean isAllowConsoleSpam() {
        return allowConsoleSpam;
    }

    public boolean getAllowConsoleSpam() {
        return allowConsoleSpam;
    }

    public void setBash(CBash bash) {
        this.bash = bash;
    }

    public CBash getBash() {
        return bash;
    }

    public CGameFrame() {
        super();
        keys = new CKeys();
        addKeyListener(keys);
        keySingleListener = new CKeySingleListener();
        addKeyListener(keySingleListener);
        mouse = new CMouse();
        addMouseListener(mouse);


        setupDraw();
    }

    private CGameFrame setupDraw() {
        updateThread = new CThread(() -> {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while(delta-- >= 1)
                updateAll();
            panel.repaint();
            frames++;
        }, false);
        return this;
    }

    public CGameFrame updateAll() {
        return this;
    }

    public void mouseClicked(MouseEvent e) {

    }

    public void mousePressed(MouseEvent e) {

    }

    public void mouseReleased(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }

    public void mouseDragged(MouseEvent e) {

    }

    public void mouseMoved(MouseEvent e) {

    }
}
