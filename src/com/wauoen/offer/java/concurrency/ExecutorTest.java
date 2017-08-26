package com.wauoen.offer.java.concurrency;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorTest {
	
	private static final int NTHREADS = 100;
	private static final Executor exec = Executors.newFixedThreadPool(NTHREADS);
	public static void main(String args[]){
		
		ExecutorService es;
		
		
		try {
			ServerSocket socket = new ServerSocket(80);
			while(true){
				final Socket connection = socket.accept();
				Runnable task = new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						System.out.println("Handle Request!!");
					}
				};
				exec.execute(task);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
