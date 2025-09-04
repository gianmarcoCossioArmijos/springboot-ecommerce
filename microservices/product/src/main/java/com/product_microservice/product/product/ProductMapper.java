package com.product_microservice.product.product;

import org.springframework.stereotype.Service;

import com.product_microservice.product.category.Category;

@Service
public class ProductMapper {

    public Product toProduct(ProductRequest request) {
        return Product.builder()
                .name(request.name())
                .description(request.description())
                .price(request.price())
                .stock(request.stock())
                .status(request.status())
                .category(Category.builder()
                            .id(request.categoryId())
                            .build()
                        )
                .build();
    }

    public ProductResponse toProductResponse(Product product) {
        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getStock(),
                product.getStatus(),
                product.getCategory().getId(),
                product.getCategory().getName(),
                product.getCategory().getDescription());
    }
}
