package io.github.czipperz.cLibrary.util

import com.czipperz.cLibrary.util.collections.CListMap
import groovy.transform.Immutable

/**
 * Created by czipperz on 4/8/15.
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
		for(CThread t : threads)
			if(!(t == thread))
				t.paused = true
	}

	synchronized static void pauseAllBut(ArrayList<CThread> threads) {
		for(CThread t : threads) {
			boolean pass = true
			for(CThread th : threads)
				if(t == th)
					pass = false
			if(pass)
				t.paused = true
		}
	}

	synchronized static void resumeAll() {
		for(CThread t : threads)
			t.paused = false
	}

	synchronized static void resumeAllBut(CThread thread) {
		for(CThread t : threads)
			if(!(t == thread))
				t.paused = false
	}

	synchronized static void resumeAllBut(ArrayList<CThread> threads) {
		for(CThread t : threads) {
			boolean pass = true
			for(CThread th : threads)
				if(t == th)
					pass = false
			if(pass)
				t.paused = false
		}
	}

	synchronized static void stopAllBut(CThread thread) {
		for(CThread t : threads)
			if(!(t == threads))
				t.stopped = true
	}

	synchronized static void stopAllBut(ArrayList<CThread> threads) {
		for(CThread t : threads) {
			boolean pass = true
			for(CThread th : threads)
				if(t == th)
					pass = false
			if(pass)
				t.stopped = true
		}
	}
}
