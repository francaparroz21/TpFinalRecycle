package com.project.recycle.exceptions;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ApplicationHandlerException {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Map<String, String>> handleException(ConstraintViolationException ex){
        Map<String, String> map_exceptions = new HashMap<>();
        ex.getConstraintViolations().forEach(error -> {
            if(map_exceptions.size()==0) {
                map_exceptions.put(String.valueOf(error.getPropertyPath()), error.getMessageTemplate());
            }
        });
        return ResponseEntity.badRequest().body(map_exceptions);
    }
}
