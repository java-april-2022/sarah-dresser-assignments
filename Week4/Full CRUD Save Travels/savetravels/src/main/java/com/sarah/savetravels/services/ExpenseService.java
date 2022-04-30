package com.sarah.savetravels.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sarah.savetravels.models.Expense;
import com.sarah.savetravels.repositories.ExpenseRepository;

@Service
public class ExpenseService {

	@Autowired
	private ExpenseRepository expenseRepo;
	
	// Get all Expenses
	public List<Expense> getAllExpenses(){
		return expenseRepo.findAll();
	}
	
	// Get expense from id
	public Expense getOne(Long id) {
		return expenseRepo.findById(id).orElse(null);
	}
	
	// Create/add new expense -- also saves edit
	public void saveExpense(Expense expense) {
		expenseRepo.save(expense);
	}
//	
//	// Edit response
//	public void update(Expense expense) {
//		expenseRepo.save(expense);
//	}
//	
	// Delete expense
	public void delete(Long id) {
		expenseRepo.deleteById(id);
	}
}
