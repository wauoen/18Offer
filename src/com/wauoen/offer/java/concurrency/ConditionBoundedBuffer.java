package com.wauoen.offer.java.concurrency;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.annotation.Generated;

public class ConditionBoundedBuffer<T> {

	private final Lock lock = new ReentrantLock();
	private final Condition notFul = lock.newCondition();
	private final Condition notEmpty = lock.newCondition();

	private final int BUFFER_SIZE = 10;
	private final T[] items = (T[]) new Object[BUFFER_SIZE];

	private int tail, head, count;

	private void put(T t) {

		lock.lock();
		try {

			while (count == items.length) {
				notFul.await();
			}
			items[tail] = t;
			if (++tail == items.length) {
				tail = 0;
			}
			++count;
			notEmpty.signal();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			lock.unlock();
		}
	}

	public T take() {
		lock.lock();
		try {

			while (count == 0)
				notEmpty.await();
			T x = items[head];
			if (++head == items.length) {
				head = 0;
			}
			--count;
			notFul.signal();
			return x;
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			lock.unlock();
		}
		return null;
	}
}

