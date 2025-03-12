package com.programming.class1;

class Duration{
	
	long stv , endv ;
	
	Duration(){
		stv = 0;
		endv = 0;
	}
	
	Duration(int a , int b ){
		
		if( a > b ) {
			throw new IllegalArgumentException("start should be less than end");
		}
		
		this.stv = a;
		this.endv = b ;
		
	}
}

public class Constructor extends Duration{

	private int dd ;
	private int mm ;
	private int yy ;
	
	Constructor(){
		
		System.out.println("aarin is stupid");
		this.dd=01;
		this.mm=01;
		this.yy=2021;
		
	}
	
	public static void main(String[] args) {
		
		Constructor cus = new  Constructor();
		System.out.println("Today is "+cus.dd+"/"+cus.mm+"/"+cus.yy);
		
		Duration dur = new Duration(12,  18);
		System.out.println("start time : "+dur.stv + "\nend time: "+dur.endv);	
	}
	
}

