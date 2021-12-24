package com.example.springbootdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootdemo.model.Employee;
import com.example.springbootdemo.service.EmployeeService;

@RestController
@RequestMapping(value = "hcl")

public class EmployeeController {
	@Autowired // it will take data automatically
	EmployeeService employeeService;

	@RequestMapping(value = "emp")
	public Employee getEmployee() {
		return new Employee(10, "Ten", 1010.0f);

	}

	@PostMapping(value = "create")
	public ResponseEntity<Employee> create(@RequestBody Employee employee) { // ResponseEntity==combination of header
																				// and body
		Employee employee2 = employeeService.createEmployee(employee);
		return new ResponseEntity<Employee>(employee2, HttpStatus.CREATED); // body==employee status or
																			// header==httpStatus.
	}

	@GetMapping(value = "read1/{data}")
	public ResponseEntity<Employee> readOne(@PathVariable int empId) {
		Employee employee = employeeService.readById(empId);
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}

	@GetMapping(value = "read2/{data}")
	public ResponseEntity<Employee> readTwo(@PathVariable String name) {
		Employee employee = employeeService.readByName(name);
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}

	@PutMapping(value = "update")
	public ResponseEntity<Employee> update(@RequestBody Employee employee) {
		Employee employee1 = employeeService.updateEmployee(employee);
		return new ResponseEntity<Employee>(employee1, HttpStatus.OK);
	}

	@DeleteMapping(value = "delete/{arg}")
	public ResponseEntity<Integer> deleteByName(@PathVariable String arg) {
		int var = employeeService.deleteByName(arg);
		return new ResponseEntity<Integer>(var, HttpStatus.GONE);
	}

}
