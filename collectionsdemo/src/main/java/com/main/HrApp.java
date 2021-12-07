package com.main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.model.Employee;
import com.service.EmployeeService;
import com.service.EmployeeServiceImpl;

public class HrApp {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		List list = new ArrayList();

		System.out.println("How Many Employees Data You Want to Enter ?");

		int noOfEmpl = sc.nextInt();

		for (int i = 1; i <= noOfEmpl; i++) {

			System.out.println(i + "Employee Data");
			System.out.println("------------------");
			System.out.println("Enter Empl Id ?");
			int id = sc.nextInt();
			System.out.println("Enter Empl Name ?");
			String name = sc.next();
			System.out.println("Enter Empl Salary ?");
			float salary = sc.nextFloat();
			Employee employee = new Employee(id, name, salary);
			list.add(employee);

		}

		EmployeeService employeeService = new EmployeeServiceImpl();
		List<Employee> resultlst = employeeService.searchEmployeeById(list, 5000);

		Iterator<Employee> itr = resultlst.iterator();

		while (itr.hasNext()) {
			Employee result = (Employee) itr.next();
			System.out.println(result.getEmpNo());
			System.out.println(result.getEmpName());
			System.out.println(result.getSalary());

		}
	}
}
