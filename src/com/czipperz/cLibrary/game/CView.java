package com.czipperz.cLibrary.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.Serializable;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.czipperz.cLibrary.imaging.CGraphics;
import com.czipperz.cLibrary.util.collections.CArrayHelper;

public class CView extends CIDAble implements IIDDrawAble, Comparable<CView>, Serializable {
	private CGameFrame displayOn;
	private boolean active = true;
	private int depth = 0;
	private boolean drawEverything = true;
	private List<CID> toDraw = null;
	private Rectangle drawRect = null;
	private Object imageObject = new Object();

	/**
	 * Sets to draw only what classes/objects have CIDs matching that of the array displayOn.  displayOn is the CGameFrame this will be shown on.  It auto registers itself and uses some of the methods of this class.  See the setters of toDraw, drawRect, and depth for more information.
	 * @param displayOn
	 * @param toDraw
	 * @param drawRect
	 * @param depth
	 */
	public CView(CGameFrame displayOn, ArrayList<CID> toDraw, Rectangle drawRect, int depth) {
		this.displayOn = displayOn;
		this.drawEverything = false;
		this.toDraw = toDraw;
		this.drawRect = drawRect;
		this.depth = depth;
		this.displayOn.addView(this);
	}

	public CView(CGameFrame displayOn, CID toDraw, Rectangle drawRect, int depth) {
		this(displayOn, CArrayHelper.createArrayList(toDraw), drawRect, depth);
	}

	/**
	 * Sets to draw only what classes/objects have CIDs matching that of the array displayOn.  displayOn is the CGameFrame this will be shown on.  It auto registers itself and uses some of the methods of this class.  See the setters of toDraw, drawRect, and depth for more information.  Generates the drawRect based on the bounds of the paramter displayOn.
	 * @param displayOn
	 * @param toDraw
	 * @param depth
	 * @see public CView(CGameFrame displayOn, ArrayList<CID> toDraw, Rectangle drawRect, int depth)
	 */
	public CView(CGameFrame displayOn, ArrayList<CID> toDraw, int depth) {
		this(displayOn, toDraw, displayOn.getBounds(), depth);
	}

	public CView(CGameFrame displayOn, CID toDraw, int depth) {
		this(displayOn, CArrayHelper.createArrayList(toDraw), depth);
	}

	/**
	 * Sets to draw Everything.  displayOn is the CGameFrame this will be shown on.  It auto registers itself and uses some of the methods of this class.  See the setters of drawRect and depth for more information.
	 * @param displayOn
	 * @param drawRect
	 * @param depth
	 */
	public CView(CGameFrame displayOn, Rectangle drawRect, int depth) {
		this.displayOn = displayOn;
		this.drawEverything = true;
		this.drawRect = drawRect;
		this.depth = depth;
		this.displayOn.addView(this);
	}

	/**
	 * Sets to draw Everything.  displayOn is the CGameFrame this will be shown on.  It auto registers itself and uses some of the methods of this class.  See the setter of depth for more information.  This also auto adds information about other components of the class's drawing behaviors.  Generates the drawRect based on the bounds of the paramter displayOn.
	 * @param displayOn
	 * @param depth
	 */
	public CView(CGameFrame displayOn, int depth) {
		this(displayOn, displayOn.getBounds(), depth);
	}

	/**
	 * Sets to draw Everything.  displayOn is the CGameFrame this will be shown on.  It auto registers itself and uses some of the methods of this class. See the setter of drawRect for more information.  This also auto adds information about other components of the class's drawing behaviors.
	 * @param displayOn
	 * @param drawRect
	 */
	public CView(CGameFrame displayOn, Rectangle drawRect) {
		this(displayOn, drawRect, 0);
	}

	/**
	 * Sets to draw Everything.  displayOn is the CGameFrame this will be shown on.  It auto registers itself and uses some of the methods of this class.  This also auto adds information about other components of the class's drawing behaviors.
	 * @param displayOn
	 */
	public CView(CGameFrame displayOn) {
		this(displayOn, 0);
	}

	private int bufferWidth, bufferHeight;
	private Image bufferImage;
	private Graphics bufferGraphics;

	private boolean preparePaint() {
		//If wrong reset
		if(bufferWidth != displayOn.getWidth() || bufferHeight != displayOn.getHeight() || bufferImage == null || bufferGraphics == null) {
			resetBuffer();
		}
		if(bufferGraphics != null) {
			//Clear
			bufferGraphics.clearRect(0, 0, bufferWidth, bufferHeight);
			return true;
		}
		return false;
	}

	private CView paintRuntime(Graphics g) {
		//Draw
		nowDraw(bufferGraphics);
		//Display
		new CGraphics(g).drawImage(bufferImage, drawRect, new Rectangle(bufferWidth, bufferHeight), displayOn);
		return this;
	}

