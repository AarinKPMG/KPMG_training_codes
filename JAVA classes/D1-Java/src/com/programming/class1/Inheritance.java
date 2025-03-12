package com.programming.class1;

class Parent{
	
	int data=10 ;
	int sas=90;
	
	void display() {
		System.out.println("parents class method");
		System.out.println("value of data is "+data);

	}
	
	void show() {
		System.out.println("show Parent");
	}
}


public class Inheritance extends Parent{
	
	int data=20;
	int qw=12;
    
	@Override
	void display() {
		System.out.println("child class method");
		System.out.println("value of data is "+data);
	}
	
	void show() {
		System.out.println("show Child");
	}
	
	public static void main(String[] args) {
		
		Parent par = new Parent();
		System.out.println("Data is "+par.data);
		
		Inheritance chd = new Inheritance();
		System.out.println("Data is "+chd.data);
	}
	
}
