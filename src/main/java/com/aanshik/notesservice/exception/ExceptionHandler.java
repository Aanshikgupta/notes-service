package com.aanshik.notesservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleResourceNotFoundException(ResourceNotFoundException resourceNotFoundException) {
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("message", resourceNotFoundException.getLocalizedMessage());
        errorMap.put("status", "failed");
        return new ResponseEntity<>(errorMap, HttpStatus.BAD_REQUEST);
    }


}
