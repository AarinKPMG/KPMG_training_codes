package com.programming.class1;

public class ThrowError {

	public static void main(String[] args) {
		
		sampleMethod();
		System.out.println("Read of Code...");
		
	}
	
	static void sampleMethod() {
		throw new NullPointerException("Null Object");
	}
	
}
