package com.programming.class1;
import java.time.LocalTime;

public interface Exam {

	public void noOfMCQ();
	public void noOfCodingAssignment();
	
	
	default void get_time() {
		LocalTime time = LocalTime.now();
		System.out.println("Present time : "+time);
	}
}

