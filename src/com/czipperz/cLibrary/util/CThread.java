package com.czipperz.cLibrary.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;


/**
 * This class adds start and stop support as shown at <b> http://docs.oracle.com/javase/7/docs/technotes/guides/concurrency/threadPrimitiveDeprecation.html</b>
 * <br />Use the method <b>stopIt()</b> to stop the CThread, <b>pauseIt()</b>  to pause the CThread, and <b>resumeIt()</b> to resume the CThread.
 * @author Chris Gregory
 */
public class CThread extends Thread implements Serializable {
	public static Object stopper = new Object();

	private boolean paused = false;
	private boolean stopped = false;
	private transient Object o = new Object();
	private Runnable run;
	private ArrayList<Long> ints;
	int indexInts = 0;

	public CThread(Runnable run) {
		this(run, true);
	}

	public CThread(Runnable run, boolean b) {
		super();
		CThreadManager.addThread(this);
		this.run = run;
		ints = new ArrayList<Long>();
		if(b)
			start();
	}

	public void run() {
		stopped = false;
		while(!stopped) {
			while(true) {
				synchronized(this) {
					while(paused)
						try {
							o.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
				}
				run.run();
				break;
			}
			ints.add(Calendar.getInstance().getTimeInMillis());
		}
	}

	public void stopIt() {
		stopped = true;
	}

	public void pauseIt() {
		paused = true;
	}

	public void resumeIt() {
		o.notify();
		paused = false;
	}

	public Object getPauser() {
		return o;
	}

	public int getRunsPerSecond() {
		long total = 0;
		int cunt = 0;
		for(Long l : ints) {
			long ne = total + l;
			if(ne <= 1000) {
				total = ne;
				cunt++;
			}
			else {
				break;
			}
		}
		double result = ((double) cunt) * 1000.0 / ((double) total);
		return (int) result;
	}
}
