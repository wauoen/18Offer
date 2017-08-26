package com.wauoen.offer.java.concurrency;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Semaphore;

/**
 * –≈∫≈¡ø
 * 
 * @author wauoen
 * 
 */
public class BoundedHashSet<T> {

	private Set<T> set;
	private Semaphore sem;

	public BoundedHashSet(int bound) {

		this.set = Collections.synchronizedSet(new HashSet<T>());
		sem = new Semaphore(bound);
	}

	public boolean add(T t) throws InterruptedException {

		sem.acquire();
		boolean wasAdd = false;
		try {

			wasAdd = set.add(t);
			return wasAdd;
		} finally {
			if (!wasAdd) {
				sem.release();
			}
		}
	}
	
	public boolean remove(Object o){
		
		boolean wasRemove = set.remove(o);
		if(wasRemove){
			sem.release();
		}
		return wasRemove;
	}
}
