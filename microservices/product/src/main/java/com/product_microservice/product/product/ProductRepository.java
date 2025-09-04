package com.product_microservice.product.product;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findByStatus(Boolean status);

    Optional<Product> findByIdAndStatus(Integer id, Boolean status);

    List<Product> findByCategoryIdAndStatus(Integer categoryId, Boolean status);
}
