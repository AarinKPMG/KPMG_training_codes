package com.programming.class1;

public class Customer {

	String firstNm;
	String lastNm;
	int age;
	String Adr;

	public String getFirstNm() {
		return firstNm;
	}

	public void setFirstNm(String firstNm) {
		this.firstNm = firstNm;
	}

	public String getLastNm() {
		return lastNm;
	}

	public void setLastNm(String lastNm) {
		this.lastNm = lastNm;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAdr() {
		return Adr;
	}

	public void setAdr(String adr) {
		Adr = adr;
	}

	public static void main(String[] args) {
		
		Customer cus = new Customer();
		
		cus.setFirstNm("Poornima");
		cus.setLastNm("Medi");
		cus.setAge(20);
		cus.setAdr("BMS Hostel");
		
		System.out.println("First Name of customer is "+cus.getFirstNm());
		System.out.println("Last Name of customer is "+cus.getFirstNm());
		System.out.println("Age of customer is "+cus.getAge());
		System.out.println("Address of customer is "+cus.getAdr());

		
	}
}
