package com.northwind.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.northwind.entity.Shippers;

public interface ShippersRepository extends JpaRepository<Shippers, Integer>{

}
