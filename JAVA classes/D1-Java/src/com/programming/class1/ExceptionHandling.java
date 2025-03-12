package com.programming.class1;

public class ExceptionHandling {

	public static void main(String[] args) {
		
		int num = 0;
		
		int intArr[] = {1,2,3};
		
		try {
			num = 50 / 0;
		}
		catch
			(ArithmeticException e){
				System.out.println(e.getMessage());
			}
			System.out.println("number is " + num);
			
		try {
			for(int i = 0; i <= intArr.length; i ++) {
				System.out.println(intArr[i] + " ");
			}
		}	
		catch(ArrayIndexOutOfBoundsException e){
			System.out.println(e.getMessage());
		}
			
		System.out.println("Rest of code...");
			
			
		ExceptionHandling obj = new ExceptionHandling();
		obj = null;
		obj.sample();
								
	}
		
	void sample() {
		System.out.println("hi");
	}
}