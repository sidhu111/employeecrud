package com.ptg.employeeservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ptg.employeeservice.entity.Employee;

@Repository
@EnableJpaRepositories
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	// List<Employee> employee = new ArrayList<>();

//	@Query(value = "SELECT e FROM employee e WHERE e.mobileno=?1",nativeQuery = true) nativequery
	
	
	//@Query(value = "SELECT * FROM employee WHERE mobileno = :mobileno",nativeQuery=true)
	@Query("SELECT e FROM Employee e WHERE e.mobileno = ?1") //jpql
	public List<Employee> findByPhoneno(Long mobileno);

}
