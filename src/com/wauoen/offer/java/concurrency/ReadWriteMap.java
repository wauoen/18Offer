package com.wauoen.offer.java.concurrency;

import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteMap<K, V> {

	private final Map<K, V> map;
	private final ReadWriteLock lock = new ReentrantReadWriteLock();
	private final Lock r = lock.readLock();
	private final Lock w = lock.writeLock();

	public ReadWriteMap(Map<K, V> map) {

		this.map = map;
	}

	public V put(K key, V value) {

		w.lock();
		try {
			return map.put(key, value);
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			w.unlock();
		}
		return null;
	}

	public V get(Object key) {

		r.lock();
		try {
			this.map.get(key);
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			r.unlock();
		}
	}
}
