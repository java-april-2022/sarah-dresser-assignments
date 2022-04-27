package com.example.week4.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.week4.models.Art;
import com.example.week4.services.ArtService;

@Controller
public class NftArtController {

	@Autowired
	private ArtService artService;
	
	@GetMapping("/")
	public String index(Model artModel) {
		List<Art> arts = artService.getAllArts();
		
		artModel.addAttribute("allArts", arts);
		
		return "index.jsp";
	}
}
