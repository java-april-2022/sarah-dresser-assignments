package com.example.week4.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.week4.models.Art;
import com.example.week4.repositories.ArtRepository;

@Service
public class ArtService {

	private ArtRepository artRepo;
	
	// CONSTRUCTOR
	public ArtService(ArtRepository artRepo) {
		super();
		this.artRepo = artRepo;
	}
	
	public List<Art> getAllArts(){
		return artRepo.findAll();
	}
	
	

	
	// Find all arts
	// Create new art
	// Update Art
}
