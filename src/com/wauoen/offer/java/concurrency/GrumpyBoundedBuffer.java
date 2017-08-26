package com.wauoen.offer.java.concurrency;

import java.nio.BufferOverflowException;

public class GrumpyBoundedBuffer<V> extends BaseBoundedBuffer<V>{

	protected GrumpyBoundedBuffer(int capacity) {
		super(capacity);
		// TODO Auto-generated constructor stub
		
	}
	
	public synchronized void put(V v){
		if (isFull()) {
			throw new BufferOverflowException();
		}
		doPut(v);
	}
	
	public synchronized V take(){
		if (isEmpty()) {
			
			throw new BufferOverflowException();
		}
		return doTake();
	}

	
}
