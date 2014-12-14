package com.czipperz.cLibrary.game;

import com.czipperz.cLibrary.util.collections.CListMap;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * A class that allows for concise listening by KeyListeners on a designated key.  KeyListeners can be registered multiple times to different (or the same) key and multiple keys may be bound to the same key.
 * @author Chris Gregory
 *
 */
public class CKeySingleListener implements KeyListener {
	private static class CO {
		public List<KeyListener> listeners;

		public CO() {
			listeners = new ArrayList<KeyListener>();
		}

		public CO(KeyListener listener) {
			this();
			listeners.add(listener);
		}
	}

	private static CListMap<EKeys, CO> e = new CListMap<EKeys, CO>();


	/**
	 * Adds the designated listener to the key.
	 * @param key - the key that will have this listener added.
	 * @param listener - the listener that will called on events from the designated key.
	 */
	public static void add(EKeys key, KeyListener listener) {
		if(e.containsKey(key))
			e.get(key).listeners.add(listener);
		else
			e.put(key, new CO(listener));
	}

	/**
	 * Removes the designated listener from the key.
	 * @param key - the key that will have this listener removed.
	 * @param listener - the listener that will no longer be called on events from the designated key.
	 * @throws java.security.InvalidParameterException will be thrown if the inputed key does not have any listeners.
	 */
	public static void remove(EKeys key, KeyListener listener) throws InvalidParameterException {
		if(e.containsKey(key))
			try {
				e.get(key).listeners.remove(listener);
			} catch(RuntimeException e) {
				throw new InvalidParameterException("The inputed key does not have any registered listeners.");
			}
		else
			throw new InvalidParameterException("The inputed key does not have any registered listeners.");
	}

	public void keyPressed(KeyEvent ev) {
		Iterator<EKeys> keys = e.iteratorKeys();
		for(int i = 0; keys.hasNext(); i++) {
			EKeys k = keys.next();
			if(k.getValue() == ev.getKeyCode())
				for(KeyListener l : e.getItem(i).listeners)
					l.keyPressed(ev);
		}
	}

	public void keyReleased(KeyEvent ev) {
		Iterator<EKeys> keys = e.iteratorKeys();
		for(int i = 0; keys.hasNext(); i++) {
			EKeys k = keys.next();
			if(k.getValue() == ev.getKeyCode())
				for(KeyListener l : e.getItem(i).listeners)
					l.keyReleased(ev);
		}
	}

	public void keyTyped(KeyEvent ev) {
		Iterator<EKeys> keys = e.iteratorKeys();
		for(int i = 0; keys.hasNext(); i++) {
			EKeys k = keys.next();
			if(k.getValue() == ev.getKeyCode())
				for(KeyListener l : e.getItem(i).listeners)
					l.keyTyped(ev);
		}
	}
}
