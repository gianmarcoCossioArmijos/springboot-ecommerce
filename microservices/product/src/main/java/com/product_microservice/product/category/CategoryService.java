package com.product_microservice.product.category;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository repository;
    private final CategoryMapper mapper;

    public String createCategory(CategoryRequest request) {
        var category = mapper.toCategory(request);
        var savedCategory = repository.save(category);
        return savedCategory.getId().toString();
    }

    public List<CategoryResponse> getAllCategories() {
        return repository
                .findAll()
                .stream()
                .map(mapper::toCategoryResponse)
                .toList();
    }

    public CategoryResponse getCategoryById(Integer id) {
        var category = repository.findById(id)
                                .orElseThrow(() -> new RuntimeException(String.format("Category with id %s not found", id)));
        return mapper.toCategoryResponse(category);
    }

    public CategoryResponse updateCategory(Integer id, CategoryRequest request) {
        Category category = repository.findById(id)
                                .orElseThrow(() -> new RuntimeException(String.format("Category with id %s not found", id)));
        category.setName(request.name());
        category.setDescription(request.description());
        return mapper.toCategoryResponse(repository.save(category));
    }
}
