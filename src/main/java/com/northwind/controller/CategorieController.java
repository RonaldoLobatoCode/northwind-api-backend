package com.northwind.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.northwind.entity.Categorie;
import com.northwind.repository.CategorieRepository;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping(path = "categories")
public class CategorieController {

	CategorieRepository categorieRepository;
	
	@GetMapping
	public List<Categorie> findAll(){
		return categorieRepository.findAll();
	}
	
	@GetMapping("{categoryId}")
	public ResponseEntity<Categorie> findById(@PathVariable int categoryId){
		return ResponseEntity.of(categorieRepository.findById(categoryId));
	}
}
