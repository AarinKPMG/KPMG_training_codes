package com.programming.class1;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class setClass {

	public static void main(String[] args) {
		
		Set<String> setInt = new HashSet<>();
		setInt.add("c");
		setInt.add("a");
		setInt.add("b");
		setInt.add("d");
		
		System.out.println("Size of HashSet : "+ setInt.size());
		
		Iterator<String> itr = setInt.iterator();
		
		while(itr.hasNext()) {
			System.out.println(itr.next()+" ");
		}
		
		setInt.remove("a");
		
		System.out.println("\nSize of HashSet : "+ setInt.size());
		
		itr = setInt.iterator();
		
		while(itr.hasNext()) {
			System.out.println(itr.next()+" ");
		}
		
		Set<Integer> setInt2 = new HashSet<>();
		setInt2.add(12);
		setInt2.add(17);
		setInt2.add(10);
		setInt2.add(24);
		
		System.out.println("\nSize of HashSet : "+ setInt2.size());
		
		Iterator<Integer> itr2 = setInt2.iterator();
		
		while(itr2.hasNext()) {
			System.out.println(itr2.next()+" ");
		}
		
		setInt2.remove(24);
		
		System.out.println("\nSize of HashSet : "+ setInt2.size());
		
		itr2 = setInt2.iterator();
		
		while(itr2.hasNext()) {
			System.out.println(itr2.next()+" ");
		}
		
		Set<Integer> setInt3 = new TreeSet<>();
		setInt3.add(12);
		setInt3.add(17);
		setInt3.add(10);
		setInt3.add(24);
		
		System.out.println("\nSize of TreeSet : "+ setInt3.size());
		
		Iterator<Integer> itr3 = setInt3.iterator();
		
		while(itr3.hasNext()) {
			System.out.println(itr3.next()+" ");
		}
		
		setInt3.remove(12);
		
		System.out.println("\nSize of TreeSet : "+ setInt3.size());
		
		itr3 = setInt3.iterator();
		
		while(itr3.hasNext()) {
			System.out.println(itr3.next()+" ");
		}
	}
	
	
}
