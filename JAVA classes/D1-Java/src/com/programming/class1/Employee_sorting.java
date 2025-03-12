package com.programming.class1;

public class Employee_sorting implements Comparable<Employee_sorting> {
    // Fields
    private int id;
    private String name;
    private String deptName;
    private double salary;
    private int age;
    private String gender;
    private String city;
    private int yearOfJoining;

    // Constructor
    public Employee_sorting(int id, String name, String deptName, double salary, int age, String gender, String city, int yearOfJoining) {
        this.id = id;
        this.name = name;
        this.deptName = deptName;
        this.salary = salary;
        this.age = age;
        this.gender = gender;
        this.city = city;
        this.yearOfJoining = yearOfJoining;
    }
    
    //comparing the ID
    public int compareTo(Employee_sorting other) {
        return Integer.compare(this.id, other.id);
    }

    // Getter and Setter methods (optional, for accessing and modifying fields)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getYearOfJoining() {
        return yearOfJoining;
    }

    public void setYearOfJoining(int yearOfJoining) {
        this.yearOfJoining = yearOfJoining;
    }

    // Main method for testing
    public static void main(String[] args) {
        Employee_sorting emp = new Employee_sorting(1, "John Doe", "IT", 75000, 30, "Male", "Mumbai", 2015);
        System.out.println("Employee ID: " + emp.getId());
        System.out.println("Employee Name: " + emp.getName());
        System.out.println("Department Name: " + emp.getDeptName());
        System.out.println("Salary: " + emp.getSalary());
        System.out.println("Age: " + emp.getAge());
        System.out.println("Gender: " + emp.getGender());
        System.out.println("City: " + emp.getCity());
        System.out.println("Year of Joining: " + emp.getYearOfJoining());
    }
}
