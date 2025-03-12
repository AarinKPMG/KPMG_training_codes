package com.programming.class1;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class HashMapClass {

	public static void main(String[] args) {
		
		HashMap<String, Integer> mp = new HashMap<>() ;
		
		mp.put("Nithin",1);
		mp.put("Sanjana",2);
		mp.put("Aarin",3);
		
		for( String k : mp.keySet()) {
			System.out.println("key : "+k+", value : "+mp.get(k));
		}
		
		mp.remove("Aarin");
		
		for( String k : mp.keySet()) {
			System.out.println("key : "+k+", value : "+mp.get(k));
		}
		
		Map<Integer,String> tmp = new HashMap<>();
		
		tmp.put(123,"ABC");
		tmp.put(567,"XZC");
		tmp.put(621,"EWR");
		tmp.put(null,"Aarin");
		tmp.put(453, null);
		tmp.put(982, null);
		
		System.out.println("\nhashMap : \n");
		for(Map.Entry<Integer,String> m : tmp.entrySet()) {
			System.out.println(m.getKey()+ " : "+ m.getValue());
		}
		
	}
	
}
