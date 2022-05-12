package com.sarah.productsandcategories.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sarah.productsandcategories.models.Category;
import com.sarah.productsandcategories.models.Product;
import com.sarah.productsandcategories.repositories.CategoryRepository;
import com.sarah.productsandcategories.repositories.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository productRepo;
	@Autowired
	CategoryRepository categoryRepo;
	
	// get product by ID
	public Product getById(Long id) {
		return productRepo.findById(id).get();
	}
	
	// get all products
	public List<Product> getAll(){
		return productRepo.findAll();
	}
	
	// save product
	public void save(Product product) {
		productRepo.save(product);
	}
	
	// get categories by product
	public List<Category> getCategoriesByProduct(Product product){
		return product.getCategories();
	}
	
	// save a category to product
	public void addCategory(Product product, Category category) {
		// add category to product's list of categories
		product.getCategories().add(category);
		// save product to update category list
		productRepo.save(product);
	}
	
	// retrieve all categories that product does not belong to
	public List<Category> getNotCategories(Product product){
		return categoryRepo.findByProductsNotContains(product);
	}
}
