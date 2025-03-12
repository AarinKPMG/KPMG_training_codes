package com.programming.class1;

public class Final_keyword {
	
	//Non static variable as final keyword -
	//Non static variable as final keyword -
	//Final method -
	//final class -
	
	static final String PAN_CARD_NUMBER ;
	
	static {
		PAN_CARD_NUMBER = "AHYPC8989K";
	}
	
//	Final_keyword(){
//		PAN_CARD_NUMBER = "AHYPC8989K";
//	}
	
	final void display() {
		System.out.println(PAN_CARD_NUMBER);
	}
	
	public static void main(String[] args) {
		
		Final_keyword obj = new Final_keyword();
		obj.display();
		
	}
	
}
