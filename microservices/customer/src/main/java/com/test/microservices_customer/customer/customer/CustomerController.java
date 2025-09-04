package com.test.microservices_customer.customer.customer;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService service;

    @PostMapping
    public ResponseEntity<String> createCustomer(@Valid @RequestBody CustomerRequest request) {
        return ResponseEntity.ok(service.createCustomer(request));
    }

    @GetMapping
    public ResponseEntity<List<CustomerResponse>> getAllCustomers() {
        return ResponseEntity.ok(service.getAllCustomers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> getCustomerById(@PathVariable("id") String id) {
        return ResponseEntity.ok(service.getCustomerById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerResponse> updateCustomer(@PathVariable("id") String id,
            @Valid @RequestBody CustomerRequest request) {
        return ResponseEntity.ok(service.updateCustomer(id, request));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable("id") String id,
            @RequestBody CustomerRequest request) {
        return ResponseEntity.ok(service.updateCustomerStatus(id, request));
    }
}
