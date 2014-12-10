package com.czipperz.cLibrary.util;

import java.util.ArrayList;
import java.util.List;

import com.czipperz.cLibrary.util.collections.CListMap;

public class CThreadManager {
	private CThreadManager() {
		threads = new ArrayList<CThread>(5);
		threadPausers = new CListMap<CThread, Object>();
	}
	
	public static CListMap<CThread, Object> threadPausers;

	public static List<CThread> threads;

	public synchronized static void addThread(CThread thread) {
		if(threads == null || threadPausers == null) {
			new CThreadManager();
		}
		threads.add(thread);
		threadPausers.put(thread, thread.getPauser());
	}

	public synchronized static void pauseAllBut(CThread thread) {
		for(CThread t : threads) {
			if(!t.equals(thread)) {
				t.pauseIt();
			}
		}
	}

	public synchronized static void pauseAllBut(ArrayList<CThread> threads) {
		for(CThread t : CThreadManager.threads) {
			boolean passs = true;
			for(CThread th : threads) {
				if(t.equals(th)) {
					passs = false;
				}
			}
			if(passs) {
				t.pauseIt();
			}
		}
	}

	public synchronized static void resumeAll() {
		for(CThread t : threads) {
			t.resumeIt();
		}
	}

	public synchronized static void resumeAllBut(CThread thread) {
		for(CThread t : threads) {
			if(!t.equals(thread)) {
				t.resumeIt();
			}
		}
	}

	public synchronized static void resumeAllBut(ArrayList<CThread> threads) {
		for(CThread t : threads) {
			for(CThread th : threads) {
				if(!t.equals(th)) {
					t.resumeIt();
				}
			}
		}
	}
	
	public synchronized static void stopAllBut(CThread thread) {
		for(CThread t : threads) {
			if(!t.equals(thread)) {
				t.stopIt();
			}
		}
	}

	public synchronized static void stopAllBut(ArrayList<CThread> threads) {
		for(CThread t : threads) {
			for(CThread th : threads) {
				if(!t.equals(th)) {
					t.stopIt();
				}
			}
		}
	}
}