package com.product_microservice.product.category;

import jakarta.validation.constraints.NotNull;

public record CategoryRequest(
    Integer id,
    @NotNull(message = "Name can't be null")
    String name,
    String description){
}
