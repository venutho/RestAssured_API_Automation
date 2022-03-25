package com.sprintboot.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprintboot.crud.dao.EmployeeRepository;
import com.sprintboot.crud.entity.Employee;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public Employee createEmployee(Employee employee) {
		return employeeRepository.save(employee);

	}

	public List<Employee> createEmployees(List<Employee> employees) {
		return employeeRepository.saveAll(employees);
	}

	public Employee getEmployeeById(int id) {
		return employeeRepository.findById(id).orElse(null);

	}

	public List<Employee> getEmployees() {
		return employeeRepository.findAll();
	}

	public Employee updateEmployee(Employee employee) {
		Employee oldEmp;

		Optional<Employee> optionalemployee = employeeRepository.findById(employee.getId());
		if (optionalemployee.isPresent()) {
			oldEmp = optionalemployee.get();
			oldEmp.setName(employee.getName());
			oldEmp.setLanguage(employee.getLanguage());
			oldEmp.setStatus(employee.getStatus());
			return employeeRepository.save(oldEmp);
		} else {
			return employeeRepository.save(employee);
		}
	}

	public String deleteEmployeeById(int id) {
		employeeRepository.deleteById(id);
		return "Employee got deleted";

	}

}
