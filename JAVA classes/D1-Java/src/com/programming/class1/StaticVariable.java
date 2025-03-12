package com.programming.class1;

public class StaticVariable {
	
	static int count1 ;
	private int count2 ;
	
	StaticVariable(){
		count1++;
		count2++;
		System.out.println("value of count is "+ count1 +","+ count2 );
	}
	
	public static void main( String[] args) {
		
		StaticVariable st1 = new StaticVariable();
		StaticVariable st2 = new StaticVariable();
		StaticVariable st3 = new StaticVariable();
		
	}

}
