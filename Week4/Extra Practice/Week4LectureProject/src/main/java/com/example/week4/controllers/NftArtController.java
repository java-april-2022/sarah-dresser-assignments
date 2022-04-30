package com.example.week4.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

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
	
	//Add Art
	@GetMapping("/new")
	public String newArt(@ModelAttribute("newArt") Art newArt) {
		return "new.jsp";
	}
	
	@PostMapping("/create")
	public String createArt(@Valid @ModelAttribute("newArt") Art newArt, BindingResult results) {
		if(results.hasErrors()) {
			return "new.jsp";
		}
		artService.createArt(newArt);
		return "redirect:/";
	}
	
	//Update Art
	@GetMapping("/edit/{id}")
	public String editArt(@PathVariable Long id, Model model) {
		Art editArt = artService.artDetails(id);
		model.addAttribute(editArt);
		return "edit.jsp";
	}
	
	@PutMapping("/update/{id")
	public String updateArt(@ModelAttribute("editArt") Art editedArt @PathVariable Long id) {
		
		artService.updateArt(editedArt);
		return "redirect:/";
	}

}
