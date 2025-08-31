package com.test.microservices_customer.customer.customer;

import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, String> {

    List<Customer> findByStatus(Boolean status);

    Optional<Customer> findByIdAndStatus(String id, Boolean status);
}
