package com.service;

import java.util.List;

import com.model.Employee;

public interface EmployeeService {
	public abstract List<Employee> searchEmployeeById(List listOfEmployee, float salary);

}
