package io.czipperz.github.cLibrary.util

import groovy.transform.Immutable
import io.czipperz.github.cLibrary.util.collections.CListMap

/**
* @author czipperz on 4/8/15.
*/
@Immutable
class CThreadManager {
	static List<CThread> threads = new ArrayList<>(5);
	static CListMap<CThread, Object> threadPausers = new CListMap<>();

	synchronized static void addThread(CThread thread) {
		threads.add thread
		threadPausers.put thread, thread.pauser
	}

	synchronized static void pauseAllBut(CThread thread) {
		threads.each {
			if(!(it == thread))
				it.paused = true
		}
	}

	synchronized static void pauseAllBut(ArrayList<CThread> threads) {
		this.threads.each {
			if(!threads.contains(it))
				it.paused = true
		}
	}

	synchronized static void resumeAll() {
		threads.each {it.paused = false}
	}

	synchronized static void resumeAllBut(CThread thread) {
		threads.each {
			if(!(it == thread))
				it.paused = false
		}
	}

	synchronized static void resumeAllBut(ArrayList<CThread> threads) {
		this.threads.each {
			if(!threads.contains(it))
				it.paused = false
		}
	}

	synchronized static void stopAllBut(CThread thread) {
		threads.each {
			if(!(thread == it))
				it.stopped = true
		}
	}

	synchronized static void stopAllBut(ArrayList<CThread> threads) {
		this.threads.each {
			if(!threads.contains(it))
				it.stopped = true
		}
	}
}
