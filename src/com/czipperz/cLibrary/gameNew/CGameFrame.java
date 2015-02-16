package com.czipperz.cLibrary.gameNew;

import com.czipperz.cLibrary.game.CKeySingleListener;
import com.czipperz.cLibrary.game.CKeys;
import com.czipperz.cLibrary.game.CMouse;
import com.czipperz.cLibrary.util.CThread;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

/**
 * Created by 997robotics1 on 2/10/2015.
 */
public class CGameFrame extends JFrame {
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
    private Consumer<String> bash;
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
    private int bufferWidth, bufferHeight;
    private Image bufferImage;
    private Graphics bufferGraphics;


}
