package com.programming.class1;

import java.io.IOException;

public class ExceptionProgation {

	public static void main(String[] args) throws IOException {
		a();
	}
	
	static void a() throws IOException {
		b();
	}
	
	static void b() throws IOException {
		c();
	}
	
	static void c() throws IOException{
		throw new IOException("Device Halaythu !");
	}
	
	
}
