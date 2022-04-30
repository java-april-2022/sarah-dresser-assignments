package com.sarah.savetravels.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.sarah.savetravels.models.Expense;
import com.sarah.savetravels.services.ExpenseService;

@Controller
public class ExpenseController {
	
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
		expenseService.saveExpense(newExpense);
		return "redirect:/expenses";
	}
	
	@GetMapping("/expenses/edit/{id}")
	public String edit(@PathVariable("id") Long id, Model model) {
		Expense expense = expenseService.getOne(id);
		model.addAttribute("expense", expense);
		return "edit.jsp";
	}
	
	@PutMapping("/expenses/{id}")
	public String update(@Valid @ModelAttribute("expense") Expense expense, BindingResult result) {
		if(result.hasErrors()) {
			return "edit.jsp";
		} else {
			expenseService.saveExpense(expense);
			return "redirect:/expenses";
		}
	}
	
	@DeleteMapping("/expenses/{id}")
	public String destroy(@PathVariable("id") Long id) {
		expenseService.delete(id);
		return "redirect:/expenses";
	}
}
