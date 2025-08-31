package com.test.microservices_customer.customer.customer;

import com.test.microservices_customer.customer.exceptions.CustomerNotFoundException;

import java.util.List;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository repository;
    private final CustomerMapper mapper;

    public String createCustomer(CustomerRequest request) {
        var customer = mapper.toCustomer(request);
        var savedCustomer = repository.save(customer);
        return savedCustomer.getId();
    }

    public CustomerResponse getCustomerById(String id) {
        var customer = repository.findByIdAndStatus(id, true)
                .orElseThrow(() -> new CustomerNotFoundException(String.format("Customer with id %s not found", id)));
        return mapper.toCustomerResponse(customer);
    }

    public List<CustomerResponse> getAllCustomers() {
        return repository
                .findByStatus(true)
                .stream()
                .map(mapper::toCustomerResponse)
                .toList();
    }

    public Customer updateCustomer(String id, CustomerRequest request) {
        Customer findCustomer = repository.findByIdAndStatus(id, true)
                .orElseThrow(() -> new CustomerNotFoundException(String.format("Customer with id %s not found", id)));
        findCustomer.setFirstName(request.firstName());
        findCustomer.setLastName(request.lastName());
        findCustomer.setEmail(request.email());
        findCustomer.setPhone(request.phone());
        findCustomer.setAddress(request.address());
        findCustomer.setCity(request.city());
        findCustomer.setStatus(request.status());
        return repository.save(findCustomer);
    }

    public String updateCustomerStatus(String id, CustomerRequest request) {
        Customer findCustomer = repository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(String.format("Customer with id %s not found", id)));
        findCustomer.setStatus(request.status());
        repository.save(findCustomer);
        return "Customer status successfully updated";
    }
}
