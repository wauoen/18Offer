package com.wauoen.offer.java.concurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Preloader {
	
	
	public static void main(String args[]){
		
		
		Preloader loader = new Preloader();
		loader.start();
		try {
			System.out.println(loader.getString());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = 0; i <10; i++) {
			System.out.println("=======");
		}
	}
	
	
	private FutureTask<String> future = new FutureTask<>(new Callable<String>() {
		public String call() throws Exception {
			
			
			System.out.println("Start Work");
			Thread.sleep(5000);//模拟执行任务操作
			System.out.println("Work finish!");
			
			return "Hello FutureTask";
		};
	});
	
	private Thread thread = new Thread(future);
	
	
	
	public void start(){
		thread.start();
	}
	
	public String getString() throws InterruptedException{
		
		try {
			return future.get();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "erro";
	}

}
