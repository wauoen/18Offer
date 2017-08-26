package com.wauoen.offer.java.concurrency;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SemaphoreOnLock {
	private final Lock lock = new ReentrantLock();
	private final Condition permitsAvailable = lock.newCondition();
	private int permits;
	public SemaphoreOnLock(int initialPermits) {
		// TODO Auto-generated constructor stub
		lock.lock();
		try {
			permits = initialPermits;
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			lock.unlock();
		}
	}
	
	public void acquire(){
		lock.lock();
		try {
			while(permits <= 0){
				System.out.println("----");
				permitsAvailable.await();
				
			}
			--permits;
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			lock.unlock();
		}
	}
	
	public void release(){
		lock.lock();
		try {
			++permits;
			
			permitsAvailable.signal();
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			lock.unlock();
		}
	}
	
	public static void main(String args[]) throws InterruptedException{
		
		SemaphoreOnLock semaphore = new SemaphoreOnLock(0);
		semaphore.acquire();
		System.out.println("----333");
		Thread.sleep(2100);
		semaphore.release();
		Semaphore s;
		s.acquire();
	}

	
}
