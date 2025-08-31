package com.test.microservices_customer.customer.exceptions;

import com.exceptions.common_exceptions.ErrorResponse;
import com.exceptions.common_exceptions.GlobalExceptionHandler;

import lombok.extern.slf4j.Slf4j;
import java.util.HashMap;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(basePackages = "com.test.microservices_customer.customer")
@Primary
@Slf4j
public class CustomerNotFoundHandler extends GlobalExceptionHandler {

    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<ErrorResponse> handler(CustomerNotFoundException ex) {

        var errors = new HashMap<String, String>();
        var fieldName = "customer";
        errors.put(fieldName, ex.getMessage());
        log.warn("Customer not found: {}", ex.toString());
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ErrorResponse(errors));
    }
}
