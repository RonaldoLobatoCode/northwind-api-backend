package com.northwind.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "Employees")
@Data
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employeeid")
	private int employeeId;
	
	@Column(name = "lastname")
	private String lastName;
	
	@Column(name = "firstname")
	private String firstName;
	
	@Column(name = "birthdate")
	private Date birthDate;
	
	@Column(name = "photo")
	private String photo;
	
	@Column(name = "notes")
	private String notes;
}
