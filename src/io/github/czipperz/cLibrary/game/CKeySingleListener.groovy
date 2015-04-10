package io.github.czipperz.cLibrary.game

import io.github.czipperz.cLibrary.util.collections.CListMap

import java.awt.event.KeyEvent
import java.awt.event.KeyListener

/**
 * Created by czipperz on 4/8/15.
 */
class CKeySingleListener implements KeyListener {
	private class CO {
		List<KeyListener> listeners;

		public CO() {
			listeners = new ArrayList<>()
		}
	}

	private CListMap<EKeys, CO> e = new CListMap<>()

	void add(EKeys key, KeyListener listener) {
		if(e.containsKey(key))
			e.get(key).listeners.add(listener)
		else
			e.put(key, new CO(listener))
	}

	void remove(EKeys key, KeyListener listener) throws RuntimeException {
		if(e.containsKey(key))
			e.get(key).listeners.remove(listener)
	}

	void keyPressed(KeyEvent ev) {
		e.getKeys().stream().filter({it.getValue() == ev.getKeyCode()}).forEach({e.getItem(it).listeners.stream().forEach({it.keyPressed(ev)})});
	}

	void keyReleased(KeyEvent ev) {
		e.getKeys().stream().filter({it.getValue() == ev.getKeyCode()}).forEach({e.getItem(it).listeners.stream().forEach({it.keyReleased(ev)})});
	}

	void keyTyped(KeyEvent ev) {
		e.getKeys().stream().filter({it.getValue() == ev.getKeyCode()}).forEach({e.getItem(it).listeners.stream().forEach({it.keyTyped(ev)})});
	}
}
