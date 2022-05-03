package com.sarah.dojosandninjas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.sarah.dojosandninjas.models.Dojo;
import com.sarah.dojosandninjas.models.Ninja;
import com.sarah.dojosandninjas.repositories.NinjaRepository;

@Service
public class NinjaService {
	
	@Autowired
	private NinjaRepository repo;
	
	// Get all Ninjas
		public List<Ninja> getAll(){
			return repo.findAll();
		}
		
		// Get one Ninja by ID
		public Ninja getById(Long id) {
			return repo.findById(id).orElse(null);
		}
		
		// Save or update a dojo
		public void save(Ninja ninja) {
			repo.save(ninja);
		}
}
