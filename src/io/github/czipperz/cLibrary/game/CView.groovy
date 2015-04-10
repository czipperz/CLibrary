package io.github.czipperz.cLibrary.game

import com.czipperz.cLibrary.exceptions.CEnumTypeNotListedException
import io.github.czipperz.cLibrary.imaging.CGraphics
import io.github.czipperz.cLibrary.location.CRect
import org.w3c.dom.css.Rect

import java.awt.Color
import java.awt.Dimension
import java.awt.Graphics
import java.awt.Image
import java.awt.Rectangle

/**
 * Created by czipperz on 4/9/15.
 */
class CView extends CObject implements CDrawAble{
	boolean drawAllObjects
	List<CDrawAble> toDraw = null

	Dimension bufferDimension
	Image bufferImage
	Graphics bufferGraphics

	CView(CGameFrame displayOn, Rectangle bounds, int depth = 0) {
		super(displayOn, bounds)
		this.drawAllObjects = true
		this.depth = depth
		this.bufferDimension = new Dimension()
	}

	CView(CGameFrame displayOn) {
		this(displayOn, displayOn.getBounds())
	}

	CDrawAble tick() {
		return this
	}

	Rectangle getBounds() {
		return null
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
		if(needDraw()) {
			//Draws everything on the supplied CGameFrame
			if (drawAllObjects) {
				displayOn.objects.collect() {
					if(it.needDraw())
						it.draw(g)
					if(displayOn.showBorders) {
						if(it instanceof CObject)
							g.color = it.outlineColor
						else
							g.color = Color.BLACK
						g.drawRect(it.bounds.x - 1, it.bounds.y - 1, it.bounds.width + 1, it.bounds.height + 1);
					}
				}
			}
			//Draws everything specifically given to it to run.
			else if (toDraw != null)
				toDraw.collect() {
					if(it.needDraw())
						it.draw(g)
					else
						g.setColor(Color.BLACK)
					g.drawRect(it.bounds.x - 1, it.bounds.y - 1, it.bounds.width + 1, it.bounds.height + 1)
				}
			else
				throw new CEnumTypeNotListedException();
		}
		//Display
		new CGraphics(g: g).drawImage(bufferImage, drawRect != null ? drawRect : displayOn.bounds, new CRect(0,0,bufferDimension).toRectangle(), displayOn);
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
