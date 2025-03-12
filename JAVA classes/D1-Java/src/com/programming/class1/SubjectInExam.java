package com.programming.class1;

public class SubjectInExam implements Exam{
	
	String course_code ;
	int MCQ_count ;
	int CodingAssignment_count ;
	
	public SubjectInExam(String cc , int a , int b) {
		// TODO Auto-generated constructor stub
		this.course_code = cc;
		this.MCQ_count = a;
		this.CodingAssignment_count = b;
	}
	
	@Override
	public void noOfMCQ() {
		// TODO Auto-generated method stub
		System.out.println("Number of MCQ : "+MCQ_count);
		
	}

	@Override
	public void noOfCodingAssignment() {
		// TODO Auto-generated method stub
		System.out.println("Number of Coding Question : "+ CodingAssignment_count);
	}
	
	public static void main(String[] args) {
		
		SubjectInExam sub1 = new SubjectInExam("1rrqeff" , 20, 2);
		
		sub1.noOfMCQ();
		sub1.noOfCodingAssignment();
		sub1.get_time();
		
	}

}
