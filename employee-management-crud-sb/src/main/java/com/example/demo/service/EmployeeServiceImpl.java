package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> getEmployee() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeById(long id) {
		Optional<Employee> employee = employeeRepository.findById(id);
		if (employee.isPresent()) {
			return employee.get();
		} else {
			throw new ResourceNotFoundException("Employee", "id", id);
		}

	}

	@Override
	public Employee updateEmployee(Employee employee, long id) {

		Optional<Employee> existingemployee = employeeRepository.findById(id);
		if (existingemployee.isEmpty()) {
			throw new ResourceNotFoundException("Employee", "id", id);
		} else {
			Employee updatedemp = existingemployee.get();
			updatedemp.setFirstName(employee.getFirstName());
			updatedemp.setLastName(employee.getLastName());
			updatedemp.setEmail(employee.getEmail());
			employeeRepository.save(updatedemp);
			return updatedemp;
		}

	}

	@Override
	public void deleteAll() {
		employeeRepository.deleteAll();
	}

	@Override
	public void deleteEmployeeById(long id) {
		employeeRepository.deleteById(id);
		
	}

}
