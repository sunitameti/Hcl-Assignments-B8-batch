package com.model;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.main.Employee;

public class EmployeeTester {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("container.xml");
		Employee employee = (Employee) applicationContext.getBean("Employee");
		System.out.println("Employee Number  : " + employee.getEmpId());
		System.out.println("Employee Name  : " + employee.getEmpName());
		System.out.println("Employee Salary  : " + employee.getEmpSalary());

		System.out.println("The end");
	}

}
