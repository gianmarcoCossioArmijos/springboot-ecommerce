package com.test.microservices_customer.customer.customer;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CustomerRequest(
        String id,
        @NotNull(message = "firstname is required") @NotBlank(message = "firstname can't be blank") String firstName,
        @NotNull(message = "lastname is required") @NotBlank(message = "lastname can't be blank") String lastName,
        @NotNull(message = "email is required") @NotBlank(message = "email can't be blank") @Email(message = "email should be valid") String email,
        String phone,
        String address,
        String city,
        Boolean status) {

}
