package com.sarah.dojosandninjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.sarah.dojosandninjas.models.Dojo;
import com.sarah.dojosandninjas.models.Ninja;
import com.sarah.dojosandninjas.services.DojoService;

@Controller
public class MainController {
	
	@Autowired
	private DojoService dojoService;
	
	@GetMapping("/")
	public String home() {
		return "redirect:/dojos";
	}
	
	@GetMapping("/dojos")
	public String index(Model model) {
		List<Dojo> allDojos = dojoService.getAllDojos();
		model.addAttribute("allDojos", allDojos);
		return "index.jsp";
	}
	
	@GetMapping("/dojos/new")
	public String newDojo(@ModelAttribute("newDojo") Dojo newDojo) {
		return "newDojo.jsp";
	}
	
	@PostMapping("/create-dojo")
	public String addDojo(@Valid @ModelAttribute("newDojo") Dojo newDojo, BindingResult results) {
		if(results.hasErrors()) {
			return "newDojo.jsp";
		} else {
			dojoService.save(newDojo);
			return "redirect:/dojos";
		}
	}
	
	@GetMapping("/ninjas/new")
	public String newNinja(@ModelAttribute("newNinja") Ninja newNinja, Model model) {
		model.addAttribute("allDojos", dojoService.getAllDojos());
		return "newNinja.jsp";
	}
}
