package com.sarah.productsandcategories.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sarah.productsandcategories.models.Category;
import com.sarah.productsandcategories.models.Product;
import com.sarah.productsandcategories.services.CategoryService;
import com.sarah.productsandcategories.services.ProductService;

@Controller
public class MainController {
	
	@Autowired
	ProductService productService;
	@Autowired
	CategoryService categoryService;

	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("allProducts", productService.getAll());
		model.addAttribute("allCategories", categoryService.getAll());
		
		return "index.jsp";
	}
	
	@GetMapping("/products/new")
	public String newProduct(Model model) {
		model.addAttribute("newProduct", new Product());
		return "newProduct.jsp";
	}
	
	@PostMapping("/products/save")
	public String saveProduct(@Valid @ModelAttribute("newProduct") Product newProduct, BindingResult result, Model model) {
		
		if(result.hasErrors()) {
			return "newProduct.jsp";
		}
		// if no errors, save product
		productService.save(newProduct);
		
		return "redirect:/";
	}
	
	@GetMapping("/categories/new")
	public String newCategory(Model model) {
		model.addAttribute("newCategory", new Category());
		return "newCategory.jsp";
	}
	
	@PostMapping("/categories/save")
	public String saveCategory(@Valid @ModelAttribute("newCategory") Category newCategory, BindingResult result, Model model) {
		
		if(result.hasErrors()) {
			return "newCategory.jsp";
		}
		// if no errors, save product
		categoryService.save(newCategory);
		
		return "redirect:/";
	}
	
	@GetMapping("/products/{id}")
	public String viewProduct(@PathVariable("id") Long id, Model model) {
		Product product = productService.getById(id);
		model.addAttribute("product", product);
		model.addAttribute("productCategories", productService.getCategoriesByProduct(product));
		model.addAttribute("notCategories", productService.getNotCategories(product));
		return "viewProduct.jsp";
	}
	
	// not using model, because object does not need to be bound
	@PostMapping("/products/{id}/add-category")
	public String addCategory(@PathVariable("id") Long id, @RequestParam(value="categoryId") Long categoryId) {
		Product product = productService.getById(id);
		Category addedCategory = categoryService.getById(categoryId);
		productService.addCategory(product, addedCategory);
		return "redirect:/products/{id}";
	}
}
