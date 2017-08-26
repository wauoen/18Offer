package com.wauoen.offer.java.concurrency;

import java.util.concurrent.CountDownLatch;

public class HarnessTest {
	
	public static void main(String args[]){
		
		try {
			new HarnessTest().timeTask(10, new Runnable(){

				@Override
				public void run() {
					System.out.println(""+Thread.currentThread().getName());
				}
				
			});
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public long timeTask(int nThreads, final Runnable task) throws InterruptedException {

		final CountDownLatch startGate = new CountDownLatch(1);
		final CountDownLatch endGate = new CountDownLatch(nThreads);
		for (int i = 0; i < nThreads; i++) {
			Thread t = new Thread() {
				public void run() {

					try {
						startGate.await();
						// TODO Auto-generated method stub
						System.out.println(""+Thread.currentThread().getName()+"startGate.await()");
						try {
							task.run();
						} finally {
//							endGate.countDown();
							System.out.println(""+Thread.currentThread().getName()+"endGate.countDown()"+endGate.getCount());
						}
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				};
			};
			t.start();
		}
		long start = System.nanoTime();
		System.out.println("执行前时间");
		startGate.countDown();
		System.out.println("MainThread:"+Thread.currentThread().getName()+"startGate.countDown()");
		endGate.await();
		System.out.println("执行后时间");
		long end = System.nanoTime();
		
		return end-start;
	}

}
