package com.czipperz.cLibrary.game;

import com.czipperz.cLibrary.util.CThread;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.Serializable;
import java.util.*;
import java.util.List;

/**
 * A class that handles everything frame related.  There is built in double-buffering, object storage, and overlay (
 * @author Chris Gregory
 * @see IIDDrawAble
 */
public class CGameFrame extends JFrame implements IDrawAble, Serializable, MouseListener, MouseMotionListener {
	private Set<IIDDrawAble> objects = new TreeSet<IIDDrawAble>();
	private Set<CView> views = new TreeSet<CView>();
	private List<IUpdateAble> updaters = new ArrayList<IUpdateAble>(5);
	private int depth = 1000;
	private CThread updateThread;
	private Object imageObject = new Object(), updateObject = new Object();
	//private BufferStrategy strategy;

	/**
	 * Makes a new CGameFrame.
	 * @see CGameFrame
	 */
	public CGameFrame() {
		super();
		addKeyListener(new CKeys());
		CMouse.addToFrame(this);
		setupDraw();
		//createBufferStrategy(2);
		//strategy = getBufferStrategy();
		//this.setIgnoreRepaint(true);
	}

	public void setFullscreen() {
		this.setExtendedState(Frame.MAXIMIZED_BOTH);
		this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		this.setResizable(false);
		this.setUndecorated(true);
	}

	public void setWindowed(Dimension size) {
		setWindowed();
		this.setSize(size);
	}

	/**
	 * @see {@link #setWindowed(java.awt.Dimension)}
	 */
	public void setWindowed() {
		this.setExtendedState(Frame.NORMAL);
		this.setUndecorated(false);
	}

	public void setBorderless(Dimension size) {
		setBorderless();
		this.setSize(size);
	}

	/**
	 * Sets the Frame to "undecorated" mode (no title bar or resizing options)
	 */
	public void setBorderless() {
		this.setExtendedState(Frame.NORMAL);
		this.setUndecorated(true);
	}

	public void mouseDragged(MouseEvent ev) {
		for(IIDDrawAble o : objects) {
			if(o instanceof CEntity) {
				if(((CEntity)o).getBounds().contains(CMouse.getLocation()))
					((CEntity)o).mouseDragged(ev);
			}
			if(o instanceof MouseMotionListener) {
				((MouseMotionListener) o).mouseDragged(ev);
			}
		}
	}

	public void mouseMoved(MouseEvent ev) {
		for(IIDDrawAble o : objects) {
			if(o instanceof CEntity) {
				if(((CEntity)o).getBounds().contains(CMouse.getLocation()))
					((CEntity)o).mouseMoved(ev);
			}
			if(o instanceof MouseMotionListener) {
				((MouseMotionListener) o).mouseMoved(ev);
			}
		}
	}

	public void mouseClicked(MouseEvent ev) {
		for(IIDDrawAble o : objects) {
			if(o instanceof CEntity) {
				if(((CEntity)o).getBounds().contains(CMouse.getLocation()))
					((CEntity)o).mouseClicked(ev);
			}
			if(o instanceof MouseListener) {
				((MouseListener) o).mouseClicked(ev);
			}
		}
	}

	public void mouseEntered(MouseEvent ev) {
		for(IIDDrawAble o : objects) {
			if(o instanceof CEntity) {
				if(((CEntity)o).getBounds().contains(CMouse.getLocation()))
					((CEntity)o).mouseEntered(ev);
			}
			if(o instanceof MouseListener) {
				((MouseListener) o).mouseEntered(ev);
			}
		}
	}

	public void mouseExited(MouseEvent ev) {
		for(IIDDrawAble o : objects) {
			if(o instanceof CEntity) {
				if(((CEntity)o).getBounds().contains(CMouse.getLocation()))
					((CEntity)o).mouseExited(ev);
			}
			if(o instanceof MouseListener) {
				((MouseListener) o).mouseExited(ev);
			}
		}
	}

	public void mousePressed(MouseEvent ev) {
		for(IIDDrawAble o : objects) {
			if(o instanceof CEntity) {
				if(((CEntity)o).getBounds().contains(CMouse.getLocation()))
					((CEntity)o).mousePressed(ev);
			}
			if(o instanceof MouseListener) {
				((MouseListener) o).mousePressed(ev);
			}
		}
	}

