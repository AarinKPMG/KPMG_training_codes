package com.programming.class1;

import java.util.Arrays;

public class Sorting_array {
	
	public static void main(String[] args) {
        // Array of integers
        int[] intArray = {5, 2, 8, 1, 3, 7};
        System.out.println("Original integer array: " + Arrays.toString(intArray));
        
        // Sorting the integer array
        Arrays.sort(intArray);
        System.out.println("Sorted integer array: " + Arrays.toString(intArray));
        
        // Array of characters
        char[] charArray = {'z', 'a', 'm', 'k', 'b'};
        System.out.println("Original character array: " + Arrays.toString(charArray));
        
        // Sorting the character array
        Arrays.sort(charArray);
        System.out.println("Sorted character array: " + Arrays.toString(charArray));
        
        Employee_sorting[] empArr = new Employee_sorting[4];
        empArr[0] = new Employee_sorting(967, "Preetham", "IT", 30000, 23, "Male", "Bangalore", 2022);
        empArr[1] = new Employee_sorting(431, "Aarin", "IT", 75000, 30, "Male", "Bangalore", 2025);
        empArr[2] = new Employee_sorting(635, "Koushik", "IT", 45000, 32, "Male", "Bangalore", 2023);
        empArr[3] = new Employee_sorting(143, "Sunil", "IT", 95000, 24, "Male", "Bangalore", 2024);
    
        Arrays.sort(empArr);
        System.out.println("Sorted Array by ID - "+Arrays.toString(empArr));
        
        for(Employee_sorting e : empArr) {
        	System.out.println("EmpID - "+e.getId() );
        	System.out.println("EmpName - "+e.getName() );
        	System.out.println("EmpDept - "+e.getDeptName() );
        	System.out.println("EmpSalary - "+e.getSalary() );
        	System.out.println("\n");
        }
        
        Arrays.sort(empArr, empArr.);
	}
}
