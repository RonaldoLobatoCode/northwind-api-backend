package com.northwind.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.northwind.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}
