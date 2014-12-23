package com.czipperz.cLibrary.game;

import com.czipperz.cLibrary.exceptions.CDoNotCallException;
import com.czipperz.cLibrary.location.CMouseSafe;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

/**
 * A class that extends all methods of CMouse and adds upon that a allowance for MouseEvent handling.
 * @author Chris Gregory
 * @see java.awt.event.MouseListener
 * @see com.czipperz.cLibrary.location.CMouseUnsafe
 * @see com.czipperz.cLibrary.location.CMouseSafe
 */
public class CMouse extends CMouseSafe implements MouseListener {
	private boolean leftDown = false, rightDown = false, middleDown = false;
	private ArrayList<MouseEvent> ev;
	private MouseEvent event = null;

	CMouse() {
		ev = new ArrayList<>();
	}
	
	CMouse addToFrame(JFrame frame) {
		frame.addMouseListener(this);
		return this;
	}

	private void add(MouseEvent e) {
		ev.add(e);
		if(event == null) {
			event = e;
		}
	}
	
	/**
	 * DO NOT CALL!!!
	 * @throws com.czipperz.cLibrary.exceptions.CDoNotCallException
	 */
	public void mouseClicked(MouseEvent e) throws CDoNotCallException {
		add(e);
	}

	/**
	 * DO NOT CALL!!!
	 * @throws com.czipperz.cLibrary.exceptions.CDoNotCallException
	 */
	public void mouseEntered(MouseEvent e) throws CDoNotCallException {
		add(e);
	}

	/**
	 * DO NOT CALL!!!
	 * @throws com.czipperz.cLibrary.exceptions.CDoNotCallException
	 */
	public void mouseExited(MouseEvent e) throws CDoNotCallException {
		add(e);
	}

	/**
	 * DO NOT CALL!!!
	 * @throws com.czipperz.cLibrary.exceptions.CDoNotCallException
	 */
	public void mousePressed(MouseEvent e) throws CDoNotCallException {
		add(e);
		if(e.getButton() == MouseEvent.BUTTON1) {
			leftDown = true;
		}
		if(e.getButton() == MouseEvent.BUTTON3) {
			rightDown = true;
		}
		if(e.getButton() == MouseEvent.BUTTON2) {
			middleDown = true;
		}
	}

	/**
	 * DO NOT CALL!!!
	 * @throws com.czipperz.cLibrary.exceptions.CDoNotCallException
	 */
	public void mouseReleased(MouseEvent e) throws CDoNotCallException {
		add(e);
		if(e.getButton() == MouseEvent.BUTTON1) {
			leftDown = false;
		}
		if(e.getButton() == MouseEvent.BUTTON3) {
			rightDown = false;
		}
		if(e.getButton() == MouseEvent.BUTTON2) {
			middleDown = false;
		}
	}
	

	
	/**
	 * Move to the next event that has been stored.
	 *
	 * @return True if there is still an event to process
	 */
	public boolean next() {
		if (ev.size() == 0) {
			event = null;
			return false;
		}

		event = ev.remove(0);

		return event != null;
	}
	
	/**
	 * Returns the event currently stored.  To advance to the next event, call next().
	 * @return The event currently stored
	 * @see {@link #next()}
	 */
	public MouseEvent getEvent() {
		return event;
	}
	
	/**
	 * Returns the array of events currently stored.  NOTE: the first item stored is what getEvent() returns.
	 * @return all events stored past and including the current event being stored (note you must call next() to change the current event).
	 * @see {@link #getEvent()}
	 * @see {@link #next()}
	 */
	public ArrayList<MouseEvent> getEvents() {
		return ev;
	}
	
	/**
	 * You can't read huh?
	 */
	public boolean isLeftDown() {
		return leftDown;
	}

	/**
	 * You can't read huh?
	 */
	public boolean isRightDown() {
		return rightDown;
	}

	/**
	 * You can't read huh?
	 */
	public boolean isMiddleDown() {
		return middleDown;
	}
}
