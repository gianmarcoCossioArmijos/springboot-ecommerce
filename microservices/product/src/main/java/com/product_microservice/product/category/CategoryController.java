package com.product_microservice.product.category;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/api/v1/categories")
@RestController
public class CategoryController {

    private final CategoryService service;

    @GetMapping
    public ResponseEntity<List<CategoryResponse>> getAllCategories() {
        return ResponseEntity.ok(service.getAllCategories());
    }

    @PostMapping
    public ResponseEntity<String> createCategory(@Valid @RequestBody CategoryRequest request) {
        return ResponseEntity.ok(service.createCategory(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponse> getCategoryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(service.getCategoryById(id));
    }
}
