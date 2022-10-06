package com.ptg.employeeservice.service.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mockitoSession;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.ptg.employeeservice.entity.Employee;
import com.ptg.employeeservice.repository.EmployeeRepository;
import com.ptg.employeeservice.service.EmployeeInterface;
import com.ptg.employeeservice.service.EmployeeserviceImpl;


@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTests {

	@Mock
	private EmployeeRepository employeerepository;

	@InjectMocks
	private EmployeeserviceImpl employeeservice;

	// private Employee employee;

	/*
	 * @BeforeEach public void setup() throws Exception{
	 * 
	 * 
	 * MockitoAnnotations.initMocks(this); }
	 */
	/*
	 * @DisplayName("  ") public void testGetEmployee() {
	 * 
	 * Optional<Employee> e1 = Optional.ofNullable(new Employee());
	 * 
	 * e1.setEmployeeId(1L); e1.setEmployeeName("sudharshan");
	 * e1.setAddress("bangalore"); e1.setAge(20L); e1.setMobileno(8919980109L);
	 * e1.setPosition("admin");
	 * 
	 * 
	 * when(employeerepository.findById(anyLong())).thenReturn(e1);
	 * 
	 * }
	 */

	@Test
	@DisplayName("JUnit test for getAllEmployees method")
	public void testgetAllEmployees() {

		List<Employee> lstemp = new ArrayList<>();

		Employee lstemp1 = new Employee(1L, "siddhu", 20L, "admin", 8919980109L, "kolkata");

		Employee lstemp2 = new Employee(2L, "Rajesh", 23L, "admin", 6281366958L, "hyd");

		lstemp.add(lstemp1);
		lstemp.add(lstemp2);

		Mockito.when(employeeservice.getAllEmployees()).thenReturn(lstemp);
		
		System.out.println(employeeservice);
		System.out.println(employeerepository);

		// test
		// when - action or the behaviour that we are going test List<Employee>
		List<Employee> emplst = employeeservice.getAllEmployees();
		
		//System.out.println(emplst);

		assertEquals(2, emplst.size());
		
		//checking empty list was not null because we has lot of data 
		assertNotNull(emplst);
		System.out.println("list was not null"+emplst);
		
	//	we can use isNotNull or assertNotNull both same
	//	assertThat(emplst).isNotNull();		
    //		assertTrue(emplist.con);

		verify(employeerepository, times(1)).findAll();
		
		
		//Failed teast 
		
		assertThat(emplst).isNullOrEmpty();
		System.out.println("list was not null"+emplst);
		
		
		
		
		
	}
	
	

}
