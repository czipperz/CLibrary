package com.czipperz.cLibrary.game;

import com.czipperz.cLibrary.exceptions.CEnumTypeNotListedException;
import com.czipperz.cLibrary.imaging.CGraphics;
import com.czipperz.cLibrary.location.CRect;

import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CView extends CObject implements Serializable, CDrawAble {
	private int depth = 0;

	private boolean drawAllObjects = true;
	private List<CDrawAble> toDraw = null;

	//Draw on the CGameFrame
	private boolean drawFullWindow = false;
	private Rectangle drawRect = null;

	//Draw on the Buffer
	private Dimension bufferDimension;
	private Image bufferImage;
	private Graphics bufferGraphics;

	/**
	 * Sets to draw Everything.  displayOn is the CGameFrame this will be shown on.  It auto registers itself and uses some of the methods of this class.  See the setters of drawRect and depth for more information.
	 * @param displayOn
	 * @param drawRect
	 * @param depth
	 */
	public CView(CGameFrame displayOn, Rectangle drawRect, int depth) {
		super(displayOn);
		this.drawAllObjects = true;
		this.drawRect = drawRect;
		this.depth = depth;
		this.bufferDimension = new Dimension();
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

	public CDrawAble draw(Graphics g) {
		while(!preparePaint()) {}
		paintRuntime(g);
		return this;
	}

	public CDrawAble tick() {
		return this;
	}

	private boolean preparePaint() {
		//If wrong reset
		if(bufferDimension.width != getDisplayOn().getWidth() || bufferDimension.height != getDisplayOn().getHeight() || bufferImage == null || bufferGraphics == null) {
			resetBuffer();
		}
		if(bufferGraphics != null) {
			//Clear
			bufferGraphics.clearRect(0,0, bufferDimension.width, bufferDimension.height);
			return true;
		}
		return false;
	}

	private synchronized void resetBuffer() {
		bufferDimension.width = getDisplayOn().getWidth();
		bufferDimension.height = getDisplayOn().getHeight();

		if(bufferGraphics != null) {
			bufferGraphics.dispose();
			bufferGraphics = null;
		}
		if(bufferImage != null) {
			bufferImage.flush();
			bufferImage = null;
		}
		System.gc();

		bufferImage = getDisplayOn().createImage(bufferDimension.width, bufferDimension.height);
		bufferGraphics = bufferImage.getGraphics();
	}

	private CView paintRuntime(Graphics g) {
		//Draw
		if(isActive()) {
			//Draws everything on the supplied CGameFrame
			if (drawAllObjects) {
				Set<CIDDrawAble> x = getDisplayOn().getObjects();
				for (CDrawAble a : x) {
					if (a.needDraw())
						a.draw(g);
					if (getDisplayOn().isShowBorders()) {
						if (a instanceof CObject)
							g.setColor(((CObject) a).getOutlineColor());
						else
							g.setColor(Color.BLACK);
						g.drawRect(a.getBounds().x - 1, a.getBounds().y - 1, a.getBounds().width + 1, a.getBounds().height + 1);
					}
				}
			}
			//Draws everything specifically given to it to run.
			else if (toDraw != null)
				for (CDrawAble i : this.toDraw) {
					if (i.needDraw())
						i.draw(g);
					if (getDisplayOn().isShowBorders()) {
						if (i instanceof CObject)
							g.setColor(((CObject) i).getOutlineColor());
						else
							g.setColor(Color.BLACK);
						g.drawRect(i.getBounds().x - 1, i.getBounds().y - 1, i.getBounds().width + 1, i.getBounds().height + 1);
					}
				}
			else
				throw new CEnumTypeNotListedException();
		}
		//Display
		new CGraphics(g).drawImage(bufferImage, drawRect != null ? drawRect : getDisplayOn().getBounds(), new CRect(0,0,bufferDimension), getDisplayOn());
		return this;
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

	/**
	 * @return if all the objects registered to the CGameFrame will be drawn by this CView object.
	 */
	public boolean isDrawAllObjects() {
		return drawAllObjects;
	}

	/**
	 * Causes toDraw to be null and drawAllObjects to be set to true.
	 */
	public CView setDrawEverything() {
		this.drawAllObjects = true;
		this.toDraw = null;
		return this;
	}

	/**
	 * @return the custom objects toDraw. IF THE
	 */
	public List<? extends CDrawAble> getToDraw() {
		return toDraw;
	}

	/**
	 * Adds the item to the drawing que
	 * @param toDraw
	 */
	public CView addToDraw(CDrawAble toDraw) {
		if(this.toDraw == null)
			return setToDraw(toDraw);
		this.toDraw.add(toDraw);
		return this;
	}

	/**
	 * Adds the following items to the drawing que
	 * @param toDraw
	 */
	public CView addToDraw(ArrayList<CDrawAble> toDraw) {
		if(this.toDraw == null)
			return setToDraw(toDraw);
		toDraw.stream().forEachOrdered(i -> toDraw.add(i));
		return this;
	}

	/**
	 * Overrides the current objects to be drawn.
	 * @param toDraw
	 */
	public CView setToDraw(ArrayList<CDrawAble> toDraw) {
		this.toDraw = toDraw;
		this.drawAllObjects = false;
		return this;
	}

	/**
	 * Overrides the current objects to be drawn by creates an ArrayList of this single item.
	 * @param toDraw
	 * @see #setToDraw(ArrayList< CDrawAble >)
	 */
	public CView setToDraw(CDrawAble toDraw) {
		ArrayList<CDrawAble> to = new ArrayList<>();
		to.add(toDraw);
		return this.setToDraw(to);
	}

	/**
	 * @return the rectangle it draws on the CGameFrame
	 */
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

	public CObject setNeedUpdate(boolean active) {
		return setActive(active);
	}

	/**
	 * @see #getDrawRect
	 */
	public Rectangle getBounds() {
		return getDrawRect();
	}

	public boolean needUpdate() {
		return false;
	}

	public Rectangle getLocScreen() {
		return getDrawRect();
	}

	public int compareTo(CDrawAble o) {
		return new CDepthSorter().compare(this, o);
	}
}
