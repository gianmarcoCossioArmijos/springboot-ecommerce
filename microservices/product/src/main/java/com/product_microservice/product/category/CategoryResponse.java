package com.product_microservice.product.category;

import java.util.List;

import com.product_microservice.product.product.ProductResponse;

public record CategoryResponse(
    
    Integer id,
    String name,
    String description,
    List<ProductResponse> products) {
}
