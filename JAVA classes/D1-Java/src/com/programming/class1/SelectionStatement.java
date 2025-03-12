package com.programming.class1;
import java.util.Scanner;

public class SelectionStatement {

	public static void main(String[] args) {
	
		int age=18 ;
		String name="aarin" ;
		int marks=50;
		
		Scanner scan = new Scanner(System.in);
		
//		System.out.println("Enter your name : ");
//		name = scan.nextLine();
//		
//		System.out.println("Enter your Age : ");
//		age = scan.nextInt();
//		
		if(age>=18) {
			System.out.println(name+", You are a Major");
		}
		else {
			System.out.println(", You are a Minor");
		}
		
		if(marks>=80) {
			System.out.println("Excellent");

		}
		
	}
	
	
	
	
}
