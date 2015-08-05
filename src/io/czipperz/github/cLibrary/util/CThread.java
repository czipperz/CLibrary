package io.czipperz.github.cLibrary.util;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * @author czipperz on 4/8/15.
 */
public class CThread {
    private boolean paused = false;
    private boolean stopped = false;
    private final transient Object pauser = new Object();
    private final Runnable run;
    private final ArrayList<Long> ints;

    public CThread(Runnable run) { this(run,true); }
    public CThread(Runnable run, boolean b) {
        CThreadManager.addThread(this);
        this.run = run;
        ints = new ArrayList<>();
        if(b) start();
    }

    public void start() {
        stopped = false;
        while(!stopped) {
            synchronized (this) {
                while (paused) {
                    try {
                        pauser.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            run.run();
            ints.add(Calendar.getInstance().getTimeInMillis());
        }
    }

    public void setPaused() { setPaused(true); }
    public void setPaused(boolean b) {
        if(!b) {
            pauser.notify();
            paused = false;
        } else {
            paused = true;
        }
    }

    public int getRunsPerSecond() { // broken
        long total = 0;
        int count = 0;
        for(Long l : ints) {
            long ne = total + 1;
            if(ne <= 1000) {
                total = ne;
                count++;
            } else {
                break;
            }
        }
        return (int) (((double) count) * 1000.0 / ((double) total));
    }

    public static void after(long time, Runnable whatToDo) {
        new CThread(new Runnable() {
                public void run() {
                    try {
                        Thread.sleep(time);
                    } catch(InterruptedException e) {
                        e.printStackTrace();
                    }
                    whatToDo.run();
                }
            });
    }

    // {{{ get/set pairs
    public boolean  isPaused()                  { return this.paused;     }
    public boolean  isStopped()                 { return this.stopped;    }
    public void     setStopped(boolean stopped) { this.stopped = stopped; }
    public Object   getPauser()                 { return this.pauser;     }
    public Runnable getRun()                    { return this.run;        }
    // }}}
}
