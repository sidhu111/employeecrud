package com.ptg.employeeservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ptg.employeeservice.entity.Employee;
import com.ptg.employeeservice.exceptions.ResourceNotFoundException;
import com.ptg.employeeservice.repository.EmployeeRepository;
import com.ptg.employeeservice.service.EmployeeserviceImpl;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	// private static final Logger logger =
	// org.slf4j.LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	private EmployeeserviceImpl employeeserviceimpl;

	@Autowired
	EmployeeRepository employeerepository;

	@PostMapping("/addemployee")
	public Employee saveEmployee(@Validated @RequestBody Employee employee) {

		// logger.info("Employee added" , employee);

		return employeeserviceimpl.saveEmployee(employee);

	}

	@GetMapping("/allemployees")
	public List<Employee> getAllEmployees() {
		return employeeserviceimpl.getAllEmployees();

	}

	@GetMapping("/getid/{id}")
	public Optional<Employee> getById(@PathVariable(value = "id") Long employeeId) {
		Optional<Employee> employee = employeeserviceimpl.findById(employeeId);
		if (employee.isPresent()) {
			return employee;
		} else {
			return Optional.empty();
//			return employee
		}
//		return Optional.ofNullable(employeeserviceimpl.findById(employeeId).orElseThrow(
//				() -> new ResourceNotFoundException("Employee Not Found with this EmployeeId" + employeeId)));
	}

	// get values by mobileno
	@GetMapping("/employee/{mobileno}")
	public ResponseEntity<List<Employee>> getByMobileno(@PathVariable Long mobileno) {

		return new ResponseEntity<>(employeeserviceimpl.getByMobileno(mobileno), HttpStatus.OK);

	}

	// update student
	@PutMapping("/{id}")
	public Employee updateEmployee(@RequestBody Employee employee, @PathVariable(value = "id") Long employeeId) {
		// here we are finding the id and save in student object from that object we are
		// updating
		/*
		 * Employee existing
		 * =this.employeeserviceimpl.findById(employeeId).orElseThrow(() -> new
		 * ResourceNotFoundException("employeeId not found  :" + employeeId));
		 * 
		 * existing.setEmployeeName(employee.getEmployeeName());
		 * existing.setAddress(employee.getAddress());
		 * existing.setAge(employee.getAge());
		 * existing.setPosition(employee.getPosition());
		 */

		return this.employeeserviceimpl.saveEmployee(employee);
	}

	/*
	 * @PutMapping("/patients/{patientId}") Patient replacePatient(@RequestBody
	 * Patient newPatient, @PathVariable Long patientId) {
	 * 
	 * return patientInterface.findById(patientId) .map(patient -> {
	 * patient.setPhoneNumber(newPatient.getPhoneNumber()); return
	 * patientInterface.save(patient); }) .orElseGet(() -> {
	 * newPatient.setPatientId(patientId); return patientInterface.save(newPatient);
	 * }); }
	 */

	@DeleteMapping("/{id}")
	public ResponseEntity<Employee> deleteEmployee(@PathVariable("id") Long employeeId) {

		Employee existing = this.employeerepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("employeeId not found :" + employeeId));

		employeerepository.delete(existing);
		return ResponseEntity.ok().build();

	}

}