	public void mouseReleased(MouseEvent ev) {
		for(IIDDrawAble o : objects) {
			if(o instanceof CEntity) {
				if(((CEntity)o).getBounds().contains(CMouse.getLocation()))
					((CEntity)o).mouseReleased(ev);
			}
			if(o instanceof MouseListener) {
				((MouseListener) o).mouseReleased(ev);
			}
		}
	}

	public static int getXOffSet() {
		return 8;
	}

	public static int getYOffSet() {
		return 30;
	}

	public static Point getOffSet() {
		return new Point(getXOffSet(), getYOffSet());
	}

	public synchronized void setVisible(boolean visible) {
		super.setVisible(visible);
		updateThread.start();
	}

	public CGameFrame setupDraw() {
		updateThread = new CThread(new Runnable() {
			public void run() {
				synchronized(updateObject) {
					long start = Calendar.getInstance().getTimeInMillis();
					updateAll();
					repaint();
					long dif = Calendar.getInstance().getTimeInMillis() - start;
					long sl = 15 - dif;
					try {
						Thread.sleep(sl);
					} catch (RuntimeException e) {
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}, false);
		return this;
	}

	private void updateAll() {
		update();
		for(IUpdateAble o : updaters) {
			o.updateBefore();
		}
		for(IIDDrawAble o : objects)  {
			Class<?>[] in = o.getClass().getInterfaces();
			for(Class<?> i : in) {
				if(i.getName().equals("IUpdateAble")) {
					((IUpdateAble) o).update();
				}
			}
		}
		for(IUpdateAble o : updaters) {
			o.update();
		}
	}

	private boolean isF7 = false;
	private boolean showData = false;
	private boolean isF8 = false;
	private boolean showBorders = false;

	private void update() {
		while(true) {
			if(CKeys.isF8()) {
				if(isF8) {

				}
				else {
					showBorders = !showBorders;
					isF8 = true;
				}
				break;
			}
			isF8 = false;
			break;
		}
		while(true) {
			if(CKeys.isF7()) {
				if(isF7) {

				} else {
					showData = !showData;
					isF7 = true;
				}
				break;
			}
			isF7 = false;
			break;
		}
	}


	public void paint(Graphics g) {
		render(g);
	}

	/*
	private void render() {
		if(strategy == null) {
			try {
				strategy = getBufferStrategy();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		while(strategy == null) {
			try {
				createBufferStrategy(2);
				strategy = getBufferStrategy();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		Graphics g = strategy.getDrawGraphics();
		render(g);
		g.dispose();
		strategy.show();
		Toolkit.getDefaultToolkit().sync();
	}
	 */

	private int bufferWidth, bufferHeight;
	private Image bufferImage;
	private Graphics bufferGraphics;
	private void render(Graphics g) {
		//If wrong reset
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
				drawBefore(bufferGraphics);
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
		paint(g);
	}

	/**
	 * Draw before the views
	 * @param g - the Graphics to draw onto
	 * @return this
	 */
	protected CGameFrame drawBefore(Graphics g) {
		return this;
	}

	protected CGameFrame drawViews(Graphics g) {
		//Collections.sort(views, new CDepthSorter());
		for(CView v : views) {
			v.draw(g);
		}
		return this;
	}

	/**
	 * Draw after the views.
	 * @param g - the Graphics to draw onto
	 * @return this
	 */
	public CGameFrame draw(Graphics g) {
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
		return this;
	}

	public boolean isShowBorders() {
		return showBorders;
	}

	public CGameFrame setDepth(int depth) {
		this.depth = depth;
		return this;
	}

	public int getDepth() {
		return depth;
	}

	public Set<IIDDrawAble> getObjects() {
		return objects;
	}

	public CGameFrame addObject(IIDDrawAble object) {
		if(object instanceof CView)
			addView((CView) object);
		else {
			objects.add(object);
		}
		return this;
	}

	public List<IUpdateAble> getUpdaters() {
		return updaters;
	}

	public CGameFrame addUpdater(IUpdateAble updater) {
		updaters.add(updater);
		return this;
	}

	public CGameFrame addView(CView view) {
		views.add(view);
		return this;
	}

	public CGameFrame addViews(Collection<? extends CView> views) {
		this.views.addAll(views);
		return this;
	}

	public Set<CView> getViews() {
		return views;
	}

	public boolean needUpdate() {
		return true;
	}

	public CThread getUpdateThread() {
		return updateThread;
	}

	public Object getImageObject() {
		return imageObject;
	}

	public int compareTo(IDrawAble o) {
		return 0;
	}
}
