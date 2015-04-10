package io.czipperz.github.cLibrary.game

import io.czipperz.github.cLibrary.exceptions.CEnumTypeNotListedException
import io.czipperz.github.cLibrary.imaging.CGraphics
import io.czipperz.github.cLibrary.location.CRect

import java.awt.*
import java.util.List

/**
 * Created by czipperz on 4/9/15.
 */
class CView implements CDrawAble {
	boolean drawAllObjects
	List<CDrawAble> toDraw = null

	Dimension bufferDimension
	Image bufferImage
	Graphics bufferGraphics

	CGameFrame displayOn

	CView(CGameFrame displayOn, Rectangle bounds, int depth = 0) {
		this.bounds = bounds
		this.displayOn = displayOn
		this.drawAllObjects = true
		this.depth = depth
		this.bufferDimension = new Dimension()
		this.needDraw = true
	}

	CView(CGameFrame displayOn) {
		this(displayOn, displayOn.getBounds())
	}

	@Override
	boolean needUpdate() {
		return false
	}

	CDrawAble tick() {
		return this
	}

	CDrawAble draw(Graphics g) {
		while(!preparePaint()) {}
		paintRuntime(g)
	}

	private boolean preparePaint() {
		if(bufferDimension.width != getDisplayOn().getWidth() || bufferDimension.height != getDisplayOn().getHeight() || bufferImage == null || bufferGraphics == null) {
			resetBuffer();
		}
		if(bufferGraphics != null) {
			//Clear
			bufferGraphics.clearRect(0,0, (int) bufferDimension.width, (int) bufferDimension.height);
			return true;
		}
		false;
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

		bufferImage = getDisplayOn().createImage((int) bufferDimension.width, (int) bufferDimension.height);
		bufferGraphics = bufferImage.getGraphics();
	}

	private CView paintRuntime(Graphics g) {
		if(needDraw) {
			//Draws everything on the supplied CGameFrame
			if (drawAllObjects) {
				displayOn.objects.collect() {
					if(it.needDraw)
						it.draw(g)
					if(displayOn.showBorders) {
						g.color = Color.BLACK
						g.drawRect(it.bounds.x - 1, it.bounds.y - 1, it.bounds.width + 1, it.bounds.height + 1);
					}
				}
			}
			//Draws everything specifically given to it to start.
			else if (toDraw != null)
				toDraw.collect() {
					if(it.needDraw)
						it.draw(g)
					else
						g.setColor(Color.BLACK)
					g.drawRect(it.bounds.x - 1, it.bounds.y - 1, it.bounds.width + 1, it.bounds.height + 1)
				}
			else
				throw new CEnumTypeNotListedException();
		}
		//Display
		new CGraphics(g).drawImage(bufferImage, bounds != null ? bounds : displayOn.bounds, new CRect(0,0,bufferDimension).toRectangle(), displayOn);
		this
	}

	boolean isDrawAllObjects() {
		return drawAllObjects
	}

	void setDrawAllObjects(boolean b = true) {
		if(b) {
			this.drawAllObjects = b
			this.toDraw = null
			return
		}
		this.toDraw = new ArrayList<>()
		this.drawAllObjects = false
	}

	void setToDraw(CDrawAble toDraw) {
		List<CDrawAble> to = new ArrayList<>()
		to.add(toDraw)
		this.toDraw = to
	}

	void addToDraw(CDrawAble toDraw) {
		this.toDraw.add(toDraw)
	}

	void addToDraw(ArrayList<CDrawAble> toDraw) {
		toDraw.collect() {
			addToDraw(it)
		}
	}
}
