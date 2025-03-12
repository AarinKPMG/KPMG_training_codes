package com.programming.class1;

class Parentcl{
	
	static void disp() {
		System.out.println("Im Parent");
	}
	
}

public class ThisAndSuper extends Parentcl{

	static void disp() {
		System.out.println("Im child");
	}
	
	void system() {
		
		System.out.println("Called by This :");
		this.disp();
		System.out.println("\nCalled by super :");
		super.disp();
		
		
	}	
	
	public static void main(String[] args) {
		
		ThisAndSuper a = new ThisAndSuper();
		a.system();
		
	}
	
}
