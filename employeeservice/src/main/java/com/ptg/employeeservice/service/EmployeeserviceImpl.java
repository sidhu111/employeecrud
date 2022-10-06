package com.ptg.employeeservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.ptg.employeeservice.entity.Employee;
import com.ptg.employeeservice.exceptions.ResourceNotFoundException;
import com.ptg.employeeservice.repository.EmployeeRepository;

@Service
public class EmployeeserviceImpl implements  EmployeeInterface{
	
	@Autowired
	EmployeeRepository employeerepository;
	
	

	public Employee saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		
		  Optional<Employee> saveemployee = employeerepository.findById(employee.getEmployeeId());
		  
		  if(saveemployee.isPresent()) {
			  throw new ResourceNotFoundException("Employee already exist with given employeeId:"+ employee.getEmployeeId());
		  }
		
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



	@Override
	public Employee updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		
		Employee existing =this.employeerepository.findById(employee.getEmployeeId()).orElseThrow(() -> new ResourceNotFoundException("employeeId not found  :" + employee.getEmployeeId()));
		
		existing.setEmployeeName(employee.getEmployeeName());
		existing.setAddress(employee.getAddress());
		existing.setAge(employee.getAge());
		existing.setPosition(employee.getPosition());
		
		
		return employeerepository.save(existing);
	}



	@Override
	public void deleteEmployee(Long Id) {
		// TODO Auto-generated method stub

		
		employeerepository.deleteById(Id);
	}
	 



	
	  public List<Employee> findByPhoneno(Long mobileno) {
		  // TODO Auto-generated method stub 
		  
		  return employeerepository.findByPhoneno(mobileno); }
	 


	




}
