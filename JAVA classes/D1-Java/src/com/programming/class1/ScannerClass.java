package com.programming.class1;

import java.util.Scanner;

public class ScannerClass {

	public static void main(String[] args) {
		
		String str = "Aarin";
		Scanner sc = new Scanner(str);
		
		System.out.println("Boolean Result : "+sc.hasNext());
		
		System.out.println("String : "+sc.nextLine());
		sc.close();
		
		System.out.println("Enter the Details : -----");
		Scanner in = new Scanner(System.in);
		
		System.out.print("Enter Name : ");
		String name = in.next();
		
		System.out.print("Enter age :  ");
		int age = in.nextInt();
		
		System.out.println("\nName : "+name );
		System.out.println("Age : "+age );
		
		System.out.print("Enter new Age : ");
		age = in.nextInt();
		
		System.out.println("New Age : "+age );
		
		in.close();
		
		String str2 = "This is aarin who is working in kpmg global service";
		Scanner sc2 = new Scanner(str2);
		
		while(sc2.hasNext()) {
			System.out.println(sc2.next());
		}
		
	}
	
}
