package com.model;

public class EmployeeTester {

	public static void main(String[] args) {

		Employee emp = new Employee();
		Employee emp1 = new Employee();
		emp.setEmp_id(1);
		emp.setName("John");
		emp.setDepartment("IT");
		emp.setSalary(500);
		emp.setAddress("Mysore");
		emp.setEmail("John@gmail.com");

		emp1.setEmp_id(2);
		emp1.setName("David");
		emp1.setDepartment("HR");
		emp1.setSalary(500);
		emp1.setAddress("chennai");
		emp1.setEmail("David@gmail.com");

		System.out.println(emp);
		System.out.println(emp1);

		int total = emp1.getSalary() + emp.getSalary();

		System.out.println("total salary:" + total);

	}

}
