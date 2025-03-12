package com.programming.class1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class WorkerThread implements Runnable{

	public String message;
	
	WorkerThread(String s){
		this.message=s;
	}
	
	public void run() {
		System.out.println("Thread Name : "+Thread.currentThread().getName()+" - message "+ message);
		
		try {
			Thread.sleep(2000);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("Thread Name : "+ Thread.currentThread().getName() + " - Ended");
	}
	
}

public class MultiThreadingExample {
	
	public static void main(String[] args) {
		
		ExecutorService executor = Executors.newFixedThreadPool(5);
		
		for(int i=0 ; i<10 ; i++) {
			Runnable worker = new WorkerThread(" "+i);
			executor.execute(worker);
		}
		try {
			System.out.println("Attempted to shutdown executor");
			executor.shutdown();
			executor.awaitTermination(5, TimeUnit.SECONDS);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			if(!executor.isTerminated()) {
				System.out.println("Cancel non finished tasks");
			}
			executor.shutdown();
			System.out.println("shutdown finished");
		}
		
	}
}
