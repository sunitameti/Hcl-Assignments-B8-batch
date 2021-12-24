package com.example.springbootdemo.service;

import java.util.List;

import com.example.springbootdemo.model.Employee;

public interface EmployeeService {
	// lets have CRUD operations
	public abstract Employee createEmployee(Employee employee);

	public abstract List<Employee> readAllEmployee();

	public abstract Employee readById(int empId);

	public abstract Employee readByName(String name);

	public abstract Employee updateEmployee(Employee employee);

	public abstract int deleteById(int empId);

	public abstract int deleteByName(String empName);
}
