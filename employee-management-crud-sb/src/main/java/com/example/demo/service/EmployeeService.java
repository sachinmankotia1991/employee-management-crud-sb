package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Employee;

public interface EmployeeService {

	Employee saveEmployee(Employee employee);
	List<Employee> getEmployee();
	Employee getEmployeeById(long id);
	Employee updateEmployee(Employee employee, long id);
	void deleteAll();
	void deleteEmployeeById(long id);

}
