package com.programming.class1;

public class SleepMethodThreadsClass extends Thread{
	
	public static void main(String[] args) {
		
		SleepMethodThreadsClass s1 = new SleepMethodThreadsClass();
		SleepMethodThreadsClass s2 = new SleepMethodThreadsClass();
		
		s1.start();
		s2.start();
	}
	
	@Override
	public void run() {
		for(int i=0 ; i<5 ; i++) {
			try {
				Thread.sleep(500);
				System.out.println(i);
			}
			catch(Exception e) {
				System.out.println("Error in Thread Launching");
			}
		}
	}
}
