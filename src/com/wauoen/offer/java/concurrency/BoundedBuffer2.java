package com.wauoen.offer.java.concurrency;

public class BoundedBuffer2<V> extends BaseBoundedBuffer<V>{

	protected BoundedBuffer2(int capacity) {
		super(capacity);
		// TODO Auto-generated constructor stub
	}
	
	public synchronized void put(V v) throws InterruptedException{
		
		while(isFull()){
			wait();
		}
		
		doPut(v);
		notifyAll();
	}
	
	public synchronized V take() throws InterruptedException{
		while(isEmpty()){
			wait();
		}
		V v = doTake();
		notifyAll();
		return v;
	} 

}
