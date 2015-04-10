package io.czipperz.github.cLibrary.game

import io.czipperz.github.cLibrary.util.collections.CListMap

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

		public CO(KeyListener listener) {
			listeners = new ArrayList<>()
			listeners.add listener
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
		e.keys.each{if(it.value == ev.keyCode) {e.getItem(it).listeners.each {it.keyPressed(ev)}}}
	}

	void keyReleased(KeyEvent ev) {
		e.keys.each{if(it.value == ev.keyCode) {e.getItem(it).listeners.each {it.keyReleased(ev)}}}
	}

	void keyTyped(KeyEvent ev) {
		e.keys.each{if(it.value == ev.keyCode) {e.getItem(it).listeners.each {it.keyTyped(ev)}}}
	}
}
