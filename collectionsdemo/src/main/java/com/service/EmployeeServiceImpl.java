package com.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.model.Employee;

public class EmployeeServiceImpl implements EmployeeService {

	@Override
	public List<Employee> searchEmployeeById(List listOfEmployee, float salary) {

		List<Employee> employees = new ArrayList<Employee>();

		Iterator<Employee> iterable = listOfEmployee.iterator();

		while (iterable.hasNext()) {

			Employee employee = (Employee) iterable.next();

			if (employee.getSalary() >= salary) {
				employees.add(employee);
			}
		}

		return employees;
	}

}
