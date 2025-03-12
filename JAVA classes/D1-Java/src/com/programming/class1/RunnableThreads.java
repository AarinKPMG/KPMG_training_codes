package com.programming.class1;

public class RunnableThreads implements Runnable{

	public static void main(String[] args) {
		RunnableThreads obj = new RunnableThreads();
		Thread t1 = new Thread(obj);
		t1.start();
	}
	
	@Override
	public void run() {
		System.out.println("Threads is Running");
	}
}
