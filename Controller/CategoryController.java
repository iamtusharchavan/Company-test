package com.testnimap.test.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.testnimap.test.Entity.Category;
import com.testnimap.test.Repository.CategoryRepository;

@RestController
@RequestMapping("categories")
public class CategoryController {

	    @Autowired
	    private CategoryRepository categoryRepository;

	    @GetMapping
	    public List<Category> getAllCategories() {
	        return categoryRepository.findAll();
	    }

	    @GetMapping("{id}")
	    public Optional<Category> getCategoryById(@PathVariable Long id) {
	        return categoryRepository.findById(id);
	    }

	    @PostMapping
	    public Category createCategory(@RequestBody Category category) {
	        return categoryRepository.save(category);
	    }

	    @PutMapping("{id}")
	    public Category updateCategory(@PathVariable Long id, @RequestBody Category category) {
	        category.setCategoryId(id);
	        return categoryRepository.save(category);
	    }
	    
	    @DeleteMapping("{id}")
	    public void deleteCategory(@PathVariable Long id) {
	        categoryRepository.deleteById(id);
	    }
	

}
