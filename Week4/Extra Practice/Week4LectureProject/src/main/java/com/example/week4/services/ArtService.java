package com.example.week4.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.week4.models.Art;
import com.example.week4.repositories.ArtRepository;

@Service
public class ArtService {

	// @Autowired performs same as CONSTRUCTOR below
	@Autowired
	private ArtRepository artRepo;
	
//	// CONSTRUCTOR
//	public ArtService(ArtRepository artRepo) {
//		this.artRepo = artRepo;
//	}
	
	// Find all arts
	public List<Art> getAllArts(){
		// Business logic
		return artRepo.findAll();
	}
	
	// Create new art
	// Update Art
	// Delete Art
}
