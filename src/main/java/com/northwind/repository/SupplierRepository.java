package com.northwind.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.northwind.entity.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier, Integer>{

}
