package io.github.czipperz.cLibrary.util

import groovy.transform.Immutable
import io.github.czipperz.cLibrary.util.collections.CListMap

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
		CClosureHelper.forEach(threads, { it == thread }) {
			it.paused = true
		}
	}

	synchronized static void pauseAllBut(ArrayList<CThread> threads) {
		CClosureHelper.forEach(this.threads, { threads.contains(it) }) {
			it.paused = true
		}
	}

	synchronized static void resumeAll() {
		threads*.paused = false
	}

	synchronized static void resumeAllBut(CThread thread) {
		CClosureHelper.forEach(threads, {it == thread}) {
			it.paused = false
		}
	}

	synchronized static void resumeAllBut(ArrayList<CThread> threads) {
		CClosureHelper.forEach(this.threads, {threads.contains(it)}) {
			it.paused = false
		}
	}

	synchronized static void stopAllBut(CThread thread) {
		CClosureHelper.forEach(threads, {thread == it}) {
			it.stopped = true
		}
	}

	synchronized static void stopAllBut(ArrayList<CThread> threads) {
		CClosureHelper.forEach(this.threads, {threads.contains(it)}) {
			it.stopped = true
		}
	}
}
