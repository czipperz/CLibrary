package io.czipperz.github.cLibrary.game

import io.czipperz.github.cLibrary.location.CMouseSafe

import javax.swing.JFrame
import java.awt.event.MouseEvent
import java.awt.event.MouseListener

/**
 * Created by czipperz on 4/8/15.
 */
class CMouse extends CMouseSafe implements MouseListener {
	private boolean leftDown = false, rightDown = false, middleDown = false
	private ArrayList<MouseEvent> ev
	private MouseEvent event = null

	CMouse() {
		ev = new ArrayList<>()
	}

	CMouse addToFrame(JFrame frame) {
		frame.addMouseListener(this)
		return this
	}

	private void add(MouseEvent e) {
		ev.add(e)
		if(event == null)
			event = e
	}

	void mouseClicked(MouseEvent mouseEvent) {
		add e
	}

	void mousePressed(MouseEvent mouseEvent) {
		add e
		switch(e.getButton()) {
			case MouseEvent.BUTTON1:
				leftDown = true; break
			case MouseEvent.BUTTON3:
				rightDown = true; break
			case MouseEvent.BUTTON2:
				middleDown = true; break
		}
	}

	void mouseReleased(MouseEvent mouseEvent) {
		add e
		switch(e.getButton()) {
			case MouseEvent.BUTTON1:
				leftDown = false; break
			case MouseEvent.BUTTON3:
				rightDown = false; break
			case MouseEvent.BUTTON2:
				middleDown = false; break
		}
	}

	void mouseEntered(MouseEvent mouseEvent) {
		add e
	}

	void mouseExited(MouseEvent mouseEvent) {
		add e
	}

	MouseEvent getEvent() {
		return event
	}

	boolean next() {
		if(ev.size() == 0) {
			event = null
			return false
		}

		return (event = ev.remove(0)) != null
	}

	ArrayList<MouseEvent> getEvents() {
		return ev
	}

	public boolean isLeftDown() {
		return leftDown;
	}

	public boolean isRightDown() {
		return rightDown;
	}

	public boolean isMiddleDown() {
		return middleDown;
	}
}
