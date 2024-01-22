package com.northwind.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.northwind.entity.Categorie;

public interface CategorieRepository extends JpaRepository<Categorie, Integer>{

}
