package com.northwind.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.northwind.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
