package com.ptg.employeeservice.service.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mockitoSession;
import static org.mockito.Mockito.when;

import java.util.Optional;

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
public class SaveEMployeeTest {
	
	@Mock
	private EmployeeRepository repo;
	
	
	@InjectMocks
	private EmployeeserviceImpl service;
	
	
	@Test
	public void saveEmployee() {
		
		Employee lstemp1 = new Employee(1L, "siddhu", 20L, "admin", 8919980109L, "kolkata");
		
		// pre condition
		Mockito.when(service.findById(lstemp1.getEmployeeId())).thenReturn(Optional.empty());
		
		
		//pre condition
		Mockito.when(service.saveEmployee(lstemp1)).thenReturn(lstemp1);
		
		System.out.println(service);
		System.out.println(repo);
		
		 // when -  action or the behaviour that we are going test
		Employee saveemp = service.saveEmployee(lstemp1);
		
		System.out.println(saveemp);
		
		
		  // then - verify the output
		assertThat(saveemp).isNotNull();
		
	}

}
