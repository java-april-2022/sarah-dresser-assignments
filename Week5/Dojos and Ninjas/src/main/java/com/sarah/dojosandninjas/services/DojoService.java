package com.sarah.dojosandninjas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sarah.dojosandninjas.models.Dojo;
import com.sarah.dojosandninjas.repositories.DojoRepository;

@Service
public class DojoService {
	
	@Autowired
	private DojoRepository repo;
	
	// Get all Dojos
	public List<Dojo> getAllDojos(){
		return repo.findAll();
	}
	
	// Get one Dojo by ID
	public Dojo getById(Long id) {
		return repo.findById(id).orElse(null);
	}
	
	// Save or update a dojo
	public void save(Dojo dojo) {
		repo.save(dojo);
	}
}
