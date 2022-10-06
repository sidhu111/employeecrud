package com.ptg.employeeservice.service;

import java.util.List;
import java.util.Optional;

import com.ptg.employeeservice.entity.Employee;

public interface EmployeeInterface {
	
	Employee saveEmployee(Employee employee);
	
	List<Employee> getAllEmployees();
	
	Optional<Employee> findById(Long employeeId);
	
	 Employee updateEmployee(Employee updatedEmployee);
	 
	 void deleteEmployee(Long Id);
	 
	 List<Employee> findByPhoneno(Long mobileno);

}
