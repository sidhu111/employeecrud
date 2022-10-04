package com.ptg.employeeservice.entity;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Employee implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long employeeId;	
	@Column
	private String employeeName;
	@Column
	private Long age;
	@Column
	private String position;
	
	@Column
	private Long mobileno;
	
	@Column
	private String address;
	
	private static final long serialversionUID=1L;
	
	
    public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
    


	public Employee(Long employeeId, String employeeName, Long age, String position, Long mobileno, String address) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.age = age;
		this.position = position;
		this.mobileno = mobileno;
		this.address = address;
	}





	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}


	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}


	public Long getAge() {
		return age;
	}


	public void setAge(Long age) {
		this.age = age;
	}


	public String getPosition() {
		return position;
	}


	public void setPosition(String position) {
		this.position = position;
	}


	public Long getMobileno() {
		return mobileno;
	}


	public void setMobileno(Long mobileno) {
		this.mobileno = mobileno;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}





	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", age=" + age + ", position="
				+ position + ", mobileno=" + mobileno + ", address=" + address + "]";
	}


	
	
	
		
	

}
