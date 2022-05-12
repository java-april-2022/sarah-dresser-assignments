package com.sarah.productsandcategories.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sarah.productsandcategories.models.Category;
import com.sarah.productsandcategories.models.Product;
import com.sarah.productsandcategories.repositories.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	CategoryRepository categoryRepo;
	
	// get category by ID
	public Category getById(Long id) {
		return categoryRepo.findById(id).get();
	}
	
	// get all categories
	public List<Category> getAll(){
		return categoryRepo.findAll();
	}
	
	// save category
	public void save(Category category) {
		categoryRepo.save(category);
	}
	
	// get products by category
	public List<Product> getProductsByCategory(Category category){
		return category.getProducts();
	}
	
	// save a product to category
	public void addProduct(Category category, Product product) {
		// add product to category's list of products
		category.getProducts().add(product);
		// save category to update product list
		categoryRepo.save(category);
	}
}
