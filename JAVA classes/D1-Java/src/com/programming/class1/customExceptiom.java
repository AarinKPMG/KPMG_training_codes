package com.programming.class1;

class InvalidAgeException extends Exception{
	public InvalidAgeException(String msg) {
		super(msg);
	}
}

public class customExceptiom {
	
	public static void main(String[] args) throws InvalidAgeException{
		validateAge(17);
	}
	
	static void validateAge(int age) throws InvalidAgeException{
		
		if(age<18) {
			throw new InvalidAgeException("User can not vote");
		}
		else {
			System.out.println("User can vote");
		}
		
	}
	
}
