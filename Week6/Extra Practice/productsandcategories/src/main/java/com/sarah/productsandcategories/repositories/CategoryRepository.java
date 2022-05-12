package com.sarah.productsandcategories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sarah.productsandcategories.models.Category;
import com.sarah.productsandcategories.models.Product;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {

	List<Category> findAll();
	
	// derived query to automatically get all categories a product belongs to
	List<Category> findAllByProducts(Product product);
	
	// retrieves a list of categories a product DOES NOT belong to
	List<Category> findByProductsNotContains(Product product);
}
