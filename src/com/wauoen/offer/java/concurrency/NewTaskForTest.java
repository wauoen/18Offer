package com.wauoen.offer.java.concurrency;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class NewTaskForTest {

}

 interface CancelableTask2<T> extends Callable{

	 void cancel();
	 RunnableFuture<T> newTask();
}

 class CancelableExecutor extends ThreadPoolExecutor{

	public CancelableExecutor(int corePoolSize, int maximumPoolSize,
			long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
		super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
		// TODO Auto-generated method stub
	
		
		return super.newTaskFor(callable);
	}
	 
 }