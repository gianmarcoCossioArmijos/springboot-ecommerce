package com.product_microservice.product.product;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
@RestController
public class ProductController {

    private final ProductService service;

    @PostMapping
    public ResponseEntity<String> createProduct(@Valid @RequestBody ProductRequest request) {
        return ResponseEntity.ok(service.createProduct(request));
    }

    @GetMapping
    public ResponseEntity<List<ProductResponse>> getAllProducts() {
        return ResponseEntity.ok(service.getAllProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProduct(Integer id) {
        return ResponseEntity.ok(service.getProductById(id));
    }

    @PostMapping("/{id}")
    public ResponseEntity<ProductResponse> updateProduct(@Valid @RequestBody ProductRequest request, Integer id) {
        return ResponseEntity.ok(service.updateProductById(id, request));
    }
}
