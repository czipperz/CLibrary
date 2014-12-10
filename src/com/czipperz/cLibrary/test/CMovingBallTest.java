package com.czipperz.cLibrary.test;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Controller;
import org.lwjgl.input.Controllers;

import com.czipperz.cLibrary.game.CGameFrame;
import com.czipperz.cLibrary.game.CKeys;
import com.czipperz.cLibrary.game.CObjectDrawAble;
import com.czipperz.cLibrary.game.CView;
import com.czipperz.cLibrary.game.IUpdateAble;
import com.czipperz.cLibrary.game.controller.CControllerXBox;
import com.czipperz.cLibrary.game.controller.CControllersHandler;
import com.czipperz.cLibrary.gui.CJFrameHelper;
import com.czipperz.cLibrary.imaging.CGraphics;
import com.czipperz.cLibrary.imaging.CImage;
import com.czipperz.cLibrary.imaging.CImageBackground;
import com.czipperz.cLibrary.imaging.CImageDraw;

public class CMovingBallTest extends CGameFrame implements IUpdateAble {
	public static void main(String[] args) {
		new CMovingBallTest();
	}

	private Controller c;
	private boolean using;

	public CMovingBallTest() {
		try {
			CControllersHandler.pollAll();
		} catch (LWJGLException e1) {
			e1.printStackTrace();
		}
		try {
			c = Controllers.getController(0);
			c.setXAxisDeadZone(0.3f);
			c.setYAxisDeadZone(0.3f);
			using = true;
		} catch(RuntimeException e) {
			using = false;
		}
		CJFrameHelper.setUpDefaultJFrame(this, 500, 500);
		CObjectDrawAble miniMapBackground = new CObjectDrawAble(this, CImageBackground.getDefaultDepth(), new CImageBackground(this, Color.RED));
		System.out.println("BGID: " + miniMapBackground.getInstanceID().toString());
		CImage moving = new CImageDraw(this, new Rectangle(xp, yp, 50, 50)) {
			public CImage draw(Graphics g) {
				this.getLocScreen().x = xp;
				this.getLocScreen().y = yp;
				new CGraphics(g).fillOval(getLocScreen());
				return this;
			}

			public Color getCustomOutlineColor() {
				return Color.BLACK;
			}
		};
		CObjectDrawAble o = new CObjectDrawAble(this, -100, moving);
		System.out.println("ObjectID: " + o.getInstanceID().toString());

		CView view = new CView(this, o.getInstanceID(), 100);
		//CView miniMap = new CView(this, new Rectangle(0, 0, 50, 50), -100);

		this.addUpdater(this);

		this.setVisible(true);
	}

	private int xp = 0;
	private int yp = 0;

	public CMovingBallTest updateBefore() {return this;}

	public CMovingBallTest update() {
		if(using) {
			c.poll();
			boolean xn = c.getXAxisValue() < 0 || c.getPovX() < 0;
			boolean xa = c.getXAxisValue() != 0 || c.getPovX() != 0;
			boolean yn = c.getYAxisValue() < 0 || c.getPovY() < 0;
			boolean ya = c.getYAxisValue() != 0 || c.getPovY() != 0;
			float za = 2f * (c.getZAxisValue() + 1.0f);
			if(xa) {
				if(xn)
					xp -= (int)(2.0f * za);
				else
					xp += (int)(2.0f * za);
			}
			if(ya) {
				if(yn)
					yp -= (int)(2.0f * za);
				else
					yp += (int)(2.0f * za);
			}
			if(c.isButtonPressed(CControllerXBox.buttonY)) {
				xp = getWidth()/2;
				yp = getHeight()/2;
			}
		}
		else {
			xp -= CKeys.isD() ? 0 : 2;
			xp += CKeys.isA() ? 0 : 2;
			yp -= CKeys.isS() ? 0 : 2;
			yp += CKeys.isW() ? 0 : 2;
		}
		return this;
	}
}
