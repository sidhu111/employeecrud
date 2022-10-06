package com.ptg.employeeservice.service.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.ptg.employeeservice.entity.Employee;
import com.ptg.employeeservice.repository.EmployeeRepository;
import com.ptg.employeeservice.service.EmployeeserviceImpl;

@ExtendWith(MockitoExtension.class)
public class GetEmployeeById {

	@Mock
	private EmployeeRepository emprepo;

	@InjectMocks
	private EmployeeserviceImpl service;

	private Employee employee;

	@BeforeEach
	public void setup() {
		// employeeRepository = Mockito.mock(EmployeeRepository.class);
		// employeeService = new EmployeeServiceImpl(employeeRepository);
		employee = new Employee(1L, "siddhu", 20L, "admin", 8919980109L, "kolkata");
	}

	@Test
	@DisplayName("JUnit test for getEmployeeById method")
	public void getByEmployeeId() {

		// given precondition or setup
		Mockito.when(service.findById(1L)).thenReturn(Optional.of(employee));

		// when action or the behaviour that we are going test
		Employee saveemp = service.findById(employee.getEmployeeId()).get();

		// then condition to check or verify the output
		// passed test case condition

		assertThat(saveemp).isNotNull();

		System.out.println("we are getting the employee" + saveemp);

		// Fail test case

		// then condition to check or verify the output

		/*
		 * assertThat(saveemp).isNull();
		 * System.out.println("we are not getting employee"+ saveemp);
		 */
	}

	@Test
	@DisplayName("JUnit test for getfailEmployeeById method")
	public void getByfailEmployeeId() {

		// given precondition or setup
		Mockito.when(service.findById(1L)).thenReturn(Optional.of(employee));

		// when action or the behaviour that we are going test
		
		Optional<Employee> saveemp = service.findById(1000L);


		// then condition to check or verify the output
		// passed test case condition

		/*
		 * assertThat(saveemp).isNotNull();
		 * 
		 * System.out.println("we are getting the employee"+ saveemp);
		 */

		// Fail test case

		// then condition to check or verify the output

//		  assertTrue(saveemp);
//		assertNull(saveemp);
//		assertTrue(saveemp.toString().contains(""));
		assertNull(saveemp);
		System.out.println("we are not getting employee" + saveemp);

	}

}
