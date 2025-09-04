package com.product_microservice.product.product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public record ProductRequest(
    Integer id,
    @NotNull(message = "Name can't be null")
    @NotBlank(message = "Name can't be blank")
    String name,
    @NotNull(message = "Description can't be null")
    @NotBlank(message = "Description can't be blank")
    String description,
    @NotNull(message = "Price can't be null")
    @PositiveOrZero(message = "Price must be zero or positive")
    Double price,
    Integer stock,
    Boolean status,
    @NotNull(message = "Category ID can't be null")
    Integer categoryId){
}
