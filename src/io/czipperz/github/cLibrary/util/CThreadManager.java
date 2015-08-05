package io.czipperz.github.cLibrary.util;

import io.czipperz.github.cLibrary.util.collections.CListMap;

import java.util.ArrayList;
import java.util.List;

/**
 * @author czipperz on 4/8/15.
 */
public class CThreadManager {
    private static List<CThread> threads = new ArrayList<>(5);

    public synchronized static void addThread(CThread thread) {
        threads.add(thread);
    }

    public synchronized static void pauseAllBut(CThread thread) {
        for (CThread it : threads) {
            if(!(it == thread)) {
                it.setPaused(true);
            }
        }
    }

    public synchronized static void pauseAllBut(ArrayList<CThread> threads) {
        for (CThread it : threads) {
            if(!threads.contains(it)) {
                it.setPaused(true);
            }
        }
    }

    public synchronized static void resumeAll() {
        for (CThread it : threads) {
            it.paused = false;
        }
    }

    public synchronized static void resumeAllBut(CThread thread) {
        for (CThread it : threads) {
            if(!(it == thread)) {
                it.paused = false;
            }
        }
    }

    public synchronized static void resumeAllBut(ArrayList<CThread> threads) {
        for (CThread it : threads) {
            if(!threads.contains(it)) {
                it.paused = false;
            }
        }
    }

    public synchronized static void stopAllBut(CThread thread) {
        for (CThread it : threads) {
            if(!(thread == it)) {
                it.stopped = true;
            }
        }
    }

    public synchronized static void stopAllBut(ArrayList<CThread> threads) {
        for (CThread it : this.threads) {
            if(!threads.contains(it)) {
                it.stopped = true;
            }
        }
    }

    //{{{ get/set pairs
    public List getThreads() { return this.threads; }
    //}}}
}
