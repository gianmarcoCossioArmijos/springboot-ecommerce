package com.test.microservices_customer.customer.exceptions;

import com.exceptions.common_exceptions.ErrorResponse;
import com.exceptions.common_exceptions.GlobalExceptionHandler;

import java.util.HashMap;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
//import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice(basePackages = "com.test.microservices_customer.customer")
@Primary
// @Slf4j
public class CustomerNotFoundHandler extends GlobalExceptionHandler {

    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<ErrorResponse> handler(CustomerNotFoundException exception) {

        var errors = new HashMap<String, String>();
        var fieldName = "customer";
        errors.put(fieldName, exception.getMessage());

        // log.warn("Customer not found: {}", exception.getMessage());
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ErrorResponse(errors));
    }
}
