package com.programming.class1;

abstract class Shape{
	
	abstract void draw();
	
	void ShowArea(double ar) {
		System.out.println("Area is "+ar);
	}
	
}

class Square extends Shape{

	@Override
	void draw() {
		// TODO Auto-generated method stub
		System.out.println("Drawing Square");
		double l=20 , b=30 ;
		double area = l*b ;
		ShowArea(area);
		
	}
	
}


public class TestAbstraction {
	
}
