package io.github.czipperz.cLibrary.game

import io.github.czipperz.cLibrary.imaging.CScreen
import io.github.czipperz.cLibrary.util.CThread

import javax.swing.*
import java.awt.*
import java.util.List

/**
 * Created by czipperz on 4/8/15.
 */
class CGameFrame extends JFrame {
	Set<CDrawAble> objects = new TreeSet<>()
	Set<CView> views = new TreeSet<>()
	List<CUpdateAble> updaters = new ArrayList<>(5)
	private CThread updateThread; public CThread getUpdateThread() {return updateThread}
	final Object imageObject = new Object(), updateObject = new Object()
	final CKeys keys
	final CKeySingleListener keySingleListener
	final CMouse mouse
	boolean overlayEnabled = false
	boolean allowConsoleSpam = true, isF7 = true
	boolean showData = false, isF8 = false
	boolean showBorders = false

	private long lastTime = System.nanoTime()
	private double amountOfTicks = 60, ns = 1000000000 / amountOfTicks, delta = 0;
	private long timer = System.currentTimeMillis()
	private int frames = 0

	int bufferWidth, bufferHeight
	Image bufferImage
	Graphics bufferGraphics

	static final int xOffSet = 8
	static final int yOffSet = 30
	static final Point offSet = new Point(xOffSet, yOffSet)

	CGameFrame() {
		keys = new CKeys()
		addKeyListener(keys)
		keySingleListener = new CKeySingleListener()
		addKeyListener(keySingleListener)
		mouse = new CMouse()
		mouse.addToFrame(this)
		setupDraw()
	}

	CGameFrame setFullscreen() {
		this.extendedState = JFrame.MAXIMIZED_BOTH
		this.size = CScreen.size
		this.resizable = false
		this.undecorated = true
		this
	}

	CGameFrame setWindowed() {
		this.extendedState = JFrame.NORMAL
		this.undecorated = false
		this
	}

	CGameFrame setBorderless() {
		this.extendedState = JFrame.NORMAL
		this.undecorated = true
		this
	}

	synchronized void setVisible(boolean visible) {
		super.visible = visible
		updateThread.start()
	}

	private void updateAll() {
		updateOverlayToggle()

		tickBefore()
		tick()
		tickAfter()
	}

	CGameFrame setupDraw() {
		updateThread = new CThread({
			synchronized (updateObject) {
				def now = System.nanoTime()
				delta += (now - lastTime) / ns
				lastTime = now

				while(delta-- >= 1) {
					updateAll()
				}
				frame.repaint()
				frames++
				if(System.currentTimeMillis() - timer > 1000) {
					timer+=1000
					if(allowConsoleSpam)
						println "FPS: $frames"
					frames = 0
				}
			}
		}, false)
		this
	}

	private void updateOverlayToggle() {
		if(overlayEnabled) {
			if(keys.f8) {
				if(isF8) {
					showBorders = !showBorders
					isF8 = true
				}
			} else
				isF8 = false
			if(keys.f7) {
				if(!isF7) {
					showData = !showData
					isF7 = true
				}
			} else
				isF7 = false
		}
	}

	void paint(Graphics g) {
		render(g)
	}

	private void render(Graphics g) {
		if(bufferWidth != getWidth() || bufferHeight != getHeight() || bufferImage == null || bufferGraphics == null) {
			resetBuffer();
		}
		if(bufferGraphics != null) {
			//Clear
			bufferGraphics.clearRect(0, 0, bufferWidth, bufferHeight);
			bufferGraphics.setColor(getBackground());
			bufferGraphics.fillRect(0, 0, getWidth(), getHeight());
			bufferGraphics.setColor(getForeground());
			//Note: sorting is done when objects are added.
			//Draw Before Views
			synchronized(imageObject) {
				//Draw Views
				drawViews(bufferGraphics);
				//Draw After Views
				draw(bufferGraphics);
				//Display
				g.drawImage(bufferImage, getXOffSet(), getYOffSet(), this);
			}
		}
	}

	private synchronized void resetBuffer() {
		bufferWidth = getWidth();
		bufferHeight = getHeight();

		if(bufferGraphics != null) {
			bufferGraphics.dispose();
			bufferGraphics = null;
		}
		if(bufferImage != null) {
			bufferImage.flush();
			bufferImage = null;
		}
		System.gc();

		bufferImage = createImage(bufferWidth, bufferHeight);
		bufferGraphics = bufferImage.getGraphics();
	}

	public void update(Graphics g) {
		paint(g)
	}

	protected CGameFrame drawViews(Graphics g) {
		views.collect() {
			if(it.needDraw())
				it.draw(g)
		}
		this
	}

	CGameFrame draw(Graphics g) {
		if(showData) {
			Font bold = new Font("Arial", Font.BOLD, 14);
			Font normal = new Font("Arial", Font.PLAIN, 14);
			g.setFont(bold);
			g.setColor(Color.GREEN);
			g.drawString("Window Width", 3, 14);
			g.setFont(normal);
			g.drawString(getWidth() + " x " + getHeight(), 3, 30);
			g.setFont(bold);
			g.drawString(objects.size() + " objects.", 3, 46);
			g.setFont(bold);
			g.setColor(Color.RED);
			g.drawString("FPS: " + this.updateThread.getRunsPerSecond(), 3, 62);
		}
		this
	}

	void tickBefore() {
		objects.collect() {
			if(it.needUpdateBefore())
				it.tickBefore()
		}
		updaters.collect() {
			it.updateBefore()
		}
	}

	void tick() {
		objects.collect() {
			if(it.needUpdate())
				it.tick()
		}
		updaters.collect() {
			it.update()
		}
	}

	void tickAfter() {
		objects.collect() {
			if(it.needUpdateAfter())
				it.tickAfter()
		}
		updaters.collect() {
			it.updateAfter()
		}
	}

	CGameFrame addUpdater(CUpdateAble updater) {
		updaters.add(updater)
		this
	}

	CGameFrame addView(CView view) {
		views.add(view)
		this
	}

	public CGameFrame addObject(CDrawAble object) {
		objects.add(object)
		this
	}
}
