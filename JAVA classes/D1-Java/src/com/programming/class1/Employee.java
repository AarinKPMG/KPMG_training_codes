package com.programming.class1;

public class Employee {
	
	int empID;
	String empName;
	int empAge;
	String empDestination;
	double empSalary;

	
	public int getEmpID() {
		return empID;
	}



	public void setEmpID(int empID) {
		this.empID = empID;
	}



	public String getEmpName() {
		return empName;
	}



	public void setEmpName(String empName) {
		this.empName = empName;
	}



	public int getEmpAge() {
		return empAge;
	}



	public void setEmpAge(int empAge) {
		this.empAge = empAge;
	}



	public String getEmpDestination() {
		return empDestination;
	}



	public void setEmpDestination(String empDestination) {
		this.empDestination = empDestination;
	}



	public double getEmpSalary() {
		return empSalary;
	}



	public void setEmpSalary(double empSalary) {
		this.empSalary = empSalary;
	}

	public static void main(String[] args) {

		Employee emp = new Employee();
		
		emp.setEmpID(123);
		emp.setEmpName("aarin");
		emp.setEmpAge(21);
		emp.setEmpDestination("Software Engineering");
		emp.setEmpSalary(70000.0D);

		System.out.println("Name of the employee is " + emp.getEmpName());
		System.out.println("Age of the employee is " + emp.getEmpAge());
		System.out.println("Destination of the employee is " + emp.getEmpDestination());
		System.out.println("Salary of the employee is " + emp.getEmpSalary());

	}

}

