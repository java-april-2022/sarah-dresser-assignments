package com.sarah.savetravels.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.sarah.savetravels.models.Expense;
import com.sarah.savetravels.services.ExpenseService;

@Controller
public class TravelsController {
	
	// automatic constructor
	@Autowired
	private ExpenseService expenseService;
	
	@GetMapping("/")
	public String home() {
		return "redirect:/expenses";
	}
	
	@GetMapping("/expenses")
	public String index(Model model, @ModelAttribute("newExpense") Expense newExpense) {
		// Get all Expenses in List
		List<Expense> allExpenses = expenseService.getAllExpenses();
		// Add allExpenses list to model
		model.addAttribute("expenses", allExpenses);
		return "index.jsp";
	}
	
	@PostMapping("/expenses")
	public String createExpense(@Valid @ModelAttribute("newExpense") Expense newExpense, BindingResult results, Model model)
	{
		if(results.hasErrors()) {
			List<Expense> allExpenses = expenseService.getAllExpenses();
			model.addAttribute("expenses", allExpenses);
			return "index.jsp";
		}
		expenseService.createExpense(newExpense);
		return "redirect:/expenses";
	}
}
