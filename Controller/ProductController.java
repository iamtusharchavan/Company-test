package com.testnimap.test.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.testnimap.test.Entity.Category;
import com.testnimap.test.Entity.Product;
import com.testnimap.test.Repository.CategoryRepository;
import com.testnimap.test.Repository.ProductRepository;

@RestController
@RequestMapping("products")
public class ProductController {
	
	 @Autowired
	    private ProductRepository productRepository;

	    @Autowired
	    private CategoryRepository categoryRepository;

	   
	    @GetMapping
	    public List<Product> getAllProducts(@RequestParam int page, @RequestParam int size) {
	        return productRepository.findAll(PageRequest.of(page, size)).getContent();
	    }

	 
	    @GetMapping("{id}")
	    public Optional<Product> getProductById(@PathVariable Long id) {
	        return productRepository.findById(id);
	    }

	    
	    @PostMapping
	    public Product createProduct(@RequestBody Product product) {
	        // Ensure the category exists before saving the product
	        Optional<Category> category = categoryRepository.findById(product.getCategory().getCategoryId());
	        if (category.isPresent()) {
	            product.setCategory(category.get());
	            return productRepository.save(product);
	        } else {
	            throw new RuntimeException("Category not found");
	        }
	    }

	   
	    @PutMapping("{id}")
	    public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {
	        product.setProductId(id);
	        // Ensure the category exists before updating the product
	        Optional<Category> category = categoryRepository.findById(product.getCategory().getCategoryId());
	        if (category.isPresent()) {
	            product.setCategory(category.get());
	            return productRepository.save(product);
	        } else {
	            throw new RuntimeException("Category not found");
	        }
	    }

	    
	    @DeleteMapping("{id}")
	    public void deleteProduct(@PathVariable Long id) {
	        productRepository.deleteById(id);
	    }

}
