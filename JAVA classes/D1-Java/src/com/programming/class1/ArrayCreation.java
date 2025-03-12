package com.programming.class1;
import java.util.ArrayList;

public class ArrayCreation {

	public static void main(String[] args) {
		int[] arr = new int[5];
		
		for(int i=0 ; i<arr.length ; i++) {
			arr[i]=i*i;
		}
		
		for(int i=0 ; i<arr.length ; i++) {
			System.out.print(arr[i]+" ");
		}
		
		
		char[] st = {'a','a','b','i','n'};

		for(int i=0; i<st.length ; i++) {
			System.out.print(st[i]);
		}
		
		int f = arr[0];
		for(int i=0 ; i<arr.length ; i++) {
			if(f>arr[i])
				f=arr[i];
		}
		
		System.out.println("\nMin : "+f);
	}
	
	
}
