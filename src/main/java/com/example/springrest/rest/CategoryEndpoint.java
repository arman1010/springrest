package com.example.springrest.rest;

import com.example.springrest.model.Category;
import com.example.springrest.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryEndpoint {
    @Autowired
    private CategoryRepository categoryRepository;

    @PostMapping("/category/add")
    public ResponseEntity addCategory(@RequestBody Category category) {
        categoryRepository.save(category);
        return ResponseEntity.ok(category);
    }

    @GetMapping("/categories")
    public ResponseEntity Categories() {
        return ResponseEntity.ok(categoryRepository.findAll());
    }
}
