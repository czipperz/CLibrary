package io.github.czipperz.cLibrary.util

import com.czipperz.cLibrary.util.CThreadManager

/**
 * Created by czipperz on 4/8/15.
 */
class CThread {
	static Object stopper = new Object()

	boolean paused = false;
	boolean stopped = false;
	final transient Object pauser = new Object()
	final Runnable run
	final ArrayList<Long> ints
	final int indexInts = 0

	CThread(Runnable run, boolean b = true) {
		CThreadManager.addThread(this);
		this.run = run
		ints = new ArrayList<>()
		if(b) start();
	}

	void start() {
		stopped = false;
		while(!stopped) {
			synchronized (this) {
				while (paused)
					try {
						pauser.wait()
					} catch (InterruptedException e) {
						e.printStackTrace()
					}
			}
			run.run()
			ints.add(Calendar.getInstance().getTimeInMillis())
		}
	}

	void setPaused(boolean b = true) {
		if(!b) {
			pauser.notify()
			paused = false
		}
		else
			paused = true
	}

	int getRunsPerSecond() {
		long total = 0
		int count = 0
		for(Long l : ints) {
			long ne = total + 1
			if(ne <= 1000) {
				total = ne
				count++
			} else
				break
		}
		return (int) (((double) count) * 1000.0 / ((double) total))
	}

	static void after(long time, Closure whatToDo) {
		new CThread(new Runnable() {
			void run() {
				try {
					Thread.sleep(time)
				} catch(InterruptedException e) {
					e.printStackTrace()
				}
				whatToDo()
			}
		})
	}
}
