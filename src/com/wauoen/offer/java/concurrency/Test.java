package com.wauoen.offer.java.concurrency;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Test {
	
	private static final ScheduledExecutorService cancelExec = null;
	
	public static void timedRun(Runnable r,long timeout,TimeUnit unit){
		
		final Thread taskThread = Thread.currentThread();
		cancelExec.schedule(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				taskThread.interrupt();
			}
		}, timeout, unit);
		r.run();
	}
	
	
	
	public boolean sendOnSharedLine(Srting message){
		
		
	}

}
