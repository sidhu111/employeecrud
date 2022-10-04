package com.ptg.employeeservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.ptg.employeeservice.entity.Employee;
import com.ptg.employeeservice.repository.EmployeeRepository;

@Service
public class EmployeeserviceImpl {
	
	@Autowired
	EmployeeRepository employeerepository;
	
	

	public Employee saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		
		return employeerepository.save(employee);
		
	}



	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return employeerepository.findAll();
	}



	public Optional<Employee> findById(Long employeeId) {
		// TODO Auto-generated method stub
		return employeerepository.findById(employeeId);
	}
	
	


	
	  public List<Employee> getByMobileno(Long mobileno) { 
		  // TODO Auto-generated
	   return employeerepository.findByPhoneno(mobileno); }
	 



	/*
	 * public Employee findByPhoneno(Long mobileno) { // TODO Auto-generated method
	 * stub return employeerepository.findByPhoneno(mobileno); }
	 */


	




}
