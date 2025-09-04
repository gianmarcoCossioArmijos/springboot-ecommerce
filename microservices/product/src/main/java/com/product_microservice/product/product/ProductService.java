package com.product_microservice.product.product;

import java.util.List;

import org.springframework.stereotype.Service;

import com.product_microservice.product.category.CategoryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repository;
    private final ProductMapper mapper;
    private final CategoryRepository categoryRepository;

    public String createProduct(ProductRequest request) {
        var product = mapper.toProduct(request);
        var savedProduct = repository.save(product);
        return savedProduct.getId().toString();
    }

    public List<ProductResponse> getAllProducts() {
        return repository
                .findByStatus(true)
                .stream()
                .map(mapper::toProductResponse)
                .toList();
    }

    public ProductResponse getProductById(Integer id) {
        var product = repository.findByIdAndStatus(id, true)
                                .orElseThrow(() -> new RuntimeException(String.format("Product with id %s not found", id)));
        return mapper.toProductResponse(product);
    }

    public ProductResponse updateProductById(Integer id, ProductRequest request) {
        var product = repository.findByIdAndStatus(id, true)
                                .orElseThrow(() -> new RuntimeException(String.format("Product with id %s not found", id)));
        var category = categoryRepository.findById(request.categoryId())
                                .orElseThrow(() -> new RuntimeException(String.format("Category with id %s not found for product with id %s", request.categoryId(), id)));
        product.setName(request.name());
        product.setDescription(request.description());
        product.setPrice(request.price());
        product.setStock(request.stock());
        product.setCategory(category);
        product.setStatus(request.status());
        return mapper.toProductResponse(repository.save(product));
    }
}
