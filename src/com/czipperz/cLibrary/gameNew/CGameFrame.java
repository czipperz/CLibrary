package com.czipperz.cLibrary.gameNew;

import com.czipperz.cLibrary.CBash;
import com.czipperz.cLibrary.CBashSOut;
import com.czipperz.cLibrary.game.*;
import com.czipperz.cLibrary.util.CThread;
import com.czipperz.cLibrary.util.collections.CArrayHelper;

import javax.swing.*;
import javax.swing.text.Keymap;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by 997robotics1 on 2/10/2015.
 */
public class CGameFrame extends JFrame {
    //Lists
    private List<CIDDrawAble> objects = new LinkedList<>();
    private List<CView> views = new LinkedList<>(), viewsClone = new LinkedList<>();
    private List<CUpdateAble> updaters = new ArrayList<>();
    //Objects
    private CThread updateThread;
    //Inputs
    private CMouse mouse;
    private CKeys keys;
    private CKeySingleListener keySingleListener;
    //Bash spam (fps)
    private boolean allowConsoleSpam = false;
    private CBash bash = new CBashSOut();
    //Overlays
    private boolean overlayEnabled = false;
    private boolean showData, showBorders = false;
    private EKeys showDataKey = EKeys.K_F7;
    private EKeys showBordersKey = EKeys.K_F8;
    //Rendering
    private long lastTime = System.nanoTime();
    private double amountOfTicks = 60;
    private double ns = 1000000000 / amountOfTicks;
    private double delta = 0;
    private int frames = 0;
    private CGamePanel panel;

    public CGameFrame() {
        super();
        keys = new CKeys();
        addKeyListener(keys);
        keySingleListener = new CKeySingleListener();
        addKeyListener(keySingleListener);
        mouse = new CMouse();
        addMouseListener(mouse);

        makeDrawThread();
    }

    public CGameFrame registerObject(CIDDrawAble obj) {
        objects.add(obj);
        return this;
    }

    /**
     * Add objects to the list by using {@linkplain #registerObject(com.czipperz.cLibrary.game.CIDDrawAble)}
     * @return the list
     */
    public List<CIDDrawAble> getObjects() {
        return objects;
    }

    public CGameFrame registerView(CView view) {
        views.add(view);
        viewsClone.add(view);
        views.sort(new CDepthSorter());
        viewsClone.sort(new CDepthSorter());
        return this;
    }

    /**
     * Add objects to the list by using {@linkplain #registerView(com.czipperz.cLibrary.game.CView)}
     * @return a clone of the list
     */
    public List<CView> getViews() {
        return viewsClone;
    }

    public CGameFrame registerUpdater(CUpdateAble updater) {
        updaters.add(updater);
        return this;
    }

    /**
     * Add objects to the list by using {@linkplain #registerUpdater(com.czipperz.cLibrary.game.CUpdateAble)}
     * @return a the list
     */
    public List<CUpdateAble> getUpdaters() {
        return updaters;
    }

    public CThread getUpdateThread() {
        return updateThread;
    }

    public CGameFrame setOverlayEnabled(boolean b) {
        overlayEnabled = true;
        return this;
    }

    public boolean isOverlayEnabled() {
        return overlayEnabled;
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

    private CGameFrame makeDrawThread() {
        updateThread = new CThread(() -> {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while(delta-- >= 1)
                updateAll();
            panel.repaint();
            frames++;
            if(allowConsoleSpam)
                try {
                    bash.println("FPS: " + frames);
                } catch(Exception e) {
                    System.out.println("Error connecting to the bash client");
                }
        }, false);
        return this;
    }

    private CGameFrame updateAll() {
        objects.stream().forEachOrdered(o -> {
            if(o.needUpdateBefore())
                o.tickBefore();
        });
        objects.stream().forEachOrdered(o -> {
            if(o.needUpdate())
                o.tick();
        });
        objects.stream().forEachOrdered(o -> {
            if(o.needUpdateAfter())
                o.tickAfter();
        });
        return this;
    }
}
