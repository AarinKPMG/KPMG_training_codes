package com.programming.class1;

public class book implements Comparable<book> {

	int bookID ;
	String bookName ;
	String bookAuthor ;
	String bookPublisher ;
	float bookQuantity;
	
	public book(int bookID , String bookName , String bookAuthor , String bookPublisher , float bookQuantity ) {
		// TODO Auto-generated constructor stub
		this.bookID = bookID;
		this.bookName = bookName ;
		this.bookAuthor = bookAuthor ;
		this.bookPublisher = bookPublisher ;
		this.bookQuantity = bookQuantity ;
		
	}
	
	@Override
	public int compareTo(book o){
		if(bookID > o.bookID) 
			return 1;
		else if(bookID < o.bookID)
			return -1;
		else
			return 0;
	}
	
	
}
