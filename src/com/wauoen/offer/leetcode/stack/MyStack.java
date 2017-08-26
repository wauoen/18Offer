package com.wauoen.offer.leetcode.stack;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
	
	private LinkedList mQueue= null;

	/** Initialize your data structure here. */
	public MyStack() {
		
		mQueue = new LinkedList<>();

	}

	/** Push element x onto stack. */
	public void push(int x) {

		mQueue.add(0,x);
	}

	/** Removes the element on top of the stack and returns that element. */
	public int pop() {
		
		int i = 0;
		if(!mQueue.isEmpty())
			i = (int) mQueue.remove(0);
		return i;
	}

	/** Get the top element. */
	public int top() {

		return -1;
	}

	/** Returns whether the stack is empty. */
	public boolean empty() {

		return false;
	}

}
