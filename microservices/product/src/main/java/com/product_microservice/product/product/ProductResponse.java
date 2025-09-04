package com.product_microservice.product.product;

public record ProductResponse(
    Integer id,
    String name,
    String description,
    Double price,
    Integer stock,
    Boolean status,
    Integer categoryId,
    String categoryName,
    String categoryDescription) {
}
