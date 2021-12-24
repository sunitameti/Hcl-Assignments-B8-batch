package com.example.springbootdemo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.springbootdemo.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Override
	public Employee createEmployee(Employee employee) {
		System.out.println("Create in employee service" + employee.getEmpNo());
		System.out.println("Create in employee service" + employee.getEmpName());
		System.out.println("Create in employee service" + employee.getSalary());

		return employee;
	}

	@Override
	public List<Employee> readAllEmployee() {
		Employee employee1 = new Employee(1, "one", 1111f);
		Employee employee2 = new Employee(2, "Two", 2222f);
		Employee employee3 = new Employee(3, "Three", 3333f);

		List<Employee> employees = new ArrayList<Employee>();
		employees.add(employee1);
		employees.add(employee2);
		employees.add(employee3);
		return employees;
	}

	@Override
	public Employee readById(int empId) {
		Employee employee = null; // dummy object
		if (empId == 10) {
			employee = new Employee(10, "Ten", 1010f);
		}
		if (empId == 20) {
			employee = new Employee(20, "Twenty", 2020f);
		}
		return employee;
	}

	@Override
	public Employee readByName(String name) {
		Employee employee = null;
		if (name.equals("Hello")) {
			employee = new Employee(10, "Hello", 1010f);

		}
		if (name.equals("World")) {
			employee = new Employee(20, "World", 2020f);

		}
		return employee;
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		System.out.println("Update in service layer" + employee.getEmpNo());
		return employee;
	}

	@Override
	public int deleteById(int empId) {
		System.out.println("Delete in service layer" + empId);
		return 1;
	}

	@Override
	public int deleteByName(String empName) {
		System.out.println("Update in service layer" + empName);
		return 2;
	}

}
