package com.programming.class1;

import java.util.ArrayList;
import java.util.List;

public class UseOfGeneric {

	public static void main(String[] args) {
		
		System.out.println("List of Any DataType : \n");
		
		List list1 = new ArrayList();
		
		list1.add("1");
		list1.add(12);
		list1.add(true);
		
		for(int i=0 ; i<list1.size() ; i++) {
			System.out.println(list1.get(i));
		}
		
		System.out.println("\nList of Integers : \n");

		
		List<Integer> Ilist = new ArrayList<>();
		
		Ilist.add(1);
		Ilist.add(2);
		Ilist.add(3);
		Ilist.add(4);
		
		for(int i=0 ; i<Ilist.size(); i++) {
			System.out.println(Ilist.get(i));
		}
		
		System.out.println("\nList of Stirngs : \n");
		
		List<String> Slist = new ArrayList<>();
		
		Slist.add("Aarin");
		Slist.add("Rohit");
		Slist.add("Poormina");
		Slist.add("Snehal");
		
		for(int i=0 ; i<Slist.size(); i++) {
			System.out.println(Slist.get(i));
		}
	}
	
}
