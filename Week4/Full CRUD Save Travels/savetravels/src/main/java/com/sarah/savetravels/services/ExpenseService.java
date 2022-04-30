package com.sarah.savetravels.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sarah.savetravels.models.Expense;
import com.sarah.savetravels.repositories.ExpenseRepository;

@Service
public class ExpenseService {

	@Autowired
	private ExpenseRepository travelRepo;
	
	// Get all Expenses
	public List<Expense> getAllExpenses(){
		return travelRepo.findAll();
	}
	
	// Create/add new expense
	public void createExpense(Expense expense) {
		travelRepo.save(expense);
	}
	
	// Delete expense
}
