package com.sarah.productsandcategories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sarah.productsandcategories.models.Category;
import com.sarah.productsandcategories.models.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

	List<Product> findAll();
	
	// get all products that belong to a category
	List<Product> findAllByCategories(Category category);
	
	/*// maybe don't need this?
	// retrieve a list of products that DO NOT belong to a category
	List<Product> findByCategoriesNotContains(Category category);
	*/
}
