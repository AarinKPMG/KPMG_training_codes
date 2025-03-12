package com.programming.class1;

class customClass<T>{
	
	T obj ;
	
	void set(T obj) {
		this.obj = obj;
	}
	
	T get() {
		return obj;
	}

}

public class GenericClass {
	
	public static void main(String[] args) {
	
		customClass<Integer> gc = new customClass<>();
		
		gc.set(1221);
		gc.obj = 23;
		System.out.println("Integer is : "+gc.get());
		
		customClass<String> gc2 = new customClass<>();
		
		gc2.set("People are so smart");
		System.out.println("Integer is : "+gc.get());
		
	}
}


