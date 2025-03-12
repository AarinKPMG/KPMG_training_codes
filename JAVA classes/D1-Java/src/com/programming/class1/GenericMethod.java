package com.programming.class1;

public class GenericMethod {
	
	public static void main(String[] args) {
		
		Integer[] intarr = {1,12,34,67,23};        //wrapper class deceleration
		Character[] chararr = {'z','a','q','d'};
		
		System.out.println("Printing Integer Array : ");
		PrintArray(intarr);
		

		System.out.println("\nPrinting Character Array : ");
		PrintArray(chararr);
		
	}
	
	static <E> void PrintArray( E[] elements ) {
		for(E ele : elements) {
			System.out.println(ele);
		}
	}
}
