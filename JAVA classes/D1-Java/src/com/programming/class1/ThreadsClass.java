package com.programming.class1;

//thread is the lightweight sub process which is the smallest unit of processing
//CPU does not allocate any memory to threads i.e. contect switching between threads
//happens very phase

//life of thread :
//New
//Runnable
//Running
//Non Runnable
//Terminate

public class ThreadsClass extends Thread {

	public static void main(String[] args) {
		ThreadsClass obj = new ThreadsClass();
		Thread t1 = new Thread(obj);
		t1.start();
	}
	
	public void run() {
		System.out.println("Thread is running");
	}
	
}
