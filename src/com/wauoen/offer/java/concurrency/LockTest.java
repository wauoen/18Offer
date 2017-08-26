package com.wauoen.offer.java.concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {
	
	Lock lock = new ReentrantLock();
	
	
	public boolean sendOnSharedLine(String message) throws InterruptedException{
		
		lock.lockInterruptibly();
		try {
			return cancellableSendOnSharedLine(message);
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			lock.unlock(); 
		}
		
		
		ReadWriteLock lock = null;
		
		
	}
	
	
	private boolean cancellableSendOnSharedLine(String message) throws InterruptedException{
		
		return false;
	}

}
