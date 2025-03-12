package com.programming.class1;


class Person{
	public String firstName;
	public String lastName;
	
	public Person() {}

	public Person(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
}

public class MethodReferenceClass {
	
	interface Converter<F,T>{
		T convert(F from);
	}
	
	public static void main(String[] args) {
		
		Converter<String,Integer> intConverter = (from)->Integer.valueOf(from);
		Integer convertedValue = intConverter.convert("123");
		System.out.println("integer value is : "+convertedValue);
		
		Converter<String,Integer> intConverterUsingMR = Integer::valueOf;
		Integer convertedValue2 = intConverterUsingMR.convert("456");
		System.out.println("integer value using method reference is : "+convertedValue2);
		
		Converter<String,String> stringConverterUsingMR = StringOperation::startsWith;
		String convertedValue3 = stringConverterUsingMR.convert("method Reference");
		System.out.println("String value using method refference is "+ convertedValue3);;
		
	}
	
	static class StringOperation{
		static String startsWith(String s) {
			return String.valueOf(s.charAt(0));
		}
	}
	
	interface PersonFactore<P extends Person>{
		P create(String firstName , String lastName);
	}
}
