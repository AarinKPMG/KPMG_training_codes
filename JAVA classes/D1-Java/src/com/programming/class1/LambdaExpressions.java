package com.programming.class1;

interface SampleInterface{
	String SampleMethod(String parameter);
}

public class LambdaExpressions{
	
	public static void main(String[] args) {
		
		SampleInterface obj1 = (name)->{return "Welcome"+name; };
		System.out.println(obj1.SampleMethod(" To functional Interface style of programming"));
		
		CompareValues obj2 = (n1,n2)->{ return n1>n2;};
		boolean res = obj2.Compare(12,15);
		System.out.println("Result is : "+res);
	}
}

@FunctionalInterface
interface CompareValues{
	boolean Compare( int a1, int a2);
}
