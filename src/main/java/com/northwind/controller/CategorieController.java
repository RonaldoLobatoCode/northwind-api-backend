package com.northwind.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@PostMapping
	public ResponseEntity<Integer> register(@RequestBody Categorie categorie){
		Categorie save = categorieRepository.save(categorie);
		return ResponseEntity.status(HttpStatus.CREATED).body(save.getCategoryId());
	}
	
	@PutMapping("{categoryId}")
	public ResponseEntity<Categorie> update(@PathVariable int categoryId, @RequestBody Categorie updatedCategory){
		Optional<Categorie> optionalCategorie = categorieRepository.findById(categoryId);
		if(optionalCategorie.isPresent()) {
			Categorie existingCategorie = optionalCategorie.get();
			existingCategorie.setCategoryName(updatedCategory.getCategoryName());
			existingCategorie.setDescription(updatedCategory.getDescription());
			
			Categorie updateCategorieEntity = categorieRepository.save(existingCategorie);
			return ResponseEntity.ok(updateCategorieEntity);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("{categoryId}")
	public void delete(@PathVariable int categoryId) {
		categorieRepository.deleteById(categoryId);
	}
}













