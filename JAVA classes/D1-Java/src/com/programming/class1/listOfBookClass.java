package com.programming.class1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class listOfBookClass {
	
	public static void main(String[] args) {
		
		List<book> listbook = new ArrayList<>();
		
		book b1 = new book(123, "A" , "B" , "C" , 1000 );
		book b2 = new book(151, "G" , "H" , "J" , 1000 );
		book b3 = new book(249, "V" , "X" , "Z" , 1000 );
		
		listbook.add(b1);
		listbook.add(b2);
		listbook.add(b3);
		
		Iterator<book> itr = listbook.iterator();
		int i=1;
		
		while(itr.hasNext()) {
			
			book b = itr.next();
			System.out.println("\nBook No."+(i++));
			System.out.println(b.bookID);
			System.out.println(b.bookName);
			System.out.println(b.bookAuthor);
			System.out.println(b.bookPublisher);
			System.out.println(b.bookQuantity);
			
		}
		
		Set<book> setB = new HashSet<>();
		
		setB.add(b1);
		setB.add(b2);
		setB.add(b3);
		
		System.out.println("\nSet Value :");
		i=1;
		
		Iterator<book> itrB = setB.iterator();	
		
		while(itrB.hasNext()) {
			book b = itrB.next();
			System.out.println("\nBook No."+(i++));
			System.out.println(b.bookID);
			System.out.println(b.bookName);
			System.out.println(b.bookAuthor);
			System.out.println(b.bookPublisher);
			System.out.println(b.bookQuantity);
		}
		
		book b4 = new book(164 , "O" , "P" , "I" , 1000 );
		
		System.out.println("\ncomparing b1 and b4 : " + b1.compareTo(b4));
		System.out.println("comparing b2 and b4 : " + b2.compareTo(b4));
		System.out.println("comparing b3 and b4 : " + b3.compareTo(b4));
		
	}
	
}