	private CView nowDraw(Graphics g) {
		if(!active)
			return this;
		if(drawEverything) {
			Set<IIDDrawAble> x = displayOn.getObjects();
			for(IDrawAble a : x) {
				if(a.needUpdate()) {
					a.draw(g);
				}
				if(displayOn.isShowBorders()) {
					if(a instanceof CObject) {
						g.setColor(((CObject) a).getOutlineColor());
					}
					else {
						g.setColor(Color.BLACK);
					}
					g.drawRect(a.getBounds().x - 1, a.getBounds().y - 1, a.getBounds().width + 1, a.getBounds().height + 1);
				}
				return this;
			}
			return this;
		}
		if(toDraw != null) {
			Set<IIDDrawAble> o = displayOn.getObjects();
			for(IDrawAble i : o) {
				if(i.needUpdate()) {
					for(CID a : this.toDraw) {
						if(i.equals(a)) {
							i.draw(g);
							break;
						}
						if(displayOn.isShowBorders()) {
							if(i instanceof CObject) {
								g.setColor(((CObject) i).getOutlineColor());
							}
							else {
								g.setColor(Color.BLACK);
							}
							g.drawRect(i.getBounds().x - 1, i.getBounds().y - 1, i.getBounds().width + 1, i.getBounds().height + 1);
						}
					}
				}
			}
			return this;
		}
		throw new RuntimeException("Can't currently draw");
	}

	private synchronized void resetBuffer() {
		bufferWidth = displayOn.getWidth();
		bufferHeight = displayOn.getHeight();

		if(bufferGraphics != null) {
			bufferGraphics.dispose();
			bufferGraphics = null;
		}
		if(bufferImage != null) {
			bufferImage.flush();
			bufferImage = null;
		}
		System.gc();

		bufferImage = displayOn.createImage(bufferWidth, bufferHeight);
		bufferGraphics = bufferImage.getGraphics();
	}

	public IDrawAble draw(Graphics g) {
		while(!preparePaint()) {};
		paintRuntime(g);
		return this;
	}

	private CView paintPrepared(Graphics g, ArrayList<IIDDrawAble> ids, ArrayList<Image> images) {
		if(!active)
			return this;
		CGraphics g2 = new CGraphics(g);
		if(drawEverything) {
			for(int i = 0; i < images.size(); i++) {
				g2.drawImage(images.get(i), ids.get(i).getBounds(), null);
			}
			return this;
		}
		if(toDraw != null) {
			for(int i = 0; i < images.size(); i++) {
				if(toDraw.contains(ids.get(i).getClassID()) || toDraw.contains(ids.get(i).getInstanceID())) {
					g2.drawImage(images.get(i), ids.get(i).getBounds(), null);
				}
			}
			return this;
		}
		throw new RuntimeException("Can't currently draw");
	}

	public CView draw(Graphics g, ArrayList<IIDDrawAble> ids, ArrayList<Image> images) {
		while(!preparePaint()) {};
		return paintPrepared(g, ids, images);
	}

	public int getDepth() {
		return depth;
	}

	/**
	 * Sets the depth at which the CView is displayed above or below the others (doesn't matter if this is the only CView active.)
	 * @param depth
	 */
	public CView setDepth(int depth) {
		this.depth = depth;
		return this;
	}

	public boolean isDrawEverything() {
		return drawEverything;
	}

	/**
	 * Causes toDraw to be null and drawEverything to be set to true.
	 * @param drawEverything
	 */
	public CView drawEverything() {
		this.drawEverything = true;
		this.toDraw = null;
		return this;
	}

	public List<CID> getToDraw() {
		return toDraw;
	}

	/**
	 * Causes drawEverything to be false and toDraw to be se to the parameter toDraw.
	 * @param toDraw
	 */
	public CView setToDraw(ArrayList<CID> toDraw) {
		this.toDraw = toDraw;
		this.drawEverything = false;
		return this;
	}

	public CView setToDraw(CID toDraw) {
		ArrayList<CID> to = new ArrayList<CID>();
		to.add(toDraw);
		return this.setToDraw(toDraw);
	}

	public Rectangle getDrawRect() {
		return drawRect;
	}

	/**
	 * Sets where and at what scale the CView will display
	 * @param drawRect
	 */
	public CView setDrawRect(Rectangle drawRect) {
		this.drawRect = drawRect;
		return this;
	}

	public boolean isActive() {
		return active;
	}

	public CView setActive(boolean active) {
		this.active = active;
		return this;
	}

	public CView setActive() {
		setActive(true);
		return this;
	}

	public CView setInactive() {
		setActive(false);
		return this;
	}

	public Rectangle getBounds() {
		return getDrawRect();
	}

	public boolean needUpdate() {
		return active;
	}

	public int compareTo(CView other) {
		if(other instanceof CView) {
			return new CDepthSorter().compare(this, (CView)other);
		}
		throw new InvalidParameterException("Other must be of class CView");
	}

	public Object getImageObject() {
		return imageObject;
	}
}
