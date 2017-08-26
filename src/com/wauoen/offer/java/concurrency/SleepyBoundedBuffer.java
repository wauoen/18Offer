package com.wauoen.offer.java.concurrency;

public class SleepyBoundedBuffer<V> extends BaseBoundedBuffer<V>{

	protected SleepyBoundedBuffer(int capacity) {
		super(capacity);
		// TODO Auto-generated constructor stub
	}
	
	public void put(V v) throws InterruptedException{
		while(true){
			synchronized (this) {
				if (!isFull()) {
					
					doPut(v);
					return;
				}
			}
			Thread.sleep(1000);
		}
	}
	

	public V take() throws InterruptedException{
		while(true){
			synchronized (this) {
			
				if (isEmpty()) {
					return doTake();
				}
				
			}
			Thread.sleep(1000);
		}
	}
	
}
