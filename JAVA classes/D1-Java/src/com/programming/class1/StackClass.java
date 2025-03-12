package com.programming.class1;

import java.util.Stack;


public class StackClass {

	public static void main(String[] args) {
		
		Stack<Integer> st = new Stack<>();
		showPush(st,45);
		showPush(st,54);
		showPush(st,90);
		showPush(st,12);
		
		showPop(st);
		showPop(st);
		showPop(st);

		showPush(st,100);
	}
	
	static void showPush( Stack<Integer> st, int a) {
		st.push(new Integer(a));
		System.out.println("Stack after pushed : "+st);
	}
	
	static void showPop( Stack<Integer> st) {
		Integer a = st.pop();
		System.out.println("Stack after popped : "+st);
	}
	
}
